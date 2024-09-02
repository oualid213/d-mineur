import java.util.Scanner;

public class Input {

    public  int readInt(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int input;
        while (true) {
            System.out.print("Please enter a number between " + min + " and " + max + ": ");
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.println("Error: The number must be between " + min + " and " + max + ".");
                }
            } else {
                System.out.println("Error: Please enter a valid integer.");
                scanner.next();
            }
        }
    }

    public String readCoordinate(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please entre the coordinate of the cell. exemple (A1)");
        while(true) {
            String input = scanner.nextLine().toUpperCase().trim();
            if (isValideString(input)) {
                return input;
            }
            System.out.println("Please entre correct coordinate");
        }
    }
    public Coordinate IntegerCoordinate(String stringCoordinate){
        return new Coordinate(rowConversion(stringCoordinate),colConversion(stringCoordinate));
    }

    private boolean isValideString(String input) {

        boolean isValide = true;

        if(input.length() != 2 ){
            isValide = false;
        }else {
            isValide = coordinateVerification(input);
        }
        return isValide;
    }
    private boolean coordinateVerification(String input){
        boolean isValide = true;
        char firstCoordinate = input.charAt(0);
        char secondCoordinate = input.charAt(1);

        if (!firstCoordinateIsValide(firstCoordinate) || !secondCoordinateIsValide(secondCoordinate)) {
            isValide = false;
        }
        return isValide;
    }

    private boolean secondCoordinateIsValide(char secondCoordinate) {
        if(secondCoordinate >= '1' && secondCoordinate <= '9' || secondCoordinate >='A' && secondCoordinate <='c'){
            return true;
        }else{
            return false;
        }
    }


    private boolean firstCoordinateIsValide(char firstCoordinate) {
        return firstCoordinateIsCar(firstCoordinate);
    }

    private boolean firstCoordinateIsCar(char firstCoordinate) {
        if(firstCoordinate >= 'A' && firstCoordinate <= 'L'){
            return true;
        }else{
            return false;
        }
    }

    private int rowConversion(String input){
        return lettreConversion(input.charAt(0),'L');
    }
    private int colConversion(String input){
        int number = 0;
        if (input.charAt(1)>='1'&& input.charAt(1) <='9'){
            number = Integer.parseInt(input.charAt(1)+"") - 1;
        }else{
            number = lettreConversion(input.charAt(1),'C') + 9;
        }
        return number;
    }

    private static int lettreConversion(char charCoordinate, char max){
        char firstChar ='A';
        int number = 0;
        int i = 0 ;
        while(firstChar <= max){
            if (charCoordinate == firstChar){
                number = i;
            }
            firstChar++;
            i++;
        }
        return number;

    }



}
