package aydoo.edu.tp.ui;

import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.json.JSONArray;
import org.json.JSONObject;

public class EditEntity {

	public EditEntity(String content) {
		JFrame frame = new JFrame("Edit entity");
		frame.setSize(200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		Box box = Box.createVerticalBox();
		frame.add(box);

		drawFields(content, box);

		frame.setVisible(true);
	}

	private void drawFields(String content, Box box) {
		JSONObject jsonObject = new JSONObject(content);
		JSONArray campos = jsonObject.getJSONArray("campos");

		for (int i = 0; i < campos.length(); i++) {
			JSONObject object = campos.getJSONObject(i);

			String name = object.getString("nombre");

			JPanel jPanel = new JPanel(new GridLayout());
			JLabel nameLabel = new JLabel(name);
			JTextField nameInput = new JTextField("", 15);
			jPanel.add(nameLabel);
			jPanel.add(nameInput);

			box.add(jPanel);
		}

		JButton button = new JButton("GUARDAR");
		button.setHorizontalAlignment(SwingConstants.CENTER);
		box.add(button);
	}

}