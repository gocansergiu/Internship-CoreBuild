import java.util.Random;

public class Battle 
{
private boolean playing=true;

public Battle(int hero_health,int hero_damage,int villain_health,int villain_damage,String hero,String villain)
{
	fight( hero_health,hero_damage, villain_health, villain_damage, hero, villain);
}


public void checkHealth(int hero_health,int villain_health,String hero,String villain)
{

	if(villain_health<=0)
	{
        playing = false;
        System.out.println(hero +" wins!" );
    }
	
	if(hero_health <= 0)
	{
        playing = false;
        System.out.println(villain +" wins!" );   
    } 
	
}


private int random_damage(int damage) 
{
	 Random rand=new Random();
	 return  (int) (damage*0.01*(100-rand.nextInt(40)));
}


public void fight(int hero_health,int hero_damage,int villain_health,int villain_damage,String hero,String villain ) 
{

	while(playing) 
	{
		 int v_dmg=random_damage(villain_damage);
		 hero_health-=v_dmg;
		
		 System.out.println(villain+" hits for: "+ v_dmg+" hero's health is now :"+ hero_health);
		 checkHealth(hero_health,villain_health,hero,villain);
		
		 if(!playing)
			 break;
		
		 int h_dmg=random_damage(hero_damage);
		 villain_health-=h_dmg;
		
		 System.out.println(hero+" hits for: "+ h_dmg+" villain's health is now :"+ villain_health);
		 checkHealth(hero_health,villain_health,hero,villain);
		
		
		
	}

	
}
}
