// ICalcAIDL.aidl
package com.example.administrator.myaidl;

// Declare any non-default types here with import statements

interface ICalcAIDL {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
           int add(int a , int b);
            int min(int a,int b);
}
