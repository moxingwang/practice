package top.moxingwang.springbootfeature;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.ctrip.framework.apollo.spring.annotation.ApolloJsonValue;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @description:
 * @author: MoXingwang 2019-07-25 14:25
 **/
@Service
public class TestApolloAnnotationBean {
//    @ApolloConfig
//    private Config config; //inject config for namespace application


    @Value("${batch}")
    private int batch;


    @PostConstruct
    public void init() {
        while (true){
            System.out.println(batch);
        }
    }




}
