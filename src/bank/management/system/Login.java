
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.JOptionPane;

public class Login extends JFrame implements ActionListener{
    
    JButton login,signup,clear;
    JTextField cardtextFeild;
    JPasswordField  PintextFeild ;
    Login(){
        setTitle("Banking Management System");
        setLayout(null); // FOR CUSTOM LAYOUT AND SETTING YOUR SELF OF LAYOUT
        
        /* ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Atm2.jpg"));
         Image i = img.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i);
         JLabel image = new JLabel(i3);
         image.setBounds(0,0,800,480);
         add(image); */
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Bank.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT); // for resize the icon length and width  
     
        JLabel label1 = new JLabel(i1);
        label1.setBounds(70,10,100,100); // FOR SET LOCATION OF BANKL LOGO
       
        
        add(label1);
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward" , Font.BOLD , 38));
        text.setBounds(200,40,400,40);
        add(text);
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel CardNo = new JLabel("Card No :");
        CardNo.setFont(new Font("Releway" , Font.BOLD , 28));
        CardNo.setBounds(120,140,400,40);
        add(CardNo);
        
        cardtextFeild = new JTextField();
        cardtextFeild.setBounds(300,150,250,30);
        cardtextFeild.setFont(new Font("Arial" , Font.BOLD , 14));
        add(cardtextFeild);
        
        JLabel pin = new JLabel("Card Pin :");
        pin.setFont(new Font("Releway" , Font.BOLD , 28));
        pin.setBounds(120,220,400,40);
        add(pin);
        
        PintextFeild = new JPasswordField();
        PintextFeild.setBounds(300,220,250,30);
        PintextFeild.setFont(new Font("Arial" , Font.BOLD , 14));
        add(PintextFeild);
        
        
        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    
     @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == clear){
            cardtextFeild.setText("");
             PintextFeild.setText("");
        }else if(ae.getSource() == login) {
            Conn co = new Conn();
            String cardnumber = cardtextFeild.getText();
            String pinnumber = PintextFeild.getText();
            String query = "select * from login where CardNumber = '" + cardnumber + "' and Pin_No = '" + pinnumber + "'";
            
            try{
              ResultSet rs =  co.s.executeQuery(query);
              if(rs.next()){
                  setVisible(false);
                  new Transaction(pinnumber).setVisible(true);
              }
              else{
                  JOptionPane.showMessageDialog(null , "Incorrect Card no or pin");
              }
            }catch(Exception ee){
                System.out.println(ee);
            }
            
        }else if (ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }

    
    
    public static void main(String args[]){
        
        new Login();
    }
}
