package styling.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import styling.drools.DroolsResult;


public class ResultFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private HashMap<String, List<String>> hashMap;
	private JPanel contentPane;
	private JLabel mainLabel = new JLabel("Resultados conseguidos");
	private JTextArea result;
	
	public ResultFrame(DroolsResult droolsResult) {
		super("Resultado");		
		this.hashMap = droolsResult.getHashMap();
		contentPane = (JPanel)this.getContentPane();
		contentPane.setLayout(null);
		
		mainLabel.setHorizontalAlignment(SwingConstants.LEFT);
		mainLabel.setForeground(new Color(0, 0, 0));
		mainLabel.setText("Resultado de corrida:");
		
		addComponent(contentPane, mainLabel, 10, 0, 240, 18);
		
		prepareResult();
		setVisible(true);
		setSize(400, 340);
	}
	
	private void prepareResult() {
		
		StringBuilder resultText = new StringBuilder();
		
		for (String clazz : hashMap.keySet()) {
			List<String> errors = hashMap.get(clazz);
			
			resultText.append("****************  Class *******************\n");
			resultText.append(clazz + "\n\n");
			
			for (String error : errors) {
				resultText.append(error + "\n");
			}
			
			resultText.append("\n******************************************\n\n");			
			
		}
		
		resultText.append("\n\n\n\n");
		
		result = new JTextArea();
		result.setText(resultText.toString());
		result.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(result);
		
		addComponent(contentPane, scrollPane, 0, 50, 400, 300);		
	}

	private void addComponent(Container container, Component c, int x, int y, int width, int height) {
		c.setBounds(x, y, width, height);
		container.add(c);
	}
}
