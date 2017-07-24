//@Grab('com.github.groovy-wslite:groovy-wslite:1.1.2')
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GUIGetWeatherByZIP {
	CityWeatherByZIP zip = new CityWeatherByZIP();
	
	private JFrame frame;
	private JTextField textField;
	String text;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIGetWeatherByZIP window = new GUIGetWeatherByZIP();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUIGetWeatherByZIP() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setLocationRelativeTo(null);
		
		textField = new JTextField();
		frame.getContentPane().add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel();
		frame.getContentPane().add(lblNewLabel, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("Hit me");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text = textField.getText();
				JOptionPane.showMessageDialog(null, zip.getData(text));
			}
		});
		frame.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
	}

}
