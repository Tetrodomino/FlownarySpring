package com.example.flownary.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.flownary.entity.Board;

@Mapper
public interface BoardDao {

	@Select("select * from board where bid=#{bid}")
	Board getBoard(int bid);
	
	@Select("select count(b.bid) from board b"
	         + " JOIN users u ON b.uid=u.uid"
	         + " where b.isDeleted=0 and ${field} like #{query}")
	int getBoardCount(String field, String query);
	
	@Select("select * from board"
			+ " where isDeleted=0 and ${field} like #{query}"
			+ " order by modTime desc"
			+ " limit #{count} offset #{offset}")
	List<Board> getBoardList(String field, String query, int count, int offset);
	
	@Insert("insert into board values(default, #{uid}, #{title}, #{bContents}, default, "
			+ " default, default, default, #{image}, #{shareUrl}, "
			+ " default, #{hashTag}, #{nickname})")
	void insertBoard(Board board);
	
	@Update("update board set title=#{title}, bContents=#{bContents}, image=#{image}"
			+ ", shareUrl=#{shareUrl}, hashTag=#{hashTag} where bid=#{bid}")
	void updateBoard(Board board);
	
	@Update("update board set nickname=#{nickname} where uid=#{uid}")
	void updateBoardNickname(int uid, String nickname);
	
	@Update("update board set isDeleted=-1 where bid=#{bid}")
	void deleteBoard(int bid);
	
	@Update("update board set replyCount=#{replyCount}"
			+ " where bid=#{bid}")
	void updateReplyCount(int bid, int replyCount);
	
	@Update("update board set likeCount=#{likeCount}"
			+ " where bid=#{bid}")
	void updateLikeCount(int bid, int likeCount);
	
	@Update("update board set viewCount=viewCount+1 where bid=#{bid} ")
	void updateViewCount(int bid);
}
