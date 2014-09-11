/**
 *
 * @author Sridhar
 * 	Course: Formal Language Theory
 *  PROGRAMMING ASSIGNMENT - 1 Problem 1
 
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class DFSM {


    public static void main(String[] args) throws FileNotFoundException, IOException {
		if(args.length!=2){	
			// If no of arguments is less than 2 it generates an error message and program exits
			System.out.println("Invalid Number of Arguments");
			System.exit(1);
        }
		
		
		//result : this variable provides the final result
        boolean result=false;
		
        String inputStr=args[1];
        String input[];
        int cols=0;
		int i=0;
       int j=0;
       int lines=0;
	   
		//Start state is always taken as 1 => Every state is numbered 1,2,3.....
        String startState="1";
        //transitions holds the transitions states from the file
		String transitions[][];
        String s="";
        //final State : holds the Final States from the variables
		String finalStates[]=null;
        
		
        
		//File reading 
		
       FileReader fr=new FileReader(args[0]);
       BufferedReader br=new BufferedReader(fr);
       StringTokenizer st;

       
       
	   while((s=br.readLine())!=null){
           st=new StringTokenizer(s);
           if(lines==0)
                cols=st.countTokens();
           lines++;
       }
       br.close();

       br=new BufferedReader(new FileReader(args[0]));
       transitions=new String[lines-1][cols];
       input=new String[cols];
       finalStates=new String[cols];
	String totalInp="";
		/* Values are taken from the File and loaded to the specific arrays 
		the while loop below includes the process
		*/
       while((s=br.readLine())!=null){
           st=new StringTokenizer(s);
           if(i==0){
               j=0;
               while(st.hasMoreTokens()){
                   input[j]=st.nextToken();
					totalInp=totalInp+input[j];
					j++;
              }
           }
           else{
               j=0;
               while(st.hasMoreTokens()){
                   transitions[i-1][j]=st.nextToken();
                    finalStates[j]=transitions[i-1][j];
                    j++;
               }
           }
           i++;
       }
	    //Check for correct Input Value
	   for(i=0;i<inputStr.length();i++){
				if(!(totalInp.indexOf(inputStr.charAt(i))!=-1)){
					System.out.println("Invalid Input Arguments");
					System.exit(1);
				}
	   }
	   
	   
	   
	   
	   /*Final States Check if all the values are zero exit the program. 
	   If every Value is Zero => that There is no final State
	   */
	   int count=0;
	   for(i=0;i<finalStates.length;i++){
			if(!finalStates[i].equals("0")){
				count++;
			}
	   }
	   if(count==0){
		System.out.println("Final States cannot be empty or 0");
		System.exit(1);
	   }
	   
		/*
		Each Character in the input string is checked for the transition from the 
		current state. If there is a transition for the current input character  
		the current state is changed to corresponding transition state .
	   */
        String currentState=startState;
        int getRow;
        
		
	for(int k=0;k<inputStr.length();k++){
           String temp=inputStr.charAt(k)+"";
           getRow=Integer.parseInt(currentState);
           for(int m=0;m<input.length;m++){
               if(temp.equals(input[m])){
       			if(getRow!=0){
				currentState=transitions[getRow-1][m];	
					}
		             break;
                }
           }
        }

		/*If the current state is in the final state then it returns true
			else it returns false
		*/
        for(int l=0;l<finalStates.length;l++){
            if(currentState.equals(finalStates[l])){
                result=true;
            }
        }
        if(result){
	System.out.println("Yes");
    	}
	else{
	System.out.println("No");
	}
	}

	
	// Used for debugging
	
    public static void display(String[] a){
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
