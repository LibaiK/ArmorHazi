
package robotharc0923;

import java.util.Random;


public class Ninja extends Robot {

    public Ninja(String Name, String Color, Integer MaxHealth, Integer Damage, Boolean IsWarrior,Weapon weapon) {
        super(Name, Color, MaxHealth, Damage, IsWarrior,weapon);
    }
    //10% esélyel kitér a támadás elől,azaz nem éri sebzés
    @Override
    public void setCurrentHealth(Integer CurrentHealth) {
        Random rand = new Random();
        int r = rand.nextInt(10);
        if(r == 1){
            System.out.println(this.getName() + " Kitért a támadás elől");
        }else{
            super.setCurrentHealth(CurrentHealth);
        }

    }
}
