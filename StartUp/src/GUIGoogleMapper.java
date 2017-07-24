import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUIGoogleMapper {

	GoogleMap google = new GoogleMap();
	
	private JFrame frame;
	private JTextField textField;
	JLabel label;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIGoogleMapper window = new GUIGoogleMapper();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUIGoogleMapper() throws IOException {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		textField = new JTextField();
		textField.setBounds(195, 6, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton find = new JButton("Find");
		
		
		find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String place = String.valueOf(textField.getText().replace(" ", ""));

				URL url = null;
				BufferedImage c = null;
				
//					url = new URL("http://maps.googleapis.com/maps/api/staticmap?center="+ place +"&size=440x240");
				try {
					
					url = new URL(google.getMap(place));
					
				} catch (MalformedURLException e2) {
					System.out.println("Error at first try");
					e2.printStackTrace();
				}
					
				try {
					c = ImageIO.read(url);
				} catch (IOException e1) {
					System.out.println("Error at second try");
					e1.printStackTrace();
				}
				
				ImageIcon image = new ImageIcon(c);
				label.setIcon(image);
				
				//google.getMap(place);
			}
		});
		
		
		find.setBounds(327, 6, 117, 29);
		frame.getContentPane().add(find);
		
		label = new JLabel();
		label.setBounds(6, 36, 438, 236);
		frame.getContentPane().add(label);
		
		JLabel lblEnterLocationTo = new JLabel("Enter location to find");
		lblEnterLocationTo.setBounds(41, 11, 142, 16);
		frame.getContentPane().add(lblEnterLocationTo);
	}
}
