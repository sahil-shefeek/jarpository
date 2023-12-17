class OddThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i += 2)
            System.out.print(i + "  ");
        System.out.println();
    }
}

class EvenThread extends Thread {
    @Override
    public void run() {
        for (int i = 2; i <= 100; i += 2)
            System.out.print(i + "  ");
        System.out.println();
    }
}

public class OddEven {
    public static void main(String[] args) {
        OddThread oddThread = new OddThread();
        EvenThread evenThread = new EvenThread();
        oddThread.start();
        evenThread.start();
    }
}