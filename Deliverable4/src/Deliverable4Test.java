import static org.junit.Assert.*;
import java.util.Random;
import org.junit.Test;


public class Deliverable4Test {
	int seed = 9;
	//generate 100 length
	Random randomLength = new Random(seed);	
	int [] resultLength = produceArrayLength(randomLength);
	//generate 100 random arrays
	Random arrayElement = new Random(seed);
	int [][] resultElement = produceArrayElement(resultLength,arrayElement);
	
	//this method is applied to generate 100 numbers used as 100 lengths for 100 arrays
	//so these 100 numbers must be unique and the range is between 1 and 100 (inclusive)
	public static int [] produceArrayLength(Random randomLength){			
			int [] arr = new int[100];
			//record the number of random number that has been generated
			int count = 0;			
			while(count<100){
			    int arrLength = randomLength.nextInt(100)+1;
				boolean flag = true;
				for(int i=0; i<count; i++){
					if(arrLength == arr[i]){
						flag = false;
						break;
					}
				}
				if(flag){
					arr[count] = arrLength;
					count++;
				}				
			}
			return arr;
	}
	
	//this method is applied to generate 100 random arrays
	public static int[][] produceArrayElement(int[] resultLength,Random arrayElement){		
			int [][] randomArray = new int[100][100];
			for(int i=0; i<100; i++){
				int elementNum = resultLength[i];
				for(int j=0; j<elementNum; j++){	
					int arrElement = arrayElement.nextInt(100)+1;	
					//each column of randomArray represents one random array 
					randomArray[i][j] = arrElement;
						}
					}
			return randomArray;				
	}
	
	
	
	//the length of the output array after calling method billify shall be
	//equal to the sum of the length of input array and one	
	// length(output array)=length(input array)+1
	@Test
	public void testOutPutArrayLength() {
		try{	
			
			//generate input array
			for(int i=0; i<100; i++){				
				int elementNum = resultLength[i];
				int [] testArray = new int[elementNum];
				for(int j=0; j<elementNum; j++){
				    int element = resultElement[i][j];
				    testArray[j] = element;
				}	
				
			Deliverable4 testcase = new Deliverable4();	
			int observedArray[]=testcase.billify(testArray);
			//length of input array
			int inputArrayLength = testArray.length;
			//length of output array
			int outputArrayLength = observedArray.length;
			assertTrue((inputArrayLength+1)==outputArrayLength);
			}
		}catch(Exception e){
			fail();
		}
		
	}
	
	
	
	//since the last element in the output array is the sum of squares of previous elements
	//so the last element in output array shall be the maximum	
	@Test
	public void testIndexofMaxValue(){
		try{	
			
			//generate the input array
			for(int i=0; i<100; i++){				
				int elementNum = resultLength[i];
				int [] testArray = new int[elementNum];
				for(int j=0; j<elementNum; j++){
				    int element = resultElement[i][j];
				    testArray[j] = element;
				}	
				
			Deliverable4 testcase = new Deliverable4();	
			int observedArray[]=testcase.billify(testArray);
			int outputArrayLength = observedArray.length;
			int maxValue = observedArray[0];
			// the index of the maximum
			int dexMaxValue = 0;
			for(int ele=0; ele<outputArrayLength; ele++){
				if(observedArray[ele]>maxValue)
					maxValue = observedArray[ele];
					dexMaxValue = ele;				
			}
			assertTrue(dexMaxValue==(outputArrayLength-1));
			}
		}catch(Exception e){
			fail();
		}
	}

	
	//according to method billify, given the same index
	//the elements of the output array is the square of 
	//the elements of the input array (except the last element of the output array) 	
	@Test
	public void testElements(){
		try{	
			
			//generate the input array
			for(int i=0; i<100; i++){				
				int elementNum = resultLength[i];
				int [] testArray = new int[elementNum];
				for(int j=0; j<elementNum; j++){
				    int element = resultElement[i][j];
				    testArray[j] = element;
				}	
				
			Deliverable4 testcase = new Deliverable4();	
			int observedArray[]=testcase.billify(testArray);
			int inputArrayLength = testArray.length;
			for(int dex=0; dex<inputArrayLength; dex++)
				assertTrue(Math.pow(testArray[dex],2)==observedArray[dex]);
			}
		}catch(Exception e){
			fail();
		}
	}

}
