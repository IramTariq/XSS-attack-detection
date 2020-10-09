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
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author iram
 */
public class geneticAlgorithmfullrandom {
  String [] feat={"input size","alert","script","onerror","confirm","img","onload","eval", "prompt", "src", "href", "javascript", "window","fromcharcode", "document", "onmouseover", "cookie", "domain", "onfocus","expression" , "iframe", "onclick", "singleQuoteMark","doubleQuoteMark", "leftAngleBracket", "rightAngleBracket", "backslant", "coma", "plus", "httpAndFile"};
    private static Scanner x;
    private static Scanner xx;
    int number_of_records=0;
    List<String> listmax = new ArrayList<String>();//stores key of maximum value map
    List<Integer> listindex = new ArrayList<Integer>();//stores key of maximum value map
    List<String> listmin = new ArrayList<String>();//stores key of minimum value map
    String processed="";// this is string that concatenate indexes that matches target chromosome


    String indexes="";
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
                            

            int maxValue=getmaximumvalue();
            String[] boring=getelementsofmaximumvalue();
            String fazool="";
            for(int i=0;i<boring.length;i++){
            fazool=boring[i];
            }
            System.out.println("boring is: "+fazool);
            indexes="";
            indexes=getmatchedindexes(fazool);
            int generation_number=0;
            while(maxValue<feat.length){
            generation_number++;
            String[] baray=getelementsofmaximumvalue();
            String[] chotay=getelementofminimumvalues();
            System.out.println("-------------------------------"+"Generation number " +generation_number+" is: "+"-------------------------------");
            String max_value_String="";
            String min_value_String="";
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
              maxValue=getmaximumvalue();
              System.out.println("maximum value is: "+maxValue); 
              Random generator = new Random();

//               List<String> keysAsArray = new ArrayList<String>(map.keySet());
//                Random r = new Random();
//                String da=Integer.toString(map.get(keysAsArray.get(r.nextInt(keysAsArray.size()))));
//                System.out.println("da is : "+da);
                
                Random       random    = new Random();
                List<String> keys      = new ArrayList<String>(map.keySet());
                String       randomKey = keys.get( random.nextInt(keys.size()) );
                System.out.println("randomkey is : "+randomKey);
                
                String[] chipkali=crossover(max_value_String,randomKey);
                String[] go=mutation(chipkali);
          }                  
        }
        catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
    }
    
    public String getmatchedindexes(String highestmatched){ //this method returns indexes of highest fitteness chromosomes, that are matched with target chromosomes
        String targetChromosomeminuscoma="";
        for(int i=0;i<targetChromosome.length();i++){
            char coma=',';
            if(targetChromosome.charAt(i)!= coma){
                targetChromosomeminuscoma=targetChromosomeminuscoma+targetChromosome.charAt(i);
            }           
        }
        for(int i=0;i<highestmatched.length();i++){
            if(highestmatched.charAt(i) == targetChromosomeminuscoma.charAt(i)){
                indexes=indexes+i;
                listindex.add(i);
            }
        }
        System.out.println("indexes are: "+indexes);
        return indexes;
    }

    public void population(String[] a){    //this method returns all chromosomes in population with their fitness
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
    public String[] getelementsofmaximumvalue(){  //keys(chromosomes) with highest fitness(could be more than two) are returned in the form of array
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
          // System.out.println(entry.getKey()+" : "+entry.getValue());
            }
            
            int number_of_maximum=0;
            int maxValueInMap=(Collections.max(map.values()));  // This will return max value in the Hashmap
            for (Map.Entry<String, Integer> entry : map.entrySet()) {  // Itrate through hashmap
                if (entry.getValue()== maxValueInMap) {
                    number_of_maximum++;
                  //  System.out.println("Max values: "+entry.getKey());     // Print the key with max value
                    listmax.add(entry.getKey());
                }
            }
            String[] max_arrays = listmax.toArray(new String[listmax.size()]);
            for(int ni=0;ni<max_arrays.length;ni++){
               // System.out.println("maximum found is: "+max_arrays[ni]);
            }
            return max_arrays;                
          
    }
    public String[] getelementofminimumvalues(){    //it return array of chromosomes having lowest fitness within population
          int number_of_minimum=0;
            int minValueInMap=(Collections.min(map.values()));  // This will return min value in the Hashmap
            for (Map.Entry<String, Integer> entry : map.entrySet()) {  // Itrate through hashmap
                if (entry.getValue()== minValueInMap) {
                    number_of_minimum++;
                    //System.out.println("Min values: "+entry.getKey()); // Print the key with min value
                    listmin.add(entry.getKey());
                }
            }
            String[] min_arrays = listmin.toArray(new String[listmin.size()]);
            for(int ni=0;ni<min_arrays.length;ni++){
                //System.out.println("minimum array found is: "+min_arrays[ni]);
            }
            return min_arrays;
    }
    public int getmaximumvalue(){ //return maximum value(fitness) from population
        int maxValueInMap=(Collections.max(map.values()));  // This will return max value in the Hashmap
        return maxValueInMap;
    }
    public int getminimumvalue(){   ////return minimum value(fitness) from population
        int minValueInMap=(Collections.min(map.values()));  // This will return min value in the Hashmap
        return minValueInMap;
    }
    
    public int fitnesscalculation(String[] a){  
        int fitness=0;      //targetChromosome
        String au="";
        for(int k=0;k<a.length;k++){
            au=au+a[k];
        }
        String targetChromosomeminuscoma="";
        for(int i=0;i<targetChromosome.length();i++){
            char coma=',';
            if(targetChromosome.charAt(i)!= coma){
                targetChromosomeminuscoma=targetChromosomeminuscoma+targetChromosome.charAt(i);
            }           
        }
        for(int i=0;i<a.length;i++){
            if(au.charAt(i) == targetChromosomeminuscoma.charAt(i)){
                fitness++;
            }
        }
        return fitness;
    }
    
    //crossover occour with 0.5% rate
    public String[] crossover(String max,String min){
        
        String crossedover[]=new String[feat.length];
//        int half=(1*feat.length)/2;
//        for(int it=0;it<feat.length;it++){
//            if(it<half+1){
//                char c=min.charAt(it);
//                String s=Character.toString(c);
//                crossedover[it]=s;
//            }
//            else{
//                char c=max.charAt(it);
//                String s=Character.toString(c);
//                crossedover[it]=s;
//            }
//        }
        System.out.println("imdexes string :"+indexes);
        for(int f=0;f<feat.length;f++){
        
            //if(f==indexes.charAt(it)){
            if(listindex.contains(f)){
                char c=max.charAt(f);
                String s=Character.toString(c);
                crossedover[f]=s;
            }
            else{
                char c=min.charAt(f);
                String s=Character.toString(c);
                crossedover[f]=s;
            }
        
        }
        
        int fit=fitnesscalculation(crossedover);
        System.out.println("fitness after crossover: "+fit);
        String toadd="";
        for(int i=0;i<crossedover.length;i++){
            toadd=toadd+crossedover[i];
        }
        if(fit>getmaximumvalue()){
        map.put(toadd, fit);
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
        System.out.println("fitness after mutaion: "+fit);
        String toadd="";
        for(int i=0;i<mutated.length;i++){
            toadd=toadd+mutated[i];
        }
        if(fit>getmaximumvalue()){
        map.put(toadd, fit);
        }
        return mutated;
    }
    
    public static void main(String[] args){
        geneticAlgorithmfullrandom GA=new geneticAlgorithmfullrandom();
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
