package com.company;

import java.util.Comparator;

/**
 * Created by Paul on 2/15/2017.
 */
public class BA_comparator implements Comparator
{
    public int compare(Object firstObject, Object secondObject)
    {
        Double ba1 = (Double)firstObject;
         Double ba2 = (Double)secondObject;
        int retValue;
        if (ba1<ba2)
        {
            retValue = -1;
        }
        else

        {
            if (ba1>ba2)
            {
                retValue = 1;
            }
            else
            {
                retValue=0;
            }
        }
        return retValue;
    }
}
