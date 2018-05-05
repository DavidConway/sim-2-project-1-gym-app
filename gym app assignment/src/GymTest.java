import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
	
/**
	 * The test class GymTest.
	 *
	 * @author  (Siobhan Drohan)
	 * @version (12 Feb 2018)
	 */
	public class GymTest
	{
	    //instance fields for testing the BMI category method.
	    private Member under15;
	    private Member equal15;
	    private Member equal16;
	    private Member below18point5;
	    private Member equal18point5;
	    private Member below25;
	    private Member equal25;
	    private Member below30;
	    private Member equal30;
	    private Member below35;
	    private Member equal35;
	    private Member below40;

	    private Gym idealWeightsGym;
	    private Gym bmiCategoriesGym;
	    private Gym unknownPhoneGym;
	    
	    /**
	     * Sets up the test fixture.
	     *
	     * Called before every test case method.
	     */
	    @Before
	    public void setUp()
	    {
	        idealWeightsGym  = new Gym("Ideal and non-ideal Weight Gym", "The Rock", "0563232532");
	        idealWeightsGym.add(  new Member(123456, "under5foot M ideal", "Waterford", 1.50, 50.0, "m"));
	        idealWeightsGym.add(  new Member(123457, "under5foot F ideal", "Waterford", 1.50, 45.5, "f"));
	        idealWeightsGym.add(  new Member(123458, "just over 5ft M", "Waterford", 1.53, 52, "m"));
	        idealWeightsGym.add(  new Member(123459, "just over 5ft F", "Waterford", 1.53, 47.5, "f"));
	        idealWeightsGym.add(  new Member(123458, "well over 5ft M", "Waterford", 1.78, 73, "m"));
	        idealWeightsGym.add(  new Member(123459, "well over 5ft F", "Waterford", 1.78, 68.5, "f"));
	        idealWeightsGym.add(  new Member(123456, "under5foot M NOT ideal",    "Waterford", 1.50, 47.98, "m"));
	        idealWeightsGym.add(  new Member(123457, "under5foot F NOT ideal",    "Waterford", 1.50, 43.45, "f"));
	        idealWeightsGym.add(  new Member(123458, "just over 5ft M NOT ideal", "Waterford", 1.53, 52.6, "m"));
	        idealWeightsGym.add(  new Member(123459, "just over 5ft F NOT ideal", "Waterford", 1.53, 48.1, "f"));        
	        idealWeightsGym.add(  new Member(123458, "well over 5ft M NOT ideal", "Waterford", 1.78, 75.2, "m"));
	        idealWeightsGym.add(  new Member(123459, "well over 5ft F NOT ideal", "Waterford", 1.78, 70.7, "f"));    
	   
	        bmiCategoriesGym = new Gym("BMI Categories Allsorts Gym!!!!", "Eddie the Eagle", "051-23222");
	        //instance fields for testing the BMI category method.
	        under15       = new Member(123456, "v sev u-weight", "Waterford", 2, 59.96,  "m");
	        equal15       = new Member(123457, "sev u-weight",   "Waterford", 2, 60,     "f");
	        equal16       = new Member(123458, "u-weight",       "Waterford", 2, 64,     "Unspecified");
	        below18point5 = new Member(123459, "u-weight",       "Waterford", 2, 73.88,  "f");
	        equal18point5 = new Member(123460, "normal",         "Waterford", 2, 74,     "m");
	        below25       = new Member(123461, "normal",         "Waterford", 2, 99.2,   "f");
	        equal25       = new Member(123462, "overweight",     "Waterford", 2, 100,    "m");
	        below30       = new Member(123463, "overweight",     "Waterford", 2, 119.92, "f");
	        equal30       = new Member(123464, "mod obese 1",    "Waterford", 2, 120,    "m");
	        below35       = new Member(123465, "mod obese 2",    "Waterford", 2, 139.96, "Unspecified");
	        equal35       = new Member(123466, "sev obese 1",    "Waterford", 2, 140,    "m");
	        below40       = new Member(123467, "sev obese 2",    "Waterford", 2, 159.92, "f");
	        bmiCategoriesGym.add(under15);
	        bmiCategoriesGym.add(equal15);
	        bmiCategoriesGym.add(equal16);
	        bmiCategoriesGym.add(below18point5);
	        bmiCategoriesGym.add(equal18point5);
	        bmiCategoriesGym.add(below25);
	        bmiCategoriesGym.add(equal25);
	        bmiCategoriesGym.add(below30);
	        bmiCategoriesGym.add(equal30);
	        bmiCategoriesGym.add(below35);
	        bmiCategoriesGym.add(equal35);
	        bmiCategoriesGym.add(below40);
	        
	        unknownPhoneGym  = new Gym("No Phone GYM", "No Contact Person!");
	    }

	    //===========================================
	    //  TESTING CONSTRUCTORS AND GETTERS TOGETHER
	    //===========================================
	    @Test
	    public void testGettersWithValidConstructorEntries()
	    {
	        assertThat(idealWeightsGym.getGymName().equals("Ideal and non-ideal Weight Gym"), is(true));
	        assertThat(idealWeightsGym.getGymName().length(), is(30));
	        assertThat(idealWeightsGym.getManagerName().equals("The Rock"), is(true));
	        assertThat(idealWeightsGym.getPhoneNumber().equals("0563232532"), is(true));
	    }

	    @Test
	    public void testGettersWithInValidConstructorEntries()
	    {
	        assertThat(bmiCategoriesGym.getGymName().equals("BMI Categories Allsorts Gym!!!"), is(true));
	        assertThat(bmiCategoriesGym.getGymName().length(), is(30));
	        assertThat(bmiCategoriesGym.getManagerName().equals("Eddie the Eagle"), is(true));
	        assertThat(bmiCategoriesGym.getPhoneNumber().equals("unknown"), is(true));
	    }
	    
	    //======================================
	    //  TESTING SETTERS AND GETTERS TOGETHER
	    //======================================
	    @Test
	    public void testGettersWithValidSetterEntries()
	    {
	        assertThat(idealWeightsGym.getGymName().equals("Ideal and non-ideal Weight Gym"), is(true));
	        idealWeightsGym.setGymName("Ideal and NON-ideal Weight Gym");
	        assertThat(idealWeightsGym.getGymName().equals("Ideal and NON-ideal Weight Gym"), is(true));
	        
	        assertThat(idealWeightsGym.getManagerName().equals("The Rock"), is(true));
	        idealWeightsGym.setManagerName("Dwayne Johnson");
	        assertThat(idealWeightsGym.getManagerName().equals("Dwayne Johnson"), is(true));
	                
	        assertThat(idealWeightsGym.getPhoneNumber().equals("0563232532"), is(true));
	        idealWeightsGym.setPhoneNumber("0513232333");
	        assertThat(idealWeightsGym.getPhoneNumber().equals("0513232333"), is(true));
	    }
	    
	    @Test
	    public void testGettersWithInValidSetterEntries()
	    {
	        assertThat(bmiCategoriesGym.getGymName().equals("BMI Categories Allsorts Gym!!!"), is(true));
	        bmiCategoriesGym.setGymName("BMI Categories Allsorts Gymnasium");
	        assertThat(bmiCategoriesGym.getGymName().equals("BMI Categories Allsorts Gymnas"), is(true));
	        
	        assertThat(bmiCategoriesGym.getManagerName().equals("Eddie the Eagle"), is(true));
	        bmiCategoriesGym.setManagerName("Michael Edwards");
	        assertThat(bmiCategoriesGym.getManagerName().equals("Michael Edwards"), is(true));
	                
	        assertThat(bmiCategoriesGym.getPhoneNumber().equals("unknown"), is(true));
	        bmiCategoriesGym.setPhoneNumber("0513232333");
	        assertThat(bmiCategoriesGym.getPhoneNumber().equals("0513232333"), is(true));
	        bmiCategoriesGym.setPhoneNumber("Ireland 051-3232333");
	        assertThat(bmiCategoriesGym.getPhoneNumber().equals("0513232333"), is(true));
	    }
	    
	    //==============================================================================
	    //  TESTING EXISTENCE OF toString METHOD AND THE CONTENTS OF THE RETURNED STRING
	    //==============================================================================
	    @Test
	    public void testToString()
	    {
	        assertThat(idealWeightsGym.toString().contains("Ideal and non-ideal Weight Gym"), is(true));
	        assertThat(idealWeightsGym.toString().contains("The Rock"), is(true));
	        assertThat(idealWeightsGym.toString().contains("0563232532"), is(true));
	        
	        //?sdr?  add in something to test for inclusion of arraylist members
	    }   
	    
	    @Test
	    public void testRemovalFromEmptyArrayList() {
            //testing when no elements are in the arraylist
	    	assertThat(unknownPhoneGym.numberOfMembers(), is (0));
	    	unknownPhoneGym.remove(0);
	    	assertThat(unknownPhoneGym.numberOfMembers(), is (0));
	    	unknownPhoneGym.remove(-1);
	    	assertThat(unknownPhoneGym.numberOfMembers(), is (0));
	    	unknownPhoneGym.remove(1);
	    	assertThat(unknownPhoneGym.numberOfMembers(), is (0));
	    }

	    @Test
	    public void testRemovalFromPopulatedArrayList() {
	    	//testing when multiple elements are in the arraylist
	    	assertThat(idealWeightsGym.numberOfMembers(), is (12));
	    	idealWeightsGym.remove(0);
	    	assertThat(idealWeightsGym.numberOfMembers(), is (11));
	    	idealWeightsGym.remove(-1);
	    	assertThat(idealWeightsGym.numberOfMembers(), is (11));
	    	idealWeightsGym.remove(11);
	    	assertThat(idealWeightsGym.numberOfMembers(), is (11));
	    	idealWeightsGym.remove(10);
	    	assertThat(idealWeightsGym.numberOfMembers(), is (10));
	    }
	    
	    @Test
	    public void testListFromEmptyArrayList() {
            //testing when no elements are in the arraylist
	    	assertThat(unknownPhoneGym.listMembers().toUpperCase().contains("NO MEMBERS"), is (true));	    
	    	assertThat(unknownPhoneGym.listMembersWithIdealWeight().toUpperCase().contains("NO MEMBERS"), is (true));	    
	    	assertThat(unknownPhoneGym.listBySpecificBMICategory("OBESE").toUpperCase().contains("NO MEMBERS"), is (true));	    
	    	assertThat(unknownPhoneGym.listMemberDetailsImperialAndMetric().toUpperCase().contains("NO MEMBERS"), is (true));	      	
	    }
	    
	    @Test
	    public void testDummyBMICategoryHasNoMembers() {
            //negative testing - a dummy bmi category should return saying no members in that BMI category
	    	assertThat((bmiCategoriesGym.listBySpecificBMICategory("dummy category").toUpperCase().contains("NO MEMBERS") &&
	    			    bmiCategoriesGym.listBySpecificBMICategory("dummy category").toUpperCase().contains("BMI CATEGORY")), is (true));	    	    	
	    }
	    
	    @Test
	    public void testCorrectBMICategoryButNoMembers() {
            //negative testing - a correct BMI category but no members should return saying no members in that BMI category
	    	assertThat((bmiCategoriesGym.listBySpecificBMICategory("VERY SEVERELY OBESE").toUpperCase().contains("NO MEMBERS") &&
	    			    bmiCategoriesGym.listBySpecificBMICategory("VERY SEVERELY OBESE").toUpperCase().contains("BMI CATEGORY")), is (true));	    	    	
	    }

	    
	    @Test
	    public void testCorrectBMICategoryWithTwoMembers() {
            //positive testing - a correct BMI category should return two members
	    	assertThat((bmiCategoriesGym.listBySpecificBMICategory("SEVERELY OBESE").toUpperCase().contains("SEV OBESE 1") &&
	    			    bmiCategoriesGym.listBySpecificBMICategory("SEVERELY OBESE").toUpperCase().contains("SEV OBESE 2")), is (true));	    	    	
	    }

	    @Test
	    public void testCorrectSubBMICategoryWithMembers() {
            //positive testing - a correct BMI category should return two members
	    	assertThat((bmiCategoriesGym.listBySpecificBMICategory("OBESE").toUpperCase().contains("SEV OBESE 1") &&
	    			    bmiCategoriesGym.listBySpecificBMICategory("OBESE").toUpperCase().contains("SEV OBESE 2") &&
      			        bmiCategoriesGym.listBySpecificBMICategory("OBESE").toUpperCase().contains("MOD OBESE 1") &&
		                bmiCategoriesGym.listBySpecificBMICategory("OBESE").toUpperCase().contains("MOD OBESE 2"))
	     			   , is (true));	    	    	
	    }
	    
	    @Test
	    public void testGymWithMembersWithIdealWeight() {
            //positive testing - Gym has members with ideal body weights
	    	assertThat((idealWeightsGym.listMembersWithIdealWeight().contains("just over 5ft M") &&
	    			    idealWeightsGym.listMembersWithIdealWeight().contains("just over 5ft F"))
	     			    , is (true));	    	    
	    }

	    @Test
	    public void testGymWithMembersWithNoIdealWeight() {
            //negative testing - Gym has members but none with ideal body weights	
	    	assertThat((bmiCategoriesGym.listMembersWithIdealWeight().toUpperCase().contains("NO MEMBERS") &&
    			    bmiCategoriesGym.listMembersWithIdealWeight().toUpperCase().contains("IDEAL")), is (true));	    	    	
	    	
	    }

	    @Test
	    public void testListingMembersImpericallyAndMetrically(){
	        //	u-weight:		73.88 kg (162.53 lbs)		2.0 metres (78.73 inches).
	    	assertThat(bmiCategoriesGym.listMemberDetailsImperialAndMetric().contains("u-weight"), is (true));	      	
	    	assertThat(bmiCategoriesGym.listMemberDetailsImperialAndMetric().contains("73.88"), is (true));	      	
	    	assertThat(bmiCategoriesGym.listMemberDetailsImperialAndMetric().contains("162.53"), is (true));	      	
	    	assertThat(bmiCategoriesGym.listMemberDetailsImperialAndMetric().contains("2.0"), is (true));	      	
	    	assertThat(bmiCategoriesGym.listMemberDetailsImperialAndMetric().contains("78.73"), is (true));	      	
	    }

}