import java.io.*;
import java.util.*;
import java.text.*;

public class ExcelFilter{

	ArrayList<EAR> ears;
	ArrayList<EAR> puuloa;
	ArrayList<EAR> usmc;
	ArrayList<EAR> aav;
	ArrayList<EAR> ods;
	ArrayList<EAR> ccs;
	ArrayList<EAR> ismt;

	public static void main(String [] args){

		new ExcelFilter();

	}

	public ExcelFilter(){

		try{
			Scanner input = new Scanner(new File("C:\\Users\\user\\Desktop\\CodeHelp\\Work\\Asset.csv"));
			ears = new ArrayList<EAR>();
			puuloa = new ArrayList<EAR>();
			usmc = new ArrayList<EAR>();
			aav = new ArrayList<EAR>();
			ods = new ArrayList<EAR>();
			ccs = new ArrayList<EAR>();
			ismt = new ArrayList<EAR>();

			while(input.hasNextLine()){
				String in = input.nextLine();
				String[] ins = in.split(";");
				//if(ins.length != 6) System.out.println("Line "+i+" has "+ins.length+" elements");
				if(ins.length >5 ){
					CMD cmd = new CMD(ins[0],ins[1],ins[2],ins[3],ins[4],ins[5]);
					EAR ear = new EAR(cmd.getLocation(), cmd.getModel(), cmd.getSN(), cmd.getUnit());
					if(ear.getLocation() != null){
						if(ear.getLocation() == "Puuloa") puuloa.add(ear);
						if(ear.getLocation() == "CCS") ccs.add(ear);
						if(ear.getLocation() == "ODS") ods.add(ear);
						if(ear.getLocation() == "1045") usmc.add(ear);
						if(ear.getLocation() == "243") ismt.add(ear);
						if(ear.getLocation() == "AAV") aav.add(ear);
						ears.add(ear);
					} 
				}
			}
			writeFile();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}

	public void writeFile(){
		try{
			//PrintWriter output = new PrintWriter("C:\\Users\\user\\Desktop\\CodeHelp\\Work\\EAR.csv");
			PrintWriter output = new PrintWriter("C:\\Users\\user\\Desktop\\CodeHelp\\Work\\Puuloa.csv");
			for(EAR ear : puuloa){
				output.println(ear.toString());
			}
			output.close();
			
			output = new PrintWriter("C:\\Users\\user\\Desktop\\CodeHelp\\Work\\CCS.csv");
			for(EAR ear : ccs){
				output.println(ear.toString());
			}
			output.close();

			output = new PrintWriter("C:\\Users\\user\\Desktop\\CodeHelp\\Work\\ODS.csv");
			for(EAR ear : ods){
				output.println(ear.toString());
			}
			output.close();

			output = new PrintWriter("C:\\Users\\user\\Desktop\\CodeHelp\\Work\\AAV.csv");
			for(EAR ear : aav){
				output.println(ear.toString());
			}
			output.close();

			output = new PrintWriter("C:\\Users\\user\\Desktop\\CodeHelp\\Work\\1045.csv");
			for(EAR ear : usmc){
				output.println(ear.toString());
			}
			output.close();

			output = new PrintWriter("C:\\Users\\user\\Desktop\\CodeHelp\\Work\\243.csv");
			for(EAR ear : ismt){
				output.println(ear.toString());
			}
			output.close();

			output = new PrintWriter("C:\\Users\\user\\Desktop\\CodeHelp\\Work\\EAR.csv");
			for(EAR ear : ears){
				output.println(ear.toString());
			}
			output.close();

		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}



	

}