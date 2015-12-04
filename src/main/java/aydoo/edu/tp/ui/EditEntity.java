package aydoo.edu.tp.ui;

import aydoo.edu.tp.entity.InputEntity;
import aydoo.edu.tp.entity.InputFieldEntity;
import aydoo.edu.tp.exporter.FileExporter;
import aydoo.edu.tp.exporter.JsonFileExporter;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class EditEntity implements ActionListener {

	private static final String EXTENSION = ".json";
    private String entityName;
    private String outputFileName;
    private JButton buttonSave;
    private JFrame frame = new JFrame("Edit entity");
    private Map<JLabel, JTextField> attributes = new LinkedHashMap<>();

    public EditEntity(String content, String fileDefinitionName) {
        outputFileName = extractFileName(fileDefinitionName)+EXTENSION;
        entityName = capitalize(extractFileName(fileDefinitionName));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        Box box = Box.createVerticalBox();
        frame.add(box);        
        
        
        box.add(addFieldAndValue("Nombre de entidad", entityName));        
        box.add(addFieldAndValue("Archivo de definición", outputFileName));

        drawFields(content, box);

        frame.setSize(350, 50 * attributes.size());

        frame.setVisible(true);
        frame.setResizable(false);
    }

    private String capitalize(String line)
    {
      return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }



	private Component addFieldAndValue(String fieldName, String fieldValue) {
		
        SpringLayout layout = new SpringLayout();
        JLabel field = new JLabel(fieldName);
        JLabel value = new JLabel(fieldValue);
        JPanel jPanel = new JPanel(layout);                
        jPanel.add(field);
        jPanel.add(value);
        layout.putConstraint(SpringLayout.WEST, field, 5, SpringLayout.WEST, jPanel);
        layout.putConstraint(SpringLayout.NORTH, field, 3, SpringLayout.NORTH, jPanel);
        layout.putConstraint(SpringLayout.WEST, value, 200, SpringLayout.WEST, jPanel);
        layout.putConstraint(SpringLayout.NORTH, value, 3, SpringLayout.NORTH, jPanel);
        
		return jPanel;
	}
	
	private String extractFileName(String fileDefinitionName) {
        return (fileDefinitionName.substring(11, fileDefinitionName.length() - 5));
    }	

    private void drawFields(String content, Box box) {
        JSONObject jsonObject = new JSONObject(content);
        JSONArray campos = jsonObject.getJSONArray("campos");        
        for (int i = 0; i < campos.length(); i++) {
            JSONObject object = campos.getJSONObject(i);
            String name = object.getString("nombre");
            box.add(makeField(name));
        }

        buttonSave = new JButton("GUARDAR");
        buttonSave.addActionListener(this);
        buttonSave.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    save();
                }
            }
        });
        buttonSave.setHorizontalAlignment(SwingConstants.CENTER);
        box.add(buttonSave);
    }

    private JPanel makeField(String name) {

        SpringLayout layout = new SpringLayout();
        JLabel nameLabel = new JLabel(name);
        JPanel jPanel = new JPanel(layout);
        JTextField nameInput = new JTextField("", 10);

        jPanel.add(nameLabel);
        jPanel.add(nameInput);

        layout.putConstraint(SpringLayout.WEST, nameLabel, 5, SpringLayout.WEST, jPanel);
        layout.putConstraint(SpringLayout.NORTH, nameLabel, 3, SpringLayout.NORTH, jPanel);
        layout.putConstraint(SpringLayout.WEST, nameInput, 200, SpringLayout.WEST, jPanel);
        layout.putConstraint(SpringLayout.NORTH, nameInput, 3, SpringLayout.NORTH, jPanel);

        attributes.put(nameLabel, nameInput);

        return jPanel;
    }

    private void save() {
        FileExporter generator = new JsonFileExporter(this.getEntity());
        try {
            generator.export();
            frame.setVisible(false);
            frame.dispose();
        } catch (IOException error) {
            error.printStackTrace();
        }

    }

    private InputEntity getEntity() {
        List<InputFieldEntity> fields = new LinkedList<>();
        for (JLabel attribute : attributes.keySet()) {
            InputFieldEntity input = new InputFieldEntity(attribute.getText(), attributes.get(attribute).getText());
            fields.add(input);
        }        
        return new InputEntity(entityName, outputFileName, fields);
    }
    
	@Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == buttonSave) {
            save();
        }
    }
}