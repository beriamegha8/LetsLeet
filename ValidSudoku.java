class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];
        
        //implementing using hashsets to ensure unique values
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<Character>();
            cols[i] = new HashSet<Character>();
            boxes[i] = new HashSet<Character>();
        }
        
        // Traversing the board
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char num = board[r][c];
                
                if (num == '.') {
                    continue;
                }
                
                //box index
                int boxIndex = (r / 3) * 3 + c / 3;
                
                if (rows[r].contains(num) || cols[c].contains(num) || boxes[boxIndex].contains(num)) {
                    return false;
                }
                
                rows[r].add(num);
                cols[c].add(num);
                boxes[boxIndex].add(num);
            }
        }
        
        return true;
    }
}
