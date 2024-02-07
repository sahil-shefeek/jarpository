public class CmdLineArgs {
    public static void main(String[] args) {
        try {
            int sum = Integer.parseInt(args[0]) + Integer.parseInt(args[1]);
            System.out.println(("Sum of args is: " + sum));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("FATAL: Too few arguments!\nAborting...");
        } catch (NumberFormatException e) {
            System.out.println("FATAL: Invalid arguments!\nPlease provide valid integers as input");
        }
    }
}
