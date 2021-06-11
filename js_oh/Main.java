package js_oh;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Hero hero = new Hero("배추", 100);
        SuperHero superHero = new SuperHero("아이언맨", 100);
        
        Hero.MONEY+=40;
        
        Slime slime1 = new Slime("슬라임A", 30);
        Slime slime2 = new Slime("슬라임B", 50);
        
        Cleric cleric = new Cleric("흰배추벌레");
        Cleric cleric2 = new Cleric("흰배추", 100);
        Cleric cleric3 = new Cleric("흰", 70, 30);
        
        Sword fireSword = new Sword("불의 검", 30);
        
        
        hero.attack(slime1);
        slime2.attack(hero);
        
        cleric.setHp(30);
        cleric.selfAid();
        System.out.println();
        cleric2.selfAid();
        System.out.println();
        cleric3.selfAid();

        hero.setSword(fireSword);
        hero.attack(slime1);

        superHero.attack(slime2);
        superHero.fly();
        
        slime1.attack(superHero);
       // slime1.attack(cleric); // 불가... cleric에 대한 메소드가 없엉...
        
        //SuperHero superHero2 = new Hero("헤헤", 50); // 불가.. Hero의 생성자로 superHero를 만들 순 없어...
        Hero superHero3 = new SuperHero("헤헤", 50); // 가능.. 좁은 의미가 생성자를 먹으니까 ...
        
        // Character character = new Character("이름", 10); // 추상클래스... 객체 생성 불가...
        

    }

}
