package ad.mapper;

import ad.pojo.Company;
import ad.utils.MyMapper;

public interface CompanyMapper extends MyMapper<Company> {

	int delCompanyByIds(String companyIds);
}