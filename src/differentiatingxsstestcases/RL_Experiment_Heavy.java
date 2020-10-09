/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package differentiatingxsstestcases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author iram
 */
public class RL_Experiment_Heavy {
 int vulcount=0;             
    int nonvulcount=0;
    int undecisive=0;
    int numberOfStrings=0;
    private static Scanner x;
    private static Scanner vulx;
    private static Scanner nonx;
    boolean vulnerable=false;
    boolean nonvulnerable=false;
    String vul_boolean="D:\\dataset_thesis\\basePaper\\ExtractedData\\vulnerable\\seperateFeatures\\boolean\\nonredundant\\vul_nonred_collective\\nonred_collective.csv";
    String nonvul_boolean="D:\\dataset_thesis\\basePaper\\ExtractedData\\nonVulnerable\\seperating_features\\boolean\\nonredundant\\nonredcullective\\collective_noRedundancy.csv";
    String pathofnon_vulcomplete="D:\\dataset_thesis\\basePaper\\ExtractedData\\nonVulnerable\\total_nonvul.csv";
    String pathof_vulcomplete="D:\\dataset_thesis\\basePaper\\ExtractedData\\vulnerable\\total_vulnerability.csv";
    List<String> list = new ArrayList<>();
    List<String> list1 = new ArrayList<>();
    List<String> list2 = new ArrayList<>();
    List<String> list3 = new ArrayList<>();
    List<String> vul_list = new ArrayList<>();
    List<String> nonvul_list = new ArrayList<>();
    String [] feat={"input size","alert","script","onerror","confirm","img","onload","eval", "prompt", "src", "href", "javascript", "window","fromcharcode", "document", "onmouseover", "cookie", "domain", "onfocus","expression", "iframe", "onclick", "singleQuoteMark","doubleQuoteMark", "leftAngleBracket", "rightAngleBracket", "backslant", "coma", "plus", "httpAndFile"};
    String[] data_input=new String[feat.length];
    List<String> All_vul_list = new ArrayList<>();
    List<String> All_nonvul_list = new ArrayList<>();
    public String modified_path(String path){
        String changed_path;
        String slash = "\\";
        String escapedSlash = slash+slash;
        String twoEscapedSlashes = escapedSlash+escapedSlash;
        changed_path=path.replaceAll(escapedSlash, twoEscapedSlashes) ;
        return changed_path;
    }
    public void readin(String path,String vulpath,String nonpath){
        String[] changed=new String[feat.length];
        String[] addData=new String[feat.length];
        String[] unchanged=new String[feat.length];
        try{
            x=new Scanner(new BufferedReader(new FileReader(path))); 
            x.useDelimiter(",");
            while(x.hasNextLine()){
                int zero=0;
                String str1 = Integer.toString(zero);
                String inputline=x.nextLine();
                String[] inarray=inputline.split(",");
                changed=new String[inarray.length];
                for(int f=0;f<inarray.length;f++){
                    unchanged[f]=inarray[f];
                    changed[f]=inarray[f];
                }
                for(int i=0;i<inarray.length;i++){
                    if(inarray[i].matches(".*\\d.*")){
                        if(inarray[i].equals(str1)==false){
                            String pandiya;
                            int one=1;
                            pandiya = Integer.toString(one);
                            changed[i]=pandiya;               
                        }             
                    }
                  list.add(changed[i]);                  
                }
                for(int o=0;o<changed.length;o=o+changed.length){       ////changed[] contain data in concatenated form, so to place them in seperate cell, or to perform operation on each term seperately, there is need to split it
                                                                        //takes data in chunk whose size is equal to record size
                    for(int oi=o;oi<changed.length;oi++){               //data within each chunk is saved in array
                        System.out.print(changed[oi]);                  
                        addData[oi]=changed[oi];
                    }
//                    System.out.println("");
//                    String str = Arrays. toString(addData);
//                    System.out.println("we want to check: "+str);
//                    checkingforvulnerability(addData,vulpath,nonpath);
                }
                System.out.println("");
                String str = Arrays. toString(addData);
                System.out.println("we want to check: "+str);
                String unstr = Arrays. toString(unchanged);                
                System.out.println("unchanged data: "+unstr);                
                checkingforvulnerability(addData,vulpath,nonpath,unchanged);    
            }
            for(int i=0;i<addData.length+1;i++){
            if(i<addData.length){
                list3.add(addData[i]);
            }
        }
        }
        catch (FileNotFoundException e) {
                    System.err.println("File not found");
                }
        
        
        
    }
    public void checkingforvulnerability(String[] array,String vulpath,String nonpath,String[] dat){
        String [] feat={"input size","alert","script","onerror","confirm","img","onload","eval", "prompt", "src", "href", "javascript", "window","fromcharcode", "document", "onmouseover", "cookie", "domain", "onfocus","expression", "iframe", "onclick", "singleQuoteMark","doubleQuoteMark", "leftAngleBracket", "rightAngleBracket", "backslant", "coma", "plus", "httpAndFile"};
        
        //System.out.println("arrays length is: "+array.length);
        String vultargetChromosome="";
        String nontargetChromosome="";
        //getting vultargetchromosome for comparison
        try{
            vulx=new Scanner(new BufferedReader(new FileReader(vulpath))); 
            vulx.useDelimiter(",");
            String line="";
            int linenum=0;
                while(vulx.hasNextLine()){
                linenum++;
                line=vulx.nextLine();
                    if ( linenum == 2 ) {
                        vultargetChromosome=line;
                        //System.out.println("x.nextLine is: "+vultargetChromosome);
                    } 
                }
                
            nonx=new Scanner(new BufferedReader(new FileReader(nonpath))); 
            nonx.useDelimiter(",");
            String nonline="";
            int nonlinenum=0;
                while(nonx.hasNextLine()){
                nonlinenum++;
                nonline=nonx.nextLine();
                    if ( nonlinenum == 2 ) {
                        nontargetChromosome=nonline;
                        //System.out.println("nonx.nextLine is: "+nontargetChromosome);
                    } 
                }
             
            matching_vul_nonvul_target(array,vultargetChromosome,nontargetChromosome,dat);
                
            }
        catch (FileNotFoundException e) {
                    System.err.println("File not found");
            }
         
    }
    int countoverlapping=0;
    public void matching_vul_nonvul_target(String[] array, String vultargetChromosome,String nontargetChromosome,String[] dat){
        int inputindex=0;int alertindex=1;int scriptindex=2;int onerrorindex=3;
        int confirmindex=4;int imgindex=5;int onloadindex=6;int evalindex=7;
        int promptindex=8;int srcindex=9;int hrefindex=10;int javascriptindex=11;
        int windowindex=12;int fromcharcodeindex=13;int documentindex=14;int onmouseoverindex=15;
        int cookieindex=16;int domainindex=17;int onfocusindex=18;int expressionindex=19;
        int iframeindex=20;int onclickindex=21;int singleQuoteMarkindex=22;int doubleQuoteMarkindex=23;
        int leftAngleBracketindex=24;int rightAngleBracketindex=25;int backslantindex=26;int comaindex=27;
        int plusindex=28;int httpAndFileindex=29;
        char[] vultar = vultargetChromosome.toCharArray();
        char[] nonvultar = nontargetChromosome.toCharArray();
        String vulnerable_chromosome_path="D:\\dataset_thesis\\basePaper\\ExtractedData\\vulnerable\\seperateFeatures\\boolean\\nonredundant\\vul_nonred_collective\\nonred_collective.csv";
        String nonvulnerable_chromosome_path="D:\\\\dataset_thesis\\\\basePaper\\\\ExtractedData\\\\nonVulnerable\\\\seperating_features\\\\boolean\\\\nonredundant\\\\nonredcullective\\\\collective_noRedundancy.csv";

        for(int i=0;i<array.length;i++){  
            if(array[i].matches(".*\\d.*")){
                int inarray=Integer.parseInt(array[i]);
                int zero=0;
                String str1 = Integer.toString(zero);
                    if(i==onerrorindex){ 
                            if(array[i].equals(str1)==false){   
                                System.out.println("its vulnerable");
                                vulnerable=true;
                                vulcount++;
                        }
                    }
                    if(i==doubleQuoteMarkindex){ 
                            if(array[i].equals(str1)==false){   
                                System.out.println("its vulnerable");
                                vulnerable=true; 
                                vulcount++;
                        }
                    }
                }
         }
        if(vulnerable==false){
            //System.out.println("it is within focused if block");
            boolean nonrdundant_vul_value=MatchingWithVulnerableHashset(array,vulnerable_chromosome_path);
            //vulnerable=false;
            boolean nonredundant_nonvul_value=MatchingWithNonVulnerableHashset(array,nonvulnerable_chromosome_path);
            if(nonrdundant_vul_value==true && nonredundant_nonvul_value==false){
                     System.out.println("it is vulnerable");
                     vulcount++;
                
            }
            if(nonrdundant_vul_value==false && nonredundant_nonvul_value==true){
                    System.out.println("it is non-vulnerable");
                    nonvulcount++;
            }
            if(nonrdundant_vul_value==true && nonredundant_nonvul_value==true){
                    //System.out.println("can not differentiate therefore setting for deep analysis");
                    boolean vul=MatchToVulValues(array,dat);
                    boolean non_vul=MatchToNonVulValues(array,dat);
                    if(vul==true && non_vul==false){
                    vulcount++;
                    System.out.println("it is vulnerable");
                    }
                    if(vul==false && non_vul==true){
                        System.out.println("it is non-vulnerable");
                        nonvulcount++;
                    }
                    if(vul==true && non_vul==true){
                    //System.out.println("it is undecisive");
                    countoverlapping++;    
                    boolean vuls=checkforhref(array,dat);
                        if(vuls==true){
                        System.out.println("it is vulnerable"); 
                        vulcount++;
                        }
                        else if(vuls==false){
                        nonvulcount++;
                        System.out.println("it is non-vulnerable");                            
                        }
                       
                        
                    //ConsideringRL(array,dat);
                }
            }
        vulnerable=false;
        nonvulnerable=false; 
        }
        vulnerable=false;
        nonvulnerable=false;
        System.out.println("number of vulnerable cases are: "+ vulcount);   
        System.out.println("number of nonvulnerable cases are: "+ nonvulcount);   
        System.out.println("number of nonvulnerable cases are: "+ undecisive); 
                System.out.println("number of countoverlapping cases are: "+ countoverlapping);
    }
    
