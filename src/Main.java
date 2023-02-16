import java.util.Random;

/**
 * @version 0.1
 */
public class Main {
    public static void main(String[] args){
        new Frame();
    }
    public static void randPaint(Frame f, int loop, int delay){
        Random rng = new Random();
        int r, c;
        for(int i = 0; i < loop; i++){
            f.color.setText(rng.nextInt(256)+", "+rng.nextInt(256)+", "+rng.nextInt(256));
            r = rng.nextInt(f.g.cells.length);
            c = rng.nextInt(f.g.cells[0].length);
            f.paintButton(f.g.cells[r][c]);
            try{Thread.sleep(delay);}catch(InterruptedException exc){System.out.println(exc.getMessage()+"\n"+exc.getCause());}
        }
    }
}
