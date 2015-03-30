/**
 * Created by Ian on 30/03/2015.
 *
 * Used by database calls to return all dem errors.
 * Only two things to return, super generic for the simplest calls.
 *
 * RETURN CODE GUIDELINES:
 *  1 = TRUE
 *  0 = FALSE
 *  -1 = ERROR
 *  -2 = ERROR
 *  -3 = YOU GET THE IDEA
 *
 * RETURN STRING GUIDELINES:
 *  Give a reason for failure, or just add useful information here.
 *
 */
final class DbGenericReturn {
	private final String return_code;
	private final String return_string;

	public DbGenericReturn(String code, String string) {
		this.return_code = code;
		this.return_string = string;

	}

	public String getReturn_code() {
		return return_code;
	}

	public String getReturn_string() {
		return return_string;
	}
}
