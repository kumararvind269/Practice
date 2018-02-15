package java8.optional;

public class Insurance {

	private int insureId;
	
	private String insureName;

	
	public Insurance(int insureId, String insureName) {
		super();
		this.insureId = insureId;
		this.insureName = insureName;
	}

	public int getInsureId() {
		return insureId;
	}

	public void setInsureId(int insureId) {
		this.insureId = insureId;
	}

	public String getInsureName() {
		return insureName;
	}

	public void setInsureName(String insureName) {
		this.insureName = insureName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + insureId;
		result = prime * result + ((insureName == null) ? 0 : insureName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Insurance other = (Insurance) obj;
		if (insureId != other.insureId)
			return false;
		if (insureName == null) {
			if (other.insureName != null)
				return false;
		} else if (!insureName.equals(other.insureName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Insurance [insureId=" + insureId + ", insureName=" + insureName + "]";
	}
	
	
	
}
