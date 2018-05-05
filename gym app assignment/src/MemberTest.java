import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
/**
 * The test class MemberTest.
 *
 * @author  (Siobhan Drohan)
 * @version (12 Feb 2018)
 */
public class MemberTest {
	
    //instance fields for testing throughout the test class
    private Member normalMember1;
    private Member normalMember2;
    private Member invalidMemberDetailsLower;
    private Member invalidMemberDetailsUpper;

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
    private Member equal40;

    //instance fields for testing the ideal weight method; these are ideal body weights:
    private Member under5footM1;
    private Member under5footF1;
    private Member justover5footM;
    private Member justover5footF;
    private Member wellover5footM;
    private Member wellover5footF;

    //instance fields for testing the ideal weight method; these are NOT ideal body weights:
    private Member under5footM1NotIdeal;
    private Member under5footF1NotIdeal;
    private Member justover5footMNotIdeal;
    private Member justover5footFNotIdeal;
    private Member wellover5footMNotIdeal;
    private Member wellover5footFNotIdeal;

    
    public MemberTest()
    {
    }
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        normalMember1 = new Member(100001, "012345678901234567890123456789", "Waterford", 1, 35, "f");
        normalMember2 = new Member(999999, "012345678901234567890123456789", "Waterford", 3, 250, "m");
        invalidMemberDetailsLower = new Member(100000,  "01234567890123456789012345678901", 
            "No validation on this field", 0.8, 34.8, "t");
        invalidMemberDetailsUpper = new Member(1000000, "01234567890123456789012345678901", 
            "No validation on this field", 3.2, 250.2, "ff");

        //instance fields for testing the BMI category method.
        under15       = new Member(123456, "v sev u-weight", "Waterford", 2, 59.96,  "m");
        equal15       = new Member(123457, "sev u-weight",   "Waterford", 2, 60,     "f");
        equal16       = new Member(123458, "u-weight",       "Waterford", 2, 64,     "Unspecified");
        below18point5 = new Member(123459, "u-weight",       "Waterford", 2, 73.88,  "f");
        equal18point5 = new Member(123460, "normal",         "Waterford", 2, 74,     "m");
        below25       = new Member(123461, "normal",         "Waterford", 2, 99.2,   "f");
        equal25       = new Member(123462, "overweight",     "Waterford", 2, 100,    "m");
        below30       = new Member(123463, "overweight",     "Waterford", 2, 119.92, "f");
        equal30       = new Member(123464, "mod obese",      "Waterford", 2, 120,    "m");
        below35       = new Member(123465, "mod obese",      "Waterford", 2, 139.96, "Unspecified");
        equal35       = new Member(123466, "sev obese",      "Waterford", 2, 140,    "m");
        below40       = new Member(123467, "sev obese",      "Waterford", 2, 159.92, "f");
        equal40       = new Member(123468, "v sev obese",    "Waterford", 2, 160,    "m");

        //instance fields for testing the ideal weight method; these are ideal body weights:
        under5footM1   = new Member(123456, "under5foot M ideal", "Waterford", 1.50, 50.0, "m");
        under5footF1   = new Member(123457, "under5foot F ideal", "Waterford", 1.50, 45.5, "f");
        justover5footM = new Member(123458, "just over 5ft M", "Waterford", 1.53, 52, "m");
        justover5footF = new Member(123459, "just over 5ft F", "Waterford", 1.53, 47.5, "f");
        wellover5footM = new Member(123458, "well over 5ft M", "Waterford", 1.78, 73, "m");
        wellover5footF = new Member(123459, "well over 5ft F", "Waterford", 1.78, 68.5, "f");

