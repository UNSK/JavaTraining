package interpret;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.swing.BoxLayout;
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
    public JTextField arraySizeField;
    public JButton createArrayButton;
    public JTextField constArgsTextField;
    public JList<Constructor<?>> constructorJList;
    public JList<Field> fieldJList;
    public JList<Object> objectJList;
    public JList<Method> methodJList;
    public JLabel fieldLabel;
    public JTextField valueField;
    public JButton fieldSetButton;
    public JTextField methodArgsTextField;
    public JButton methodInvokeButton;
    


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
        constArgsTextField = new JTextField("Arguments");
        //create button
        createButton = new JButton("Create");
        //array size text field
        arraySizeField = new JTextField("size");
        //add create array button
        createArrayButton = new JButton("Create Array");
        
        //TODO change to group layout
        JPanel creationSubPanel = new JPanel();
        creationSubPanel.setLayout(new GridLayout(2, 2));
        creationSubPanel.add(constArgsTextField);
        creationSubPanel.add(createButton);
        creationSubPanel.add(arraySizeField);
        creationSubPanel.add(createArrayButton);
        
        //object list
        objectJList = new JList<>(ObjectManager.getObjectListModel());
        JScrollPane objectScroll = new JScrollPane();
        objectScroll.getViewport().setView(objectJList);
        objectScroll.setPreferredSize(null);
        //add(objectScroll);
        
        JPanel creationPanel = new JPanel();
        creationPanel.setLayout(new BoxLayout(creationPanel, BoxLayout.Y_AXIS));
        creationPanel.add(cNameCombo);
        creationPanel.add(constructorScroll);
        creationPanel.add(creationSubPanel);
        creationPanel.add(objectScroll);
        this.add(creationPanel);
        
        
        //field list
        fieldJList = new JList<>(ObjectManager.getFieldListModel());
        JScrollPane fieldScroll = new JScrollPane();
        fieldScroll.getViewport().setView(fieldJList);
        fieldScroll.setPreferredSize(null);
        
        //field details
        valueField = new JTextField("value", 10);
        //field set button
        fieldSetButton = new JButton("Set");

        JPanel fieldSubPanel = new JPanel();
        fieldSubPanel.setLayout(new FlowLayout());
        fieldSubPanel.add(valueField);
        fieldSubPanel.add(fieldSetButton);
        
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(new BoxLayout(fieldPanel, BoxLayout.Y_AXIS));
        fieldPanel.add(fieldScroll);
        fieldPanel.add(fieldSubPanel);
        add(fieldPanel);
        
        //method list
        methodJList = new JList<>(ObjectManager.getMethodListModel());
        JScrollPane methodScroll = new JScrollPane();
        methodScroll.getViewport().setView(methodJList);
        methodScroll.setPreferredSize(null);
        
        //method arguments text field
        methodArgsTextField = new JTextField(10);   
        //method invoke button
        methodInvokeButton = new JButton("Invoke");
        
        JPanel methodPanel = new JPanel();
        methodPanel.setLayout(new BoxLayout(methodPanel, BoxLayout.Y_AXIS));
        methodPanel.add(methodScroll);
        methodPanel.add(methodArgsTextField);
        methodPanel.add(methodInvokeButton);
        add(methodPanel);
        
        pack();
        setSize(getPreferredSize());
        setVisible(true);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | UnsupportedLookAndFeelException e) {
            // TODO Auto-generated catch block
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
     * @return the methodJList
     */
    public JList<Method> getMethodJList() {
        return methodJList;
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

    /**
     * @return the argsTextField
     */
    public JTextField getConstArgsTextField() {
        return constArgsTextField;
    }

    /**
     * @return the fieldSetButton
     */
    public JButton getFieldSetButton() {
        return fieldSetButton;
    }
    
    /**
     * @return the methodArgsTextField
     */
    public JTextField getMethodArgsTextField() {
        return methodArgsTextField;
    }

    /**
     * @return the methodInvokeButton
     */
    public JButton getMethodInvokeButton() {
        return methodInvokeButton;
    }

    /**
     * @return the arraySizeField
     */
    public JTextField getArraySizeField() {
        return arraySizeField;
    }

    /**
     * @return the createArrayButton
     */
    public JButton getCreateArrayButton() {
        return createArrayButton;
    }
    
}
