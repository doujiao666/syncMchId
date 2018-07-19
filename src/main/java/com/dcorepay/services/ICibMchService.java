package com.dcorepay.services;

import com.dcorepay.entities.Mch;

import java.util.List;
import java.util.Map;

public interface ICibMchService{

	public List<Mch> selectListByTopBankId(Long topBankId);

	public int update(Mch cibMch);

	public Map<String, String> generateCodeAli(Mch mch);

	public Map<String, String> getCodeOrGenerate(Mch mch);
}