package com.rest.example.service;



import com.rest.example.model.PostModel;

public interface PostService {
	
	public PostModel[] getAllPosts() ;
	public void getAllPostsByUserId(Long userId);
	public PostModel createPost(PostModel postModel);

}
