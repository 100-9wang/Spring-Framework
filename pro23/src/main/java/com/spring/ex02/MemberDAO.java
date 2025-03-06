package com.spring.ex02;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;

public class MemberDAO {
	
    private static SqlSessionFactory sqlMapper = null;

    // 싱글톤 패턴으로 SqlSessionFactory 객체를 초기화
    public static SqlSessionFactory getInstance() {
        if (sqlMapper == null) {
            try {
                String resource = "mybatis/SqlMapConfig.xml"; // MyBatis 설정 파일 경로
                Reader reader = Resources.getResourceAsReader(resource);
                sqlMapper = new SqlSessionFactoryBuilder().build(reader);
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sqlMapper;
    }
    
    // 모든 회원 정보 조회 메소드
	public List<MemberVO> selectAllMemberList() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<MemberVO> membersList = null;
		membersList = session.selectList("mapper.member.selectAllMemberList");
		return membersList;
	}
	
	// selectName() 메소드 구현
    public String selectName() {
    	sqlMapper = getInstance();
    	SqlSession session = sqlMapper.openSession(); // DB연동
    	String name = (String)session.selectOne("mapper.member.selectName");
    	return name;
    }
    
    // selectPwd() 메소드 구현
    public String selectPwd() {
    	sqlMapper = getInstance();
    	SqlSession session = sqlMapper.openSession();
    	String pwd = (String)session.selectOne("mapper.member.selectPwd");
    	return pwd;
    }
	
}
