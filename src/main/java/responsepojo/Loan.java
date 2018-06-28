package responsepojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Loan {

	@SerializedName("loan_id")
	@Expose
	private Integer loanId;
	@SerializedName("loan_path")
	@Expose
	private String loanPath;
	@SerializedName("loan_status")
	@Expose
	private String loanStatus;

	public Integer getLoanId() {
		return loanId;
	}

	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}

	public String getLoanPath() {
		return loanPath;
	}

	public void setLoanPath(String loanPath) {
		this.loanPath = loanPath;
	}

	public String getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}

}