import java.util.Scanner;

public class BattleGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择你的职业：1.战士（生命高）  2.法师（攻击高）");
        int choice = scanner.nextInt();
        Hero hero;
        if (choice == 1) {
            hero = new Hero("阿龙", 200, 15);
        } else {
            hero = new Hero("阿龙", 130, 25);
        }
        Monster monster = new Monster("黑暗龙王", 200, 22);
        System.out.println("× 「" + hero.name + "」挑战「" + monster.name + "」");
        int round = 1;
        while (hero.hp > 0 && monster.hp > 0) {
            System.out.print("第 " + round + " 回合：");
            hero.attackCount++;
            int heroDamage;
            if (hero.attackCount % 3 == 0) {
                heroDamage = hero.heavyHit();
                System.out.print("勇者【重击】造成 " + heroDamage + " 点伤害，");
            } else {
                heroDamage = hero.normalHit();
                System.out.print("勇者普通攻击 造成 " + heroDamage + " 点伤害，");
            }
            monster.hp = monster.hp - heroDamage;
            if (monster.hp < 0) monster.hp = 0;
            System.out.println("怪物 HP " + monster.hp);

            if (monster.hp <= 0) {
                System.out.println("黑暗龙王倒下了......挑战成功");
                break;
            }
            int mDamage = monster.attack();
            hero.hp = hero.hp - mDamage;
            if (hero.hp < 0) hero.hp = 0;
            System.out.println("\t怪物反击 造成 " + mDamage + " 点伤害，勇者 HP " + hero.hp);

            if (hero.hp <= 0) {
                System.out.println("勇者倒下了......挑战失败");
                break;
            }
            round++;
        }
        scanner.close();
    }
}

class Character {
    String name;
    int hp;
    int atk;
}

class Hero extends Character {
    int attackCount = 0;

    public Hero(String name, int hp, int atk) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
    }
    public int normalHit(){
        return this.atk;
    }
    public int heavyHit(){
        return this.atk * 2;
    }
}

class Monster extends Character{
    public Monster(String name, int hp, int atk){
        this.name = name;
        this.hp = hp;
        this.atk = atk;
    }
    public int attack(){
        return this.atk;
    }
    public static void calcDamage(int attack,int defense){

    }
}
