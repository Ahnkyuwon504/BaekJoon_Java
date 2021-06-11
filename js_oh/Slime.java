package js_oh;

public class Slime {
    private String name;
    private int hp;
    
    public Slime(String name, int hp) {
        super();
        this.name = name;
        this.hp = hp;
    }

    public void attack(Hero hero) {
        System.out.println(name + " 슬라임이 " + hero.getName() + "용사를 공격했다!");
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    
    @Override
    public String toString() {
        return "Slime [name=" + name + ", hp=" + hp + "]";
    }
}
