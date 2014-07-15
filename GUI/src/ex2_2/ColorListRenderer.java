package ex2_2;

import java.awt.Component;
import java.awt.SystemColor;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 */
public class ColorListRenderer implements ListCellRenderer<Object> {

    private boolean focused = false;
    private JLabel renderer;
    public ColorListRenderer() {
      renderer = new JLabel();
      renderer.setOpaque (true);
    }
    
    @Override
    public Component getListCellRendererComponent(
        JList<?> list, Object value, int index, 
        boolean isSelected, boolean cellHasFocus) {
      if (value == null) {
        renderer.setText("");
        renderer.setIcon(null);
      } else {
        @SuppressWarnings("unchecked")
        Map<String, Object> map = (Map<String, Object>) value;
        renderer.setText((String) map.get("label"));
        renderer.setIcon((Icon) map.get("icon"));
      }
      renderer.setBackground(isSelected ? 
        SystemColor.textHighlight 
        : SystemColor.menu);
      renderer.setForeground(isSelected ? 
        SystemColor.textHighlightText 
        : SystemColor.menuText);
      return renderer;
    }


  
}
