/**
 * Created by Ian on 30/03/2015.
 *
 * Used by database calls to return all dem errors.
 * Only two things to return, super generic for the simplest calls.
 */
final class DbGenericReturn {
	private final int return_code;
	private final String return_string;

	public DbGenericReturn(int code, String string) {
		this.return_code = code;
		this.return_string = string;

	}

	public int getReturn_code() {
		return return_code;
	}

	public String getReturn_string() {
		return return_string;
	}
}
