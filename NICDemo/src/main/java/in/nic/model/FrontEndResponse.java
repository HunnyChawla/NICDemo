package in.nic.model;

import java.util.List;

public class FrontEndResponse {
	private List<CompanyDetails> cd;
	private int totalPages;
	public FrontEndResponse(List<CompanyDetails> list, int totalPages) {
		super();
		this.cd = list;
		this.totalPages = totalPages;
	}
	public List<CompanyDetails> getCd() {
		return cd;
	}
	public void setCd(List<CompanyDetails> cd) {
		this.cd = cd;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	@Override
	public String toString() {
		return "FrontEndResponse [cd=" + cd + ", totalPages=" + totalPages + "]";
	}
	
}
