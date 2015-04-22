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
		if (e.getClickCount() == 2) {
			System.out.println("double clicked");
			int n = JOptionPane.showConfirmDialog(
					frame1,
					"Mark item as done?",
					"Confirm Completion",
					JOptionPane.YES_NO_OPTION);
			if(n==0) {
				//DO THE UPDATE
				String item = list1.getSelectedValue().toString();
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
		clockLabel = new JLabel();
		panel2 = new JPanel();
		label1 = new JLabel();
		menuBar2 = new JMenuBar();
		label2 = new JLabel();

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


					//---- clockLabel ----
					clockLabel.setText(bundle.getString("MainForm.clockLabel.text"));

					GroupLayout panel1Layout = new GroupLayout(panel1);
					panel1.setLayout(panel1Layout);
					panel1Layout.setHorizontalGroup(
						panel1Layout.createParallelGroup()
							.addGroup(panel1Layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(clockLabel, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(379, Short.MAX_VALUE))
					);
					panel1Layout.setVerticalGroup(
						panel1Layout.createParallelGroup()
							.addGroup(panel1Layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(clockLabel, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
								.addContainerGap())
					);
				}
				tabbedPane1.addTab(bundle.getString("MainForm.panel1.tab.title"), panel1);

				//======== panel2 ========
				{

					//---- label1 ----
					label1.setText(bundle.getString("MainForm.label1.text"));

					GroupLayout panel2Layout = new GroupLayout(panel2);
					panel2.setLayout(panel2Layout);
					panel2Layout.setHorizontalGroup(
						panel2Layout.createParallelGroup()
							.addGroup(panel2Layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(label1, GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
								.addContainerGap())
					);
					panel2Layout.setVerticalGroup(
						panel2Layout.createParallelGroup()
							.addGroup(panel2Layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(label1, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
								.addContainerGap())
					);
				}
				tabbedPane1.addTab(bundle.getString("MainForm.panel2.tab.title"), panel2);
			}

			//======== menuBar2 ========
			{

				//---- label2 ----
				label2.setText(bundle.getString("MainForm.label2.text"));
				label2.setForeground(Color.gray);
				menuBar2.add(label2);
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
	private JLabel clockLabel;
	private JPanel panel2;
	private JLabel label1;
	private JMenuBar menuBar2;
	private JLabel label2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables

	public void setCreds(String[] credentials) {
		creds = credentials;
	}

	private void autoUpdateList() {
		// TODO add your code here

		setCreds(new String[] {"ian", "password"});
		System.out.println("STATE CHANGED TO "+autoUpdateCheckBox.getState());
		System.out.println("UPDATING");

		Client client = new Client();
		String[] result = client.getActiveOrderItems(creds,40);

		if(result[0].equals("1")) {
			String[] trimmedResult = Arrays.copyOfRange(result, 1, result.length);


			String[][] orderItems = new String[trimmedResult.length+1][4];
			int x = 0;
			for(int i = 0; trimmedResult.length>i; i=i+4) {
				orderItems[x][0] = trimmedResult[i];
				orderItems[x][1] = trimmedResult[i+1];
				orderItems[x][2] = trimmedResult[i+2];
				orderItems[x][3] = trimmedResult[i+3];
				x++;


			}

			//setTableItems(orderItems);
			setTableItems(trimmedResult);

		} else { //Error case
			System.err.println("ERROR!: "+result[0]+result[1]);
		}
	}

	private String makeListItem(String O_Id, String T_Id, String date, String item){

		String listItem = "<html><span><hr><span>"+
				"OID: "+O_Id+" TID: "+T_Id+" TIME: "+date+"<br>"+
				"<font size=+2>"+item+"</font>"
				+"</html>";

		return listItem;
	}

	private int getUpdateRate() {
		if(update1sRadioButton.isSelected()) {
			return 1;
		} else if(update2sRadioButton.isSelected()) {
			return 2;
		} else if(update5sRadioButton.isSelected()) {
			return 5;
		} else if(update10sRadioButton.isSelected()) {
			return 10;
		} else if(update30sRadioButton.isSelected()) {
			return 30;
		} else if(update1mRadioButton.isSelected()) {
			return 60;
		} else {
			return 10;
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


	public void setClockTime() {


	}
	public void setVisibility(boolean vis) {
		frame1.setVisible(vis);
	}
}
