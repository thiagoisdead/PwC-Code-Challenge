package code.challenge;

import javax.swing.*;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import code.challenge.CodeFinal.InputException;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class Interface_gui {

	private JFrame frmFormatadorDeEndereos;
	private JTextField dataInsert;
	private static CodeFinal logica;
	private JTextField dataOutput;
	private JButton formate;
	private JTextField title;
	private JTextField txtMadeInJava;
	private JTextField txtExemplosSimples;
	private JTextField textExemplosMedios;
	private JTextField txtExemplosComplicados;
	private JTextField txtExemplosComplicados2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface_gui window = new Interface_gui();
					window.frmFormatadorDeEndereos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Interface_gui() {
		initialize();
	}
	
	private void initialize() {
		frmFormatadorDeEndereos = new JFrame();
		frmFormatadorDeEndereos.getContentPane().setBackground(new Color(192, 192, 192));
		frmFormatadorDeEndereos.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frmFormatadorDeEndereos.setBackground(new Color(255, 255, 255));
		frmFormatadorDeEndereos.setResizable(false);
		frmFormatadorDeEndereos.setTitle("Formatador de Endereços");
		frmFormatadorDeEndereos.setBounds(0, 0, 900, 600);
		frmFormatadorDeEndereos.setLocationRelativeTo(null);
		frmFormatadorDeEndereos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton exit = new JButton("Sair");
		exit.setBounds(608, 352, 89, 24);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		frmFormatadorDeEndereos.getContentPane().setLayout(null);
		frmFormatadorDeEndereos.getContentPane().add(exit);
		
		JButton Exemplos = new JButton("Exemplos");
		Exemplos.setBounds(374, 353, 114, 23);
		Exemplos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtExemplosSimples.setVisible(true);
				textExemplosMedios.setVisible(true);
				txtExemplosComplicados.setVisible(true);
				txtExemplosComplicados2.setVisible(true);
				Exemplos.setEnabled(false);
				Exemplos.setVisible(false);
			}
		});
		
		JLabel svgJava = new JLabel("");
		svgJava.setBounds(10, 370, 180, 147);
		svgJava.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon icone = new ImageIcon("C:\\OneDrive\\OneDrive - Fatec Centro Paula Souza\\Desktop\\226777.png");
		Image redimensionada = icone.getImage();
		Image newimg2 = redimensionada.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
		ImageIcon novoIcone = new ImageIcon(newimg2);
		svgJava.setIcon(novoIcone);
		
		JButton dataStart = new JButton("Iniciar a inserção de dados");
		dataStart.setBounds(221, 296, 442, 59);
		dataStart.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dataStart.setFocusPainted(false);
		dataStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataInsert.setVisible(true);
				dataOutput.setVisible(true);
				exit.setVisible(true);
				dataStart.setVisible(false);
				svgJava.setVisible(false);
				formate.setVisible(true);
				title.setVisible(false);
				txtMadeInJava.setVisible(false);
				Exemplos.setVisible(true);
			}
		});
		frmFormatadorDeEndereos.getContentPane().add(dataStart);
		
		dataInsert = new JTextField();
		dataInsert.setBounds(70, 296, 251, 45);
		dataInsert.setHorizontalAlignment(SwingConstants.CENTER);
		frmFormatadorDeEndereos.getContentPane().add(dataInsert);
		dataInsert.setColumns(10);
		frmFormatadorDeEndereos.getContentPane().add(svgJava);
		
		dataOutput = new JTextField();
		dataOutput.setBounds(530, 296, 251, 45);
		dataOutput.setEditable(false);
		dataOutput.setHorizontalAlignment(SwingConstants.CENTER);
		frmFormatadorDeEndereos.getContentPane().add(dataOutput);
		dataOutput.setColumns(10);
		
		formate = new JButton("Formatar");
		formate.setBounds(137, 353, 89, 23);
		formate.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				try {
					dataOutput.setText(logica.formatador(dataInsert.getText()));
				} catch (InputException e1) {
					e1.printStackTrace();
				}
			}
		});
		frmFormatadorDeEndereos.getContentPane().add(formate);
		
		title = new JTextField();
		title.setBounds(10, 51, 884, 106);
		title.setForeground(Color.BLACK);
		title.setFocusable(false);
		title.setForeground(new Color(0, 0, 0));
		title.setBackground(new Color(192, 192, 192));
		title.setEditable(false);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setText("Desafio de Código PWC");
		title.setFont(new Font("Sitka Display", Font.BOLD, 48));
		title.setBorder(null);
		frmFormatadorDeEndereos.getContentPane().add(title);
		title.setColumns(10);
		
		txtMadeInJava = new JTextField();
		txtMadeInJava.setBounds(0, 510, 199, 24);
		txtMadeInJava.setEditable(false);
		txtMadeInJava.setBackground(new Color(192, 192, 192));
		txtMadeInJava.setFocusable(false);
		txtMadeInJava.setEditable(false);
		txtMadeInJava.setBorder(null);
		txtMadeInJava.setForeground(Color.BLACK);
		txtMadeInJava.setFont(new Font("Sitka Subheading", Font.PLAIN, 17));
		txtMadeInJava.setHorizontalAlignment(SwingConstants.CENTER);
		txtMadeInJava.setText("Feito em Java");
		title.setBorder(null);
		frmFormatadorDeEndereos.getContentPane().add(txtMadeInJava);
		txtMadeInJava.setColumns(10);
		
		txtExemplosSimples = new JTextField();
		txtExemplosSimples.setBounds(261, 195, 359, 27);
		txtExemplosSimples.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtExemplosSimples.setText("Exemplos: Miritiba 339, Babaçu 500, Cambuí 804B");
		txtExemplosSimples.setBackground(new Color(192, 192, 192));
		frmFormatadorDeEndereos.getContentPane().add(txtExemplosSimples);
		txtExemplosSimples.setColumns(10);
		txtExemplosSimples.setBorder(null);
		txtExemplosSimples.setEditable(false);
		
		textExemplosMedios = new JTextField();
		textExemplosMedios.setBounds(261, 219, 359, 24);
		textExemplosMedios.setBackground(new Color(192, 192, 192));
		textExemplosMedios.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		frmFormatadorDeEndereos.getContentPane().add(textExemplosMedios);
		textExemplosMedios.setText("Rio Branco 23, Quirino dos Santos 23 b");
		textExemplosMedios.setColumns(10);
		textExemplosMedios.setBorder(null);
		textExemplosMedios.setEditable(false);
		
		txtExemplosComplicados = new JTextField();
		txtExemplosComplicados.setBounds(261, 243, 359, 21);
		txtExemplosComplicados.setBackground(new Color(192, 192, 192));
		txtExemplosComplicados.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtExemplosComplicados.setText("4, Rue de la République, 100 Broadway Av");
		frmFormatadorDeEndereos.getContentPane().add(txtExemplosComplicados);
		txtExemplosComplicados.setColumns(10);
		txtExemplosComplicados.setBorder(null);
		txtExemplosComplicados.setEditable(false);
		
		txtExemplosComplicados2 = new JTextField();
		txtExemplosComplicados2.setBounds(261, 261, 359, 24);
		txtExemplosComplicados2.setBackground(new Color(192, 192, 192));
		txtExemplosComplicados2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtExemplosComplicados2.setText("Calle Sagasta 26, Calle 44 No 1991");
		frmFormatadorDeEndereos.getContentPane().add(txtExemplosComplicados2);
		txtExemplosComplicados2.setColumns(10);
		txtExemplosComplicados2.setBorder(null);
		txtExemplosComplicados2.setEditable(false);
		frmFormatadorDeEndereos.getContentPane().add(Exemplos);

		
		dataInsert.setVisible(false);
		dataOutput.setVisible(false);
		exit.setVisible(false);
		svgJava.setVisible(true);
		formate.setVisible(false);
		title.setVisible(true);
		txtMadeInJava.setVisible(true);
		txtExemplosSimples.setVisible(false);
		textExemplosMedios.setVisible(false);
		txtExemplosComplicados.setVisible(false);
		txtExemplosComplicados2.setVisible(false);
		Exemplos.setVisible(false);
	}
}
