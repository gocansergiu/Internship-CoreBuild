public class Planet 
{
	 private int id;
     private String name;
     private int heroAttackModifier,heroHealthModifier,villainAttackModifier,villainHealthModifier;
     private String description;
  
 
     public Planet(int id, String name,String description,int heroAttackModifier,
    		 int heroHealthModifier,int villainAttackModifier,int villainHealthModifier) {
         		this.id=id;
         		this.name=name;
         		this.heroAttackModifier=heroAttackModifier;
         		this.heroHealthModifier=heroHealthModifier;
         		this.villainAttackModifier=villainAttackModifier;
         		this.villainHealthModifier=villainHealthModifier;
         		this.description=description;
     }
 
     @Override
     public String toString() {
          return "nr: "+id+"| Name: "+name+ "| Hero's attack modifier: "+ heroAttackModifier+"| Hero's health modifier: "+heroHealthModifier
        		  + "| villain's attack modifier: "+ villainAttackModifier+"| Villain's health modifier: "+ villainHealthModifier
        		  +"| Description: "+description;
}
     
     
     //getters
     public int getId() {
 		return id;
 	}

 	public String getName() {
 		return name;
 	}

 	public int getHeroAttackModifier() {
 		return heroAttackModifier;
 	}

 	public int getHeroHealthModifier() {
 		return heroHealthModifier;
 	}

 	public int getVillainAttackModifier() {
 		return villainAttackModifier;
 	}

 	public int getVillainHealthModifier() {
 		return villainHealthModifier;
 	}

 	public String getDescription() {
 		return description;
 	}
}
