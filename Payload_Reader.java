package differentiatingxsstestcases;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author iram
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Payload_Reader {
    public Payload_Reader(){
    
    }
    
    StringBuilder sb = new StringBuilder();
    String strLine = "";
    List<String> list = new ArrayList<>();
    List<String> list2 = new ArrayList<>();
    Integer count;
    Map<String, Integer> words = new HashMap<>(); 
    String data1;
    
    public void read(String Path){
        String filepath;
        filepath = modified_path(Path);
        try {
             BufferedReader br = new BufferedReader(new FileReader(filepath));
              while (strLine != null)
               {
//                strLine = br.readLine();//sb.append(strLine);//sb.append(System.lineSeparator());
                strLine = br.readLine();
                list.add(strLine);
                if (strLine==null)
                   break;
                
            }
              int counting=0;
              
            int n=list.size();
            String [] nw = new String [n];
            //path in which we wanted to save data
            System.out.println("Give path of file in which you wanted to save attributes of payload");
            Scanner input=new Scanner(System.in);
            String pa=input.next();
            String mpa=modified_path(pa);
            System.out.println("suggest name of file");
            String nam=input.next();
            String pat=mpa+"\\"+nam+".csv";
              for(int i=0;i<list.size()-1;i++){
                  int j=i;
                  nw[i]=list.get(i);
                  //System.out.println("Data number " + j + " is:" + nw[i]);
                  nw[i] = nw[i].replaceAll("%(?![0-9a-fA-F]{2})", "%25");
                  String result = java.net.URLDecoder.decode(nw[i], (StandardCharsets.UTF_8).toString());
                  list2.add(result);
                  System.out.println("new list " + j + " is:" + list2.get(i));
                  String data=list2.get(i).toString();
                  data1=Tolowercase(data);
                  System.out.println(data1);
                 
                  
           
                  Checking_Vulnerability(data1,pat);
//                  if (nw[i].contains("script"))
                      counting++;
              }
         //System.out.println((list.toArray()));
         System.out.println("number of items are: " +counting );
         //System.out.println(words);
             br.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
    }
          
    public Map<String,Object> Checking_Vulnerability(String dat, String pat){ 
        char less_than = '<';
          int countLessThan=0;
          char greater_than= '>';
          int countGreaterThan=0;
          char curlyBracket_open='(';
          int curlyBracketOpen=0;
          char curlyBracket_close=')';
          int curlyBracketClose=0;
          char semicolon=';';
          int SemiColon=0;
          int countsrc=0;
          char singleQuoteMark='\'';
          int singleQuote=0;
          char backslant='\\';
          int backSlant=0;
          char doubleQuoteMark='"';
          int doubleQuote=0;
          char plus='+';
          int Plus=0;
          char coma=',';
          int countcoma=0;
          int countAlert=0;
          int countonerror=0;
          int countonclick=0;
          int countConfirm=0;
    int counthttp=0;
          int countfttp=0;
          int countfile=0;
          int counthref=0;
          int counteval=0;
          int countDocument=0;
          int countOnMouseOver=0;
          int countonload=0;
          int countwindow=0;
          int countcookie=0;
          int countdomain=0;
          int countprompt=0;
          int onfocus=0;
          int countFromCharCode=0;
          int countjavascript=0;
          int img_count=0;
          int iframe_count=0;
          int script_count=0;
          int httpfttpfile=0;
          String splitted;    
          
          int detectorscript=0;
          int expression=0;
          char one='<';
          char two='(';
          char three=')';
          char four='|';
          char five='/';
          char six='[';
          char seven=']';
          char eight='^';
          char nine='>';
          for(int i=0; i<dat.length()-1;i++){
              if(dat.charAt(i)== less_than){
                  countLessThan++;
                }
              else if(dat.charAt(i)== coma){
                  countcoma++;
                }
              else if(dat.charAt(i)== greater_than){
                   countGreaterThan++;
                }
              else if(dat.charAt(i)== curlyBracket_open){
                   curlyBracketOpen++;
                }
              else if(dat.charAt(i)== curlyBracket_close){
                   curlyBracketClose++;
                }
              else if(dat.charAt(i)== semicolon){
                   SemiColon++;
                }
              else if(dat.charAt(i)== singleQuoteMark){
                   singleQuote++;
                }
              else if(dat.charAt(i)== backslant){
                   backSlant++;
                   expression++;
                }
              else if(dat.charAt(i)== doubleQuoteMark){
                   doubleQuote++;
                }
              else if(dat.charAt(i)== plus){
                   Plus++;
                }
              else if(dat.charAt(i)== one){
                   expression++;
                }
              else if(dat.charAt(i)== two){
                   expression++;
                }
              else if(dat.charAt(i)== three){
                   expression++;
                }
              else if(dat.charAt(i)== four){
                   expression++;
                }
              else if(dat.charAt(i)== five){
                   expression++;
                }
              else if(dat.charAt(i)== six){
                   expression++;
                }
              else if(dat.charAt(i)== seven){
                   expression++;
                }
              else if(dat.charAt(i)== eight){
                   expression++;
                }
              else if(dat.charAt(i)== nine){
                   expression++;
                }
              
            }
          for(int j=0; j<dat.length()-3; j++){
              if(dat.charAt(j) == 's'){
                  if(dat.charAt(j+1) == 'r'){
                      if(dat.charAt(j+2) == 'c'){
                        countsrc++;
                } } }
          }
//          int countAlert=0;
          for(int f=0;f<dat.length()-5;f++){
              if(dat.charAt(f)=='a'){
                  if(dat.charAt(f+1)=='l'){
                      if(dat.charAt(f+2)=='e'){
                          if(dat.charAt(f+3)=='r'){
                              if(dat.charAt(f+4)=='t'){
                                  countAlert++;
                }   }   }   }   }
          }
//          int countonload=0;
//          int countwindow=0;
//          int countcookie=0;
//          int countdomain=0;
//          int countprompt=0;
          for(int k=0; k<dat.length()-6; k++){
              if(dat.charAt(k) == 'o'){
                  if(dat.charAt(k+1) == 'n'){
                      if(dat.charAt(k+2) == 'l'){
                          if(dat.charAt(k+3)=='o'){
                              if(dat.charAt(k+4)=='a'){
                                  if(dat.charAt(k+5)=='d'){
                                      countonload++;
                }   }   }   }   }   }   }
          for(int k=0; k<dat.length()-6; k++){
              if(dat.charAt(k)=='w'){
                      if(dat.charAt(k+1)=='i'){
                          if(dat.charAt(k+2)=='n'){
                              if(dat.charAt(k+3)=='d'){
                                  if(dat.charAt(k+4)=='o'){
                                      if(dat.charAt(k+5)=='w'){
                                          countwindow++;
                }   }   }   }   }   }}
          for(int k=0; k<dat.length()-6; k++){
              if(dat.charAt(k)=='c'){
                      if(dat.charAt(k+1)=='o'){
                          if(dat.charAt(k+2)=='o'){
                              if(dat.charAt(k+3)=='k'){
                                  if(dat.charAt(k+4)=='i'){
                                      if(dat.charAt(k+5)=='e'){
                                          countcookie++;
                }   }   }   }   }   }}
          for(int k=0; k<dat.length()-6; k++){
              if(dat.charAt(k)=='d'){
                      if(dat.charAt(k+1)=='o'){
                          if(dat.charAt(k+2)=='m'){
                              if(dat.charAt(k+3)=='a'){
                                  if(dat.charAt(k+4)=='i'){
                                      if(dat.charAt(k+5)=='n'){
                                          countdomain++;
                }   }   }   }   }   }}
          for(int k=0; k<dat.length()-6; k++){
              if(dat.charAt(k) == 'p'){
                    if(dat.charAt(k+1) == 'r'){
                          if(dat.charAt(k+2) == 'o'){
                              if(dat.charAt(k+3)=='m'){
                                  if(dat.charAt(k+4)=='p'){
                                      if(dat.charAt(k+5)=='t'){
                                          countprompt++;
                }   }   }   }   }   }
          
          }   
          
          
//since onclick is seven character long so we iterate it upto less than 7 times. to avoid stringOutofboundException
//          int countonerror=0;
//          int countonclick=0;
//          int countConfirm=0;
          for(int k=0; k<dat.length()-7; k++){
              if(dat.charAt(k) == 'o'){
                  if(dat.charAt(k+1) == 'n'){
                      if(dat.charAt(k+2) == 'c'){
                          if(dat.charAt(k+3)=='l'){
                              if(dat.charAt(k+4)=='i'){
                                  if(dat.charAt(k+5)=='c'){
                                      if(dat.charAt(k+6)=='k'){
                                          countonclick++;
                        }   }   }   }   }   }   }}
              for(int k=0; k<dat.length()-7; k++){
              if(dat.charAt(k) == 'o'){
                  if(dat.charAt(k+1) == 'n'){
                      if(dat.charAt(k+2) == 'e'){
                          if(dat.charAt(k+3)=='r'){
                              if(dat.charAt(k+4)=='r'){
                                  if(dat.charAt(k+5)=='o'){
                                      if(dat.charAt(k+6)=='r'){
                                          countonerror++;
                        }   }   }   }   }   
                }   }}
              //int onfocus=0;
              for(int k=0; k<dat.length()-7; k++){
              if(dat.charAt(k) == 'o'){
                  if(dat.charAt(k+1) == 'n'){
                      if(dat.charAt(k+2) == 'f'){
                          if(dat.charAt(k+3)=='o'){
                              if(dat.charAt(k+4)=='c'){
                                  if(dat.charAt(k+5)=='u'){
                                      if(dat.charAt(k+6)=='s'){
                                          onfocus++;
                        }   }   }   }   }   
                }   }}
              
             for(int k=0; k<dat.length()-7; k++){ 
              if(dat.charAt(k)=='c'){
                  if(dat.charAt(k+1)=='o'){
                      if(dat.charAt(k+2)=='n'){
                          if(dat.charAt(k+3)=='f'){
                              if(dat.charAt(k+4)=='i'){
                                  if(dat.charAt(k+5)=='r'){
                                      if(dat.charAt(k+6)=='m'){
                                          countConfirm++;
                }   }   }   }   }   }   }
            }
          

          for(int k=0; k<dat.length()-4; k++){
              if(dat.charAt(k)=='h'){
                  if(dat.charAt(k+1)=='t'){
                      if(dat.charAt(k+2)=='t'){
                          if(dat.charAt(k+3)=='p'){
                              counthttp++;
                }   }   }   }}
          for(int k=0; k<dat.length()-4; k++){
              if(dat.charAt(k)=='f'){
                if(dat.charAt(k+1)=='t'){
                    if(dat.charAt(k+2)=='t'){
                          if(dat.charAt(k+3)=='p'){
                              countfttp++;
                }   }   }   }}
          for(int k=0; k<dat.length()-4; k++){
              if(dat.charAt(k)=='f'){
                if(dat.charAt(k+1)=='i'){
                    if(dat.charAt(k+2)=='l'){
                          if(dat.charAt(k+3)=='e'){
                              countfile++;
                }   }   }   }}
          for(int k=0; k<dat.length()-4; k++){
              if(dat.charAt(k)=='h'){
                if(dat.charAt(k+1)=='r'){
                    if(dat.charAt(k+2)=='e'){
                          if(dat.charAt(k+3)=='f'){
                              counthref++;
                }   }   }   }}
          for(int k=0; k<dat.length()-4; k++){
              if(dat.charAt(k)=='e'){
                if(dat.charAt(k+1)=='v'){
                    if(dat.charAt(k+2)=='a'){
                          if(dat.charAt(k+3)=='l'){
                              counteval++;
                }   }   }   }
          }
          
//          int countDocument=0;
          for(int k=0; k<dat.length()-8; k++){ 
              if(dat.charAt(k)=='d'){
                  if(dat.charAt(k+1)=='o'){
                      if(dat.charAt(k+2)=='c'){
                          if(dat.charAt(k+3)=='u'){
                              if(dat.charAt(k+4)=='m'){
                                  if(dat.charAt(k+5)=='e'){
                                      if(dat.charAt(k+6)=='n'){
                                          if(dat.charAt(k+7)=='t'){
                                          countDocument++;
               }    }   }   }   }   }   }   }
            }
        
          //int countOnMouseOver=0;
          for(int k=0;k<dat.length()-11;k++){
              if(dat.charAt(k)=='o'){
                  if(dat.charAt(k+1)=='n'){
                      if(dat.charAt(k+2)=='m'){
                          if(dat.charAt(k+3)=='o'){
                              if(dat.charAt(k+4)=='u'){
                                  if(dat.charAt(k+5)=='s'){
                                      if(dat.charAt(k+6)=='e'){
                                          if(dat.charAt(k+7)=='o'){
                                              if(dat.charAt(k+8)=='v'){
                                                  if(dat.charAt(k+9)=='e'){
                                                      if(dat.charAt(k+10)=='r'){
                                                          countOnMouseOver++;
                }   }   }   }   }   }   }   }   }   }   }
          }
//          int countFromCharCode=0;
          for(int k=0;k<dat.length()-11;k++){
              if(dat.charAt(k)=='f'){
                  if(dat.charAt(k+1)=='r'){
                      if(dat.charAt(k+2)=='o'){
                          if(dat.charAt(k+3)=='m'){
                              if(dat.charAt(k+4)=='c'){
                                  if(dat.charAt(k+5)=='h'){
                                      if(dat.charAt(k+6)=='a'){
                                          if(dat.charAt(k+7)=='r'){
                                              if(dat.charAt(k+8)=='c'){
                                                  if(dat.charAt(k+9)=='o'){
                                                      if(dat.charAt(k+10)=='d'){
                                                          if(dat.charAt(k+11)=='e'){
                                                              countFromCharCode++;
                }   }   }   }   }   }   }   }   }   }   }   }
          }
          
          //int countjavascript=0;
          for(int k=0;k<dat.length()-10;k++){
              if(dat.charAt(k)=='j'){
                  if(dat.charAt(k+1)=='a'){
                      if(dat.charAt(k+2)=='v'){
                          if(dat.charAt(k+3)=='a'){
                              if(dat.charAt(k+4)=='s'){
                                  if(dat.charAt(k+5)=='c'){
                                      if(dat.charAt(k+6)=='r'){
                                          if(dat.charAt(k+7)=='i'){
                                              if(dat.charAt(k+8)=='p'){
                                                  if(dat.charAt(k+9)=='t'){
                                                     countjavascript++;
                                                  }   }   }   }   }   }   }   }   }   }
          }
          
          httpfttpfile=counthttp+countfttp+countfile;           
          Document htmlFile;// = null;
          htmlFile = Jsoup.parse(dat, "ISO-8859-1");
          //counting script tag
          Elements scriptElement = htmlFile.getElementsByTag("script");
          script_count=scriptElement.size();
         //System.out.println("number of script: "+ script_count);
         
         //counting iframe tag
         Elements iframeElement = htmlFile.getElementsByTag("iframe");
         iframe_count=iframeElement.size();
        // System.out.println("number of <iframe> are: "+iframe_count);
         
         //counting img tag
         Elements imgElement = htmlFile.getElementsByTag("img");
         img_count=imgElement.size();
         //System.out.println("number of <img> are: "+img_count);

          Elements link = htmlFile.select("a");
          int numberofa=link.size();
          //System.out.println("number of a are: "+numberofa);
          
          System.out.println("input size: " + dat.length()); 
          System.out.println("number of alert: " + countAlert);
          System.out.println("number of script: " + script_count);
          System.out.println("number of onerror: " + countonerror);
          System.out.println("number of confirm: " + countConfirm);
          System.out.println("number of img: " + img_count);
          System.out.println("number of onload: " + countonload);
          System.out.println("number of eval: " + counteval);
          System.out.println("number of prompt: " + countprompt);
          System.out.println("number of src: " + countsrc);
          System.out.println("number of href: " + counthref);
          System.out.println("number of javascript: " + countjavascript);
          System.out.println("number of window: " + countwindow);
          System.out.println("number of fromcharcode: " + countFromCharCode);
          System.out.println("number of document: " + countDocument);
          System.out.println("number of onmouseoveer: " + countOnMouseOver);
          System.out.println("number of cookie: " + countcookie);
          System.out.println("number of domain: " + countdomain);
          System.out.println("number of onfocus: " + onfocus);
          System.out.println("number of expression: " + expression);
          System.out.println("number of iframe: " + iframe_count);
          System.out.println("number of onclick: " + countonclick);
          System.out.println("number of singlequotemark: " + singleQuote);
          System.out.println("number of doublequotemark: " + doubleQuote);
          System.out.println("number of leftanglebracket: " + countLessThan);
          System.out.println("number of rightanglebracket: " + countGreaterThan);
          System.out.println("number of backslant: " + backSlant);
          System.out.println("number of coma: " + countcoma);
          System.out.println("number of plus: " + Plus);
          System.out.println("number of httpandFile: " + httpfttpfile); 
                
          Object frequency;
          Map<String,Object> toreturn=new HashMap<>();
          
          int[] sirdard=new int[]{dat.length(),countAlert,script_count,countonerror,countConfirm,img_count,countonload,counteval,countprompt,countsrc,counthref,                                                                                     
                      countjavascript,countwindow,countFromCharCode,countDocument,countOnMouseOver,countcookie,countdomain,onfocus, expression,iframe_count,countonclick,singleQuote,doubleQuote,countLessThan,countGreaterThan,backSlant,countcoma,Plus,httpfttpfile}; 
          
          insertion(sirdard,pat);
          return toreturn;
    }                  
    public void insertion(int [] array,String pat) {
          try{
              FileOutputStream fos= new FileOutputStream(pat,true);
              PrintWriter pw=new PrintWriter(fos);
              BufferedReader br = new BufferedReader(new FileReader(pat));  
              try {
              if (br.readLine() == null ){
                pw.println("input size, alert, script,onerror, confirm, img, onload, eval, prompt, src, href, javascript, window, "
                      + "fromcharcode, document, onmouseover, cookie, domain, onfocus, expression, iframe, onclick, singleQuoteMark, "
                        + "doubleQuoteMark, leftAngleBracket, rightAngleBracket, backslant, coma, plus, httpAndFile");
                for(int i=0;i<array.length+1;i++){
                    if(i==0){
                        pw.print('\n'+array[i]);
                    }
                    if(i>0 & i<array.length){
                       pw.print(","+array[i]);
                    }
                    if(i==array.length){
                        pw.append('\n');
                    }}
                } 
              else{
                     for(int ii=0;ii<array.length+1;ii++){
                         if(ii==0){
                        pw.print(array[ii]);
                    }
                    if(ii>0 & ii<array.length){
                       pw.print(","+array[ii]);
                    }
                         if(ii==array.length){
                            pw.append('\n');
                        }}}
                }
              catch(Exception e){
                System.err.println("Unable to write the file.");              }
              pw.flush();
              pw.close();
          }
          catch(FileNotFoundException e){
              System.err.println("File not found");;
          }
//          return true;
    }
    
    public String modified_path(String path){
        String changed_path;
        String slash = "\\";
        String escapedSlash = slash+slash;
        String twoEscapedSlashes = escapedSlash+escapedSlash;
        changed_path=path.replaceAll(escapedSlash, twoEscapedSlashes) ;
        return changed_path;
    }
    public String Tolowercase(String da){
        char [] in = da.toCharArray();
        char [] compare = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char [] compares="abcdefghijklmnopqrstuvwxyz".toCharArray();       
        for (int i=0; i<in.length; i++) 
        { 
            for(int j=0;j<compare.length;j++){
                if(compare[j]==in[i]){
                    in[i]=compares[j];
        }   }   }
            String did=new String(in);
            return did;
    }
    
    public static void main(String []args){
    System.out.println("give file path");
    String pa;
    Scanner input=new Scanner(System.in);
    pa=input.next();
    Payload_Reader re=new Payload_Reader();
    re.read(pa);
    }
}
