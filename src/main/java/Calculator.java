public class Calculator {
    public double CalculateTotalCost(int n, double[] prices, int[] quantities) {
        double totalCost = 0;
        for (int i = 0; i < n; i++) {
            totalCost += prices[i] * quantities[i];
        }
        return totalCost;
    }
}
