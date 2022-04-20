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
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class Reportes extends JFrame {
	  private JLabel lbltitulo,lblsubtitulo;
	    private JButton btnreportes,btnregresar;
	    private JLabel lblNoEmpleado;
	    private JLabel lblNombre;
	    private JLabel lblPuesto;
	    private JTable table;
	    private static DefaultTableModel model;
	    conexion_empleados con= new conexion_empleados();
	   
		
	  //declaracion del arreglo
	  	String empleados[][]=new String[10][3];
	  	
	  	// variable que contrala los renglones de la matriz del empleado
	  	private PreparedStatement pstm=null;
	  	private JScrollPane scrollPane;
	  	
  	
	    public Reportes()
		{
	    
	    	con.conetar();		
			
			getContentPane().setBackground(SystemColor.activeCaption);
			//propiedades del formulario
			this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			this.setSize(469,300);
			this.setResizable(false);
			this.setLocationRelativeTo(null);
			this.setTitle("Sistema de Empleados (Reportes)");
			getContentPane().setLayout(null);
			
			//componenetes del formulario
			lbltitulo=new JLabel();
			lbltitulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
			lbltitulo.setText(".:: Sistema de Empleados ::.");
			lbltitulo.setBounds(116, 11, 266, 30);
			this.getContentPane().add(lbltitulo);
			
			lblsubtitulo=new JLabel();
			lblsubtitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblsubtitulo.setText("Reportes de empleados");
			lblsubtitulo.setBounds(156, 37, 168, 30);
			this.getContentPane().add(lblsubtitulo);
			
			btnreportes=new JButton();
			btnreportes.setIcon(new ImageIcon("C:\\Users\\yani lizeth\\Downloads\\reportes.png"));
			btnreportes.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
				llenatabla();	
				
				}
			});
			btnreportes.setToolTipText("Reportes de Empleados");
			//btnreportes.setIcon(new ImageIcon(Reportes.class.getResource("/imagenes/insert.png")));
			btnreportes.setBounds(365, 229, 39, 30);
			this.getContentPane().add(btnreportes);
			
			btnregresar=new JButton();
			btnregresar.setIcon(new ImageIcon("C:\\Users\\yani lizeth\\Downloads\\exit.png"));
			btnregresar.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					Menus menu=new Menus();
					menu.setVisible(true);
					dispose();
				}
			});
			btnregresar.setToolTipText("Regresar al Men\u00FA Principal");
			//btnregresar.setIcon(new ImageIcon(Menus.class.getResource("/imagenes/login.png")));
			btnregresar.setBounds(414, 229, 39, 30);
			this.getContentPane().add(btnregresar);
				
			lblNoEmpleado = new JLabel("No. ");
			lblNoEmpleado.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNoEmpleado.setBounds(22, 78, 32, 14);
			getContentPane().add(lblNoEmpleado);
			
			lblNombre = new JLabel("Nombre");
			lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNombre.setBounds(95, 78, 66, 14);
			getContentPane().add(lblNombre);
			
			lblPuesto = new JLabel("Puesto");
			lblPuesto.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblPuesto.setBounds(184, 78, 66, 14);
			getContentPane().add(lblPuesto);
			
			String Columnas[] = {"ID", "NOMBRE", "PUESTO"};
			model= new DefaultTableModel(null, Columnas);
			table = new JTable(model);
			
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 104, 300, 100);
			scrollPane.setViewportView(table);
			getContentPane().add(scrollPane);
			
			
			
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\yani lizeth\\Downloads\\emp.png"));
			lblNewLabel.setBounds(320, 66, 112, 137);
			getContentPane().add(lblNewLabel);
			
				}
	    
	    public Statement llenatabla(){
			try {
				String sql = "SELECT * FROM empleado";
			
				PreparedStatement pstm = con.conetar().prepareStatement(sql);
				ResultSet rs = pstm.executeQuery();
				
				while(rs.next()){
					model.addRow(new Object[]{rs.getInt("id_empleado"), rs.getString("nombre_empleado"),rs.getString("puesto")});
				}
				
			} catch (Exception e) {
				//JOptionPane.showMessageDialog(null, "Error" + e);
				JOptionPane.showMessageDialog(null, "No se ejecuto la consulta"+e.getMessage());
				e.printStackTrace();
			}
			
			
			return null;
		}
		
		
		public static void main(String[] args) 
		{
			// Menu principal del sistema
			Reportes frame=new Reportes();
			frame.setVisible(true);
			

		}
}
