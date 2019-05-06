import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
 
public class XML_parser 
{
	
	public List<Character> Characters = new ArrayList<Character>();
	public List<Planet> Planets = new ArrayList<Planet>();
	
	
	public XML_parser() throws ParserConfigurationException, SAXException, IOException { 
			XML_parser_characters();
			XML_parser_planets();
	}
	
	
	public void XML_parser_characters() throws ParserConfigurationException, SAXException, IOException 
	{
		 
       
		 
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); //DOM Parser
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("characters.xml");
    
        
       
        NodeList nodeList = document.getElementsByTagName("character");
        
        for (int i = 0; i < nodeList.getLength(); i++)
        {
             Node node = nodeList.item(i);
             
             if (node.getNodeType() == Node.ELEMENT_NODE) 
             {
                  Element elem = (Element) node;

         
                  Integer id = Integer.parseInt(elem.getElementsByTagName("id")
                          .item(0).getChildNodes().item(0).getNodeValue());
              
                  
                  String name = elem.getElementsByTagName("name")
                                      .item(0).getChildNodes().item(0).getNodeValue();

                  
                  Integer	attack =Integer.parseInt(elem.getElementsByTagName("attack")
                		  .item(0).getChildNodes().item(0).getNodeValue());
                  
                  Integer health=Integer.parseInt(elem.getElementsByTagName("health")
                		  .item(0).getChildNodes().item(0).getNodeValue());
                 
                  String description = elem.getElementsByTagName("description")
                          .item(0).getChildNodes().item(0).getNodeValue();
                  Boolean isVillain=Boolean.valueOf(elem.getElementsByTagName("isVillain")
                		  .item(0).getChildNodes().item(0).getNodeValue());

                Characters.add(new Character(id,name,description,attack,health,isVillain));
             }
        }   
   }
	
	
     public void XML_parser_planets() throws ParserConfigurationException, SAXException, IOException {
 
 
          DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
          DocumentBuilder builder = factory.newDocumentBuilder();
 
         
          Document document = builder.parse("planets.xml");
      
     
          NodeList nodeList = document.getElementsByTagName("planet");
          NodeList modifiers_list=document.getElementsByTagName("modifiers"); 
		
		
          
          for (int i = 0; i < nodeList.getLength(); i++) 
          {
               Node node = nodeList.item(i);
               
               if (node.getNodeType() == Node.ELEMENT_NODE) 
               {
                    Element elem = (Element) node;
 
                    Integer id = Integer.parseInt(elem.getElementsByTagName("id")
                            .item(0).getChildNodes().item(0).getNodeValue());
                
                
                    
                    String name = elem.getElementsByTagName("name")
                                        .item(0).getChildNodes().item(0).getNodeValue();
 
                	Node modifiers_node=modifiers_list.item(i);
                	Element emodifier=(Element) modifiers_node;
                	
                    Integer	heroAttackModifier =Integer.parseInt(emodifier.
                    		getElementsByTagName("heroAttackModifier").item(0).getChildNodes().item(0).getNodeValue());
                    
                    Integer heroHealthModifier=Integer.parseInt(emodifier.
                    		getElementsByTagName("heroHealthModifier").item(0).getChildNodes().item(0).getNodeValue());
                    
                    Integer villainAttackModifier=Integer.parseInt(emodifier.
                    		getElementsByTagName("villainAttackModifier").item(0).getChildNodes().item(0).getNodeValue());
                    
                    Integer villainHealthModifier=Integer.parseInt(emodifier.
                    		getElementsByTagName("villainHealthModifier").item(0).getChildNodes().item(0).getNodeValue());
                    		
                 
                    String description = elem.getElementsByTagName("description")
                            .item(0).getChildNodes().item(0).getNodeValue();

 
                    Planets.add(new Planet(id,name,description,heroAttackModifier,heroHealthModifier,
                    		villainAttackModifier,villainHealthModifier));
               }
          }
       
     }
     
     public void Characters_display() {
    	 
    	 System.out.println("\n-----Characters---\n");
    	 
    		for (Character ch :Characters)
                System.out.println(ch.toString());
           	
     }
     
     public void Planet_display() {
    	 
    	 System.out.println("\n-----Planets---\n");
    	 
    		for (Planet plan :Planets)
    			System.out.println(plan.toString());
 	}
 	
}
