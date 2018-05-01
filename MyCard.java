import javax.swing.*;

public class MyCard extends JButton{
  private int clickedCount = 0;

  MyCard(){
    super();
  }
  
  MyCard(ImageIcon image){
    super(image);
  }

  public void addClickedCount(){
    clickedCount++;
  }

  public int ClickedCount(){
    return clickedCount;
  }

  public void setClickedCount(int i) {
    clickedCount = i;
  }
}