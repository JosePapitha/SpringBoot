package com.rest.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rest.example.model.PostModel;

@Service
public class PostServiceImpl implements PostService{
	
	@Value("${external.api.url}")
	private String postApiBaseUrl;

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public PostModel[] getAllPosts() {
		PostModel[] result = restTemplate.getForObject(postApiBaseUrl+"/posts", PostModel[].class);
		System.out.println(result);
		
		return result;
	}

	
	@Override
	public void getAllPostsByUserId(Long userId) {
		
		
	}


	@Override
	public PostModel createPost(PostModel postModel) {
		
		PostModel model = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<PostModel> httpEntity = new HttpEntity<>(postModel,headers);
		
		ResponseEntity<PostModel> newPostEntity =  restTemplate.postForEntity(postApiBaseUrl+"/posts", httpEntity, PostModel.class);
		
		if(newPostEntity.getStatusCode() == HttpStatus.CREATED) {
			model = newPostEntity.getBody();
		}
		
		return model;
		
	}

}
