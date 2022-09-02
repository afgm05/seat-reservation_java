import java.util.Scanner;

public class SeatReservation {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int row = 5;
        int col = 7;
        String [][] seats = new String[row][col]; 
        int number = 1;
        String chosenSeat;
        int chosenSeatInt;
        boolean run = true;
                
        // assign seat numbers to the array
        for (int i=0; i < row; i++) {           
            for (int j=0; j < col; j++) {
                seats[i][j] = Integer.toString(number);
                number++;
            }     
        }   
        
        while (run) {
            boolean looping = false;
            
            //print seat numbers
            for (int i=0; i < row; i++) {
                for (int j=0; j < col; j++) {
                    System.out.print(seats[i][j] + "\t");
                }
                System.out.println();
            }

            System.out.print("\nChoose a seat number --> ");
            chosenSeat = sc.next();
            chosenSeatInt = Integer.parseInt(chosenSeat);
            System.out.println();

            if (chosenSeatInt < 1 || chosenSeatInt > (row*col)) {
                System.out.println("Invalid seat number\n");
            } else {
                boolean found = false;
                for (int i=0; i < row; i++) {
                    for (int j=0; j < col; j++) {
                        if (seats[i][j].equals(chosenSeat)){
                            seats[i][j] = "X";
                            System.out.println("Seat successfully reserved\n");
                            found = true;
                        }    
                    }
                }
                if (found == false) {
                    System.out.println("Seat is taken\n");
                }
            }
            
            //check if there's a remaining seat
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (seats[i][j] != "X") {
                        looping = true;
                        break;
                    }
                }
            }
            
            if (looping == false) {
                System.out.println("All seats are taken! \nProgram will exit.");
                run = false;
            }
            
            //create delay on the next loop
            try {
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        } 
              
    }
   
}
