package com.kangjonghyuk.mvvmsample.view.ui.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kangjonghyuk.mvvmsample.R;
import com.kangjonghyuk.mvvmsample.databinding.FragmentProjectListBinding;
import com.kangjonghyuk.mvvmsample.view.adapter.ProjectAdapter;
import com.kangjonghyuk.mvvmsample.view.callback.ProjectClickCallback;
import com.kangjonghyuk.mvvmsample.viewmodel.ProjectListViewModel;

/**
 * Created by kangjonghyuk on 2017. 12. 19..
 */

public class ProjectListFragment extends Fragment {

    public static final String TAG = "ProjectListFragment";
    private ProjectAdapter projectAdapter;
    private FragmentProjectListBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_project_list, container, false);

        projectAdapter = new ProjectAdapter(projectClickCallback);
        binding.projectList.setAdapter(projectAdapter);
        binding.setIsLoading(true);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final ProjectListViewModel viewModel =
                ViewModelProviders.of(this).get(ProjectListViewModel.class);

        observeViewModel(viewModel);
    }

    private void observeViewModel(ProjectListViewModel viewModel){

        viewModel.getProjectListObservable().observe(this, projects -> {
            if(projects != null){
                binding.setIsLoading(false);
                projectAdapter.setProjectList(projects);
            }
        });
    }

    private final ProjectClickCallback projectClickCallback = project -> {
//        if(getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)){
//            ((MainActivity) getActivity()).show(project);
//        }
    };
}
