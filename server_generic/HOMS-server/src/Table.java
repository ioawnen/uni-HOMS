/**
 * Created by Ian on 30/03/2015.
 *
 * Table Object Constructor
 */
final class Table {

	private final int T_Id;
	private final int Table_Number;
	private final String Table_Description;
	private final int Table_Available;
	private final int Table_Seats;

	public Table(int tid, int tableNumber, String tableDescription, int tableAvailable, int tableSeats) {
		this.T_Id = tid;
		this.Table_Number = tableNumber;
		this.Table_Description = tableDescription;
		this.Table_Available = tableAvailable;
		this.Table_Seats = tableSeats;
	}

	public int getT_Id() {
		return T_Id;
	}

	public int getTable_Number() {
		return Table_Number;
	}

	public String getTable_Description() {
		return Table_Description;
	}

	public int getTable_Available() {
		return Table_Available;
	}

	public int getTable_Seats() {
		return Table_Seats;
	}
}
