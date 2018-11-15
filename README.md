
[![API](https://img.shields.io/badge/API-16%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=16)
[![](https://jitpack.io/v/HamidrezaAmz/Rele.svg)](https://jitpack.io/#HamidrezaAmz/Rele)

# Rele

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

```
allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }
```

Step 2. Add the dependency

```
dependencies {
    implementation 'com.github.HamidrezaAmz:Rele:v1.0.6'
}
```

### Here we go for implementation

Add xml of custom view into your parent view
```
<com.vasl.recyclerlibrary.MyCustomView
        android:id="@+id/myCustomView"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
```

Refrence to custom-view inside your activity or fragment (I use [butterknife](https://github.com/JakeWharton/butterknife/))
```
 @BindView(R.id.myCustomView)
 MyCustomView myCustomView;
```

For getting recycler-view
```
RecyclerView recyclerView = myCustomView.getRecyclerView();
```

For setting status
```
myCustomView.setStatus(ListStatuse.LOADING);
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
