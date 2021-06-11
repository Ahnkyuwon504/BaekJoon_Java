package stock;

// 여긴 Thing 받아도 문제없어.. abstract라서
// 그래도 공통 사항이니까 weight도 여기서 구현하자...
public abstract class TangibleAsset implements Thing {
    private String name;
    private int price;
    private String color;
    protected double weight;
    
    public TangibleAsset(String name, int price, String color) {
        this.name = name;
        this.price = price;
        this.color = color;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    
    @Override
    public double getWeight() {
        // TODO Auto-generated method stub
        return weight;
    }
    
    @Override
    public void setWeight(double weight) {
        // TODO Auto-generated method stub
        this.weight = weight;
        
    }
}
