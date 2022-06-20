public class IntegerSet {

    public boolean[] inSet;
    public int[] numbers;

    public static IntegerSet intSet = new IntegerSet();

    public IntegerSet()
    {
        inSet = new boolean[101];
        numbers = new int[101];
    }


    public IntegerSet union(IntegerSet iSet)
    {

        IntegerSet newIntegerSet = new IntegerSet();
        newIntegerSet = intSet;
        
        int iterateTo;
        int paramLength = iSet.numbers.length;
        int memberLength = numbers.length;
        if (paramLength > memberLength)
            iterateTo = paramLength;
        else
            iterateTo = memberLength;

        for (int i = 0; i < iterateTo; i++)
        {
            if (iSet.numbers[i] != numbers[i])
            {
                int paramVal = iSet.numbers[i];
                int origVal = numbers[i];

                newIntegerSet.numbers[paramVal] = paramVal;
                newIntegerSet.inSet[paramVal] = true;

                newIntegerSet.numbers[origVal] = origVal;
                newIntegerSet.inSet[origVal] = true;
            }
            else if (iSet.inSet[i] != false)
            {
                newIntegerSet.numbers[i] = iSet.numbers[i];
                newIntegerSet.inSet[i] = true;
            }
        }
        return newIntegerSet;
    }   

    public IntegerSet intersection(IntegerSet iSet)
    {

        IntegerSet newIntegerSet = new IntegerSet();

        int iterateTo;
        int paramLength = iSet.numbers.length;
        int memberLength = numbers.length;
        if (paramLength > memberLength)
            iterateTo = paramLength;
        else
            iterateTo = memberLength;

        for (int i = 0; i < iterateTo; i++)
        {
            if (numbers[i] == iSet.numbers[i] && inSet[i])
            {
                newIntegerSet.numbers[i] = numbers[i];
                newIntegerSet.inSet[i] = true;
            }
        }
        return newIntegerSet;
    }

    public IntegerSet insertElement(int data)
    {
        numbers[data] = data;
        inSet[data] = true;
        return intSet;
    }

    public IntegerSet deleteElement(int data)
    {
        numbers[data] = 0;
        inSet[data] = false;
        return intSet;
    }

    public boolean isEqualTo(IntegerSet iSet)
    {
        for (int i = 0; i < numbers.length; i++)
        {
            for (int j = i; j< numbers.length; j++)
            {
                if (numbers[i] != iSet.numbers[i])
                    return false;
            }
        }
        return true;
    }

    public String toString()
    {
        String contents = "";
        String isEmpty = "---";

        for (int i = 0; i < numbers.length; i++)
        {
            if (inSet[i] == true)
            contents += String.valueOf(numbers[i]) + " ";
        }

        if (contents == "")
            return isEmpty;
        else
            return contents;
    }

}
