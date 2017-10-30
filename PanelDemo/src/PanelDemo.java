import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelDemo extends JFrame implements ActionListener
{
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 1000;

    private int studentNum;
    private int courseNum;

    private JLabel student;
    private JLabel course;

    JMenuBar menuBar;

    public static void main(String[] args)
    {
        PanelDemo gui = new PanelDemo( );
        gui.setVisible(true);
    }

    public PanelDemo( )
    {
        super("Panel Demonstration");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2,1));

        this.studentNum = 0;
        this.courseNum = 0;

        JPanel biggerPanel = new JPanel( );
        biggerPanel.setLayout(new GridLayout(1,2));

        Border border = BorderFactory.createLineBorder(Color.BLACK);

        student = new JLabel();
        student.setText("Number of students: " + studentNum);
        student.setHorizontalAlignment(JLabel.CENTER);
        student.setBorder(border);
        biggerPanel.add(student);

        course = new JLabel("Number of courses: " + courseNum);
        course.setHorizontalAlignment(JLabel.CENTER);
        course.setBorder(border);
        biggerPanel.add(course);

        add(biggerPanel);

        JPanel buttonPanel = new JPanel( );
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

            JButton studentButton = new JButton("Student");
            studentButton.addActionListener(this);
            buttonPanel.add(studentButton);

            JButton courseButton = new JButton("Course");
            courseButton.addActionListener(this);
            buttonPanel.add(courseButton);

            JButton exitButton = new JButton("Exit");
            exitButton.addActionListener(this);
            buttonPanel.add(exitButton);

        add(buttonPanel, BorderLayout.SOUTH);

        menuBar = new JMenuBar();
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(this);
        menuBar.add(exitItem);

        add(menuBar, BorderLayout.NORTH);

    }

    public void actionPerformed(ActionEvent e)
    {
        String buttonString = e.getActionCommand( );

        if (buttonString.equals("Student"))
        {
            studentNum ++;
        }
        else if (buttonString.equals("Course"))
        {
            courseNum ++;
        }
        else if (buttonString.equals("Exit"))
        {
            System.exit(0);
        }
        else
        {
            System.out.println("Unexpected error.");
        }
    }
}