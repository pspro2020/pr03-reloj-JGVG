package reloj;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MiReloj(), "Reloj");

        thread.start();
        thread.join(12000);
        thread.interrupt();

        System.out.println("El hilo secundario ya ha terminado de ejecutarse");

    }

    public static class MiReloj implements Runnable {

        private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {

                    System.out.println(LocalDateTime.now().format(dateTimeFormatter));
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }

    }
}


