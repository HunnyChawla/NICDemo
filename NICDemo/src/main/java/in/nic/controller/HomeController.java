package in.nic.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import in.nic.dao.CompanyRepo;
import in.nic.model.CompanyDetails;
import in.nic.service.DataService;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	@Autowired
	private DataService DataService;
	@RequestMapping("/getCompanyDetails")
	@ResponseBody
	public ModelAndView getCompanyDetails(@PathParam("cname") String cname,  @PathParam("cin") String cin, @PathParam("city") String city, @PathParam("postalcode") String postalcode) {
		ModelAndView mv= new ModelAndView("showCompanyDetails.jsp");
		System.out.println("cname ::"+cname);
		System.out.println("cin ::"+cin);
		System.out.println("city ::"+city);
		System.out.println("postalcode ::"+postalcode);
		List<CompanyDetails> cd= DataService.getData(cname,cin,city,postalcode);
		System.out.println(cd);
		mv.addObject("data",cd);
		return mv;	
	}
}
