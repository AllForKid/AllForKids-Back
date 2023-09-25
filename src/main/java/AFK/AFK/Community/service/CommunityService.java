package AFK.AFK.Community.service;

import AFK.AFK.Community.controller.CommunityController;
import AFK.AFK.Community.dto.*;
import AFK.AFK.Community.entity.Community;
import AFK.AFK.Community.repository.CommunityRepository;
import AFK.AFK.Login.User;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommunityService {
    private final CommunityRepository communityRepository;
    private EntityManager entityManager;

    @Autowired
    public CommunityService(CommunityRepository communityRepository, EntityManager entityManager) {
        this.communityRepository = communityRepository;
        this.entityManager = entityManager;
    }

    //리뷰 목록 조회
    public CommunityListResponseDto getCommunityList(String type) {
        List<Community> communities = communityRepository.findByType(type);
        List<CommunityListDto> communityList = new ArrayList<>();

        for (Community community : communities) {
            CommunityListDto communityListDto = new CommunityListDto(community.getWriter(), community.getTitle(), community.getContent(), community.getImageUrl(), community.getCreatedAt());
            communityList.add(communityListDto);
        }
        return new CommunityListResponseDto(true, 1012, "게시글 목록 조회 성공", communityList);
    }

    //리뷰 하나 조회
    public CommunityResponseDto getCommunity(Long userId, Long postId){
        try {
            Optional<Community> communities = communityRepository.findById(postId);
            if (communities.isEmpty()) {
                return new CommunityResponseDto(false, 3027, "게시글 없음", null);
            }
            Community community = communities.get();
            List<CommunityDto> communityResult = new ArrayList<>();
            LocalDateTime createdAt = community.getCreatedAt().atStartOfDay();
            communityResult.add(new CommunityDto(userId, postId, createdAt, community.getWriter(), community.getTitle(), community.getContent(), community.getImageUrl()));

            return new CommunityResponseDto(true, 1011, "게시글 조회 성공", communityResult);
        } catch (Exception e) {
            System.out.println(e);
            return new CommunityResponseDto(false, 3021, "게시글 조회 실패", null);
        }
    }

    //리뷰 작성
    public CommunitySaveResponseDto postCommunity(String type, Long userId, String title, String content,String writer, String image) {
        try{
            User user = entityManager.find(User.class, userId);
            Community community = new Community(user, type, title, content, writer, false, image);
            Community community1 = communityRepository.save(community);
            LocalDateTime createdAt = LocalDateTime.now();
            List<CommunitySaveDto> communitySaveDto = List.of(new CommunitySaveDto(userId, community1.getPostId(), createdAt, community1.getWriter(), community1.getTitle(), community1.getContent(), type, community1.getImageUrl()));

            return new CommunitySaveResponseDto(true, 1013, "글쓰기 성공", null);
        }
        catch (Exception e){
            System.out.println(e);
            return new CommunitySaveResponseDto(false, 3023, "글쓰기 실패", null);
        }
    }

    //리뷰 수정
    public CommunityResponseDto patchCommunity(Long postId, String title, String content, String image) {
        try {
            Optional<Community> community = communityRepository.findById(postId);
            Community community1 = community.get();
            community1.updateCommunity(title, content, image);
            return new CommunityResponseDto(true, 1015, "글 수정 성공", null);
        }
        catch (Exception e) {
            System.out.println(e);
            return new CommunityResponseDto(false, 3024, "글 수정 실패", null);
        }
    }

    //리뷰 삭제
    public CommunityResponseDto deleteCommunity(Long postId) {
        try {
            Optional<Community> community = communityRepository.findById(postId);
            if (community.isEmpty()) {
                return new CommunityResponseDto(false, 3014, "게시글 없음", null);
            }
            Community delCommunity = community.get();
            communityRepository.delete(delCommunity);
            return new CommunityResponseDto(true, 1016, "글 삭제 성공", null);
        }
        catch (Exception e) {
            System.out.println(e);
            return new CommunityResponseDto(false, 3025, "글 삭제 실패", null);
        }
    }
}