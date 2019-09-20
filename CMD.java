public class CMD{

	private String serialNumber;
	private String model;
	private String unit;
	private String location;
	private String logisticStatus;
	private String contractNumber;

	public CMD(){
		this.serialNumber = null;
		this.model = null;
		this.unit = null;
		this.location = null;
		this.logisticStatus = null;
		this.contractNumber	= null;
	}

	public CMD(String serialNumber, String model, String unit, String location, String logisticStatus, String contractNumber){
		this.serialNumber = serialNumber;
		this.model = model;
		this.unit = unit;
		this.location = location;
		this.logisticStatus = logisticStatus;
		this.contractNumber = contractNumber;
	}

	public String getSN(){
		return serialNumber;
	}

	public String getModel(){
		return model;
	}

	public String getUnit(){
		return unit;
	}

	public String getLocation(){
		return location;
	}


	public String toString(){
		return serialNumber+";"+model+";"+unit+";"+location+";"+logisticStatus+";"+contractNumber;
	}

}