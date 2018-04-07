package com.github.takahirom.hyperion.plugin.simpleitem;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

public class SimpleItem {
  @NonNull public final String title;
  @Nullable public final String text;
  @Nullable public final View.OnClickListener clickListener;
  @DrawableRes public final int image;

  private SimpleItem(Builder builder) {
    title = builder.title;
    text = builder.text;
    clickListener = builder.clickListener;
    image = builder.image;
  }

  public static final class Builder {
    private String title;
    private String text;
    private View.OnClickListener clickListener;
    private int image;

    public Builder(@NonNull String title) {
      this.title = title;
    }

    public Builder text(String text) {
      this.text = text;
      return this;
    }

    public Builder clickListener(View.OnClickListener clickListener) {
      this.clickListener = clickListener;
      return this;
    }

    public Builder image(@DrawableRes int image) {
      this.image = image;
      return this;
    }

    public SimpleItem build() {
      return new SimpleItem(this);
    }
  }
}
