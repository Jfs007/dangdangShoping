package service;

import java.util.List;

import dao.CatDao;

import entiy.DCategory;

public class CatSeverImpl implements CatSever {
private CatDao catDao;
	
	public CatDao getCatDao() {
		return catDao;
	}
	public void setCatDao(CatDao catDao) {
		this.catDao = catDao;
	}
	//≤È’“◊”cat
	@Override
	public List<DCategory> getcatChbyId() {
		// TODO Auto-generated method stub
		return catDao.getCatChcbyId();
	}
	//≤È’“∏∏cat
	public List<DCategory> getcatPrbyId() {
		// TODO Auto-generated method stub
		return catDao.getCatPrcbyId();
	}
	
}
