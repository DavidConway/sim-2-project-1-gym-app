
public class Member {
	// initialisesvariables
	int memberId;  
	String memberName, memberAddress, gender;
	double height, startingWeight;
	//
	
	//constructor
	public Member(int memberId, String memberName, String MemberAddress, double height, double startingWeight, String gender) {
		//member id
		if(memberId>100000 && memberId<=999999) {
			this.memberId=memberId;
		}
		else {
			this.memberId = 100000;
		}
		//
		
		// member name
		if (memberName.length() >30) { //checks if gymeName is more then 30
			this.memberName = memberName.substring(0,30);//Truncates the string if it is
		}
		else {
			this.memberName =memberName;
		}
		//
		
		//address
		this.memberAddress=MemberAddress;
		//
		
		//height
		if(height>=1 && height <=3) {
			this.height = height;
		}
		else {
			this.height = 0;
		}
		//
		
		//S weight
		if(startingWeight>=35 && startingWeight<=250) {
			this.startingWeight = startingWeight;
		}
		else {
			this.startingWeight = 0;
		}
		//
		
		//gender
		if(gender.equals("f") || gender.equals("F") || gender.equals("m") || gender.equals("M")) {
			String genderUP = gender.toUpperCase();
			this.gender = genderUP;
		}
		else {
			this.gender = "Unspecified";			}
		//
	}
	//
	
	//getters
		// get height
		public double getHeight() {
			return this.height;
		}
		//
		//get address
		public String getMemberAddress() {
			return this.memberAddress;
		}
		//
		//get gender
		public String getMemberGender() {
			return this.gender;
		}
		//
		//get id
		public int getMemberId() {
			return this.memberId;
		}
		//
		//get name
		public String getMemberName() {
			return this.memberName;
		}
		//
		//get S weight
		public double getStartingWeight() {
			return this.startingWeight;
		}
		//
	//
	
	//setters
		//set gender
		public void setGender(String gender) {
			if(gender.equals("f") || gender.equals("F") || gender.equals("m") || gender.equals("M")) {
				String genderUP = gender.toUpperCase();
				this.gender = genderUP;
			}
		}
		//
		
		//set height
		public void setHeight(double height) {
			if(height>=1 && height <=3) {
				this.height = height;
			}
		}
		//
		
		//set address
		public void setMemberAddress(String memberAddress) {
			this.memberAddress=memberAddress;
		}
		//
		
		//set id
		public void setMemberId(int memberId) {
			if(memberId>100000 && memberId<=999999) {
				this.memberId=memberId;
			}
		}
		//
		
		//set name
		public void setMemberName(String memberName) {
			if (memberName.length() >30) { //checks if gymeName is more then 30
				this.memberName = memberName.substring(0,30);//Truncates the string if it is
			}
			else {
				this.memberName =memberName;
			}
		}
		//
		
		//set S weight
		public void setStartingWeight(double startingWeight) {
			if(startingWeight>=35 && startingWeight<=250) {
				this.startingWeight = startingWeight;
			}
		}
		//
	//
	
	//BMI
		// calc BMI
		public double calculateBMI() {
			double BMI= ((this.startingWeight)/(this.height*this.height)); //gets the number whit all decimals
			BMI = toTwoDecimalPlaces(BMI);
			return BMI;
		}
		//
		// deter BMI cat
		public String determineBMICategory() {
			String out = "NOT FOUND"; //initialises out
			if(this.calculateBMI()<15) {
				out= ("VERY SEVERELY UNDERWEIGHT");
			}
			else if(this.calculateBMI()>=15 && this.calculateBMI()<16) {
				out= ("SEVERELY UNDERWEIGHT");
			}
			else if(this.calculateBMI()>=16 && this.calculateBMI()<18.5) {
				out= ("UNDERWEIGHT");
			}
			else if(this.calculateBMI()>=18.5 && this.calculateBMI()<25) {
				out= ("NORMAL");
			}
			else if(this.calculateBMI()>=25 && this.calculateBMI()<30) {
				out= ("OVERWEIGHT");
			}
			else if(this.calculateBMI()>=30 && this.calculateBMI()<35) {
				out= ("MODERATELY OBESE");
			}
			else if(this.calculateBMI()>=35 && this.calculateBMI()<40) {
				out= ("SEVERELY OBESE");
			}
			else if(this.calculateBMI()>=40) {
				out= ("VERY SEVERELY OBESE");
			}
			return out; //returns whatever the body type is
		}
		//
	//
	
	
	//conversion
		// con Height
		public double convertHeightMetresToInches() {
			double con= this.height*39.37;//multiply height by 100
			con = toTwoDecimalPlaces(con);
			return con;
		}
		//
		//con weight
		public double convertWeightKGtoPounds() {
			double con= this.startingWeight*2.2;
			con = toTwoDecimalPlaces(con);
			return con;
		}
		//
	//
	
	//checks if there weight is ideal
	public boolean isIdealBodyWeight() {
		double idealWeight; //Initializes variables 
		boolean ideal;
		
		if(this.gender.equals("M")) { //checks if male
			if(this.convertHeightMetresToInches() > 60) {
				idealWeight = 50 + ((this.convertHeightMetresToInches()-60)*2.3);
			}
			else {
				idealWeight = 50;
			}
		}
		else{ //if female or not set
			if(this.convertHeightMetresToInches()>60) {
				idealWeight = 45.5 + ((this.convertHeightMetresToInches()-60)*2.3);
			}
			else {
				idealWeight = 45.5;
			}
		}
		
		if (idealWeight-2 <= this.startingWeight && this.startingWeight <= idealWeight+2) {//checks if the body wate is idea
			ideal = true;
		}
		else {
			ideal = false;
		}
		return ideal; //returns result

	}
	//
	
	//toString
	public String toString() {
		return ("Member id : "+this.memberId+
				", Name:"+this.memberName+
				", Address:"+this.memberAddress+"."+
				"\n\t Height: "+this.height+" meters"+ 
				", Starting Weight: "+this.startingWeight+" kgs"+
				", BMI: "+calculateBMI())+" "+"( \" " +this.determineBMICategory()+ " \" )"+this.gender;
	}
	//
	
    private double toTwoDecimalPlaces(double num){
        return (int) (num *100 ) /100.0; 
    }
}
