import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FlowLayoutJFrame extends JFrame implements ActionListener
{
    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;
    private JLabel label1;

    public FlowLayoutJFrame( )
    {
        super( );
        setSize(WIDTH, HEIGHT);
        setTitle("Layout Demonstration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout( ));

        label1 = new JLabel("Hello Swing");
        add(label1);

        JButton button1 = new JButton("OK");
        button1.addActionListener(this);
        add(button1);

        JButton button2 = new JButton("Exit");
        button2.addActionListener(this);
        add(button2);
    }

    public void actionPerformed(ActionEvent e)
    {
        String buttonString = e.getActionCommand( );

        if (buttonString.equals("Exit"))
        {
            System.exit(0);
        }
        else if (buttonString.equals("OK"))
        {
            this.label1.setText("Ok was pressed.");
        }
        else
        {
            System.out.println("Unexpected error.");
        }
    }
}