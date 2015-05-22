import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.util.Currency;
import java.util.Locale;

/*
 * Created by JFormDesigner on Tue Apr 14 16:07:44 BST 2015
 */



/**
 * @author Ian Owen
 */
public class MainForm extends JPanel {
	private String[] creds = new String[2];
	String url;

	public MainForm() {
		initComponents();
	}

	private void usersTableMouseClicked(MouseEvent e) {
		// TODO add your code here
		System.out.println("usersTableMouseClicked");
	}

	private void usersTablePropertyChange(PropertyChangeEvent e) {
		// TODO add your code here
		System.out.println("users table property change");
	}


	private void userInputAddNewButtonActionPerformed(ActionEvent e) {
		// TODO add your code here
		System.out.println("ADD USER BUTTON PRESS!");

		String username = userInputUsernameField.getText();
		String password = new String(userInputPasswordField.getPassword());
		int isActive = boolToInt(userInputActiveCheckBox.isSelected());
		int isAdmin = boolToInt(userInputAdminCheckBox.isSelected());
		int employeeNumber = Integer.parseInt(userInputEmployeeNoField.getText());
		String firstName = userInputFirstNameField.getText();
		String lastName = userInputLastNameField.getText();

		int confirmation = JOptionPane.showConfirmDialog(frame1, "<html>CONFIRM?<br>" +
				"USERNAME   = "+username+"<br>" +
				"PASSWORD   = "+password+"<br>" +
				"ACTIVE     = "+isActive+"<br>" +
				"ADMIN      = "+isAdmin+"<br>" +
				"EMP NO     = "+employeeNumber+"<br>" +
				"FIRST NAME = "+firstName+"<br>" +
				"LAST NAME  = "+lastName+"</html>");

		if(confirmation==0) {
			Client client = new Client();
			client.setURL(url);
			String[] result = client.addUser(creds, username, password, isActive, isAdmin, employeeNumber, firstName, lastName);

			if(!result[0].equals("1")) {
				JOptionPane.showMessageDialog(frame1, "<html>Error!<br>Error Code: " + result[0] + "<br>Message: " + result[1] + "</html>");
				return;
			}

			clearUserFields();
			updateUserTable();

		}

	}

	private void userInputClearButtonActionPerformed(ActionEvent e) {
		clearUserFields();
	}

	private void refreshButtonActionPerformed(ActionEvent e) {
		// TODO add your code here
		updateItemTable();
		updateUserTable();
		updateTablesTable();
		updateHome();
	}

    private void updateChangesMenuItemActionPerformed(ActionEvent e) {
        // TODO add your code here
		System.out.println("UPDATE CHANGES BUTTON PRESS");
		modifyUser();
		modifyItem();
		modifyTable();
    }

    private void frame1WindowActivated(WindowEvent e) {
        // TODO add your code here
		updateItemTable();
		updateUserTable();
		updateTablesTable();
		updateHome();
    }

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ian Owen
        ResourceBundle bundle = ResourceBundle.getBundle("mainform_strings");
        frame1 = new JFrame();
        menuBar1 = new JMenuBar();
        updateChangesMenuItem = new JMenuItem();
        refreshButton = new JMenuItem();
        tabbedPane1 = new JTabbedPane();
        overviewPanel = new JPanel();
        income24hPanel = new JPanel();
        income24hLabel = new JLabel();
        income7dPanel = new JPanel();
        income7dLabel = new JLabel();
        income28dPanel = new JPanel();
        income28dLabel = new JLabel();
        ordersInProgPanel = new JPanel();
        ordersInProgLabel = new JLabel();
        orders24HPanel = new JPanel();
        orders24HLabel = new JLabel();
        orders7DPanel = new JPanel();
        orders7DLabel = new JLabel();
        orders28DPanel = new JPanel();
        orders28DLabel = new JLabel();
        incomeTotalPanel = new JPanel();
        incomeTotalLabel = new JLabel();
        ordersTotalPanel = new JPanel();
        ordersTotalLabel = new JLabel();
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
        userInputPanel2 = new JPanel();
        userInputUsernameLabel2 = new JLabel();
        userInputPasswordLabel2 = new JLabel();
        userInputEmployeeNoLabel2 = new JLabel();
        userInputUsernameField2 = new JTextField();
        userInputEmployeeNoField2 = new JTextField();
        userInputAddNewButton2 = new JButton();
        userInputUserIdLabel2 = new JLabel();
        userInputUserIdField2 = new JTextField();
        userInputPasswordField2 = new JPasswordField();
        userInputClearButton2 = new JButton();
        manageItemsPanel = new JPanel();
        itemsScrollPane = new JScrollPane();
        itemsTable = new JTable();
        userInputPanel3 = new JPanel();
        userInputUsernameLabel3 = new JLabel();
        userInputPasswordLabel3 = new JLabel();
        userInputEmployeeNoLabel3 = new JLabel();
        userInputUsernameField3 = new JTextField();
        userInputEmployeeNoField3 = new JTextField();
        userInputAddNewButton3 = new JButton();
        userInputUserIdLabel3 = new JLabel();
        userInputUserIdField3 = new JTextField();
        userInputActiveCheckBox2 = new JCheckBox();
        userInputAdminCheckBox2 = new JCheckBox();
        userInputPasswordField3 = new JPasswordField();
        userInputClearButton3 = new JButton();
        userInputAdminCheckBox3 = new JCheckBox();

