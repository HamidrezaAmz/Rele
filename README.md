
[![API](https://img.shields.io/badge/API-16%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=16)
[![](https://jitpack.io/v/HamidrezaAmz/Rele.svg)](https://jitpack.io/#HamidrezaAmz/Rele)

# Rele
![error](https://user-images.githubusercontent.com/13493645/48548518-633d1300-e8e2-11e8-887c-b7079fe24f34.PNG)
![empty](https://user-images.githubusercontent.com/13493645/48548524-6a642100-e8e2-11e8-924c-988958bd51a1.PNG)
![loading](https://user-images.githubusercontent.com/13493645/48548510-5b7d6e80-e8e2-11e8-930c-e52cefa8408b.PNG)

This is a custom view include: **Recycler-View**, **Empty-View**, **Loading-View**, **Error-View**.

It can handle multiple UI states that we have on setting data into recycler-view in android. 
You just need to set state on this custom view. 


## Getting Started

These instructions will help you to use this library inside your projects

### Prerequisites

This library was built with **androidX**, so you should migrate into androidX to use this library with out any problem. For migration you can use [Migrating to AndroidX](https://developer.android.com/jetpack/androidx/migrate)

### Installing

Step 1. Add the JitPack repository to your build file,
Add it in your root build.gradle at the end of repositories:

```gradle
allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }
```

Step 2. Add the dependency

```gradle
dependencies {
    implementation 'com.github.HamidrezaAmz:Rele:v1.0.6'
}
```

### Here we go for implementation

Add xml of custom view into your parent view
```xml
<com.vasl.recyclerlibrary.MyCustomView
        android:id="@+id/myCustomView"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
```

Refrence to custom-view inside your activity or fragment (I use [butterknife](https://github.com/JakeWharton/butterknife/))
```java
 @BindView(R.id.myCustomView)
 MyCustomView myCustomView;
```

For getting recycler-view
```java
RecyclerView recyclerView = myCustomView.getRecyclerView();
```

For setting status
```java
myCustomView.setStatus(ListStatuse.LOADING);
```

List of statuses
- ListStatuse.LOADING
- ListStatuse.FAILURE
- ListStatuse.EMPTY
- ListStatuse.SUCCESS


## Other Libraries

* [Mkloader](https://github.com/nntuyen/mkloader) - The loading view library


## Author

* **Hamidreza amoozadeh** - *Android DEV* - [github](https://github.com/HamidrezaAmz)


## Supported Languages
* English, Persian
