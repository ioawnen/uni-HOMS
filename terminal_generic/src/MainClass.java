/**
 * Created by Ian on 14/04/2015.
 */
public class MainClass {

	public static void main(String[] args){
		System.out.println("STARTING");
		MainForm form = new MainForm();
		form.setCreds(new String[] {"ian", "********"});
		form.updateItems();
		form.setVisibility(true);
		System.out.println("STARTED");
	}
}
