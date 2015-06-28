package gcj;

public class Tester {
	
    public static void main(String[] args) throws Exception {
        double C = 500.0;
        double F = 4.0;
        double X = 2000.0;
        double currentOutput = 2.0;
        double totalTime = 0.0;
        while(true){
        	double timeWithoutFarm = X / currentOutput;
        	double timeForFarm = C / currentOutput;
        	double timeWithFarm = X / (currentOutput + F) + timeForFarm;
        	if(timeWithoutFarm > timeWithFarm){ //buy farm
        		totalTime += timeForFarm;
        		currentOutput += F;
        	} else {
        		totalTime += timeWithoutFarm;
        		break;
        	}
        }
        System.out.println(totalTime);
    }
}
