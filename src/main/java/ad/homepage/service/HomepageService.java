package ad.homepage.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;

import ad.pojo.BusinessClassify;
import ad.pojo.Company;
import ad.pojo.News;
import ad.pojo.TelCallRecord;
import ad.pojo.Users;

public interface HomepageService {

	PageInfo<Company> listCompany(Map<String, String> paramMap);

	int companySave(Company company);

	List<Company> listCompanyWx();

	int delCompanyByIds(String companyIds);

	void importCompanyDatas(List<Company> allList);

	Company getCompanyById(String companyId);

	int userSave(Users user);

	int getUserRegInfoWx(String openid);

	Users getUserByopenid(String openid);

	int updateUser(Users user);

	int saveTelCallRecord(TelCallRecord telCallRecord);

	List<TelCallRecord> listMyTelRecord(String openid);

	PageInfo<News> listNews(Map<String, String> paramMap);

	int newsSave(News news);

	int delNewsById(String id);

	int publishNews(String id);

	List<News> listNewsWx();

	News getNewsById(String id);

	PageInfo<BusinessClassify> listClassify(Map<String, String> paramMap, String type);

	int BusinessClassifySave(BusinessClassify businessClassify);

	int delClassifyById(String id);

	List<BusinessClassify> listClassifyWx(String type);

	List<Company> listCompanyByClassifyWx(String code, String name);

	List<BusinessClassify> selectClassify(String title);

}
