

import java.util.InputMismatchException;
import java.util.Random;

abstract class Visitors{	

	private int no;
	private String location;

	
	public Visitors(int no, String location){
		this.setNo(no);
		this.setLocation(location);
	}
	
	public int getNo(){
		return no;
	}
	public String getLocation(){
		return location;
	}
	
	public void setNo(int no){
		//visitor number must among 1-5
		try{
			if(no==1 || no==2 || no==3 || no==4 || no==5)
				this.no = no;
		}catch(Exception e){
			System.out.println("Error");
		}
			
		
	}	
	public void setLocation(String location){
		//locations are The Cathedral of Learning, The Point, Downtown and Squirrel Hill
		try{
			if(location =="The Cathedral of Learning"||location =="The Point"||location =="Downtown"||location=="Squirrel Hill")
				this.location = location;
		}catch(Exception e){
			System.out.println("Error");
		}
		
	}

	
	public abstract String likeLocation();

   
	
}


//Students did like locations except The Cathedral of Learning
class Student extends Visitors{
	
	public Student(int no, String location){
		super(no,location);
	}
	
	public String likeLocation (){
		if(super.getLocation()=="The Cathedral of Learning"){
			return ("Visitor " + super.getNo() + " did not like The Cathedral of Learning.");
		}
		else{
			return ("Visitor " + super.getNo() + " did like " +super.getLocation() + ".");
		}
	}
	
}


//Professor like all locations
class Professor extends Visitors{
	
	public Professor(int no, String location){
		super(no,location);
	}
	
	public String likeLocation (){		
			return "Visitor " + super.getNo() + " did like " + super.getLocation() + ".";		
	}
	
}


//A Business person likes Squirrel Hill and Downtown but did not like The Cathedral of Learning and The Point
class Business extends Visitors{
	
	public Business(int no, String location){
		super(no,location);
	}
	
	public String likeLocation (){
		if(getLocation()=="The Cathedral of Learning"||getLocation()=="The Point"){
			return "Visitor " + super.getNo() + " did not like " + super.getLocation() + ".";
		}
		else{
			return "Visitor " + super.getNo() + " did like " + super.getLocation() + ".";
		}
	}

}


//A blogger dislikes all locations
class Blogger extends Visitors{
	
	public Blogger(int no, String location){
		super(no,location);
	}
	
	public String likeLocation (){	
			return "Visitor " + super.getNo() + " did not like " + super.getLocation() + ".";
		}
	
}





public class CitySim9002 {
	public static void main(String [] args){
		//set input value as the seed
		int seed = 0;
		try{
			if (args.length == 1) {  
		    try{
		    	seed = Integer.parseInt(args[0]);
		    	System.out.println("Welcom to CitySim! You seed is " + seed + ".");
		    }catch(Exception e){
		    	System.out.println("Please enter one argument, seed");   			
	  		    System.exit(0);
		    }
			}else{
				System.out.println("Please enter one argument, seed");   			
	  		    System.exit(0);
		        }
		
		String[] traveler = {"Student","Professor","Business Person","Blogger"};
		String[] region = {"The Cathedral of Learning","Squirrel Hill","The Point","Downtown"};
		
		//Randomly generate a visitor type 
		Random rvisitor = new Random(seed);
		//Randomly generate a location
		Random rlocation = new Random(seed);
		//Randomly generate a status, 0 stands for leaving and 1 stands for visitig
		Random rstatus = new Random(seed);
		Random rplace = new Random(seed);
		Random rselect = new Random(seed);
		
		for(int i = 1; i <= 5; i++){		
			int nxtvisitor = rvisitor.nextInt(4);
			int nxtlocation = rlocation.nextInt(4);
			int nxtstatus = rstatus.nextInt(2);
			
			System.out.println("Visitor " + i + " is a " + traveler[nxtvisitor]);
		    
			going(i,traveler[nxtvisitor],region[nxtlocation]);			
			
			while(nxtstatus!=0){
				
				int nxtplace = rplace.nextInt(4);
				going(i,traveler[nxtvisitor],region[nxtplace]);
				
				int nxtselect = rselect.nextInt(2);
				if(nxtselect==1)
					nxtstatus = 1;
				else
					nxtstatus = 0;
			}
			
	        System.out.println("Visitor " + i + " has left the city" );		
	        System.out.println("***");
	        
		 }
		}catch(InputMismatchException e){
			System.out.println("Please enter one argument, seed");   			
  		    System.exit(0);
		}
       
	}

	public static void going(int m, String visitor, String location){
		
		System.out.println("Visitor " + m + " is going to " + location);
		
		Student stu = new Student(m,location);
		Professor pro = new Professor(m,location);
		Business bus = new Business(m,location);
		Blogger blog = new Blogger(m,location);
		
		if(visitor=="Student"){	   
			System.out.println(stu.likeLocation()); 
			}
			else if(visitor=="Professor"){
			System.out.println (pro.likeLocation());
			}
			else if(visitor=="Business Person"){
			System.out.println (bus.likeLocation());
			}
			else{		
         	System.out.println(blog.likeLocation());				
		}
		
		
	}

}
