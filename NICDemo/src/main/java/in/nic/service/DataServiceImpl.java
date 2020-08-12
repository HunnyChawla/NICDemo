package in.nic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import in.nic.dao.CompanyRepo;
import in.nic.model.CompanyDetails;

@Service
public class DataServiceImpl implements DataService {

	@Autowired
	CompanyRepo CompanyRepo;
	public List<CompanyDetails> getData(){
		List<CompanyDetails> list=CompanyRepo.findAll();
		return list;
	}
	public List<CompanyDetails> getData(String cname, String cin, String city, String postcode){
		Specification<CompanyDetails> specification=Specification.where(cname==null || cname.equals("")?null:cnameContains(cname))
				.and(cin==null || cin.equals("")?null:cinContains(cin))
				.and(city==null || city.equals("")?null:cityContains(city))
				.and(postcode==null || postcode.equals("")?null:postCodeContains(postcode));
		Pageable paging = PageRequest.of(1, 10);
		Page<CompanyDetails> pagedResult=CompanyRepo.findAll(specification, paging);
		return pagedResult.toList();
	}
	public static Specification<CompanyDetails> cnameContains(String expression) {
	    return (root, query, builder) -> builder.equal(root.get("name"), expression);
	}
	public static Specification<CompanyDetails> cinContains(String expression) {
		return (root, query, builder) -> builder.equal(root.get("cin"), expression);
	}
	public static Specification<CompanyDetails> cityContains(String expression) {
		return (root, query, builder) -> builder.equal(root.get("city"), expression);
	}
	public static Specification<CompanyDetails> postCodeContains(String expression) {
		return (root, query, builder) -> builder.equal(root.get("postalcode"), expression);
	}
	
	public List<CompanyDetails> getData(CompanyDetails cd){
		if((cd.getName()==null || cd.getName().equals("")) && (cd.getCin()==null || cd.getCin().equals("")) && (cd.getCity()==null || cd.getCity().equals("")) && (cd.getPostalcode()==null || cd.getPostalcode().equals(""))) {
			return new ArrayList<CompanyDetails>();
		}
		Specification<CompanyDetails> specification=Specification.where(cd.getName()==null || cd.getName().equals("")?null:cnameContains(cd.getName()))
				.and(cd.getCin()==null || cd.getCin().equals("")?null:cinContains(cd.getCin()))
				.and(cd.getCity()==null || cd.getCity().equals("")?null:cityContains(cd.getCity()))
				.and(cd.getPostalcode()==null || cd.getPostalcode().equals("")?null:postCodeContains(cd.getPostalcode()));
		List<CompanyDetails> list=CompanyRepo.findAll(specification);
		return list;
	}
	public Page<CompanyDetails> getData(CompanyDetails cd,int pageNo, int pageSize){
		if((cd.getName()==null || cd.getName().equals("")) && (cd.getCin()==null || cd.getCin().equals("")) && (cd.getCity()==null || cd.getCity().equals("")) && (cd.getPostalcode()==null || cd.getPostalcode().equals(""))) {
			return null;
		}
		Specification<CompanyDetails> specification=Specification.where(cd.getName()==null || cd.getName().equals("")?null:cnameContains(cd.getName()))
				.and(cd.getCin()==null || cd.getCin().equals("")?null:cinContains(cd.getCin()))
				.and(cd.getCity()==null || cd.getCity().equals("")?null:cityContains(cd.getCity()))
				.and(cd.getPostalcode()==null || cd.getPostalcode().equals("")?null:postCodeContains(cd.getPostalcode()));
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<CompanyDetails> pagedResult=CompanyRepo.findAll(specification, paging);
		System.out.println("Total Pages : "+pagedResult.getTotalPages());
		return pagedResult;
	}
}
