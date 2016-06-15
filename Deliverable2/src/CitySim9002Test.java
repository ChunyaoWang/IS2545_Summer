


import static org.junit.Assert.*;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CitySim9002Test {
	
	
	//check setNo() and setLocation() 
	//Double an object to calls setNo() and setLocation() methods
	//verify that these two actions have happened
	@Test
	public void testVisitorSet(){
		Visitors mockvisitor = mock(Visitors.class);
		
		mockvisitor.setNo(1);
		mockvisitor.setLocation("Downtown");
		
		verify(mockvisitor).setNo(1);
		verify(mockvisitor).setLocation("Downtown");		
		
	}
	
	
	
    //Check methods getNo() and getLocation()
	//Double a new object without initializing;
	//getNo() will return 0 and getLocation will return Null
	@Test
	public void testVisitorsGetNo(){
		Visitors mockvisitor = mock(Visitors.class);
		
	    assertEquals(0,mockvisitor.getNo());
	    assertNull(mockvisitor.getLocation());
	}
	
	
	
	//Any locations except The Cathedral of Learning, The Point, Squirrel Hill and Downtown should not be accepted
	//Initializing object student with arguments visitor number 1 and location "IS Building"
	//"IS Building" cannot be assigned to object student.	
	@Test
	public void testStudent01(){
		Student student = new Student(1,"IS Building");
		
		assertFalse(student.getLocation()=="IS Building");
	}
	
	
	
	//Student did not like The Cathedral of Learning.
	//Initializing object student with visitor number 1 and location "The Cathedral of Learning",
	//Object calls method likeLocation()
    //It is true that student did not like the Cathedral of Learning.
	@Test
	public void testStudent02(){
		Student student = new Student(1,"The Cathedral of Learning");
		
		assertEquals("Visitor 1 did not like The Cathedral of Learning.",student.likeLocation());
	}
		
	
	
	//Professor did like location "The Point".
	//Creating a new object mockvis
	//When object calls methods getNo() and getLocation() to return visitor number as 2 and location as The Point,
	//Initializing an object pro from class Professor with mockvis.getNo() as visitor number and mockvis.getLocation() as location
	//The result of pro calling method likeLocation() equals to the context "Visitor 2 did like The Point"
	@Test
	public void testProfessor01(){
		Visitors mockvis = mock(Visitors.class);
		
		when(mockvis.getNo()).thenReturn(2);
		when(mockvis.getLocation()).thenReturn("The Point");
		
		Professor pro = new Professor(mockvis.getNo(),mockvis.getLocation());
		
		assertEquals("Visitor 2 did like The Point.",pro.likeLocation());
	}
	
	
	
	//Visitor number must be among number 1-5
	//Initializing object pro from class Professor with visitor number 8 and location "Squirrel Hill".
	//Visitor number cannot be 8
	@Test 
	public void testProfessor02(){
		Professor pro = new Professor(8,"Squirrel Hill");
		assertFalse(pro.getNo()==8);
		assertTrue(pro.getLocation()=="Squirrel Hill");
	}
	
	
	
	//Name of location must be correct
	//Initializing object pro01 with visitor number 2 and location DownTown
	//Initializing object pro02 with visitor number 2 and location Downtown
	//DownTown is not the same as Downtown
	@Test 
	public void testProfessor03(){
		Professor pro01 = new Professor(2,"DownTown");
		Professor pro02	= new Professor(2,"Downtown");	
		
		assertFalse(pro01.getLocation()=="DownTown");
		assertTrue(pro02.getLocation()=="Downtown");
		assertNotEquals(pro01.getLocation(),pro02.getLocation());
	}
	
	
	
	//A business person did like Squirrel Hill
	//Initializing object business with visitor number 3 and location Squirrel Hill
	//It returns 3 and Squirrel Hill when calling method getNo() and getLocation().
	//Visitor 3 did like Squirrel Hill
	@Test
	public void testBusiness01(){
		Business business = new Business(3,"Squirrel Hill");
		
		assertTrue(business.getNo()==3);
		assertTrue(business.getLocation()=="Squirrel Hill");
		assertEquals("Visitor 3 did like Squirrel Hill.",business.likeLocation());
	}
	
	
	
	//Check geNo() and getLocation() method can return exact context
	//Fake object mockBusiness and methods getNo() to be 1 and method getLocation() to be "The Point"
	//Stubbed methods work.
	@Test
	public void testBusiness02(){
		Business mockBusiness = mock(Business.class);
		
		when(mockBusiness.getNo()).thenReturn(1);
		when(mockBusiness.getLocation()).thenReturn("The Point");
		
		String val = "Visitor "+mockBusiness.getNo()+ " did not like " + mockBusiness.getLocation() +".";
		
		assertEquals("Visitor 1 did not like The Point.",val);				
	}
	
	
	
	//Check geNo() and getLocation() method can return exact context
	//Fake object mockBusiness and methods getNo() to be 4 and method getLocation() to be "The Point"
	//Object calls method likeLocation()
	//Stubbed methods work.
		@Test
		public void testBusiness03(){
			Business mockBusiness = mock(Business.class);
			
			when(mockBusiness.getNo()).thenReturn(4);
			when(mockBusiness.getLocation()).thenReturn("The Point");
			
			String val = "Visitor "+mockBusiness.getNo()+ " did not like " + mockBusiness.getLocation() +".";
			Business bus = new Business(4,"The Point");
			assertEquals(val,bus.likeLocation());				
		}
	
	
	
	//check that method likeLocaiton() works.
	//Creating object mockBlogger
	//MockBlogger calls method likeLocation()
	//verify this method works
	@Test
	public void testBlogger01(){
		Blogger mockBlogger = mock(Blogger.class);
		
		mockBlogger.likeLocation();
		
		verify(mockBlogger).likeLocation();		
	}
	
	
	
	//Professor did like location "The Point".
	//Creating an object mockvis,
	//Set methods getNo() and getLocation() as 5 and "The Point",
	//Initializing an object blog with mockvis.getNo() as visitor number and mockvis.getLocation() as location		
	//The result of calling likeLocation() is "Visitor 5 did like The Point"
	@Test
	public void testBlogger02(){
		Visitors mockvis = mock(Visitors.class);
		
		when(mockvis.getNo()).thenReturn(5);
		when(mockvis.getLocation()).thenReturn("The Point");
		
		Blogger blog = new Blogger(mockvis.getNo(),mockvis.getLocation());
		
		assertEquals("Visitor 5 did not like The Point.",blog.likeLocation());
	}
	


}
