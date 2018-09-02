package top.moxingwang.demo.dubbo.consumer.contoller;

import top.moxingwang.demo.dubbo.api.IOrderTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: MoXingwang 2018-08-28 20:20
 **/
@RestController
@RequestMapping("index")
public class IndexController {

    @Autowired
    private IOrderTestService orderTestService;

    @GetMapping("order")
    public String getOrder() {
        return orderTestService.getOrder();
    }

}
