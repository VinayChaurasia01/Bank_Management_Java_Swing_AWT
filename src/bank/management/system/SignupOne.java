
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.*;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SignupOne extends JFrame implements ActionListener{
    
    long random;
    
    
    
    JLabel FormNo , personalDetail , name , fathername , DOB , gender , email ,phoneno , address , city , marSta , state ,pincode;
    JTextField nametext , fathernametext ,  emailtext , phonenotext ,addresstext , citytext , statetext , pincodetext ;
    JRadioButton male , female , single , married;
     JButton next;
     JDateChooser dateChooser;

    SignupOne()
{
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        FormNo = new JLabel("APPLICATION FORM NO. " + random );
        FormNo.setFont(new Font("Relewaty" , Font.BOLD , 30));
        FormNo.setBounds(140,20,600,40);
        add(FormNo);
        
        personalDetail = new JLabel("Personal Details :" );
        personalDetail.setFont(new Font("Relewaty" , Font.BOLD , 22));
        personalDetail.setBounds(290,80,400,30);
        add(personalDetail);
        
        
        name = new JLabel("Full Name :" );
        name.setFont(new Font("Relewaty" , Font.BOLD , 16));
        name.setBounds(100,140,100,30);
        add(name);
        
        nametext = new JTextField();
        nametext.setFont(new Font("Releway" , Font.BOLD , 20));
        nametext.setBounds(300 , 140 , 400 , 30);
        add(nametext);
        
        fathername = new JLabel("Father's Name :" );
        fathername.setFont(new Font("Relewaty" , Font.BOLD , 16));
        fathername.setBounds(100,190,200,30);
        add(fathername);
        
        fathernametext = new JTextField();
        fathernametext.setFont(new Font("Releway" , Font.BOLD , 20));
        fathernametext.setBounds(300 , 190 , 400 , 30);
        add(fathernametext);
        
        DOB = new JLabel("DOB :" );
        DOB.setFont(new Font("Relewaty" , Font.BOLD , 16));
        DOB.setBounds(100,240,100,30);
        add(DOB);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);
        
        gender = new JLabel("Gender :" );
        gender.setFont(new Font("Relewaty" , Font.BOLD , 16));
        gender.setBounds(100,290,100,30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300,290,100,30);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450,290,100,30);
        add(female);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        
        email = new JLabel("Email Address :" );
        email.setFont(new Font("Relewaty" , Font.BOLD , 16));
        email.setBounds(100,340,200,30);
        add(email);
        
        emailtext = new JTextField();
        emailtext.setFont(new Font("Releway" , Font.BOLD , 20));
        emailtext.setBounds(300 , 340 , 400 , 30);
        add(emailtext);
        
        phoneno = new JLabel("Contact No. :" );
        phoneno.setFont(new Font("Relewaty" , Font.BOLD , 16));
        phoneno.setBounds(100,390,100,30);
        add(phoneno);
        
        phonenotext = new JTextField();
        phonenotext.setFont(new Font("Releway" , Font.BOLD , 20));
        phonenotext.setBounds(300 , 390 , 400 , 30);
        add(phonenotext);
        
        marSta = new JLabel("Marriage Status :" );
         marSta.setFont(new Font("Relewaty" , Font.BOLD , 16));
         marSta.setBounds(100,440,200,30);
        add( marSta);
        
        single = new JRadioButton("Single");
        single.setBounds(300,440,120,30);
        add(single);
        
        married = new JRadioButton("Married");
        married.setBounds(450,440,120,30);
        add(married);
        
        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(single);
        bg2.add(married);
        
        address = new JLabel("Address :" );
        address.setFont(new Font("Relewaty" , Font.BOLD , 16));
        address.setBounds(100,490,100,30);
        add(address);
        
        addresstext = new JTextField();
        addresstext.setFont(new Font("Releway" , Font.BOLD , 20));
        addresstext.setBounds(300 , 490 , 400 , 30);
        add(addresstext);

        city = new JLabel("City :" );
        city.setFont(new Font("Relewaty" , Font.BOLD , 16));
        city.setBounds(100,540,100,30);
        add(city);
        
        citytext = new JTextField();
        citytext.setFont(new Font("Releway" , Font.BOLD , 20));
        citytext.setBounds(300 , 540 , 400 , 30);
        add(citytext);

        
        state = new JLabel("State :" );
        state.setFont(new Font("Relewaty" , Font.BOLD , 16));
        state.setBounds(100,590,100,30);
        add(state);
        
        statetext = new JTextField();
        statetext.setFont(new Font("Releway" , Font.BOLD , 20));
        statetext.setBounds(300 , 590 , 400 , 30);
        add(statetext);
        
        pincode = new JLabel("Pin Code :" );
        pincode.setFont(new Font("Relewaty" , Font.BOLD , 16));
        pincode.setBounds(100,640,100,30);
        add(pincode);
        
        pincodetext = new JTextField();
        pincodetext.setFont(new Font("Releway" , Font.BOLD , 20));
        pincodetext.setBounds(300 , 640 , 400 , 30);
        add(pincodetext);
        
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Releway" , Font.BOLD , 14));
        next.setBounds(650,700,80,30);
        next.addActionListener(this);
        add(next);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = "" + random;
        String name = nametext.getText();
        String fname = fathernametext.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gen = null;
        if(male.isSelected()){
            gen = "Male";
        }else if(female.isSelected()){
            gen = "Female";
        }
        
        String mail = emailtext.getText();
        String contact = phonenotext.getText();
        
        String status = null;
        if(single.isSelected()){
            status = "Single";
        }else if(married.isSelected()){
            status = "Married";
        }
        
        String addres = address.getText();
        String cit = city.getText();
        String sta = statetext.getText();
        String pinco = pincode.getText();
        
        try{
            
           
            if(name.equals("")){
                JOptionPane.showMessageDialog(null , "Name is Required "); 
            }else {
                Conn co = new Conn();
                String query = "insert into signup values('" + formno + "' , '" + name +"' , '" + fname + "' , '" + dob + "' , '" + gen + "' , '" + mail + "' , '" + contact + "' , '" + status + "' , '" + addres + "' , '"+ cit + "' , '" + sta + "' , '" + pinco + "' )" ;
                co.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }
 
        catch(Exception ee){
            System.out.println(ee);
        }
    
    }

    
    
    public static void main(String[] args){
          new SignupOne();
    }

}
