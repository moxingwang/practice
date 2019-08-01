package top.moxingwang.springbootfeature;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.moxingwang.springbootfeature.jpa.OrderRepository;
import top.moxingwang.springbootfeature.model.TxOrderEntity;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootFeatureApplicationTests {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private StringEncryptor encryptor;

    @Test
    public void contextLoads() {
    }

    @Test
    public void getPass() {

        Optional<TxOrderEntity> s = orderRepository.findById(1L);
        TxOrderEntity ss = s.get();
        List<TxOrderEntity> list = orderRepository.listOrder(1);
        System.out.println(1);
    }
}
