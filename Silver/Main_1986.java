package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main_1986 {
    static int n, m;
    static boolean[][] attacked;
    static boolean[][] occupied;

    static int[] knightDx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] knightDy = {-1, 1, -2, 2, -2, 2, -1, 1};

    static int[] queenDx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] queenDy = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        attacked = new boolean[n][m];
        occupied = new boolean[n][m];

        int[][] queens = readPieces(br);
        int[][] knights = readPieces(br);
        int[][] pawns = readPieces(br);

        markOccupied(queens);
        markOccupied(knights);
        markOccupied(pawns);

        markQueenAttacks(queens);
        markKnightAttacks(knights);

        int safeCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!attacked[i][j] && !occupied[i][j]) {
                    safeCount++;
                }
            }
        }

        System.out.println(safeCount);
    }

    static int[][] readPieces(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int[][] pieces = new int[count][2];
        for (int i = 0; i < count; i++) {
            pieces[i][0] = Integer.parseInt(st.nextToken()) - 1;
            pieces[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }
        return pieces;
    }

    static void markOccupied(int[][] pieces) {
        for (int[] pos : pieces) {
            occupied[pos[0]][pos[1]] = true;
        }
    }

    static void markQueenAttacks(int[][] queens) {
        for (int[] pos : queens) {
            for (int dir = 0; dir < 8; dir++) {
                int x = pos[0];
                int y = pos[1];
                while (true) {
                    x += queenDx[dir];
                    y += queenDy[dir];
                    if (x < 0 || x >= n || y < 0 || y >= m) break;
                    if (occupied[x][y]) break;
                    attacked[x][y] = true;
                }
            }
        }
    }

    static void markKnightAttacks(int[][] knights) {
        for (int[] pos : knights) {
            for (int i = 0; i < 8; i++) {
                int x = pos[0] + knightDx[i];
                int y = pos[1] + knightDy[i];
                if (x >= 0 && x < n && y >= 0 && y < m && !occupied[x][y]) {
                    attacked[x][y] = true;
                }
            }
        }
    }
}
