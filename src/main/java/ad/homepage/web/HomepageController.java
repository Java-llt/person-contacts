package ad.homepage.web;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;

import ad.homepage.service.HomepageService;
import ad.pojo.BusinessClassify;
import ad.pojo.Company;
import ad.pojo.News;
import ad.pojo.TelCallRecord;
import ad.pojo.Users;
import ad.utils.DateUtil;
import ad.utils.HttpUtil;
import ad.utils.IMoocJSONResult;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/homepageController")
public class HomepageController {
	
	@Autowired
	private HomepageService homepageService;
	
	@RequestMapping("/toCompanyAddPage")
	public ModelAndView toCompanyAddPage(String companyData) {
		ModelAndView mv = new ModelAndView();
		Company company = new Company();
		if (StringUtils.isNotBlank(companyData)) {
			JSONObject jsonObject = JSONObject.fromObject(companyData);
			company = (Company) JSONObject.toBean(jsonObject, Company.class);
//			Company dbCompany = homepageService.getCompanyById(company.getCompanyId());
//			if (StringUtils.isNotBlank(dbCompany.getHomepageSlideshow())) {
//				String slideshowFileStr = Base64ToImage(dbCompany.getHomepageSlideshow(),"C:/mediaFile/homepageSlideshow");
//				company.setHomepageSlideshow("/homepageSlideshow/"+slideshowFileStr);
//			}
//			if (StringUtils.isNotBlank(dbCompany.getListMiniPic())) {
//				String listminiFileStr = Base64ToImage(dbCompany.getListMiniPic(),"C:/mediaFile/listMiniPic");
//				company.setListMiniPic("/listMiniPic/"+listminiFileStr);
//			}
		}
		mv.addObject("company", company);
		mv.setViewName("/manage/customer-edit");
		return mv;
	}
	
	
	@RequestMapping("/toNewsEditPage")
	public ModelAndView toNewsEditPage(String newsData) {
		ModelAndView mv = new ModelAndView();
		News news = new News();
		if (StringUtils.isNotBlank(newsData)) {
			JSONObject jsonObject = JSONObject.fromObject(newsData);
			news = (News) JSONObject.toBean(jsonObject, News.class);
		}
		mv.addObject("news", news);
		mv.setViewName("/manage/news-edit");
		return mv;
	}
	
	@RequestMapping("/toClassifyEditPage")
	public ModelAndView toClassifyEditPage(String data, String type) {
		ModelAndView mv = new ModelAndView();
		BusinessClassify classify = new BusinessClassify();
		if (StringUtils.isNotBlank(data)) {
			JSONObject jsonObject = JSONObject.fromObject(data);
			classify = (BusinessClassify) JSONObject.toBean(jsonObject, BusinessClassify.class);
		}
		mv.addObject("data", classify);
		mv.addObject("type", type);
		mv.setViewName("/manage/classify-edit");
		return mv;
	}
	
