package emps;


import javax.swing.JFrame;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Bajas extends JFrame {

	private JButton btnaltas, btnregresar;
	private JTextField txtNum;
	
	String empleados[][]=new String[3][10];
	private JLabel label;
	conexion_empleados cn = new conexion_empleados();
	private JLabel lblNewLabel;
	public Bajas()
	{
		
		
		getContentPane().setBackground(SystemColor.activeCaption);
		//Propiedades del formulario
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setSize(416, 300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Sistema de Empleados (Bajas)");
		getContentPane().setLayout(null);
		
		btnaltas= new JButton();
		btnaltas.setIcon(new ImageIcon("C:\\Users\\yani lizeth\\Downloads\\baja.png"));
		btnaltas.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try{ 
					PreparedStatement pstm = cn.conetar().prepareStatement("DELETE FROM empleado WHERE id_empleado="+ txtNum.getText());
		        	int i=pstm.executeUpdate();
		        	
		        	if(i==0){        		
		        		JOptionPane.showMessageDialog(null, "empleado eliminado exitosamente");
		        		txtNum.setText("");
		    
		        	}
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null,(e1.getMessage()));	
				}//llave del segundo catch	


			}
		});
		btnaltas.setToolTipText("Dar de Baja");
		btnaltas.setBounds(310, 230, 40, 30);
		this.getContentPane().add(btnaltas);
		
		btnregresar= new JButton();
		btnregresar.setIcon(new ImageIcon("C:\\Users\\yani lizeth\\Downloads\\exit.png"));
		btnregresar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				Menus menu = new Menus();
				menu.setVisible(true);
				dispose();
			}
		});
		
		btnregresar.setToolTipText("Regreasr al Men\u00FA Principal");
		btnregresar.setBounds(360, 230, 40, 30);
		this.getContentPane().add(btnregresar);
		
		JLabel lblNumeroDeEmpleado = new JLabel("No Empleado");
		lblNumeroDeEmpleado.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblNumeroDeEmpleado.setBounds(32, 119, 96, 23);
		getContentPane().add(lblNumeroDeEmpleado);
		
		txtNum = new JTextField();
		txtNum.setBounds(138, 112, 150, 30);
		getContentPane().add(txtNum);
		txtNum.setColumns(10);
		
		
		JLabel label_1 = new JLabel();
		label_1.setText(".:: Sistema de Empleados ::.");
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		label_1.setBounds(70, 11, 266, 30);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel();
		label_2.setText("Altas de empleados");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(138, 40, 153, 30);
		getContentPane().add(label_2);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\yani lizeth\\Downloads\\emp.png"));
		lblNewLabel.setBounds(284, 65, 96, 125);
		getContentPane().add(lblNewLabel);
	}
	public static void main(String[] args) 
	{
		Bajas pantalla= new Bajas();
		pantalla.setVisible(true);


	}

}
