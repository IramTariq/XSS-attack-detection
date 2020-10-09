/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package differentiatingxsstestcases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 *
 * @author iram
 */
public class GeneticAlgorithm {
    String [] feat={"input size","alert","script","onerror","confirm","img","onload","eval", "prompt", "src", "href", "javascript", "window","fromcharcode", "document", "onmouseover", "cookie", "domain", "onfocus","expression" , "iframe", "onclick", "singleQuoteMark","doubleQuoteMark", "leftAngleBracket", "rightAngleBracket", "backslant", "coma", "plus", "httpAndFile"};
    private static Scanner x;
    private static Scanner xx;
    int number_of_records=0;
    List<String> listmax = new ArrayList<String>();//stores key of maximum value map
    List<String> listmin = new ArrayList<String>();//stores key of minimum value map


    HashMap<String, Integer> map = new HashMap();
    String targetChromosome=null;
    List<String> list = new ArrayList<>();
    String target[]=new String[29];
    String changed[]=new String[29];
    String addData[]=new String[29];
    public String modified_path(String path){
        String changed_path;
        String slash = "\\";
        String escapedSlash = slash+slash;
        String twoEscapedSlashes = escapedSlash+escapedSlash;
        changed_path=path.replaceAll(escapedSlash, twoEscapedSlashes) ;
        return changed_path;
    }
    private void read(String path, String chromosome_path){
        
        int linenum =0;
        //reading a file to get target chromosome
        try {
            String line=null;
            x=new Scanner(new BufferedReader(new FileReader(chromosome_path))); 
            x.useDelimiter(",");
            while(x.hasNextLine()){
            linenum++;
            line=x.nextLine();
            if ( linenum == 2 ) {
                targetChromosome=line;
                System.out.println("x.nextLine is: "+targetChromosome);
            }  
         }
       }
        catch (FileNotFoundException e) {
                    System.err.println("File not found");
                }
        //reading a file on which genetic algorithm will run
        try{
            int linetoremove=0;     //this variable will help in ignoring record containing "feature names"
            xx=new Scanner(new BufferedReader(new FileReader(path))); 
            xx.useDelimiter(",");
            while(xx.hasNextLine()){
                linetoremove++;
                String inputline=xx.nextLine();
                String[] inarray=inputline.split(",");
                if(linetoremove!=1){        //this ensure 1st line of file is not considered, first line is feature name and feature name has minimum fitness so to crossover we wont get chromosome with minimum fitness
                changed=new String[inarray.length];
                for(int f=0;f<inarray.length;f++){
                    changed[f]=inarray[f];
                    number_of_records++;
                }
                population(changed);
            }
            }
            //Showing all elements of Hashmap 
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
            }
            
            int number_of_maximum=0;
            int maxValueInMap=(Collections.max(map.values()));  // This will return max value in the Hashmap
            for (Entry<String, Integer> entry : map.entrySet()) {  // Itrate through hashmap
                if (entry.getValue()== maxValueInMap) {
                    number_of_maximum++;
                    System.out.println("Max values: "+entry.getKey());     // Print the key with max value
                    listmax.add(entry.getKey());
                }
            }
            String[] max_arrays = listmax.toArray(new String[listmax.size()]);
            for(int ni=0;ni<max_arrays.length;ni++){
                System.out.println("maximum found is: "+max_arrays[ni]);
            }

//            for (Entry<String, Integer> entry : map.entrySet()) {  // Itrate through hashmap
//                if (entry.getValue()== maxValueInMap) {
//                    for(int j=0;j<number_of_maximum;j++){
//                        max_array[j]=entry.getKey();  //the issue here was that complete array contains last  maximum value found on each index
//                    }
//                }
//            }
//            String[] maxfound=trimarray(max_array);
//            for(int ni=0;ni<maxfound.length;ni++){
//                System.out.println("maximum found is: "+maxfound[ni]);
//            }
                   
            int number_of_minimum=0;
            int minValueInMap=(Collections.min(map.values()));  // This will return min value in the Hashmap
            for (Entry<String, Integer> entry : map.entrySet()) {  // Itrate through hashmap
                if (entry.getValue()== minValueInMap) {
                    number_of_minimum++;
                    System.out.println("Min values: "+entry.getKey()); // Print the key with min value
                    listmin.add(entry.getKey());
                }
            }
            String[] min_arrays = listmin.toArray(new String[listmin.size()]);
            for(int ni=0;ni<min_arrays.length;ni++){
                System.out.println("minimum array found is: "+min_arrays[ni]);
            }
//            for (Entry<String, Integer> entry : map.entrySet()) {  // Itrate through hashmap
//                if (entry.getValue()== minValueInMap) {
//                    for(int j=0;j<number_of_minimum;j++){
//                        min_array[j]=entry.getKey();
//                    }
//                }
//            }
//            String[] cross=new String[feat.length];
//            cross= crossover(max_array,min_array);
//            int crosfit=fitnesscalculation(cross);
//            System.out.println("cross fit: "+crosfit);
//            String[] mutat=new String[feat.length];
//            mutat=mutation(cross);
//            int mutfit=fitnesscalculation(mutat);
//            System.out.println("mutate fit: "+mutfit);
            int maxValue=getmaximumvalue();
            String[] baray=getelementsofmaximumvalue();
            String[] chotay=getelementofminimumvalues();
            String max_value_String="";
            String min_value_String="";
           //String[] highcross=new String[feat.length];
           // int minValue=getminimumvalue();
          while(maxValue<feat.length){
            if(baray.length==1){
                  for(int i=0;i<baray.length;i++){
                      max_value_String=baray[i];
                  }
              }
            if(baray.length>1){
                   Random r=new Random();
                   int randomNumber=r.nextInt(baray.length);
                   for(int i=0;i<baray.length;i++){
                        if(i==randomNumber){
                        max_value_String=baray[i];
                       }
                  }
              }
//              String[] blah=new String[feat.length]; 
//              for(int g=0;g<max_value_String.length();g++){
//                  //high.add((max_value_String.charAt(g)).toString);
//                  char[] highs=new char[max_value_String.length()];
//                  highs[g]=max_value_String.charAt(g);
//                  //blah[g]=ToString(highs[g]);
//                  blah=Stream.of(highs).toArray(String[]::new);
//
//              }
              
              
              if(chotay.length==1){
                  for(int i=0;i<chotay.length;i++){
                      min_value_String=chotay[i];
                  }
              }
            if(chotay.length>1){
                   Random r=new Random();
                   int randomNumber=r.nextInt(chotay.length);
                   for(int i=0;i<chotay.length;i++){
                        if(i==randomNumber){
                        min_value_String=chotay[i];
                       }
                  }
              }
//              String[] blahchoti=new String[feat.length]; 
//              for(int g=0;g<min_value_String.length();g++){
//                  //high.add((max_value_String.charAt(g)).toString);
//                  char[] lows=new char[min_value_String.length()];
//                  lows[g]=min_value_String.charAt(g);
//                  blahchoti=Stream.of(lows).toArray(String[]::new);
//
//              }
              String[] chipkali=crossover(max_value_String,min_value_String);
              String[] go=mutation(chipkali);
              maxValue=getmaximumvalue();
              System.out.println("maximum value is: "+maxValue);              
          }                  
             
        }
        catch (FileNotFoundException e) {
                    System.err.println("File not found");
        }
    }
    
    public String[] trimarray(String[] firstArray){
        List<String> list = new ArrayList<String>();
        for(String s : firstArray) {
           if(s != null && s.length() > 0) {
              list.add(s);
           }
        }
        firstArray = list.toArray(new String[list.size()]);
        return firstArray;
        }
    
    //population will do two things, when a string is added to it it will add it in hashMap such that,
    //key contains the respective array as key should not contain dupllicate value
    // and value contains fitness of this array and fitness of two chromosomes could be same.
    public void population(String[] a){
        String[] pop=new String[a.length];
        String chromo="";

        System.out.println("length is : "+a.length);
        for(int i=0;i<a.length;i++){
            pop[i]=a[i];
            chromo=chromo+a[i];
        }
        int fit=fitnesscalculation(pop);
        System.out.println("fitness is: "+fit);
        map.put(chromo, fit);       
             
    }
    public String[] getelementsofmaximumvalue(){
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
            }
            
            int number_of_maximum=0;
            int maxValueInMap=(Collections.max(map.values()));  // This will return max value in the Hashmap
            for (Entry<String, Integer> entry : map.entrySet()) {  // Itrate through hashmap
                if (entry.getValue()== maxValueInMap) {
                    number_of_maximum++;
                    System.out.println("Max values: "+entry.getKey());     // Print the key with max value
                    listmax.add(entry.getKey());
                }
            }
            String[] max_arrays = listmax.toArray(new String[listmax.size()]);
            for(int ni=0;ni<max_arrays.length;ni++){
                System.out.println("maximum found is: "+max_arrays[ni]);
            }
            return max_arrays;                
          
    }
    public String[] getelementofminimumvalues(){
          int number_of_minimum=0;
            int minValueInMap=(Collections.min(map.values()));  // This will return min value in the Hashmap
            for (Entry<String, Integer> entry : map.entrySet()) {  // Itrate through hashmap
                if (entry.getValue()== minValueInMap) {
                    number_of_minimum++;
                    System.out.println("Min values: "+entry.getKey()); // Print the key with min value
                    listmin.add(entry.getKey());
                }
            }
            String[] min_arrays = listmin.toArray(new String[listmin.size()]);
            for(int ni=0;ni<min_arrays.length;ni++){
                System.out.println("minimum array found is: "+min_arrays[ni]);
            }
            return min_arrays;
    }
    public int getmaximumvalue(){
        int maxValueInMap=(Collections.max(map.values()));  // This will return max value in the Hashmap
        return maxValueInMap;
    }
    public int getminimumvalue(){
        int minValueInMap=(Collections.min(map.values()));  // This will return min value in the Hashmap
        return minValueInMap;
    }
    
    
    
    
    //this function calculates the fitness of chromosome array by comparing it with target chromosome
    //More resemblance results in high fitness
    //indec to index matching will take place
    public int fitnesscalculation(String[] a){
        int fitness=0;      //targetChromosome
        String au="";
        for(int k=0;k<a.length;k++){
            au=au+a[k];
        }
        String targetChromosomeminuscoma="";
        //System.out.println("au is: "+ au);
        for(int i=0;i<targetChromosome.length();i++){
            char coma=',';
            if(targetChromosome.charAt(i)!= coma){
                targetChromosomeminuscoma=targetChromosomeminuscoma+targetChromosome.charAt(i);
            }           
        }
        //System.out.println("targetChromosomeminuscoma : "+targetChromosomeminuscoma);

        for(int i=0;i<a.length;i++){
            if(au.charAt(i) == targetChromosomeminuscoma.charAt(i)){
                //System.out.println("Matched occurances are: "+targetChromosomeminuscoma.charAt(i));
                fitness++;
            }
        }
        return fitness;
    }  
    
    //crossover occour with 0.5% rate
    public String[] crossover(String max,String min){
        String crossedover[]=new String[feat.length];
        int half=(1*feat.length)/2;
        for(int it=0;it<feat.length;it++){
            if(it<half+1){
                char c=max.charAt(it);
                String s=Character.toString(c);
                crossedover[it]=s;
                
            }
            else{
                char c=min.charAt(it);
                String s=Character.toString(c);
                crossedover[it]=s;
            }
        }
        return crossedover;
    }
    
    //index is randomly selected and its value is mutated
    public String[] mutation(String[] a){
        String mutated[]=new String[a.length];
        Random r=new Random();
        String zero="0";
        String one="1";
        int randomNumber=r.nextInt(a.length);
        for(int j=0;j<a.length;j++){
            mutated[j]=a[j];
            if(j==randomNumber){
                if(a[j].equals(zero)){
                    mutated[j]=one;
                }
                if(a[j].equals(one)){
                    mutated[j]=zero;
                }
            }
        }
        int fit=fitnesscalculation(mutated);
        String toadd="";
        for(int i=0;i<mutated.length;i++){
            toadd=toadd+mutated[i];
        }
        map.put(toadd, fit);
        return mutated;
    }
    
    public static void main(String[] args){
        GeneticAlgorithm GA=new GeneticAlgorithm();
        System.out.println("Give path of file on which you want to run genetic algorithm");
        Scanner input=new Scanner(System.in);
        String pat=input.next();
        String path=GA.modified_path(pat);
        System.out.println("give path of file where you have stored target chromosome");
        String chromosome_pat=input.next();
        String chromosome_path=GA.modified_path(chromosome_pat);
        System.out.println("Give name of file where you wanted to store fittest chromosome");
        String storpath=input.next();
        String storage_path=GA.modified_path(storpath);
        GA.read(path,chromosome_path);
    }
}
