package com.kangjonghyuk.mvvmsample.view.adapter;

import android.databinding.BindingAdapter;
import android.view.View;

/**
 * Created by kangjonghyuk on 2017. 12. 19..
 */

public class CustomBindingAdapter {

    @BindingAdapter("visibleGone")
    public static void showHide(View view, boolean show){
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}
