import java.io.*;
import java.util.*;
import java.text.*;

public class ExcelFilter{

	ArrayList<EAR> ears;

	public static void main(String [] args){

		new ExcelFilter();

	}

	public ExcelFilter(){

		try{
			Scanner input = new Scanner(new File("C:\\Users\\user\\Desktop\\CodeHelp\\Work\\cmd.csv"));
			ears = new ArrayList<EAR>();
			while(input.hasNextLine()){
				String in = input.nextLine();
				String[] ins = in.split(";");
				//if(ins.length != 6) System.out.println("Line "+i+" has "+ins.length+" elements");
				if(ins.length >5 ){
					CMD cmd = new CMD(ins[0],ins[1],ins[2],ins[3],ins[4],ins[5]);
					EAR ear = new EAR(cmd.getLocation(), cmd.getModel(), cmd.getSN(), cmd.getUnit());
					if(ear.getLocation() != null){
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
			PrintWriter output = new PrintWriter("C:\\Users\\user\\Desktop\\CodeHelp\\Work\\EAR.csv");
			for(EAR ear : ears){
				output.println(ear.toString());
			}
			output.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}



	

}