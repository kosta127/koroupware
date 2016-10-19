package kosta.community.mapper;

import java.util.List;

import kosta.community.model.Community;

public interface CommunityMapper {
	public int insertCommunity(Community community);
	public List<Community> listCommunity();
}
