# Hyperion-Simple-Item
[![Release](https://jitpack.io/v/takahirom/Hyperion-Simple-Item.svg)](https://jitpack.io/#takahirom/Hyperion-Simple-Item)

You can add item to [Hyperion-Android](https://github.com/willowtreeapps/Hyperion-Android) menu.

If you already have DebugMenu in your app, you will be able to go to that place.

![image](https://user-images.githubusercontent.com/1386930/38463403-36f50024-3b35-11e8-98d3-104e2be65baa.png)

# Usage

app/src/**debug**/AndroidManifest.xml

```xml
    <application
        android:name=".DebugApp"
        tools:replace="android:name"
        />
```


Write bindings between shared preference and method in your DebugApp.

app/src/**debug**/java/.../DebugApp.java

```java
// Extends your main Application classs
public class DebugApp extends App {
  @Override public void onCreate() {
    super.onCreate();

    final SimpleItem item = new SimpleItem.Builder("all: this is the title")
            .text("this is the text")
            .image(R.drawable.ic_list_black_24dp)
            .clickListener(new View.OnClickListener() {
              @Override public void onClick(View v) {
                Toast.makeText(App.this, "click",Toast.LENGTH_SHORT).show();
              }
            })
            .build();
    SimpleItemHyperionPlugin.addItem(item);
```

# Download
Step 1. Add it in your root build.gradle at the end of repositories:

```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency

```groovy
dependencies {
    debugImplementation 'com.github.takahirom:Hyperion-Simple-Item:0.1.0'
}
```
