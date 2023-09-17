package AFK.AFK.Community.controller;


import AFK.AFK.Community.dto.CommunityDto;
import AFK.AFK.Community.dto.CommunityListResponseDto;
import AFK.AFK.Community.dto.CommunityResponseDto;
import AFK.AFK.Community.dto.CommunitySaveResponseDto;
import AFK.AFK.Community.service.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/community")
@RequiredArgsConstructor
public class CommunityController {
    private final CommunityService communityService;

    //전체 리뷰 목록 조회
    @GetMapping("/community/{type}")
    public ResponseEntity<CommunityListResponseDto> getCommunityList(
            @PathVariable String type){
        CommunityListResponseDto communityListResponseDto = communityService.getCommunityList(type);
        return ResponseEntity.ok(communityListResponseDto);
    }

    /*
    //리뷰 하나 조회
    @GetMapping("/community/{postId}")
    public ResponseEntity<CommunityResponseDto> getCommunity(
            @PathVariable Long postId){
        CommunityResponseDto communityResponseDto = communityService.getCommunity(postId);
        return ResponseEntity.ok(communityResponseDto);
    }

    //리뷰 작성

    @PostMapping("/community/{type}")
    public ResponseEntity postCommunity(@PathVariable String type,
                                        @RequestBody CommunityDto communityDto, @RequestParam(value = "image", required = false) String image) {
        CommunitySaveResponseDto communitySaveResponseDto = communityService.postCommunity(
                type, communityDto.getUserId(), communityDto.getTitle(), communityDto.getContent(), image);
        return ResponseEntity.ok(communitySaveResponseDto);
    }
*/
    //리뷰 수정
    @PatchMapping("/community/{postId}")
    public ResponseEntity patchCommunity(
            @PathVariable Long postId,
            @RequestBody CommunityDto communityDto, @RequestParam(value = "image", required = false) String image) {
        CommunityResponseDto communityResponseDto = communityService.patchCommunity(postId, communityDto.getTitle(), communityDto.getContent(), image);
        return ResponseEntity.ok(communityResponseDto);
    }

    //리뷰 삭제
    @DeleteMapping("/community/{postId}")
    public ResponseEntity deleteCommunity(
            @PathVariable Long postId) {
        CommunityResponseDto communityResponseDto = communityService.deleteCommunity(postId);
        return ResponseEntity.ok(communityResponseDto);
    }
}
