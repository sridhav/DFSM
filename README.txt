//README
/**
	Sridhar Vemula
	Formal Language Theory
*/

/**
	NOTE: Most of the description is given inside the program 
	      under comments for a better understanding. 
		  The brief gist for the program is provided below
    COMPILE : 1. javac DFSM.java
			  2. javac pattern.java
    USAGE : 1. java DFSM <input-file> <string to be accepted>
		    2. java pattern <output-file> <pattern>
	ERROR HANDLING : Appropriate Error Handling is done.
*/

/**
Problem 1 :
1. Values are taken from the File and loaded to the specific arrays 
   
2.  Each Character in the input string is checked for the transition from the 
	current state. If there is a transition for the current input character  
	the current state is changed to corresponding transition state .

3.  If the current state is in the final state then it returns true
	else it returns false  
*/


/**
Problem 2:
1. Takes 256 characters for every row(state) but most of them are wasted only the valid 
   input variables are considered i.e., the unique variables 
   obtained from the the above getUnique function
2. First fill the first row values all the values are zero except the first character in pattern
   it changes to the next state
3. For every other rows from index j= 1 to j<=pattern.length().
		1. Copy the entries from row at index equal to lastposition.
		2. Update the entry for transitions[j][pattern.charAt(j)] character to j+1.
		3. Update lastPosition = transitions[lastPosition][pattern.charAt(j)]
*/