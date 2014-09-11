/**
 *
 * @author Sridhar
 * 	Course: Formal Language Theory
 *  PROGRAMMING ASSIGNMENT - 1 Problem 2
 
 */
 
import java.io.*;
import java.util.Arrays;
public class pattern {

    public static void main(String[] args) throws Exception {
		if(args.length!=2){			
			// If no of arguments is less than 2 it generates an error message and program exits
			System.out.println("Invalid Number of Arguments");
			System.exit(1);
        }
		
		
		//holds the lastposition value 
		//lastpos for the first character is always 0
		int lastPos=0;
		//resulting transitions : final result
	   int transitions[][];
       String pattern=args[1];
	   String filename=args[0];
	   
	   //gets the unique alphabets from the input char 
	   char[] alphabets=getUnique(pattern);
	   String alp=new String(alphabets);
	   String pattern2=pattern+" ";
	   String res="";
      
	  
	  
	  /*takes 256 chars but most of them are wasted only the valid 
	   input variables are considered i.e., the unique variables 
	   obtained from the the above getUnique function
	*/
	  
       transitions=new int[pattern.length()+1][256];
    
	/*first fill the first row values
	 all the values are zero except the first character in pattern
	it changes to the next state
	*/
	for(int i=0;i<256;i++){
           transitions[0][i]=0;
          // int temp=Integer.parseInt(pattern.charAt(i)+"");
           transitions[0][(int)pattern.charAt(0)]=1;
    }
	   
	    /* for every other rows from index j= 1 to j<=pattern.length().
		1. Copy the entries from row at index equal to lastposition.
		2. Update the entry for transitions[j][pattern.charAt(j)] character to j+1.
		3. Update lastPosition = transitions[lastPosition][pattern.charAt(j)]
		*/
		for(int j=1;j<=pattern.length();j++){
           for(int k=0;k<256;k++){   
					transitions[j][k]=transitions[lastPos][k];
			}
					transitions[j][(int)pattern2.charAt(j)]=j+1; 
				   
               if(j<pattern.length()){
					lastPos=transitions[lastPos][(int)pattern2.charAt(j)];
              }
              
       }
	   
	   // Only the alphabets entries are displayed removing other unwanted entries
	 
	 for(int i=0;i<alphabets.length;i++){

		res=res+""+alphabets[i]+"\t";
	 }
	 res=res+"\n";
	 int temp;
	 for(int i=0;i<=pattern.length();i++){
           for(int j=1;j<256;j++){
				if(alp.indexOf((char)j)!=-1){
					temp=transitions[i][j]+1;
				    res=res+temp+"\t";
				}
           }
           res=res+"\n";
       }
	   temp=pattern.length()+1;
	   res=res+""+temp+"\n";
	   //res holds the tranisiton values returned to a file given in command line args
	   System.out.print(res);
	   //file writing
	   FileWriter fw=new  FileWriter(args[0]);
	   fw.write(res);
	   fw.close();
       
    }
	
	
//returns all unique characters from the input patterns as a char array
	public static char[] getUnique(String x){
		char[] chars=x.toCharArray();
		char[] ret=new char[chars.length];
		Arrays.sort(chars);
		int j=1;
		ret[0]=chars[0];
		for(int i=1;i<chars.length;i++){
			if(!(chars[i-1]==chars[i])){
				ret[j]=chars[i];
				j++;
			}
		}
		return ret;
	}
}
