import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculate {
   private int a;
   private int b;
   private String operator;



    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int subtraction(int a, int b) {
        return a - b;
    }

    public int division(int a, int b) {
        return a / b;
    }

    public int multiplication(int a, int b) {
        return  a * b;
    }


    public static void main(String[] args)  {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int result;
        try {
            Calculate calculate = new Calculate();
            Numbers numbers = new Numbers(reader.readLine());
            numbers.handlerStringInNumber(calculate);
            switch (calculate.getOperator()) {
                case ("+") -> result = calculate.add(calculate.getA(), calculate.getB());
                case ("-") -> result = calculate.subtraction(calculate.getA(), calculate.getB());
                case ("/") -> result = calculate.division(calculate.getA(), calculate.getB());
                case ("*") -> result = calculate.multiplication(calculate.getA(), calculate.getB());
                default -> throw new IllegalStateException("Неверные данные " + calculate.getOperator());
            }
            if(numbers.isArab()) {
                System.out.println(result);
            }
            else {
                System.out.println(numbers.romanNumbersConverter(result));
            }

        } catch (NullPointerException | IOException e) {
            System.out.println("Программа будет закрыта");
        }

    }
}
