import java.util.AbstractMap;

public class CharGrid {
    private char[][] arr;

    CharGrid(char[][] arr) {
        this.arr = arr;
    }

    public int charArea(char ch) {
        int area = 0;
        Pair<Integer, Integer> topLeft = new Pair<Integer, Integer>(arr.length - 1, arr[0].length - 1);
        Pair<Integer, Integer> bottomRight= new Pair<Integer, Integer>(0, 0);
        for(int i = 0; i < arr.length; ++i) {
            for(int j = 0; j < arr[0].length; ++j) {
                if(arr[i][j] == ch) {
                    topLeft.setKey(Math.min(topLeft.getKey(), i));
                    topLeft.setValue(Math.min(topLeft.getValue(), j));
                    bottomRight.setKey(Math.max(bottomRight.getKey(), i));
                    bottomRight.setValue(Math.max(bottomRight.getValue(), j));
                }
            }
        }
        area = (bottomRight.getKey() - topLeft.getKey() + 1) * (bottomRight.getValue() - topLeft.getValue() + 1);
        return area;
    }

    private boolean isValidPlus(int row, int col, char c) {
        int horizontal = 0, vertical = 0;
        boolean isMoreThan2Hori = false, isMoreThan2Verti = false;
        for(int i = col; i >= 0 && (c == arr[row][i] || c == ' '); --i) {
            if(c == arr[row][i]) {
                horizontal += 1;
                if(horizontal >= 2) {
                    isMoreThan2Hori = true;
                }
            }
        }
        for(int i = col; i < arr[0].length && (c == arr[row][i] || c == ' '); ++i) {
            if(c == arr[row][i]) {
                horizontal -= 1;
            }
        }
        for(int i = row; i >= 0 && c == arr[i][col]; --i) {
            if(c == arr[i][col]) {
                vertical += 1;
                if(vertical >= 2) {
                    isMoreThan2Verti = true;
                }
            }
        }
        for(int i = row; i < arr.length && (c == arr[i][col] || c == ' '); ++i) {
            if(c == arr[i][col]) {
                vertical -= 1;
            }
        }
        return horizontal == 0 && vertical == 0 && isMoreThan2Verti == true && isMoreThan2Hori == true;
    }

    public int countPlus() {
        int ans = 0;
        for(int i = 0; i < arr.length; ++i) {
            for(int j = 0; j < arr[i].length; ++j) {
                ans = (isValidPlus(i, j, arr[i][j]) == true) ? ans + 1 : ans;
            }
        }
        return ans;
    }
}
