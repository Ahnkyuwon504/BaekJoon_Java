package js_oh;

public class Wizard extends Character {
    private int mp;
    
    // 추상클래스를 받았으므로, 추상메소드 구현해야 함...
    @Override
    public void attack(Slime slime) {
        
        
    }
    
    public void heal(Hero hero) {
        hero.setHp(hero.getHp() + 10);
    }

}
