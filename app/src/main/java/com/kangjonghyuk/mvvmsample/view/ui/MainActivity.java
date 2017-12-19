package com.kangjonghyuk.mvvmsample.view.ui;

import com.kangjonghyuk.mvvmsample.R;
import com.kangjonghyuk.mvvmsample.service.model.Project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            ProjectListFragment fragment = new ProjectListFragment();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, fragment, ProjectListFragment.TAG).commit();
        }
    }

    public void show(Project project){
        ProjectFragment projectFragment = ProjectFragment.forProject(project.name);

        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack("project")
                .replace(R.id.fragment_container,
                        projectFragment, null).commit();
    }
}
