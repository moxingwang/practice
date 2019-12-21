package top.moxingwang.demo.classloader.testobj;

/**
 * <Description> JVM参数： -server -XX:+UnlockDiagnosticVMOptions -XX:+TraceClassLoading  -XX:+PrintAssembly -XX:+LogCompilation -XX:LogFile=live.log<br>
 *
 * @author Sunny<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2019/01/21 15:37 <br>
 */
public class SimpleInliningTest {
    private int count = 0;

    public static void main(String[] args) throws Exception {
        SimpleInliningTest t = new SimpleInliningTest();
        int sum = 0;
        for (int i = 0; i < 1000000; i++) {
            sum += t.m();
        }
        System.out.println(sum);
    }

    public int m() {
        int i = count;
        i = m2(i);
        i += count;
        i *= count;
        i++;
        return i;
    }

    public int m2(int i) {
        if (i % 10 == 0) {
            i += 1;
        } else if (i % 10 == 1) {
            i += 2;
        } else if (i % 10 == 2) {
            i += 3;
        }
        return i;
    }
}