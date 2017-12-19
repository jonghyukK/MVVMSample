package com.kangjonghyuk.mvvmsample.view.ui.activity;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.kangjonghyuk.mvvmsample.R;
import com.kangjonghyuk.mvvmsample.databinding.ActivityMainBinding;
import com.kangjonghyuk.mvvmsample.view.adapter.TabPagerAdapter;
import com.kangjonghyuk.mvvmsample.view.ui.fragment.TabFragment1;
import com.kangjonghyuk.mvvmsample.view.ui.fragment.TabFragment2;
import com.kangjonghyuk.mvvmsample.view.ui.fragment.TabFragment3;

public class MainActivity extends AppCompatActivity implements
        TabFragment1.OnFragmentInteractionListener,
        TabFragment2.OnFragmentInteractionListener,
        TabFragment3.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setHandler(this);
        binding.setManager(getSupportFragmentManager());
    }

    @BindingAdapter({"bind:handler"})
    public static void bindViewPagerAdapter(final ViewPager view, final MainActivity activity) {
        final TabPagerAdapter adapter = new TabPagerAdapter(view.getContext(), activity
                .getSupportFragmentManager());
        view.setAdapter(adapter);
    }

    @BindingAdapter({"bind:pager"})
    public static void bindViewPagerTabs(final TabLayout view, final ViewPager pagerView) {
        view.setupWithViewPager(pagerView, true);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}


//        if (savedInstanceState == null) {
//            ProjectListFragment fragment = new ProjectListFragment();
//
//            getSupportFragmentManager()
//                    .beginTransaction()
//                    .add(R.id.fragment_container, fragment, ProjectListFragment.TAG).commit();
//        }
//    }
//
//    public void show(Project project){
//        ProjectFragment projectFragment = ProjectFragment.forProject(project.name);
//
//        getSupportFragmentManager()
//                .beginTransaction()
//                .addToBackStack("project")
//                .replace(R.id.fragment_container,
//                        projectFragment, null).commit();
//    }
//}
