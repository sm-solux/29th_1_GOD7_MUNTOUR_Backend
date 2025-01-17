package com.godseven.muntour.post.repository;

import com.godseven.muntour.post.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    @Query("SELECT b FROM Board b WHERE b.title LIKE %:keyword% OR b.content LIKE %:keyword%")
    List<Board> searchByTitleOrContent(@Param("keyword") String keyword);

    @Query("SELECT b FROM Board b WHERE b.category = :category")
    List<Board> findByCategory(@Param("category") String category);

    @Query("SELECT b FROM Board b JOIN b.tagMappings tm JOIN tm.tag t WHERE t.word = :hashtag")
    List<Board> findByHashtag(@Param("hashtag") String hashtag);
}
