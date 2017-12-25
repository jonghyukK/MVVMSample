package com.kangjonghyuk.mvvmsample.view.ui.fragment.sub;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kangjonghyuk.mvvmsample.R;

public class ArrayPictureFragment extends Fragment {


    public ArrayPictureFragment() {
        // Required empty public constructor
    }

    public static ArrayPictureFragment newInstance() {
        ArrayPictureFragment fragment = new ArrayPictureFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_array_picture, container, false);

        return view;
    }

}
