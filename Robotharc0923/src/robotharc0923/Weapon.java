
package robotharc0923;


public class Weapon {
    private Integer minDmg;
    private Integer maxDmg;
    private Integer strength;
    private String name;
    

    public Weapon(Integer minDmg, Integer maxDmg,Integer strength, String name) {
        this.minDmg = minDmg;
        this.maxDmg = maxDmg;
        this.strength = strength;
        this.name = name;
        
    }

    public Integer getMinDmg() {
        return minDmg;
    }

    public Integer getMaxDmg() {
        return maxDmg;
    }

    public String getName() {
        return name;
    }

    public Integer getStrength() {
        return strength;
    }
    
    
}
