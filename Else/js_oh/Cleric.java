package js_oh;

public class Cleric {
    // static으로 해야 프로그램 돌리자마자 메모리 차지함...
    // static 없으면 Cleric 생성시마다 얘를 불러야함...
    // 얘넨 static이라 Cleric이랑 아무 관계도 없다...
    private static final int MAX_HP = 50;
    private static final int MAX_MP = 10;
    
    // 얘넨 멤버변수 맞아...
    private String name;
    private int hp = MAX_HP;
    private int mp = MAX_MP;
    
    // 생성자는 당연히 있어야 함.
    public Cleric(String name) {
        this(name, MAX_HP, MAX_MP);
    }
    
    // 생성자는 당연히 있어야 함.
    public Cleric(String name, int hp) {
        this(name, hp, MAX_MP);
    }
    
    // 생성자는 당연히 있어야 함.
    public Cleric(String name, int hp, int mp) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
    }

    // 자가 치료 메소드
    public void selfAid() {
        
        if (mp < 5) {
            return;
        }
        
        mp -= 5;
        hp = MAX_HP;
        System.out.println("성직자 " + name + "의 selfAid 시전 결과 ...");
        System.out.println("성직자 " + name + "의 hp는 " + hp + "가 되었다!");
        System.out.println("성직자 " + name + "의 mp는 " + mp + "가 되었다!");
    }
    
    public void pray(int sec) {
        
        mp = Math.min(mp + sec, MAX_MP);
        
    }
    
    // Getter/Setter는 당연히 있어야함.
    // static껀 필요없엉
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
    public int getMp() {
        return mp;
    }
    public void setMp(int mp) {
        this.mp = mp;
    }
    
    // ToString도 있어야해...
    @Override
    public String toString() {
        return "Cleric [name=" + name + ", hp=" + hp + ", mp=" + mp + "]";
    }
    
    

    
}
