package Numbers;

public class IsPrime {
	// The running time for the below function is O(logN)
    public static void isPrime(int number) {
        if(number ==2){
            System.out.println("Prime");
            return;
        }      
        //Optimization 1 : all even numbers are not prime number
        if(number ==1 || number%2 ==0){
            System.out.println("Not prime");
            return;
        }
        //Optimization 2: start from 3 and in each iteration, add 2 and then divide
        //Optimization 3: based on math formula, the maximum iteration for the for loop is sqrt(n)
        int maxIteration = (int)Math.sqrt((double)number);
        for(int i=3;i<= maxIteration;i+=2) {
            if(number%i ==0) {
                System.out.println("Not prime");
                return;
            }
        }
        System.out.println("Prime");  
            
    }
}
