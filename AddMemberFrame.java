import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import mu.*;

public class AddMemberFrame extends JFrame
{
JPanel jp1,jp2;
JButton add,back;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;

public AddMemberFrame()
{
super("Add Employee");
setSize(700,250);
setResizable(false);
setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

jp1=new JPanel();
jp1.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));

add=new JButton("Add");
back=new JButton("Back");
l1=new JLabel("Id:");
l2=new JLabel("Name:");
l3=new JLabel("Phone");
l4=new JLabel("Membership Date");

l5=new JLabel("Book Issued");
l6=new JLabel("Book Issue Date");
l7=new JLabel("Book Return Date");
l8=new JLabel("Fine");
l9=new JLabel("Library");


l10=new JLabel("Book");
t1=new JTextField(5);
t2=new JTextField(10);
t3=new JTextField(10);
t4=new JTextField(5);
t5=new JTextField(10);
t6=new JTextField(10);
t7=new JTextField(10);
t8=new JTextField(10);
t9=new JTextField(10);
t10=new JTextField(10);
t11=new JTextField(10);
l11=new JLabel("location");
jp1.add(l1);
jp1.add(t1);
jp1.add(l2);
jp1.add(t2);
jp1.add(l3);
jp1.add(t3);
jp1.add(l4);
jp1.add(t4);
jp1.add(l5);
jp1.add(t5);
jp1.add(l6);
jp1.add(t6);
jp1.add(l7);
jp1.add(t7);
jp1.add(l8);
jp1.add(t8);
jp1.add(l9);
jp1.add(t9);
jp1.add(l10);
jp1.add(t10);
jp1.add(l11);
jp1.add(t11);
add(jp1);

jp2=new JPanel();

jp2.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));
jp2.add(add);
jp2.add(back);
add(jp2,BorderLayout.SOUTH);
setLocationRelativeTo(null);
setVisible(true);

addWindowListener(new WindowAdapter(){
public void WindowClosing(WindowEvent we){
	HomeFrame h=new HomeFrame();
	dispose();
}
});

//event handling
back.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
	HomeFrame a=new HomeFrame();
	dispose();
}
});

add.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
	String id=t1.getText();
	String name=t2.getText();
	String phone=t3.getText();
	String m_date=t4.getText();
	String issued=t5.getText();
	String i_date=t6.getText();
	String r_date=t7.getText();
	String fine=t8.getText();
	String library=t9.getText();
	String book=t10.getText();
	String location=t11.getText();
	//DatabaseHandler.insertmember(Integer.parseInt(id),name,Integer.parseInt(phone),m_date,Integer.parseInt(issued),i_date,r_date,Integer.parseInt(fine),Integer.parseInt(library),Integer.parseInt(book));
	
	 DatabaseHandler q=new DatabaseHandler();
	 DatabaseHandler.insertmember(Integer.parseInt(id),name,Integer.parseInt(phone),location,m_date,Integer.parseInt(issued),i_date,r_date,Integer.parseInt(fine),Integer.parseInt(library),Integer.parseInt(book));
	 t1.setText("");
	 t2.setText("");
	
	}
});
}
	
public boolean isletters(String name) {
    char[] chars = name.toCharArray();

    for (char c : chars) {
        if(!Character.isLetter(c) && c!=' ') {
            return false;
        }
    }

    return true;
}

public static void main(String args[])
{
AddBookFrame q=new AddBookFrame();
}

}














