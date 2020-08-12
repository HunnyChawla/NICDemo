package in.nic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import in.nic.dao.CompanyRepo;
import in.nic.model.CompanyDetails;

public class PagingServiceImpl implements PagingService{

	@Autowired
	private CompanyRepo repo;
	@Override
	public List<CompanyDetails> findPaginated(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<CompanyDetails> pagedResult = repo.findAll(paging);

        return pagedResult.toList();
	}

}
