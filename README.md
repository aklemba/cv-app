# cv-app

### Summary

This app is written 100% in Kotlin

It uses the following Architecture Components:
 - ViewModel
 - LiveData
 - Data Binding
 - Navigation

It uses [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
for dependency injection.

HTTP request are performed by Retrofit2 library and image downloading is performed by Glide library

Asynchronous calls are handled by RxJava3 library.

This project applies MVVM with Clean Architecture approach using UseCases and Repository pattern

### Testing

Didn't manage to make it on time to test whole application.
"Summary" feature is unit tested OK. Other feature have missing tests.

UI tests not applied since Hilt rejects any tries for making it work [SummaryFragmentTest]
Testing fragments that use Hilt is not yet supported, but
there is a workaround provided in Google's Architecture Blueprints[https://developer.android.com/training/dependency-injection/hilt-testing#launchfragment]
Unfortunately the workaround doesn't work for me. No time to go back using Dagger2.

### Missing in the app
 - There should be a screen with all third party libraries used.
 - proguard configuration might have some rules missing.
 - Firebase support must be added before release for crash reports and statistics