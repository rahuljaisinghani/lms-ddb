import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Date;
import mu.Sound;
import mu.*;
public class HomeFrame extends JFrame
{
	JPanel jp;
	JButton library,book,member,supplier,user1,user2;
	
	public HomeFrame()
	{
		super("Library Management System");
		

		setSize(600,150);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		jp=new JPanel();
		jp.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));
		
		
		library=new JButton("LIBRARY");
		book=new JButton("BOOK");
		member=new JButton("MEMBER");
		supplier=new JButton("Supplier");
		user1=new JButton("User1");
		user2=new JButton("User2");
		
		jp.add(library);
		jp.add(book);
		jp.add(member);
		jp.add(supplier);
		jp.add(user1);
		jp.add(user2);
		add(jp);
		
		setLocationRelativeTo(null);
		setVisible(true);
		
		StatusBar statusBar = new StatusBar();
		getContentPane().add(statusBar, java.awt.BorderLayout.SOUTH);
		setVisible(true);	
		
	

		library.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			LibraryFrame a=new LibraryFrame();
			dispose();
		}});
		book.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			BookFrame a=new BookFrame();
			dispose();
		}});
		user1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			User1Frame a=new User1Frame();
			dispose();
		}});
		user2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			User2Frame a=new User2Frame();
			dispose();
		}});
		supplier.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			SupplierFrame a=new SupplierFrame();
			dispose();
		}});
		member.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			MemberFrame a=new MemberFrame();
			dispose();
		}});
		addWindowListener(new WindowAdapter(){
		public void windowOpened(WindowEvent e)
		{
			
		}
		public void windowClosing(WindowEvent e)
		{
			int output=JOptionPane.showConfirmDialog(new JDialog(),"Do u Wnt to exit");
			if(output==JOptionPane.YES_OPTION)
			{
				System.exit(0);
			}
		}
	});
		
	}
	

	public static void main(String args[])
	{
		JOptionPane.showMessageDialog(new JDialog(),"Welcome to R3 Employee Management System");

		HomeFrame h=new HomeFrame();
	}
}
class StatusBar extends JLabel {
     
    public StatusBar() {
        super();
        super.setPreferredSize(new Dimension(100, 16));
		 Date date = new Date();
        setMessage(date.toString());
    }
     
    public void setMessage(String message) {
        setText(" "+message);        
    }        
}

