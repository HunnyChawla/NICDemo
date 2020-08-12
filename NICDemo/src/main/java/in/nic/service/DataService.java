package in.nic.service;

import java.util.List;

import org.springframework.data.domain.Page;

import in.nic.model.CompanyDetails;

public interface DataService {
	public List<CompanyDetails> getData();
	public List<CompanyDetails> getData(String cname, String cin, String city, String postcode);
	public List<CompanyDetails> getData(CompanyDetails cd);
	public Page<CompanyDetails> getData(CompanyDetails cd, int pageNo, int pageSize);
}
