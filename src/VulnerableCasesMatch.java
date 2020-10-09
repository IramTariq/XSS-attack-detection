
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author iram
 */
public class VulnerableCasesMatch {
    String pathof_Non_Vul_complete="D:\\dataset_thesis\\basePaper\\ExtractedData\\NonVulnerable.csv";
    List<String> Non_Vul_list = new ArrayList<>();
    List<String> Modi_list = new ArrayList<>();
    int mismatched_counter=0;
    
    
    public String modified_path(String path){
        String changed_path;
        String slash = "\\";
        String escapedSlash = slash+slash;
        String twoEscapedSlashes = escapedSlash+escapedSlash;
        changed_path=path.replaceAll(escapedSlash, twoEscapedSlashes) ;
        return changed_path;
    }
    public void readfull(){
        try{
        BufferedReader br = new BufferedReader(new FileReader(pathof_Non_Vul_complete)); //pathofnon_vulcomplete,,,,pathof_vulcomplete
        String line = br.readLine();  
        while(line != null) 
        { 
            //String modi_line=removecoma(line);
            Non_Vul_list.add(line);
            line = br.readLine(); 
        }
        br.close(); 
        }
        catch (FileNotFoundException e) {
                    System.err.println("File not found");
        }
        catch (IOException e) {
            System.err.println("Unable to read the file.");
        } 
    }
    public void read_modi(String path){
        try{
        BufferedReader br = new BufferedReader(new FileReader(path)); //path of non_vul modified file
        String line = br.readLine();  
        while(line != null) 
        { 
            //String modi_line=removecoma(line);
            Modi_list.add(line);
            line = br.readLine(); 
        }
        br.close();
        checkMatching();
        }
        catch (FileNotFoundException e) {
                    System.err.println("File not found");
        }
        catch (IOException e) {
            System.err.println("Unable to read the file.");
        } 
    }
    public void checkMatching(){
        //Non_Vul_list,Modi_list;
        for(int i=0;i<Non_Vul_list.size();i++){
            if(Non_Vul_list.get(i).equals(Modi_list.get(i).toString())==false){
                mismatched_counter++;               
            }
        }
        System.out.println("mismatched payloads are: "+ mismatched_counter);
    }
    
    
    
    
    public static void main(String[] args){
        VulnerableCasesMatch VCM=new VulnerableCasesMatch();
        VCM.readfull();
        System.out.println("Give path of modified file");
        Scanner input=new Scanner(System.in);
        String pati=input.next();
        String path=VCM.modified_path(pati);
        VCM.read_modi(path);
        
    }
}
