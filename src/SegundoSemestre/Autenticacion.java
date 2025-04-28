package SegundoSemestre;
import SegundoSemestre.SouvenirApp;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.Color;
public class Autenticacion extends JFrame implements ActionListener {
    public JButton aceptar;
    public JButton cancelar;
    protected JFrame ventana;
    private JLabel IbIUser, IbIPass;
    protected JTextField txtUser;
    protected JPasswordField contra;
    private JPanel lienzo;
    protected byte x = 0;
    protected boolean resp;
    public Autenticacion() {
        super("AUTENTICACION DE USUARIO");
        ventana = new JFrame("Autenticación");
        lienzo = new JPanel();
        aceptar = new JButton("Aceptar");
        aceptar.addActionListener(this);
        cancelar = new JButton("Cancelar");
        cancelar.addActionListener(this);
        IbIUser = new JLabel("Usuario");
        IbIPass = new JLabel("Contrasena");
        txtUser = new JTextField();
        contra = new JPasswordField();
        lienzo.setLayout(new GridLayout(3, 2, 5, 5));
        lienzo.setBackground(Color.pink);
        lienzo.add(IbIUser);
        lienzo.add(txtUser);
        lienzo.add(IbIPass);
        lienzo.add(contra);
        lienzo.add(aceptar);
        lienzo.add(cancelar);
        ventana.add(lienzo, BorderLayout.CENTER);
        ventana.setSize(300, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null); // Centrar ventana
        ventana.setVisible(true);
    }
    private boolean evaluacion() {
        String user = txtUser.getText();
        String pass = new String(contra.getPassword());
        return user.equals("nat") && pass.equals("1706");
    }
    @Override
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource().equals(aceptar)) {
            resp = evaluacion();
            if (!resp) {
                x++;
                if (x <= 3) {
                    txtUser.setText("");
                    contra.setText("");
                    JOptionPane.showMessageDialog(ventana, "Intento fallido " + x + " de 3.");
                }
                if (x >= 3) {
                    JOptionPane.showMessageDialog(ventana, "Máximo número de intentos alcanzado.");
                    System.exit(0);
                }
            } else {
                ventana.setVisible(false);
                ventana.dispose(); 
                new SouvenirApp(); 
            }
        } else if (ev.getSource().equals(cancelar)) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Autenticacion();
    }
}
class SouvenirApp extends JFrame {
    private JComboBox<String> comboProductos;
    private JTextArea areaNota;
    private JLabel lblNota, lblPrecio;
    private int notaActual = 1;
    private Map<String, Integer> productos = new HashMap<>();
    public SouvenirApp() {
        super("Bioparque Estrella - Souvenirs");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        productos.put("Gorro", 70);
        productos.put("Taza", 60);
        productos.put("Termo", 80);
        productos.put("Llavero", 50);
        productos.put("Peluche", 120);
        productos.put("Playera", 150);
        productos.put("Pulsera", 40);
        productos.put("Espejo", 30);
        JPanel panelSuperior = new JPanel(new GridLayout(3, 2, 5, 5));
        panelSuperior.setBackground(Color.pink);
        panelSuperior.add(new JLabel("Souvenir:"));
        comboProductos = new JComboBox<>(productos.keySet().toArray(new String[0]));
        panelSuperior.add(comboProductos);
        panelSuperior.add(new JLabel("Precio:"));
        lblPrecio = new JLabel();
        panelSuperior.add(lblPrecio);
        panelSuperior.add(new JLabel("Nota #:"));
        lblNota = new JLabel("Nota " + notaActual);
        panelSuperior.add(lblNota);
        add(panelSuperior, BorderLayout.NORTH);
        areaNota = new JTextArea();
        areaNota.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaNota);
        add(scroll, BorderLayout.CENTER);
        JPanel panelInferior = new JPanel();
        panelInferior.setBackground(Color.pink);
        JButton btnAceptar = new JButton("Aceptar");
        JButton btnAgregar = new JButton("Agregar");
        JButton btnCancelar = new JButton("Cancelar");
        JButton btnTotal = new JButton("Calcular Total");
        panelInferior.add(btnAceptar);
        panelInferior.add(btnAgregar);
        panelInferior.add(btnCancelar);
        panelInferior.add(btnTotal);
        add(panelInferior, BorderLayout.SOUTH);
        comboProductos.addActionListener(e -> actualizarPrecio());
        String productoInicial = (String) comboProductos.getSelectedItem();
        lblPrecio.setText("$" + productos.get(productoInicial));
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void actualizarPrecio() {
        String productoSeleccionado = (String) comboProductos.getSelectedItem();
        lblPrecio.setText("$" + productos.get(productoSeleccionado));
    }
}
