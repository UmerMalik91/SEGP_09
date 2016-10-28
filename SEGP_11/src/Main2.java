import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Main2 extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public Main2() {
		setLayout(null);
		
		JLabel lblPersonalAcademicTutor = new JLabel("Personal Academic Tutor ");
		lblPersonalAcademicTutor.setBounds(234, 27, 195, 26);
		add(lblPersonalAcademicTutor);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(218, 175, 65, 21);
		add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(218, 257, 65, 21);
		add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(315, 175, 188, 20);
		add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(315, 257, 188, 20);
		add(passwordField);
		
		JButton btnLogin = new JButton("LogIn");
		btnLogin.setBounds(475, 327, 89, 23);
		add(btnLogin);
		btnLogin.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {

				Home p2=new Home();
				p2.setBounds(getBounds());
				removeAll();
				add(p2);
				revalidate();
				repaint();


				// TODO Auto-generated method stub

			}

		});

	}
}
