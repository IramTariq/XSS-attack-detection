
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class PatternPercentage {
    List<String> pattern_list = new ArrayList<>();
    List<String> redundant_list = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap();
    List<Integer> fit_list = new ArrayList<>();
    public String modified_path(String path){
        String changed_path;
        String slash = "\\";
        String escapedSlash = slash+slash;
        String twoEscapedSlashes = escapedSlash+escapedSlash;
        changed_path=path.replaceAll(escapedSlash, twoEscapedSlashes) ;
        return changed_path;
    }
    public void read_nonredundant(String path){
        try{
            int linenumber=0;
        BufferedReader br = new BufferedReader(new FileReader(path)); //pathofnon_vulcomplete,,,,pathof_vulcomplete
        String line = br.readLine();  
        while(line != null) 
        { 
            linenumber++;
            //String modi_line=removecoma(line);
            pattern_list.add(line);
            line = br.readLine();
            counting(linenumber,line);
        }
        br.close();        
//        for(int i=0;i<fit_list.size();i++){
//            System.out.println("fitness is: "+fit_list.get(i).toString());
//        }
        }
        catch (FileNotFoundException e) {
                    System.err.println("File not found");
        }
        catch (IOException e) {
            System.err.println("Unable to read the file.");
        } 
    }
    public void read_redundant(String path){
        try{
        BufferedReader br = new BufferedReader(new FileReader(path)); //path of non_vul modified file
        String line = br.readLine();  
        while(line != null) 
        { 
            //String modi_line=removecoma(line);
            redundant_list.add(line);
            line = br.readLine(); 
        }
        br.close();
        
        //populatingMap();
        //checkMatchig();
        }
        catch (FileNotFoundException e) {
                    System.err.println("File not found");
        }
        catch (IOException e) {
            System.err.println("Unable to read the file.");
        } 
    }
    
    public void counting(int linenumber, String line){
        int fit=0;
        for(int i=0;i<redundant_list.size();i++){
            
                if(redundant_list.get(i).equals(line)){
                    fit=fit+1;       
                }
                fit_list.add(fit);
            }
        System.out.println("line number: "+linenumber+ " has fitness "+fit);
        }
        
    
    public void populatingMap(){
        int fit=0;
         for(int i=0;i<pattern_list.size();i++){
        map.put(pattern_list.get(i), fit); 
    }
    }
         
    public void checkMatchig(){
        for(int i=0;i<pattern_list.size();i++){
            for(int j=0;j<redundant_list.size();j++)
            if(pattern_list.get(i).equals(redundant_list.get(j).toString())==false){
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if(entry.getKey()==pattern_list.get(i)){
                        map.put(entry.getKey(), map.get(entry.getKey()) + 1);
                    }               
                }
            }
        }
//        int max=getmaximumvalue();
//        int min=getminimumvalue();
        gethighestpattern();
        getlowestpattern();
    }
    public void gethighestpattern(){
        String highestMap = null;
        int highestVote = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > highestVote) {
                highestMap = entry.getKey();
                highestVote = entry.getValue();
            }
        }
        System.out.println("highest pattern: "+ highestMap +"highest value is: "+highestVote);
    }
    public void getlowestpattern(){
        String lowMap = null;
        int lowVote = 50000;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() < lowVote) {
                lowMap = entry.getKey();
                lowVote = entry.getValue();
            }
        }
        System.out.println("lowest pattern: "+ lowMap +"owest value is: "+lowVote);
    }
    
//    public int getmaximumvalue(){ //return maximum value(fitness) from population
//        int maxValueInMap=(Collections.max(map.values()));  // This will return max value in the Hashmap
//        return maxValueInMap;
//    }
//    public int getminimumvalue(){   ////return minimum value(fitness) from population
//        int minValueInMap=(Collections.min(map.values()));  // This will return min value in the Hashmap
//        return minValueInMap;
//    }
//    
    
    public static void main(String[] args){
        PatternPercentage pp=new PatternPercentage();
        System.out.println("Give path of redundant file with name and exten");
        Scanner input=new Scanner(System.in);
        String pati=input.next();
        String paths=pp.modified_path(pati);
        pp.read_redundant(paths);
        System.out.println("Give path of pattern file with name and exten");
        Scanner inputs=new Scanner(System.in);
        String pat=inputs.next();
        String path=pp.modified_path(pat);
        //pp.read_redundant(path);
        pp.read_nonredundant(path);
        
        
        
    }
}
