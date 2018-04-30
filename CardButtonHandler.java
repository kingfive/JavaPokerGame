import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CardButtonHandler implements ActionListener {
  public void actionPerformed(ActionEvent event) {
    event.getSource().setLocation(((JButton) event.getSource()).getX(),
     ((JButton) event.getSource()).getY(), 50, 70);
  }
}
