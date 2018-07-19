package com.dcorepay.dao;

import com.dcorepay.entities.Mch;

import java.util.List;

public interface CibMchMapper{

	public int update(Mch entity);

	List<Mch> selectListByTopBankId(Long _topBankId);
}
