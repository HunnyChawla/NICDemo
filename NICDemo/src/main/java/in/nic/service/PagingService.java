package in.nic.service;

import java.util.List;

import in.nic.model.CompanyDetails;

public interface PagingService {
	List<CompanyDetails> findPaginated(int pageNo, int pageSize);
}
