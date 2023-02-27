public class MockExample {
    Example example;

    public MockExample(Example example) {
        this.example = example;
    }

    public int mockTest(int num1, int num2) {
        return example.add(num1, num2) * num1;
    }
}
