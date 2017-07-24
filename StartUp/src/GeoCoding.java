import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

public class GeoCoding {

	private JFrame frame;
	private JTextField place;
	static BrowserView browserView;
	static Browser browser;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeoCoding window = new GeoCoding();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GeoCoding() {
		browser = new Browser();
		browserView = new BrowserView(browser);
		browser.loadURL("https://www.google.com");
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1320, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(browserView, BorderLayout.CENTER);
		frame.setLocationRelativeTo(null);
		
		place = new JTextField();
		place.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				browser.loadURL(place.getText());
			}
		});
		
		
		frame.getContentPane().add(place, BorderLayout.NORTH);
		place.setColumns(10);
	}

}
