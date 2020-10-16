package com.github.takahirom.hyperion.plugin.simpleitem;

import androidx.annotation.Nullable;
import com.google.auto.service.AutoService;
import com.willowtreeapps.hyperion.plugin.v1.Plugin;
import com.willowtreeapps.hyperion.plugin.v1.PluginModule;
import java.util.ArrayList;
import java.util.List;

@AutoService(Plugin.class)
public class SimpleItemHyperionPlugin extends Plugin {
  private static final List<SimpleItem> items = new ArrayList<SimpleItem>();
  public static void addItem(SimpleItem item) {
     items.add(item);
  }

  @Nullable @Override public PluginModule createPluginModule() {
    return new SimpleItemModule(items);
  }


}
