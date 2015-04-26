import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.factories.*;
/*
 * Created by JFormDesigner on Tue Apr 14 16:07:44 BST 2015
 */



/**
 * @author Ian Owen
 */
public class MainForm extends JPanel {
	private String[] creds = new String[2];

	public MainForm() {
		initComponents();
	}

	private void usersTableMouseClicked(MouseEvent e) {
		// TODO add your code here

	}

	private void usersTablePropertyChange(PropertyChangeEvent e) {
		// TODO add your code here
		System.out.println("users table property change");
		try {

			//Get the row that was changed.
			int rowIndex = usersTable.getSelectedRow();
			String uid = (String) usersTable.getModel().getValueAt(rowIndex, 0);
			String username = (String) usersTable.getModel().getValueAt(rowIndex, 1);
			String password = (String) usersTable.getModel().getValueAt(rowIndex, 2);
			String isActive = (String) usersTable.getModel().getValueAt(rowIndex, 3);
			String isAdmin = (String) usersTable.getModel().getValueAt(rowIndex, 4);
			String employeeNumber = (String) usersTable.getModel().getValueAt(rowIndex, 5);
			String firstName = (String) usersTable.getModel().getValueAt(rowIndex, 6);
			String lastName = (String) usersTable.getModel().getValueAt(rowIndex, 7);

			//Send the modifications!
			String[] result = new Client().modifyUser(
					creds,
					Integer.parseInt(uid),
					username,
					password,
					Integer.parseInt(isActive),
					Integer.parseInt(isAdmin),
					Integer.parseInt(employeeNumber),
					firstName,
					lastName);

			if (!result[0].equals("1")) {
				JOptionPane.showMessageDialog(frame1, "<html>Error!<br>Error Code: " + result[0] + "<br>Message: " + result[1] + "</html>");
				return;
			} else if (result[0].equals("1")) {
				//Everything was great case. Generally do nothing.
				System.out.println("USER MODIFY SUCCESS!");
			}
		}
		catch (ArrayIndexOutOfBoundsException ex){
			System.err.println("THIS SEEMS BAD IF IT KEEPS HAPPENING");
		}
		finally {
			updateUserTable();
		}


	}

	private void userInputAddNewButtonActionPerformed(ActionEvent e) {
		// TODO add your code here
		System.out.println("ADD USER BUTTON PRESS!");

		String username = userInputUsernameField.getText();
		String password = userInputPasswordField.getPassword().toString();
		int isActive = boolToInt(userInputActiveCheckBox.isSelected());
		int isAdmin = boolToInt(userInputAdminCheckBox.isSelected());
		int employeeNumber = Integer.parseInt(userInputEmployeeNoField.getText());
		String firstName = userInputFirstNameField.getText();
		String lastName = userInputLastNameField.getToolTipText();

		int confirmation = JOptionPane.showConfirmDialog(frame1, "CONFIRM? TODO: MAKE THIS SHOW THE INFO");

		if(confirmation==0) {
			String[] result = new Client().addUser(creds, username, password, isActive, isAdmin, employeeNumber, firstName, lastName);

			if(!result[0].equals("1")) {
				JOptionPane.showMessageDialog(frame1, "<html>Error!<br>Error Code: " + result[0] + "<br>Message: " + result[1] + "</html>");
				return;
			}

			clearUserFields();

		}

	}

