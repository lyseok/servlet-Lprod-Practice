package prod.dao;

import java.util.List;

import prod.vo.LprodVO;
import prod.vo.ProdVO;

public interface IProdDao {
	public List<LprodVO> selectLprod();
	public List<ProdVO> selectProdByGu(String gu);
	public ProdVO selectProdById(String id);
}
