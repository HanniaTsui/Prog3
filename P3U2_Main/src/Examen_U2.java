import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Examen_U2 extends JFrame {
	
	
	public Examen_U2() {
		// TODO Auto-generated constructor stub
		this.setTitle("Factura en JAVA");
		this.setSize(800,740);
		this.setLocationRelativeTo(null);
		this.setMaximumSize(new Dimension (800,800));
		this.setMinimumSize(new Dimension (250,250));
		this.setResizable(false);
		this.setLayout(null); //Quitar el molde
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.iniciarComponentes();
        this.setVisible(true); 
	}
	
	public void iniciarComponentes()
	{
		this.factura();
	}
	
	public void factura()
	{
		JPanel panel = new JPanel();
		panel.setSize(this.getWidth(), this.getHeight());
		panel.setLocation(0,0);
		panel.setBackground(new Color(241, 241, 241));
		panel.setLayout(null);	
		
		JLabel titulo = new JLabel ("      Factura en JAVA - NetBeans - ArrayList y POO");
		titulo.setForeground(Color.white);
		titulo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		titulo.setBounds(0,-10, this.getWidth(), 100);
		panel.add(titulo); 
		
		JLabel subTitulo = new JLabel ("          [Sin Base de datos]");
		subTitulo.setForeground(Color.white);
		subTitulo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		subTitulo.setBounds(0,10, this.getWidth(), 100);
		panel.add(subTitulo); 
		
		JLabel titArriba = new JLabel (" ");
		titArriba.setBackground(new Color(0,101,153));
		titArriba.setBounds(0,0, this.getWidth(), 100);
		titArriba.setOpaque(true);
		panel.add(titArriba);
		
		
		//DATOS DEL CLIENTE
		JLabel datos = new JLabel ("");
		datos.setBounds(40,130, 700, 100);
		datos.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(226, 226, 226), 1), "Datos del cliente", TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial Rounded MT Bold", Font.PLAIN, 12), new Color(0, 0, 0)), null));
		panel.add(datos);
		
		JLabel docs = new JLabel("Documento: ");
		docs.setBounds(60,155,80,25);
		docs.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		panel.add(docs);
		
		JLabel direccion = new JLabel("Dirección: ");
		direccion.setBounds(60,190,80,25);
		direccion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		panel.add(direccion);
		
		JLabel nombre = new JLabel("Nombres: ");
		nombre.setBounds(420,155,80,25);
		nombre.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		panel.add(nombre);
		
		JLabel tel = new JLabel("Teléfono: ");
		tel.setBounds(420,190,80,25);
		tel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		panel.add(tel);
		
		JTextField noDocs = new JTextField(" 123456");
		noDocs.setBounds(140,155,200,25);
		noDocs.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		noDocs.setBorder(BorderFactory.createLineBorder(new Color(222, 222, 222), 2));
		panel.add(noDocs);
		
		JTextField dir = new JTextField(" Calle 1 # 123");
		dir.setBounds(140,190,200,25);
		dir.setBorder(BorderFactory.createLineBorder(new Color(222, 222, 222), 2));
		dir.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		panel.add(dir);
		
		JTextField name = new JTextField(" Jhon Doe");
		name.setBounds(500,155,200,25);
		name.setBorder(BorderFactory.createLineBorder(new Color(222, 222, 222), 2));
		name.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		panel.add(name);
		
		JTextField noTel = new JTextField(" 5554433");
		noTel.setBounds(500,190,200,25);
		noTel.setBorder(BorderFactory.createLineBorder(new Color(222, 222, 222), 2));
		noTel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		panel.add(noTel);
		
		// DATOS DE FACTURA
		JLabel datosFac = new JLabel ("");
		datosFac.setBounds(40,250, 700, 60);
		datosFac.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(226, 226, 226), 1), "Datos de factura", TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial Rounded MT Bold", Font.PLAIN, 12), new Color(0, 0, 0)), null));
		panel.add(datosFac);
		
		JLabel factura = new JLabel(" N° Factura: ");
		factura.setBounds(60,270,75,25);
		factura.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		panel.add(factura);
		
		JLabel noFactura = new JLabel(" 1");
		noFactura.setBounds(140,270,200,25);
		noFactura.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		panel.add(noFactura);
		
		JLabel fecha = new JLabel(" Fecha: ");
		fecha.setBounds(420,270,70,25);
		fecha.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		panel.add(fecha);
		
		JLabel noFecha = new JLabel(" 2021 / 50 / 21");
		noFecha.setBounds(500,270,200,25);
		noFecha.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		panel.add(noFecha);
		
		// LISTADO DE FACTURAS
		JLabel list = new JLabel ("");
		list.setBounds(41,330, 698, 50);
		list.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(222, 222, 222), 1), "", TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial Rounded MT Bold", Font.PLAIN, 12), new Color(0, 0, 0)), null));
		panel.add(list);
		
		JLabel logoLista = new JLabel();
		logoLista.setIcon(new ImageIcon(getClass().getResource("lista.png")));
		logoLista.setBounds(60,343,30,30);
		panel.add(logoLista);
		
		JLabel verLista = new JLabel ("Ver listado de facturas");
		verLista.setBounds(80,345, 150, 25);
		verLista.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		panel.add(verLista);
		
		
		
		JLabel anadir = new JLabel ("Añadir");
		anadir.setBounds(590,345, 150, 25);
		anadir.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		panel.add(anadir);
		
		JLabel logoAnadir = new JLabel();
		logoAnadir.setIcon(new ImageIcon(getClass().getResource("logoanadir.png")));
		logoAnadir.setBounds(570,343,30,30);
		panel.add(logoAnadir);
		
		JLabel eliminar = new JLabel ("Eliminar");
		eliminar.setBounds(670,345, 150, 25);
		eliminar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		panel.add(eliminar);
		
		JLabel logoEliminar = new JLabel();
		logoEliminar.setIcon(new ImageIcon(getClass().getResource("logoeliminar.png")));
		logoEliminar.setBounds(650,343,30,30);
		panel.add(logoEliminar);
		
		//TABLA
		String titles[]= {"Producto", "Cantidad", "Valor", "Sub Total"};
		
		String data[][]={{" Agua", "2", "500", "1000.0"},
						 {" Cereal", "5", "1000", "5000.0"},
						 {" Leche", "2", "300", "600.0"}
						 };
		JTable datosTabla = new JTable(data, titles);
		datosTabla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		JScrollPane tablaScroll = new JScrollPane(datosTabla);
		tablaScroll.setBorder(BorderFactory.createLineBorder(new Color(222, 222, 222), 2));
		tablaScroll.setBounds(40,400,700,105);
		panel.add(tablaScroll);
		
		// SUB TOTAL
		
		JLabel subTotal = new JLabel("  SubTotal: ");
		subTotal.setBounds(40,530,70,25);
		subTotal.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		panel.add(subTotal);
		
		JLabel noSubTotal = new JLabel("  6600.0");
		noSubTotal.setBounds(140,530,200,25);
		noSubTotal.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		panel.add(noSubTotal);
		
		JLabel descuento = new JLabel("  % Descuento: ");
		descuento.setBounds(40,565,100,25);
		descuento.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		panel.add(descuento);
		
		JTextField noDesc = new JTextField(" 5");
		noDesc.setBounds(143,565,50,25);
		noDesc.setBorder(BorderFactory.createLineBorder(new Color(222, 222, 222), 2));
		noDesc.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		panel.add(noDesc);
		
		
		JCheckBox verificar = new JCheckBox("", true);
		verificar.setBounds(215,566,20,20);
		verificar.setOpaque(false);
		panel.add(verificar);
		
		JLabel valorDesc = new JLabel("Valor descontado: ");
		valorDesc.setBounds(275,565,150,25);
		valorDesc.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		panel.add(valorDesc);
		
		JLabel noValor = new JLabel(" 330.0");
		noValor.setBounds(405,565,50,25);
		noValor.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		panel.add(noValor);
		
		JLabel iva = new JLabel("  IVA 19%: ");
		iva.setBounds(40,595,70,25);
		iva.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		panel.add(iva);
		
		JLabel noIva = new JLabel("  1254.0");
		noIva.setBounds(140,595,200,25);
		noIva.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		panel.add(noIva);
		
		JLabel totalFac = new JLabel("  Total Factura: ");
		totalFac.setBounds(40,625,100,25);
		totalFac.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		panel.add(totalFac);
		
		JLabel noTotal = new JLabel("  7524.0");
		noTotal.setBounds(140,625,200,25);
		noTotal.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		panel.add(noTotal);
		
		JButton botonFin = new JButton("Finalizar Factura");
		botonFin.setBounds(510,655,140,25);
		botonFin.setBackground(new Color(223,223,223));
		botonFin.setFocusable(false);
		botonFin.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		panel.add(botonFin);
		
		JButton botonLimpiar = new JButton("Limpiar");
		botonLimpiar.setBounds(660,655,80,25);
		botonLimpiar.setBackground(new Color(223,223,223));
		botonLimpiar.setFocusable(false);
		botonLimpiar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		panel.add(botonLimpiar);
		
		
		
		JLabel barraAbajo = new JLabel (" ");
		barraAbajo.setBackground(new Color(0,101,153));
		barraAbajo.setBounds(0,690, this.getWidth(), 30);
		barraAbajo.setOpaque(true);
		panel.add(barraAbajo);
		
		
		this.add(panel);
	}
	
	
}