        //instance fields for testing the ideal weight method; these are NOT ideal body weights:
        under5footM1NotIdeal   = new Member(123456, "under5foot M NOT ideal",    "Waterford", 1.50, 47.98, "m");
        under5footF1NotIdeal   = new Member(123457, "under5foot F NOT ideal",    "Waterford", 1.50, 43.45, "f");
        justover5footMNotIdeal = new Member(123458, "just over 5ft M NOT ideal", "Waterford", 1.53, 52.6, "m");
        justover5footFNotIdeal = new Member(123459, "just over 5ft F NOT ideal", "Waterford", 1.53, 48.1, "f");
        wellover5footMNotIdeal = new Member(123458, "well over 5ft M NOT ideal", "Waterford", 1.78, 75.2, "m");
        wellover5footFNotIdeal = new Member(123459, "well over 5ft F NOT ideal", "Waterford", 1.78, 70.7, "f");    

    }

    //===========================================
    //  TESTING CONSTRUCTORS AND GETTERS TOGETHER
    //===========================================
    @Test
    public void testGettersWithNormal1ConstructorEntries()
    {
        assertThat(normalMember1.getMemberId(), is(100001));

        assertThat(normalMember1.getMemberName(), equalTo("012345678901234567890123456789"));
        assertThat(normalMember1.getMemberName().length(), is(30));

        assertThat(normalMember1.getMemberAddress(), equalTo("Waterford"));

        assertThat(normalMember1.getHeight(), is(1.0));
        assertThat(normalMember1.getStartingWeight(), is(35.0));

        assertThat(normalMember1.getMemberGender(), equalTo ("F"));
    }

    @Test
    public void testGettersWithNormal2ConstructorEntries()
    {
        assertThat(normalMember2.getMemberId(), is(999999));

        assertThat(normalMember2.getMemberName(), equalTo("012345678901234567890123456789"));
        assertThat(normalMember2.getMemberName().length(), is(30));

        assertThat(normalMember2.getMemberAddress(), equalTo("Waterford"));

        assertThat(normalMember2.getHeight(), is(3.0));
        assertThat(normalMember2.getStartingWeight(), is(250.0));
        
        assertThat(normalMember2.getMemberGender(), equalTo ("M"));
    }

    @Test
    public void testGettersWithInvalidMemberLowerConstructorEntries()
    {
        assertThat(invalidMemberDetailsLower.getMemberId(), is(100000));

        assertThat(invalidMemberDetailsLower.getMemberName(), equalTo("012345678901234567890123456789"));
        assertThat(invalidMemberDetailsLower.getMemberName().length(), is(30));

        assertThat(invalidMemberDetailsLower.getMemberAddress(), equalTo("No validation on this field"));

        assertThat(invalidMemberDetailsLower.getHeight(), is(0.0));
        assertThat(invalidMemberDetailsLower.getStartingWeight(), is(0.0));
        
        assertThat(invalidMemberDetailsLower.getMemberGender(), equalTo("Unspecified"));
    }

    @Test
    public void testGettersWithInvalidMemberUpperConstructorEntries()
    {
        assertThat(invalidMemberDetailsUpper.getMemberId(), is(100000));

        assertThat(invalidMemberDetailsUpper.getMemberName(), equalTo("012345678901234567890123456789"));
        assertThat(invalidMemberDetailsUpper.getMemberName().length(), is(30));

        assertThat(invalidMemberDetailsUpper.getMemberAddress(), equalTo("No validation on this field"));

        assertThat(invalidMemberDetailsUpper.getHeight(), is(0.0));
        assertThat(invalidMemberDetailsUpper.getStartingWeight(), is(0.0));
    }

    //======================================
    //  TESTING SETTERS AND GETTERS TOGETHER
    //======================================
    @Test
    public void testGettersWithNormal1SetterEntries()
    {
        assertThat(normalMember1.getMemberId(), is(100001));
        normalMember1.setMemberId(999999);
        assertThat(normalMember1.getMemberId(), is(999999));

        assertThat(normalMember1.getMemberName(), equalTo("012345678901234567890123456789"));
        assertThat(normalMember1.getMemberName().length(), is(30));
        normalMember1.setMemberName("This is also 30 character long");
        assertThat(normalMember1.getMemberName().length(), is(30));
        assertThat(normalMember1.getMemberName(), equalTo("This is also 30 character long"));

        assertThat(normalMember1.getMemberAddress(), equalTo("Waterford"));
        normalMember1.setMemberAddress("Wexford");
        assertThat(normalMember1.getMemberAddress(), equalTo("Wexford"));

        assertThat(normalMember1.getHeight(), is(1.0));
        normalMember1.setHeight(3);
        assertThat(normalMember1.getHeight(), is(3.0));

        assertThat(normalMember1.getStartingWeight(), is(35.0));
        normalMember1.setStartingWeight(250);
        assertThat(normalMember1.getStartingWeight(), is(250.0));
    }

    @Test
    public void testGettersWithNormal2SetterEntries()
    {
        assertThat(normalMember2.getMemberId(), is(999999));
        normalMember2.setMemberId(100001);
        assertThat(normalMember2.getMemberId(), is(100001));

        assertThat(normalMember2.getMemberName(), equalTo("012345678901234567890123456789"));
        assertThat(normalMember2.getMemberName().length(), is(30));
        normalMember2.setMemberName("This is also 30 character long");
        assertThat(normalMember2.getMemberName().length(), is(30));
        assertThat(normalMember2.getMemberName(), equalTo("This is also 30 character long"));

        assertThat(normalMember2.getMemberAddress(), equalTo("Waterford"));
        normalMember2.setMemberAddress("Wexford");
        assertThat(normalMember2.getMemberAddress(), equalTo("Wexford"));

        assertThat(normalMember2.getHeight(), is(3.0));
        normalMember2.setHeight(1);
        assertThat(normalMember2.getHeight(), is(1.0));

        assertThat(normalMember2.getStartingWeight(), is(250.0));
        normalMember2.setStartingWeight(35);
        assertThat(normalMember2.getStartingWeight(), is(35.0));

        assertThat(normalMember2.getMemberGender(), equalTo("M"));
        normalMember2.setGender("f");
        assertThat(normalMember2.getMemberGender(), equalTo("F"));
    }

    @Test
    public void testGettersWithInvalidMemberLowerSetterEntries()
    {
        //the two setter calls are ensuring that a value of 100000 was not being
        //defaulted at setter level.
        assertThat(invalidMemberDetailsLower.getMemberId(), is(100000));
        invalidMemberDetailsLower.setMemberId(999999);
        assertThat(invalidMemberDetailsLower.getMemberId(), is(999999));
        invalidMemberDetailsLower.setMemberId(99999);
        assertThat(invalidMemberDetailsLower.getMemberId(), is(999999));

        assertThat(invalidMemberDetailsLower.getMemberName(), equalTo("012345678901234567890123456789"));
        assertThat(invalidMemberDetailsLower.getMemberName().length(), is(30));
        invalidMemberDetailsLower.setMemberName("This is also 31 characters long");
        assertThat(invalidMemberDetailsLower.getMemberName().length(), is(30));
        assertThat(invalidMemberDetailsLower.getMemberName(), equalTo("This is also 31 characters lon"));

        assertThat(invalidMemberDetailsLower.getMemberAddress(), equalTo("No validation on this field"));
        invalidMemberDetailsLower.setMemberAddress("Wexford");
        assertThat(invalidMemberDetailsLower.getMemberAddress(), equalTo("Wexford"));

        //the two setter calls are ensuring that a value of 0 was not being
        //defaulted at setter level.
        assertThat(invalidMemberDetailsLower.getHeight(), is(0.0));
        invalidMemberDetailsLower.setHeight(1);
        assertThat(invalidMemberDetailsLower.getHeight(), is(1.0));
        invalidMemberDetailsLower.setHeight(0.8);
        assertThat(invalidMemberDetailsLower.getHeight(), is(1.0));

        //the two setter calls are ensuring that a value of 0 was not being
        //defaulted at setter level.
        assertThat(invalidMemberDetailsLower.getStartingWeight(), is(0.0));
        invalidMemberDetailsLower.setStartingWeight(35);
        assertThat(invalidMemberDetailsLower.getStartingWeight(), is(35.0));
        invalidMemberDetailsLower.setStartingWeight(34.8); 
        assertThat(invalidMemberDetailsLower.getStartingWeight(), is(35.0));

        assertThat(invalidMemberDetailsLower.getMemberGender(), equalTo("Unspecified"));
        invalidMemberDetailsLower.setGender("m");
        assertThat(invalidMemberDetailsLower.getMemberGender(), equalTo("M"));
        invalidMemberDetailsLower.setGender("blah");
        assertThat(invalidMemberDetailsLower.getMemberGender(), equalTo("M"));
    }

    @Test
    public void testGettersWithInvalidMemberUpperSetterEntries()
    {
        //the two setter calls are ensuring that a value of 100000 was not being
        //defaulted at setter level.
        assertThat(invalidMemberDetailsUpper.getMemberId(), is(100000));
        invalidMemberDetailsUpper.setMemberId(100001);
        assertThat(invalidMemberDetailsUpper.getMemberId(), is(100001));
        invalidMemberDetailsUpper.setMemberId(10000000);
        assertThat(invalidMemberDetailsUpper.getMemberId(), is(100001));
        invalidMemberDetailsUpper.setMemberId(999999);
        assertThat(invalidMemberDetailsUpper.getMemberId(), is(999999));
        invalidMemberDetailsUpper.setMemberId(999998);
        assertThat(invalidMemberDetailsUpper.getMemberId(), is(999998));

        assertThat(invalidMemberDetailsUpper.getMemberName(), equalTo("012345678901234567890123456789"));
        assertThat(invalidMemberDetailsUpper.getMemberName().length(), is(30));
        invalidMemberDetailsUpper.setMemberName("This is also 31 characters long");
        assertThat(invalidMemberDetailsUpper.getMemberName().length(), is(30));
        assertThat(invalidMemberDetailsUpper.getMemberName(), equalTo("This is also 31 characters lon"));

        assertThat(invalidMemberDetailsUpper.getMemberAddress(), equalTo("No validation on this field"));
        invalidMemberDetailsUpper.setMemberAddress("Wexford");
        assertThat(invalidMemberDetailsUpper.getMemberAddress(), equalTo("Wexford"));

        //the two setter calls are ensuring that a value of 0 was not being
        //defaulted at setter level.
        assertThat(invalidMemberDetailsUpper.getHeight(), is(0.0));
        invalidMemberDetailsUpper.setHeight(3);
        assertThat(invalidMemberDetailsUpper.getHeight(), is(3.0));
        invalidMemberDetailsUpper.setHeight(3.2);
        assertThat(invalidMemberDetailsUpper.getHeight(), is(3.0));

        //the two setter calls are ensuring that a value of 0 was not being
        //defaulted at setter level.
        assertThat(invalidMemberDetailsUpper.getStartingWeight(), is(0.0));
        invalidMemberDetailsUpper.setStartingWeight(250);
        assertThat(invalidMemberDetailsUpper.getStartingWeight(), is(250.0));
        invalidMemberDetailsUpper.setStartingWeight(250.2); 
        assertThat(invalidMemberDetailsUpper.getStartingWeight(), is(250.0));

        //test the mutator for both positive and negative tests
        assertThat(invalidMemberDetailsUpper.getMemberGender(), equalTo("Unspecified"));
        invalidMemberDetailsUpper.setGender("f");
        assertThat(invalidMemberDetailsUpper.getMemberGender(), equalTo("F"));
        invalidMemberDetailsUpper.setGender("b");
        assertThat(invalidMemberDetailsUpper.getMemberGender(), equalTo("F"));
    
    
    }    

    //==============================================================================
    //  TESTING EXISTENCE OF toString METHOD AND THE CONTENTS OF THE RETURNED STRING
    //==============================================================================
    @Test
    public void testToString()
    {
        assertThat(normalMember1.toString().contains("100001"), is(true));
        assertThat(normalMember1.toString().contains("012345678901234567890123456789"), is(true));
        assertThat(normalMember1.toString().contains("Waterford"), is(true));
        assertThat(normalMember1.toString().contains("1.0"), is(true));
        assertThat(normalMember1.toString().contains("35.0"), is(true));
        assertThat(normalMember1.toString().contains("" + normalMember1.calculateBMI()), is(true));
        assertThat(normalMember1.toString().contains(normalMember1.determineBMICategory()), is(true));      
    }

    //==============================================================================
    //  TESTING THE REMAINING METHODS IN THE MEMBER CLASS:
    //      * convertWeightKGtoPounds()
    //      * convertHeightMetresToInches()
    //      * isIdealBodyWeight()
    //      * calculateBMI()
    //      * determineBMICategory()
    //==============================================================================
    @Test
    public void testConvertWeightKGtoPounds()
    {
        assertThat(normalMember1.convertWeightKGtoPounds(), is(77.0));
        assertThat(normalMember2.convertWeightKGtoPounds(), is(550.0));
        assertThat(invalidMemberDetailsLower.convertWeightKGtoPounds(), is(0.0));
        assertThat(invalidMemberDetailsUpper.convertWeightKGtoPounds(), is(0.0));
    }

    @Test
    public void testConvertHeightMetresToInches()
    {
        assertEquals(normalMember1.convertHeightMetresToInches(), 39.37, 0.1);
        assertEquals(normalMember2.convertHeightMetresToInches(), 118.11, 0.1);
        assertThat(invalidMemberDetailsLower.convertHeightMetresToInches(), is(0.0));
        assertThat(invalidMemberDetailsUpper.convertHeightMetresToInches(), is(0.0));
    }

    @Test
    public void testIsIdealBodyWeight()
    {
        assertThat(under5footM1.isIdealBodyWeight(), is(true));
        assertThat(under5footF1.isIdealBodyWeight(), is(true));
        assertThat(justover5footM.isIdealBodyWeight(), is(true));
        assertThat(justover5footF.isIdealBodyWeight(), is(true));
        assertThat(wellover5footM.isIdealBodyWeight(), is(true));
        assertThat(wellover5footF.isIdealBodyWeight(), is(true));

        assertThat(under5footM1NotIdeal.isIdealBodyWeight(), is(false));
        assertThat(under5footF1NotIdeal.isIdealBodyWeight(), is(false));
        assertThat(justover5footMNotIdeal.isIdealBodyWeight(), is(false));
        assertThat(justover5footFNotIdeal.isIdealBodyWeight(), is(false));
        assertThat(wellover5footMNotIdeal.isIdealBodyWeight(), is(false));
        assertThat(wellover5footFNotIdeal.isIdealBodyWeight(), is(false));
    }

    @Test
    public void testCalculateBMI()
    {
        assertThat(normalMember1.calculateBMI(), is(35.0));
        assertThat(normalMember2.calculateBMI(), is(27.77));        
        assertThat(invalidMemberDetailsLower.calculateBMI(), is(0.0));
        assertThat(invalidMemberDetailsUpper.calculateBMI(), is(0.0));        
    }

    @Test
    public void testDetermineBMICategory()
    {
        assertThat(under15.determineBMICategory().contains("VERY SEVERELY UNDERWEIGHT"), is(true));
        assertThat(equal15.determineBMICategory().contains("SEVERELY UNDERWEIGHT"), is(true));
        assertThat(equal16.determineBMICategory().contains("UNDERWEIGHT"), is(true));
        assertThat(below18point5.determineBMICategory().contains("UNDERWEIGHT"), is(true));
        assertThat(equal18point5.determineBMICategory().contains("NORMAL"), is(true));
        assertThat(below25.determineBMICategory().contains("NORMAL"), is(true));
        assertThat(equal25.determineBMICategory().contains("OVERWEIGHT"), is(true));
        assertThat(below30.determineBMICategory().contains("OVERWEIGHT"), is(true));
        assertThat(equal30.determineBMICategory().contains("MODERATELY OBESE"), is(true));
        assertThat(below35.determineBMICategory().contains("MODERATELY OBESE"), is(true));
        assertThat(equal35.determineBMICategory().contains("SEVERELY OBESE"), is(true));
        assertThat(below40.determineBMICategory().contains("SEVERELY OBESE"), is(true));       
        assertThat(equal40.determineBMICategory().contains("VERY SEVERELY OBESE"), is(true));  
    }

}
