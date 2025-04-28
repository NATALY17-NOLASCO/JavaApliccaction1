package SegundoSemestre;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public abstract class Autenticacion1 extends JFrame implements ActionListener {
    public JButton aceptar;
    public JButton cancelar;
    protected JFrame ventana;
    private JLabel IbIUser, IbIPass;
    protected JTextField txtUser;
    protected JPasswordField contra;
    private JPanel lienzo;
    protected byte x = 0;
    protected boolean resp;
    public Autenticacion1() {
        super("AUTENTICACION DE USUARIO");
        ventana = new JFrame();
        lienzo = new JPanel();
        aceptar = new JButton("Aceptar");
        aceptar.addActionListener((ActionListener) this);
        cancelar = new JButton("Cancelar");
        cancelar.addActionListener((ActionListener)this);
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
        ventana.setVisible(true);
        ventana.setSize(300, 200);
    }
    public static void main(String args[]) {
        Autenticacion vent = new Autenticacion() {};
        vent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private boolean evaluacion() {
        String user, pass;
        user = txtUser.getText();
        pass = contra.getText();
        if (user.equals("nat") && pass.equals("1706")) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource().equals(aceptar)) {
            resp = evaluacion();
            if (resp == false) {
                x++;
                if(x <= 3) {
                    txtUser.setText("");
                    contra.setText("");
                    System.out.println("Intento fallido " + x + " de 3.");
                }
                if (x >= 3) {
                    System.out.println("Máximo número de intentos alcanzado.");
                    System.exit(0); 
                }
            } else {
                ventana.setVisible(false);
                System.out.println("Autenticación exitosa.");
            }
        }
        else if (ev.getSource().equals(cancelar)) {
            System.exit(0);
        }
    }
}
