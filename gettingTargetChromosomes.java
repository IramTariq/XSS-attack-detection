
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
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
public class gettingTargetChromosomes {
    String [] feat={"input size","alert","script","onerror","confirm","img","onload","eval", "prompt", "src", "href", "javascript", "window","fromcharcode", "document", "onmouseover", "cookie", "domain", "onfocus","expression" , "iframe", "onclick", "singleQuoteMark","doubleQuoteMark", "leftAngleBracket", "rightAngleBracket", "backslant", "coma", "plus", "httpAndFile"};
    String inarray[]=new String[feat.length];
    int number_of_record=0;
    private static Scanner x;
    List<String> list2 = new ArrayList<>();
    List<String> list = new ArrayList<>();
    
    public String modified_path(String path){
        String changed_path;
        String slash = "\\";
        String escapedSlash = slash+slash;
        String twoEscapedSlashes = escapedSlash+escapedSlash;
        changed_path=path.replaceAll(escapedSlash, twoEscapedSlashes) ;
        return changed_path;
    }
    public void read(String path, String featurename, String Storage_path){
        boolean binput=false;boolean balert=false;boolean bscript=false;boolean bonerror=false;
        boolean bconfirm=false;boolean bimg=false;boolean bonload=false;boolean beval=false;
        boolean bprompt=false;boolean bsrc=false;boolean bhref=false;boolean bjavascript=false;
        boolean bwindow=false;boolean bfromcharcode=false;boolean bdocument=false;boolean bonmouseover=false;
        boolean bcookie=false;boolean bdomain=false;boolean bonfocus=false;boolean bexpression=false;
        boolean biframe=false;boolean bonclick=false;boolean bsingleQuoteMark=false;boolean bdoubleQuoteMark=false;
        boolean bleftAngleBracket=false;boolean brightAngleBracket=false;boolean bbackslant=false;boolean bcoma=false;
        boolean bplus=false;boolean bhttpAndFile=false;
        boolean array[]=new boolean[]{binput,balert,bscript,bonerror,bconfirm,bimg,bonload,beval,bprompt,bsrc,bhref,bjavascript,bwindow,bfromcharcode,bdocument,bonmouseover,bcookie,bdomain,bonfocus,bexpression,biframe,bonclick,bsingleQuoteMark,bdoubleQuoteMark,bleftAngleBracket,brightAngleBracket,bbackslant,bcoma,bplus,bhttpAndFile};
        int aray[]=new int[array.length];
        int index=0;
        for(int k=0;k<feat.length;k++){
            if(featurename.equals(feat[k].toString())){
                    index=k;
                }
        }
        try{
            x=new Scanner(new BufferedReader(new FileReader(path))); 
            x.useDelimiter(",");
            while(x.hasNextLine()){
                number_of_record++;
                int zero=0;
                String str1 = Integer.toString(zero);
                String inputline=x.nextLine();
                String[] inarray=inputline.split(",");
                for(int i=0;i<inarray.length;i++){
                     if(inarray[i].matches(".*\\d.*")){
                        if(inarray[i].equals(str1)==false){
                            array[i]=true;               
                        }
                    }
                }
            } 
            int[] changed=new int[feat.length]; 
            for(int i=0;i<array.length;i++){
            int one=1;
            int zero=0;
            if(array[i]==true){
                aray[i]=one;
            }
            if(array[i]==false){
                aray[i]=zero;
            }
            changed[i]=aray[i];
            String p=Integer.toString(changed[i]);
            list.add(p);         
        }
        System.out.println(list);
        String dat="";
        for(int i=0;i<list.size();i++){
            dat=dat+list.get(i);
        }
        insert_targetchromosome(feat,dat,featurename,Storage_path);
        }
        catch (FileNotFoundException e) {
            System.err.println("File not found");
            }
        System.out.println("do you also wanted to find association? press (a) if you want");
        Scanner input=new Scanner(System.in);
        String get=input.next();
          
        if(get.equals("a")){
            findAssociation(path,featurename,Storage_path);
        }
    }
    public void insert_targetchromosome(String[] feat,String dat, String feature,String storage_path) throws FileNotFoundException{
          char[] shokha = dat. toCharArray();
          System.out.println("chromososme size is "+ shokha.length);
          try{
              FileOutputStream fos= new FileOutputStream(storage_path,true);
              PrintWriter pw=new PrintWriter(fos);
              BufferedReader br = new BufferedReader(new FileReader(storage_path));  
                try {
                    if (br.readLine()==null){
                        for(int i=0;i<shokha.length+1;i++){
                            if(i==0){
                           pw.print(feat[i]);
                            }
                            if(i>0 & i<feat.length){
                                pw.print(","+feat[i]);
                            }
                            if(i==feat.length){
                                pw.append('\n');
                            }
                        }
                        for(int i=0;i<shokha.length+1;i++){
                            if(i==0){
                           pw.print(shokha[i]);
                            }
                            if(i>0 & i<shokha.length){
                                pw.print(","+shokha[i]);
                            }
                            if(i==shokha.length){
                                pw.append('\n');
                            }
                        }
                    }
                }
                catch(Exception e){
                System.err.println("Unable to write the file.");  
              }
              pw.flush();
              pw.close();
            }
           catch(FileNotFoundException e){
              System.err.println("File not found");
            }
    }
   
