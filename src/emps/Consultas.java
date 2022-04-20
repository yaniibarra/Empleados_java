package emps;
import javax.swing.JFrame;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Consultas extends JFrame{
	 private JLabel lbltitulo,lblsubtitulo;
	    private JButton btnreportes;
	    private JLabel lblNoEmpleado;
	    private JLabel lblNombre;
	    private JLabel lblPuesto;
	    private JTextField txtnoempleado;
	    private JTextField txtnombre;
	    private JTextField txtpuesto;
	    conexion_empleados cn = new conexion_empleados();
	    
		
	  //declaracion del arreglo
	  	String empleados[][]=new String[3][3];
	  	private JButton btnbuscar;
	  	private JTextField txtbuscar;
	  	
	    public Consultas()
		{
	    	//cargar los valores de la matriz
	    	empleados[0][0]="1";
	    	empleados[0][1]="David";
	    	empleados[0][2]="Admin";
	    	empleados[1][0]="2";
	    	empleados[1][1]="Carlos";
	    	empleados[1][2]="Contador";
	    	empleados[2][0]="3";
	    	empleados[2][1]="Ruben";
	    	empleados[2][2]="Ing";
	    	
	    			
			//setIconImage(Toolkit.getDefaultToolkit().getImage(Menus.class.getResource("/imagenes/user.jpg")));
			getContentPane().setBackground(SystemColor.activeCaption);
			//propiedades del formulario
			this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			this.setSize(469,300);
			this.setResizable(false);
			this.setLocationRelativeTo(null);
			this.setTitle("Sistema de Empleados (Consultas)");
			getContentPane().setLayout(null);
			
			//componenetes del formulario
			lbltitulo=new JLabel();
			lbltitulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
			lbltitulo.setText(".:: Sistema de Empleados ::.");
			lbltitulo.setBounds(116, 11, 266, 30);
			this.getContentPane().add(lbltitulo);
			
			lblsubtitulo=new JLabel();
			lblsubtitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblsubtitulo.setText("Consultas de empleados");
			lblsubtitulo.setBounds(156, 37, 199, 30);
			this.getContentPane().add(lblsubtitulo);
			
			btnreportes=new JButton();
			btnreportes.setIcon(new ImageIcon("C:\\Users\\yani lizeth\\Downloads\\exit.png"));
			btnreportes.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					Menus menu=new Menus();
					menu.setVisible(true);
					dispose();
				}
			});
			btnreportes.setToolTipText("Regresar al Men\u00FA Principal");
			//btnreportes.setIcon(new ImageIcon(Menus.class.getResource("/imagenes/login.jpg")));
			btnreportes.setBounds(414, 229, 39, 30);
			this.getContentPane().add(btnreportes);
			
			/*JLabel lblimagen = new JLabel("");
			lblimagen.setIcon(new ImageIcon(Menus.class.getResource("/imagenes/user.jpg")));
			lblimagen.setBounds(325, 68, 138, 128);
			getContentPane().add(lblimagen);*/
			
			lblNoEmpleado = new JLabel("No. Empleado:");
			lblNoEmpleado.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNoEmpleado.setBounds(50, 150, 97, 14);
			getContentPane().add(lblNoEmpleado);
			
			lblNombre = new JLabel("Nombre:");
			lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNombre.setBounds(50, 188, 66, 14);
			getContentPane().add(lblNombre);
			
			lblPuesto = new JLabel("Puesto:");
			lblPuesto.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblPuesto.setBounds(50, 230, 66, 14);
			getContentPane().add(lblPuesto);
			
			txtnoempleado = new JTextField();
			txtnoempleado.setEditable(false);
			txtnoempleado.setBounds(156, 148, 86, 20);
			getContentPane().add(txtnoempleado);
			txtnoempleado.setColumns(10);
			
			txtnombre = new JTextField();
			txtnombre.setEditable(false);
			txtnombre.setBounds(156, 186, 86, 20);
			getContentPane().add(txtnombre);
			txtnombre.setColumns(10);
			
			txtpuesto = new JTextField();
			txtpuesto.setEditable(false);
			txtpuesto.setBounds(156, 228, 86, 20);
			getContentPane().add(txtpuesto);
			txtpuesto.setColumns(10);
			
			btnbuscar = new JButton();
			btnbuscar.setIcon(new ImageIcon("C:\\Users\\yani lizeth\\Downloads\\lupa.png"));
			btnbuscar.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					if(txtbuscar.getText().equals(null) || txtbuscar.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Ingresa un numero de usuario");
					}
					
					else{
							
				try {
					String sql = "SELECT * FROM empleado WHERE id_empleado='"+txtbuscar.getText()+"'";
					PreparedStatement pstm = cn.conetar().prepareStatement(sql);
					ResultSet rs = pstm.executeQuery();
					
					if(rs.next()){
						txtnoempleado.setText(rs.getString("id_empleado"));
						txtnombre.setText(rs.getString("nombre_empleado"));
						txtpuesto.setText(rs.getString("puesto"));
					}else{
						JOptionPane.showMessageDialog(null, "No se encontro el empleado");
					}
					
					
				} catch (Exception e) {
					
				}
					}	
				}
			});
			//btnbuscar.setIcon(new ImageIcon(Consultas.class.getResource("/imagenes/ingresar.jpg")));
			btnbuscar.setToolTipText("Consultar un Empleado");
			btnbuscar.setBounds(283, 93, 46, 30);
			getContentPane().add(btnbuscar);
			
			JLabel label = new JLabel("");
			label.setBounds(70, 84, 46, 14);
			getContentPane().add(label);
			
			txtbuscar = new JTextField();
			txtbuscar.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent k) {
					char c = k.getKeyChar();
					if(Character.isLetter(c)){
						JOptionPane.showMessageDialog(null, "solo se admiten numeros");
						txtbuscar.setText(null);
						k.consume();
					}
				}
			});
			txtbuscar.addMouseListener(new MouseAdapter() 
			{
				@Override
				public void mouseClicked(MouseEvent arg0) 
				{
					txtbuscar.setText(null);
				}
			});
			
			txtbuscar.setText("Buscar el # Empleado ...");
			txtbuscar.setBounds(126, 93, 138, 20);
			getContentPane().add(txtbuscar);
			txtbuscar.setColumns(10);
			
		}
		
		public static void main(String[] args) 
		{
			// Menu principal del sistema
			Consultas frame=new Consultas();
			frame.setVisible(true);
			

		}
	}

