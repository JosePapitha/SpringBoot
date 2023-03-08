package com.rest.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.rest.example.model.PostModel;
import com.rest.example.service.PostService;

@RestController
@RequestMapping("/api/v1")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	Logger LOGGER = LoggerFactory.getLogger(PostController.class);
	
	@GetMapping("/posts")
	public PostModel[] getAllPosts() {
		PostModel[] response = postService.getAllPosts();
		LOGGER.info("[PostController] - Inside posts method");
		return response;
	}
	
	@GetMapping("/posts/user/{userId}")
	public void getAllPostsByUserId(@PathVariable("userId") Long userId) {
		
	}
	
	@PostMapping("/posts")
	public PostModel createPost(@RequestBody PostModel postModel) {
		PostModel model = postService.createPost(postModel);
		return model;
	}
	
	@GetMapping
	public String greeting() {
		return "Hello";
	}
	
	@GetMapping(value = "/greeting")
	public String customGreetings() {
		return "Welcome to Spring Boot";
	}

}

