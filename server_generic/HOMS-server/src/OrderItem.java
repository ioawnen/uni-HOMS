

/**
 * Created by Ian on 30/03/2015.
 *
 * Order Item Object Constructor
 */
final class OrderItem {

	private final String O_Id;
	private final String I_Id;
	private final String Time; //This needs looking Stringo. Store in unix time for now.
	private final String Is_Active;

	public OrderItem(String oid, String iid, String time, String isActive) {
		this.O_Id = oid;
		this.I_Id = iid;
		this.Time = time;
		this.Is_Active = isActive;
	}

	public String getO_Id() {
		return O_Id;
	}

	public String getI_Id() {
		return I_Id;
	}

	public String getTime() {
		return Time;
	}

	public String getIs_Active() {
		return Is_Active;
	}
}
