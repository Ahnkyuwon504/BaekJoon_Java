package js_oh;

// 상속 받자!
public class Hero extends Character {
    public static int MONEY = 100;
    private Sword sword;
    
    public Hero(String name, int hp) {
        setName(name);
        setHp(hp);
        
        this.setName(name);
        this.setHp(hp);
    }
    
    public void attack(Slime slime) {
        if (sword == null) {
            System.out.println(name + " 용사가 " + slime.getName() + " 슬라임을 빠르게 공격했다!");
        } else {
            System.out.println(name + " 용사가 " + sword.getName() + "칼로 " + slime.getName() + " 슬라임을 빠르게 공격했다!");
        }
        
        slime.attack(this);
    }
   

    

    public Sword getSword() {
        return sword;
    }

    public void setSword(Sword sword) {
        this.sword = sword;
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
        return "Hero [name=" + name + ", hp=" + hp + "]";
    }

}
