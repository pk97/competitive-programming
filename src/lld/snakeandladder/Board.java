package lld.snakeandladder;

public class Board {
    private Box[][] positions;

     Board() {
         positions = new Box[10][10];
         for (int i = 0; i < 10; i++) {
             for (int j = 0; j < 10; j++) {
                 positions[i][j] = new Box(i*10+j+1);
             }

         }
    }
}
