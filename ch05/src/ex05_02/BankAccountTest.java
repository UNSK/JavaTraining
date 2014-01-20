package ex05_02;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {
	BankAccount test_account;
	BankAccount ba2;

	@Before
	public void setUp() throws Exception {
		test_account = new BankAccount(1234, 1000);
	}

	@Test
	public void depositTest() {
		test_account.deposit(500);
		assertThat(test_account.getBalance(), is(1500L));
	}
	
	@Test
	public void withdrawTest() {
		test_account.withdraw(500);
		assertThat(test_account.getBalance(), is(500L));
	}
	
	@Test
	public void fetchNoneHistoryTest() {
		assertNull(test_account.history().next()); //　Actionはnullのはず
	}
	
	@Test
	public void fetchHistoryTest() {
		test_account.deposit(300);
		assertThat(test_account.history().next().toString(), is("1234: deposit 300"));
		for (int i = 0; i < 11; i++) { // 11回操作する
			test_account.deposit(i);
		}
		for (int i = 0; i < 10; i++) { // 10回取り出す（目視用に表示）
			System.out.println(test_account.history().next());
		}
		// 10個までしか保存されないため、11回目はnullのはず
		assertNull(test_account.history().next());
	}

}
