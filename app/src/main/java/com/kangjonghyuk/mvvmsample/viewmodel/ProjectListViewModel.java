package com.kangjonghyuk.mvvmsample.viewmodel;

import com.kangjonghyuk.mvvmsample.service.model.Project;
import com.kangjonghyuk.mvvmsample.service.repository.ProjectRepository;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

/**
 * Created by kangjonghyuk on 2017. 12. 19..
 */

public class ProjectListViewModel extends AndroidViewModel{
    private final LiveData<List<Project>> projectListObservable;

    public ProjectListViewModel(Application application){
        super(application);

        projectListObservable = ProjectRepository.getInstance().getProjectList("Google");
    }

    public LiveData<List<Project>> getProjectListObservable() {
        return projectListObservable;
    }
}
