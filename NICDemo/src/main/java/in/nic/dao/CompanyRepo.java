package in.nic.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import in.nic.model.CompanyDetails;

@Repository
public interface CompanyRepo extends JpaRepository<CompanyDetails, Integer>, JpaSpecificationExecutor<CompanyDetails> , PagingAndSortingRepository<CompanyDetails, Integer>{
	@Query("select c from CompanyDetails c where c.name=?1  and c.cin = ?2")
	public List<CompanyDetails> getCompanyDetails(String name, String cname);
	@Query("select c from CompanyDetails c where c.name=?1  and c.cin = ?2 and c.city = ?3 ")
	public List<CompanyDetails> getCompanyDetails(String name, String cname, String city);
	@Query("select c from CompanyDetails c where c.name=?1  and c.cin = ?2 and c.city = ?3 and c.postalcode = ?4")
	public List<CompanyDetails> getCompanyDetails(String name, String cin, String city, String postalcode);
}
