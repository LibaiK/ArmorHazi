
package robotharc0923;


public class Robotharc0923 {

  
    public static void main(String[] args) {
        Weapon sword = new Weapon(4,7,1,"BF. Sword");
        Weapon sword2 = new Weapon(2,5,0,"Small sword");
        Robot r1 = new Ninja("Robi","kek",30,6,true,sword);
        Robot r2 = new Warrior("Peti","zold",28,6,true,sword2);
        Robot.Fight(r1, r2);
    }
    
}
