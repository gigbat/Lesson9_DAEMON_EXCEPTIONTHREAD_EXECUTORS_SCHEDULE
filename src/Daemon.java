public class Daemon {
    public static void start() {
        SimpleThread simpleThread = new SimpleThread();
        SimpleThread simpleDaemon = new SimpleThread();

        simpleDaemon.setDaemon(true);

        simpleThread.start();
        simpleDaemon.start();

        System.out.println(Thread.currentThread().getName());
    }

    static class SimpleThread extends Thread {
        @Override
        public void run() {
            try {
                if (isDaemon()) {
                    System.out.println("Старт потока демона.");
                    Thread.sleep(10_000);
                } else {
                    System.out.println("Страт обычного потока.");
                }
            } catch (InterruptedException e) {
                System.err.println(e);
            } finally {
                if (!isDaemon()) {
                    System.out.println("Завершение обычного потока.");
                } else {
                    System.out.println("Завершение потока демона.");
                }
            }
        }
    }
}
