package top.moxingwang.demo.multithread.volatiletest;


public class CacheVolatileTwo {
    private  long[] i = {0,0,0,0,0,0,0,0};

    public void write() {
        i[0] = 1;
    }

    public long read() {
        while (i[0] == 0) {
//            new String("1");
        }
        return i[0];
    }

    public static void main(String[] args) {
        CacheVolatileTwo cacheVolatile = new CacheVolatileTwo();

        Thread thread = new Thread(() -> {
            cacheVolatile.read();
        });
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 10000; i++)
            cacheVolatile.write();

    }
}
