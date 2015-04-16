import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.event.*;
/*
 * Created by JFormDesigner on Tue Apr 14 14:56:34 BST 2015
 */



/**
 * @author unknown
 */
public class MainForm extends JPanel {
	public MainForm() {
		initComponents();
	}

	private void list1ValueChanged(ListSelectionEvent e) {
		// TODO add your code here
	}



	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Ian Owen
		ResourceBundle bundle = ResourceBundle.getBundle("mainform_strings");
		frame1 = new JFrame();
		menuBar1 = new JMenuBar();
		menu1 = new JMenu();
		menu2 = new JMenu();
		radioButtonMenuItem1 = new JRadioButtonMenuItem();
		radioButtonMenuItem2 = new JRadioButtonMenuItem();
		radioButtonMenuItem3 = new JRadioButtonMenuItem();
		radioButtonMenuItem4 = new JRadioButtonMenuItem();
		radioButtonMenuItem5 = new JRadioButtonMenuItem();
		radioButtonMenuItem6 = new JRadioButtonMenuItem();
		checkBoxMenuItem1 = new JCheckBoxMenuItem();
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

					//======== menu2 ========
					{
						menu2.setText(bundle.getString("MainForm.menu2.text"));

						//---- radioButtonMenuItem1 ----
						radioButtonMenuItem1.setText(bundle.getString("MainForm.radioButtonMenuItem1.text"));
						menu2.add(radioButtonMenuItem1);

						//---- radioButtonMenuItem2 ----
						radioButtonMenuItem2.setText(bundle.getString("MainForm.radioButtonMenuItem2.text"));
						menu2.add(radioButtonMenuItem2);

						//---- radioButtonMenuItem3 ----
						radioButtonMenuItem3.setText(bundle.getString("MainForm.radioButtonMenuItem3.text"));
						menu2.add(radioButtonMenuItem3);

						//---- radioButtonMenuItem4 ----
						radioButtonMenuItem4.setText(bundle.getString("MainForm.radioButtonMenuItem4.text"));
						menu2.add(radioButtonMenuItem4);

						//---- radioButtonMenuItem5 ----
						radioButtonMenuItem5.setText(bundle.getString("MainForm.radioButtonMenuItem5.text"));
						menu2.add(radioButtonMenuItem5);

						//---- radioButtonMenuItem6 ----
						radioButtonMenuItem6.setText(bundle.getString("MainForm.radioButtonMenuItem6.text"));
						menu2.add(radioButtonMenuItem6);
					}
					menu1.add(menu2);

					//---- checkBoxMenuItem1 ----
					checkBoxMenuItem1.setText(bundle.getString("MainForm.checkBoxMenuItem1.text"));
					menu1.add(checkBoxMenuItem1);
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
						.addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
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
		updateRateButtonGroup.add(radioButtonMenuItem1);
		updateRateButtonGroup.add(radioButtonMenuItem2);
		updateRateButtonGroup.add(radioButtonMenuItem3);
		updateRateButtonGroup.add(radioButtonMenuItem4);
		updateRateButtonGroup.add(radioButtonMenuItem5);
		updateRateButtonGroup.add(radioButtonMenuItem6);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Ian Owen
	private JFrame frame1;
	private JMenuBar menuBar1;
	private JMenu menu1;
	private JMenu menu2;
	private JRadioButtonMenuItem radioButtonMenuItem1;
	private JRadioButtonMenuItem radioButtonMenuItem2;
	private JRadioButtonMenuItem radioButtonMenuItem3;
	private JRadioButtonMenuItem radioButtonMenuItem4;
	private JRadioButtonMenuItem radioButtonMenuItem5;
	private JRadioButtonMenuItem radioButtonMenuItem6;
	private JCheckBoxMenuItem checkBoxMenuItem1;
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

	private String makeListItem(String O_Id, String T_Id, String item){

		String listItem = "<html><span><hr><span>"+
				"OID: "+O_Id+" TID: "+T_Id+"<br>"+
				"<font size=+2>"+item+"</font>"





				+"</html>";


		return listItem;
	}


	public void setTableItems() {

		String[][] orders = new String[][] {{"13546","34","SOME FOOD THAT'S NICE"},{"dfirh","dfihjbd","SMOKED SOMETHING"}};

		String[] orderText = new String[orders.length];

		for(int i = 0; i<orders.length; i++) {
			orderText[i] = makeListItem(orders[i][0],orders[i][1],orders[i][2]);
		}
		list1.setListData(orderText);



	}

	public void setClockTime() {


	}
	public void setVisibility(boolean vis) {
		frame1.setVisible(vis);
	}
}
