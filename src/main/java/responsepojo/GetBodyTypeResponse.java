package responsepojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetBodyTypeResponse {

	@SerializedName("getBodyTypes")
	@Expose
	private List<GetBodyType> getBodyTypes = null;

	public List<GetBodyType> getGetBodyTypes() {
		return getBodyTypes;
	}

	public void setGetBodyTypes(List<GetBodyType> getBodyTypes) {
		this.getBodyTypes = getBodyTypes;
	}

}