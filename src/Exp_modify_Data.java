
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
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
public class Exp_modify_Data {
    String pathof_vulcomplete="D:\\dataset_thesis\\basePaper\\ExtractedData\\Vulnerable.csv";
    String pathofnon_vulcomplete="D:\\dataset_thesis\\basePaper\\ExtractedData\\experimenttest.csv";
    List<String> vul_list = new ArrayList<>();
    List<String> list1 = new ArrayList<>();
    List<String> full_list = new ArrayList<>();
    List<String> bari = new ArrayList<>();
    List<String> listii = new ArrayList<>();

//    public String removecoma(String line){
//        char coma=',';
//        String linewithoutcoma="";
//        for(int i=0;i<line.length();i++){
//                if(line.charAt(i)!=coma){
//                    linewithoutcoma=linewithoutcoma+line.charAt(i);
//                }
//            }
//        
//        return linewithoutcoma;
//    }
    public String modified_path(String path){
        String changed_path;
        String slash = "\\";
        String escapedSlash = slash+slash;
        String twoEscapedSlashes = escapedSlash+escapedSlash;
        changed_path=path.replaceAll(escapedSlash, twoEscapedSlashes) ;
        return changed_path;
    }
    
    
    public void storeAllVulnerableDataInList(){
        try{
        BufferedReader br = new BufferedReader(new FileReader(pathof_vulcomplete)); //pathofnon_vulcomplete,,,,pathof_vulcomplete
        String line = br.readLine();  
        while(line != null) 
        { 
            //String modi_line=removecoma(line);
            vul_list.add(line);
            line = br.readLine(); 
        }
        int ans=0;
        Scanner input=new Scanner(System.in);
        System.out.println("how much percentage of data you want to change in experimental file?");
        String in=input.next();
        if(in.equals("5")){
            ans=494; //494
            System.out.println("answer is: "+ans);
        }
        else if(in.equals("10")){
            ans=988;
            System.out.println("answer is: "+ans);
        }
        else if(in.equals("15")){
            ans=1482;
            System.out.println("answer is: "+ans);
        }
        else if(in.equals("20")){
            ans=1976;
            System.out.println("answer is: "+ans);
        }
        else if(in.equals("25")){
            ans=2470;
            System.out.println("answer is: "+ans);
        }
        else if(in.equals("30")){
            ans=2964;
            System.out.println("answer is: "+ans);
        }
        else if(in.equals("35")){
            ans=3458;
            System.out.println("answer is: "+ans);
        }
        else if(in.equals("40")){
            ans=3952;
            System.out.println("answer is: "+ans);
        }
        else if(in.equals("45")){
            ans=4446;
            System.out.println("answer is: "+ans);
        }
        int array[]=new int[ans];
        for(int i=0;i<ans;i++){
             Random r=new Random();
             int randomNumber=r.nextInt(vul_list.size());
             array[i]=randomNumber;
             for(int j=0;j<vul_list.size();j++){
                 if(randomNumber==j){
                     list1.add(vul_list.get(j));
                 }
             }
        }
        //System.out.println("Vulnerable list size is: "+list1.size());
        for(int i=0;i<list1.size();i++){        //it shows vulnerable data that will replace
            //System.out.println("list is: "+list1.get(i).toString());
        }
        for(int i=0;i<array.length;i++){    //to display indexes to replace with vulnerable
           // System.out.println(array[i]);
        }
        
        modifyExperimentalData(ans,list1,array);
        //System.out.println("Size of vulnerable list from which to match: "+vul_list.size());
        br.close(); 
        }
        catch (FileNotFoundException e) {
                    System.err.println("File not found");
        }
        catch (IOException e) {
            System.err.println("Unable to read the file.");
        } 
       //return vul_list;
    }
    
    public void modifyExperimentalData(int ans, List<String> list , int[] array){
        int [] arrayindex=new int[list.size()];
        //String [] arrayToStore=new String[full_list.size()];
        try{
        BufferedReader br = new BufferedReader(new FileReader(pathofnon_vulcomplete)); //pathofnon_vulcomplete,,,,pathof_vulcomplete
        String line = br.readLine();  
        while(line != null) 
        { 
            //String modi_line=removecoma(line);
            full_list.add(line);
            bari.add(line);
            line = br.readLine(); 
        } 
        int k=0;
        System.out.println("Size of non-vulnerable list from which to match: "+full_list.size());
        //System.out.println("size of array: "+array.length);
        for(int i=0;i<array.length;i++){
             Random r=new Random();
             int randomNumber=r.nextInt(full_list.size());
             arrayindex[i]=randomNumber;
             for(int j=0;j<full_list.size();j++){
                 if(j==randomNumber){
                     //arrayToStore[j]=list.get(k).toString();
                    // listii.add(list.get(k).toString());
                     full_list.set(j, list.get(k).toString());
                     //System.out.println("added list is: "+list.get(k).toString());
                     k++;
                 }
//                 else if(j!=randomNumber){
//                     //arrayToStore[j]=full_list.get(j).toString();
//                     listii.add(full_list.get(j).toString());
//
//                 }
             }
        }
        String [] charge=new String[full_list.size()];
        for(int i=0;i<listii.size();i++){
            charge[i]=listii.get(i);
        }
        String [] testarray=new String[full_list.size()];
        int countermismatched=0;
        for(int i=0;i<full_list.size();i++){
            if(bari.get(i).equals(full_list.get(i).toString())==false){
                countermismatched++;
            }
        }
        String[] aray=full_list.toArray(new String[0]);
        
        //System.out.println("Size of array to store: "+aray.length);
        System.out.println("mismatched are: "+countermismatched);
        int nonvul_replaced=0;                  //count number of nonvul replaced that will help in experiment
        for(int h=0;h<arrayindex.length;h++){
            if(arrayindex[h]>3462){
                nonvul_replaced++;
            }
        }
        String []data=new String[30];
        System.out.println("Total replaced are: "+k);
        System.out.println("Non Vulnerable replaced are: "+nonvul_replaced);
        System.out.println("give path of file with name and extention to store modified file"+k);        
        Scanner input=new Scanner(System.in);
        String pat=input.next();
        String path= modified_path(pat);  
        //System.out.println("array to store size is: "+aray.length);
        

        for(int i=0;i<aray.length;i++){
            insertion(path,aray[i]);
        }
//        insertion(path,arrayToStore);
        
        
        br.close(); 
        }
        catch (FileNotFoundException e) {
                    System.err.println("File not found");
                }
        catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
        
    }
    public void insertion(String storeplace,String array) throws FileNotFoundException{
        FileOutputStream fos= new FileOutputStream(storeplace,true);
        PrintWriter pw=new PrintWriter(fos);
        BufferedReader br = new BufferedReader(new FileReader(storeplace));
        //int linelength=30;
        
        try {
            if (br.readLine()==null){
                
                        pw.print(array+'\n');
                     
                }
            
            else{
                pw.print(array+'\n');
            }
        }
        catch(Exception e){
            System.err.println("Unable to write the file.");
        }
        pw.flush();
        pw.close();
    }
    
    
    
    public static void main(String[] args){
          
       Exp_modify_Data md=new Exp_modify_Data();
        
       md.storeAllVulnerableDataInList();
        
        
    }
}
