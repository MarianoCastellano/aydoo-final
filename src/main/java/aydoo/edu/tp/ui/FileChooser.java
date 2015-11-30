package aydoo.edu.tp.ui;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class FileChooser extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	static private final String newline = "\n";
	JButton openButton;
	JTextArea textArea;
	JFileChooser fileChooser;
	JPanel panel;

	public FileChooser() {
		super(new BorderLayout());

		textArea = new JTextArea(5, 20);
		textArea.setMargin(new Insets(5, 5, 5, 5));
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);

		fileChooser = new JFileChooser();

		openButton = new JButton("Open a File...");
		openButton.addActionListener(this);

		panel = new JPanel();
		panel.add(openButton);

		add(panel, BorderLayout.PAGE_START);
		add(scrollPane, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == openButton) {
			int returnVal = fileChooser.showOpenDialog(FileChooser.this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				String content = readFile(file.getPath(), Charset.defaultCharset());

				new EditEntity(content);

				textArea.append("Opening: " + file.getName() + "." + newline + content);
			}
			textArea.setCaretPosition(textArea.getDocument().getLength());
		}
	}

	private String readFile(String path, Charset encoding) {
		byte[] encoded = new byte[0];
		try {
			encoded = Files.readAllBytes(Paths.get(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new String(encoded, encoding);
	}

	private static void createAndShowGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);

		JFrame frame = new JFrame("AyDOO Final");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JComponent newContentPane = new FileChooser();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);

		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}