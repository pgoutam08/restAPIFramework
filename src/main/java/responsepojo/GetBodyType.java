package responsepojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetBodyType {

	@SerializedName("code")
	@Expose
	private String code;
	@SerializedName("value")
	@Expose
	private String value;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}