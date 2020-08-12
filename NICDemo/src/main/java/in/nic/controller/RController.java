package in.nic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.nic.model.CompanyDetails;
import in.nic.model.FrontEndResponse;
import in.nic.service.DataService;
@RestController
public class RController {
	@Autowired
	private DataService dataService;
	@PostMapping("/getCompanyDetails")
	@ResponseBody
	public FrontEndResponse getCompanyDetails(CompanyDetails cd,int pageNo, int pageSize) {
		Page<CompanyDetails> page= dataService.getData(cd,pageNo,pageSize);
		if(page==null) {
			return new FrontEndResponse(new ArrayList<>(), 0);
		}
		FrontEndResponse fdr= new FrontEndResponse(page.toList(), page.getTotalPages());
		return fdr;	
	}
}
