package com.joyoung.androidjetpack;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class User extends BaseObservable {
    private String name;
    private String text;
    private String title;
    private int count;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        notifyChange();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User viewModel = (User) o;

        if (count != viewModel.count) return false;
        if (!name.equals(viewModel.name)) return false;
        if (!text.equals(viewModel.text)) return false;
        return title.equals(viewModel.title);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + text.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + count;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", title='" + title + '\'' +
                ", count=" + count +
                '}';
    }
}
