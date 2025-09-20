package HW1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;

public class RandomWalk {
    public static void main(String[] args) {
        int n = Integer.parseInt("10");
        StdDraw.setScale(-n - 0.5, n + 0.5);
        StdDraw.clear(StdDraw.GRAY);
        StdDraw.enableDoubleBuffering();

        int x = 0, y = 0;
        int steps = 0;
        int dir = 0;
        int lim = 1;
        int cur = 0;
        while (lim < n*n) {
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(x, y, 0.45);
            switch (dir) {
                case 0:
                    y -= 1;
                    cur += 1;
                    break;
                case 1:
                    x -= 1;
                    cur += 1;
                    break;
                case 2:
                    y += 1;
                    cur += 1;
                    break;
                case 3:
                    x += 1;
                    cur += 1;
                    break;
            }
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.filledSquare(x, y, 0.45);
            StdDraw.show();
            StdDraw.pause(40);
            if(cur == lim) {
               steps += 1;
               if(steps % 2 == 0) {
                   lim += 1;
               }
               cur = 0;
               dir = (dir + 1) % 4;
            }
        }
        StdOut.println("Total steps = " + steps);
    }
}
