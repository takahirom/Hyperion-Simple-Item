package com.github.takahirom.hyperion.plugin.simpleitem;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import takahirom.github.com.hyperion_simple_item.R;

class SimpleItemListAdapter
    extends RecyclerView.Adapter<SimpleItemListAdapter.SimpleItemViewHolder> {

  private LayoutInflater layoutInflater;
  @NonNull private List<SimpleItem> items = new ArrayList<SimpleItem>();

  SimpleItemListAdapter(LayoutInflater layoutInflater) {
    super();
    this.layoutInflater = layoutInflater;
  }

  @NonNull @Override
  public SimpleItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new SimpleItemViewHolder(
        layoutInflater.inflate(R.layout.layout_simple_item, parent, false));
  }

  @Override public void onBindViewHolder(@NonNull final SimpleItemViewHolder holder, int position) {
    final SimpleItem item = items.get(position);
    holder.title.setText(item.title);
    holder.title.setVisibility(item.title == null ? View.GONE : View.VISIBLE);
    holder.text.setText(item.text);
    holder.text.setVisibility(item.text == null ? View.GONE : View.VISIBLE);
    holder.image.setImageResource(item.image);
    holder.image.setVisibility(item.image == 0 ? View.GONE : View.VISIBLE);
    holder.itemView.setOnClickListener(item.clickListener);
  }

  @Override public int getItemCount() {
    return items.size();
  }

  public void submitList(List<SimpleItem> items){
    this.items = items;
    notifyDataSetChanged();
  }

  class SimpleItemViewHolder extends RecyclerView.ViewHolder {
    private final TextView title;
    private final TextView text;
    private final ImageView image;

    SimpleItemViewHolder(View itemView) {
      super(itemView);
      title = itemView.findViewById(R.id.title);
      text = itemView.findViewById(R.id.text);
      image = itemView.findViewById(R.id.image);
    }
  }
}