	@RequestMapping("/toClassifySelectPage")
	public ModelAndView toClassifySelectPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/manage/classify-select");
		return mv;
	}
	
	
	@RequestMapping("/listCompany")
	public@ResponseBody IMoocJSONResult listCompany(@RequestParam Map<String, String> paramMap) {
		PageInfo<Company> pageInfo = homepageService.listCompany(paramMap);
		return IMoocJSONResult.layuiData(0, "OK", pageInfo.getTotal(), pageInfo.getList());
	}
	
	@RequestMapping("/selectClassify")
	public@ResponseBody IMoocJSONResult selectClassify(String title) {
		List<BusinessClassify> list = homepageService.selectClassify(title);
		return IMoocJSONResult.build(0, "", list);
	}
	
	@RequestMapping("/listNews")
	public@ResponseBody IMoocJSONResult listNews(@RequestParam Map<String, String> paramMap) {
		PageInfo<News> pageInfo = homepageService.listNews(paramMap);
		return IMoocJSONResult.layuiData(0, "OK", pageInfo.getTotal(), pageInfo.getList());
	}
	
	@RequestMapping("/listClassify")
	public@ResponseBody IMoocJSONResult listClassify(@RequestParam Map<String, String> paramMap, String type) {
		PageInfo<BusinessClassify> pageInfo = homepageService.listClassify(paramMap, type);
		return IMoocJSONResult.layuiData(0, "OK", pageInfo.getTotal(), pageInfo.getList());
	}
	
	@RequestMapping(value = "/uploadNewsPic", method = RequestMethod.POST)
	public@ResponseBody IMoocJSONResult uploadNewsPic(MultipartFile file) throws IllegalStateException, IOException {
		String fileName = file.getOriginalFilename();
		fileName = UUID.randomUUID().toString()+fileName.substring(fileName.lastIndexOf('.'));
		File dirFile = new File("C:/mediaFile/news");
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
		File newFile = new File(dirFile, fileName);
		file.transferTo(newFile);
		return IMoocJSONResult.ok("/news/"+fileName);
	}
	
	@RequestMapping(value = "/uploadClassifyIcon", method = RequestMethod.POST)
	public@ResponseBody IMoocJSONResult uploadClassifyIcon(MultipartFile file) throws IllegalStateException, IOException {
		String fileName = file.getOriginalFilename();
		fileName = UUID.randomUUID().toString()+fileName.substring(fileName.lastIndexOf('.'));
		File dirFile = new File("C:/mediaFile/classifyIcon");
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
		File newFile = new File(dirFile, fileName);
		file.transferTo(newFile);
		return IMoocJSONResult.ok("/classifyIcon/"+fileName);
	}
	
	@RequestMapping(value = "/uploadHomepageSlideshow", method = RequestMethod.POST)
	public@ResponseBody IMoocJSONResult uploadHomepageSlideshow(MultipartFile file) throws IllegalStateException, IOException {
		String fileName = file.getOriginalFilename();
		fileName = UUID.randomUUID().toString()+fileName.substring(fileName.lastIndexOf('.'));
		File dirFile = new File("C:/mediaFile/homepageSlideshow");
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
		File newFile = new File(dirFile, fileName);
		file.transferTo(newFile);
		return IMoocJSONResult.ok("/homepageSlideshow/"+fileName);
	}
	

	@RequestMapping("/uploadListMiniPic")
	public@ResponseBody IMoocJSONResult uploadListMiniPic(MultipartFile file) throws IllegalStateException, IOException {
		String fileName = file.getOriginalFilename();
		fileName = UUID.randomUUID().toString()+fileName.substring(fileName.lastIndexOf('.'));
		File dirFile = new File("C:/mediaFile/listMiniPic");
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
		File newFile = new File(dirFile, fileName);
		file.transferTo(newFile);
		return IMoocJSONResult.ok("/listMiniPic/"+fileName);
	}
	
	@RequestMapping("/companySave")
	public@ResponseBody IMoocJSONResult companySave(String companyData) {
		JSONObject jsonObject = JSONObject.fromObject(companyData);
		Company company = (Company) JSONObject.toBean(jsonObject, Company.class);
//		company.setHomepageSlideshow(ImageToBase64ByLocal("C:/mediaFile"+company.getHomepageSlideshow()));
//		company.setListMiniPic(ImageToBase64ByLocal("C:/mediaFile"+company.getListMiniPic()));
		int status = this.homepageService.companySave(company);
		String msg = "";
		if (status == 1) {
			status = 200;
			msg = "保存成功";
		}else {
			status = 500;
			msg = "保存失败，请重新填写或联系管理员...";
		}
		return IMoocJSONResult.build(status, msg, "");
	}
	
	@RequestMapping("/newsSave")
	public@ResponseBody IMoocJSONResult newsSave(String newsData) {
		JSONObject jsonObject = JSONObject.fromObject(newsData);
		News news = (News) JSONObject.toBean(jsonObject, News.class);
		int status = this.homepageService.newsSave(news);
		String msg = "";
		if (status == 1) {
			status = 200;
			msg = "保存成功";
		}else {
			status = 500;
			msg = "保存失败，请重新填写或联系管理员...";
		}
		return IMoocJSONResult.build(status, msg, "");
	}
	
	@RequestMapping("/BusinessClassifySave")
	public@ResponseBody IMoocJSONResult BusinessClassifySave(String data) {
		JSONObject jsonObject = JSONObject.fromObject(data);
		BusinessClassify businessClassify = (BusinessClassify) JSONObject.toBean(jsonObject, BusinessClassify.class);
		int status = this.homepageService.BusinessClassifySave(businessClassify);
		String msg = "";
		if (status == 1) {
			status = 200;
			msg = "保存成功";
		}else {
			status = 500;
			msg = "保存失败，请重新填写或联系管理员...";
		}
		return IMoocJSONResult.build(status, msg, "");
	}
	
	@RequestMapping("/delCompanyByIds")
	public@ResponseBody IMoocJSONResult delCompanyByIds(String companyIds) {
		int status = this.homepageService.delCompanyByIds(companyIds);
		String msg = "";
		if (status > 0) {
			status = 200;
			msg = "删除成功";
		}else {
			status = 500;
			msg = "删除失败，请重新填写或联系管理员...";
		}
		return IMoocJSONResult.build(status, msg, "");
	}
	
	@RequestMapping("/delNewsById")
	public@ResponseBody IMoocJSONResult delNewsById(String id) {
		int status = this.homepageService.delNewsById(id);
		String msg = "";
		if (status > 0) {
			status = 200;
			msg = "删除成功";
		}else {
			status = 500;
			msg = "删除失败，请重新填写或联系管理员...";
		}
		return IMoocJSONResult.build(status, msg, "");
	}
	
	@RequestMapping("/delClassifyById")
	public@ResponseBody IMoocJSONResult delClassifyById(String id) {
		int status = this.homepageService.delClassifyById(id);
		String msg = "";
		if (status > 0) {
			status = 200;
			msg = "删除成功";
		}else {
			status = 500;
			msg = "删除失败，请重新填写或联系管理员...";
		}
		return IMoocJSONResult.build(status, msg, "");
	}
	
	@RequestMapping("/publishNews")
	public@ResponseBody IMoocJSONResult publishNews(String id) {
		int status = this.homepageService.publishNews(id);
		String msg = "";
		if (status > 0) {
			status = 200;
			msg = "发布成功";
		}else {
			status = 500;
			msg = "发布失败，请重新填写或联系管理员...";
		}
		return IMoocJSONResult.build(status, msg, "");
	}
	
	
	/***
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	@RequestMapping("/importCompanyDatas")
	@ResponseBody
	public String importCompanyDatas (@RequestParam("file") MultipartFile file) throws IOException{
		InputStream inputStream;
		HSSFWorkbook book; 
		HSSFSheet sheet;
		HSSFRow row;
		inputStream = file.getInputStream();
		book = new HSSFWorkbook(inputStream); 
		sheet = book.getSheetAt(0);
		int totalRowNum = sheet.getLastRowNum()+1;
		List<Company> allList = new ArrayList<>();
		row = sheet.getRow(1);
		List<Object> keyList = new ArrayList<Object>();
		int cellNum = row.getLastCellNum();
		for (int j = 0; j < cellNum; j++) {
			keyList.add(getCellValue(row.getCell(j)));
		}
		for (int i = 2; i < totalRowNum; i++) {
			row = sheet.getRow(i);
			if (row == null) {
				break;
			}
			Map<String, Object> map = new HashMap<String, Object>();
			int k = 0;
 			for (int j = 0; j < cellNum; j++) {
				if("".equals(getCellValue(row.getCell(j)))){
					k++;
				}
				map.put(keyList.get(j).toString(), getCellValue(row.getCell(j)));
			}
			if(k == cellNum){
				break;
			}
			Company company = JSON.parseObject(JSON.toJSONString(map), Company.class);
			company.setCompanyId(UUID.randomUUID().toString());
			company.setTs(new Date());
			company.setIsDeleted(false);
			allList.add(company);
		}
	
		homepageService.importCompanyDatas(allList);
		return "导入成功!";
	}
	
	
	/**
	 * 判断单元格值的类型
	 * @param cell 单元格实体
	 * @return value 单元格中的值
	 * */
	private String getCellValue(HSSFCell cell){
		String cellValue = "";
		if (cell == null) {
			return cellValue;
		}
		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_STRING://字符串
			cellValue = cell.getRichStringCellValue().toString().trim();
			break;
		case HSSFCell.CELL_TYPE_BLANK://空值
			cellValue = "";
			break;
		case HSSFCell.CELL_TYPE_BOOLEAN://布尔
			cellValue = String.valueOf(cell.getBooleanCellValue()).trim();
			break;
		case HSSFCell.CELL_TYPE_NUMERIC://数字
			if (HSSFDateUtil.isCellDateFormatted(cell)) {//yyyy年m月d日--- 180
				Date date = cell.getDateCellValue();
				cellValue = DateUtil.formatDate(date, "yyyy-MM-dd");
			} else {
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cellValue = cell.getRichStringCellValue().toString().trim();
//				cellValue = String.valueOf(cell.getNumericCellValue());
			}
			break;
		case HSSFCell.CELL_TYPE_FORMULA://公式
			cellValue = "";
			break;
		case HSSFCell.CELL_TYPE_ERROR://故障
			cellValue = "error";
			break;
			
		default:
			break;
		}
		return cellValue;
	}
	
	
	@RequestMapping("/listTelRecord.wx")
	public@ResponseBody List<TelCallRecord> listTelRecordWx(String openid) {
		return this.homepageService.listMyTelRecord(openid);
	}
	
	@RequestMapping("/listNews.wx")
	public@ResponseBody List<News> listNewsWx() {
		return this.homepageService.listNewsWx();
	}
	
	@RequestMapping("/listCompany.wx")
	public@ResponseBody List<Company> listCompanyWx() {
		return this.homepageService.listCompanyWx();
	}
	
	@RequestMapping("/listCompanyByClassify.wx")
	public@ResponseBody List<Company> listCompanyByClassifyWx(String code, String name) {
		return this.homepageService.listCompanyByClassifyWx(code, name);
	}
	
	@RequestMapping("/listClassify.wx")
	public@ResponseBody List<BusinessClassify> listClassifyWx(String type) {
		return this.homepageService.listClassifyWx(type);
	}

	
	private String appId = "wx332ab31b839984da";
	private String grantType = "authorization_code";
