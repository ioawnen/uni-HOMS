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
 *  PROVIDE AN ARRAY. MAKE IT NEAT.
 *
 */
final class DbDataReturn {
	private final String return_code;
	private final String[] return_strings;

	public DbDataReturn(String code, String[] strings) {
		this.return_code = code;
		this.return_strings = strings;

	}

	public String getReturn_code() {
		return return_code;
	}

	public String[] getReturn_strings() {
		return return_strings;
	}
}
