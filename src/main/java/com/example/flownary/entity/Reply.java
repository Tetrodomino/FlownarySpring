package com.example.flownary.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reply {

	int rid;
	int bid;
	int uid;
	String rContents;
	LocalDateTime modTime;
	int likeCount;
	String nickname;
	int isDeleted;

	@Override
	public String toString() {
		return "Reply [rid=" + rid + ", bid=" + bid + ", uid=" + uid + ", rContents=" + rContents + ", modTime="
				+ modTime + ", isDeleted=" + isDeleted + ", nickname=" + nickname + "]";
	}
}
