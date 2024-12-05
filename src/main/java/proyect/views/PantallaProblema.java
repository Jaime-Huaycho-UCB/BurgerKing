package proyect.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import proyect.lib.Libreria;
import proyect.models.Resolucion.Servidor;
import proyect.models.Resolucion.UnServidor;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class PantallaProblema extends JFrame {

	private Libreria lib = new Libreria();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblLambda;
	private JTextArea SalidaLambda;
	private JLabel lblP;
	private JTextArea SalidaP;
	private JLabel lblPo;
	private JTextArea SalidaPo;
	private JLabel lblLs;
	private JTextArea SalidaLs;
	private JLabel lblLq;
	private JTextArea SalidaLq;
	private JLabel lblWs;
	private JTextArea SalidaWs;
	private JLabel lblWq;
	private JTextArea SalidaWq;
	private JButton BotonVolver;
	private JLabel SalidaTitulo;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton BotonCalcularSistema;
	private JButton BotonCalcularCola;
	private JButton BotonCalcularPn;

	public PantallaProblema(Servidor servidor) {
		String titulo = "";
		if (servidor instanceof UnServidor){
			titulo="Un servidor";
		}else{
			titulo="Mas de un servidor";
		}
		servidor.realizarCalculos();
		System.out.println(servidor);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("µ");
		lblNewLabel.setBounds(71, 136, 61, 16);
		contentPane.add(lblNewLabel);
		
		JTextArea SalidaMiu = new JTextArea();
		SalidaMiu.setText(servidor.getMiu()+"");
		SalidaMiu.setBounds(144, 136, 103, 16);
		contentPane.add(SalidaMiu);
		
		lblLambda = new JLabel("Lambda");
		lblLambda.setBounds(71, 164, 61, 16);
		contentPane.add(lblLambda);
		
		SalidaLambda = new JTextArea();
		SalidaLambda.setText(servidor.getLambda()+"");
		SalidaLambda.setBounds(144, 164, 103, 16);
		contentPane.add(SalidaLambda);
		
		lblP = new JLabel("P");
		lblP.setBounds(71, 192, 61, 16);
		contentPane.add(lblP);
		
		SalidaP = new JTextArea();
		SalidaP.setText(servidor.getP()+"");
		SalidaP.setBounds(144, 192, 103, 16);
		contentPane.add(SalidaP);
		
		lblPo = new JLabel("Po");
		lblPo.setBounds(71, 220, 61, 16);
		contentPane.add(lblPo);
		
		SalidaPo = new JTextArea();
		SalidaPo.setText(servidor.getPo()+"");
		SalidaPo.setBounds(144, 220, 103, 16);
		contentPane.add(SalidaPo);
		
		lblLs = new JLabel("Ls");
		lblLs.setBounds(71, 248, 61, 16);
		contentPane.add(lblLs);
		
		SalidaLs = new JTextArea();
		SalidaLs.setText(servidor.getLs()+"");
		SalidaLs.setBounds(144, 248, 103, 16);
		contentPane.add(SalidaLs);
		
		lblLq = new JLabel("Lq");
		lblLq.setBounds(71, 276, 61, 16);
		contentPane.add(lblLq);
		
		SalidaLq = new JTextArea();
		SalidaLq.setText(servidor.getLq()+"");
		SalidaLq.setBounds(144, 276, 103, 16);
		contentPane.add(SalidaLq);
		
		lblWs = new JLabel("Ws");
		lblWs.setBounds(71, 304, 61, 16);
		contentPane.add(lblWs);
		
		SalidaWs = new JTextArea();
		SalidaWs.setText(servidor.getWs()+"");
		SalidaWs.setBounds(144, 304, 103, 16);
		contentPane.add(SalidaWs);
		
		lblWq = new JLabel("Wq");
		lblWq.setBounds(71, 332, 61, 16);
		contentPane.add(lblWq);
		
		SalidaWq = new JTextArea();
		SalidaWq.setText(servidor.getWq()+"");
		SalidaWq.setBounds(144, 332, 103, 16);
		contentPane.add(SalidaWq);
		
		BotonVolver = new JButton("Volver");
		BotonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaInicio pantallaInicio = new PantallaInicio();
				pantallaInicio.setLocationRelativeTo(null);
				pantallaInicio.setVisible(true);
				dispose();
			}
		});
		BotonVolver.setBounds(6, 0, 117, 29);
		contentPane.add(BotonVolver);
		
		SalidaTitulo = new JLabel(titulo);
		SalidaTitulo.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		SalidaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		SalidaTitulo.setBounds(16, 35, 541, 48);
		contentPane.add(SalidaTitulo);
		
		lblNewLabel_2 = new JLabel("Variables");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(71, 95, 176, 29);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Probabilidades");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(317, 95, 176, 29);
		contentPane.add(lblNewLabel_3);
		
		BotonCalcularSistema = new JButton("Tiempo de espera en sistema");
		BotonCalcularSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirCalculadora(servidor, "sistema");
			}
		});
		BotonCalcularSistema.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		BotonCalcularSistema.setBounds(299, 141, 209, 65);
		contentPane.add(BotonCalcularSistema);
		
		BotonCalcularCola = new JButton("Tiempo de espera en cola");
		BotonCalcularCola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirCalculadora(servidor, "cola");
			}
		});
		BotonCalcularCola.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		BotonCalcularCola.setBounds(299, 227, 209, 65);
		contentPane.add(BotonCalcularCola);
		
		BotonCalcularPn = new JButton("Calcular Pn");
		BotonCalcularPn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = lib.EntradaEntero("Ingrese la cantidad de clientes a evaluar","informatio","Probabilidad de n clientes en cola");
				double Pn = servidor.calcularPn(n);
				Pn=lib.redondear(Pn);
				lib.MostrarConfirmacion("La probabilidad de que haya "+n+" cliente en cola es del "+(Pn*100.00)+"%");
			}
		});
		BotonCalcularPn.setBounds(71, 360, 176, 29);
		contentPane.add(BotonCalcularPn);
	}

	public void abrirCalculadora(Servidor servidor,String titulo){
		PantallaCalcularProbabilidad pantallaCalcularProbabilidad = new PantallaCalcularProbabilidad(servidor,titulo);
		pantallaCalcularProbabilidad.setLocationRelativeTo(null);
		pantallaCalcularProbabilidad.setVisible(true);
	}
}
