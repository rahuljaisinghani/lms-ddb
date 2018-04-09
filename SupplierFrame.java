import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import mu.*;

public class SupplierFrame extends JFrame
{
JPanel jp1,jp2;
JButton add,back;
JButton modify,delete,view;

JLabel l1,l2,l3;
JTextField t1,t2,t3;

public SupplierFrame()
{
super("Library");
setSize(500,160);
setResizable(false);
setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

jp1=new JPanel();
jp1.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));
add=new JButton("Add");
delete=new JButton("DELETE");
view=new JButton("VIEW");

back=new JButton("Back");

jp1.add(add);
jp1.add(delete);
jp1.add(view);

add(jp1);

jp2=new JPanel();

jp2.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));

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
	AddSupplierFrame a=new AddSupplierFrame();
	dispose();}
});

view.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			ViewFrame1 a=new ViewFrame1("supplier");
			dispose();
		}});
delete.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			DeleteFrame a=new DeleteFrame("supplier");
			dispose();
		}});
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
SupplierFrame q=new SupplierFrame();
}

}














