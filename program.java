import java.io.Reader;
import java.util.Scanner;

public class program {
    public static void main(String[] args) {

        Numbers(1, 1000);

        AmountTriangleNumbers(3);

        System.out.println(MultiplyTriangleNumbers(6));

        Calculator calc = new Calculator();
        calc.Calc();


    }

    /* Numbers - Выводим все простые числа от start до stop включительно */
    static void Numbers(int start, int stop) {
        int a = start;
        int z = stop;
        while (a <= z) {
            System.out.println(a);
            a++;
        }
    }

    /* AmountTriangleNumbers - сумма чисел от 1 до n */
    static void AmountTriangleNumbers(int n) {
        int start = 1;
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += start;
            start++;
        }
        System.out.println("Сумма числел от 1 до " + n + " = " + result);
    }

    /* MultiplyTriangleNumbers - произведение чисел от 1 до n */
    static int MultiplyTriangleNumbers(int n) {
        if (n==1) return n;
        return n * MultiplyTriangleNumbers(n - 1);
    }

}
class Calculator{
    String _HELP = "Что бы закрыть калькулятор введите в консоль 'Q' или 'q'";
    String _ERRORINPUT = "Ошибка ввода";
    String _ERRORNULL = "Деление на 0";
    Scanner _input = new Scanner(System.in);
    Double _firstnumber;
    Double _secondnumber;
    Double _result;
    boolean _working = true;

    public void Calc(){

        System.out.println("Калькулятор запущен");
        System.out.println(_HELP);
        _result = InputNumber();

        while (_working){

            _firstnumber = _result;

            switch (OperatorChoice()) {
                case 1:
                    _secondnumber = InputNumber();
                    _result = _firstnumber + _secondnumber;
                    break;
                case 2:
                    _secondnumber = InputNumber();
                    _result = _firstnumber - _secondnumber;
                    break;
                case 3:
                    _secondnumber = InputNumber();
                    _result = _firstnumber * _secondnumber;
                    break;
                case 4:
                    _secondnumber = InputNumber();
                    if (_secondnumber == 0) {
                        System.out.println(_ERRORNULL);
                        break;
                    }
                    _result = _firstnumber / _secondnumber;
                    break;
                case 5:
                    _secondnumber = InputNumber();
                    _result = Math.pow(_firstnumber, _secondnumber);
                    break;
            }

            if(!_working) continue;

            System.out.println("Результат: " + _result);
        }
        System.out.println("Калькулятор закрыт");
    }
    double InputNumber(){

        while (_working) {
            System.out.println("Ввод числа: ");
            var flag = _input.hasNextDouble();
            if (!flag) {
                _working = isExit(_input.next().charAt(0));
                if(_working) System.out.println(_ERRORINPUT);
                continue;
            }
            return _input.nextDouble();
        }
        return 0;
    }

    boolean isExit(char exit){

        switch (exit) {
            case 'q':
            case 'Q':
                return false;
            default:
                return true;
        }

    }

    int OperatorChoice(){

        char oper;

        while (_working) {

            System.out.println("Введите оператор: ");

            if(_input.hasNext()){
                oper = _input.next().charAt(0);
                switch (oper) {
                    case '+':
                        return 1;
                    case '-':
                        return 2;
                    case '*':
                        return 3;
                    case '/':
                        return 4;
                    case '^':
                        return 5;
                    default:
                        _working = isExit(oper);
                        continue;
                }
            } else {
                System.out.println(_ERRORINPUT);
            }
        }
        return 0;
    }

}