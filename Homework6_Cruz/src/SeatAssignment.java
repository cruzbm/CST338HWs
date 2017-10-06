

public class SeatAssignment {

    private int[] row = new int[7];
    private char[][] seats = new char[7][5];

    public SeatAssignment(){
        for (int i = 0; i < 7; i++) {
            row[i] = i + 1;
            seats[i][0] = 'A';
            seats[i][1] = 'B';
            seats[i][2] = ' ';
            seats[i][3] = 'C';
            seats[i][4] = 'D';
        }
    }

    public void setSeats(int row, int column) {
        if (seats[row][column] != 'X') {
            seats[row][column] = 'X';
        }
        else{
            System.out.println("Seat is already assigned.");
        }
    }

    public void printSeats(){
        for (int i = 0; i < 7; i++){
            System.out.print(row[i] + " ");
            for (int j = 0; j < 5; j++){
                System.out.print(seats[i][j]);
            }
            System.out.println();
        }
    }

}