* [Elasticsearch－基础介绍及索引原理分析](https://www.cnblogs.com/dreamroute/p/8484457.html)
   - mapping
       * [elasticsearch 之mapping](https://my.oschina.net/davidzhang/blog/811511)
       
# 创建索引

PUT /my_index/type
```aidl

```

* index
```aidl
analyzed:默认选项，以标准的全文索引方式，分析字符串，完成索引。
not_analyzed:精确索引，不对字符串做分析，直接索引字段数据的精确内容。
no：不索引该字段。
```

* QueryBuilders.matchQuery 适用于分词（analyzed）
* QueryBuilders.termQuery 适用于精确索引（not_analyzed）
* QueryBuilders.wildcardQuery 适用于精确索引（not_analyzed）