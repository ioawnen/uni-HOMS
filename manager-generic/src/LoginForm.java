import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import com.jgoodies.forms.factories.*;
/*
 * Created by JFormDesigner on Tue Apr 14 16:08:05 BST 2015
 */



/**
 * @author Ian Owen
 */
public class LoginForm extends JPanel {
	public LoginForm() {
		initComponents();
	}

	private void SignInButtonActionPerformed(ActionEvent e) {
		// TODO add your code here

		if(validateFields()) {
			String username = usernameField.getText();
			String password = new String(passwordField.getPassword());

			String[] results = new Client().authenticate(new String[] {username, password});
			if(results[0].equals("1")) {
				//CONTINUE ONWARDS

				MainForm mainForm = new MainForm();
				mainForm.setCreds(username, password);
				mainForm.updateUserTable();
				mainForm.setVisibility(true);
				dialog1.setVisible(false);
				dialog1.dispose();
			}
			else if(results[0].equals("0")) {
				JOptionPane.showMessageDialog(null,"The username or password is invalid.","HOMS | Could not login",JOptionPane.WARNING_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null,"<html>An Error Occured.<br>Error Code: "+results[0]+"<br>Message: "+results[1]+"</html>","HOMS | Error!",JOptionPane.WARNING_MESSAGE);
			}


			//TODO: REMOVE THIS AFTER IMPLEMENTING CLIENT CLASS
			/*System.out.println(getPassword());
			MainForm mainForm = new MainForm();
			mainForm.setCreds(usernameField.getText(), passwordField.getPassword().toString());

			mainForm.setCreds("ian", "password");
			mainForm.setVisibility(true);
			mainForm.updateUserTable();
			*/


		}
	}

	private void inputFieldsFocusGained(FocusEvent e) {
		// TODO add your code here
	}

	private void serverFieldKeyTyped(KeyEvent e) {
		// TODO add your code here
	}

	private void serverFieldFocusGained(FocusEvent e) {
		// TODO add your code here
		serverField.setBackground(new Color(255,255,255,255));
	}

	private void usernameFieldFocusGained(FocusEvent e) {
		// TODO add your code here
		usernameField.setBackground(new Color(255,255,255,255));
	}

	private void passwordFieldFocusGained(FocusEvent e) {
		passwordField.setBackground(new Color(255,255,255,255));
	}


	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Ian Owen
		ResourceBundle bundle = ResourceBundle.getBundle("loginform_strings");
		dialog1 = new JDialog();
		menuBar1 = new JMenuBar();
		panel1 = new JPanel();
		label3 = new JLabel();
		serverLabel = new JLabel();
		serverField = new JTextField();
		usernameLabel = new JLabel();
		usernameField = new JTextField();
		passwordLabel = new JLabel();
		passwordField = new JPasswordField();
		SignInButton = new JButton();

		//======== dialog1 ========
		{
			dialog1.setTitle(bundle.getString("LoginForm.dialog1.title"));
			Container dialog1ContentPane = dialog1.getContentPane();
			dialog1.setJMenuBar(menuBar1);

			//======== panel1 ========
			{
				panel1.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent e) {
						inputFieldsFocusGained(e);
					}
				});

				// JFormDesigner evaluation mark
				panel1.setBorder(new javax.swing.border.CompoundBorder(
					new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
						"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
						javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
						java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

				panel1.setLayout(new GridBagLayout());
				((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 0, 0, 249, 0};

				//---- label3 ----
				label3.setText(bundle.getString("LoginForm.label3.text"));
				label3.setHorizontalTextPosition(SwingConstants.CENTER);
				label3.setHorizontalAlignment(SwingConstants.CENTER);
				label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 6f));
				panel1.add(label3, new GridBagConstraints(1, 0, 3, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));

				//---- serverLabel ----
				serverLabel.setText(bundle.getString("LoginForm.serverLabel.text"));
				serverLabel.setHorizontalAlignment(SwingConstants.RIGHT);
				panel1.add(serverLabel, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));

				//---- serverField ----
				serverField.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent e) {
						serverFieldFocusGained(e);
					}
				});
				panel1.add(serverField, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));

				//---- usernameLabel ----
				usernameLabel.setText(bundle.getString("LoginForm.usernameLabel.text"));
				usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
				panel1.add(usernameLabel, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));

				//---- usernameField ----
				usernameField.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent e) {
						usernameFieldFocusGained(e);
					}
				});
				panel1.add(usernameField, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));

				//---- passwordLabel ----
				passwordLabel.setText(bundle.getString("LoginForm.passwordLabel.text"));
				passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
				panel1.add(passwordLabel, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));

				//---- passwordField ----
				passwordField.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent e) {
						passwordFieldFocusGained(e);
					}
				});
				panel1.add(passwordField, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));

				//---- SignInButton ----
				SignInButton.setText(bundle.getString("LoginForm.SignInButton.text"));
				SignInButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						SignInButtonActionPerformed(e);
					}
				});
				panel1.add(SignInButton, new GridBagConstraints(1, 6, 3, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
					new Insets(0, 0, 0, 5), 0, 0));
			}

			GroupLayout dialog1ContentPaneLayout = new GroupLayout(dialog1ContentPane);
			dialog1ContentPane.setLayout(dialog1ContentPaneLayout);
			dialog1ContentPaneLayout.setHorizontalGroup(
				dialog1ContentPaneLayout.createParallelGroup()
					.addGroup(dialog1ContentPaneLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel1, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
						.addContainerGap())
			);
			dialog1ContentPaneLayout.setVerticalGroup(
				dialog1ContentPaneLayout.createParallelGroup()
					.addGroup(dialog1ContentPaneLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel1, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
						.addContainerGap())
			);
			dialog1.pack();
			dialog1.setLocationRelativeTo(dialog1.getOwner());
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Ian Owen
	private JDialog dialog1;
	private JMenuBar menuBar1;
	private JPanel panel1;
	private JLabel label3;
	private JLabel serverLabel;
	private JTextField serverField;
	private JLabel usernameLabel;
	private JTextField usernameField;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	private JButton SignInButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables

	public boolean validateFields() {

		if(serverField.getText().length()==0){
			//System.out.println("Server required.");
			serverField.setBackground(new Color(255,255,0,255));
			return false;
		}
		if(usernameField.getText().length()==0){
			//System.out.println("Username required.");
			usernameField.setBackground(new Color(255,255,0,255));
			return false;
		}
		if(getPassword().length()==0){
			//System.out.println("Password required.");
			passwordField.setBackground(new Color(255,255,0,255));
			return false;
		}


		return true;
	}

	private String getPassword() {
		char[] pass = passwordField.getPassword();
		return new String(pass);
	}
	public void setVisibility(boolean vis) {
		dialog1.setVisible(vis);
	}

}
