import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.itextpdf.text.Image;

import javax.swing.JPasswordField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;

public class Main2 extends JPanel {
	private JTextField tEmail;
	private JPasswordField tPassword;

	/**
	 * Create the panel.
	 */
	public Main2() {
		setLayout(null);

		JLabel lblPersonalAcademicTutor = new JLabel("Personal Academic Tutor ");
		lblPersonalAcademicTutor.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 36));
		lblPersonalAcademicTutor.setBounds(171, 11, 461, 66);
		add(lblPersonalAcademicTutor);

		JLabel lEmail = new JLabel("Email");
		lEmail.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		lEmail.setBounds(365, 190, 65, 21);
		add(lEmail);

		JLabel lPassword = new JLabel("Password");
		lPassword.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lPassword.setBounds(365, 250, 97, 21);
		add(lPassword);
		
		tEmail = new JTextField();
		tEmail.setBounds(481, 186, 209, 25);
		add(tEmail);
		tEmail.setColumns(10);

		tPassword = new JPasswordField();
		tPassword.setBounds(481, 246, 209, 25);
		add(tPassword);

		JButton btnLogin = new JButton("Log In");
		btnLogin.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		btnLogin.setBounds(615, 307, 89, 21);
		add(btnLogin);

		JLabel message = new JLabel("");
		message.setBounds(481, 285, 209, 14);
		add(message);
		btnLogin.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				GetData data=new GetData();
				if(data.isUser(tEmail.getText(),tPassword.getText())){
					Home p2=new Home();
					p2.setBounds(getBounds());
					removeAll();
					add(p2);
					revalidate();
					repaint();
				}
				else
					message.setText("Email or Password is not correct");


				// TODO Auto-generated method stub

			}

		});

	}
}
