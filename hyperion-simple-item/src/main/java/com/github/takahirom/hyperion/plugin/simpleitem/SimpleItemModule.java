package com.github.takahirom.hyperion.plugin.simpleitem;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.willowtreeapps.hyperion.plugin.v1.PluginModule;
import java.util.List;

class SimpleItemModule extends PluginModule {

  private final List<SimpleItem> items;

  SimpleItemModule(List<SimpleItem> items) {
    this.items = items;
  }

  @Override public View createPluginView(@NonNull final LayoutInflater layoutInflater,
      @NonNull ViewGroup parent) {
    final RecyclerView recyclerView = new RecyclerView(parent.getContext());
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    final SimpleItemListAdapter adapter = new SimpleItemListAdapter(layoutInflater);
    recyclerView.setAdapter(adapter);
    final DividerItemDecoration dividerItemDecoration =
        new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
    recyclerView.addItemDecoration(dividerItemDecoration);
    adapter.submitList(items);
    return recyclerView;
  }
}
