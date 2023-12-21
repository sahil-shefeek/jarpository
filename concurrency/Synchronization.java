class Counter {
    synchronized public void count() throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
            Thread.sleep(1000);
        }
        System.out.println("");
    }
}

class CounterThread extends Thread {
    Counter counter;

    CounterThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        try {
            counter.count();
        } catch (InterruptedException e) {
            System.out.print("");
        }
    }
}

class Synchronization {
    public static void main(String z[]) {
        Counter counter = new Counter();
        CounterThread t1 = new CounterThread(counter);
        CounterThread t2 = new CounterThread(counter);
        CounterThread t3 = new CounterThread(counter);
        t1.start();
        t2.start();
        t3.start();
        System.out.println();
    }
}
