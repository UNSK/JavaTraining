package interpret;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 */
public class InterpretView extends JFrame {
    
    private static final long serialVersionUID = 1L;
    
    public JTextField cNameField;
    public JComboBox<String> cNameCombo;
    public JButton createButton;
    public JTextField argsTextField;
    public JList<Constructor<?>> constructorJList;
    public JList<Field> fieldJList;
    public JList<Object> objectJList;
    public JList<Method> methodJList;
    public JLabel fieldLabel;
    public JTextField valueField;
    
    private String[] cNameList = {
            "java.lang.String", "java.lang.Double", "interpret.TestSub"};

    /**
     * construct Interpret
     */
    public InterpretView() {
        getContentPane().setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Interpret");
        setSize(500, 500);
        
        
        cNameCombo = new JComboBox<>(cNameList);
        cNameCombo.setSelectedIndex(-1);
        cNameCombo.setEditable(true);
        //TODO how to search class name
        cNameField = (JTextField) cNameCombo.getEditor().getEditorComponent();
        cNameField.setText("");
        cNameField.addKeyListener(new ClassNameComboHandler(cNameCombo));
        //add(cNameCombo);
        
        //constructor list
        constructorJList = new JList<>(ObjectManager.getConstructorListModel());
        JScrollPane constructorScroll = new JScrollPane();
        constructorScroll.getViewport().setView(constructorJList);
        constructorScroll.setPreferredSize(null);
        //add(constructorScroll);
        
        //arguments text field
        argsTextField = new JTextField(10);
        
        //create button
        createButton = new JButton("Create");
        //add(createButton);
        
        JPanel creationPanel = new JPanel();
        creationPanel.setLayout(new BoxLayout(creationPanel, BoxLayout.Y_AXIS));
        creationPanel.add(cNameCombo);
        creationPanel.add(constructorScroll);
        creationPanel.add(argsTextField);
        creationPanel.add(createButton);
        this.add(creationPanel);
        
        //object list
        objectJList = new JList<>(ObjectManager.getObjectListModel());
        JScrollPane objectScroll = new JScrollPane();
        objectScroll.getViewport().setView(objectJList);
        objectScroll.setPreferredSize(null);
        add(objectScroll);
        
        //field list
        fieldJList = new JList<>(ObjectManager.getFieldListModel());
        JScrollPane fieldScroll = new JScrollPane();
        fieldScroll.getViewport().setView(fieldJList);
        fieldScroll.setPreferredSize(null);
        add(fieldScroll);
        
        //field details
        fieldLabel = new JLabel("Value\n");
        add(fieldLabel);
        valueField = new JTextField("value", 10);
        add(valueField);
        
        //method list
        methodJList = new JList<>(ObjectManager.getMethodListModel());
        JScrollPane methodScroll = new JScrollPane();
        methodScroll.getViewport().setView(methodJList);
        methodScroll.setPreferredSize(null);
        add(methodScroll);
        
        pack();
        setSize(getPreferredSize());
        setVisible(true);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | UnsupportedLookAndFeelException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @return the cNameCombo
     */
    public JComboBox<String> getcNameCombo() {
        return cNameCombo;
    }

    /**
     * @return the classNField
     */
    public JTextField getCNameField() {
        return cNameField;
    }

    /**
     * @return the createButton
     */
    public JButton getCreateButton() {
        return createButton;
    }
    
    /**
     * @return the fieldList() 
     */
    public JList<Field> getFieldJList() {
        return fieldJList;
    }

    /**
     * @return the objectList
     */
    public JList<Object> getObjectJList() {
        return objectJList;
    }

    /**
     * @return the fieldLabel
     */
    public JLabel getFieldLabel() {
        return fieldLabel;
    }

    /**
     * @return the valueField
     */
    public JTextField getValueField() {
        return valueField;
    }

    
    
}