    public boolean ConsideringRL(String[] array, String[] dat){
        boolean vulnerability=false;
        HashMap<Integer, String[]> map = new HashMap();
        map.put(numberOfStrings, array); 
        numberOfStrings++;

        HashMap<Integer, String[]> mapnum = new HashMap();
        mapnum.put(numberOfStrings, dat); 
        numberOfStrings++;
        
        
        return vulnerability;
    }
    
    public boolean checkforhref(String[] array, String[] dat){
        int counter=0;
        boolean vulnerability=false;
        String two="2";
        String four="4";
        String six="6";
        String one="1";
        String ariss=removecomaspace_from_unchanged(Arrays.toString(array));
        //System.out.println("array is: "+ ariss + "its size is "+ ariss.length());
        for(int i=0;i<dat.length;i++){
            if(i==17 && dat[i].equals(four)){   //everywhere where domain==4 its vulnerable
                vulnerability=true;
               // System.out.println("it iss vulnerable");
            }
        }
        if(ariss.equals("1000000000000010000000000000000")){    //href vulnerablity
            vulnerability=true;
            counter++;
            //System.out.println("it iss vulnerable");

        }
        
        if(ariss.equals("100000000000000001001000000000")){     //1,10 zeros,1,5 zeros,6,12 zeros 
            for(int i=0;i<array.length;i++){
                System.out.println(array[i]);
                if(i==17 && dat[i].equals(two)){
                    vulnerability=false;
                    counter++;
                    //System.out.println("it iss nonvulnerable");

                }
                else if(i==17 && dat[i].equals(four)){
                    vulnerability=true;
                    counter++;
                    //System.out.println("it iss vulnerable");
                }
            }
        }
        if(ariss.equals("100000000001000001000000000000")){     //1,10 zeros,1,5 zeros,6,12 zeros 
            for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
                if(i==17 && dat[i].equals(two)){
                    vulnerability=false;
                    counter++;
                    //System.out.println("it iss nonvulnerable");
                
                }
                else if(i==17 && dat[i].equals(one)){
                    vulnerability=false;
                    counter++;
                    //System.out.println("it iss nonvulnerable");
                
                }
                else if(i==17 && dat[i].equals(six)){
                    vulnerability=true;
                    counter++;
                    //System.out.println("it iss vulnerable");
                }
            
            }
        }
        if(ariss.equals("100000000000001101100000000000")){     //the unique pattern 
                      vulnerability=true;
                      counter++;
        }
        if(ariss.equals("110000000000000001000000000000")){     //the unique pattern 
                      vulnerability=true;
                      counter++;
        }
        if(ariss.equals("100000000000100011000000000000")){     //the unigue pattern
                      vulnerability=true;
                      counter++;
        }
        if(ariss.equals("100000000000000011000000000000")){     //The unique patterns 
                      vulnerability=true;
                      counter++;
        }
        //non-vulnerable unique
        if(ariss.equals("100000000000000001000000000000")){     //The unique patterns 
                      vulnerability=false;
                      counter++;
        }
        if(ariss.equals("100000000000000001010000000000")){     //The unique patterns 
                      vulnerability=false;
                      counter++;
        }
        if(ariss.equals("100000000000000000000000000000")){     //The unique patterns 
                      vulnerability=false;
                      counter++;
        }
        if(ariss.equals("000000000000000000000000000000")){     
                      vulnerability=false;
                      counter++;
        }
        if(ariss.equals("110000000000000000000000000000")){     
                      vulnerability=true;
                      counter++;
        }
        if(ariss.equals("100000000000010000000000000000")){     
                      vulnerability=true;
                      counter++;
        }
        if(ariss.equals("100000000000000000100000000000")){     
                      vulnerability=true;
                      counter++;
        }
        if(ariss.equals("100000001000000001000000000000")){     
                      vulnerability=true;
                      counter++;
        }
        if(ariss.equals("100000000000000010000000000000")){     
                      vulnerability=true;
                      counter++;
        }
        
        
        if(counter==0){
                undecisive++;

        }
        return vulnerability;
    }
 
    //All_vul_list,,,,,All_nonvul_list
    //array is boolean representaton
    //dat is numerical representation
    public boolean MatchToVulValues(String[] array, String[] dat){
        boolean vulMatch=false;

        String totest=Arrays.toString(dat);
        String modi_totest=removecomaspace_from_unchanged(totest);
//        System.out.println("data to compare with all vulnerable vectors is: "+modi_totest);
//        System.out.println("size of vulnerable list to compare with: "+vul_list.size());        
        for(String str:vul_list){
            if(str.trim().contains(modi_totest)){
                vulnerable=true;
            }
            else if(str.equalsIgnoreCase(modi_totest)){
                vulnerable=true;
            }
        }
       
        vulMatch=vulnerable;
        return vulMatch;
    }
    public boolean MatchToNonVulValues(String[] array, String[] dat){ //array is of no use
        boolean nonvulMatch=false;
        String totest=Arrays.toString(dat);
        String modi_totest=removecomaspace_from_unchanged(totest);
        for(String str:nonvul_list){
            if(str.trim().contains(modi_totest)){
                nonvulnerable=true;
            }
            else if(str.equalsIgnoreCase(modi_totest)){
                nonvulnerable=true;
            }
        }
        nonvulMatch=nonvulnerable;
        return nonvulMatch;
    }
    
    
    
    public String removecoma(String line){
        char coma=',';
        String linewithoutcoma="";
        for(int i=0;i<line.length();i++){
                if(line.charAt(i)!=coma){
                    linewithoutcoma=linewithoutcoma+line.charAt(i);
                }
            }
        
        return linewithoutcoma;
    }
    public String removecomaspace(String line){
        String linetoreturn="";
        char zero='0';
        char one='1';
        for(int i=0;i<line.length();i++){
                if(line.charAt(i)==zero){
                    linetoreturn=linetoreturn+line.charAt(i);
                }
                if(line.charAt(i)==one){
                    linetoreturn=linetoreturn+line.charAt(i);
                }
            }
        return linetoreturn;
    }
    
    public String removecomaspace_from_unchanged(String line){
        String linetoreturn="";
        char coma=',';
        char space=' ';
        for(int i=0;i<line.length();i++){
            String pag=Character.toString(line.charAt(i));
             if(pag.matches(".*\\d.*")){
                    linetoreturn=linetoreturn+pag;
               }
            }
        return linetoreturn;
    }
    
    
    
    
    public boolean MatchingWithVulnerableHashset(String[] array,String vulpath) {
        
        try{
        BufferedReader br = new BufferedReader(new FileReader(vul_boolean)); 
        String line = br.readLine();  
        HashSet<String> vul_hs = new HashSet<String>(); 
        
        while(line != null) 
        { 
            String modi_line=removecoma(line);
            vul_hs.add(modi_line); 
            vul_list.add(modi_line);
            line = br.readLine(); 
        } 
        br.close(); 
                    String totest=Arrays.toString(array);
        String modi_totest=removecomaspace(totest);
//        System.out.println("after removing space and coma: "+modi_totest);

        for(String str:vul_list){
            if(str.trim().contains(modi_totest)){
                vulnerable=true;
                //System.out.println("it is vulnerable");
            }
            else if(str.equalsIgnoreCase(modi_totest)){
                vulnerable=true;
               // System.out.println("it is vulnerable");
            }
        }

    }
        catch (FileNotFoundException e) {
                    System.err.println("File not found");
                }
        catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
        //it was printing "it is vulnerable two times" 
//        if(vulnerable==true){
//            System.out.println("it is vulnerable");
//        }
        return vulnerable;
        
    }
    public boolean MatchingWithNonVulnerableHashset(String[] array,String nonvulpath){
        boolean nonvulnerables;
        System.out.println("now testing nonbulnerable hashset");
        try{
        BufferedReader br = new BufferedReader(new FileReader(nonvul_boolean)); 
        String line = br.readLine(); 
        //HashSet<String> nonvul_hs = new HashSet<String>(); 
        while(line != null) 
        { 
            String modi_line=removecoma(line);
            //nonvul_hs.add(modi_line); 
            nonvul_list.add(modi_line);
            line = br.readLine(); 
        }  
        br.close(); 
        String totest=Arrays.toString(array);
        String modi_totest=removecomaspace(totest);
//        System.out.println("after removing space and coma: "+modi_totest);
        for(String str:nonvul_list){
            if(str.trim().contains(modi_totest)){
                nonvulnerable=true;
                //System.out.println("it is matched to be nonvulnerable");
            }
        }
//       
    }
        catch (FileNotFoundException e) {
                    System.err.println("File not found");
                }
        catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
        //it is printing "it is non-vulnerable" two times
//        if(nonvulnerable==true){
//            System.out.println("it is matched to be nonvulnerable");
//        }
        nonvulnerables=nonvulnerable;
        return nonvulnerables;
    }
    
    
    //All_vul_list,,,,,All_nonvul_list
    public void storeAllNonVulnerableDataInList(){
        try{
        BufferedReader br = new BufferedReader(new FileReader(pathofnon_vulcomplete)); //pathofnon_vulcomplete,,,,pathof_vulcomplete
        String line = br.readLine();  
        while(line != null) 
        { 
            String modi_line=removecoma(line);
            nonvul_list.add(modi_line);
            line = br.readLine(); 
        } 
        System.out.println("Size of non-vulnerable list from which to match: "+nonvul_list.size());
        br.close(); 
        }
        catch (FileNotFoundException e) {
                    System.err.println("File not found");
                }
        catch (IOException e) {
            System.err.println("Unable to read the file.");
        }   
        //return nonvul_list;
    }
    public void storeAllVulnerableDataInList(){
        try{
        BufferedReader br = new BufferedReader(new FileReader(pathof_vulcomplete)); //pathofnon_vulcomplete,,,,pathof_vulcomplete
        String line = br.readLine();  
        while(line != null) 
        { 
            String modi_line=removecoma(line);
            vul_list.add(modi_line);
            line = br.readLine(); 
        } 
        System.out.println("Size of vulnerable list from which to match: "+vul_list.size());
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
    
    
    
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        Experiment ex=new Experiment();
        System.out.println("Give path of test file (name + extension)");
        String pat=input.next();
        String path=ex.modified_path(pat);
//       
        String vul="D:\\dataset_thesis\\basePaper\\ExtractedData\\vulnerable\\seperateFeatures\\boolean\\nonredundant\\vul_nonred_collective\\targetchromosome\\input.csv";
        String vulpath=ex.modified_path(vul);
        System.out.println("");
        
        
//        System.out.println("give path of nonvulnerable target chromosome(name+extension)");
//        Scanner in=new Scanner(System.in);
//        String nonvul=in.next();
        String nonvul="D:\\dataset_thesis\\basePaper\\ExtractedData\\nonVulnerable\\seperating_features\\boolean\\nonredundant\\nonredcullective\\targetchromosome\\target.csv";
        String nonpath=ex.modified_path(nonvul);
        ex.storeAllNonVulnerableDataInList();
        ex.storeAllVulnerableDataInList();
        ex.readin(path,vulpath,nonpath);
        
    }
    
}