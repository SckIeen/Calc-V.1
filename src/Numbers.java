import java.util.Arrays;

public class Numbers {
    final String[] ROMANNUMBERS = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    private String firstNumber;
    private String secondNumber;
    private String operator;
    private boolean isArab;

    public boolean isArab() {
        return isArab;
    }

    public Numbers(String string) {
        String[] numbers = string.split(" ");
        firstNumber = numbers[0];
        secondNumber = numbers[2];
        operator = numbers[1];
    }

    public void handlerStringInNumber(Calculate calculate) {
        try {
            if (existA(firstNumber) && existA(secondNumber)) {
                calculate.setA(findIndexIn(ROMANNUMBERS, firstNumber));
                calculate.setB(findIndexIn(ROMANNUMBERS, secondNumber));
                isArab = false;
            } else if (Integer.parseInt(firstNumber) <= 10 && Integer.parseInt(secondNumber) <= 10) {
                calculate.setA(Integer.parseInt(firstNumber));
                calculate.setB(Integer.parseInt(secondNumber));
                isArab = true;
            }
            else {
                throw new NumberFormatException();
            }
            calculate.setOperator(operator);
        } catch (NumberFormatException e) {
            System.out.println("Можно использовать только римские или только арабские числа и числа не больше 10");
        }
    }


    public String romanNumbersConverter(int arabNumber) {
        int dozens = arabNumber / 10;
        int units = arabNumber % 10;
        StringBuilder builder = new StringBuilder();
        if (arabNumber < 10) {
            return ROMANNUMBERS[arabNumber];
        } else if (arabNumber < 40) {
            builder.append(ROMANNUMBERS[10].repeat(Math.max(0, dozens)));
            builder.append(ROMANNUMBERS[units]);
            return builder.toString();
        }
        else if (arabNumber < 50) {
            builder.append("XL").append(ROMANNUMBERS[units]);
            return builder.toString();
        } else if (arabNumber < 60) {
            builder.append("L").append(ROMANNUMBERS[units]);
            return builder.toString();
        }
        else if (arabNumber < 90) {
            builder.append("LX");
            builder.append(ROMANNUMBERS[10].repeat((arabNumber - 60) / 10));
            builder.append((ROMANNUMBERS[units]));
            return builder.toString();
        } else if (arabNumber < 100) {
            builder.append("XC").append(ROMANNUMBERS[units]);
            return builder.toString();
        }
        return "C";
    }

    private boolean existA(String a) {
        for (String s : ROMANNUMBERS) {
            if (a.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public int findIndexIn(String[] list, String str) {
        int result = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(str)) {
                result = i;
                break;
            }

        }
        return result;
    }

}
