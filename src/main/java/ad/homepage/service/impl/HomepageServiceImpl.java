package ad.homepage.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import ad.homepage.service.HomepageService;
import ad.mapper.BusinessClassifyMapper;
import ad.mapper.CompanyMapper;
import ad.mapper.NewsMapper;
import ad.mapper.TelCallRecordMapper;
import ad.mapper.UsersMapper;
import ad.pojo.BusinessClassify;
import ad.pojo.Company;
import ad.pojo.News;
import ad.pojo.TelCallRecord;
import ad.pojo.Users;
import ad.utils.DateUtil;
import tk.mybatis.mapper.entity.Example;

@Service
public class HomepageServiceImpl implements HomepageService{
	
	@Autowired
	private CompanyMapper companyMapper;
	@Autowired
	private UsersMapper usersMapper;
	@Autowired
	private TelCallRecordMapper telCallRecordMapper;
	@Autowired
	private NewsMapper newsMapper;
	@Autowired
	private BusinessClassifyMapper businessClassifyMapper;

	@Override
	public PageInfo<Company> listCompany(Map<String, String> paramMap) {
		Integer pageNum = Integer.parseInt(paramMap.get("page"));
		Integer pageSize = Integer.parseInt(paramMap.get("limit"));
		PageHelper.startPage(pageNum, pageSize);
		
		Example example = new Example(Company.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andCondition("is_deleted = 0");
		example.orderBy("ts").desc();
		List<Company> list = companyMapper.selectByExample(example);
		PageInfo<Company> pageInfo = new PageInfo<Company>(list);
		return pageInfo;
	}
	
	@Override
	public List<Company> listCompanyByClassifyWx(String code, String name) {
		Example example = new Example(Company.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andCondition("primary_business_code like '%"+code+"%'");
//		try {
//			if (StringUtils.isNotBlank(code)) {
////				name = java.net.URLDecoder.decode(name,"UTF-8");
////				name = java.net.URLDecoder.decode(name,"UTF-8");
//				criteria.andLike("primaryBusinessCode", code);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		criteria.andCondition("is_deleted = 0");
		example.orderBy("ts").desc();
		return companyMapper.selectByExample(example);
	}

	@Override
	public int companySave(Company company) {
		if (StringUtils.isNotBlank(company.getCompanyId())) {
			return this.companyMapper.updateByPrimaryKeySelective(company);
		}
		company.setCompanyId(UUID.randomUUID().toString());
		company.setTs(new Date());
		company.setIsDeleted(false);
		return this.companyMapper.insert(company);
	}

	@Override
	public int delCompanyByIds(String companyIds) {
		if (StringUtils.isBlank(companyIds)) {
			return 0;
		}
		return this.companyMapper.delCompanyByIds(companyIds);
	}

	@Override
	public void importCompanyDatas(List<Company> allList) {
		for (Company company : allList) {
			this.companyMapper.insertSelective(company);
		}
//		this.companyMapper.insertList(allList);
	}

	@Override
	public List<Company> listCompanyWx() {
		Company company = new Company();
		RowBounds rowBounds = new RowBounds(0, 10);
		return companyMapper.selectByRowBounds(company, rowBounds);
	}

	@Override
	public Company getCompanyById(String companyId) {
		return companyMapper.selectByPrimaryKey(companyId);
	}

	@Override
	public int userSave(Users user) {
		String tel = user.getTel();
		if (StringUtils.isNotBlank(tel)) {
			Example example = new Example(Company.class);
			Example.Criteria criteria = example.createCriteria();
			criteria.andCondition("company_tel like '%"+tel+"%'");
			List<Company> list = companyMapper.selectByExample(example);
			if (list != null && list.size() > 0) {
				Company company = list.get(0);
				user.setCompanyId(company.getCompanyId());
				user.setCompanyTel(company.getCompanyTel());
			}
		}
		return this.usersMapper.insert(user);
	}

	@Override
	public int getUserRegInfoWx(String openid) {
		Users user = new Users();
		user.setOpenid(openid);
		return usersMapper.selectCount(user);
	}

	@Override
	public Users getUserByopenid(String openid) {
		Example example = new Example(Users.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andCondition(" openid = '"+openid+"' ");
		List<Users> list = usersMapper.selectByExample(example);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public int updateUser(Users user) {
		Example example = new Example(Users.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andCondition(" openid = '"+user.getOpenid()+"' ");
		return this.usersMapper.updateByExampleSelective(user, example);
	}

	@Override
	public int saveTelCallRecord(TelCallRecord telCallRecord) {
		return this.telCallRecordMapper.insert(telCallRecord);
	}

	@Override
	public List<TelCallRecord> listMyTelRecord(String openid) {
		Example example = new Example(TelCallRecord.class);
		Example.Criteria criteria = example.createCriteria();
//		criteria.andCondition(" openid = '"+openid+"' ");
		return this.telCallRecordMapper.selectByExample(example);
	}

	@Override
	public PageInfo<News> listNews(Map<String, String> paramMap) {
		Integer pageNum = Integer.parseInt(paramMap.get("page"));
		Integer pageSize = Integer.parseInt(paramMap.get("limit"));
		PageHelper.startPage(pageNum, pageSize);
		
		Example example = new Example(News.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andCondition("is_deleted = 0");
		example.orderBy("ts").desc();
		List<News> list = newsMapper.selectByExample(example);
		PageInfo<News> pageInfo = new PageInfo<News>(list);
		return pageInfo;
	}

	@Override
	public int newsSave(News news) {
		if (StringUtils.isNotBlank(news.getId())) {
			return this.newsMapper.updateByPrimaryKeySelective(news);
		}
		news.setId(UUID.randomUUID().toString());
		news.setTs(DateUtil.formatDate(new Date()));
		news.setPublish(false);
		news.setIsDeleted(false);
		return this.newsMapper.insert(news);
	}

	@Override
	public int delNewsById(String id) {
		return this.newsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int publishNews(String id) {
		News news = new News();
		news.setId(id);
		news.setPublish(true);
		return this.newsMapper.updateByPrimaryKeySelective(news);
	}

	@Override
	public List<News> listNewsWx() {
		Example example = new Example(News.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andCondition("publish = 1 ");
		example.orderBy("ts").desc();
		return this.newsMapper.selectByExample(example);
	}

	@Override
	public News getNewsById(String id) {
		return this.newsMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<BusinessClassify> listClassify(Map<String, String> paramMap, String type) {
		Integer pageNum = Integer.parseInt(paramMap.get("page"));
		Integer pageSize = Integer.parseInt(paramMap.get("limit"));
		PageHelper.startPage(pageNum, pageSize);
		
		Example example = new Example(BusinessClassify.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andCondition("pcode = '"+type+"'");
		example.orderBy("pcode").asc().orderBy("pinyin").asc().orderBy("reserve1").desc().orderBy("code").asc();
		List<BusinessClassify> list = businessClassifyMapper.selectByExample(example);
		PageInfo<BusinessClassify> pageInfo = new PageInfo<BusinessClassify>(list);
		return pageInfo;
	}

	@Override
	public int BusinessClassifySave(BusinessClassify businessClassify) {
		if (StringUtils.isNotBlank(businessClassify.getId())) {
			return this.businessClassifyMapper.updateByPrimaryKeySelective(businessClassify);
		}
		businessClassify.setId(UUID.randomUUID().toString());
		String pcode = businessClassify.getPcode();
		if ("01".equals(pcode)) {
			businessClassify.setPname("轿车客车");
		}else if ("02".equals(pcode)) {
			businessClassify.setPname("单项易损");
		}else if ("03".equals(pcode)) {
			businessClassify.setPname("汽车用品");
		}else if ("04".equals(pcode)) {
			businessClassify.setPname("重汽轻卡");
		}
		//根据pcode获取当前最大编码
		String maxCode = businessClassifyMapper.selectMaxCodeOfClassify(pcode);
		if(StringUtils.isBlank(maxCode)) {
			maxCode = pcode+"001";
		}else {
			maxCode = "0"+(Integer.parseInt(maxCode)+1);
		}
		businessClassify.setCode(maxCode);
		//根据pcode获取当前是否已有拼音首字母
		String simplePinYin = businessClassify.getPinyin();
		if (StringUtils.isNotBlank(simplePinYin)) {
			if (isHasSimplePinYin(pcode,simplePinYin) == 0) {
				businessClassify.setReserve1("Y");
			}else {
				businessClassify.setReserve1("N");
			}
		}
		return this.businessClassifyMapper.insert(businessClassify);
	}

	private int isHasSimplePinYin(String pcode, String simplePinYin) {
		BusinessClassify businessClassify = new BusinessClassify();
		businessClassify.setPcode(pcode);
		businessClassify.setPinyin(simplePinYin);
		return businessClassifyMapper.selectCount(businessClassify);
	}

	@Override
	public int delClassifyById(String id) {
		return businessClassifyMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<BusinessClassify> listClassifyWx(String type) {
		Example example = new Example(BusinessClassify.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andCondition("pcode = '"+type+"'");
		example.orderBy("pinyin").asc().orderBy("reserve1").desc().orderBy("code").asc();
		return businessClassifyMapper.selectByExample(example);
	}

	@Override
	public List<BusinessClassify> selectClassify(String title) {
		Example example = new Example(BusinessClassify.class);
		Example.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(title)) {
//			criteria.andCondition("name like '%"+title+"'%");
			criteria.andLike("name", title);
		}
		example.orderBy("pinyin").asc().orderBy("reserve1").desc().orderBy("code").asc();
		return businessClassifyMapper.selectByExample(example);
	}


	
}
