package ex05_02;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 5.2 口座に対する最後の10個の処理を記録する
 */
public class BankAccount {
	/** 口座番号 */
	private long number_;
	/** 残高（セント） */
	private long balance_;
	/** 処理履歴　*/
	private History history_ = new History();
	/** 処理の記録件数 */
	private static final int HISTORY_SIZE = 10;
	
	/**
	 * @param number 口座番号
	 * @param balance 残高
	 */
	public BankAccount(long number, long balance) {
		this.number_ = number;
		this.balance_ = balance;
	}
	
	/** 処理内容を表すクラス */
	public class Action {
		/** 処理内容 */
		private String act_;
		/** 操作した金額 */
		private long amount_;
		/**
		 *  処理内容と金額を記録する 
		 *  @param act 処理内容
		 *  @param amount 操作した金額
		 */
		public Action(String act, long amount) {
			this.act_ = act;
			this.amount_ = amount;
		}
		@Override
		public String toString() {
			return number_ + ": " + act_ + " " + amount_;
		}
	}
	
	/** 処理を記録するクラス */
	public class History {
		/** 処理を保存する両端キュー。LIFOで運用する */
		private Deque<Action> history_deque_ = new LinkedList<>();
		
		/** 
		 * 直近のActionを取り出す 
		 * @return 最新の処理、空ならばnull
		 */
		public Action next() {
			return history_deque_.pollFirst();
		}
		
		/**
		 * Actionを追加する。記録件数を上回った場合、最後の要素を削除する
		 * @param action 追加するAction
		 */
		public void add(Action action) {
			history_deque_.addFirst(action);
			if (history_deque_.size() > HISTORY_SIZE) { //　容量オーバ
				history_deque_.removeLast();
			}
		}
	}
	
	/**
	 * 預入
	 * @param amount 預金額
	 */
	public void deposit(long amount) {		
		balance_ += amount;
		history_.add(new Action("deposit", amount));
	}
	
	/**
	 * 引出
	 * @param amount 引出額
	 */
	public void withdraw(long amount) {
		balance_ -= amount;
		history_.add(new Action("withdraw", amount));
	}

	/**
	 * @return Historyオブジェクト
	 */
	public History history() {
		return this.history_;
	}

	/**
	 * @return the balance_
	 */
	public long getBalance() {
		return balance_;
	}
}
