import java.util.ArrayList;
import java.util.Scanner;

public class Rabbit {
	public int RAge; //in months
	public boolean isFertile; //becomes fertile at 4 months
	public boolean isFemale; //true for female, false for male
	
	public Rabbit(int age, boolean fertile, boolean gender) {
		RAge = age;
		isFertile = fertile;
		isFemale = gender;
		}
	
	//returns age of rabbits
	public int getAge() {
		return RAge;
		} 
	//returns gender of rabbits
	public boolean getGender() {
		return isFemale;
		} 
	//returns fertility of rabbits
	public boolean getFertile() {
		return isFertile;
		}
	//sets rabbit to be fertile
	public void setFertile() {
		isFertile = true;
	}
	public void AgeMe() {
		RAge++;
	}
	
	
	 public static void main(String []args) {
		 Scanner input = new Scanner(System.in); //Scanner to get user input
		 ArrayList<Rabbit> totalPop = new ArrayList<Rabbit>(); //List of all the rabbits
		 int Mi = input.nextInt(); //Male_rabbits
		 int Fi = input.nextInt(); //Female_rabbits
		 int neededAlive = input.nextInt(); //Rabbits_needed_alive
		 int totalMonths = 0; //Total elapsed months
		 int totalDead = 0; //Total number of Dead
		 int totalF = Fi; //Total number of Females
		 int totalM = Mi; //Total number of Males		 
		 
		 //Populates the given number of initial males
		 for(int i = 0; i < Mi; i++) {
			 Rabbit rabbitMi = new Rabbit(2, false, false);
			 totalPop.add(rabbitMi);
		 }
		 //Populates the given number of initial females
		 for(int j = 0; j < Fi; j++) {
			 Rabbit rabbitMi = new Rabbit(2, false, true);
			 totalPop.add(rabbitMi);
		 }
		 
		 //While there are less rabbits than neededAlive
		 
		 while(totalPop.size() < neededAlive) {
			 totalMonths++;
			 for(int x = 0; x < totalPop.size(); x++) {
				 totalPop.get(x).AgeMe(); //Age them one month
				 //If rabbit is of age make fertile
				 if(totalPop.get(x).getAge() >= 4) {
					 totalPop.get(x).setFertile();
				 }
				 //If rabbit is female and fertile, it breeds
				 if(totalPop.get(x).getGender() && totalPop.get(x).getFertile() == true) {
						//Breeds 5 Male rabbits into totalPop
						for(int m = 0; m < 4; m++) { 
							Rabbit mBaby = new Rabbit(0, false, false);//create a male baby
							totalPop.add(mBaby); //add baby to the totalPop
							totalM++;
							}
						//Breeds 9 female rabbits into totalPop
						for(int f = 0; f < 8; f++) { 
							Rabbit fBaby = new Rabbit(0, false, true); //create a female baby
							totalPop.add(fBaby); //add baby to the totalPop
							totalF++;
							}
				 		}
				 //If older than 96, delete
				 if(totalPop.get(x).getAge() > 96) {
					 totalDead++;
					 totalPop.remove(x);
				 		}
				 	}
				 }
		 System.out.println("Total Final Pop: " + totalPop.size());
		 System.out.println("Total time taken: " + totalMonths + " months");
		 System.out.println("Total dead rabbits: " + totalDead);
		 System.out.println("Total males:" + totalM + " Total females:" + totalF);
			 }
		 }
