
package bank.management.system;

import java.awt.Image;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;



public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField enterpin, reenterpin;
    JButton change,back;
    String pinnumber;
    
    PinChange(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Atm2.jpg"));
        Image i1 = img.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel image = new JLabel(i2);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Change Your Pin");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Releway" , Font.BOLD , 20));
        text.setBounds(360,330,700,35);
        image.add(text);
        
        JLabel pintext = new JLabel("New Pin :");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("Releway" , Font.BOLD , 18));
        pintext.setBounds(280,365,200,25);
        image.add(pintext);
        
        enterpin = new JPasswordField();
        enterpin.setFont(new Font("Releway" , Font.BOLD,25));
        enterpin.setBounds(400 , 365 , 150 , 25);
        image.add(enterpin);
        
        JLabel pintext2 = new JLabel("Confirm Pin:");
        pintext2.setForeground(Color.WHITE);
        pintext2.setFont(new Font("Releway" , Font.BOLD , 18));
        pintext2.setBounds(280,400,200,25);
        image.add(pintext2);
        
        reenterpin = new JPasswordField();
        reenterpin.setFont(new Font("Releway" , Font.BOLD,25));
        reenterpin.setBounds(400 , 400 , 150 , 25);
        image.add(reenterpin);
        
        change = new JButton("Change");
        change.setBounds(520 , 460 , 100 , 20);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("Back");
        back.setBounds(520,490,100,20);
        back.addActionListener(this);
        image.add(back);
        
        
        setLocation(300,0);
        setSize(900,900);
        setUndecorated(true);
        setVisible(true);
        
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
      
        if(e.getSource() == change)
        {
        try{
            String epin = enterpin.getText();
            String rpin = reenterpin.getText();
            
            if(!epin.equals(rpin)){
                JOptionPane.showMessageDialog(null , "Incorrect Pin");
                return;
            }
            
            if(!epin.equals("")){
                JOptionPane.showMessageDialog(null , "Please Enter Pin");
                return;
            }
            
            if(!rpin.equals("")){
                JOptionPane.showMessageDialog(null , "Please Enter Pin");
                return;
            }
            
            Conn co = new Conn();
            String query1 = "update bank set pin = '" + rpin + "' where pin= '" + pinnumber +"'" ; 
            String query2 = "update login set Pin_No = '" + rpin + "' where pin= '" + pinnumber +"'" ; 
            String query3 = "update signupthree set Pin_No = '" + rpin + "' where pin= '" + pinnumber +"'" ; 
            
            co.s.executeUpdate(query1);
            co.s.executeUpdate(query2);
            co.s.executeUpdate(query3);
            
            JOptionPane.showMessageDialog(null,"Pin changed Successfully");
            
            setVisible(false);
            new Transaction(epin).setVisible(true);
            
        }catch(Exception ex){
            System.out.println(ex);
        }
        
    }else{
            setVisible(false);
            new  Transaction(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String [] args){
        
        new PinChange("");
       
        
    }

   
}
