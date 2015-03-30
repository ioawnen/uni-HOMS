/**
 * Created by Ian on 30/03/2015.
 *
 * User Object Constructor
 */
final class User {

	private final int U_Id;
	private final String Username;
	private final String Password;
	private final int Is_Active;
	private final int Is_Admin;
	private final int Employee_Number;
	private final String First_Name;
	private final String Last_Name;


	public User(int uid, String username, String password, int isActive, int isAdmin, int employeeNumber, String firstName, String lastName) {
		this.U_Id = uid;
		this.Username = username;
		this.Password = password;
		this.Is_Active = isActive;
		this.Is_Admin = isAdmin;
		this.Employee_Number = employeeNumber;
		this.First_Name = firstName;
		this.Last_Name = lastName;

	}

	public int getU_Id() {
		return U_Id;
	}

	public String getUsername() {
		return Username;
	}

	public String getPassword() {
		return Password;
	}

	public int getIs_Active() {
		return Is_Active;
	}

	public int getIs_Admin() {
		return Is_Admin;
	}

	public int getEmployee_Number() {
		return Employee_Number;
	}

	public String getFirst_Name() {
		return First_Name;
	}

	public String getLast_Name() {
		return Last_Name;
	}
}
