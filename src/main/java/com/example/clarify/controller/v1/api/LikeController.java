package com.example.clarify.controller.v1.api;

import com.example.clarify.model.Like;
import com.example.clarify.service.LikeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts/{pid}/likes")
public class LikeController {
    private final LikeService likesService;

    @GetMapping
    public ResponseEntity<Integer> getLikesCount(@PathVariable String pid) {
        try {
            List<Like> list = likesService.findByPid(pid);
            return new ResponseEntity<>(list.size(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Like> saveLike(@RequestBody Like like) {
        try {
            Like savedLike = likesService.save(like);
            return new ResponseEntity<>(savedLike, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        try {
            likesService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
