
package robotharc0923;

import java.util.Random;


public class Warrior extends Robot{

    public Warrior(String Name, String Color, Integer MaxHealth, Integer Damage, Boolean IsWarrior,Weapon weapon) {
        super(Name, Color, MaxHealth, Damage, IsWarrior,weapon);
    }
    
    //esély kritikus sebzésre (azaz dupla sebzésre)
    @Override
    public Integer attack(Robot attacked){
        Integer actualDamage = this.generateDamage();
        Integer criticalDmg = 0;
        
        Random rand = new Random();
        int generated =  rand.nextInt(10); //0-9 
        
        if(generated == 4){
            criticalDmg = actualDamage*2;
            System.out.println("Kritikus csapás!!!!");
            
        }
        else{
            criticalDmg = actualDamage;
        }
        
        attacked.setCurrentHealth(attacked.getCurrentHealth()-criticalDmg);
        
        //A heal függvény miatt utólag bekerült:
        if(actualDamage.equals(this.getDamage())){
            this.healAttacker();
        }
        
        return criticalDmg;
    }
    
}
