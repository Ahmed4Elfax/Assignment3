package eg.edu.alexu.csd.datastructure.iceHockey;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.Point;
import org.junit.jupiter.api.Test;

class IceHockeyTest {

	@Test
	void test1() {
		IPlayerFinder playersFinder = new IceHockey();
	    String[] a = {"", "", "", "", "", ""};
	    Point[] answer = new Point[] {};
	    Integer team = 1;
	    Integer threashold = 1;
	    Point[] result = playersFinder.findPlayers(a, team, threashold);
	    assertArrayEquals(answer, result);	
	}
	@Test
	void test2() {
		IPlayerFinder playersFinder = new IceHockey();
		String[] a={"33JUBU33","3U3O4433","O33P44NB","PO3NSDP3","VNDSD333","OINFD33X"};
		Point[] answer = new Point[] {new Point(4, 5), new Point(13,9 ),
                new Point(14,2 )};
		 Point[] result = playersFinder.findPlayers(a,3, 16);
		 assertArrayEquals(answer, result);
	}
	@Test
	void test3() {
	   IPlayerFinder playersFinder = new IceHockey();
		String[] a={"44444H44S4","K444K4L444","4LJ44T44XH","444O4VIF44","44C4D4U444","4V4Y4KB4M4","G4W4HP4O4W",
				    "4444ZDQ4S4","4BR4Y4A444","4G4V4T4444"};
		Point[] answer = new Point[] {new Point(3,8), new Point(4,16),
                new Point(5,4),new Point(16,3),new Point(16,17),new Point(17,9)};
		 Point[] result = playersFinder.findPlayers(a,4, 16);
		 assertArrayEquals(answer, result);	
	}
	
	@Test
	void test4() {
		 IPlayerFinder playersFinder = new IceHockey();
		String[] a={"11111","1AAA1","1A1A1","1AAA1","11111"};
         Point[] answer = new Point[] {new Point(5,5), new Point(5,5)};
		 Point[] result = playersFinder.findPlayers(a,1,3);
		 assertArrayEquals(answer, result);	
	}
}
