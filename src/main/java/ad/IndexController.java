package ad;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/indexController")
public class IndexController {
	
	@RequestMapping("/toIndex")
	public String toSlideshow() {
		return "index";
	}
	@RequestMapping("/toNews")
	public String toNews() {
		return "manage/news-manage";
	}
	@RequestMapping("/toClassify")
	public ModelAndView toClassify(String type) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("type", type);
		mv.setViewName("manage/classify-manage");
		return mv;
	}
	
}
