package com.example.native_library;

public class NativeMethods {
    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native static String stringFromJNI();
    public native static int crashFromJNI();
}
