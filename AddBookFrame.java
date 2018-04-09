import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import mu.*;

public class AddBookFrame extends JFrame
{
JPanel jp1,jp2;
JButton add,back;
JLabel l1,l2,l3,l4,l5,l6,l7;
JTextField t1,t2,t3,t4,t5,t6,t7;

public AddBookFrame()
{
super("Add Employee");
setSize(500,250);
setResizable(false);
setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

jp1=new JPanel();
jp1.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));

add=new JButton("Add");
back=new JButton("Back");
l1=new JLabel("Id:");
l2=new JLabel("Title:");
l3=new JLabel("Isbn");
l4=new JLabel("Quantity");

l5=new JLabel("Library");
l6=new JLabel("Supplier");
l7=new JLabel("Author");
t1=new JTextField(5);
t2=new JTextField(10);
t3=new JTextField(10);
t4=new JTextField(5);
t5=new JTextField(10);
t6=new JTextField(10);
t7=new JTextField(10);
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
	String title=t2.getText();
	String author=t7.getText();
	String isbn=t3.getText();
	String quantity=t5.getText();
	String libid=t5.getText();
	String supid=t6.getText();
	if(id.length()==0 | title.length()==0)
	{
	  Sound.failure();
	 JOptionPane.showMessageDialog(new JDialog(),"All fields are mandatory");
	 return;
	}
	
if(id.matches("\\d*")){}
	else{Sound.failure();
JOptionPane.showMessageDialog(new JDialog(),"ID should only contain NUMBERS");
	t1.setText("");
	 t2.setText("");}
	boolean i= isletters(title);
if(i==false)
	{Sound.failure();
	JOptionPane.showMessageDialog(new JDialog(),"Name Should not contain numbers");
	 t1.setText("");
	 t2.setText("");
	return;
	}
	 DatabaseHandler q=new DatabaseHandler();
	 DatabaseHandler.insertbook(Integer.parseInt(id),title,author,Integer.parseInt(isbn),Integer.parseInt(quantity),Integer.parseInt(libid),Integer.parseInt(supid));
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














