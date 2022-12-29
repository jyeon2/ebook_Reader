package member.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("MemberDao")
public class MemberDao {

	private String namespace = "member.model.Member";
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public void insertMember(MemberBean member) {
		sqlSessionTemplate.insert(namespace+".InsertMember", member);
		
	}

	public boolean checkEmailPassword(MemberBean member) {
		MemberBean mb = null;
		mb = sqlSessionTemplate.selectOne(namespace+".CheckEP", member);
		if(mb == null) {
			return false; //없음 -> 로그인X
		} else {
			return true; //있음 -> 로그인O
		}
	}

	public MemberBean selectMemberOne(MemberBean member) {
		MemberBean mb = null;
		mb = sqlSessionTemplate.selectOne(namespace+".SelectMemberOne", member);
		return mb; 
	}

	public MemberBean findId(MemberBean member) {
		MemberBean mb = null;
		mb=sqlSessionTemplate.selectOne(namespace+".FindId",member);
		return mb;
	}

	public MemberBean searchEmail(String useremail) {
		MemberBean mb = null;
		mb = sqlSessionTemplate.selectOne(namespace + ".SearchEmail", useremail);
		return mb;
	}

	public MemberBean findPw(MemberBean member) {
		MemberBean mb = null;
		mb=sqlSessionTemplate.selectOne(namespace+".FindPw",member);
		return mb;
	}
	

	
}
