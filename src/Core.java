
public class Core {
    private static Stack StringToStack(String input)
    {
        Stack s = new Stack();

        for(int i = 0; i < input.length(); i++)
        {
            s.Push(input.charAt(i));
        }
        return s;
    }

    private static String StringToPostfix(String input)          // 将输入字符转化成后缀表达式形式
    {
        // To finished
    }
    private static boolean isFormatValid(String input)
    {
        for(int i = 0; i < input.length(); i++)
        {
            char ch1 = input.charAt(i);
            if(ch1 == '+' || ch1 == '-' || ch1 == 'x' || ch1 == '/')
            {
                if(i == 0 || i == input.length() - 1) return false;
                char num1 = input.charAt(i - 1);
                char num2 = input.charAt(i + 1);
                if(ch1 == '/' && num2 == '0')return false;
                if(num1 == '+' || num1 == '-' || num1 == 'x' || num1 == '/') return false;
                if(num2 == '+' || num2 == '-' || num2 == 'x' || num2 == '/') return false;
            }
            else if(ch1 == '0')
            {
                if(i == input.length() - 1)
                    break;
                char num = input.charAt(i + 1);
                if((num != '+' && num != '-' && num != 'x' && num != '/' && num != '0')) return false;
            }
        }
        return true;
    }

    public static String getResult(String postfix)                // 用后缀表达式计算结果
    {
        if(!isFormatValid(input))
            return "Invalid input format, please check your input...";


        return Integer.toString(result);
    }
}
