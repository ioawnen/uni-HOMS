

/**
 * Created by Ian on 30/03/2015.
 *
 * Order Item Object Constructor
 */
final class OrderItem {

	private final int O_Id;
	private final int I_Id;
	private final int Time; //This needs looking into. Store in unix time for now.
	private final int Is_Active;

	public OrderItem(int oid, int iid, int time, int isActive) {
		this.O_Id = oid;
		this.I_Id = iid;
		this.Time = time;
		this.Is_Active = isActive;
	}

	public int getO_Id() {
		return O_Id;
	}

	public int getI_Id() {
		return I_Id;
	}

	public int getTime() {
		return Time;
	}

	public int getIs_Active() {
		return Is_Active;
	}
}
