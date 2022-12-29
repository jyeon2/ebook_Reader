package admin.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("BookDao")
public class BookDao {

	private String namespace="admin.model.Admin";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public int insertBook(BookBean book) {
		int cnt = -1;
		cnt = sqlSessionTemplate.insert(namespace+".InsertBook",book);
		System.out.println("insertBook 성공 : "+cnt);
		return cnt;
		
	}

	public List<BookBean> getAllBook() {
		List<BookBean> lists = new ArrayList<BookBean>();
		lists= sqlSessionTemplate.selectList(namespace+".GetAllBook");
		return lists;
	}

	public BookBean selectBookbyno(String book_no) {
		BookBean book = sqlSessionTemplate.selectOne(namespace+".SelectBookbyno", book_no);
		return book;
	}

	public int updateBook(BookBean book) {
		int cnt = sqlSessionTemplate.update(namespace+".UpdateBook",book);
		System.out.println("updateBook 성공 : "+cnt);
		return cnt;
		
	}

	public void deleteBook(String book_no) {
		sqlSessionTemplate.delete(namespace+".DeleteBook",book_no);
		
	}
	
	
}