        //======== frame1 ========
        {
            frame1.addWindowListener(new WindowAdapter() {
                @Override
                public void windowActivated(WindowEvent e) {
                    frame1WindowActivated(e);
                }
            });
            Container frame1ContentPane = frame1.getContentPane();

            //======== menuBar1 ========
            {

                //---- updateChangesMenuItem ----
                updateChangesMenuItem.setText(bundle.getString("MainForm.updateChangesMenuItem.text"));
                updateChangesMenuItem.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						updateChangesMenuItemActionPerformed(e);
					}
				});
                menuBar1.add(updateChangesMenuItem);

                //---- refreshButton ----
                refreshButton.setText(bundle.getString("MainForm.refreshButton.text"));
                refreshButton.setHorizontalTextPosition(SwingConstants.LEADING);
                refreshButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        refreshButtonActionPerformed(e);
                    }
                });
                menuBar1.add(refreshButton);
            }
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

                    //======== orders24HPanel ========
                    {
                        orders24HPanel.setBorder(new TitledBorder("Ordered Items (24h)"));
                        orders24HPanel.setLayout(new GridBagLayout());
                        ((GridBagLayout)orders24HPanel.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
                        ((GridBagLayout)orders24HPanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
                        ((GridBagLayout)orders24HPanel.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
                        ((GridBagLayout)orders24HPanel.getLayout()).rowWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};

                        //---- orders24HLabel ----
                        orders24HLabel.setText(bundle.getString("MainForm.orders24HLabel.text"));
                        orders24HLabel.setFont(orders24HLabel.getFont().deriveFont(orders24HLabel.getFont().getSize() + 10f));
                        orders24HPanel.add(orders24HLabel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                            new Insets(0, 0, 5, 5), 0, 0));
                    }

                    //======== orders7DPanel ========
                    {
                        orders7DPanel.setBorder(new TitledBorder("Ordered Items (7 Days)"));
                        orders7DPanel.setLayout(new GridBagLayout());
                        ((GridBagLayout)orders7DPanel.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
                        ((GridBagLayout)orders7DPanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
                        ((GridBagLayout)orders7DPanel.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
                        ((GridBagLayout)orders7DPanel.getLayout()).rowWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};

                        //---- orders7DLabel ----
                        orders7DLabel.setFont(orders7DLabel.getFont().deriveFont(orders7DLabel.getFont().getSize() + 10f));
                        orders7DLabel.setText(bundle.getString("MainForm.orders7DLabel.text"));
                        orders7DPanel.add(orders7DLabel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                            new Insets(0, 0, 5, 5), 0, 0));
                    }

                    //======== orders28DPanel ========
                    {
                        orders28DPanel.setBorder(new TitledBorder("Ordered Items (28 Days)"));
                        orders28DPanel.setLayout(new GridBagLayout());
                        ((GridBagLayout)orders28DPanel.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
                        ((GridBagLayout)orders28DPanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
                        ((GridBagLayout)orders28DPanel.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
                        ((GridBagLayout)orders28DPanel.getLayout()).rowWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};

                        //---- orders28DLabel ----
                        orders28DLabel.setFont(orders28DLabel.getFont().deriveFont(orders28DLabel.getFont().getSize() + 10f));
                        orders28DLabel.setText(bundle.getString("MainForm.orders28DLabel.text"));
                        orders28DPanel.add(orders28DLabel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                            new Insets(0, 0, 5, 5), 0, 0));
                    }

                    //======== incomeTotalPanel ========
                    {
                        incomeTotalPanel.setBorder(new TitledBorder("Income (Total)"));
                        incomeTotalPanel.setLayout(new GridBagLayout());
                        ((GridBagLayout)incomeTotalPanel.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
                        ((GridBagLayout)incomeTotalPanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
                        ((GridBagLayout)incomeTotalPanel.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
                        ((GridBagLayout)incomeTotalPanel.getLayout()).rowWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};

                        //---- incomeTotalLabel ----
                        incomeTotalLabel.setText(bundle.getString("MainForm.incomeTotalLabel.text"));
                        incomeTotalLabel.setFont(incomeTotalLabel.getFont().deriveFont(incomeTotalLabel.getFont().getSize() + 10f));
                        incomeTotalPanel.add(incomeTotalLabel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                            new Insets(0, 0, 5, 5), 0, 0));
                    }

                    //======== ordersTotalPanel ========
                    {
                        ordersTotalPanel.setBorder(new TitledBorder("Ordered Items (Total)"));
                        ordersTotalPanel.setLayout(new GridBagLayout());
                        ((GridBagLayout)ordersTotalPanel.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
                        ((GridBagLayout)ordersTotalPanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
                        ((GridBagLayout)ordersTotalPanel.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
                        ((GridBagLayout)ordersTotalPanel.getLayout()).rowWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};

                        //---- ordersTotalLabel ----
                        ordersTotalLabel.setFont(ordersTotalLabel.getFont().deriveFont(ordersTotalLabel.getFont().getSize() + 10f));
                        ordersTotalLabel.setText(bundle.getString("MainForm.ordersTotalLabel.text"));
                        ordersTotalPanel.add(ordersTotalLabel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
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
                                        .addComponent(ordersInProgPanel, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 678, Short.MAX_VALUE))
                                    .addGroup(GroupLayout.Alignment.TRAILING, overviewPanelLayout.createSequentialGroup()
                                        .addGroup(overviewPanelLayout.createParallelGroup()
                                            .addComponent(income24hPanel, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(orders24HPanel, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
                                        .addGap(39, 39, 39)
                                        .addGroup(overviewPanelLayout.createParallelGroup()
                                            .addComponent(income7dPanel, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(orders7DPanel, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                        .addGroup(overviewPanelLayout.createParallelGroup()
                                            .addGroup(overviewPanelLayout.createSequentialGroup()
                                                .addComponent(orders28DPanel, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                                                .addGap(27, 27, 27)
                                                .addComponent(ordersTotalPanel, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(overviewPanelLayout.createSequentialGroup()
                                                .addComponent(income28dPanel, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                                                .addGap(27, 27, 27)
                                                .addComponent(incomeTotalPanel, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap())
                    );
                    overviewPanelLayout.setVerticalGroup(
                        overviewPanelLayout.createParallelGroup()
                            .addGroup(overviewPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(overviewPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(income24hPanel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(incomeTotalPanel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(income28dPanel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(income7dPanel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(overviewPanelLayout.createParallelGroup()
                                    .addComponent(orders24HPanel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ordersTotalPanel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(orders28DPanel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(orders7DPanel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ordersInProgPanel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(222, Short.MAX_VALUE))
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
                                .addComponent(usersScrollPane, GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
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

                    //======== userInputPanel2 ========
                    {
                        userInputPanel2.setBorder(new TitledBorder(bundle.getString("MainForm.userInputPanel2.border")));

                        //---- userInputUsernameLabel2 ----
                        userInputUsernameLabel2.setText(bundle.getString("MainForm.userInputUsernameLabel2.text"));
                        userInputUsernameLabel2.setHorizontalAlignment(SwingConstants.TRAILING);

                        //---- userInputPasswordLabel2 ----
                        userInputPasswordLabel2.setText(bundle.getString("MainForm.userInputPasswordLabel2.text"));
                        userInputPasswordLabel2.setHorizontalAlignment(SwingConstants.TRAILING);

                        //---- userInputEmployeeNoLabel2 ----
                        userInputEmployeeNoLabel2.setText(bundle.getString("MainForm.userInputEmployeeNoLabel2.text"));
                        userInputEmployeeNoLabel2.setHorizontalAlignment(SwingConstants.TRAILING);

                        //---- userInputAddNewButton2 ----
                        userInputAddNewButton2.setText(bundle.getString("MainForm.userInputAddNewButton2.text"));
                        userInputAddNewButton2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                userInputAddNewButtonActionPerformed(e);
                            }
                        });

                        //---- userInputUserIdLabel2 ----
                        userInputUserIdLabel2.setText(bundle.getString("MainForm.userInputUserIdLabel2.text"));
                        userInputUserIdLabel2.setHorizontalAlignment(SwingConstants.TRAILING);

                        //---- userInputUserIdField2 ----
                        userInputUserIdField2.setEditable(false);

                        //---- userInputClearButton2 ----
                        userInputClearButton2.setText(bundle.getString("MainForm.userInputClearButton2.text"));
                        userInputClearButton2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                userInputAddNewButtonActionPerformed(e);
                                userInputClearButtonActionPerformed(e);
                            }
                        });

                        GroupLayout userInputPanel2Layout = new GroupLayout(userInputPanel2);
                        userInputPanel2.setLayout(userInputPanel2Layout);
                        userInputPanel2Layout.setHorizontalGroup(
                            userInputPanel2Layout.createParallelGroup()
                                .addGroup(userInputPanel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(userInputPanel2Layout.createParallelGroup()
                                        .addGroup(userInputPanel2Layout.createSequentialGroup()
                                            .addGroup(userInputPanel2Layout.createParallelGroup()
                                                .addGroup(userInputPanel2Layout.createSequentialGroup()
                                                    .addGroup(userInputPanel2Layout.createParallelGroup()
                                                        .addComponent(userInputUsernameLabel2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(userInputPasswordLabel2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(userInputPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(userInputUsernameField2, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                                        .addComponent(userInputPasswordField2)))
                                                .addGroup(userInputPanel2Layout.createSequentialGroup()
                                                    .addComponent(userInputUserIdLabel2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(userInputUserIdField2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 284, Short.MAX_VALUE)
                                            .addComponent(userInputEmployeeNoLabel2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(userInputEmployeeNoField2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, userInputPanel2Layout.createSequentialGroup()
                                            .addGap(0, 640, Short.MAX_VALUE)
                                            .addComponent(userInputClearButton2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(userInputAddNewButton2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
                                    .addContainerGap())
                        );
                        userInputPanel2Layout.setVerticalGroup(
                            userInputPanel2Layout.createParallelGroup()
                                .addGroup(userInputPanel2Layout.createSequentialGroup()
                                    .addGap(4, 4, 4)
                                    .addGroup(userInputPanel2Layout.createParallelGroup()
                                        .addGroup(userInputPanel2Layout.createSequentialGroup()
                                            .addGroup(userInputPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(userInputUserIdLabel2)
                                                .addComponent(userInputUserIdField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addGap(6, 6, 6)
                                            .addGroup(userInputPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(userInputUsernameLabel2)
                                                .addComponent(userInputUsernameField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(userInputPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(userInputPasswordLabel2)
                                                .addComponent(userInputPasswordField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addGap(44, 57, Short.MAX_VALUE))
                                        .addGroup(userInputPanel2Layout.createSequentialGroup()
                                            .addGroup(userInputPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(userInputEmployeeNoField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(userInputEmployeeNoLabel2))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                                            .addGroup(userInputPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(userInputAddNewButton2)
                                                .addComponent(userInputClearButton2))
                                            .addContainerGap())))
                        );
                    }

                    GroupLayout manageTablesPanelLayout = new GroupLayout(manageTablesPanel);
                    manageTablesPanel.setLayout(manageTablesPanelLayout);
                    manageTablesPanelLayout.setHorizontalGroup(
                        manageTablesPanelLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, manageTablesPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(userInputPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addComponent(tablesScrollPane, GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
                    );
                    manageTablesPanelLayout.setVerticalGroup(
                        manageTablesPanelLayout.createParallelGroup()
                            .addGroup(manageTablesPanelLayout.createSequentialGroup()
                                .addComponent(tablesScrollPane, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(userInputPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                    );
                }
                tabbedPane1.addTab(bundle.getString("MainForm.manageTablesPanel.tab.title"), manageTablesPanel);

                //======== manageItemsPanel ========
                {

                    //======== itemsScrollPane ========
                    {
                        itemsScrollPane.setViewportView(itemsTable);
                    }

                    //======== userInputPanel3 ========
                    {
                        userInputPanel3.setBorder(new TitledBorder(bundle.getString("MainForm.userInputPanel3.border")));

                        //---- userInputUsernameLabel3 ----
                        userInputUsernameLabel3.setText(bundle.getString("MainForm.userInputUsernameLabel3.text"));
                        userInputUsernameLabel3.setHorizontalAlignment(SwingConstants.TRAILING);

                        //---- userInputPasswordLabel3 ----
                        userInputPasswordLabel3.setText(bundle.getString("MainForm.userInputPasswordLabel3.text"));
                        userInputPasswordLabel3.setHorizontalAlignment(SwingConstants.TRAILING);

                        //---- userInputEmployeeNoLabel3 ----
                        userInputEmployeeNoLabel3.setText(bundle.getString("MainForm.userInputEmployeeNoLabel3.text"));
                        userInputEmployeeNoLabel3.setHorizontalAlignment(SwingConstants.TRAILING);

                        //---- userInputAddNewButton3 ----
                        userInputAddNewButton3.setText(bundle.getString("MainForm.userInputAddNewButton3.text"));
                        userInputAddNewButton3.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                userInputAddNewButtonActionPerformed(e);
                            }
                        });

                        //---- userInputUserIdLabel3 ----
                        userInputUserIdLabel3.setText(bundle.getString("MainForm.userInputUserIdLabel3.text"));
                        userInputUserIdLabel3.setHorizontalAlignment(SwingConstants.TRAILING);

                        //---- userInputUserIdField3 ----
                        userInputUserIdField3.setEditable(false);

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

                        //---- userInputClearButton3 ----
                        userInputClearButton3.setText(bundle.getString("MainForm.userInputClearButton3.text"));
                        userInputClearButton3.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                userInputAddNewButtonActionPerformed(e);
                                userInputClearButtonActionPerformed(e);
                            }
                        });

                        //---- userInputAdminCheckBox3 ----
                        userInputAdminCheckBox3.setText(bundle.getString("MainForm.userInputAdminCheckBox3.text"));
                        userInputAdminCheckBox3.setHorizontalTextPosition(SwingConstants.LEADING);
                        userInputAdminCheckBox3.setIconTextGap(10);
                        userInputAdminCheckBox3.setHorizontalAlignment(SwingConstants.TRAILING);

                        GroupLayout userInputPanel3Layout = new GroupLayout(userInputPanel3);
                        userInputPanel3.setLayout(userInputPanel3Layout);
                        userInputPanel3Layout.setHorizontalGroup(
                            userInputPanel3Layout.createParallelGroup()
                                .addGroup(userInputPanel3Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(userInputPanel3Layout.createParallelGroup()
                                        .addGroup(userInputPanel3Layout.createSequentialGroup()
                                            .addComponent(userInputUserIdLabel3, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(userInputUserIdField3, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(userInputActiveCheckBox2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                                            .addComponent(userInputEmployeeNoLabel3, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(userInputEmployeeNoField3, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(userInputPanel3Layout.createSequentialGroup()
                                            .addGroup(userInputPanel3Layout.createParallelGroup()
                                                .addComponent(userInputUsernameLabel3, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(userInputPasswordLabel3, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(userInputPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(userInputUsernameField3, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                                .addComponent(userInputPasswordField3))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(userInputPanel3Layout.createParallelGroup()
                                                .addComponent(userInputAdminCheckBox2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(userInputAdminCheckBox3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(userInputPanel3Layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(userInputClearButton3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(userInputAddNewButton3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
                                    .addContainerGap())
                        );
                        userInputPanel3Layout.setVerticalGroup(
                            userInputPanel3Layout.createParallelGroup()
                                .addGroup(userInputPanel3Layout.createSequentialGroup()
                                    .addGap(4, 4, 4)
                                    .addGroup(userInputPanel3Layout.createParallelGroup()
                                        .addGroup(userInputPanel3Layout.createSequentialGroup()
                                            .addGroup(userInputPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(userInputUserIdLabel3)
                                                .addComponent(userInputUserIdField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(userInputActiveCheckBox2))
                                            .addGap(6, 6, 6)
                                            .addGroup(userInputPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(userInputUsernameLabel3)
                                                .addComponent(userInputUsernameField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(userInputAdminCheckBox2))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(userInputPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(userInputPasswordLabel3)
                                                .addComponent(userInputPasswordField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(userInputAdminCheckBox3))
                                            .addGap(44, 64, Short.MAX_VALUE))
                                        .addGroup(userInputPanel3Layout.createSequentialGroup()
                                            .addGroup(userInputPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(userInputEmployeeNoField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(userInputEmployeeNoLabel3))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                                            .addGroup(userInputPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(userInputAddNewButton3)
                                                .addComponent(userInputClearButton3))
                                            .addContainerGap())))
                        );
                    }

                    GroupLayout manageItemsPanelLayout = new GroupLayout(manageItemsPanel);
                    manageItemsPanel.setLayout(manageItemsPanelLayout);
                    manageItemsPanelLayout.setHorizontalGroup(
                        manageItemsPanelLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, manageItemsPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(userInputPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addComponent(itemsScrollPane, GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
                    );
                    manageItemsPanelLayout.setVerticalGroup(
                        manageItemsPanelLayout.createParallelGroup()
                            .addGroup(manageItemsPanelLayout.createSequentialGroup()
                                .addComponent(itemsScrollPane, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(userInputPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                    );
                }
                tabbedPane1.addTab(bundle.getString("MainForm.manageItemsPanel.tab.title"), manageItemsPanel);
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
    private JMenuItem updateChangesMenuItem;
    private JMenuItem refreshButton;
    private JTabbedPane tabbedPane1;
    private JPanel overviewPanel;
    private JPanel income24hPanel;
    private JLabel income24hLabel;
    private JPanel income7dPanel;
    private JLabel income7dLabel;
    private JPanel income28dPanel;
    private JLabel income28dLabel;
    private JPanel ordersInProgPanel;
    private JLabel ordersInProgLabel;
    private JPanel orders24HPanel;
    private JLabel orders24HLabel;
    private JPanel orders7DPanel;
    private JLabel orders7DLabel;
    private JPanel orders28DPanel;
    private JLabel orders28DLabel;
    private JPanel incomeTotalPanel;
    private JLabel incomeTotalLabel;
    private JPanel ordersTotalPanel;
    private JLabel ordersTotalLabel;
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
    private JPanel userInputPanel2;
    private JLabel userInputUsernameLabel2;
    private JLabel userInputPasswordLabel2;
    private JLabel userInputEmployeeNoLabel2;
    private JTextField userInputUsernameField2;
    private JTextField userInputEmployeeNoField2;
    private JButton userInputAddNewButton2;
    private JLabel userInputUserIdLabel2;
    private JTextField userInputUserIdField2;
    private JPasswordField userInputPasswordField2;
    private JButton userInputClearButton2;
    private JPanel manageItemsPanel;
    private JScrollPane itemsScrollPane;
    private JTable itemsTable;
    private JPanel userInputPanel3;
    private JLabel userInputUsernameLabel3;
    private JLabel userInputPasswordLabel3;
    private JLabel userInputEmployeeNoLabel3;
    private JTextField userInputUsernameField3;
    private JTextField userInputEmployeeNoField3;
    private JButton userInputAddNewButton3;
    private JLabel userInputUserIdLabel3;
    private JTextField userInputUserIdField3;
    private JCheckBox userInputActiveCheckBox2;
    private JCheckBox userInputAdminCheckBox2;
    private JPasswordField userInputPasswordField3;
    private JButton userInputClearButton3;
    private JCheckBox userInputAdminCheckBox3;
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

	public void modifyUser() {
		System.out.println("modifyUser ROWS = " + usersTable.getRowCount());
		try {
			for (int rowIndex = 0; rowIndex<=usersTable.getRowCount(); rowIndex++) {
				//Get the row that was changed.
				System.out.println("\tLOOP! "+rowIndex);

				String uid = (String) usersTable.getModel().getValueAt(rowIndex, 0);
				String username = (String) usersTable.getModel().getValueAt(rowIndex, 1);
				String password = (String) usersTable.getModel().getValueAt(rowIndex, 2);
				String isActive = (String) usersTable.getModel().getValueAt(rowIndex, 3);
				String isAdmin = (String) usersTable.getModel().getValueAt(rowIndex, 4);
				String employeeNumber = (String) usersTable.getModel().getValueAt(rowIndex, 5);
				String firstName = (String) usersTable.getModel().getValueAt(rowIndex, 6);
				String lastName = (String) usersTable.getModel().getValueAt(rowIndex, 7);

				//Send the modifications!
				Client client = new Client();
				client.setURL(url);
				String[] result = client.modifyUser(
						creds,
						Integer.parseInt(uid),
						username,
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

				if (!password.equals("********")) {
					//Send the modifications!
					Client client2 = new Client();
					client.setURL(url);
					String[] result2 = client.modifyUserPassword(
							creds,
							Integer.parseInt(uid),
							password);

					if (!result2[0].equals("1")) {
						JOptionPane.showMessageDialog(frame1, "<html>Error!<br>Error Code: " + result[0] + "<br>Message: " + result[1] + "</html>");
						return;
					} else if (result2[0].equals("1")) {
						//Everything was great case. Generally do nothing.
						System.out.println("USER MODIFY SUCCESS!");
					}
				}
			}
		}
		catch (ArrayIndexOutOfBoundsException ex){
			System.err.println("THIS SEEMS BAD IF IT KEEPS HAPPENING");
		}
		finally {
			updateUserTable();
		}
	}

	public void modifyItem() {
		System.out.println("modifyItem ROWS = "+itemsTable.getRowCount());
		try {
			for (int rowIndex = 0; rowIndex<=itemsTable.getRowCount(); rowIndex++) {
				//Get the row that was changed.
				System.out.println("\tLOOP! "+rowIndex);

				String iid = (String) itemsTable.getModel().getValueAt(rowIndex, 0);
				String itemName = (String) itemsTable.getModel().getValueAt(rowIndex, 1);
				String itemDesc = (String) itemsTable.getModel().getValueAt(rowIndex, 2);
				String itemPrice = (String) itemsTable.getModel().getValueAt(rowIndex, 3);
				String itemAvail = (String) itemsTable.getModel().getValueAt(rowIndex, 4);
				String itemVeget = (String) itemsTable.getModel().getValueAt(rowIndex, 5);
				String itemVegan = (String) itemsTable.getModel().getValueAt(rowIndex, 6);
				String itemSpicy = (String) itemsTable.getModel().getValueAt(rowIndex, 7);

				//Send the modifications!
				Client client = new Client();
				client.setURL(url);
				String[] result = client.modifyItem(
						creds,
						Integer.parseInt(iid),
						itemName,
						itemDesc,
						Integer.parseInt(itemPrice),
						Integer.parseInt(itemAvail),
						Integer.parseInt(itemVeget),
						Integer.parseInt(itemVegan),
						Integer.parseInt(itemSpicy));

				if (!result[0].equals("1")) {
					JOptionPane.showMessageDialog(frame1, "<html>Error!<br>Error Code: " + result[0] + "<br>Message: " + result[1] + "</html>");
					return;
				} else if (result[0].equals("1")) {
					//Everything was great case. Generally do nothing.
					System.out.println("ITEM MODIFY SUCCESS!");
				}

			}
		}
		catch (ArrayIndexOutOfBoundsException ex){
			System.err.println("THIS SEEMS BAD IF IT KEEPS HAPPENING");
		}
		finally {
			updateUserTable();
		}
	}

	public void modifyTable() {
		System.out.println("modifyTable ROWS = "+tablesTable.getRowCount());
		try {
			for (int rowIndex = 0; rowIndex<=tablesTable.getRowCount(); rowIndex++) {
				//Get the row that was changed.
				System.out.println("\tLOOP! "+rowIndex);

				String tid = (String) tablesTable.getModel().getValueAt(rowIndex, 0);
				String tableNo = (String) tablesTable.getModel().getValueAt(rowIndex, 1);
				String tableDesc = (String) tablesTable.getModel().getValueAt(rowIndex, 2);
				String tableAvail = (String) tablesTable.getModel().getValueAt(rowIndex, 3);
				String tableSeats = (String) tablesTable.getModel().getValueAt(rowIndex, 4);

				//Send the modifications!
				Client client = new Client();
				client.setURL(url);
				String[] result = client.modifyTable(
						creds,
						Integer.parseInt(tid),
						Integer.parseInt(tableNo),
						tableDesc,
						Integer.parseInt(tableAvail),
						Integer.parseInt(tableSeats));

				if (!result[0].equals("1")) {
					JOptionPane.showMessageDialog(frame1, "<html>Error!<br>Error Code: " + result[0] + "<br>Message: " + result[1] + "</html>");
					return;
				} else if (result[0].equals("1")) {
					//Everything was great case. Generally do nothing.
					System.out.println("TABLE MODIFY SUCCESS!");
				}

			}
		}
		catch (ArrayIndexOutOfBoundsException ex){
			System.err.println("THIS SEEMS BAD IF IT KEEPS HAPPENING");
		}
		finally {
			updateUserTable();
		}
	}

	public void updateItemTable() {
		System.out.println("updateItemTable");

		DefaultTableModel model = (DefaultTableModel) itemsTable.getModel();
		//Clear before each refresh
		model.setRowCount(0);
		model.setColumnCount(0);
		itemsTable.revalidate();

		model.addColumn("I_Id");
		model.addColumn("Item Name");
		model.addColumn("Description");
		model.addColumn("Price");
		model.addColumn("Is Available");
		model.addColumn("Is Vegetarian");
		model.addColumn("Is Vegan");
		model.addColumn("Is Spicy");

		Client client = new Client();
		client.setURL(url);
		String[] result = client.getItems(creds);
		
		if(!result[0].equals("1")) {
			JOptionPane.showMessageDialog(frame1, "<html>Error!<br>Error Code: "+result[0]+"<br>Message: "+result[1]+"</html>");
			return;
		}

		String[] trimmedResult = Arrays.copyOfRange(result, 1, result.length);

		String[][] items = new String[trimmedResult.length/8][8];
		System.out.println("length = "+trimmedResult.length);

		int x = 0;
		for(int i = 0; trimmedResult.length>i; i = i + 8) {
			String[] item = new String[] {
					trimmedResult[i+0], //IID
					trimmedResult[i+1], //Name
					trimmedResult[i+2], //Desc
					trimmedResult[i+3], //Price
					trimmedResult[i+4], //Avail
					trimmedResult[i+5], //Veg
					trimmedResult[i+6],  //Vegan
					trimmedResult[i+7]  //Spicy

			};
			items[x] = item;
			x++;
		}

		for(String[] item : items) {
			String iid = item[0];
			String name = item[1];
			String description = item[2];
			String price = item[3];
			String available = item[4];
			String vegetarian = item[5];
			String vegan = item[6];
			String spicy = item[7];

			Object[] row = { iid, name, description, price, available, vegetarian, vegan, spicy};
			model.addRow(row);
		}
	}

	public void updateUserTable() {

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

		Client client = new Client();
		client.setURL(url);
		String[] result = client.getUsers(creds);

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

	public void updateTablesTable() {

		DefaultTableModel model = (DefaultTableModel) tablesTable.getModel();
		//Clear before each refresh
		model.setRowCount(0);
		model.setColumnCount(0);
		tablesTable.revalidate();

		model.addColumn("T_Id");
		model.addColumn("Table Number");
		model.addColumn("Description");
		model.addColumn("Available");
		model.addColumn("Seats");

		Client client = new Client();
		client.setURL(url);
		String[] result = client.getTables(creds);

		if(!result[0].equals("1")) {
			JOptionPane.showMessageDialog(frame1, "<html>Error!<br>Error Code: "+result[0]+"<br>Message: "+result[1]+"</html>");
			return;
		}

		String[] trimmedResult = Arrays.copyOfRange(result, 1, result.length);

		String[][] tables = new String[trimmedResult.length/5][5];
		System.out.println("length = "+trimmedResult.length);

		int x = 0;
		for(int i = 0; trimmedResult.length>i; i = i + 5) {
			String[] table = new String[] {
					trimmedResult[i+0], //TID
					trimmedResult[i+1], //No
					trimmedResult[i+2], //Desc
					trimmedResult[i+3], //Avail
					trimmedResult[i+4], //Seats
			};
			tables[x] = table;
			x++;
		}

		for(String[] table : tables) {
			String tid = table[0];
			String tableno = table[1];
			String description = table[2];
			String available = table[3];
			String seats = table[4];
			Object[] row = { tid, tableno, description, available, seats};
			model.addRow(row);
		}
	}

	public void updateHome() {

		Client client = new Client();
		client.setURL(url);
		String[] results = client.getManagementData(creds);

		Currency currency = Currency.getInstance(Locale.UK);

		income24hLabel.setText(currency.getSymbol(Locale.UK)+results[1]);
		income7dLabel.setText(currency.getSymbol(Locale.UK)+results[2]);
		income28dLabel.setText(currency.getSymbol(Locale.UK)+results[3]);
		incomeTotalLabel.setText(currency.getSymbol(Locale.UK)+results[4]);
		orders24HLabel.setText(results[5]);
		orders7DLabel.setText(results[6]);
		orders28DLabel.setText(results[7]);
		ordersTotalLabel.setText(results[8]);
		ordersInProgLabel.setText(results[9]);
	}

	public void setVisibility(boolean vis) {
		frame1.setVisible(vis);
	}


	public void setURL(String URL) {
		url = URL;
	}
}
