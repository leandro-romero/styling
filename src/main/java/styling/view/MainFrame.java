package styling.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JButton buttonEvaluar;
	private JLabel pathLabel;
	public JTextField repositorio;
	private JPanel contentPane;

	public MainFrame() {
		super("Styling");

		Container content = this.getContentPane();
		content.setLayout(null);
		contentPane = (JPanel) this.getContentPane();

		buttonEvaluar = new JButton();

		buttonEvaluar.setText("Evaluar Codigo");

		buttonEvaluar.addActionListener(new StylingListener(this));

		pathLabel = new JLabel();

		pathLabel.setHorizontalAlignment(SwingConstants.LEFT);
		pathLabel.setForeground(new Color(0, 0, 0));
		pathLabel.setText("Path : ");

		repositorio = new JTextField();
		repositorio.setToolTipText("Ingrese el path del repositorio");
		contentPane.setLayout(null);
		contentPane.setBorder(BorderFactory.createEtchedBorder());
		contentPane.setBackground(new Color(204, 204, 204));

		addComponent(contentPane, pathLabel, 50, 30, 100, 18);
		addComponent(contentPane, repositorio, 100, 30, 200, 18);
		addComponent(contentPane, buttonEvaluar, 50, 90, 150, 30);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		this.setSize(400, 200);
	}

	private void addComponent(Container container, Component c, int x, int y, int width, int height) {
		c.setBounds(x, y, width, height);
		container.add(c);
	}

	public static void main(String[] ar) {

		MainFrame f = new MainFrame();

		f.setVisible(true);
	}
}
