/**
 * Created by Ian on 30/03/2015.
 *
 * Order Object Constructor
 */
final class Order {

	private final int O_Id;
	private final int U_Id;
	private final int T_Id;

	public Order(int oid, int uid, int tid) {
		this.O_Id = oid;
		this.U_Id = uid;
		this.T_Id = tid;
	}

	public int getO_Id() {
		return O_Id;
	}

	public int getU_Id() {
		return U_Id;
	}

	public int getT_Id() {
		return T_Id;
	}

}
