package stock;

public class Main {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Computer computer = new Computer(null, 0, null, null);
        TangibleAsset ta = computer;
        TangibleAsset ta2 = new Computer(null, 0, null, null);
        Thing thing = new Computer(null, 0, null, null);
        Thing thing2 = ta2;

    }
    
    // 이게 다형성이다.

}
