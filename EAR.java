public class EAR{

	private String systemDescription;
	private String nomenclature;
	private String serialNumber;
	private String location;
	private String subLocation;
	private String partNumber;

	public EAR(String subLocation, String model, String sn, String unit){
		setDescription(unit);
		this.nomenclature = model;
		this.serialNumber = sn;
		setLocation(unit);
		this.subLocation = subLocation;
		checkForPartNumber(model);
		setNomenclature();
	}
	
	public void setDescription(String s){
		if(s.contains("[131454]")) this.systemDescription = "ISMT-III";
		if(s.contains("[2300006]")) this.systemDescription = "CCS";
		if(s.contains("[3300005]")) this.systemDescription = "ODS";		
		if(s.contains("[5300004]")) this.systemDescription = "AAV-TT";
		if(s.contains("[130256]")) this.systemDescription = "ISMT-III";
		if(s.contains("[130302]")) this.systemDescription = "ISMT-III";
	}

	public void setLocation(String s){
		if(s.contains("[131454]")) this.location = "Puuloa";
		if(s.contains("[2300006]")) this.location = "CCS";
		if(s.contains("[3300005]")) this.location = "ODS";		
		if(s.contains("[5300004]")) this.location = "AAV";
		if(s.contains("[130256]")) this.location = "1045";
		if(s.contains("[130302]")) this.location = "243";
	}

	public String getLocation(){
		return location;
	}

	public void setPartNumber(String s){
		String ss = s.replaceAll("[\\[\\]()\"]","");
		this.partNumber = ss;
	}

	public void checkForPartNumber(String s){
		String string = s.replaceAll("\"","");
		String [] ss = string.trim().split(" ");
		if(ss[ss.length - 1].startsWith("[") || ss[ss.length - 1].startsWith("(")){
			if(ss[ss.length - 2].startsWith("(") || ss[ss.length - 2].startsWith("[")) setPartNumber(ss[ss.length - 2]);
			else setPartNumber(ss[ss.length - 1]);
		}

	}

	public void setNomenclature(){
		this.nomenclature = nomenclature.replace("\"", "");
	}

	public String getNomenclature(){
		return nomenclature;
	}

	public String toString(){
		if(partNumber != null) return ";"+systemDescription+";"+nomenclature+";;"+serialNumber+";"+partNumber+";;;;;;;;;;"+location+";"+subLocation;
		else return ";"+systemDescription+";"+nomenclature+";;"+serialNumber+";;;;;;;;;;;"+location+";"+subLocation;
	}
}