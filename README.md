# Firebase NDK Test

This simple Android project includes a *native* Android Library project. The project includes the Firebase Crashlytics library and has buttons for forcing both managed and native crashes.

## Building the project

You'll need your own Firebase project setup and a downloaded `google-services.json` file to place in the `app` folder.

Run the following commands:

`./gradlew app:assembleRelease`

`./gradlew app:uploadCrashlyticsSymbolFileRelease`

Note in both cases, you'll see the following message:

```
Crashlytics could not find NDK build tasks on which to depend. You many need to manually enforce task dependencies for generateCrashlyticsSymbolFileRelease
```

## Testing Crashlytics

Run the app on a device and press the **Managed Crash** button — that should cause a crash in the Java code. Run the app again and press the **Native Crash** button — that should cause a crash in the native (C++) code. Run the app a third time so that Crashlytics can report the errors.

Once the two errors show up in the Firebase Crashlytics portal, you'll see that the managed (Java) crash properly reports the crash:

```
com.example.firebasendktest.MainActivity$1.onClick (MainActivity.java:28)
```

For the native crash though, the calling Java function is referred to but not the underlying C++ code that actually causes the exception:

```
com.example.native_library.NativeMethods.crashFromJNI (NativeMethods.java)
```

We would instead expect to see line 18 of `native-lib.cpp` referred to, since it's the location of the actual exception.
