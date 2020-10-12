public class ExceptThread extends Thread {
    @Override
    public void run() {
        boolean flag = true;

        if (flag) {
            throw new RuntimeException();
        }

        System.out.println("end of ExceptThread");
    }

    static class Except {
        public static void start() throws InterruptedException {
            new ExceptThread().start();
            Thread.sleep(1000);
            System.out.println("end of main");
        }
    }
}
