package com.kangjonghyuk.mvvmsample.view.ui.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kangjonghyuk.mvvmsample.R;
import com.kangjonghyuk.mvvmsample.databinding.FragmentTabFragment4Binding;

public class TabFragment4 extends Fragment {

    private FragmentTabFragment4Binding binding;

    public TabFragment4() {
        // Required empty public constructor
    }

    public static TabFragment4 newInstance(String param1, String param2) {
        TabFragment4 fragment = new TabFragment4();
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tab_fragment4, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Fragment infoFragment = InfoFragment.newInstance("one", "two");
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.topContainer, infoFragment).commit();

        Fragment pictureFragment = ArrayPictureFragment.newInstance();
        FragmentTransaction transaction1 = getChildFragmentManager().beginTransaction();
        transaction1.replace(R.id.bottomContainer, pictureFragment).commit();
    }
}
