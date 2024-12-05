package proyect.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import proyect.config;
import proyect.lib.Libreria;
import proyect.models.Excel;
import proyect.models.Resolucion.MasDeUnServidor;
import proyect.models.Resolucion.Servidor;
import proyect.models.Resolucion.UnServidor;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaInicio extends JFrame implements config{

	private Libreria lib = new Libreria();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public PantallaInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 290, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton BotonUnServidor = new JButton("Un servidor");
		BotonUnServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IniciarProblema(1);
			}
		});
		BotonUnServidor.setBounds(70, 125, 148, 29);
		contentPane.add(BotonUnServidor);
		
		JButton BotonMasUnServidor = new JButton("Mas de un servidor");
		BotonMasUnServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IniciarProblema(2);
			}
		});
		BotonMasUnServidor.setBounds(70, 193, 148, 29);
		contentPane.add(BotonMasUnServidor);
		
		JLabel lblNewLabel = new JLabel("Teoria de colas");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 48, 278, 41);
		contentPane.add(lblNewLabel);
	}

	public void IniciarProblema(int opcion){
		Double tiempoObservacion = lib.EntradaDecimal("Ingrese el tiempo de observacion");
		Servidor servidor = null;
		if (opcion==1){
			servidor = new UnServidor(new Excel(HOJA_1), tiempoObservacion); 
		}else{
			int servidores = lib.EntradaEntero("Ingrese el numero de servidores");
			servidor = new MasDeUnServidor(new Excel(HOJA_2), tiempoObservacion,servidores); 
		}
		PantallaProblema pantallaProblema = new PantallaProblema(servidor);
		pantallaProblema.setLocationRelativeTo(null);
		pantallaProblema.setVisible(true);
		dispose();
	}
}
