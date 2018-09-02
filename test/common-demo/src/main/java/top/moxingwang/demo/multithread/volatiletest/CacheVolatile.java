package top.moxingwang.demo.multithread.volatiletest;

public class CacheVolatile {
    private volatile int i = 0;

    public void write() {
        i++;
    }

    public int read() {
        while (i == 0) {

        }
        return i;
    }

    public static void main(String[] args) {
        CacheVolatile cacheVolatile = new CacheVolatile();

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
