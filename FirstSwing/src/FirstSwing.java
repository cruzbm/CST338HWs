import javax.swing.JFrame;
import javax.swing.JButton;

public class FirstSwing extends JFrame
{
    public FirstSwing( )
    {
        super( );
        setSize(1200, 1000);
        setTitle("First Swing Class");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton endButton = new JButton("Click to end program.");
        EndingListener buttonEar = new EndingListener();
        endButton.addActionListener(buttonEar);
        add(endButton);
    }
}