    public void findAssociation(String path, String featurename,String storage_path){
        int binput=0;int balert=0;int bscript=0;int bonerror=0;int bconfirm=0;int bimg=0;int bonload=0;int beval=0;
        int bprompt=0;int bsrc=0;int bhref=0;int bjavascript=0;int bwindow=0;int bfromcharcode=0;int bdocument=0;
        int bonmouseover=0;int bcookie=0;int bdomain=0;int bonfocus=0;int bexpression=0;int biframe=0;int bonclick=0;
        int bsingleQuoteMark=0;int bdoubleQuoteMark=0;int bleftAngleBracket=0;int brightAngleBracket=0;int bbackslant=0;
        int bcoma=0;int bplus=0;int bhttpAndFile=0;
        
        
        String input="input";String alert="alert";String script="script";String onerror="onerror";
        String confirm="confirm";String img="img";String onload="onload";String eval="eval";
        String prompt="prompt";String src="src";String href="href";String javascript="javascript";
        String window="window";String fromcharcode="fromcharcode";String document="document";
        String onmouseover="onmouseover";String cookie="cookie";String domain="domain";
        String onfocus="onfocus";String expression="expression";String iframe="iframe";
        String onclick="onclick";String singleQuoteMark="singleQuoteMark";String doubleQuoteMark="doubleQuoteMark";
        String leftAngleBracket="leftAngleBracket";String rightAngleBracket="rightAngleBracket";
        String backslant="backslant";String coma="coma";String plus="plus";String httpAndFile="httpAndFile";
        String[] features=new String[]{"input","alert","script","onerror",
        "confirm","img","onload","eval","prompt","src","href","javascript",
        "window","fromcharcode","document","onmouseover","cookie","domain",
        "onfocus","expression","iframe","onclick","singleQuoteMark","doubleQuoteMark",
        "leftAngleBracket","rightAngleBracket","backslant","coma","plus","httpAndFile"};
        
        int position_input=0;int position_alert=0;int position_script=0;int position_onerror=0;
        int position_confirm=0;int position_img=0;int position_onload=0;int position_eval=0;int position_prompt=0;
        int position_src=0;int position_href=0;int position_javascript=0;int position_window=0;int position_fromcharcode=0;
        int position_document=0;int position_onmouseover=0;int position_cookie=0;int position_domain=0;int position_onfocus=0;
        int position_expression=0;int position_iframe=0;int position_onclick=0;int position_singleQuoteMark=0;int position_doubleQuoteMark=0;
        int position_leftAngleBracket=0;int position_rightAngleBracket=0;int position_backslant=0;int position_coma=0;
        int position_plus=0;int position_httpAndFile=0;
        int index=0;
        for(int k=0;k<feat.length;k++){
            if(featurename.equals(feat[k].toString())){
                    index=k;
                }
            if(feat[k].equals(input)){
                position_input=k;
            }
            if(feat[k].equals(alert)){
                position_alert=k;
            }
            if(feat[k].equals(script)){
                position_script=k;
            }
            if(feat[k].equals(onerror)){
                position_onerror=k;
            }
            if(feat[k].equals(confirm)){
                position_confirm=k;
            }
            if(feat[k].equals(img)){
                position_img=k;
            }
            if(feat[k].equals(onload)){
                position_onload=k;
            }
            if(feat[k].equals(eval)){
                position_eval=k;
            }
            if(feat[k].equals(prompt)){
                position_prompt=k;
            }
            if(feat[k].equals(src)){    
                position_src=k;         
            }                           
            if(feat[k].equals(href)){
                position_href=k;
            }
            if(feat[k].equals(javascript)){
                position_javascript=k;
            }
            if(feat[k].equals(window)){
                position_window=k;
            }
            if(feat[k].equals(fromcharcode)){
                position_fromcharcode=k;
            }
            if(feat[k].equals(document)){
                position_document=k;      
            }
            if(feat[k].equals(onmouseover)){
                position_onmouseover=k;
            }            
            if(feat[k].equals(cookie)){
                position_cookie=k;
            }
            if(feat[k].equals(domain)){
                position_domain=k;
            }
            if(feat[k].equals(onfocus)){
                position_onfocus=k;         
            }
            if(feat[k].equals(expression)){
                position_expression=k;
            }
            if(feat[k].equals(iframe)){
                position_iframe=k;
            }
            if(feat[k].equals(onclick)){
                position_onclick=k;
            }
            if(feat[k].equals(singleQuoteMark)){
                position_singleQuoteMark=k;     
            }
            if(feat[k].equals(doubleQuoteMark)){
                position_doubleQuoteMark=k;
            }
            if(feat[k].equals(leftAngleBracket)){
                position_leftAngleBracket=k;
            }
            if(feat[k].equals(rightAngleBracket)){
                position_rightAngleBracket=k;   
            }
            if(feat[k].equals(backslant)){
                position_backslant=k;
            }
            if(feat[k].equals(coma)){
                position_coma=k;
            }
            if(feat[k].equals(plus)){
                position_plus=k;
            }
            if(feat[k].equals(httpAndFile)){
                position_httpAndFile=k;
            }
                
        }
        try{
            x=new Scanner(new BufferedReader(new FileReader(path))); 
            x.useDelimiter(",");
            while(x.hasNextLine()){
                String inputline=x.nextLine();
                String[] inarray=inputline.split(",");
                number_of_record++;

                for(int i=0;i<inarray.length;i++){
                     if(inarray[i].matches(".*\\d.*")){
                        int result = Integer.parseInt(inarray[i]); 
                        if(i==position_input){
                            binput=binput+result;               
                        }
                        if(i==position_alert){
                            balert=balert+result;               
                        }
                        if(i==position_script){
                            bscript=bscript+result;              
                        }
                        if(i==position_onerror){
                            bonerror=bonerror+result;              
                        }
                        if(i==position_confirm){
                            bconfirm=bconfirm+result;               
                        }
                        if(i==position_img){
                            bimg=bimg+result;               
                        }
                        if(i==position_onload){
                            bonload=bonload+result;             
                        }
                        if(i==position_eval){
                            beval=beval+result;               
                        }
                        if(i==position_prompt){
                            bprompt=bprompt+result;
                        }
                        if(i==position_src){
                            bsrc=bsrc+result;               
                        }
                        if(i==position_href){
                            bhref=bhref+result;               
                        }
                        if(i==position_javascript){
                            bjavascript=bjavascript+result;               
                        }
                        if(i==position_window){
                            bwindow=bwindow+result;               
                        }
                        if(i==position_fromcharcode){
                            bfromcharcode=bfromcharcode+result;               
                        }
                        if(i==position_document){
                            bdocument=bdocument+result;               
                        }
                        if(i==position_onmouseover){
                            bonmouseover=bonmouseover+result;               
                        }
                        if(i==position_cookie){
                            bcookie=bcookie+result;               
                        }
                        if(i==position_domain){
                            bdomain=bdomain+result;               
                        }
                        if(i==position_onfocus){
                            bonfocus=bonfocus+result;               
                        }
                        if(i==position_expression){
                            bexpression=bexpression+result;               
                        }
                        if(i==position_iframe){
                            biframe=biframe+result;               
                        }
                        if(i==position_onclick){
                            bonclick=bonclick+result;               
                        }
                        if(i==position_singleQuoteMark){
                            bsingleQuoteMark=bsingleQuoteMark+result;               
                        }
                        if(i==position_doubleQuoteMark){
                            bdoubleQuoteMark=bdoubleQuoteMark+result;               
                        }
                        if(i==position_leftAngleBracket){
                            bleftAngleBracket=bleftAngleBracket+result;               
                        }
                        if(i==position_rightAngleBracket){
                            brightAngleBracket=brightAngleBracket+result;               
                        }
                        if(i==position_backslant){
                            bbackslant=bbackslant+result;               
                        }
                        if(i==position_coma){
                            bcoma=bcoma+result;               
                        }
                        if(i==position_plus){
                            bplus=bplus+result;               
                        }
                        if(i==position_httpAndFile){
                            bhttpAndFile=bhttpAndFile+result;              
                        }
                    }
                }
            } 
            int[] bakwas=new int[]{binput,balert,bscript,bonerror,bconfirm,bimg,bonload,beval,
            bprompt,bsrc,bhref,bjavascript,bwindow,bfromcharcode,bdocument,
            bonmouseover,bcookie,bdomain,bonfocus,bexpression,biframe,bonclick,
            bsingleQuoteMark,bdoubleQuoteMark,bleftAngleBracket,brightAngleBracket,bbackslant,
            bcoma,bplus,bhttpAndFile};
            double[] prob=new double[feat.length];
            for(int i=0;i<bakwas.length;i++){
                System.out.println("number of "+features[i]+" are: "+bakwas[i]);
                double one=bakwas[i];
                int record=number_of_record/2;
                int chawal=(record-1);
                double two=chawal;
                double probab=(1.0*one)/two;
                System.out.println("ullu ka patha "+probab);
                double probability=Math.round(probab*100.0)/100.0;
                

                prob[i]=probability;                
                 String p=Double.toString(prob[i]);
                 list2.add(p);
                System.out.println("probability of "+features[i]+" is "+prob[i]);
            }
            String data="";
            for(int i=0;i<list2.size();i++){
            data=data+list2.get(i);
            }
            System.out.println(list2);
            insert_Probability(feat,prob,featurename,storage_path);
        }  
        catch (FileNotFoundException e) {
                    System.err.println("File not found");
                }
    }
    public void insert_Probability(String[] feat,double[] prob, String feature,String storage_path){
          try{
              FileOutputStream fos= new FileOutputStream(storage_path,true);
              PrintWriter pw=new PrintWriter(fos);
              BufferedReader br = new BufferedReader(new FileReader(storage_path));  
                try {
                    if (br.readLine()!=null){
                        for(int i=0;i<feat.length+1;i++){
                            if(i==0){
                           pw.print(prob[i]);
                            }
                            if(i>0 & i<feat.length){
                                pw.print(","+prob[i]);
                            }
                            if(i==feat.length){
                                pw.append('\n');
                            }
                        }                        
                    }
                }
                catch(Exception e){
                System.err.println("Unable to write the file.");  
              }
              pw.flush();
              pw.close();
            }
           catch(FileNotFoundException e){
              System.err.println("File not found");
            }
    }
    
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        gettingTargetChromosomes GTC=new gettingTargetChromosomes();
        System.out.println("Give path of file to read and extract target chromosome");
        String pat=input.next();
        String path=GTC.modified_path(pat);
        System.out.println("Give feature name around which file is centered");
        String featurename=input.next();
        System.out.println("Give path of file to save target chromosome");
        Scanner inputt=new Scanner(System.in);
        String pattt=inputt.next();
        String patst= pattt+"\\"+featurename+".csv";
        String paths=GTC.modified_path(patst);
            GTC.read(path,featurename,paths);
    }
}
