import java.util.ArrayList;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Gym {
	String gymName, managerName, phoneNumber;
	private ArrayList<Member> members;
	
	//constructor
		//1
		public Gym(String gymName, String managerName) {
			//gymName
			if (gymName.length() >30) { //checks if gymeName is more then 30
				this.gymName = gymName.substring(0,30);//Truncates the string if it is
			}
			else {
				this.gymName =gymName;
			}
			//
			//managerName
			this.managerName =managerName;
			//
			//phoneNumber
			this.phoneNumber="unknown";
			//
			//members in
			members = new ArrayList<Member>();
			//
		}
		//
		//2
		public Gym(String gymName, String managerName, String phoneNumber ) {
			//gymName
			if (gymName.length() >30) { //checks if gymeName is more then 30
				this.gymName = gymName.substring(0,30);//Truncates the string if it is
			}
			else {
				this.gymName =gymName;
			}
			//
			//managerName
			this.managerName =managerName;
			//
			//phone number
			try { 
				double check = Double.parseDouble(phoneNumber); //used to check if phone number is a number
				this.phoneNumber = phoneNumber;
			}
			catch(NumberFormatException nfe) {
				this.phoneNumber = "unknown";
			}
			//
			//members in
			members = new ArrayList<Member>();
			//
		}
		//
	//
	
	//Getters
		//Gym
		public String getGymName() {
			return this.gymName;
		}
		//
		//Manager
		public String getManagerName() {
			return this.managerName;
		}
		//
		//PhoneNumber
		public String getPhoneNumber() {
			return this.phoneNumber;
		}
		//
		//member array
		public ArrayList<Member> getMembers()
		{
			return members;
		}
		//
	//	
	
	//Setters
		//Gym
		public void setGymName(String gymName) {
			if (gymName.length() >30) { //checks if gymeName is more then 30
				this.gymName = gymName.substring(0,30);//Truncates the string if it is
			}
			else {
				this.gymName =gymName;
			}
		}
		//
		//Manager
		public void setManagerName(String managerName) {
			this.managerName = managerName;
		}
		//
		//PhoneNumber
		public void setPhoneNumber(String phoneNumber) {
			try { 
				double check = Double.parseDouble(phoneNumber); //used to check if phone number is a number
				this.phoneNumber = phoneNumber;
			}
			catch(NumberFormatException nfe) {// if failed do nothing
			}
		}
		//
	//
		
	//toString
		public String toString() {
			return ("Gym name: "+this.gymName+
					", Manager: "+this.managerName+
					", Phone Number: "+this.phoneNumber+
					"\n\n"+"List of members in the gym:\n"+ this.listMembers());
		}
	//
		
	//list by BMI
		public String listBySpecificBMICategory(String category){
			String listOfMatchingMembers = "";
			for (Member member: members){//checks all members
				if((member.determineBMICategory()).toUpperCase().contains(category.toUpperCase())) {//checks if bmi matches
					listOfMatchingMembers += (member.toString() + "\n");
				}
			}
			if(members.size()==0) {
				listOfMatchingMembers= "There are no members in the gym";
				
			}
			if(listOfMatchingMembers.equals("")) {
				listOfMatchingMembers = "There are no members in the gym in this BMI category ";
			}
			
			return listOfMatchingMembers;
		}
	//
	
	//Member list
		public String listMembers(){
			if(members.size()>0) {//makes sur there is at leat 1ember
				String listOfMembers = "";
				for (int i =0; i < members.size(); i++){
				listOfMembers +=  (i + ":" + members.get(i)) + "\n";// adds detales and index to list of members
				}
			return listOfMembers;
			}
			else {
				return ("There are no members in this gym");
			}

		}
	//
		
	//members details imp and met
		public String listMemberDetailsImperialAndMetric() {
			String MembersDetales ="   ";
			for (Member member: members){

			String MName = member.getMemberName()+":";
			String Weight = member.getStartingWeight()+" kg ("+member.convertWeightKGtoPounds()+" lbs)";
			String Height = member.getHeight()+" metera ("+member.convertHeightMetresToInches()+" inches)."+"\n";
			MembersDetales+= String.format("%-30s %-30s %-30s", MName, Weight, Height);// formats and adds detales to MembersDetales 
			}
			if(members.size()==0) {
				MembersDetales= "There are no members in this gym";
			}
			return MembersDetales;
		}
	//
		
	//member weight ideal
		public String listMembersWithIdealWeight() {
			String listOfIdeal = "";
			for (Member member: members){
				if(member.isIdealBodyWeight()) {
					listOfIdeal += (member.getMemberName()).toString() + "\n";// if the person has ideal weight thay are added to list
				}
			}
			if(members.size() == 0) {
				listOfIdeal = "There are no members in the gym";
			}
			if(listOfIdeal.equals("")) {
				listOfIdeal= "There are no members in the gym with an ideal weight";
			}
			return listOfIdeal;
		}
	//
	
	//number of members
		public int numberOfMembers() {
			return members.size();
		}
	//
		
	//add member
		public void add(Member member) {
			members.add(member);
		}
	//
		
	//remove member
		public void remove(int index) {
			if(index >= members.size() || index < 0) {
				System.out.println("There is no member for this index number");
			}
			else {
			members.remove(index);
			}
		}
	//
		
	    @SuppressWarnings("unchecked")
	    public void load() throws Exception //loads members
	    {
	    	System.out.println("Loading member details...");
	        XStream xstream = new XStream(new DomDriver());
	        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("member.xml"));
	        members = (ArrayList<Member>) is.readObject();
	        is.close();
	        System.out.println("Load Complete");
	    }
	    
	    public void save() throws Exception //saves members
	    {
	    	System.out.println("Saving member details...");
	        XStream xstream = new XStream(new DomDriver());
	        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("member.xml"));
	        out.writeObject(members);
	        out.close();
	        System.out.println("Saving Complete");
	    }

}
