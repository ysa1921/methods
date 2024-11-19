import java.util.Scanner;

public class CalculatorApp {


    public static double PowerMethod(double baseNum, int exp) {
        double result = 1;
        for (int i = 0; i < exp; i++) {
            result *= baseNum;
        }
        return result;
    }

 
    public static int ComputeSum(int[] values) {
        int total = 0;
        for (int val : values) {
            total += val;
        }
        return total;
    }


    public static int FindMax(int[] values) {
        if (values.length == 0) return Integer.MIN_VALUE;
        int maximum = values[0];
        for (int val : values) {
            if (val > maximum) {
                maximum = val;
            }
        }
        return maximum;
    }

    public static int FindMin(int[] values) {
        if (values.length == 0) return Integer.MAX_VALUE;
        int minimum = values[0];
        for (int val : values) {
            if (val < minimum) {
                minimum = val;
            }
        }
        return minimum;
    }

  
    public static double ComputeAve(int[] values) {
        if (values.length == 0) return 0;
        int sum = ComputeSum(values);
        return (double) sum / values.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Choose an operation:");
            System.out.println("1. PowerMethod (base^exponent)");
            System.out.println("2. ComputeSum (sum of array)");
            System.out.println("3. FindMax (maximum of array)");
            System.out.println("4. FindMin (minimum of array)");
            System.out.println("5. ComputeAve (average of array)");
            System.out.print("Enter your choice (or type 'exit' to quit): ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("exit")) {
                break;
            }

            switch (choice) {
                case "1":
                    System.out.print("Enter the base: ");
                    double baseNum = scanner.nextDouble();
                    System.out.print("Enter the exponent: ");
                    int exp = scanner.nextInt();
                    scanner.nextLine();  // Consume newline left-over
                    double powerResult = PowerMethod(baseNum, exp);
                    System.out.println("Result: " + powerResult);
                    break;

                case "2":
                case "3":
                case "4":
                case "5":
                    System.out.print("Enter numbers separated by spaces: ");
                    String[] input = scanner.nextLine().split(" ");
                    if (input.length == 0 || (input.length == 1 && input[0].isEmpty())) {
                        System.out.println("No numbers entered.");
                        break;
                    }

                    int[] values = new int[input.length];
                    for (int i = 0; i < input.length; i++) {
                        values[i] = Integer.parseInt(input[i]);
                    }

                    if (choice.equals("2")) {
                        int sumResult = ComputeSum(values);
                        System.out.println("Sum: " + sumResult);
                    } else if (choice.equals("3")) {
                        int maxResult = FindMax(values);
                        System.out.println("Maximum: " + maxResult);
                    } else if (choice.equals("4")) {
                        int minResult = FindMin(values);
                        System.out.println("Minimum: " + minResult);
                    } else {
                        double aveResult = ComputeAve(values);
                        System.out.println("Average: " + aveResult);
                    }
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }

          
            System.out.print("Would you like to compute again? (yes/no): ");
            String again = scanner.nextLine();
            if (!again.equalsIgnoreCase("yes")) {
                break;
            }
        } while (true);

        System.out.println("Program exited.");
        scanner.close();
    }
}
