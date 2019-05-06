import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Menu 
{
private String hero;
private String planet;
private String villain;
private int hero_health,villain_health;
private int hero_attack,villain_attack;


	public Menu() throws ParserConfigurationException, SAXException, IOException, ArrayIndexOutOfBoundsException
	{
		Command_Chooser();
		new Battle(hero_health, hero_attack, villain_health, villain_attack, hero, villain);
	}
	
	public void Command_Chooser() throws ParserConfigurationException, SAXException, IOException 
	{
	
		
				XML_parser liste=new XML_parser();
				liste.Characters_display();
				liste.Planet_display();
				
				
				@SuppressWarnings("resource")
				Scanner keyboard = new Scanner(System.in);
				
				System.out.println("\n Pick a planet:");
				int  planet_nr = keyboard.nextInt();
				
				if(planet_nr<=0 || planet_nr>liste.Planets.size())
				 throw new ArrayIndexOutOfBoundsException("Index Out of Bounds");
		
				System.out.println("You chose the planet : "+liste.Planets.get(planet_nr-1).getName()); 
					// nr-1, because the list starts from 0, and our xml starts from 1
				planet=liste.Planets.get(planet_nr-1).getName();
				 
				System.out.println("Do you want to assemble Avengers?(yes(1)/no(0))");
				int confirmation=keyboard.nextInt();
				
				if(confirmation==1)
				{
				
				boolean exit=true;
				int sum_of_attack=0,sum_of_health=0,nr,nr_heroes=0;
				
					while(exit) 
					{
						
						System.out.print("The heroes: ");
						
						for (Character ch :liste.Characters)
							if(!ch.isVillain())
								System.out.print(ch.getId()+"."+ch.getName()+"  ");
						
						System.out.println("\n Pick a hero (press 0 to assemble Avengers):");
						nr= keyboard.nextInt();
						
						if(nr>liste.Characters.size())
							 throw new ArrayIndexOutOfBoundsException("Index Out of Bounds");
						
						if(nr!=0) {
								sum_of_attack+=liste.Characters.get(nr-1).getAttack();
								sum_of_health+=liste.Characters.get(nr-1).getHealth();
								nr_heroes++;
								  }
						if(nr==0)
							{exit=false;
							break;
							}
						if(liste.Characters.get(nr-1).isVillain())
							 try
						 		{
								 throw new Exception("It must be a hero!");
						 		}
						 	 catch(Exception e) 
						 		{
								 e.printStackTrace();
								 System.exit(1);
						 		}
						
						System.out.println("You chose the hero: "+liste.Characters.get(nr-1).getName());
						
					}
					
				// attack and health modifiers are applied by multiplying with nr of heroes and planet modifier
				hero_attack=sum_of_attack+(liste.Planets.get(planet_nr-1).getHeroAttackModifier()*nr_heroes);
				hero_health=sum_of_health+(liste.Planets.get(planet_nr-1).getHeroHealthModifier()*nr_heroes);
				hero="The Avengers";
				
				System.out.println("The Avengers assembled (attack:"+hero_attack+" health:"+hero_health+").");
				}
				
				else if(confirmation==0){	
					
					for (Character ch :liste.Characters)
						if(!ch.isVillain())
							System.out.print(ch.getId()+"."+ch.getName()+"  ");
					
					System.out.println("\n Pick a hero :");
					int hero_nr = keyboard.nextInt();
			
					if(hero_nr>liste.Characters.size())
						 throw new ArrayIndexOutOfBoundsException("Index Out of Bounds");
				
					if(liste.Characters.get(hero_nr-1).isVillain())
					 try
				 		{
						 throw new Exception("It must be a hero!");
				 		}
					 catch(Exception e) 
				 		{
						 e.printStackTrace();
						 System.exit(1);
						 
				 		}
					else 
					{
						System.out.println("You chose the hero: "+liste.Characters.get(hero_nr-1).getName());
						hero=liste.Characters.get(hero_nr-1).getName();
				 
						hero_attack=liste.Characters.get(hero_nr-1).getAttack()+liste.Planets.get(planet_nr-1).getHeroAttackModifier();
						hero_health=liste.Characters.get(hero_nr-1).getHealth()+liste.Planets.get(planet_nr-1).getHeroHealthModifier();
					}
				}
				
				else if(confirmation!=0 || confirmation!=1) 
					try
		 		{
				 throw new Exception("Invalid answer... Press 1 for Yes and 0 for No.");
			    }
				 catch(Exception e) 
		 			{
					 e.printStackTrace();
					 System.exit(1);
		 			}
						
				 
				for (Character ch :liste.Characters)
					if(ch.isVillain())
						System.out.print(ch.getId()+"."+ch.getName()+"  ");
				
				System.out.println("\n Pick a villain:");
				int villain_nr=keyboard.nextInt();
				
				if(villain_nr>liste.Characters.size())
					 throw new ArrayIndexOutOfBoundsException("Index Out of Bounds");
		
				 if(!(liste.Characters.get(villain_nr-1).isVillain()))
					 try
				 		{
						 throw new Exception("It must be a villain!");
					    }
				 catch(Exception e) 
				 		{
						 e.printStackTrace();
						 System.exit(1);
					 	}
				 else 
				 {
					 System.out.println("You chose the villain: "+liste.Characters.get(villain_nr-1).getName());
				 		
					 villain=liste.Characters.get(villain_nr-1).getName();
					 
					 villain_attack=liste.Characters.get(villain_nr-1).getAttack()
							 +liste.Planets.get(planet_nr-1).getVillainAttackModifier();
					 
					 villain_health=liste.Characters.get(villain_nr-1).getHealth()
							 +liste.Planets.get(planet_nr-1).getVillainHealthModifier();
				 }
				 
				System.out.println(hero+" has "+hero_attack+" attack "+hero_health+" health, "+" "+villain+" has "
				+ villain_attack+" attack "+villain_health+" health,"+" and the fight is happening on planet: "+ planet);
		
	
}
}
