package js_oh;

public abstract class Character {
    // private으로 하면 상속받아도 안 보여: getter/setter로 접근 해야 해...
    // protected로 하면 getter/setter 없어도 접근 가능...
    protected String name;
    protected int hp;
    
    // 추상 메소드를 하나라도 가지고 있으면 이는 추상클래스가 된다...
    public abstract void attack(Slime slime);
    
    // 일반 메소드 있어도 괜찮아
    public void run() {
        System.out.println("뛰다");
    }

}
