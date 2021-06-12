import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UseOfLock {
    public static void printMessage(Lock lock) {
        try {
            lock.lock();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();

        new Thread(() -> printMessage(lock)).start();
        tryBlockWithoutTimeToWaitAvailableLock(lock);
        tryBlockWithTimeToWaitAvailableLock(lock);
    }

    private static void tryBlockWithoutTimeToWaitAvailableLock(Lock lock){
        if (lock.tryLock()) {
            try {
                System.out.println("Lock obtained, entering protected code");
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("Unable to acquire lock, doing something else");
        }
    }

    private static void tryBlockWithTimeToWaitAvailableLock(Lock lock) throws InterruptedException {
        if (lock.tryLock(10, TimeUnit.SECONDS)) {
            try {
                System.out.println("Lock obtained, entering protected code");
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("Unable to acquire lock, doing something else");
        }
    }
}