	private void userInputClearButtonActionPerformed(ActionEvent e) {
		clearUserFields();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Ian Owen
		ResourceBundle bundle = ResourceBundle.getBundle("mainform_strings");
		frame1 = new JFrame();
		menuBar1 = new JMenuBar();
		tabbedPane1 = new JTabbedPane();
		overviewPanel = new JPanel();
		income24hPanel = new JPanel();
		income24hLabel = new JLabel();
		income7dPanel = new JPanel();
		income7dLabel = new JLabel();
		income28dPanel = new JPanel();
		income28dLabel = new JLabel();
		itemsTodayPanel = new JPanel();
		itemsTodayLabel = new JLabel();
		tablesTodayPanel = new JPanel();
		tablesTodayLabel = new JLabel();
		ordersInProgPanel = new JPanel();
		ordersInProgLabel = new JLabel();
		ordersTodayPanel = new JPanel();
		ordersTodayLabel = new JLabel();
		averageIncomeDailyPanel = new JPanel();
		averageIncomeDailyLabel = new JLabel();
		ordersInProgPanel2 = new JPanel();
		ordersInProgLabel2 = new JLabel();
		ordersInProgPanel3 = new JPanel();
		ordersInProgLabel3 = new JLabel();
		manageUsersPanel = new JPanel();
		usersScrollPane = new JScrollPane();
		usersTable = new JTable();
		userInputPanel = new JPanel();
		userInputUsernameLabel = new JLabel();
		userInputPasswordLabel = new JLabel();
		userInputEmployeeNoLabel = new JLabel();
		userInputFirstNameLabel = new JLabel();
		userInputLastNameLabel = new JLabel();
		userInputUsernameField = new JTextField();
		userInputEmployeeNoField = new JTextField();
		userInputFirstNameField = new JTextField();
		userInputLastNameField = new JTextField();
		userInputAddNewButton = new JButton();
		userInputUserIdLabel = new JLabel();
		userInputUserIdField = new JTextField();
		userInputActiveCheckBox = new JCheckBox();
		userInputAdminCheckBox = new JCheckBox();
		userInputPasswordField = new JPasswordField();
		userInputClearButton = new JButton();
		manageTablesPanel = new JPanel();
		tablesScrollPane = new JScrollPane();
		tablesTable = new JTable();
		tablesInputPanel = new JPanel();
		tablesInputUpdateButton = new JButton();
		userInputUsernameLabel2 = new JLabel();
		userInputPasswordLabel2 = new JLabel();
		userInputEmployeeNoLabel2 = new JLabel();
		userInputFirstNameLabel2 = new JLabel();
		userInputLastNameLabel2 = new JLabel();
		userInputUsernameField2 = new JTextField();
		userInputPasswordField2 = new JTextField();
		userInputEmployeeNoField2 = new JTextField();
		userInputFirstNameField2 = new JTextField();
		userInputLastNameField2 = new JTextField();
		userInputAddNewButton2 = new JButton();
		userInputUserIdLabel2 = new JLabel();
		userInputUserIdField2 = new JTextField();
		userInputActiveCheckBox2 = new JCheckBox();
		userInputAdminCheckBox2 = new JCheckBox();
		manageItemsPanel = new JPanel();
		itemsScrollPane = new JScrollPane();
		itemsTable = new JTable();
		manageOrdersPanel = new JPanel();
		orderssSrollPane = new JScrollPane();
		ordersTable = new JTable();

		//======== frame1 ========
		{
			Container frame1ContentPane = frame1.getContentPane();
			frame1.setJMenuBar(menuBar1);

			//======== tabbedPane1 ========
			{

				//======== overviewPanel ========
				{

					// JFormDesigner evaluation mark
					overviewPanel.setBorder(new javax.swing.border.CompoundBorder(
						new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
							"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
							javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
							java.awt.Color.red), overviewPanel.getBorder())); overviewPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


					//======== income24hPanel ========
					{
						income24hPanel.setBorder(new TitledBorder("Income (24h)"));
						income24hPanel.setLayout(new GridBagLayout());
						((GridBagLayout)income24hPanel.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
						((GridBagLayout)income24hPanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
						((GridBagLayout)income24hPanel.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
						((GridBagLayout)income24hPanel.getLayout()).rowWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};

						//---- income24hLabel ----
						income24hLabel.setText(bundle.getString("MainForm.income24hLabel.text"));
						income24hLabel.setFont(income24hLabel.getFont().deriveFont(income24hLabel.getFont().getSize() + 10f));
						income24hPanel.add(income24hLabel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));
					}

					//======== income7dPanel ========
					{
						income7dPanel.setBorder(new TitledBorder("Income (7 Days)"));
						income7dPanel.setLayout(new GridBagLayout());
						((GridBagLayout)income7dPanel.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
						((GridBagLayout)income7dPanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
						((GridBagLayout)income7dPanel.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
						((GridBagLayout)income7dPanel.getLayout()).rowWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};

						//---- income7dLabel ----
						income7dLabel.setText(bundle.getString("MainForm.income7dLabel.text"));
						income7dLabel.setFont(income7dLabel.getFont().deriveFont(income7dLabel.getFont().getSize() + 10f));
						income7dPanel.add(income7dLabel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));
					}

					//======== income28dPanel ========
					{
						income28dPanel.setBorder(new TitledBorder("Income (28 days)"));
						income28dPanel.setLayout(new GridBagLayout());
						((GridBagLayout)income28dPanel.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
						((GridBagLayout)income28dPanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
						((GridBagLayout)income28dPanel.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
						((GridBagLayout)income28dPanel.getLayout()).rowWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};

						//---- income28dLabel ----
						income28dLabel.setText(bundle.getString("MainForm.income28dLabel.text"));
						income28dLabel.setFont(income28dLabel.getFont().deriveFont(income28dLabel.getFont().getSize() + 10f));
						income28dPanel.add(income28dLabel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));
					}

					//======== itemsTodayPanel ========
					{
						itemsTodayPanel.setBorder(new TitledBorder("Items Sold Today"));
						itemsTodayPanel.setLayout(new GridBagLayout());
						((GridBagLayout)itemsTodayPanel.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
						((GridBagLayout)itemsTodayPanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
						((GridBagLayout)itemsTodayPanel.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
						((GridBagLayout)itemsTodayPanel.getLayout()).rowWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};

						//---- itemsTodayLabel ----
						itemsTodayLabel.setText(bundle.getString("MainForm.itemsTodayLabel.text"));
						itemsTodayLabel.setFont(itemsTodayLabel.getFont().deriveFont(itemsTodayLabel.getFont().getSize() + 10f));
						itemsTodayPanel.add(itemsTodayLabel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));
					}

					//======== tablesTodayPanel ========
					{
						tablesTodayPanel.setBorder(new TitledBorder("Tables Served Today"));
						tablesTodayPanel.setLayout(new GridBagLayout());
						((GridBagLayout)tablesTodayPanel.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
						((GridBagLayout)tablesTodayPanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
						((GridBagLayout)tablesTodayPanel.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
						((GridBagLayout)tablesTodayPanel.getLayout()).rowWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};

						//---- tablesTodayLabel ----
						tablesTodayLabel.setText(bundle.getString("MainForm.tablesTodayLabel.text"));
						tablesTodayLabel.setFont(tablesTodayLabel.getFont().deriveFont(tablesTodayLabel.getFont().getSize() + 10f));
						tablesTodayPanel.add(tablesTodayLabel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));
					}

					//======== ordersInProgPanel ========
					{
						ordersInProgPanel.setBorder(new TitledBorder("Orders In Progress"));
						ordersInProgPanel.setLayout(new GridBagLayout());
						((GridBagLayout)ordersInProgPanel.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
						((GridBagLayout)ordersInProgPanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
						((GridBagLayout)ordersInProgPanel.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
						((GridBagLayout)ordersInProgPanel.getLayout()).rowWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};

						//---- ordersInProgLabel ----
						ordersInProgLabel.setFont(ordersInProgLabel.getFont().deriveFont(ordersInProgLabel.getFont().getSize() + 10f));
						ordersInProgLabel.setText(bundle.getString("MainForm.ordersInProgLabel.text"));
						ordersInProgPanel.add(ordersInProgLabel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));
					}

					//======== ordersTodayPanel ========
					{
						ordersTodayPanel.setBorder(new TitledBorder("Orders (24h)"));
						ordersTodayPanel.setLayout(new GridBagLayout());
						((GridBagLayout)ordersTodayPanel.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
						((GridBagLayout)ordersTodayPanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
						((GridBagLayout)ordersTodayPanel.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
						((GridBagLayout)ordersTodayPanel.getLayout()).rowWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};

						//---- ordersTodayLabel ----
						ordersTodayLabel.setText(bundle.getString("MainForm.ordersTodayLabel.text"));
						ordersTodayLabel.setFont(ordersTodayLabel.getFont().deriveFont(ordersTodayLabel.getFont().getSize() + 10f));
						ordersTodayPanel.add(ordersTodayLabel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));
					}

					//======== averageIncomeDailyPanel ========
					{
						averageIncomeDailyPanel.setBorder(new TitledBorder("Average (Daily)"));
						averageIncomeDailyPanel.setLayout(new GridBagLayout());
						((GridBagLayout)averageIncomeDailyPanel.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
						((GridBagLayout)averageIncomeDailyPanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
						((GridBagLayout)averageIncomeDailyPanel.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
						((GridBagLayout)averageIncomeDailyPanel.getLayout()).rowWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};

						//---- averageIncomeDailyLabel ----
						averageIncomeDailyLabel.setText(bundle.getString("MainForm.averageIncomeDailyLabel.text"));
						averageIncomeDailyLabel.setFont(averageIncomeDailyLabel.getFont().deriveFont(averageIncomeDailyLabel.getFont().getSize() + 10f));
						averageIncomeDailyPanel.add(averageIncomeDailyLabel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));
					}

					//======== ordersInProgPanel2 ========
					{
						ordersInProgPanel2.setBorder(new TitledBorder("Orders (7 Days)"));
						ordersInProgPanel2.setLayout(new GridBagLayout());
						((GridBagLayout)ordersInProgPanel2.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
						((GridBagLayout)ordersInProgPanel2.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
						((GridBagLayout)ordersInProgPanel2.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
						((GridBagLayout)ordersInProgPanel2.getLayout()).rowWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};

						//---- ordersInProgLabel2 ----
						ordersInProgLabel2.setFont(ordersInProgLabel2.getFont().deriveFont(ordersInProgLabel2.getFont().getSize() + 10f));
						ordersInProgLabel2.setText(bundle.getString("MainForm.ordersInProgLabel2.text"));
						ordersInProgPanel2.add(ordersInProgLabel2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));
					}

					//======== ordersInProgPanel3 ========
					{
						ordersInProgPanel3.setBorder(new TitledBorder("Orders (28 Days)"));
						ordersInProgPanel3.setLayout(new GridBagLayout());
						((GridBagLayout)ordersInProgPanel3.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
						((GridBagLayout)ordersInProgPanel3.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
						((GridBagLayout)ordersInProgPanel3.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
						((GridBagLayout)ordersInProgPanel3.getLayout()).rowWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};

						//---- ordersInProgLabel3 ----
						ordersInProgLabel3.setFont(ordersInProgLabel3.getFont().deriveFont(ordersInProgLabel3.getFont().getSize() + 10f));
						ordersInProgLabel3.setText(bundle.getString("MainForm.ordersInProgLabel3.text"));
						ordersInProgPanel3.add(ordersInProgLabel3, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));
					}

					GroupLayout overviewPanelLayout = new GroupLayout(overviewPanel);
					overviewPanel.setLayout(overviewPanelLayout);
					overviewPanelLayout.setHorizontalGroup(
						overviewPanelLayout.createParallelGroup()
							.addGroup(overviewPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(overviewPanelLayout.createParallelGroup()
									.addGroup(overviewPanelLayout.createSequentialGroup()
										.addComponent(income24hPanel, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(ordersTodayPanel, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 292, Short.MAX_VALUE)
										.addComponent(itemsTodayPanel, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
									.addGroup(overviewPanelLayout.createSequentialGroup()
										.addComponent(income7dPanel, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(ordersInProgPanel2, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 292, Short.MAX_VALUE)
										.addComponent(tablesTodayPanel, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
									.addGroup(overviewPanelLayout.createSequentialGroup()
										.addGroup(overviewPanelLayout.createParallelGroup()
											.addGroup(overviewPanelLayout.createSequentialGroup()
												.addComponent(income28dPanel, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(ordersInProgPanel3, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
											.addGroup(overviewPanelLayout.createSequentialGroup()
												.addComponent(averageIncomeDailyPanel, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(ordersInProgPanel, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))
										.addGap(0, 482, Short.MAX_VALUE)))
								.addContainerGap())
					);
					overviewPanelLayout.setVerticalGroup(
						overviewPanelLayout.createParallelGroup()
							.addGroup(overviewPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(overviewPanelLayout.createParallelGroup()
									.addGroup(GroupLayout.Alignment.TRAILING, overviewPanelLayout.createParallelGroup()
										.addComponent(income24hPanel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
										.addComponent(itemsTodayPanel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
									.addComponent(ordersTodayPanel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(overviewPanelLayout.createParallelGroup()
									.addComponent(income7dPanel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
									.addComponent(tablesTodayPanel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
									.addComponent(ordersInProgPanel2, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(overviewPanelLayout.createParallelGroup()
									.addComponent(ordersInProgPanel3, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
									.addComponent(income28dPanel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(overviewPanelLayout.createParallelGroup()
									.addComponent(averageIncomeDailyPanel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
									.addComponent(ordersInProgPanel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
								.addContainerGap(134, Short.MAX_VALUE))
					);
				}
				tabbedPane1.addTab(bundle.getString("MainForm.overviewPanel.tab.title"), overviewPanel);

				//======== manageUsersPanel ========
				{

					//======== usersScrollPane ========
					{

						//---- usersTable ----
						usersTable.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								usersTableMouseClicked(e);
							}
						});
						usersTable.addPropertyChangeListener(new PropertyChangeListener() {
							@Override
							public void propertyChange(PropertyChangeEvent e) {
								usersTablePropertyChange(e);
							}
						});
						usersScrollPane.setViewportView(usersTable);
					}

					//======== userInputPanel ========
					{
						userInputPanel.setBorder(new TitledBorder(bundle.getString("MainForm.userInputPanel.border")));

						//---- userInputUsernameLabel ----
						userInputUsernameLabel.setText(bundle.getString("MainForm.userInputUsernameLabel.text"));
						userInputUsernameLabel.setHorizontalAlignment(SwingConstants.TRAILING);

						//---- userInputPasswordLabel ----
						userInputPasswordLabel.setText(bundle.getString("MainForm.userInputPasswordLabel.text"));
						userInputPasswordLabel.setHorizontalAlignment(SwingConstants.TRAILING);

						//---- userInputEmployeeNoLabel ----
						userInputEmployeeNoLabel.setText(bundle.getString("MainForm.userInputEmployeeNoLabel.text"));
						userInputEmployeeNoLabel.setHorizontalAlignment(SwingConstants.TRAILING);

						//---- userInputFirstNameLabel ----
						userInputFirstNameLabel.setText(bundle.getString("MainForm.userInputFirstNameLabel.text"));
						userInputFirstNameLabel.setHorizontalAlignment(SwingConstants.TRAILING);

						//---- userInputLastNameLabel ----
						userInputLastNameLabel.setText(bundle.getString("MainForm.userInputLastNameLabel.text"));
						userInputLastNameLabel.setHorizontalAlignment(SwingConstants.TRAILING);

						//---- userInputAddNewButton ----
						userInputAddNewButton.setText(bundle.getString("MainForm.userInputAddNewButton.text"));
						userInputAddNewButton.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								userInputAddNewButtonActionPerformed(e);
							}
						});

						//---- userInputUserIdLabel ----
						userInputUserIdLabel.setText(bundle.getString("MainForm.userInputUserIdLabel.text"));
						userInputUserIdLabel.setHorizontalAlignment(SwingConstants.TRAILING);

						//---- userInputUserIdField ----
						userInputUserIdField.setEditable(false);

						//---- userInputActiveCheckBox ----
						userInputActiveCheckBox.setText(bundle.getString("MainForm.userInputActiveCheckBox.text"));
						userInputActiveCheckBox.setHorizontalTextPosition(SwingConstants.LEADING);
						userInputActiveCheckBox.setIconTextGap(10);
						userInputActiveCheckBox.setHorizontalAlignment(SwingConstants.TRAILING);

						//---- userInputAdminCheckBox ----
						userInputAdminCheckBox.setText(bundle.getString("MainForm.userInputAdminCheckBox.text"));
						userInputAdminCheckBox.setHorizontalTextPosition(SwingConstants.LEADING);
						userInputAdminCheckBox.setIconTextGap(10);
						userInputAdminCheckBox.setHorizontalAlignment(SwingConstants.TRAILING);

						//---- userInputClearButton ----
						userInputClearButton.setText(bundle.getString("MainForm.userInputClearButton.text"));
						userInputClearButton.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								userInputAddNewButtonActionPerformed(e);
								userInputClearButtonActionPerformed(e);
							}
						});

						GroupLayout userInputPanelLayout = new GroupLayout(userInputPanel);
						userInputPanel.setLayout(userInputPanelLayout);
						userInputPanelLayout.setHorizontalGroup(
								userInputPanelLayout.createParallelGroup()
								.addGroup(userInputPanelLayout.createSequentialGroup()
										.addContainerGap()
										.addGroup(userInputPanelLayout.createParallelGroup()
												.addGroup(userInputPanelLayout.createSequentialGroup()
														.addGroup(userInputPanelLayout.createParallelGroup()
																.addGroup(userInputPanelLayout.createSequentialGroup()
																		.addGroup(userInputPanelLayout.createParallelGroup()
																				.addComponent(userInputUsernameLabel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
																				.addComponent(userInputPasswordLabel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(userInputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
																				.addComponent(userInputUsernameField, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
																				.addComponent(userInputPasswordField, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
																.addGroup(userInputPanelLayout.createSequentialGroup()
																		.addComponent(userInputUserIdLabel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(userInputUserIdField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 296, Short.MAX_VALUE)
														.addGroup(userInputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
																.addComponent(userInputEmployeeNoLabel, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
																.addComponent(userInputFirstNameLabel, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
																.addComponent(userInputLastNameLabel, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(userInputPanelLayout.createParallelGroup()
																.addComponent(userInputEmployeeNoField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
																.addComponent(userInputFirstNameField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
																.addComponent(userInputLastNameField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
												.addGroup(userInputPanelLayout.createSequentialGroup()
														.addGap(6, 6, 6)
														.addComponent(userInputActiveCheckBox, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(userInputAdminCheckBox, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 440, Short.MAX_VALUE)
														.addComponent(userInputClearButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(userInputAddNewButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
									.addContainerGap())
						);
						userInputPanelLayout.setVerticalGroup(
								userInputPanelLayout.createParallelGroup()
								.addGroup(userInputPanelLayout.createSequentialGroup()
										.addGap(4, 4, 4)
										.addGroup(userInputPanelLayout.createParallelGroup()
												.addGroup(userInputPanelLayout.createSequentialGroup()
														.addGroup(userInputPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
																.addComponent(userInputUserIdLabel)
																.addComponent(userInputUserIdField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addGap(6, 6, 6)
														.addGroup(userInputPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
																.addComponent(userInputUsernameLabel)
																.addComponent(userInputUsernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(userInputPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
																.addComponent(userInputPasswordLabel)
																.addComponent(userInputPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addGroup(userInputPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
																.addComponent(userInputActiveCheckBox)
																.addComponent(userInputAdminCheckBox))
														.addGap(44, 44, 44))
												.addGroup(userInputPanelLayout.createSequentialGroup()
														.addGroup(userInputPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
																.addComponent(userInputEmployeeNoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addComponent(userInputEmployeeNoLabel))
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(userInputPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
																.addComponent(userInputFirstNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addComponent(userInputFirstNameLabel))
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(userInputPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
																.addComponent(userInputLastNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addComponent(userInputLastNameLabel))
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(userInputPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
																.addComponent(userInputAddNewButton)
																.addComponent(userInputClearButton))
											.addGap(0, 0, Short.MAX_VALUE))))
						);
					}

					GroupLayout manageUsersPanelLayout = new GroupLayout(manageUsersPanel);
					manageUsersPanel.setLayout(manageUsersPanelLayout);
					manageUsersPanelLayout.setHorizontalGroup(
						manageUsersPanelLayout.createParallelGroup()
							.addComponent(userInputPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(usersScrollPane, GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
					);
					manageUsersPanelLayout.setVerticalGroup(
						manageUsersPanelLayout.createParallelGroup()
							.addGroup(manageUsersPanelLayout.createSequentialGroup()
									.addComponent(usersScrollPane, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(userInputPanel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
					);
				}
				tabbedPane1.addTab(bundle.getString("MainForm.manageUsersPanel.tab.title"), manageUsersPanel);

				//======== manageTablesPanel ========
				{

					//======== tablesScrollPane ========
					{
						tablesScrollPane.setViewportView(tablesTable);
					}

					//======== tablesInputPanel ========
					{
						tablesInputPanel.setBorder(new TitledBorder(bundle.getString("MainForm.tablesInputPanel.border")));

						//---- tablesInputUpdateButton ----
						tablesInputUpdateButton.setText(bundle.getString("MainForm.tablesInputUpdateButton.text"));

						//---- userInputUsernameLabel2 ----
						userInputUsernameLabel2.setText(bundle.getString("MainForm.userInputUsernameLabel2.text"));
						userInputUsernameLabel2.setHorizontalAlignment(SwingConstants.TRAILING);

						//---- userInputPasswordLabel2 ----
						userInputPasswordLabel2.setText(bundle.getString("MainForm.userInputPasswordLabel2.text"));
						userInputPasswordLabel2.setHorizontalAlignment(SwingConstants.TRAILING);

						//---- userInputEmployeeNoLabel2 ----
						userInputEmployeeNoLabel2.setText(bundle.getString("MainForm.userInputEmployeeNoLabel2.text"));
						userInputEmployeeNoLabel2.setHorizontalAlignment(SwingConstants.TRAILING);

						//---- userInputFirstNameLabel2 ----
						userInputFirstNameLabel2.setText(bundle.getString("MainForm.userInputFirstNameLabel2.text"));
						userInputFirstNameLabel2.setHorizontalAlignment(SwingConstants.TRAILING);

						//---- userInputLastNameLabel2 ----
						userInputLastNameLabel2.setText(bundle.getString("MainForm.userInputLastNameLabel2.text"));
						userInputLastNameLabel2.setHorizontalAlignment(SwingConstants.TRAILING);

						//---- userInputAddNewButton2 ----
						userInputAddNewButton2.setText(bundle.getString("MainForm.userInputAddNewButton2.text"));

						//---- userInputUserIdLabel2 ----
						userInputUserIdLabel2.setText(bundle.getString("MainForm.userInputUserIdLabel2.text"));
						userInputUserIdLabel2.setHorizontalAlignment(SwingConstants.TRAILING);

						//---- userInputUserIdField2 ----
						userInputUserIdField2.setEditable(false);

						//---- userInputActiveCheckBox2 ----
						userInputActiveCheckBox2.setText(bundle.getString("MainForm.userInputActiveCheckBox2.text"));
						userInputActiveCheckBox2.setHorizontalTextPosition(SwingConstants.LEADING);
						userInputActiveCheckBox2.setIconTextGap(10);
						userInputActiveCheckBox2.setHorizontalAlignment(SwingConstants.TRAILING);

						//---- userInputAdminCheckBox2 ----
						userInputAdminCheckBox2.setText(bundle.getString("MainForm.userInputAdminCheckBox2.text"));
						userInputAdminCheckBox2.setHorizontalTextPosition(SwingConstants.LEADING);
						userInputAdminCheckBox2.setIconTextGap(10);
						userInputAdminCheckBox2.setHorizontalAlignment(SwingConstants.TRAILING);

						GroupLayout tablesInputPanelLayout = new GroupLayout(tablesInputPanel);
						tablesInputPanel.setLayout(tablesInputPanelLayout);
						tablesInputPanelLayout.setHorizontalGroup(
							tablesInputPanelLayout.createParallelGroup()
								.addGroup(tablesInputPanelLayout.createSequentialGroup()
									.addContainerGap()
									.addGroup(tablesInputPanelLayout.createParallelGroup()
										.addGroup(tablesInputPanelLayout.createSequentialGroup()
											.addGroup(tablesInputPanelLayout.createParallelGroup()
												.addComponent(userInputUsernameLabel2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
												.addComponent(userInputPasswordLabel2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
											.addGroup(tablesInputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
												.addComponent(userInputUsernameField2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
												.addComponent(userInputPasswordField2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
										.addGroup(tablesInputPanelLayout.createSequentialGroup()
											.addComponent(userInputUserIdLabel2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
											.addGap(6, 6, 6)
											.addComponent(userInputUserIdField2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
										.addGroup(tablesInputPanelLayout.createSequentialGroup()
											.addGap(6, 6, 6)
											.addComponent(userInputActiveCheckBox2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(userInputAdminCheckBox2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(tablesInputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addComponent(userInputEmployeeNoLabel2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
										.addComponent(userInputFirstNameLabel2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
										.addComponent(userInputLastNameLabel2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addGroup(tablesInputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addGroup(tablesInputPanelLayout.createSequentialGroup()
											.addComponent(tablesInputUpdateButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(userInputAddNewButton2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
										.addComponent(userInputEmployeeNoField2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
										.addComponent(userInputFirstNameField2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
										.addComponent(userInputLastNameField2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
									.addContainerGap(278, Short.MAX_VALUE))
						);
						tablesInputPanelLayout.setVerticalGroup(
							tablesInputPanelLayout.createParallelGroup()
								.addGroup(tablesInputPanelLayout.createSequentialGroup()
									.addGroup(tablesInputPanelLayout.createParallelGroup()
										.addGroup(tablesInputPanelLayout.createSequentialGroup()
											.addGap(4, 4, 4)
											.addComponent(userInputUserIdLabel2))
										.addComponent(userInputUserIdField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addGroup(tablesInputPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(userInputUsernameLabel2)
										.addComponent(userInputUsernameField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addGroup(tablesInputPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(userInputPasswordLabel2)
										.addComponent(userInputPasswordField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(tablesInputPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(userInputActiveCheckBox2)
										.addComponent(userInputAdminCheckBox2))
									.addGap(44, 44, 44))
								.addGroup(tablesInputPanelLayout.createSequentialGroup()
									.addGap(4, 4, 4)
									.addGroup(tablesInputPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(userInputEmployeeNoField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(userInputEmployeeNoLabel2))
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addGroup(tablesInputPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(userInputFirstNameField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(userInputFirstNameLabel2))
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addGroup(tablesInputPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(userInputLastNameField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(userInputLastNameLabel2))
									.addGap(18, 18, 18)
									.addGroup(tablesInputPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(userInputAddNewButton2)
										.addComponent(tablesInputUpdateButton))
									.addGap(0, 0, Short.MAX_VALUE))
						);
					}

					GroupLayout manageTablesPanelLayout = new GroupLayout(manageTablesPanel);
					manageTablesPanel.setLayout(manageTablesPanelLayout);
					manageTablesPanelLayout.setHorizontalGroup(
						manageTablesPanelLayout.createParallelGroup()
							.addGroup(manageTablesPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(manageTablesPanelLayout.createParallelGroup()
										.addComponent(tablesScrollPane, GroupLayout.PREFERRED_SIZE, 868, GroupLayout.PREFERRED_SIZE)
										.addComponent(tablesInputPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					);
					manageTablesPanelLayout.setVerticalGroup(
						manageTablesPanelLayout.createParallelGroup()
							.addGroup(manageTablesPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(tablesScrollPane, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(tablesInputPanel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
					);
				}
				tabbedPane1.addTab(bundle.getString("MainForm.manageTablesPanel.tab.title"), manageTablesPanel);

				//======== manageItemsPanel ========
				{

					//======== itemsScrollPane ========
					{
						itemsScrollPane.setViewportView(itemsTable);
					}

					GroupLayout manageItemsPanelLayout = new GroupLayout(manageItemsPanel);
					manageItemsPanel.setLayout(manageItemsPanelLayout);
					manageItemsPanelLayout.setHorizontalGroup(
						manageItemsPanelLayout.createParallelGroup()
							.addGroup(GroupLayout.Alignment.TRAILING, manageItemsPanelLayout.createSequentialGroup()
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(itemsScrollPane, GroupLayout.PREFERRED_SIZE, 868, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
					);
					manageItemsPanelLayout.setVerticalGroup(
						manageItemsPanelLayout.createParallelGroup()
							.addGroup(manageItemsPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(itemsScrollPane, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(188, Short.MAX_VALUE))
					);
				}
				tabbedPane1.addTab(bundle.getString("MainForm.manageItemsPanel.tab.title"), manageItemsPanel);

				//======== manageOrdersPanel ========
				{

					//======== orderssSrollPane ========
					{
						orderssSrollPane.setViewportView(ordersTable);
					}

					GroupLayout manageOrdersPanelLayout = new GroupLayout(manageOrdersPanel);
					manageOrdersPanel.setLayout(manageOrdersPanelLayout);
					manageOrdersPanelLayout.setHorizontalGroup(
						manageOrdersPanelLayout.createParallelGroup()
							.addGroup(manageOrdersPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(orderssSrollPane, GroupLayout.DEFAULT_SIZE, 868, Short.MAX_VALUE)
								.addContainerGap())
					);
					manageOrdersPanelLayout.setVerticalGroup(
						manageOrdersPanelLayout.createParallelGroup()
							.addGroup(manageOrdersPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(orderssSrollPane, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(188, Short.MAX_VALUE))
					);
				}
				tabbedPane1.addTab(bundle.getString("MainForm.manageOrdersPanel.tab.title"), manageOrdersPanel);
			}

			GroupLayout frame1ContentPaneLayout = new GroupLayout(frame1ContentPane);
			frame1ContentPane.setLayout(frame1ContentPaneLayout);
			frame1ContentPaneLayout.setHorizontalGroup(
				frame1ContentPaneLayout.createParallelGroup()
					.addGroup(frame1ContentPaneLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(tabbedPane1)
						.addContainerGap())
			);
			frame1ContentPaneLayout.setVerticalGroup(
				frame1ContentPaneLayout.createParallelGroup()
					.addGroup(frame1ContentPaneLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(tabbedPane1)
						.addContainerGap())
			);
			frame1.pack();
			frame1.setLocationRelativeTo(frame1.getOwner());
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Ian Owen
	private JFrame frame1;
	private JMenuBar menuBar1;
	private JTabbedPane tabbedPane1;
	private JPanel overviewPanel;
	private JPanel income24hPanel;
	private JLabel income24hLabel;
	private JPanel income7dPanel;
	private JLabel income7dLabel;
	private JPanel income28dPanel;
	private JLabel income28dLabel;
	private JPanel itemsTodayPanel;
	private JLabel itemsTodayLabel;
	private JPanel tablesTodayPanel;
	private JLabel tablesTodayLabel;
	private JPanel ordersInProgPanel;
	private JLabel ordersInProgLabel;
	private JPanel ordersTodayPanel;
	private JLabel ordersTodayLabel;
	private JPanel averageIncomeDailyPanel;
	private JLabel averageIncomeDailyLabel;
	private JPanel ordersInProgPanel2;
	private JLabel ordersInProgLabel2;
	private JPanel ordersInProgPanel3;
	private JLabel ordersInProgLabel3;
	private JPanel manageUsersPanel;
	private JScrollPane usersScrollPane;
	private JTable usersTable;
	private JPanel userInputPanel;
	private JLabel userInputUsernameLabel;
	private JLabel userInputPasswordLabel;
	private JLabel userInputEmployeeNoLabel;
	private JLabel userInputFirstNameLabel;
	private JLabel userInputLastNameLabel;
	private JTextField userInputUsernameField;
	private JTextField userInputEmployeeNoField;
	private JTextField userInputFirstNameField;
	private JTextField userInputLastNameField;
	private JButton userInputAddNewButton;
	private JLabel userInputUserIdLabel;
	private JTextField userInputUserIdField;
	private JCheckBox userInputActiveCheckBox;
	private JCheckBox userInputAdminCheckBox;
	private JPasswordField userInputPasswordField;
	private JButton userInputClearButton;
	private JPanel manageTablesPanel;
	private JScrollPane tablesScrollPane;
	private JTable tablesTable;
	private JPanel tablesInputPanel;
	private JButton tablesInputUpdateButton;
	private JLabel userInputUsernameLabel2;
	private JLabel userInputPasswordLabel2;
	private JLabel userInputEmployeeNoLabel2;
	private JLabel userInputFirstNameLabel2;
	private JLabel userInputLastNameLabel2;
	private JTextField userInputUsernameField2;
	private JTextField userInputPasswordField2;
	private JTextField userInputEmployeeNoField2;
	private JTextField userInputFirstNameField2;
	private JTextField userInputLastNameField2;
	private JButton userInputAddNewButton2;
	private JLabel userInputUserIdLabel2;
	private JTextField userInputUserIdField2;
	private JCheckBox userInputActiveCheckBox2;
	private JCheckBox userInputAdminCheckBox2;
	private JPanel manageItemsPanel;
	private JScrollPane itemsScrollPane;
	private JTable itemsTable;
	private JPanel manageOrdersPanel;
	private JScrollPane orderssSrollPane;
	private JTable ordersTable;
	// JFormDesigner - End of variables declaration  //GEN-END:variables

	public void setCreds(String username, String password){
		creds[0] = username;
		creds[1] = password;
	}

	public String boolToNumString(boolean x) {
		if(x) return "1";
		else return "0";
	}
	public int boolToInt(boolean x) {
		if(x) return 1;
		else return 0;
	}

	private void clearUserFields() {
		userInputUsernameField.setText("");
		userInputPasswordField.setText("");
		userInputActiveCheckBox.setSelected(false);
		userInputAdminCheckBox.setSelected(false);
		userInputEmployeeNoField.setText("");
		userInputFirstNameField.setText("");
		userInputLastNameField.setText("");
	}

	public void updateUserTable() {

		//Object[] row = { "f", "g", "gg", "gthj" };
		DefaultTableModel model = (DefaultTableModel) usersTable.getModel();
		//Clear before each refresh
		model.setRowCount(0);
		model.setColumnCount(0);
		usersTable.revalidate();

		model.addColumn("U_Id");
		model.addColumn("Username");
		model.addColumn("Password");
		model.addColumn("Active");
		model.addColumn("Admin");
		model.addColumn("Employee Number");
		model.addColumn("First Name");
		model.addColumn("Last Name");

		String[] result = new Client().getUsers(creds);
		
		if(!result[0].equals("1")) {
			JOptionPane.showMessageDialog(frame1, "<html>Error!<br>Error Code: "+result[0]+"<br>Message: "+result[1]+"</html>");
			return;
		}

		String[] trimmedResult = Arrays.copyOfRange(result, 1, result.length);

		String[][] users = new String[trimmedResult.length/7][7];
		System.out.println("length = "+trimmedResult.length);

		int x = 0;
		for(int i = 0; trimmedResult.length>i; i = i + 7) {
			String[] user = new String[] {
					trimmedResult[i+0], //UID
					trimmedResult[i+1], //Username
					trimmedResult[i+2], //IsActive
					trimmedResult[i+3], //IsAdmin
					trimmedResult[i+4], //EmployeeNumber
					trimmedResult[i+5], //First name
					trimmedResult[i+6]  //Last name
			};
			users[x] = user;
			x++;
		}

		for(String[] user : users) {
			String uid = user[0];
			String username = user[1];
			String password = "********";
			String isActive = user[2];
			String isAdmin = user[3];
			String employeeNumber = user[4];
			String firstName = user[5];
			String lastName = user[6];
			Object[] row = { uid, username, password, isActive, isAdmin, employeeNumber, firstName, lastName};
			model.addRow(row);
		}
	}

	public void setVisibility(boolean vis) {
		frame1.setVisible(vis);
	}





}
