package com.kangjonghyuk.mvvmsample.service.repository;

import com.kangjonghyuk.mvvmsample.service.model.Project;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kangjonghyuk on 2017. 12. 19..
 */

public class ProjectRepository {
    private GitHubService gitHubService;
    private static ProjectRepository projectRepository;

    private ProjectRepository(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GitHubService.HTTPS_API_GITHUB_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        gitHubService = retrofit.create(GitHubService.class);
    }

    public synchronized static ProjectRepository getInstance(){
        if(projectRepository == null){
            if(projectRepository == null){
                projectRepository = new ProjectRepository();
            }
        }

        return projectRepository;
    }


    /**
     *  Project List API
     * @param userId
     * @return
     */
    public LiveData<List<Project>> getProjectList(String userId) {
        final MutableLiveData<List<Project>> data = new MutableLiveData<>();

        gitHubService.getProjectList(userId).enqueue(new Callback<List<Project>>() {
            @Override
            public void onResponse(Call<List<Project>> call, Response<List<Project>> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Project>> call, Throwable t) {
                data.setValue(null);
            }
        });

        return data;
    }

    /**
     *  Project Detail API
     * @param userID
     * @param projectName
     * @return
     */
    public LiveData<Project> getProjectDetail(String userID, String projectName){
        final MutableLiveData<Project> data = new MutableLiveData<>();

        gitHubService.getProjectDetails(userID, projectName).enqueue(new Callback<Project>() {
            @Override
            public void onResponse(Call<Project> call, Response<Project> response) {
                simulateDelay();
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Project> call, Throwable t) {
                data.setValue(null);
            }
        });

        return data;
    }

    private void simulateDelay(){
        try{
            Thread.sleep(10);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
