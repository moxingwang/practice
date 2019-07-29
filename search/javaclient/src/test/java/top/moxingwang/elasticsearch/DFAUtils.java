package top.moxingwang.elasticsearch;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/**
 * @description:
 * @author: MoXingwang 2019-07-29 13:00
 **/
public class DFAUtils {
    /**
     * 添加敏感词到算法树
     */
    public static void addSensitiveWord(String sensitiveWord) {
        if (null == sensitiveWord || sensitiveWord.length() == 0) {
            return;
        }
        char[] chars = sensitiveWord.toCharArray();
        Map<Character, Map> parentMap = sensitiveWordsMap;
        Map<Character, Map> current = null;
        synchronized (lock) {
            for (int i = 0; i < chars.length; i++) {
                if (i == 0) {
                    if (sensitiveWordsMap.size() == 0) {
                        /* 添加第一个敏感词的第一个字符执行此code */
                        if (chars.length == 1) {
                            Map<Character, Map> endMap = new HashMap<>(1);
                            endMap.put(null, null);
                            sensitiveWordsMap.put(chars[0], endMap);
                        } else {
                            sensitiveWordsMap.put(chars[0], null);
                        }
                    } else {
                        current = parentMap.get(chars[0]);
                        if (null == current) {
                            if (chars.length == 1) {
                                Map<Character, Map> endMap = new HashMap<>(1);
                                endMap.put(null, null);
                                sensitiveWordsMap.put(chars[0], endMap);
                                break;
                            } else {
                                sensitiveWordsMap.put(chars[0], null);
                            }
                        } else {
                            if (chars.length == 1) {
                                current.put(null, null);
                                break;
                            }
                        }
                    }
                } else {
                    if (null == current) {
                        Map<Character, Map> childMap = new HashMap<Character, Map>();
                        if (i == chars.length - 1) {
                            Map<Character, Map> endMap = new HashMap<>(1);
                            endMap.put(null, null);
                            childMap.put(chars[i], endMap);
                            parentMap.put(chars[i - 1], childMap);
                            break;
                        } else {
                            childMap.put(chars[i], null);
                            parentMap.put(chars[i - 1], childMap);
                            parentMap = childMap;
                            current = null;
                        }
                    } else {
                        Map<Character, Map> childMap = current.get(chars[i]);
                        if (null == childMap) {
                            if (i == chars.length - 1) {
                                Map<Character, Map> endMap = new HashMap<>(1);
                                endMap.put(null, null);
                                current.put(chars[i], endMap);
                            } else {
                                current.put(chars[i], null);
                                parentMap = current;
                                current = null;
                            }
                        } else {
                            if (i == chars.length - 1) {
                                childMap.put(null, null);
                            } else {
                                parentMap = current;
                                current = childMap;
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 检查敏感词(找到符合敏感词则返回--单个字符敏感词前后不是中文字符才算敏感词)
     */
    public static String checkSensitiveWord(String content) {
        if (null == content || content.length() == 0 || sensitiveWordsMap.size() == 0) {
            return null;
        }
        char[] chars = content.toCharArray();
        boolean isContain = Boolean.FALSE;
        StringBuilder sbResult = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (sensitiveWordsMap.containsKey(chars[i])) {
                Map<Character, Map> currentMap = sensitiveWordsMap.get(chars[i]);
                sbResult.append(chars[i]);
                if (null == currentMap) {
                    break;
                } else {
                    if (currentMap.containsKey(null)) {
                        if (sbResult.length() == 1) {
                            /* 前一个字符或后一个字符是否是中文字符 */
                            boolean before = Boolean.FALSE;
                            if (i - 1 < 0) {
                                before = Boolean.TRUE;
                            } else {
                                if (chars[i - 1] < 13312 || chars[i - 1] > 40895) {
                                    before = Boolean.TRUE;
                                }
                            }
                            boolean after = Boolean.FALSE;
                            if (i + 1 >= chars.length) {
                                after = Boolean.TRUE;
                            } else {
                                if (chars[i + 1] < 13312 || chars[i + 1] > 40895) {
                                    after = Boolean.TRUE;
                                }
                            }
                            if (before && after) {
                                isContain = Boolean.TRUE;
                                break;
                            }
                            /* From当前index开始匹配是否存在敏感词 */
                            int j = i + 1;
                            for (; j < chars.length; j++) {
                                if (currentMap.containsKey(chars[j])) {
                                    sbResult.append(chars[j]);
                                    currentMap = currentMap.get(chars[j]);
                                    if (currentMap.containsKey(null)) {
                                        isContain = Boolean.TRUE;
                                        break;
                                    } else {
                                        continue;
                                    }
                                } else {
                                    break;
                                }
                            }
                        } else {
                            isContain = Boolean.TRUE;
                            break;
                        }
                    } else {
                        /* From当前index开始匹配是否存在敏感词 */
                        int j = i + 1;
                        for (; j < chars.length; j++) {
                            if (currentMap.containsKey(chars[j])) {
                                sbResult.append(chars[j]);
                                currentMap = currentMap.get(chars[j]);
                                if (currentMap.containsKey(null)) {
                                    isContain = Boolean.TRUE;
                                    break;
                                } else {
                                    continue;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    if (isContain) {
                        break;
                    } else {
                        sbResult.setLength(0);
                    }
                }
            }
        }

        if (isContain) {
            return sbResult.toString();
        } else {
            return null;
        }
    }

    /**
     * 删除算法树的敏感词
     */
    public static void delSensitiveWord(String sensitiveWord) {
        if (null == sensitiveWord || sensitiveWord.length() == 0 || sensitiveWordsMap.size() == 0) {
            return;
        }
        int delIndex = 0;
        char[] chars = sensitiveWord.toCharArray();
        Map<Character, Map> current = sensitiveWordsMap;
        synchronized (lock) {
            int i = 0;
            for (; i < chars.length; i++) {
                if (current.containsKey(chars[i])) {
                    if (current.get(chars[i]).size() > 1) {
                        delIndex = i;
                    }

                } else {
                    break;
                }
                current = current.get(chars[i]);
            }
            if (!current.containsKey(null)) {
                return;
            }
            current = sensitiveWordsMap;
            if (i == chars.length) {
                for (i = 0; i < delIndex; i++) {
                    current = current.get(chars[i]);
                }
                if (i == chars.length) {
                    current.remove(chars[i]);
                } else {
                    if (i == 0 && chars.length == 1) {
                        if (current.get(chars[i]).size() == 1) {
                            current.remove(chars[i]);
                        } else {
                            current.get(chars[i]).remove(null);
                        }
                    } else {
                        if (i + 1 == chars.length) {
                            current.get(chars[i]).remove(null);
                        } else {
                            current.get(chars[i]).remove(chars[i + 1]);
                        }
                    }
                }
            }
        }
    }

    /**
     * 获取算法树的敏感词
     */
    public static LinkedList<String> getSevsitiveWords() {
        LinkedList<String> listWords = new LinkedList<String>();
        if (sensitiveWordsMap.size() == 0) {
            return listWords;
        }
        StringBuilder sbWord = new StringBuilder();
        getSevsitiveWords(sensitiveWordsMap, listWords, sbWord);
        return listWords;
    }

    /**
     * 算法树是否包含对应的敏感词
     */
    public static boolean containSensitiveWord(String sensitiveWord) {
        if (null == sensitiveWord || sensitiveWord.length() == 0 || sensitiveWordsMap.size() == 0) {
            return false;
        }
        return sensitiveWord.equals(checkSensitiveWord(sensitiveWord));
    }

    /**
     * 清空算法树
     */
    public static void clearSensitiveWord() {
        synchronized (lock) {
            sensitiveWordsMap = new HashMap<Character, Map>();
        }
    }


    /**
     * 递归获取算法树的敏感词
     */
    private static void getSevsitiveWords(Map<Character, Map> childMap, LinkedList<String> listWords,
                                          StringBuilder sbWord) {
        if (childMap.size() == 1 && childMap.containsKey(null)) {
            listWords.add(sbWord.toString());
            sbWord.setLength(sbWord.length() - 1);
            return;
        }
        for (Map.Entry<Character, Map> entry : childMap.entrySet()) {
            Character keyChar = entry.getKey();
            Map<Character, Map> valueMap = entry.getValue();
            if (null == keyChar) {
                continue;
            }
            sbWord.append(keyChar);
            if (valueMap.containsKey(null)) {
                listWords.add(sbWord.toString());
                if (valueMap.size() == 1) {
                    sbWord.setLength(sbWord.length() - 1);
                } else {
                    getSevsitiveWords(valueMap, listWords, sbWord);
                    sbWord.setLength(sbWord.length() - 1);
                }
            } else {
                getSevsitiveWords(valueMap, listWords, sbWord);
                sbWord.setLength(sbWord.length() - 1);
            }
        }
    }

    private final static Object lock = new Object();
    private static Map<Character, Map> sensitiveWordsMap = new HashMap<Character, Map>();
}
