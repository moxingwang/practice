package top.moxingwang.demo.proyx.aspectj;

public aspect HelloAspect {
    pointcut HelloWorldPointCut() : execution(* HelloWorld.main(..));



    before() : HelloWorldPointCut(){
        System.out.println("Hello world");
    }
}
