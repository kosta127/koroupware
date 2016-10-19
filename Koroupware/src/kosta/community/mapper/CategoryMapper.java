package kosta.community.mapper;

import java.util.List;

import kosta.community.model.Category;
import kosta.community.model.Community;

public interface CategoryMapper {

	public int insertCategory(Category category);
	public List<Community> listCategory(int community_no);
	
}
