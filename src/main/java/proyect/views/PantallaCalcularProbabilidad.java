package proyect.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import proyect.lib.Libreria;
import proyect.models.Resolucion.Servidor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaCalcularProbabilidad extends JFrame {

	private Libreria lib = new Libreria();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField EntradaTiempo;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PantallaCalcularProbabilidad(Servidor servidor,String titulo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 316, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel SalidaTitulo = new JLabel("Probabilidad de tiempo de espera en "+titulo);
		SalidaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		SalidaTitulo.setBounds(6, 6, 304, 16);
		contentPane.add(SalidaTitulo);
		
		JComboBox EntradaOperador = new JComboBox();
		EntradaOperador.setModel(new DefaultComboBoxModel(new String[] {">", "<="}));
		EntradaOperador.setBounds(119, 35, 73, 27);
		contentPane.add(EntradaOperador);
		
		JLabel lblNewLabel_1 = new JLabel("P ( Ws");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(81, 39, 37, 16);
		contentPane.add(lblNewLabel_1);
		
		EntradaTiempo = new JTextField();
		EntradaTiempo.setBounds(185, 34, 47, 26);
		contentPane.add(EntradaTiempo);
		EntradaTiempo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel(")");
		lblNewLabel_2.setBounds(232, 39, 15, 16);
		contentPane.add(lblNewLabel_2);
		
		JButton BotonCerrar = new JButton("Cerrar");
		BotonCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		BotonCerrar.setBounds(22, 74, 117, 29);
		contentPane.add(BotonCerrar);
		
		JButton BotonCalcular = new JButton("Calcular");
		BotonCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double tiempo = Double.parseDouble(EntradaTiempo.getText());
					double resultado = 0.00;
					if (titulo.equals("sistema")){
						resultado=servidor.probabilidadTiempoSistema(tiempo,EntradaOperador.getSelectedItem().toString());
					}else{
						resultado=servidor.probabilidadTiempoCola(tiempo,EntradaOperador.getSelectedItem().toString());
					}
					resultado=lib.redondear(resultado);
					lib.MostrarConfirmacion("La pobabilidad de esperar "+tiempo+" minutos en "+titulo+" es del "+(resultado*100.00)+"%");
				} catch (NumberFormatException er) {
					lib.MostrarError("ingrese un valor numerico");
				}
			}
		});
		BotonCalcular.setBounds(168, 74, 117, 29);
		contentPane.add(BotonCalcular);
	}
}
