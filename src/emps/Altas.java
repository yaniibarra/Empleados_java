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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

/*import Empleados_1.Menus;
import Empleados_1.conexion_empleados;*/

public class Altas extends JFrame{
	
	  private JLabel lbltitulo,lblsubtitulo;
	    private JButton btnaltas,btnreportes;
	    private JLabel lblNoEmpleado;
	    private JLabel lblNombre;
	    private JLabel lblPuesto;
	    private JTextField txtnoempleado;
	    private JTextField txtnombre;
	    private JTextField txtpuesto;
	    conexion_empleados cn = new conexion_empleados();
		
	  //declaracion del arreglo
	  	String empleados[][]=new String[10][3];
	  	
	  	// variable que contrala los renglones de la matriz del empleado
	  	private int r=0;
	  	private JLabel lblNewLabel;
	  	 public Altas()
	  	 
	 	{
	     	//cargar los valores de la matriz 
	     	empleados[0][0]="";
	     	empleados[0][1]="";
	     	empleados[0][2]="";
	     	empleados[1][0]="";
	     	empleados[1][1]="";
	     	empleados[1][2]="";
	     	empleados[2][0]="";
	     	empleados[2][1]="";
	     	empleados[2][2]="";
	     	
	     			
	 		getContentPane().setBackground(SystemColor.activeCaption);
	 		//propiedades del formulario
	 		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	 		this.setSize(469,300);
	 		this.setResizable(false);
	 		this.setLocationRelativeTo(null);
	 		this.setTitle("Sistema de Empleados (Altas)");
	 		getContentPane().setLayout(null);
	 		
	 		//componentes del formulario
	 		lbltitulo=new JLabel();
	 		lbltitulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
	 		lbltitulo.setText(".:: Sistema de Empleados ::.");
	 		lbltitulo.setBounds(116, 11, 266, 30);
	 		this.getContentPane().add(lbltitulo);
	 		
	 		lblsubtitulo=new JLabel();
	 		lblsubtitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
	 		lblsubtitulo.setText("Altas de empleados");
	 		lblsubtitulo.setBounds(171, 37, 153, 30);
	 		this.getContentPane().add(lblsubtitulo);
	 		
	 		btnaltas=new JButton();
	 		btnaltas.setIcon(new ImageIcon("C:\\Users\\yani lizeth\\Downloads\\altas.png"));
	 		btnaltas.addActionListener(new ActionListener() 
	 		{
	 			public void actionPerformed(ActionEvent e) 
	 			{
	 				try {
	 					String noempleado,nombre,puesto;
	 					
	 					noempleado=txtnoempleado.getText();
	 					nombre=txtnombre.getText();
	 					puesto=txtpuesto.getText();
	 					
	 					String consulta = "INSERT INTO empleado (id_empleado, nombre_empleado, puesto) VALUES (?,?,?)";
	 					PreparedStatement pstm = cn.conetar().prepareStatement(consulta);
	 					pstm.setString(1,noempleado);
	 					pstm.setString(2,nombre);
	 					pstm.setString(3,puesto);
	 					
	 					int a = pstm.executeUpdate();
	 					if(a == 0){ //execute 
	 						JOptionPane.showMessageDialog(null, "Error no se pudo agregar el empleado");
	 						
	 						empleados[r][0]=noempleado;
	 						empleados[r][0]=nombre;
	 						empleados[r][0]=puesto;
	 						
	 					}else
	 					{
	 						
	 						empleados[r][0]=noempleado;
	 						empleados[r][1]=nombre;
	 						empleados[r][2]=puesto;
	 										
	 						for (int i=0;i<=r;i++)
	 						{	
	 						  JOptionPane.showMessageDialog(null,".:: Registro capturado con exito ::"
	 								+ "\n"+empleados[i][0]+"\t  "+empleados[i][1]+"\t  "+empleados[i][2]);
	 						} 
	 						r=r+1;
	 						
	 						txtnoempleado.setText("");
	 						txtnombre.setText("");
	 						txtpuesto.setText("");
	 						
	 						
	 					}
	 					
	 				}catch (SQLException e2) {
	 					JOptionPane.showMessageDialog(null, "Error: " +e2);
	 				}
	 					
	 			}
	 		});
	 		btnaltas.setToolTipText("Altas de Empleados");
	 		//btnaltas.setIcon(new ImageIcon("));
	 	   // ImageIcon altas = new ImageIcon(getClass().getResource("altas.png"));
	 		//ImageIcon altasimg2 = new ImageIcon(altas.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
	 		//btnaltas.setIcon(altasimg2);
	 		btnaltas.setBounds(318, 210, 56, 50);
	 		this.getContentPane().add(btnaltas);
	 		
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
	 		//btnreportes.setIcon(new ImageIcon("C:\\Users\\\Documents\\3er CUATRIMESTRE\\ima\\reportes.jpg"));
	 		btnreportes.setBounds(384, 210, 56, 50);
	 		this.getContentPane().add(btnreportes);
	 		
	 		/*JLabel lblimagen = new JLabel("");
	 		//lblimagen.setIcon(new ImageIcon(""));
	 		lblimagen.setBounds(288, 68, 138, 128);
	 		getContentPane().add(lblimagen);*/
	 		
	 		lblNoEmpleado = new JLabel("No. Empleado:");
	 		lblNoEmpleado.setFont(new Font("Tahoma", Font.BOLD, 12));
	 		lblNoEmpleado.setBounds(50, 102, 97, 14);
	 		getContentPane().add(lblNoEmpleado);
	 		
	 		lblNombre = new JLabel("Nombre:");
	 		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
	 		lblNombre.setBounds(50, 140, 66, 14);
	 		getContentPane().add(lblNombre);
	 		
	 		lblPuesto = new JLabel("Puesto:");
	 		lblPuesto.setFont(new Font("Tahoma", Font.BOLD, 12));
	 		lblPuesto.setBounds(50, 182, 66, 14);
	 		getContentPane().add(lblPuesto);
	 		
	 		txtnoempleado = new JTextField();
	 		txtnoempleado.setBounds(156, 100, 86, 20);
	 		getContentPane().add(txtnoempleado);
	 		txtnoempleado.setColumns(10);
	 		
	 		txtnombre = new JTextField();
	 		txtnombre.setBounds(156, 138, 86, 20);
	 		getContentPane().add(txtnombre);
	 		txtnombre.setColumns(10);
	 		
	 		txtpuesto = new JTextField();
	 		txtpuesto.setBounds(156, 180, 86, 20);
	 		getContentPane().add(txtpuesto);
	 		txtpuesto.setColumns(10);
	 		
	 		lblNewLabel = new JLabel("New label");
	 		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\yani lizeth\\Downloads\\emp.png"));
	 		lblNewLabel.setBounds(272, 71, 104, 128);
	 		getContentPane().add(lblNewLabel);
	 		
	 	}
	 	
	 	public static void main(String[] args) 
	 	{
	 		// Menu principal del sistema
	 		Altas frame=new Altas();
	 		frame.setVisible(true);
	 	
	 	}
	 }



