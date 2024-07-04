package lld.snakeandladder;

public interface Character {
    Box execute();
}


class Snake implements Character {
    private Box head, tail;
    Snake(Box head,Box  tail) {
        this.head = head;
        this.tail = tail;
    }
    @Override
    public Box execute() {
        return tail;
    }
}


class Ladder implements Character {
    private final Box head;
    private Box tail;
    Ladder(Box head,Box  tail) {
        this.head = head;
        this.tail = tail;
    }
    @Override
    public Box execute() {
        return head;
    }
}

class NoOpertaion implements Character {
    private final Box position;

    NoOpertaion(Box position) {
        this.position = position;
    }

    @Override
    public Box execute() {
        return position;
    }
}