class DatabaseHandler
{

static Connection con;

public static void getConnection()
{
	try
	{
	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","rahul23","rahul146");
	
	}
	catch(SQLException e)
	{
		System.out.println(e);
	}
}
public static void insert(int id,String name,String location)
{
	try{  
getConnection();
PreparedStatement pst=con.prepareStatement("insert into library values(?,?,?)");  
pst.setInt(1,id);//1 specifies the first parameter in the query  
pst.setString(2,name);  
pst.setString(3,location);
try{
int i=pst.executeUpdate(); }
catch(Exception e){ 
System.out.println("tata");

Sound.failure();}
 Sound.success(); 
JOptionPane.showMessageDialog(new JDialog(),"1 RECORD ADDED"); 
  
}catch(Exception e){ 
 Sound.failure();
JOptionPane.showMessageDialog(new JDialog(),"RECORD ALREADY EXISTS"+e);
}//end of catch  
}//end of insert


public static void insertsupplier(int id,String name,int library)
{
	try{  
getConnection();
PreparedStatement pst=con.prepareStatement("insert into supplier values(?,?,?)");  
pst.setInt(1,id);//1 specifies the first parameter in the query  
pst.setString(2,name);  
pst.setInt(3,library);
try{
int i=pst.executeUpdate(); }
catch(Exception e){ 


Sound.failure();}
 Sound.success(); 
JOptionPane.showMessageDialog(new JDialog(),"1 RECORD ADDED"); 
  
}catch(Exception e){ 
 Sound.failure();
JOptionPane.showMessageDialog(new JDialog(),"RECORD ALREADY EXISTS"+e);
}//end of catch  
}//end of insert


public static void insertbook(int id,String name,String location,int isbn,int quantity,int libid,int supid)
{
	try{  
getConnection();
System.out.println("HEllo");
PreparedStatement pst=con.prepareStatement("insert into books values(?,?,?,?,?,?,?)");  
pst.setInt(1,id);//1 specifies the first parameter in the query  
pst.setString(2,name);  
pst.setString(3,location);
pst.setInt(4,isbn);//1 specifies the first parameter in the query  
pst.setInt(5,quantity);  
pst.setInt(6,libid);
pst.setInt(7,supid);
System.out.println("HEllo2");
try{
	System.out.println("nahi phata");
int i=pst.executeUpdate(); }
catch(Exception e){
	System.out.println("pahat");

	JOptionPane.showMessageDialog(new JDialog(),"Phata"+e);
}
System.out.println("HEllo1");
 Sound.success(); 
JOptionPane.showMessageDialog(new JDialog(),"1 RECORD ADDED"); 
  
}catch(Exception e){ 
 Sound.failure();
JOptionPane.showMessageDialog(new JDialog(),"RECORD ALREADY ssfs EXISTS"+e);
}//end of catch  
}//end of insert
public static void insertmember(int id,String name,int phone,String location,String m_date,int issued,String i_date,String r_date,int fine,int libid,int supid)
{
	try{  
	
getConnection();
System.out.println("HEllo");
PreparedStatement pst=con.prepareStatement("insert into member values(?,?,?,?,TO_DATE(?, 'yyyy/mm/dd'),?,TO_DATE(?, 'yyyy/mm/dd'),TO_DATE(?, 'yyyy/mm/dd'),?,?,?)");  
pst.setInt(1,id);//1 specifies the first parameter in the query  
pst.setString(2,name);  
pst.setInt(3,phone);
pst.setString(4,location);
pst.setString(5,m_date);//1 specifies the first parameter in the query  
pst.setInt(6,issued);  
pst.setString(7,i_date);
pst.setString(8,r_date);
pst.setInt(9,fine);  
pst.setInt(10,libid);
pst.setInt(11,supid);
System.out.println("HEllo2");
try{
	System.out.println("nahi phata");
int i=pst.executeUpdate(); }
catch(Exception e){
	System.out.println("pahat");

	JOptionPane.showMessageDialog(new JDialog(),"Phata"+e);
}
System.out.println("HEllo1");
 Sound.success(); 
JOptionPane.showMessageDialog(new JDialog(),"1 RECORD ADDED"); 
  
}catch(Exception e){ 
 Sound.failure();
JOptionPane.showMessageDialog(new JDialog(),"RECORD ALREADY ssfs EXISTS"+e);
}//end of catch  
}//end of insert


public String query(String table_name){
StringBuffer sb= new StringBuffer();
try
{
getConnection();
String q="";
if(table_name=="library"){
 q="Select * from library order by library_id ";
}
else if(table_name=="books"){
q="Select * from books order by book_id";}
else if(table_name=="supplier"){
	 q="Select * from supplier order by supplier_id";
}
else if(table_name=="user1_lib"){
	 q="Select * from supplier order by supplier_id";
}
else if(table_name=="user1_book"){
	 q="Select * from supplier order by supplier_id";
}
else if(table_name=="user2_lib"){
	 q="Select * from supplier order by supplier_id";
}
else if(table_name=="user2_book"){
	 q="Select * from supplier order by supplier_id";
}
else if(table_name=="member"){
	 q="Select * from member order by member_id";
}
// String q="Select * from library order by library_id";
Statement st=con.createStatement();
ResultSet rs=st.executeQuery(q);
sb.append("=================================\n");
sb.append( "||Sr no.||             || ID ||"+"\t"+"|| NAME   "+"||"+"\n");
sb.append("=================================\n");
int p=1;
while(rs.next())
{
	sb.append(p+")\t"+rs.getString(1)+"\t"+""+rs.getString(2)+"\n");
p++;}//end of while
rs.close();
}
catch(Exception e)
{ JOptionPane.showMessageDialog(new JDialog()," "+e);
}
return sb.toString();
}


public static void update(int id,String name)
{	try{
	getConnection();

	String q="Select * from Employee order by id";
Statement st=con.createStatement();
ResultSet rs=st.executeQuery(q);
while(rs.next()){
if(id==Integer.parseInt(rs.getString(1))){
update1(id,name);
return;
}

}
int p=1;

while(!rs.next()){
if(p==1){
 Sound.failure();
JOptionPane.showMessageDialog(new JDialog(),"RECORD DOES NOT EXIST");
p=0;
return;

/*
	PreparedStatement pst=con.prepareStatement("update Employee set name=? where id=?");
	pst.setInt(2,id);
pst.setString(1,name);


pst.executeUpdate();
 Sound.success(); 
JOptionPane.showMessageDialog(new JDialog(),"1 RECORD Modified"); 
*/
}}}
catch(Exception e){ 
 Sound.failure();
JOptionPane.showMessageDialog(new JDialog(),"RECORD ALREADY EXISTS"+ e);
}//end of catch  
}

public static void delete(int id, String table_name)
{
try
{
getConnection();

String q="Select * from books";//+ table_name;
System.out.println(table_name);
Statement st=con.createStatement();
ResultSet rs=st.executeQuery(q);
while(rs.next()){
if(id==Integer.parseInt(rs.getString(1))){
	System.out.println(Integer.parseInt(rs.getString(1)));

del1(id,table_name);
return;
}

}
int p=1;

while(!rs.next()){
if(p==1){
 Sound.failure();
JOptionPane.showMessageDialog(new JDialog(),"RECORD DOES NOT EXIST");
p=0;
return;

}
}
/*String s="delete from Employee where id=? ";
PreparedStatement pst=con.prepareStatement(s);
pst.setInt(1,id);
pst.executeUpdate();
 Sound.success();
JOptionPane.showMessageDialog(new JDialog(),"One record deleted");

*/
}

catch(Exception e)
{
 Sound.failure();
JOptionPane.showMessageDialog(new JDialog(),"Record does not exists"+ e);
}

}
public static void update1(int id,String name)
{
try
{getConnection();
	PreparedStatement pst=con.prepareStatement("update Employee set name=? where id=?");
	pst.setInt(2,id);
pst.setString(1,name);
pst.executeUpdate();
 Sound.success(); 
JOptionPane.showMessageDialog(new JDialog(),"1 RECORD Modified"); 
}
catch(Exception e){ 
 Sound.failure();
JOptionPane.showMessageDialog(new JDialog(),"RECORD ALREADY EXISTS"+ e);
}//end of catch 
}


public static void del1(int id,String table_name){
try{
getConnection();
String s="";
System.out.println(table_name);

if(table_name=="library"){
 s="delete from library where library_id=? ";
}
else if(table_name=="books"){
	 s="delete from books where book_id=? ";

}
else if(table_name=="supplier"){

	 s="delete from supplier where supplier_id=? ";

}
else if(table_name=="member"){

	 s="delete from member where member_id=? ";

}
System.out.println(s);

PreparedStatement pst=con.prepareStatement(s);
try{
pst.setInt(1,id);}
catch(Exception e){ 
 Sound.failure();
 //PreparedStatement pst=con.prepareStatement(s);
 pst.setInt(1,id);
//JOptionPane.showMessageDialog(new JDialog(),"RECORD ALREADY EXISTS"+ e);
}
System.out.println(s);

pst.executeUpdate();
System.out.println(s);

 Sound.success();
JOptionPane.showMessageDialog(new JDialog(),"One record deleted");
}
catch(Exception e)
{
Sound.failure();
JOptionPane.showMessageDialog(new JDialog(),"Record does not exists"+ e);
}
}
}