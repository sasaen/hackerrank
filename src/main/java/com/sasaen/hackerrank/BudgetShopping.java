package com.sasaen.hackerrank;

/**
 * Created by santoss on 27/10/2017.
 */
public class BudgetShopping {
    static int budgetShopping(int n, int[] bundleQuantities, int[] bundleCosts) {
        return exploreCombinations(n, 0, 0, bundleQuantities, bundleCosts);
    }

    static int exploreCombinations(int budget, int currentQuantity, int currentCost, int[] bundleQuantities, int[] bundleCosts) {
        int maxQuantity = currentQuantity;
        for (int i = 0; i < bundleQuantities.length; i++) {
            if (currentCost + bundleCosts[i] <= budget) {
                int amount = exploreCombinations(budget, currentQuantity + bundleQuantities[i], currentCost + bundleCosts[i], bundleQuantities, bundleCosts);
                if (maxQuantity < amount) {
                    maxQuantity = amount;
                }
            }
        }
        return maxQuantity;
    }

    public static void main(String[] args) {

        int[] quantities = {20, 19};
        int[] costs = {24, 20};

        int i = budgetShopping(50, quantities, costs);
        System.out.println("Max shopping "+i);
    }
}
