package prod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;


import prod.vo.LprodVO;
import prod.vo.ProdVO;
import util.MyBatisUtil;

public class ProdDaoImpl implements IProdDao {
	private static IProdDao instance;
	
	private ProdDaoImpl() {};
	
	public static IProdDao getInstance() {
		if(instance == null) instance = new ProdDaoImpl();
		return instance;
	}
	
	@Override
	public List<LprodVO> selectLprod() {
		List<LprodVO> list = null;
		SqlSession session = null;
		
		try {
			session = MyBatisUtil.getSqlSession();
			list = session.selectList("prod.selectLprod");			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();			
		}
		return list;
	}

	@Override
	public List<ProdVO> selectProdByGu(String gu) {
		List<ProdVO> list = null;
		SqlSession session = null;
		
		try {
			session = MyBatisUtil.getSqlSession();
			list = session.selectList("prod.selectProdByGu", gu);			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();			
		}
		return list;
	}

	@Override
	public ProdVO selectProdById(String id) {
		ProdVO vo = null;
		SqlSession session = null;
		
		try {
			session = MyBatisUtil.getSqlSession();
			vo = session.selectOne("prod.selectProdById", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();			
		}
		
		return vo;
	}

}
