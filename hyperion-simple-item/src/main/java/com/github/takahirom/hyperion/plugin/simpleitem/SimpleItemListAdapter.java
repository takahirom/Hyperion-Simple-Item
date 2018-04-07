package com.github.takahirom.hyperion.plugin.simpleitem;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import takahirom.github.com.hyperion_simple_item.R;

class SimpleItemListAdapter
    extends ListAdapter<SimpleItem, SimpleItemListAdapter.SimpleItemViewHolder> {

  private static final DiffUtil.ItemCallback<SimpleItem> DIFF_CALLBACK =
      new DiffUtil.ItemCallback<SimpleItem>() {
        @Override
        public boolean areItemsTheSame(@NonNull SimpleItem oldUser, @NonNull SimpleItem newUser) {
          return oldUser.equals(newUser);
        }

        @Override public boolean areContentsTheSame(@NonNull SimpleItem oldUser,
            @NonNull SimpleItem newUser) {
          return oldUser.equals(newUser);
        }
      };
  private LayoutInflater layoutInflater;

  SimpleItemListAdapter(LayoutInflater layoutInflater) {
    super(DIFF_CALLBACK);
    this.layoutInflater = layoutInflater;
  }

  @NonNull @Override
  public SimpleItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new SimpleItemViewHolder(
        layoutInflater.inflate(R.layout.layout_simple_item, parent, false));
  }

  @Override public void onBindViewHolder(@NonNull final SimpleItemViewHolder holder, int position) {
    final SimpleItem item = getItem(position);
    holder.title.setText(item.title);
    holder.text.setText(item.text);
    holder.text.setVisibility(item.text == null ? View.GONE : View.VISIBLE);
    holder.image.setImageResource(item.image);
    holder.image.setVisibility(item.image == 0 ? View.GONE : View.VISIBLE);
    holder.itemView.setOnClickListener(item.clickListener);
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
