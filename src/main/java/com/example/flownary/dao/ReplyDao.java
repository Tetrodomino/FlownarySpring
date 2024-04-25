package com.example.flownary.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.flownary.entity.Reply;

@Mapper
public interface ReplyDao {

	@Select("select * from reply where rid=#{rid}")
	Reply getReply(int rid);
	
	@Select("select r.*, u.nickname from reply r"
			+ " join user u on r.uid=u.uid"
			+ " where isDeleted=0 and bid=#{bid}"
			+ " order by modTime desc"
			+ " limit #{count} offset #{offset}")
	List<Reply> getReplyList(int bid, int offset, int limit);
	
	@Select("select r.*, u.nickname from reply "
			+ "	join user u on r.uid=u.uid"
			+ " where isDeleted=0 and uid=#{uid}"
			+ " order by modTime desc"
			+ " limit #{count} offset #{offset}")
	List<Reply> getReplyListByUid(int uid, int offset, int limit);
	
	@Insert("insert into reply values(default, #{bid}, #{uid}, #{rContents}, default, default)")
	void insertReply(Reply reply);
	
	@Update("update reply set rContents=#{rContents} where rid=#{rid}")
	void updateReply(Reply reply);
	
	@Update("update reply set isDeleted=-1 where rid=#{rid}")
	void deleteReply(Reply reply);
}
