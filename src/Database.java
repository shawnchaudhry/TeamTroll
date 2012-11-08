import java.util.*;

public class Database {
	private static ArrayList<UserAccount> accounts;

	public Database() {
		accounts = new ArrayList<UserAccount>();
	}

	public static void addAccount(UserAccount acc) {
		accounts.add(acc);
	}

	public static boolean checkAccount(UserAccount acc) {
		return accounts.contains(acc);
	}

	public static void printAccounts() {
		for(UserAccount ua : accounts) 
			System.out.println(ua);
	}
}
