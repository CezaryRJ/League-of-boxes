import teammgmt.Rooster;
import teammgmt.Team;
import testdummy.testdummy;
import BladeMaster.BladeMaster;
import Xerath.Xerath;

public class test {

	public static void main(String[] args) {

		Xerath xerath = new Xerath();

		testdummy test = new testdummy();
		BladeMaster yi = new BladeMaster();
		
		Rooster t = new Rooster();
	Team ting = new Team("ting");
	
	ting.addchamp(t.getchamp(0));
	ting.addchamp(t.getchamp(3));
	
		
	}
}
