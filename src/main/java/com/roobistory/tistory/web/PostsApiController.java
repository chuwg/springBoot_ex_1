package com.roobistory.tistory.web;

import com.roobistory.tistory.service.posts.PostsService;
import com.roobistory.tistory.web.dto.PostsResponseDto;
import com.roobistory.tistory.web.dto.PostsSaveRequestDto;
import com.roobistory.tistory.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController

public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id)
    {
        return postsService.findById(id);
    }
}
