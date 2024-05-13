
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Transaction extends JFrame implements ActionListener{
    
    JButton deposite , withdrawal , fastcash, ministate, pinchange , balan , exit ;
    String pinnumber;
    
    Transaction(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Atm2.jpg"));
        Image i1 = img.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel image = new JLabel(i2);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(335,330,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Releway" , Font.BOLD , 16));
        image.add(text);
        
        
        deposite = new JButton("Deposite");
        deposite.setBounds(280,400,100,20);
        deposite.addActionListener(this);
        image.add(deposite);
        
        withdrawal = new JButton("Withdraw");
        withdrawal.setBounds(520,400,100,20);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(280,430,100,20);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministate = new JButton("Mini Statement");
        ministate.setBounds(520,430,100,20);
        ministate.addActionListener(this);
        image.add(ministate);
        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(280,460,100,20);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balan = new JButton("Balance");
        balan.setBounds(520,460,100,20);
        balan.addActionListener(this);
        image.add(balan);
        
        exit = new JButton("Exit");
        exit.setBounds(520,490,100,20);
        exit.addActionListener(this);
        image.add(exit);
        
        setLocation(300,0);
        setSize(900,900);
        setUndecorated(true);
        setVisible(true);

    
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == exit){
           System.exit(0);
       }else if(e.getSource() == deposite){
         
           setVisible(false);
           new Deposite(pinnumber).setVisible(true);
    }
       else if(e.getSource() == withdrawal){
           setVisible(false);
           new Withdrawl(pinnumber).setVisible(true);
       }else if(e.getSource() == fastcash){
           setVisible(false);
           new FastCash(pinnumber).setVisible(true);
       }else if(e.getSource() == pinchange){
           setVisible(false);
           new PinChange(pinnumber).setVisible(true);
       }else if(e.getSource() == balan){
           setVisible(false);
           new BalanceEnquiry(pinnumber).setVisible(true);
       }if(e.getSource() == ministate){
           new MiniStatement(pinnumber).setVisible(true);
       }
    }
    
    public static void main(String []  args){
        
        new Transaction("");
    }

   
}
