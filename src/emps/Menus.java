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

//import empleados_2.Altas;

/*import formularioEmpleados.Altas;
import formularioEmpleados.Bajas;
import formularioEmpleados.Cambios;
import formularioEmpleados.Consultas;*/

import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Menus extends JFrame{
	public static int tipo;
	 private JLabel lbltitulo,lblsubtitulo,  lblUsuario,lbl_user;
	    private JButton btnaltas,btnbajas,btnconsultas,btnmodificaciones,btnreportes;
	    conexion_empleados cn= new conexion_empleados();
	    
		public Menus()
		{
			//setIconImage(Toolkit.getDefaultToolkit().getImage(Menus.class.getResource("/imagenes/user.jpg")));
			getContentPane().setBackground(SystemColor.activeCaption);
			//propiedades del formulario
			this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			this.setSize(469,300);
			this.setResizable(false);
			this.setLocationRelativeTo(null);
			this.setTitle("Sistema de Empleados (Men\u00FA)");
			getContentPane().setLayout(null);
			
			//componenetes del formulario
			lbltitulo=new JLabel();
			lbltitulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
			lbltitulo.setText(".:: Sistema de Empleados ::.");
			lbltitulo.setBounds(116, 11, 266, 30);
			this.getContentPane().add(lbltitulo);
			
			lblsubtitulo=new JLabel();
			lblsubtitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblsubtitulo.setText(".:: Menú Principal ::.");
			lblsubtitulo.setBounds(171, 37, 153, 30);
			this.getContentPane().add(lblsubtitulo);
			
			btnaltas=new JButton();
			btnaltas.setIcon(new ImageIcon("C:\\Users\\yani lizeth\\Downloads\\altas.png"));
			btnaltas.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					if(tipo==1){
					Altas altas=new Altas();
					altas.setVisible(true);
					dispose();
					}else{
						JOptionPane.showMessageDialog(null, "No tiene permisos de admon");
					}
				}
			});
			btnaltas.setToolTipText("Altas de Empleados");
			//btnaltas.setIcon(new ImageIcon(Menus.class.getResource("/imagenes/insert.jpg")));
			btnaltas.setBounds(35, 78, 100, 30);
			this.getContentPane().add(btnaltas);
			
			btnbajas=new JButton();
			btnbajas.setIcon(new ImageIcon("C:\\Users\\yani lizeth\\Downloads\\baja.png"));
			btnbajas.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					Bajas bajas=new Bajas();
					bajas.setVisible(true);
					dispose();
				}
			});
			btnbajas.setToolTipText("Eliminar un Empleado");
			//btnbajas.setIcon(new ImageIcon(Menus.class.getResource("/imagenes/delete.jpg")));
			btnbajas.setBounds(171, 78, 100, 30);
			this.getContentPane().add(btnbajas);
			
			btnconsultas=new JButton();
			btnconsultas.setIcon(new ImageIcon("C:\\Users\\yani lizeth\\Downloads\\consul.png"));
			btnconsultas.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					Consultas consultas=new Consultas();
					consultas.setVisible(true);
					dispose();
				}
			});
			btnconsultas.setToolTipText("Consultar un Empleado");
			//btnconsultas.setIcon(new ImageIcon(Menus.class.getResource("/imagenes/ingresar.jpg")));
			btnconsultas.setBounds(35, 119, 100, 30);
			this.getContentPane().add(btnconsultas);
			
			btnmodificaciones=new JButton();
			btnmodificaciones.setIcon(new ImageIcon("C:\\Users\\yani lizeth\\Downloads\\actualizacion.png"));
			btnmodificaciones.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					Cambios cambios=new Cambios();
					cambios.setVisible(true);
					dispose();
				}
			});
			btnmodificaciones.setToolTipText("Actualizar un Empleado");
			//btnmodificaciones.setIcon(new ImageIcon(Menus.class.getResource("/imagenes/update.jpg")));
			btnmodificaciones.setBounds(171, 119, 100, 30);
			this.getContentPane().add(btnmodificaciones);
			
			btnreportes=new JButton();
			btnreportes.setIcon(new ImageIcon("C:\\Users\\yani lizeth\\Downloads\\reportes.png"));
			btnreportes.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					Reportes reportes=new Reportes();
					reportes.setVisible(true);
					dispose();
				}
			});
			btnreportes.setToolTipText("Reportes de Empleados");
			//btnreportes.setIcon(new ImageIcon(Menus.class.getResource("/imagenes/login.jpg")));
			btnreportes.setBounds(104, 165, 100, 30);
			this.getContentPane().add(btnreportes);
			
			JLabel lblimagen = new JLabel("");
			lblimagen.setIcon(new ImageIcon("C:\\Users\\yani lizeth\\Downloads\\emp.png"));
			//lblimagen.setIcon(new ImageIcon(Menus.class.getResource("/imagenes/user.jpg")));
			lblimagen.setBounds(315, 78, 138, 140);
			getContentPane().add(lblimagen);
			
			JButton btnNewButton = new JButton("");
			btnNewButton.setIcon(new ImageIcon("C:\\Users\\yani lizeth\\Downloads\\exit.png"));
			btnNewButton.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					System.exit(EXIT_ON_CLOSE);
				}
			});
			btnNewButton.setBackground(SystemColor.activeCaption);
			//btnNewButton.setIcon(new ImageIcon(Menus.class.getResource("/imagenes/exit.jpg")));
			btnNewButton.setBounds(403, 229, 50, 32);
			getContentPane().add(btnNewButton);
			
			 lblUsuario = new JLabel("usuario");
			lblUsuario.setBounds(366, 37, 46, 14);
			getContentPane().add(lblUsuario);
			
			lbl_user = new JLabel("0");
			lbl_user.setBounds(366, 62, 46, 14);
			getContentPane().add(lbl_user);
			
			 obtenerusuario();
						
		}
		
		public static void main(String[] args) 
		{
			// Menu principal del sistema
			Menus frame=new Menus();
			frame.setVisible(true);
			

		}
		
		public ResultSet obtenerusuario(){
			String sql;
			int iduser = cn.id_user;
			try {
				
				sql= "SELECT * FROM usuarios_sistema WHERE id_usuario='"+ iduser+"'";
				PreparedStatement p = cn.conetar().prepareStatement(sql); //precompila la consulta y dice si ahi error de sintaxis
				ResultSet r = p.executeQuery();
				if(r.next()){
					lbl_user.setText(r.getString("user"));
					tipo = r.getInt("tipo");
					//JOptionPane.showMessageDialog(null, "el nivel de usuario es: "+r.getString("tipo"));
				}
			} catch (Exception e) {
				
			}
			
			return null;
			
		}
}
