import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class productos_crud extends JFrame {
    private JTextField textnombre;
    private JTextField textdescripcion;
    private JTextField textprecio;
    private JTextField textStock;
    private JButton actualizar;
    private JButton eliminar;
    private JButton buscarB;
    private JButton limpiar;
    private JTextField textid;
    private JButton agregar;
    private JPanel mainPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("productos_crud");
        frame.setContentPane(new productos_crud().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public productos_crud() {
        agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


}

