import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUI implements ActionListener {
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	
	JLabel title = new JLabel("Currency Converter");
	JButton calc = new JButton("Calculate");
	JLabel input = new JLabel("Input Currency", SwingConstants.CENTER);
	JLabel output = new JLabel("Output Currency", SwingConstants.CENTER);
	JComboBox<String> inputCurrency = new JComboBox<String>(CurrencyConverter.countries);
	JComboBox<String> outputCurrency = new JComboBox<String>(CurrencyConverter.countries);
	JTextField inputAmount = new JTextField("Input amount of currency here");
	JTextField outputAmount = new JTextField("Output of converted currency goes here");
	
	public GUI() {
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panel.setLayout(new GridLayout(4, 2));
		frame.add(panel, BorderLayout.CENTER);
		
		title.setFont(new Font("Monaco", Font.BOLD, 36));
		panel.add(title);

		calc.addActionListener(this);
		panel.add(calc);
		
		input.setFont(new Font("Monaco", Font.PLAIN, 26));
		panel.add(input);
		
		output.setFont(new Font("Monaco", Font.PLAIN, 26));
		panel.add(output);
		
		panel.add(inputCurrency);
		
		panel.add(outputCurrency);
		
		panel.add(inputAmount);
		
		panel.add(outputAmount);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Currency Converter");
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		outputAmount.setText(String.valueOf(Double.parseDouble(inputAmount.getText()) * CurrencyConverter.vals[inputCurrency.getSelectedIndex()] / CurrencyConverter.vals[outputCurrency.getSelectedIndex()]));
	}
}
