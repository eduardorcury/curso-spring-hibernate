package springdemo;

public class MyApp {
	
	public static void main(String[] args) {
		
		// criar objeto
		Coach theCoach = new TrackCoach();

		// usar objeto
		System.out.println(theCoach.getDailyWorkout());
		
	}

}
