public class ReadInventoryThread extends Thread{
    @Override
    public void run() {
        System.out.println("Printing zoo inventory");
    }
    public static void main(String[] args){
        System.out.println("begin");
        (new ReadInventoryThread()).start();
        (new Thread(new PrintData())).start();
        (new ReadInventoryThread()).start();
        System.out.println("end");
    }
}
