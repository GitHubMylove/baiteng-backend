package com.baiteng.base;

/**
 **  @Author: John007
 **  @Company:
 **  @Date: 2019/8/18 11:50
 **  @Description:
 **/
public final class Assert
{
    public static final void notNull(Object object, String errorCode, String errorMessage)
    {
        if (object == null)
            throw new CoreException(errorCode, errorMessage);
    }

    public static final void notNull(Object object, String errorCode, Object[] args)
    {
        if (object == null)
            throw new CoreException(errorCode, args);
    }

    public static final void notNull(Object object, String errorCode)
    {
        notNull(object, errorCode, (String)null);
    }

    public static void isTrue(boolean expression, String errorCode)
    {
        if (!expression)
            throw new CoreException(errorCode);
    }

    public static void isTrue(boolean expression, String errorCode, String errorMessage)
    {
        if (!expression)
            throw new CoreException(errorCode, errorMessage);
    }

    public static void isTrue(boolean expression, String errorCode, Object[] args)
    {
        if (!expression)
            throw new CoreException(errorCode, args);
    }
}