//	private String appSecret = "xiaotao666888";
	private String appSecret = "52fec7f5601f538196e56f61671d30a9";
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/getSession.wx")
	public@ResponseBody Map<String, Object> getSessionWx(String code) {
		String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+appId+"&secret="+appSecret+"&js_code="+code+"&grant_type="+grantType;  
        // 发送请求  
        String data = HttpUtil.get(url);  
        ObjectMapper mapper = new ObjectMapper();  
        Map<String, Object> json = null;  
        try {  
            json = mapper.readValue(data, Map.class);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        // 形如{"session_key":"6w7Br3JsRQzBiGZwvlZAiA==","openid":"oQO565cXXXXXEvc4Q_YChUE8PqB60Y"}的字符串  
        return json;  
	}
	
	@RequestMapping("/saveUserInfo.wx")
	public@ResponseBody IMoocJSONResult saveUserInfoWx(String openid, String avatarUrl, String nickName, boolean gender, String tel) {
		Users user = new Users();
		user.setOpenid(openid);
		user.setAvatarUrl(avatarUrl);
		user.setNickname(nickName);
		user.setUserAddress("");
		user.setGender(gender);
		user.setTel(tel);
		user.setId(UUID.randomUUID().toString());
		user.setCreateTime(new Date());
		user.setTs(new Date());
		int status = this.homepageService.userSave(user);
		String msg = "";
		if (status == 1) {
			status = 200;
			msg = "保存成功";
		}else {
			status = 500;
			msg = "保存失败，请重新填写或联系管理员...";
		}
		return IMoocJSONResult.build(status, msg, ""); 
	}
	
	@RequestMapping("/getUserRegInfo.wx")
	public@ResponseBody IMoocJSONResult getUserRegInfoWx(String openid) {
		int status = this.homepageService.getUserRegInfoWx(openid);
		String msg = "";
		if (status == 1) {
			status = 200;
			msg = "保存成功";
		}else {
			status = 500;
			msg = "保存失败，请重新填写或联系管理员...";
		}
		return IMoocJSONResult.build(status, msg, ""); 
	}
	
	@RequestMapping("/getCompanyDetailById.wx")
	public@ResponseBody IMoocJSONResult getCompanyDetailByIdWx(String companyid) {
		Company company = this.homepageService.getCompanyById(companyid);
		JSONObject jsonObject = JSONObject.fromObject(company);
		String telStr = company.getCompanyTel();
		String tel[] = telStr.split(",");
		jsonObject.put("tels", tel);
		return IMoocJSONResult.ok(jsonObject.toString()); 
	}
	
	@RequestMapping("/getNewsDetailById.wx")
	public@ResponseBody IMoocJSONResult getNewsDetailByIdWx(String id) {
		return IMoocJSONResult.ok(this.homepageService.getNewsById(id)); 
	}
	
	@RequestMapping("/getUserInfo.wx")
	public@ResponseBody IMoocJSONResult getUserInfoWx(String openid) {
		Users user = this.homepageService.getUserByopenid(openid);
		return IMoocJSONResult.ok(user); 
	}
	
	@RequestMapping("/updateUserInfo.wx")
	public@ResponseBody IMoocJSONResult updateUserInfoWx(String openid, String param, String paramtype) {
		Users user = new Users();
		user.setOpenid(openid);
		if ("nickname".equalsIgnoreCase(paramtype)) {
			user.setNickname(param);
		}else if ("tel".equalsIgnoreCase(paramtype)) {
			user.setTel(param);
		}else if ("address".equalsIgnoreCase(paramtype)) {
			user.setUserAddress(param);
		}
		int status = this.homepageService.updateUser(user);
		String msg = "";
		if (status == 1) {
			status = 200;
			msg = "保存成功";
		}else {
			status = 500;
			msg = "保存失败，请重新填写或联系管理员...";
		}
		return IMoocJSONResult.build(status, msg, "");
	}
	
	
	@RequestMapping("/saveTelCallRecord.wx")
	public@ResponseBody IMoocJSONResult saveTelCallRecordWx(String openid, String companyid, String companyname, String tel) throws UnsupportedEncodingException {
		TelCallRecord telCallRecord = new TelCallRecord();
		telCallRecord.setId(UUID.randomUUID().toString());
		telCallRecord.setOpenid(openid);
		telCallRecord.setCompanyId(companyid);
		telCallRecord.setCompanyName(companyname);
		telCallRecord.setTel(tel);
		telCallRecord.setTs(DateUtil.formatDate(new Date()));
		int status = this.homepageService.saveTelCallRecord(telCallRecord);
		String msg = "";
		if (status == 1) {
			status = 200;
			msg = "保存成功";
		}else {
			status = 500;
			msg = "保存失败，请重新填写或联系管理员...";
		}
		return IMoocJSONResult.build(status, msg, "");
	}
	
	/**
	 * 本地图片转换成base64字符串
	 * 
	 * @param targetFilePath 图片本地路径
	 * @return String 图片base64字符串
	 */
//	public static String ImageToBase64ByLocal(String targetFilePath) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
//		InputStream in = null;
//		byte[] data = null;
//
//		// 读取图片字节数组
//		try {
//			in = new FileInputStream(targetFilePath);
//			data = new byte[in.available()];
//			in.read(data);
//			in.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			// 删除临时文件
//			File tempFile = new File(targetFilePath);
//			if (tempFile.exists()) {
//				tempFile.delete();
//			}
//		}
//
//		// 对字节数组Base64编码
//		return "data:image/png;base64," + new BASE64Encoder().encode(data);// 返回Base64编码过的字节数组字符串
//	}
//
//	/**
//	 * base64字符串转换成图片
//	 * 
//	 * @param imgStr base64字符串
//	 * @param imgFilePath 图片存放路径
//	 * @return
//	 */
//	public String Base64ToImage(String imgStr, String imgFilePath) { // 对字节数组字符串进行Base64解码并生成图片
//		if (imgStr == null){
//            return "N";
//        }
//        Base64 decoder = new Base64();
//        try{
//        	//Base64解码 
//        	int j = imgStr.lastIndexOf(",");
//        	imgStr = imgStr.substring(j+1,imgStr.length()-1);
//            byte[] b = decoder.decode(imgStr);
//            for(int i=0;i<b.length;++i){
//                if(b[i]<0)
//                {//调整异常数据 
//                    b[i]+=256;
//                }
//            }
//            //String filePath=ConfigProvider.getPropertiesValue("config.properties", "rootPath");
//            //生成jpg图片
////            String imgFilePath = "C:/mediaFile/homepageSlideshow";//新生成的图片
//			File newFile = new File(imgFilePath,"");
//            if(!newFile.exists()) {
//                newFile.mkdirs();
//            }
//            String fileFileName =UUID.randomUUID().toString() + ".jpg";
//            OutputStream out = new FileOutputStream(imgFilePath+File.separator+fileFileName);
//            out.write(b);
//            out.flush();
//            out.close();
//            return fileFileName;
//        }catch (Exception e){
//            return "N";
//        }
//
//	}
	
	
}
