class CloneTest implements Cloneable{
    private int num1;
    private int num2;

    public CloneTest(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public String toString() {
        return "CloneTest{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                '}';
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
public class CloneDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        CloneTest cloneTest = new CloneTest(10,20);
        System.out.println(cloneTest);

        CloneTest cloneTest1 = (CloneTest) cloneTest.clone();
        cloneTest1.setNum1(15);
        cloneTest1.setNum2(25);
        System.out.println(cloneTest1);
    }
}
