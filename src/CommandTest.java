import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CommandTest {
	private final static String GOOD_FIRST_WORD = "go";
	private final static String GOOD_SECOND_WORD = "north";
	private final static String BAD_FIRST_WORD = "aslkfawjma";
	private final static String BAD_SECOND_WORD = "sadkjwnm";
	
	private Command good;
	private Command noSecond;
	private Command bad1;
	private Command bad2;
	private Command bad3;
	
	@Before
	public void setUp() throws Exception {
		good = new Command(GOOD_FIRST_WORD,GOOD_SECOND_WORD);
		noSecond = new Command(GOOD_FIRST_WORD,null);
		bad1 = new Command(BAD_FIRST_WORD,GOOD_SECOND_WORD);
		bad2 = new Command(GOOD_FIRST_WORD,BAD_SECOND_WORD);
		bad3 = new Command(null,null);
	}


	@Test
	public void testGetCommandWord() {
		assertEquals("Command word should be "+GOOD_FIRST_WORD+".", GOOD_FIRST_WORD, good.getCommandWord());
		assertEquals("Command word should be "+GOOD_FIRST_WORD+".", GOOD_FIRST_WORD, noSecond.getCommandWord());
		assertEquals("Command word should be "+BAD_FIRST_WORD+".", BAD_FIRST_WORD, bad1.getCommandWord());
		assertEquals("Command word should be "+GOOD_FIRST_WORD+".", GOOD_FIRST_WORD, bad2.getCommandWord());
		assertEquals("Command word should be "+null+".", null, bad3.getCommandWord());
	}

	@Test
	public void testGetSecondWord() {
		assertEquals("Second word should be "+GOOD_SECOND_WORD+".", GOOD_SECOND_WORD, good.getSecondWord());
		assertEquals("Second word should be "+null+".", null, noSecond.getSecondWord());
		assertEquals("Second word should be "+GOOD_SECOND_WORD+".", GOOD_SECOND_WORD, bad1.getSecondWord());
		assertEquals("Second word should be "+BAD_SECOND_WORD+".", BAD_SECOND_WORD, bad2.getSecondWord());
		assertEquals("Second word should be "+null+".", null, bad3.getSecondWord());
	}

	@Test
	public void testHasSecondWord() {
		assertEquals("Should return true.", true, good.hasSecondWord());
		assertEquals("Should return false.", false, noSecond.hasSecondWord());
		assertEquals("Should return true.", true, bad1.hasSecondWord());
		assertEquals("Should return true.", true, bad2.hasSecondWord());
		assertEquals("Should return false.", false, bad3.hasSecondWord());
		}

}
