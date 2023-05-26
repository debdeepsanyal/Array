public class WordSearch {
    private int ROWS;
    private int COLS;
    private char[][] board;
    private String word;

    public boolean exist(char[][] board, String word) {
        this.ROWS = board.length;
        this.COLS = board[0].length;
        this.board = board;
        this.word = word;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (dfs(r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int r, int c, int index) {
        if (index == word.length()) {
            return true;
        }

        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || board[r][c] != word.charAt(index)) {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '#';  // Mark the cell as visited

        boolean found = dfs(r + 1, c, index + 1)
                || dfs(r - 1, c, index + 1)
                || dfs(r, c + 1, index + 1)
                || dfs(r, c - 1, index + 1);

        board[r][c] = temp;  // Restore the original value

        return found;
    }

    public static void main(String[] args) {
        WordSearch solution = new WordSearch();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "SEE";
        boolean exists = solution.exist(board, word);
        System.out.println("Word exists: " + exists);
    }
}
