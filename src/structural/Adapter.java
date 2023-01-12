package structural;

public class Adapter {
    public void boardService(Board board) {
        System.out.println(board.write());
        System.out.println(board.update());
    }

    public static void main(String args[]) {
        Board_v01 board = new Board_v01();
        Adapter adapter = new Adapter();
        adapter.boardService(board);

        Board newBoard = new BoardAdapter(new Board_v02());
        adapter.boardService(newBoard);
    }
}

class Board_v01 implements Board {
    public String write() {
        return "iam v01. write.";
    }
    public String update() {
        return "iam v01. update.";
    }
}

class Board_v02 {
    public String insert() {
        return "iam v02. write.";
    }
    public String modify() {
        return "iam v02. update.";
    }
}

interface Board {
    public String write();
    public String update();
}

class BoardAdapter implements Board  {

    private final Board_v02 board_v02;

    BoardAdapter(Board_v02 board_v02) {
        this.board_v02 = board_v02;
    }

    @Override
    public String write() {
        return board_v02.insert();
    }

    @Override
    public String update() {
        return board_v02.modify();
    }
}