package com.github.takahirom.hyperion.plugin.simpleitem.sample;

import android.view.View;
import android.widget.Toast;
import com.github.takahirom.hyperion.plugin.simpleitem.R;
import com.github.takahirom.hyperion.plugin.simpleitem.SimpleItem;
import com.github.takahirom.hyperion.plugin.simpleitem.SimpleItemHyperionPlugin;

public class DebugApp extends App {
  @Override public void onCreate() {
    super.onCreate();
    final SimpleItem onlyTitleItem = new SimpleItem.Builder("only title: title")
        .clickListener(new View.OnClickListener() {
          @Override public void onClick(View v) {
            Toast.makeText(DebugApp.this, "click 1",Toast.LENGTH_SHORT).show();
          }
        })
        .build();
    SimpleItemHyperionPlugin.addItem(onlyTitleItem);
    final SimpleItem titleTextItem = new SimpleItem.Builder("title and text: this is the title")
        .text("this is the text")
        .clickListener(new View.OnClickListener() {
          @Override public void onClick(View v) {
            Toast.makeText(DebugApp.this, "click 2",Toast.LENGTH_SHORT).show();
          }
        })
        .build();
    SimpleItemHyperionPlugin.addItem(titleTextItem);
    final SimpleItem imageItem = new SimpleItem.Builder("all: this is the title")
        .text("this is the text")
        .image(R.drawable.ic_list_black_24dp)
        .clickListener(new View.OnClickListener() {
          @Override public void onClick(View v) {
            Toast.makeText(DebugApp.this, "click 3",Toast.LENGTH_SHORT).show();
          }
        })
        .build();
    SimpleItemHyperionPlugin.addItem(imageItem);
  }
}
