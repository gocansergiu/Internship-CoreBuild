public class Character 
{
	 private int id;
     private int health,attack;
     private String name;
     private String description;
     private boolean isVillain;
 
     public Character(int id, String name,String description,int attack,int health,boolean isVillain){
        
    	 this.id=id;
         this.name=name;
         this.attack=attack;
         this.health=health;
         this.description=description;
         this.isVillain=isVillain;
     }
 
     @Override
     public String toString() {
          return "nr: "+id+"| Name: "+name+"| Attack: "+attack+"| Health:" +health+"| Villain: "+ isVillain +"| Description: "+ description;
     }
     
     
     //getters
    public boolean isVillain() {
 		return isVillain;
 	}

 	public int getId() {
 		return id;
 	}

 	public String getName() {
 		return name;
 	}

 	public int getHealth() {
 		return health;
 	}

 	public int getAttack() {
 		return attack;
 	}

 	public String getDescription() {
 		return description;
 	}
}
