import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.event.*;

public class Table extends JFrame{
  String Filename;
  BufferedImage image;
  JPanel cardBackJPanel_top;
  MyCard[] myCardButton = new MyCard[13];
  
  public Table(){
    super("Poker Games");
    
    JMenu filemenu = new JMenu("File");
    JMenu helpmenu = new JMenu("Help");
    JMenuBar bar = new JMenuBar();
    setJMenuBar(bar);
    bar.add(filemenu);
    bar.add(helpmenu);
    
    this.setSize(1000, 500);
    this.setLayout(null);
    this.getContentPane().setBackground(new Color(57, 114, 30));
    
    createCardBack_Top(350, 0);
    createCardBack_LeftAndRight(10, 100);
    createCardBack_LeftAndRight(this.getWidth()-100, 100);
    createMyCard(200, this.getHeight()-100);

    CardButtonHandler cbh = new CardButtonHandler();
    for (int i=0; i<myCardButton.length; i++) {
      myCardButton[i].addActionListener(cbh);
    }

  }

  private class CardButtonHandler implements ActionListener{
    public void actionPerformed(ActionEvent event) {
      // JButton thisCard = new JButton();
      // thisCard = ((JButton) event.getSource());
      if ( ((MyCard) event.getSource()).ClickedCount() == 0 ) {
        ((MyCard)event.getSource()).setLocation( ((MyCard)event.getSource()).getX(), 400-10);
        ((MyCard)event.getSource()).addClickedCount();
      }
      else if(((MyCard) event.getSource()).ClickedCount() == 1){
        for (int i = 0; i < myCardButton.length; i++) {
          myCardButton[i].setLocation(myCardButton[i].getX(), 400);
          myCardButton[i].setClickedCount(0);
        }
        ((MyCard) event.getSource()).setLocation(((MyCard) event.getSource()).getX(), 200);
      }
    }

  }

  public void loadFile(String imageName){
    Filename=imageName;//設定檔名
    try{
      image=ImageIO.read(new File(Filename));//讀取檔案
    }
    catch(Exception e){
      javax.swing.JOptionPane.showMessageDialog(null, "載入圖檔錯誤: "+Filename);
      image=null;//如果錯誤的話顯示錯誤訊息
    }
  }
  
  public void createCardBack_Top(int x, int y){
    this.loadFile("cardback.png");
    for(int i=0; i<13; i++){
    JLabel cardBack = new JLabel(new ImageIcon(image));//把Image放進label裡
    this.add(cardBack);
    cardBack.setBounds(x+(i*20), y, 50, 70);
    }
  }

  public void createCardBack_LeftAndRight(int x, int y){
    this.loadFile("cardback_down.png");
    for(int i=0; i<13; i++){
    JLabel cardBack = new JLabel(new ImageIcon(image));//把Image放進label裡
    this.add(cardBack);
    cardBack.setBounds(x, y+(i*20), 70, 50);
  }
  }
    
  public void createMyCard(int x, int y){
    String[] myCardPic = new String[]{"sa.png", "s2.png", "s3.png", "s4.png", "s5.png", "s6.png", "s7.png",
      "s8.png", "s9.png", "s10.png", "sj.png", "sq.png", "sk.png"};
      for(int i=0; i<13; i++){
      loadFile(myCardPic[i]);
      myCardButton[i] = new MyCard(new ImageIcon(image));
      this.add(myCardButton[i]);
      myCardButton[i].setBounds(x+(i*50), y, 50, 70);
    }
  }

}