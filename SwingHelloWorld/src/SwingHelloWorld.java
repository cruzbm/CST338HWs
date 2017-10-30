import javax.swing.*;


public final class SwingHelloWorld extends JFrame {

    public SwingHelloWorld() {
        super();
        setSize(300, 200);
        setTitle("Hello World!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new JLabel("Brandon Cruz ", SwingConstants.CENTER));
    }

    public static void main(String[] args) {
        (new SwingHelloWorld()).setVisible(true);
    }
}