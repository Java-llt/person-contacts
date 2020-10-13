package ad.mapper;

import ad.pojo.BusinessClassify;
import ad.utils.MyMapper;

public interface BusinessClassifyMapper extends MyMapper<BusinessClassify> {

	String selectMaxCodeOfClassify(String pcode);
}