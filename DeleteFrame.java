import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import mu.*;
public class DeleteFrame extends JFrame
{
JPanel jp1,jp2;
JButton delete,back;
JLabel l1;
JTextField t1;

public DeleteFrame(String x)
{
super("Delete Employee"+x);
setSize(600,150);
System.out.println(x);
setResizable(false);
setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);



jp1=new JPanel();
jp1.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));

delete=new JButton("Delete");
back=new JButton("Back");

l1=new JLabel("Id:");
t1=new JTextField(6);
jp1.add(l1);
jp1.add(t1);
add(jp1);

jp2=new JPanel();
jp2.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));
jp2.add(delete);
jp2.add(back);
add(jp2,BorderLayout.SOUTH);
setLocationRelativeTo(null);
setVisible(true);

back.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
HomeFrame a= new HomeFrame();
dispose();
}});

delete.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
String id=t1.getText();

if(id.matches("\\d*")){}
	else{Sound.failure();
JOptionPane.showMessageDialog(new JDialog(),"ID should only contain NUMBERS");
	t1.setText("");
	}

if(id.length()==0)
{
Sound.failure();
JOptionPane.showMessageDialog(new JDialog(),"ID is mandatory");
return;
}
else
{
DatabaseHandler r=new DatabaseHandler();
DatabaseHandler.del1(Integer.parseInt(id),x);
t1.setText("");
}

}});
}

public static void main(String args[])
{
// DeleteFrame d=new DeleteFrame();
}

}













