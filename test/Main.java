import javax.swing.JOptionPane;

class Facturacion {
    private String nombre;

    public Facturacion() {
        System.out.println(""" 
                           Tecnologico de Estudios Superiores de Jilotepec 
                           Ingenieria en Sistemas Computacionales
                           Programacion Orientada a Objetos
                           Nataly Gabrielle Garcia Nolasco
                           Yadira Esther Jimenez Perez
                           Segundo Semestre
                           """);
    }

    public Facturacion(String nombre) {
        this.nombre = nombre;
        System.out.println("Bienvenido " + nombre);
    }

    public void pedirDatos() {
        double costoProducto1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el costo de los refrescos "));
        int cantidadProducto1 = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos refrescos deseas comprar?"));
        double costoProducto2 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el costo de las botellas de agua "));
        int cantidadProducto2 = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántas botellas de agua desea comprar?"));

        double totalPagar = (costoProducto1 * cantidadProducto1) + (costoProducto2 * cantidadProducto2);
        System.out.println("El total a pagar es: " + totalPagar);
    }

    public void pedirDatos(String producto1, String producto2) {
        System.out.println("Refrescos: " + producto1);
        System.out.println("Botellas de agua: " + producto2);
    }
}

public class Main {
    public static void main(String[] args) {
        Facturacion facturacion = new Facturacion();  
        facturacion.pedirDatos();
        facturacion.pedirDatos("Producto 1", "Producto 2");
    }
}
