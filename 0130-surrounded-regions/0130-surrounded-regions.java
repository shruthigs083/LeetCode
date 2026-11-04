class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        // Traverse left and right boundaries
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0, board, row, col);
            }

            if (board[i][col - 1] == 'O') {
                dfs(i, col - 1, board, row, col);
            }
        }

        // Traverse top and bottom boundaries
        for (int j = 0; j < col; j++) {
            if (board[0][j] == 'O') {
                dfs(0, j, board, row, col);
            }

            if (board[row - 1][j] == 'O') {
                dfs(row - 1, j, board, row, col);
            }
        }

        // Capture surrounded regions and restore safe cells
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int r, int c, char[][] board, int row, int col) {
        // Mark this O as safe
        board[r][c] = '#';

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < row &&
                nc >= 0 && nc < col &&
                board[nr][nc] == 'O') {
                dfs(nr, nc, board, row, col);
            }
        }
    }
}