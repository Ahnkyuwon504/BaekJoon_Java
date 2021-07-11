package js_oh;

// 상속 받으면.. 상속 받은애가 superClass의 생성자를 호출해야함...
public class SuperHero extends Hero {
    private boolean isFly;
   
    public SuperHero (String name, int hp) {
        super(name, hp);
    }
    
    @Override
    public void attack(Slime slime) {
        super.attack(slime);
    }
    
    public void fly() {
        setFly(true);
    }
    
    public void land() {
        setFly(false);
    }

    public boolean isFly() {
        return isFly;
    }

    public void setFly(boolean isFly) {
        this.isFly = isFly;
    }
}
