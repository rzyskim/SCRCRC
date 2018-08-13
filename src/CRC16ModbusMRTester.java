import java.util.List;
import java.util.Scanner;

public class CRC16ModbusMRTester {
    public static void main(String[] args) {

//        Scanner scan = new Scanner("01 10 00 11 00 03 06 1A C4 BA D0");
        Scanner scan = new Scanner(System.in);

        System.out.println("Proszę wprowadzić kolejne bajty w zapisie hexadecymalnym, oddzielone spacją:");
        String scanInput = scan.nextLine();
        System.out.println("Proszę wyznaczyć liczbę powtórzeń algorytmu:");
        String stringIterations = scan.nextLine();

        scan.close();


        List<Short> bytesInserted = CRC16ModbusMR.parseInput(scanInput);
        int numberOfIterations = Integer.parseInt(stringIterations);

        long millisActualTime = System.currentTimeMillis(); // początkowy czas w milisekundach.
        for (int i = 0; i < numberOfIterations; i++) {
            CRC16ModbusMR.calculateCRC(bytesInserted, 256);
        }
        long executionTime = System.currentTimeMillis() - millisActualTime; // czas wykonania programu w milisekundach.


        System.out.println("Wyliczona suma kontrolna to: " + CRC16ModbusMR.calculateCRC(bytesInserted, 256));
        System.out.println("Czas wykonania dla " + numberOfIterations + " powtórzeń wyniósł: " + executionTime + "[ms]");
    }
}
