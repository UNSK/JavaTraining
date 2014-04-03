package interpret;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;


/**
 *
 */
public class InterpretView extends JFrame {
    
    private static final long serialVersionUID = 1L;
    
    public JTextField cNameField;
    public JComboBox<String> cNameCombo;
    public JButton createButton;
    
    private String[] cNameList = {
            "java.lang.String", "java.lang.Double", "interpret.TestSub"};

    /**
     * construct Interpret
     */
    public InterpretView() {
        getContentPane().setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Interpret");
        setSize(500, 200);
        
        
        cNameCombo = new JComboBox<>(cNameList);
        cNameCombo.setSelectedIndex(-1);
        cNameCombo.setEditable(true);
        //TODO how to search class name
        cNameField = (JTextField) cNameCombo.getEditor().getEditorComponent();
        cNameField.setText("");
        cNameField.addKeyListener(new ClassNameComboHandler(cNameCombo));
        add(cNameCombo);
        
        //create button
        createButton = new JButton("create");
        add(createButton);
        
        setVisible(true);
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
    
}
