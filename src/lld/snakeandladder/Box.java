package lld.snakeandladder;

public class Box {
    private int number;
    private Character character;

    Box(int number, Character character) {
        this.number = number;
        this.character = character;
    }

    Box(int number) {
        this.number = number;
        character = null;
    }
}
