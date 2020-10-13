package ad.utils;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;

import tk.mybatis.mapper.provider.SpecialProvider;

public interface InsertUidListMapper<T> {
	/**
	 * ======如果主键不是id怎么用？========== 假设主键的属性名是uid,那么新建一个Mapper接口如下
	 * 
	 * <pre>
	    public interface InsertUidListMapper<T> {
	        &#64;Options(useGeneratedKeys = true, keyProperty = "uid")
	        &#64;InsertProvider(type = SpecialProvider.class, method = "dynamicSQL")
	        int insertList(List<T> recordList);
	    }
	 * 只要修改keyProperty = "uid"就可以
	 *
	 * 然后让你自己的Mapper继承InsertUidListMapper<T>即可
	 *
	 * </pre>
	 */
//	@Options(useGeneratedKeys = true, keyProperty = "uid")
//	@InsertProvider(type = SpecialProvider.class, method = "dynamicSQL")
//	int insertList(List<T> recordList);
}