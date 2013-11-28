package ex01_14;

import static org.junit.Assert.*;

import org.junit.Test;

public class WalkmanTest {

	@Test
	public void walkmanBaseTest() {
		Walkman walkman = new Walkman();
		walkman.playMusic();
		assertEquals("now playing (jack)", walkman.getJack());
	}

	@Test
	public void twoJacksWalkmanTest() {
		TwoJacksWalkman tjWalkman = new TwoJacksWalkman();
		tjWalkman.playMusic();
		assertEquals("now playing (jack)", tjWalkman.getJack());
		assertEquals("now playing (sub_jack)", tjWalkman.getSubjack());
	}
	
	@Test
	public void InteractiveWalkmanTest() {
		InteractiveWalkman iWalkman = new InteractiveWalkman();
		iWalkman.talk();
		assertEquals("now talking (jack)", iWalkman.getJack());
		assertEquals("now talking (sub_jack)", iWalkman.getSubjack());
	}
}
