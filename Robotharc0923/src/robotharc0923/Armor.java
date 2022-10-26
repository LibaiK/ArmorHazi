package robotharc0923;


public class Armor {
 private String helmet;
 private String vest;

    public String getHelmet() {
        return helmet;
    }

    public void setHelmet(String helmet) {
        this.helmet = helmet;
    }

    public String getVest() {
        return vest;
    }

    public void setVest(String vest) {
        this.vest = vest;
    }

    public Armor(String helmet, String vest) {
        this.helmet = helmet;
        this.vest = vest;
    }
 
}
