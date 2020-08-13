#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_native_1library_NativeMethods_stringFromJNI(
        JNIEnv* env,
        jclass /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jint JNICALL
        Java_com_example_native_1library_NativeMethods_crashFromJNI(
        JNIEnv* env,
        jclass /* this */) {

    int* foo = (int*)-1;
    printf("%d\n", *foo);
    return *foo;
}
