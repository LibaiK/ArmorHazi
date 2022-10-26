package robotharc0923;

import java.util.Random;

public abstract class Robot {
    //Property + acces modifier
    protected String Name;
    protected String Color;
    protected Integer MaxHealth;
    protected Integer CurrentHealth;
    protected Integer Damage;
    protected Boolean IsWarrior;
    protected Weapon weapon;
    protected Armor Armor;
    
    //Construct functions

    public Robot(String Name, String Color, Integer MaxHealth, Integer Damage, Boolean IsWarrior,Weapon weapon) {
        this.Name = Name;
        this.Color = Color;
        this.MaxHealth = MaxHealth;
        this.CurrentHealth = MaxHealth;
        this.Damage = Damage;
        this.IsWarrior = IsWarrior;
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return Armor;
    }

    public void setArmor(Armor Armor) {
        this.Armor = Armor;
    }
    
    
    
    //Get functions
    public Boolean getIsWarrior() {
        return IsWarrior;
    }

    public String getName() {
        return Name;
    }

    public String getColor() {
        return Color;
    }

    public Integer getMaxHealth() {
        return MaxHealth;
    }

    public Integer getCurrentHealth() {
        return CurrentHealth;
    }

    public Integer getDamage() {
        return Damage;
    }
    
    
    
    //Set functions
    public void setCurrentHealth(Integer CurrentHealth){
        this.CurrentHealth = CurrentHealth;
    }

    //Custom functions
    public static Boolean Warriors(Robot r1, Robot r2) {
        return r1.IsWarrior && r2.IsWarrior; // false==false
        /*
        true == true -> true
        false == true -> false
        true == false -> false
        false == false -> true
        
        true && true -> true
        false && true -> false
        true && false -> false
        false && false -> false
        */
    }
    
    public static Robot starterRobot(Robot r1, Robot r2){
        //Élet kissebb
        if(r1.getMaxHealth() < r2.getMaxHealth()){
            return r1;
        }
        else if(r1.getMaxHealth() > r2.getMaxHealth()){
            return r2;
        }
        
        //Élet egyenlő és sebzés vizsgálat
        
        else if(r1.getDamage() > r2.getDamage()){
                return r1;
        }
        else if(r1.getDamage() < r2.getDamage()){
                return r2;
        }
        
        //Élet és sebzés azonos, random szám kell.
        else if(Robot.randomGenerator(2).equals(0)){
            return r1;
        }
        else{
            return r2;
        }
    }
    
    public Integer generateDamage(){
//       return Robot.randomGenerator(this.getDamage() + 1);
Integer dmg = Robot.randomGenerator(this.weapon.getMaxDmg()+1);
if(dmg < this.weapon.getMinDmg()){
    dmg = this.weapon.getMinDmg();
}
dmg += this.Damage;
dmg+=this.weapon.getStrength();
return dmg;
    }
    
    
    public static Integer randomGenerator(Integer maximum){ //10 
        Random rand = new Random();
        return rand.nextInt(maximum); //0-9 
    }
    
    public Integer attack(Robot attacked){
        Integer actualDamage = this.generateDamage();
        attacked.setCurrentHealth(attacked.getCurrentHealth()-actualDamage);
        
        //A heal függvény miatt utólag bekerült:
        if(actualDamage.equals(this.getDamage())){
            this.healAttacker();
        }
        
        return actualDamage;
    }
    
    public void healAttacker(){
        //At attack-ban lévő if miatt csak akkor hívódik meg, ha kell healelni magát.
        this.CurrentHealth += 2;
        //this.setCurrentHealth(this.getCurrentHealth() + 2);
        if(this.getMaxHealth() < this.getCurrentHealth()){
            this.setCurrentHealth(this.getMaxHealth());
        }
    }
    
    public static void Fight(Robot r1, Robot r2){
        if(Robot.Warriors(r1, r2)){
            // Mindkét isWarrior true, mehet a harc
            Robot first = Robot.starterRobot(r1, r2);
            Robot second = first.equals(r2)? r1 : r2;
            
            while(true){
                Integer dmg = first.attack(second);
                System.out.println(first.getName() + " attacked " + second.getName() +
                 "! The damage was: " + dmg +", and the new health score is: " + second.getCurrentHealth());
                
                if(second.getCurrentHealth() <= 0){
                    System.out.println("The winner is: "+ first.getName());
                    break;
                }
                
                Integer dmg2 = second.attack(first);
                System.out.println(second.getName() + " attacked " + first.getName() +
                 "! The damage was: " + dmg2 +", and the new health score is: " + first.getCurrentHealth());
                
                if(first.getCurrentHealth() <= 0){
                    System.out.println("The winner is: "+ second.getName());
                    break;
                }
                
            }
        }
        else{
            System.out.println("Ez a két robot nem küzdhet meg egymással!");
        }
    }
    public Integer ArmorAttackRemover(Robot armored){
     Integer armorRemover = this.generateDamage();
     armored.setCurrentHealth(armored.getCurrentHealth()-armorRemover);
     
 return armorRemover;
    }
}
