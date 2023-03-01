class ScientificCalculator extends Calculator {
    int power(int num, int power) {
        int result = num;
        for (int times = 0; times < (power - 1); times++) {
            result *= num;
        }
        return result;
    }

    double power(double num, int power) {
        double result = num;
        for (int times = 0; times < (power - 1); times++) {
            result *= num;
        }
        return result;
    }
}
