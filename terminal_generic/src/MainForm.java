import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.event.*;
import java.lang.Thread;
/*
 * Created by JFormDesigner on Tue Apr 14 14:56:34 BST 2015
 */



/**
 * @author unknown
 */
public class MainForm extends JPanel {

	String[] creds;
	String[][] items;
	String url;
	public MainForm() {
		initComponents();
	}

	private void list1ValueChanged(ListSelectionEvent e) {
		// TODO add your code here
	}

	private void autoUpdateCheckBoxActionPerformed(ActionEvent e) {
		// TODO add your code here
		autoUpdateList();
	}

	private void onListMouseClicked(MouseEvent e) {
		// TODO add your code here

		//Get the Order ID, Item ID. //TODO MOVE THIS TO A SEPARATE METHOD
		String item = list1.getSelectedValue().toString();
		String[] item_part1 = item.split("IID: ");
		String[] item_part2 = item_part1[1].split(" ");
		String item_id = item_part2[0];

		String[] item_part3 = item.split("OID: ");
		String[] item_part4 = item_part3[1].split(" ");
		String order_id = item_part4[0];

		System.out.println(order_id+" "+item_id);

		setInfoText(item_id);



		if (e.getClickCount() == 2) {
			System.out.println("double clicked");
			int n = JOptionPane.showConfirmDialog(
					frame1,
					"Mark item as done?",
					"Confirm Completion",
					JOptionPane.YES_NO_OPTION);
			if(n==0) {
				//DO THE UPDATE
				Client client = new Client();
				String[] result = client.modifyOrderItem(creds, Integer.parseInt(order_id), Integer.parseInt(item_id), 0); //Set the order as inactive (completed)
				autoUpdateList();

				if(!result[0].equals("1")) {
					JOptionPane.showMessageDialog(frame1, "Error!");
				}
			}
		}
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Ian Owen
		ResourceBundle bundle = ResourceBundle.getBundle("mainform_strings");
		frame1 = new JFrame();
		menuBar1 = new JMenuBar();
		menu1 = new JMenu();
		autoUpdateCheckBox = new JCheckBoxMenuItem();
		menu2 = new JMenu();
		update1sRadioButton = new JRadioButtonMenuItem();
		update2sRadioButton = new JRadioButtonMenuItem();
		update5sRadioButton = new JRadioButtonMenuItem();
		update10sRadioButton = new JRadioButtonMenuItem();
		update30sRadioButton = new JRadioButtonMenuItem();
		update1mRadioButton = new JRadioButtonMenuItem();
		darkModeCheckBox = new JCheckBoxMenuItem();
		scrollPane2 = new JScrollPane();
		list1 = new JList();
		tabbedPane1 = new JTabbedPane();
		panel1 = new JPanel();
		infoLabel = new JLabel();
		menuBar2 = new JMenuBar();
		statusLabel = new JLabel();

		//======== frame1 ========
		{
			Container frame1ContentPane = frame1.getContentPane();

			//======== menuBar1 ========
			{

				//======== menu1 ========
				{
					menu1.setText(bundle.getString("MainForm.menu1.text"));

					//---- autoUpdateCheckBox ----
					autoUpdateCheckBox.setText(bundle.getString("MainForm.autoUpdateCheckBox.text"));
					autoUpdateCheckBox.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							autoUpdateCheckBoxActionPerformed(e);
						}
					});
					menu1.add(autoUpdateCheckBox);

					//======== menu2 ========
					{
						menu2.setText(bundle.getString("MainForm.menu2.text"));

						//---- update1sRadioButton ----
						update1sRadioButton.setText(bundle.getString("MainForm.update1sRadioButton.text"));
						menu2.add(update1sRadioButton);

						//---- update2sRadioButton ----
						update2sRadioButton.setText(bundle.getString("MainForm.update2sRadioButton.text"));
						menu2.add(update2sRadioButton);

						//---- update5sRadioButton ----
						update5sRadioButton.setText(bundle.getString("MainForm.update5sRadioButton.text"));
						menu2.add(update5sRadioButton);

						//---- update10sRadioButton ----
						update10sRadioButton.setText(bundle.getString("MainForm.update10sRadioButton.text"));
						menu2.add(update10sRadioButton);

						//---- update30sRadioButton ----
						update30sRadioButton.setText(bundle.getString("MainForm.update30sRadioButton.text"));
						menu2.add(update30sRadioButton);

						//---- update1mRadioButton ----
						update1mRadioButton.setText(bundle.getString("MainForm.update1mRadioButton.text"));
						menu2.add(update1mRadioButton);
					}
					menu1.add(menu2);

					//---- darkModeCheckBox ----
					darkModeCheckBox.setText(bundle.getString("MainForm.darkModeCheckBox.text"));
					menu1.add(darkModeCheckBox);
				}
				menuBar1.add(menu1);
			}
			frame1.setJMenuBar(menuBar1);

			//======== scrollPane2 ========
			{

				//---- list1 ----
				list1.addListSelectionListener(new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						list1ValueChanged(e);
					}
				});
				list1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						onListMouseClicked(e);
					}
				});
				scrollPane2.setViewportView(list1);
			}

			//======== tabbedPane1 ========
			{

				//======== panel1 ========
				{

					// JFormDesigner evaluation mark
					panel1.setBorder(new javax.swing.border.CompoundBorder(
						new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
							"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
							javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
							java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


					//---- infoLabel ----
					infoLabel.setText(bundle.getString("MainForm.infoLabel.text"));

					GroupLayout panel1Layout = new GroupLayout(panel1);
					panel1.setLayout(panel1Layout);
					panel1Layout.setHorizontalGroup(
						panel1Layout.createParallelGroup()
							.addGroup(panel1Layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(infoLabel, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(377, Short.MAX_VALUE))
					);
					panel1Layout.setVerticalGroup(
						panel1Layout.createParallelGroup()
							.addGroup(panel1Layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(infoLabel, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
								.addContainerGap())
					);
				}
				tabbedPane1.addTab(bundle.getString("MainForm.panel1.tab.title"), panel1);
			}

			//======== menuBar2 ========
			{

				//---- statusLabel ----
				statusLabel.setText(bundle.getString("MainForm.statusLabel.text"));
				statusLabel.setForeground(Color.gray);
				menuBar2.add(statusLabel);
			}

			GroupLayout frame1ContentPaneLayout = new GroupLayout(frame1ContentPane);
			frame1ContentPane.setLayout(frame1ContentPaneLayout);
			frame1ContentPaneLayout.setHorizontalGroup(
				frame1ContentPaneLayout.createParallelGroup()
					.addComponent(menuBar2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(frame1ContentPaneLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(frame1ContentPaneLayout.createParallelGroup()
							.addComponent(tabbedPane1)
							.addComponent(scrollPane2))
						.addContainerGap())
			);
			frame1ContentPaneLayout.setVerticalGroup(
				frame1ContentPaneLayout.createParallelGroup()
					.addGroup(frame1ContentPaneLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(menuBar2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
			);
			frame1.pack();
			frame1.setLocationRelativeTo(frame1.getOwner());
		}

		//---- updateRateButtonGroup ----
		ButtonGroup updateRateButtonGroup = new ButtonGroup();
		updateRateButtonGroup.add(update1sRadioButton);
		updateRateButtonGroup.add(update2sRadioButton);
		updateRateButtonGroup.add(update5sRadioButton);
		updateRateButtonGroup.add(update10sRadioButton);
		updateRateButtonGroup.add(update30sRadioButton);
		updateRateButtonGroup.add(update1mRadioButton);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Ian Owen
	private JFrame frame1;
	private JMenuBar menuBar1;
	private JMenu menu1;
	private JCheckBoxMenuItem autoUpdateCheckBox;
	private JMenu menu2;
	private JRadioButtonMenuItem update1sRadioButton;
	private JRadioButtonMenuItem update2sRadioButton;
	private JRadioButtonMenuItem update5sRadioButton;
	private JRadioButtonMenuItem update10sRadioButton;
	private JRadioButtonMenuItem update30sRadioButton;
	private JRadioButtonMenuItem update1mRadioButton;
	private JCheckBoxMenuItem darkModeCheckBox;
	private JScrollPane scrollPane2;
	private JList list1;
	private JTabbedPane tabbedPane1;
	private JPanel panel1;
	private JLabel infoLabel;
	private JMenuBar menuBar2;
	private JLabel statusLabel;
	// JFormDesigner - End of variables declaration  //GEN-END:variables

	public void setCreds(String[] credentials) {
		creds = credentials;
	}
	private boolean intToBool(int i) {
		if(i==1){
			return true;
		}
		else {
			return false;
		}
	}

	private void autoUpdateList() {
		// TODO add your code here

		new Thread(new Runnable() {
			public void run() {

				while(autoUpdateCheckBox.getState()) {

					System.out.println("REFRESH STATE " + autoUpdateCheckBox.getState());
					System.out.println("UPDATING");

					Client client = new Client();
					client.setURL(url);
					String[] result = client.getActiveOrderItems(creds, 40);

					if (result[0].equals("1")) {
						String[] trimmedResult = Arrays.copyOfRange(result, 1, result.length);


						String[][] orderItems = new String[trimmedResult.length + 1][4];
						int x = 0;
						for (int i = 0; trimmedResult.length > i; i = i + 4) {
							orderItems[x][0] = trimmedResult[i];
							orderItems[x][1] = trimmedResult[i + 1];
							orderItems[x][2] = trimmedResult[i + 2];
							orderItems[x][3] = trimmedResult[i + 3];
							x++;
						}

						//setTableItems(orderItems);
						setTableItems(trimmedResult);
					} else { //Error case
						System.err.println("ERROR!: " + result[0] + result[1]);
					}

					try {
						Thread.sleep(getUpdateRate());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	public void updateItems() {

		Client client = new Client();
		client.setURL(url);
		String[] result = client.getItems(creds);
		System.out.println("1");
		if(result[0].equals("1")) {
			String[] trimmedResult = Arrays.copyOfRange(result, 1, result.length);
			items = new String[trimmedResult.length][8];

			int x = 0;
			for(int i = 0; trimmedResult.length>i; i=i+8) {

				System.out.println(x+" "+i);
				items[x][0] = trimmedResult[i];
				items[x][1] = trimmedResult[i+1];
				items[x][2] = trimmedResult[i+2];
				items[x][3] = trimmedResult[i+3];
				items[x][4] = trimmedResult[i+4];
				items[x][5] = trimmedResult[i+5];
				items[x][6] = trimmedResult[i+6];
				items[x][7] = trimmedResult[i+7];
				x++;
			}
		}
	}

	private String makeListItem(String O_Id, String T_Id, String date, String item){ //TODO: NEEDS VALIDATION

		//Firstly, get the item info from the ID.

		String[] itemData = new String[8];
		for(int j = 0; j < items[0].length; j++) {
			if(items[j][0].equals(item)) {
				itemData[0] = items[j][0];
				itemData[1] = items[j][1];
				itemData[2] = items[j][2];
				itemData[3] = items[j][3];
				itemData[4] = items[j][4];
				itemData[5] = items[j][5];
				itemData[6] = items[j][6];
				itemData[7] = items[j][7];
				break;
			}
		}

		//Assemble the String (HTML for styling)

		String listItem = "<html><span><hr><span>"+
				"OID: "+O_Id+" IID: "+itemData[0]+" TID: "+T_Id+" TIME: "+date+"<br>"+
				"<font size=+2>"+itemData[1]+"</font>"
				+"</html>";

		return listItem;
	}
	private void setInfoText(String item) {


		String[] itemData = new String[8];
		for(int j = 0; j < items[0].length; j++) {
			if(items[j][0].equals(item)) {
				itemData[0] = items[j][0]; //ID
				itemData[1] = items[j][1]; //Name
				itemData[2] = items[j][2]; //Description
				itemData[3] = items[j][3]; //Price
				itemData[4] = items[j][4]; //IsAvailable
				itemData[5] = items[j][5]; //IsVegetarian
				itemData[6] = items[j][6]; //IsVegan
				itemData[7] = items[j][7]; //IsSpicy
				break;
			}
		}

		String infoText = "<html>"+
				"Item Name:   "+itemData[1]+"<br>"+
				"Description: "+itemData[2]+"<br>"+
				"Price:       "+itemData[3]+"<br>"+
				"Available:   "+itemData[4]+"<br>"+
				"Vegetarian:  "+itemData[5]+"<br>"+
				"Vegan:       "+itemData[6]+"<br>"+
				"Spicy:       "+itemData[7]+
				"</html>";

		infoLabel.setText(infoText);

	}

	private int getUpdateRate() {
		if(update1sRadioButton.isSelected()) {
			return 1000;
		} else if(update2sRadioButton.isSelected()) {
			return 2000;
		} else if(update5sRadioButton.isSelected()) {
			return 5000;
		} else if(update10sRadioButton.isSelected()) {
			return 10000;
		} else if(update30sRadioButton.isSelected()) {
			return 30000;
		} else if(update1mRadioButton.isSelected()) {
			return 60000;
		} else {
			return 10000; //no config default
		}

	}

	public void setTableItems(String[] orders) {

		String[] orderText = new String[orders.length/4];
		int x = 0;
		for(int i = 0; i<orders.length; i+=4) {
			orderText[x] = makeListItem(orders[i], orders[i+1], orders[i+2], orders[+3]);
			x++;
		}
		list1.setListData(orderText);

	}

	public void setCreds(String username, String password) {
		creds = new String[] {username, password};
	}
	public void setURL(String URL) {
		url = URL;
	}

	public void setClockTime() {
	//TODO: Implement real time clock
	}

	public void setVisibility(boolean vis) {
		frame1.setVisible(vis);
	}
}
