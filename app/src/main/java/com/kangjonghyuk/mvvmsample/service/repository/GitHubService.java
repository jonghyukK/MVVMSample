package com.kangjonghyuk.mvvmsample.service.repository;

import com.kangjonghyuk.mvvmsample.service.model.Project;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by kangjonghyuk on 2017. 12. 19..
 */

interface GitHubService {

    String HTTPS_API_GITHUB_URL = "https://api.github.com/";

    @GET("users/{user}/repos")
    Call<List<Project>> getProjectList(@Path("user") String user);

    @GET("/repos/{user}/{reponame}")
    Call<Project> getProjectDetails(@Path("user") String user, @Path("reponame") String projectName);
}
