package responsepojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetProfileResponse {

	@SerializedName("username")
	@Expose
	private String username;
	@SerializedName("loans")
	@Expose
	private List<Loan> loans = null;
	@SerializedName("crm_id")
	@Expose
	private String crmId;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}

	public String getCrmId() {
		return crmId;
	}

	public void setCrmId(String crmId) {
		this.crmId = crmId;
	}

}