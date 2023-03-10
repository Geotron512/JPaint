import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener{
    //Variables
    public JTextField color = new JTextField("0, 0, 0");
    private final JButton random = new JButton("Paint for me");
    private Color c;
    Grid g;
    //Action
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        if(b.equals(random)) Main.randPaint(this, 1024, 1);
        else paintButton(b);
    }
    //Paints button
    public void paintButton(JButton b){
        c = parseColor(color.getText());
        b.setBackground(c);
        b.update(b.getGraphics());
    }
    //Constructor
    public Frame(){
        super();
        try{UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}catch(Exception exc){System.out.println(exc.getMessage()+"\n"+exc.getCause());}
        setTitle("PAINT");
        setSize(640, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(color, BorderLayout.NORTH);
        g = new Grid(this, 64, 64);
        add(g, "Center");
        random.addActionListener(this);
        add(random, "South");
        setVisible(true);
    }
    //Parse color from the text field
    public Color parseColor(String arg) {
        Color c = new Color(255, 255, 255);
        if(arg.contains(",")){
            String[] args = arg.split(", ");
            c = new Color(Integer.parseInt(args[0]) % 256, Integer.parseInt(args[1]) % 256, Integer.parseInt(args[2]) % 256);
        }
        else if(arg.contains("#")){
            int i = arg.indexOf("#");
            String hex = arg.substring(i + 1);
            c = new Color(Integer.parseInt(hex.substring(0, 1), 16), Integer.parseInt(hex.substring(2, 3), 16), Integer.parseInt(hex.substring(4, 5), 16));
        }
        return c;
    }
}
