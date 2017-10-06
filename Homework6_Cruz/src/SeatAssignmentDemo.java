import java.util.Scanner;

public class SeatAssignmentDemo {
    public static void main(String[] args){
        SeatAssignment seats = new SeatAssignment();
        seats.printSeats();

        boolean q = false;
        while (!q){
            System.out.println("Enter a row: (Q to quit)");
            Scanner in = new Scanner(System.in);
            String row = in.nextLine();
            if (row.equalsIgnoreCase("q")){
                System.out.println("Thank you for using our system.");
                q = true;
            }
            else{
                System.out.println("Enter a column number");
                in = new Scanner(System.in);
                String col = in.nextLine().toUpperCase();
                char[] column = col.toCharArray();
                if (column[0] == 'A'){
                    int rowNum = Integer.parseInt(row);
                    seats.setSeats(rowNum-1, 0); //0 for seat A
                }
                else if (column[0] == 'B'){
                    int rowNum = Integer.parseInt(row);
                    seats.setSeats(rowNum-1, 1); //0 for seat B
                }
                else if (column[0] == 'C'){
                    int rowNum = Integer.parseInt(row);
                    seats.setSeats(rowNum-1, 3); //0 for seat C
                }
                else if (column[0] == 'D'){
                    int rowNum = Integer.parseInt(row);
                    seats.setSeats(rowNum-1, 4); //0 for seat D
                }
                else{
                    System.out.println("Invalid seat.");
                }

            }
            seats.printSeats();
        }
    }
}
