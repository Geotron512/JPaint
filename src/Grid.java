import javax.swing.*;
import java.awt.*;

public class Grid extends JPanel {
    //Variables
    public JButton[][] cells;
    private final Frame frame;
    //Constructors
    public Grid(Frame f, int rows, int columns){
        super();
        setLayout(new GridLayout(rows, columns));
        frame = f;
        cells = new JButton[rows][columns];
        for(int i = 0; i < cells.length; i++){
            for(int j = 0; j < cells[i].length; j++){
                cells[i][j] = new JButton();
                cells[i][j].addActionListener(frame);
                cells[i][j].setBorderPainted(false);
                add(cells[i][j]);
            }
        }
    }
}
