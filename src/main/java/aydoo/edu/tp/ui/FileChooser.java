package aydoo.edu.tp.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.charset.Charset;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class FileChooser extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JButton openButton;
    private JFileChooser fileChooser;
    private JPanel panel;

    public FileChooser() {
        super(new BorderLayout());
        fileChooser = new JFileChooser();
        openButton = new JButton("Open a File...");
        openButton.addActionListener(this);

        panel = new JPanel();
        panel.add(openButton);

        add(panel, BorderLayout.PAGE_START);
    }

    private static void createAndShowGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);

        JFrame frame = new JFrame("AyDOO Final");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openButton) {
            int returnVal = fileChooser.showOpenDialog(FileChooser.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                String content = FileUtil.readFile(file.getPath(), Charset.defaultCharset());

                new EditEntity(content, file.getName());
            }
        }
    }
}