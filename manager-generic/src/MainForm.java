import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
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
		manageUsersPanel = new JPanel();
		usersScrollPane = new JScrollPane();
		usersTable = new JTable();
		manageTablesPanel = new JPanel();
		tablesScrollPane = new JScrollPane();
		tablesTable = new JTable();
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
						ordersTodayPanel.setBorder(new TitledBorder("Orders Today"));
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
										.addComponent(ordersInProgPanel, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 292, Short.MAX_VALUE)
										.addComponent(tablesTodayPanel, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
									.addGroup(overviewPanelLayout.createSequentialGroup()
										.addGroup(overviewPanelLayout.createParallelGroup()
											.addComponent(income28dPanel, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
											.addComponent(averageIncomeDailyPanel, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
										.addGap(0, 678, Short.MAX_VALUE)))
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
									.addGroup(overviewPanelLayout.createSequentialGroup()
										.addGroup(overviewPanelLayout.createParallelGroup()
											.addComponent(income7dPanel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
											.addComponent(tablesTodayPanel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(income28dPanel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
									.addComponent(ordersInProgPanel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(averageIncomeDailyPanel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(95, Short.MAX_VALUE))
					);
				}
				tabbedPane1.addTab(bundle.getString("MainForm.overviewPanel.tab.title"), overviewPanel);

				//======== manageUsersPanel ========
				{

					//======== usersScrollPane ========
					{
						usersScrollPane.setViewportView(usersTable);
					}

					GroupLayout manageUsersPanelLayout = new GroupLayout(manageUsersPanel);
					manageUsersPanel.setLayout(manageUsersPanelLayout);
					manageUsersPanelLayout.setHorizontalGroup(
						manageUsersPanelLayout.createParallelGroup()
							.addGroup(GroupLayout.Alignment.TRAILING, manageUsersPanelLayout.createSequentialGroup()
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(usersScrollPane, GroupLayout.PREFERRED_SIZE, 868, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
					);
					manageUsersPanelLayout.setVerticalGroup(
						manageUsersPanelLayout.createParallelGroup()
							.addGroup(manageUsersPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(usersScrollPane, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(143, Short.MAX_VALUE))
					);
				}
				tabbedPane1.addTab(bundle.getString("MainForm.manageUsersPanel.tab.title"), manageUsersPanel);

				//======== manageTablesPanel ========
				{

					//======== tablesScrollPane ========
					{
						tablesScrollPane.setViewportView(tablesTable);
					}

					GroupLayout manageTablesPanelLayout = new GroupLayout(manageTablesPanel);
					manageTablesPanel.setLayout(manageTablesPanelLayout);
					manageTablesPanelLayout.setHorizontalGroup(
						manageTablesPanelLayout.createParallelGroup()
							.addGroup(manageTablesPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(tablesScrollPane, GroupLayout.PREFERRED_SIZE, 868, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					);
					manageTablesPanelLayout.setVerticalGroup(
						manageTablesPanelLayout.createParallelGroup()
							.addGroup(manageTablesPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(tablesScrollPane, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(143, Short.MAX_VALUE))
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
								.addContainerGap(143, Short.MAX_VALUE))
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
								.addContainerGap(143, Short.MAX_VALUE))
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
	private JPanel manageUsersPanel;
	private JScrollPane usersScrollPane;
	private JTable usersTable;
	private JPanel manageTablesPanel;
	private JScrollPane tablesScrollPane;
	private JTable tablesTable;
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

	public void setVisibility(boolean vis) {
		frame1.setVisible(vis);
	}



}
