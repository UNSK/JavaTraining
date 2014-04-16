package interpret;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 */
public class InterpretView extends JFrame {
    
    private static final long serialVersionUID = 1L;
    
    private JTextField cNameField;
    private JComboBox<String> cNameCombo;
    private JButton createButton;
    private JTextField arraySizeField;
    private JButton createArrayButton;
    private JTextField constArgsTextField;
    private JTextField arrConstTextField;
    private JButton arrInitButton;
    private JList<Constructor<?>> constructorJList;
    private JList<Field> fieldJList;
    private JList<Object> objectJList;
    private JList<Method> methodJList;
    private JList<Object> arrayJList;
    private JLabel fieldLabel;
    private JTextField valueField;
    private static JLabel statusBar;
    
    private JButton fieldSetButton;
    private JTextField methodArgsTextField;
    private JButton methodInvokeButton;
    private JTextField retValField;
    


    private String[] cNameList = {
            "java.lang.String", "java.lang.Double", "interpret.TestSub",
            "java.awt.Frame"};

    /**
     * construct Interpret
     */
    public InterpretView() {
        getContentPane().setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Interpret");
        setSize(500, 500);
        
        Dimension dim = new Dimension(400, 150);
        
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
        constructorScroll.setPreferredSize(dim);
        //add(constructorScroll);
        
        //arguments text field
        constArgsTextField = new JTextField();
        //create button
        createButton = new JButton("Create");
        //array size text field
        arraySizeField = new JTextField();
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
        objectScroll.setPreferredSize(dim);
        //add(objectScroll);
        
        //array value list
        arrayJList = new JList<>(ObjectManager.getArrayValueListModel());
        JScrollPane arrElemScroll = new JScrollPane();
        arrElemScroll.getViewport().setView(arrayJList);
        arrElemScroll.setPreferredSize(dim);
        
        //element instantiate 
        arrConstTextField = new JTextField();
        arrInitButton = new JButton("Init Element");
        JPanel arrInitPanel = new JPanel();
        arrInitPanel.setLayout(new GridLayout(1, 1));
        arrInitPanel.add(arrConstTextField);
        arrInitPanel.add(arrInitButton);
        
        JPanel creationPanel = new JPanel();
        creationPanel.setLayout(new BoxLayout(creationPanel, BoxLayout.Y_AXIS));
        creationPanel.add(cNameCombo);
        JLabel cLabel = new JLabel("Constructors");
        cLabel.setAlignmentX(CENTER_ALIGNMENT);
        creationPanel.add(cLabel);
        creationPanel.add(constructorScroll);
        creationPanel.add(creationSubPanel);
        JLabel oLabel = new JLabel("Objects");
        oLabel.setAlignmentX(CENTER_ALIGNMENT);
        creationPanel.add(oLabel);
        creationPanel.add(objectScroll);
        creationPanel.add(arrElemScroll);
        creationPanel.add(arrInitPanel);
        this.add(creationPanel, BorderLayout.WEST);
        
        
        //field list
        fieldJList = new JList<>(ObjectManager.getFieldListModel());
        JScrollPane fieldScroll = new JScrollPane();
        fieldScroll.getViewport().setView(fieldJList);
        fieldScroll.setPreferredSize(dim);
        
        
        //field details
        valueField = new JTextField();
        //field set button
        fieldSetButton = new JButton("Set");

        JPanel fieldSubPanel = new JPanel();
        fieldSubPanel.setLayout(new GridLayout(1, 1));
        fieldSubPanel.add(valueField);
        fieldSubPanel.add(fieldSetButton);
        
       
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(new BoxLayout(fieldPanel, BoxLayout.Y_AXIS));
        JLabel fLabel = new JLabel("Fileds", SwingConstants.CENTER);
        fLabel.setAlignmentX(CENTER_ALIGNMENT);
        fieldPanel.add(fLabel);
        fieldPanel.add(fieldScroll);
        fieldPanel.add(fieldSubPanel);
        add(fieldPanel);
        
        //method list
        methodJList = new JList<>(ObjectManager.getMethodListModel());
        JScrollPane methodScroll = new JScrollPane();
        methodScroll.getViewport().setView(methodJList);
        methodScroll.setPreferredSize(dim);
        
        //method arguments text field
        methodArgsTextField = new JTextField(10);   
        //method invoke button
        methodInvokeButton = new JButton("Invoke");
        //return value
        JLabel retValJLabel = new JLabel("return value: ");
        retValField = new JTextField("null");
        retValField.setEditable(false);
        
        JPanel methodSubPanel = new JPanel();
        methodSubPanel.setLayout(new GridLayout(2, 2));
        methodSubPanel.add(methodArgsTextField);
        methodSubPanel.add(methodInvokeButton);
        methodSubPanel.add(retValJLabel);
        methodSubPanel.add(retValField);
        
        
        JPanel methodPanel = new JPanel();
        methodPanel.setLayout(new BoxLayout(methodPanel, BoxLayout.Y_AXIS));
        JLabel mLabel = new JLabel("Methods", SwingConstants.CENTER);
        mLabel.setAlignmentX(CENTER_ALIGNMENT);
        methodPanel.add(mLabel);
        methodPanel.add(methodScroll);
        methodPanel.add(methodSubPanel);
        add(methodPanel);
        
        JTextArea usageText = new JTextArea();
        usageText.append("USAGE:\n");
        usageText.append("  String: put \" arround. (ex. \"foo\")\n"); 
        usageText.append("  char: put ' arround. (ex. 'c')\n");
        usageText.append("  Object: assign the number of instance in left pane, after #. (ex. #0)\n");
        usageText.append("  Array: write the index after Object like in code. (ex. #1[2])");
        usageText.setEditable(false);
        usageText.setBackground(getBackground());
        
        JPanel membersPanel = new JPanel();
        membersPanel.setLayout(new BoxLayout(membersPanel, BoxLayout.Y_AXIS));
        membersPanel.add(fieldPanel);
        membersPanel.add(methodPanel);
        membersPanel.add(usageText);
        add(membersPanel, BorderLayout.EAST);
        
        statusBar = new JLabel("Ready");
        add(statusBar, BorderLayout.SOUTH);
        
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

    public static void setStatus(String msg, Color color) {
        statusBar.setText(msg);
        statusBar.setForeground(color);
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
     * @return the arrConstTextField
     */
    public JTextField getArrConstTextField() {
        return arrConstTextField;
    }

    /**
     * @return the arrInitButton
     */
    public JButton getArrInitButton() {
        return arrInitButton;
    }

    /**
     * @return the constructorJList
     */
    public JList<Constructor<?>> getConstructorJList() {
        return constructorJList;
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
     * @return the arrayJList
     */
    public JList<Object> getArrayJList() {
        return arrayJList;
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

    /**
     * @return the retValField
     */
    public JTextField getRetValField() {
        return retValField;
    }

    /**
     * @return the statusBar
     */
    public JLabel getStatusBar() {
        return statusBar;
    }
    
}
