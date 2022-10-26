
package robotharc0923;

import java.util.Random;


public class Healer extends Robot {

    public Healer(String Name, String Color, Integer MaxHealth, Integer Damage, Boolean IsWarrior,Weapon weapon) {
        super(Name, Color, MaxHealth, Damage, IsWarrior,weapon);
    }
    //5% esélyel a támadás végén a sebzéstől függetlenül +3 életerőt visszatölt magának
    @Override
    public void setCurrentHealth(Integer CurrentHealth) {
        Random rand = new Random();
        int r = rand.nextInt(20);
        if(r == 3 && CurrentHealth > 0){
            CurrentHealth += 3;
            if(CurrentHealth <= this.getMaxHealth()){
                super.setCurrentHealth(CurrentHealth);
            }else{
                super.setCurrentHealth(this.getMaxHealth());
            }
            System.out.println(this.getName() + " sérülés után gyógyult");
        }else{
            super.setCurrentHealth(CurrentHealth);
        }
    }
}
