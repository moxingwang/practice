package top.moxingwang.elasticsearch.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import top.moxingwang.elasticsearch.entity.Book;

public interface BookDao extends ElasticsearchRepository<Book, String> {

}
