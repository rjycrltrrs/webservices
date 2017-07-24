import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorGUI implements ActionListener{
	
	Calculator calc = new Calculator();

	private JFrame frame;
	private JTextField num1;
	private JTextField num2;
	private JButton btnSubtract;
	private JButton btnAdd;
	private JButton btnMultiply;
	private JButton btnDivide;
	private JPanel panel_1;
	private JLabel result;
	
	int a;
	int b;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorGUI window = new CalculatorGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CalculatorGUI() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		num1 = new JTextField();
		panel.add(num1);
		num1.setColumns(5);
		
		num2 = new JTextField();
		panel.add(num2);
		num2.setColumns(5);
		
		result = new JLabel("=");
		panel.add(result);
		
		panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		btnAdd = new JButton("Add");
		panel_1.add(btnAdd);
		btnAdd.addActionListener(this);
		
		btnSubtract = new JButton("Subtract");
		panel_1.add(btnSubtract);
		btnSubtract.addActionListener(this);
		
		btnMultiply = new JButton("Multiply");
		panel_1.add(btnMultiply);
		btnMultiply.addActionListener(this);
		
		btnDivide = new JButton("Divide");
		panel_1.add(btnDivide);
		btnDivide.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==btnAdd){
			a = Integer.parseInt(num1.getText());
			b = Integer.parseInt(num2.getText());
			
			result.setText("= "+calc.getSum(a, b));
			
		}
		else if(ae.getSource()==btnSubtract){
			a = Integer.parseInt(num1.getText());
			b = Integer.parseInt(num2.getText());
			
			result.setText("= "+calc.getDifference(a, b));
			
		}
		else if(ae.getSource()==btnMultiply){
			a = Integer.parseInt(num1.getText());
			b = Integer.parseInt(num2.getText());
			
			result.setText("= "+calc.getProduct(a, b));
			
		}
		else if(ae.getSource()==btnDivide){
			a = Integer.parseInt(num1.getText());
			b = Integer.parseInt(num2.getText());
			
			result.setText("= "+calc.getQuotient(a, b));
			
		}
	}

}
