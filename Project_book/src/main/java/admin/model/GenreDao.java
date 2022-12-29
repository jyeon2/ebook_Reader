package admin.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("GenreDao")
public class GenreDao {

	private String namespace="admin.model.Admin";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public void insertGenre(GenreBean genre) {
		
		sqlSessionTemplate.insert(namespace+".InsertGenre",genre);
	}

	public List<GenreBean> getAllGenre() {
		List<GenreBean> lists = new ArrayList<GenreBean>();
		lists = sqlSessionTemplate.selectList(namespace+".GetAllGenre");
		
		return lists;
	}

	public GenreBean selectByGno(String gno) {
		GenreBean genre =
		sqlSessionTemplate.selectOne(namespace+".SelectByGno",gno);		
		
		return genre;
	}

	public void updateGenre(GenreBean genre) {
		sqlSessionTemplate.update(namespace+".UpdateGenre",genre);
		
	}

	public void deleteGenre(String gno) {
		sqlSessionTemplate.delete(namespace+".DeleteGenre",gno);
		
	}

	public List<GenreBean> getGenreCate() {
		List<GenreBean> lists = new ArrayList<GenreBean>();
		lists = sqlSessionTemplate.selectList(namespace+".GetGenreCate");
		return lists;
	}

}
