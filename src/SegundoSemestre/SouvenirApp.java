package SegundoSemestre;
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.*;
import java.util.*;
import java.awt.Color;
import javax.swing.JFrame;
public class SouvenirApp extends JFrame {
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
        String productoInicial = (String) comboProductos.getSelectedItem();
        lblPrecio.setText("$" + productos.get(productoInicial));
        setVisible(true);
    }
    public static void main(String[] args) {
        new SouvenirApp();
    }
}