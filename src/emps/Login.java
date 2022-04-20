package emps;

import javax.swing.JLabel;


import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;


public class Login extends JFrame{
	JLabel lbltitulo,lblid,lblpass;
	JTextField txtid;
	JButton btningresar,btnsalir;
	JPasswordField txtpass;
	conexion_empleados cn=new conexion_empleados();
	
	//declaracion del arreglo
	String user_system[][]=new String[3][3];
	private JLabel lblNewLabel;
		
	public Login()
	{
		//cargar los valores de la matriz
/*user_system[0][0]="dago";
		user_system[0][1]="fiscal";
		user_system[0][2]="admin";
		user_system[1][0]="otro";
		user_system[1][1]="otros";
		user_system[1][2]="estandar";
		user_system[2][0]="user";
		user_system[2][1]="pass";
		user_system[2][2]="usuario";		*/
		
		getContentPane().setBackground(new Color(176, 224, 230));
		setTitle("Autentificacion del Usuario ...");
		//setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/imagenes/system_login.jpg")));
		// formulario de login
		this.setBounds(250, 250, 400, 243);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		//componentes del formulario
		
		lbltitulo=new JLabel();
		lbltitulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lbltitulo.setText(".:: AUTENTIFICACIÓN DE USUARIOS ::.");
		lbltitulo.setBounds(46, 10, 293, 30);
		this.getContentPane().add(lbltitulo);
		
		lblid=new JLabel();
		lblid.setText("Usuario: ");
		lblid.setBounds(46, 51, 100, 30);
		this.getContentPane().add(lblid);
		
		lblpass=new JLabel();
		lblpass.setText("Contraseña: ");
		lblpass.setBounds(30, 100, 100, 30);
		this.getContentPane().add(lblpass);
		
		txtid=new JTextField();
		txtid.setBounds(110, 51, 100, 30);
		this.getContentPane().add(txtid);
		
		txtpass=new JPasswordField();
		txtpass.setEchoChar('*');
		txtpass.setBounds(110, 100, 100, 30);
		this.getContentPane().add(txtpass);
		
		btningresar=new JButton();
		btningresar.addActionListener(new ActionListener() 
		  {
			String id="",pass="";
			boolean band_user;
			boolean band_pass;
			
			public void actionPerformed(ActionEvent arg0) 
			{
				id=txtid.getText();
				pass=txtpass.getText();
				band_user=false;
				band_pass=false;
				
				cn.login(id, pass);
				if(cn.login(id, pass)==1){
					Menus mn= new Menus();
					mn.setVisible(true);
					dispose();
				}
				
			}
		  });
		btningresar.setText("Entrar");
		//btningresar.setIcon(new ImageIcon(Login.class.getResource("/imagenes/ingresar.jpg")));
		btningresar.setBounds(30, 150, 110, 30);
		this.getContentPane().add(btningresar);
		
		btnsalir=new JButton();
		//btnsalir.setIcon(new ImageIcon(Login.class.getResource("/imagenes/exit.jpg")));
		btnsalir.setText("Salir");
		btnsalir.setBounds(150, 150, 110, 30);
		btnsalir.addActionListener(new ActionListener()
				{
			      public void actionPerformed(ActionEvent arg0)
			      {
			    	  System.exit(EXIT_ON_CLOSE);
			      }
				});
		this.getContentPane().add(btnsalir);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\yani lizeth\\Downloads\\1466153038_Login Manager.png"));
		lblNewLabel.setBounds(270, 57, 73, 94);
		getContentPane().add(lblNewLabel);
		
		
	}	
	

	public static void main(String[] args) 
	{
		Login frame=new Login();
		frame.setVisible(true);

	}
	
	
}



