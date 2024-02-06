class MyNumber {
    int value;

    public MyNumber(int value) {
        this.value = value;
    }
}

public class __call_by_reference__ {
    public static void main(String[] args) {
        MyNumber number = new MyNumber(10);
        System.out.println("Original Value: " + number.value);

        modifyNumber(number);

        System.out.println("Value After Modification: " + number.value);
    }

    public static void modifyNumber(MyNumber num) {
        num.value = 20;
        System.out.println("Value Inside the Method: " + num.value);
    }
}
