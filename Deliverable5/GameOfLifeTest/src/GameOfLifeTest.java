import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
  

public class GameOfLifeTest {
	
	//The convertToInt() method before being modified
	public int convertToIntBefore(int x) {
		int c = 0;
		String padding = "0";
		while (c < 1000) {
		    String l = new String("0");
		    padding += l;
		    c++;
		}
		
		String n = padding + String.valueOf(x);
		int q = Integer.parseInt(n);
		return q;
	    }
	
	  //The convertToInt() method after being modified  
     public int convertToIntAfter(int x) {   	
	    	return x;
	        }
	    
	
	//read txt file into an 2d array

	 public static  List  readTxtFile(String filePath) {
        List<String> list = new ArrayList<String>();
        try {
            String encoding = "UTF-8";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    if (!lineTxt.startsWith("#"))
                        list.add(lineTxt);
                }
                read.close();
            } else {
                System.out.println("Cannot find the file");
            }
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return list;
  
    }
	
	
	public static String[][] createArray(String filePath){
        List<String> list = readTxtFile(filePath);
        String array[][] = new String[list.size()][];
        for(int i=0;i<list.size();i++){
            array[i] = new String[3];
            String linetxt=list.get(i);
            String[] myArray = linetxt.replaceAll("\\s+", "@").split("@");
            for(int j=0;j<myArray.length;j++){
                if(j<3){
                    array[i][j]=myArray[j];
                }
            }
        }
        return array;
    }
	
	//input integer 5, proof that the return values 
	//of the convertToInt() method before and after being modifiedare equals .
	@Test
	public void testConvertToInt(){
		try{
			GameOfLifeTest convertTest = new GameOfLifeTest();
			assertEquals(convertTest.convertToIntBefore(5),convertTest.convertToIntAfter(5));		
		}catch(Exception e){
			fail();
		}
	}
	
	//Given same size of world and alive cell
	//test the Write functionality
	//before modifying toString(), get backupBefore.txt file
	//after modifying toString(), get backupAfter.txt file
	//contents in these files shall be same

	@Test
	public void testContentOfTxtFile() {
		try{
			//read backupBefore.txt file into arrayBefore
			String arrayBefore[][] = createArray("backupBefore.txt");
			//read backupBefore.txt file into arrayAfter
			String arrayAfter[][] = createArray("backupAfter.txt");
			assertArrayEquals(arrayAfter,arrayBefore);
		}catch(Exception e){
			fail();
		}
	}
	
	

}
