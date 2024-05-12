package com.choiye.awspractice.controller;

import com.choiye.awspractice.dto.ContentAddDto;
import com.choiye.awspractice.dto.ContentResponseDto;
import com.choiye.awspractice.service.ContentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/content")
@RequiredArgsConstructor
public class ContentController {
    private final ContentService contentService;

    @PostMapping
    public ResponseEntity createContent(@RequestBody @Valid ContentAddDto contentDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(contentService.createContent(contentDto));
    }

    @GetMapping("/{contentId}")
    public ResponseEntity getContent(@PathVariable Long contentId){
        ContentResponseDto responseDto = ContentResponseDto.of(contentService.getContent(contentId));
        return ResponseEntity.ok(responseDto);
    }
}
