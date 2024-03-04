import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JEditorPane;
import java.awt.FlowLayout;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.DropMode;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.DebugGraphics;
import java.awt.ComponentOrientation;
import javax.swing.JList;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;
import java.awt.Component;
import java.awt.Insets;
import java.awt.Point;

public class registroUsuarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registroUsuarios frame = new registroUsuarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public registroUsuarios() {
		setAutoRequestFocus(false);
		setBackground(new Color(255, 255, 255));
		setTitle("Registro de usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 599);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBackground(new Color(128, 255, 128));
		getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		
		JPanel Norte = new JPanel();
		Norte.setBackground(new Color(128, 255, 128));
		panelPrincipal.add(Norte, BorderLayout.NORTH);
		
		JLabel etiquetNorte = new JLabel("Registro de Usuarios");
		etiquetNorte.setForeground(new Color(128, 0, 0));
		etiquetNorte.setFont(new Font("Ebrima", Font.BOLD, 18));
		Norte.add(etiquetNorte);
		
		JPanel Sur = new JPanel();
		Sur.setBackground(new Color(128, 255, 128));
		Sur.setForeground(Color.GRAY);
		panelPrincipal.add(Sur, BorderLayout.SOUTH);
		
		JPanel OESTE = new JPanel();
		OESTE.setBackground(new Color(128, 255, 128));
		panelPrincipal.add(OESTE, BorderLayout.WEST);
		
		JPanel ESTE = new JPanel();
		ESTE.setBackground(new Color(128, 255, 128));
		panelPrincipal.add(ESTE, BorderLayout.EAST);
		
		JPanel CENTRO = new JPanel();
		CENTRO.setBackground(new Color(128, 255, 128));
		panelPrincipal.add(CENTRO, BorderLayout.CENTER);
		CENTRO.setLayout(new GridLayout(2, 2, 5, 5));
		
		JPanel panelDatosGenerales = new JPanel();
		panelDatosGenerales.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		panelDatosGenerales.setBackground(new Color(176, 249, 200));
		CENTRO.add(panelDatosGenerales);
		panelDatosGenerales.setLayout(new BorderLayout(2, 2));
		
		JLabel lblNewLabel = new JLabel(" Datos Generales");
		lblNewLabel.setFont(new Font("Ebrima", Font.BOLD | Font.ITALIC, 15));
		panelDatosGenerales.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(176, 249, 200));
		panelDatosGenerales.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(0, 2, 0, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Nombres: ");
		lblNewLabel_1.setBackground(new Color(176, 249, 200));
		lblNewLabel_1.setFont(new Font("Ebrima", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		textField.setFont(new Font("Ebrima", Font.PLAIN, 12));
		panel_4.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido  Paterno: ");
		lblNewLabel_2.setBackground(new Color(176, 249, 200));
		lblNewLabel_2.setFont(new Font("Ebrima", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Ebrima", Font.PLAIN, 12));
		panel_4.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Apellido Materno:");
		lblNewLabel_3.setBackground(new Color(176, 249, 200));
		lblNewLabel_3.setFont(new Font("Ebrima", Font.BOLD, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Ebrima", Font.PLAIN, 12));
		panel_4.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha de Nacimiento: ");
		lblNewLabel_4.setBackground(new Color(176, 249, 200));
		lblNewLabel_4.setFont(new Font("Ebrima", Font.BOLD, 14));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textField_3.setFont(new Font("Ebrima", Font.PLAIN, 12));
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setText("07/02/1995");
		panel_4.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Sexo: ");
		lblNewLabel_5.setBackground(new Color(176, 249, 200));
		lblNewLabel_5.setFont(new Font("Ebrima", Font.BOLD, 14));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_5);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(176, 249, 200));
		panel_4.add(panel_5);
		panel_5.setLayout(new GridLayout(2, 2, 0, 0));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Mujer");
		rdbtnNewRadioButton.setFont(new Font("Ebrima", Font.BOLD, 12));
		panel_5.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBackground(new Color(176, 249, 200));
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Hombre");
		rdbtnNewRadioButton_1.setFont(new Font("Ebrima", Font.BOLD, 12));
		panel_5.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBackground(new Color(176, 249, 200));
		
		JLabel lblNewLabel_6 = new JLabel("Nacionalidad");
		lblNewLabel_6.setBackground(new Color(176, 249, 200));
		lblNewLabel_6.setFont(new Font("Ebrima", Font.BOLD, 14));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_6);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Ebrima", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"México", "Perú", "Brasil", "Alemania"}));
		panel_4.add(comboBox);
		
		JPanel panelPerfilUsuario = new JPanel();
		panelPerfilUsuario.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		panelPerfilUsuario.setBackground(new Color(255, 179, 179));
		CENTRO.add(panelPerfilUsuario);
		panelPerfilUsuario.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_7 = new JLabel(" Perfil de Usuario");
		lblNewLabel_7.setFont(new Font("Ebrima", Font.BOLD | Font.ITALIC, 15));
		panelPerfilUsuario.add(lblNewLabel_7, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 179, 179));
		panelPerfilUsuario.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 179, 179));
		panel_3.setPreferredSize(new Dimension(10, 55));
		panel.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_15 = new JLabel("");
		panel_3.add(lblNewLabel_15);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Mostrar foto de perfil");
		chckbxNewCheckBox.setFont(new Font("Ebrima", Font.BOLD, 12));
		chckbxNewCheckBox.setBackground(new Color(255, 179, 179));
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_13 = new JLabel("");
		panel_3.add(lblNewLabel_13);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Mostrar fecha de nacimiento");
		chckbxNewCheckBox_1.setFont(new Font("Ebrima", Font.BOLD, 12));
		chckbxNewCheckBox_1.setBackground(new Color(255, 179, 179));
		chckbxNewCheckBox_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(chckbxNewCheckBox_1);
		
		JLabel lblNewLabel_12 = new JLabel("");
		panel_3.add(lblNewLabel_12);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setContentType("");
		editorPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		editorPane.setBorder(new LineBorder(null, 1, true));
		panel.add(editorPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel_11 = new JLabel("                       ");
		panel.add(lblNewLabel_11, BorderLayout.WEST);
		
		JLabel lblNewLabel_14 = new JLabel("                       ");
		panel.add(lblNewLabel_14, BorderLayout.EAST);
		
		JPanel panelDatosOpcionales = new JPanel();
		panelDatosOpcionales.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		panelDatosOpcionales.setBackground(new Color(255, 128, 128));
		CENTRO.add(panelDatosOpcionales);
		panelDatosOpcionales.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_8 = new JLabel(" Datos Opcionales");
		lblNewLabel_8.setFont(new Font("Ebrima", Font.BOLD | Font.ITALIC, 15));
		panelDatosOpcionales.add(lblNewLabel_8, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel_1.setBackground(new Color(255, 128, 128));
		panelDatosOpcionales.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 10));
		
		JLabel lblNewLabel_9 = new JLabel("Descripción             Prefencias\r\n   ");
		lblNewLabel_9.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_9.setMaximumSize(new Dimension(34, 13));
		lblNewLabel_9.setMinimumSize(new Dimension(34, 13));
		lblNewLabel_9.setPreferredSize(new Dimension(34, 13));
		lblNewLabel_9.setFont(new Font("Ebrima", Font.BOLD, 14));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_9, BorderLayout.NORTH);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 128, 128));
		panel_1.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new GridLayout(1, 0, 8, 8));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setDebugGraphicsOptions(DebugGraphics.LOG_OPTION);
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		scrollPane.setBackground(new Color(255, 128, 128));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel_6.add(scrollPane);
		
		JTextArea txtrHolaMeGusta = new JTextArea();
		txtrHolaMeGusta.setMaximumSize(new Dimension(21, 21));
		txtrHolaMeGusta.setSelectionColor(new Color(255, 128, 128));
		txtrHolaMeGusta.setMargin(new Insets(2, 8, 2, 2));
		txtrHolaMeGusta.setLocation(new Point(4, 0));
		txtrHolaMeGusta.setFont(new Font("Ebrima", Font.PLAIN, 16));
		txtrHolaMeGusta.setText("Hola, me \r\ngusta escuchar \r\nmúsica, jugar \r\nvideojuegos, \r\nver películas\r\ny hacer\r\nejercicio");
		scrollPane.setViewportView(txtrHolaMeGusta);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setDebugGraphicsOptions(DebugGraphics.LOG_OPTION);
		panel_6.add(scrollPane_1);
		
		JTextArea txtrCantarLeerDibujar = new JTextArea();
		txtrCantarLeerDibujar.setSelectionColor(new Color(255, 128, 128));
		txtrCantarLeerDibujar.setMargin(new Insets(2, 8, 2, 2));
		txtrCantarLeerDibujar.setFont(new Font("Ebrima", Font.PLAIN, 16));
		txtrCantarLeerDibujar.setText("Cantar\r\nLeer\r\nDibujar\r\nPintar\r\nBailar\r\nJugar\r\nDeportes\r\nOtros");
		scrollPane_1.setViewportView(txtrCantarLeerDibujar);
		
		JLabel lblNewLabel_24 = new JLabel("                       ");
		lblNewLabel_24.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(lblNewLabel_24, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_10 = new JLabel("                       ");
		panelDatosOpcionales.add(lblNewLabel_10, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_23 = new JLabel("             ");
		panelDatosOpcionales.add(lblNewLabel_23, BorderLayout.EAST);
		
		JLabel lblNewLabel_22 = new JLabel("             ");
		panelDatosOpcionales.add(lblNewLabel_22, BorderLayout.WEST);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		panelBotones.setBackground(new Color(176, 249, 200));
		CENTRO.add(panelBotones);
		panelBotones.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_16 = new JLabel("                       ");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panelBotones.add(lblNewLabel_16, BorderLayout.NORTH);
		
		JLabel lblNewLabel_17 = new JLabel("                       ");
		panelBotones.add(lblNewLabel_17, BorderLayout.WEST);
		
		JLabel lblNewLabel_18 = new JLabel("                       ");
		panelBotones.add(lblNewLabel_18, BorderLayout.EAST);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(176, 249, 200));
		panel_2.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		panel_2.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panel_2.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panelBotones.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton = new JButton("Nuevo");
		btnNewButton.setFocusable(false);
		btnNewButton.setFont(new Font("Ebrima", Font.PLAIN, 12));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		panel_2.add(btnNewButton);
		
		JLabel lblNewLabel_20 = new JLabel("                       ");
		panel_2.add(lblNewLabel_20);
		
		JButton btnNewButton_2 = new JButton("Cancelar");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Ebrima", Font.PLAIN, 12));
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		btnNewButton_2.setFocusable(false);
		panel_2.add(btnNewButton_2);
		
		JLabel lblNewLabel_21 = new JLabel("                       ");
		panel_2.add(lblNewLabel_21);
		
		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.setFont(new Font("Ebrima", Font.PLAIN, 12));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_1.setFocusable(false);
		panel_2.add(btnNewButton_1);
		
		JLabel lblNewLabel_19 = new JLabel("                       ");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panelBotones.add(lblNewLabel_19, BorderLayout.SOUTH);
	}
}
