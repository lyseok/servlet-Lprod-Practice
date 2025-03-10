package prod.service;

import java.util.List;

import prod.dao.IProdDao;
import prod.vo.LprodVO;
import prod.vo.ProdVO;

public class ProdServiceImpl implements IProdService {
	private static IProdService instance;
	private IProdDao dao;
	
	private ProdServiceImpl(IProdDao dao) {
		this.dao = dao;
	}
	
	public static IProdService getInstance(IProdDao dao) {
		if(instance == null) instance = new ProdServiceImpl(dao);
		return instance;
	}

	@Override
	public List<LprodVO> selectLprod() {
		return dao.selectLprod();
	}

	@Override
	public List<ProdVO> selectProdByGu(String gu) {
		return dao.selectProdByGu(gu);
	}

	@Override
	public ProdVO selectProdById(String id) {
		return dao.selectProdById(id);
	}

}
