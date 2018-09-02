package top.moxingwang.demo.multithread.volatiletest;

/**
 * 缓存行的原因
 * 差点思考成傻逼了
 */

/**

 大多数高性能处理器（如UltraSPARC处理器）在慢速内存和CPU的高速寄存器之间插入缓存缓冲区。访问存储器位置使得包含请求的存储器位置的实际存储器（高速缓存行）的片段被复制到高速缓存中。随后对相同内存位置的引用或其周围的引用可能会从缓存中满足，直到系统确定需要保持高速缓存和内存之间的一致性。

 然而，来自不同处理器的同一高速缓存行中的各个元素的同时更新使整个高速缓存行无效，即使这些更新在逻辑上彼此独立。高速缓存行的单个元素的每次更新将该行标记为无效。访问同一行中不同元素的其他处理器会看到标记为无效的行。即使所访问的元素未被修改，它们被迫从内存或其他地方获取更新的该行的副本。这是因为高速缓存一致性在高速缓存行基础上维护，而不是针对单个元素。因此，互连流量和开销会增加。此外，当缓存行更新正在进行时，对行中的元素的访问被禁止。

 这种情况称为虚假共享。如果这种情况发生频繁，OpenMP应用程序的性能和可扩展性将受到严重影响。

 当发生以下所有条件时，虚假共享会降低性能。

 共享数据由多个处理器修改。

 多个处理器更新同一缓存行内的数据。

 这种更新非常频繁（例如，在紧密循环中）。

 请注意，循环中只读的共享数据不会导致虚假共享。

 https://docs.oracle.com/cd/E19205-01/819-5270/aewcy/index.html
 */

public class TestTwo {

    int i = 0;
    volatile int b = 0;

    public void add(){
        System.out.println(i);
        i ++;
        b ++;
    }

    public void testA(){
        while (true){

            //嫌疑点
            System.out.println("b " + b);

            if(i > 0){
                System.out.println("------------------i > 0");
                break;
            }
        }
    }

    public static void main(String[] args) {
        TestTwo testTwo = new TestTwo();
        Thread thread1 = new Thread(() -> {
            testTwo.testA();
        });
        thread1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (testTwo.i < 10000){
            testTwo.add();
        }
    }

}
