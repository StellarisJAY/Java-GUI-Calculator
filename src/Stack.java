public class Stack {
    private char[] stack = new char[10000];
    private int topStack = -1;

    public boolean isEmpty()
    {
        return topStack == -1;
    }

    public void Pop()
    {
        topStack --;
    }

    public void Push(char element)
    {
        stack[++topStack] = element;
    }

    public char Top()
    {
        if(isEmpty())
        {
            System.out.println("Fatal error: stack is empty");
            return ' ';
        }
        return stack[topStack];
    }
}
