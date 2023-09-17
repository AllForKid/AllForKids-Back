package AFK.AFK.Community.repository;

import AFK.AFK.Community.entity.Community;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommunityRepository extends JpaRepository<Community, Long> {
    List<Community> findCommunityByPostId(Long postId);
    List<Community> findByType(String type);
}
