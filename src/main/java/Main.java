import java.util.*;

public class Main {
    public static void main(String[] args) {
        ResourceBundle rb;
        Locale locale;
        System.out.println("Enter the language you want to use: ");
        System.out.println("1. English");
        System.out.println("2. Finnish");
        System.out.println("3. Swedish");
        Scanner sc = new Scanner(System.in);
        String language = sc.nextLine();

        switch (language) {
            case "1":
                locale = new Locale("en", "US");
                break;
            case "2":
                locale = new Locale("fi", "FI");
                break;
            case "3":
                locale = new Locale("sv", "SE");
                break;
            default:
                locale = new Locale("en", "US");
                break;
        }


        try {
            rb = ResourceBundle.getBundle("messages", locale);
        } catch (Exception e) {
            System.out.println("Invalid language. Using English as default.");
            rb = ResourceBundle.getBundle("messages", new Locale("en", "US"));
        }

        Calculator calc = new Calculator();
        List<Double> prices = new ArrayList<>();
        List<Integer> quantities = new ArrayList<>();

        System.out.println(rb.getString("items"));
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(rb.getString("price"));
            double price = sc.nextDouble();
            System.out.println(rb.getString("quantity"));
            int quantity = sc.nextInt();
            prices.add(price);
            quantities.add(quantity);
        }

        double[] pricesArray = prices.stream().mapToDouble(Double::doubleValue).toArray();
        int[] quantitiesArray = quantities.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(rb.getString("total") + calc.CalculateTotalCost(n, pricesArray, quantitiesArray));
    }
}
