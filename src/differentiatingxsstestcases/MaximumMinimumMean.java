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
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author iram
 */
public class MaximumMinimumMean {
    String [] feat={"input size","alert","script","onerror","confirm","img","onload","eval", "prompt", "src", "href", "javascript", "window","fromcharcode", "document", "onmouseover", "cookie", "domain", "onfocus","expression" , "iframe", "onclick", "singleQuoteMark","doubleQuoteMark", "leftAngleBracket", "rightAngleBracket", "backslant", "coma", "plus", "httpAndFile"};
    private static Scanner x;
    String strLine = "";
    
    List<Integer> inputlist = new ArrayList<>();
    List<Integer> alertlist = new ArrayList<>();
    List<Integer> scriptlist = new ArrayList<>();
    List<Integer> onerrorlist = new ArrayList<>();
    List<Integer> confirmlist = new ArrayList<>();
    List<Integer> imglist = new ArrayList<>();
    List<Integer> onloadlist = new ArrayList<>();
    List<Integer> evallist = new ArrayList<>();
    List<Integer> promptlist = new ArrayList<>();
    List<Integer> srclist = new ArrayList<>();
    List<Integer> hreflist = new ArrayList<>();
    List<Integer> javascriptlist = new ArrayList<>();
    List<Integer> windowlist = new ArrayList<>();
    List<Integer> fromcharcodelist = new ArrayList<>();
    List<Integer> documentlist = new ArrayList<>();
    List<Integer> onmouseoverlist = new ArrayList<>();
    List<Integer> cookielist = new ArrayList<>();
    List<Integer> domainlist = new ArrayList<>();
    List<Integer> onfocuslist = new ArrayList<>();
    List<Integer> expressionlist = new ArrayList<>();
    List<Integer> iframelist = new ArrayList<>();
    List<Integer> onclicklist = new ArrayList<>();
    List<Integer> singleQuoteMarklist = new ArrayList<>();
    List<Integer> doubleQuoteMarklist = new ArrayList<>();
    List<Integer> leftAngleBracketlist = new ArrayList<>();
    List<Integer> rightAngleBracketlist = new ArrayList<>();
    List<Integer> backslantlist = new ArrayList<>();
    List<Integer> comalist = new ArrayList<>();
    List<Integer> pluslist = new ArrayList<>();
    List<Integer> httpAndFilelist = new ArrayList<>();
    


    
    public String modified_path(String path){
        String changed_path;
        String slash = "\\";
        String escapedSlash = slash+slash;
        String twoEscapedSlashes = escapedSlash+escapedSlash;
        changed_path=path.replaceAll(escapedSlash, twoEscapedSlashes) ;
        return changed_path;
    }
    public void read(String pat){
        System.out.println("what file you want to search into?");
        Scanner input=new Scanner(System.in);
        String feature=input.next();
        String path=pat+"\\"+feature+".csv";
        
        int Maxinput=0;int Maxalert=0;int Maxscript=0;int Maxonerror=0;
        int Maxconfirm=0;int Maximg=0;int Maxonload=0;int Maxeval=0;
        int Maxprompt=0;int Maxsrc=0;int Maxhref=0;int Maxjavascript=0;
        int Maxwindow=0;int Maxfromcharcode=0;int Maxdocument=0;int Maxonmouseover=0;
        int Maxcookie=0;int Maxdomain=0;int Maxonfocus=0;int Maxexpression=0;
        int Maxiframe=0;int Maxonclick=0;int MaxsingleQuoteMark=0;int MaxdoubleQuoteMark=0;
        int MaxleftAngleBracket=0;int MaxrightAngleBracket=0;int Maxbackslant=0;int Maxcoma=0;
        int Maxplus=0;int MaxhttpAndFile=0;
        
        int Mininput=1000;int Minalert=1000;int Minscript=1000;int Minonerror=1000;
        int Minconfirm=1000;int Minimg=1000;int Minonload=1000;int Mineval=1000;
        int Minprompt=1000;int Minsrc=1000;int Minhref=1000;int Minjavascript=1000;
        int Minwindow=1000;int Minfromcharcode=1000;int Mindocument=1000;int Minonmouseover=1000;
        int Mincookie=1000;int Mindomain=1000;int Minonfocus=1000;int Minexpression=1000;
        int Miniframe=1000;int Minonclick=1000;int MinsingleQuoteMark=1000;int MindoubleQuoteMark=1000;
        int MinleftAngleBracket=1000;int MinrightAngleBracket=1000;int Minbackslant=1000;int Mincoma=1000;
        int Minplus=1000;int MinhttpAndFile=1000;
        
        
        
        int inputindex=0;int alertindex=1;int scriptindex=2;int onerrorindex=3;
        int confirmindex=4;int imgindex=5;int onloadindex=6;int evalindex=7;
        int promptindex=8;int srcindex=9;int hrefindex=10;int javascriptindex=11;
        int windowindex=12;int fromcharcodeindex=13;int documentindex=14;int onmouseoverindex=15;
        int cookieindex=16;int domainindex=17;int onfocusindex=18;int expressionindex=19;
        int iframeindex=20;int onclickindex=21;int singleQuoteMarkindex=22;int doubleQuoteMarkindex=23;
        int leftAngleBracketindex=24;int rightAngleBracketindex=25;int backslantindex=26;int comaindex=27;
        int plusindex=28;int httpAndFileindex=29; 
        
        
        
        
        
        
        
        
        
        
        
        int index=0;
        for(int k=0;k<feat.length;k++){
            if(feature.equals(feat[k].toString()))
                index=k;      
            }
        
        try{
            x=new Scanner(new BufferedReader(new FileReader(path))); 
            x.useDelimiter(",");
            while(x.hasNextLine()){
                int zero=0;
                String str1 = Integer.toString(zero);
                String inputline=x.nextLine();
                String[] innarray=inputline.split(",");
                for(int i=0;i<innarray.length;i++){
    
                   if(innarray[i].matches(".*\\d.*")){
                   int inarray=Integer.parseInt(innarray[i]);
                   
                   if(i==inputindex){ 
                       inputlist.add(inarray); //Add in medianlist 
                        if(inarray<Mininput){   //to get minimum out of input column
                            if(innarray[i].equals(str1)==false){    //condition that eliminate if data is zero, because zero is default value of mininput and zero act as noise in data
                                Mininput=inarray;
                            }               
                        }
                        if(inarray>Maxinput){   //to get maximum out of input column
                            Maxinput=inarray;               
                        }
                    }
                    if(i==alertindex){
                        alertlist.add(inarray); //Add in medianlist 
                        if(inarray<Minalert){
                            if(innarray[i].equals(str1)==false){
                                Minalert=inarray;
                            }               
                        }
                        if(inarray>Maxalert){
                            Maxalert=inarray;               
                        }
                    }
                    if(i==scriptindex){
                        scriptlist.add(inarray); //Add in medianlist 
                        if(inarray<Minscript){
                            if(innarray[i].equals(str1)==false){
                                Minscript=inarray;
                            }               
                        }
                        if(inarray>Maxscript){
                            Maxscript=inarray;               
                        }
                    }
                  
                    if(i==onerrorindex){
                        onerrorlist.add(inarray); //Add in medianlist 
                        if(inarray<Minonerror){
                            if(innarray[i].equals(str1)==false){
                                Minonerror=inarray;
                            }               
                        }
                        if(inarray>Maxonerror){
                            Maxonerror=inarray;               
                        }
                    }
                    if(i==confirmindex){
                        confirmlist.add(inarray); //Add in medianlist 
                        if(inarray<Minconfirm){
                            if(innarray[i].equals(str1)==false){
                                Minconfirm=inarray;
                            }               
                        }
                        if(inarray>Maxconfirm){
                            Maxconfirm=inarray;               
                        }
                    }
                    if(i==imgindex){
                        imglist.add(inarray); //Add in medianlist 
                        if(inarray<Minimg){
                            if(innarray[i].equals(str1)==false){
                                Minimg=inarray;
                            }               
                        }
                        if(inarray>Maximg){
                            Maximg=inarray;               
                        }
                    }
    
                    if(i==onloadindex){
                        onloadlist.add(inarray); //Add in medianlist 
                        if(inarray<Minonload){
                            if(innarray[i].equals(str1)==false){
                                Minonload=inarray;
                            }               
                        }
                        if(inarray>Maxonload){
                            Maxonload=inarray;               
                        }
                    }
                    if(i==evalindex){
                        evallist.add(inarray); //Add in medianlist 
                        if(inarray<Mineval){
                            if(innarray[i].equals(str1)==false){
                                Mineval=inarray;
                            }               
                        }
                        if(inarray>Maxeval){
                            Maxeval=inarray;               
                        }
                    }
    
                    if(i==promptindex){
                        promptlist.add(inarray); //Add in medianlist 
                       if(inarray<Minprompt){
                            if(innarray[i].equals(str1)==false){
                                Minprompt=inarray;
                            }               
                        }
                        if(inarray>Maxprompt){
                            Maxprompt=inarray;               
                        }
                    }
                    if(i==srcindex){
                        srclist.add(inarray); //Add in medianlist 
                        if(inarray<Minsrc){
                            if(innarray[i].equals(str1)==false){
                                Minsrc=inarray;
                            }               
                        }
                        if(inarray>Maxsrc){
                            Maxsrc=inarray;               
                        }
                    }
                    
                    if(i==hrefindex){
                        hreflist.add(inarray); //Add in medianlist 
                        if(inarray<Minhref){
                            if(innarray[i].equals(str1)==false){
                                Minhref=inarray;
                            }               
                        }
                        if(inarray>Maxhref){
                            Maxhref=inarray;               
                        }
                    }
    
                    if(i==javascriptindex){
                        javascriptlist.add(inarray); //Add in medianlist 
                        if(inarray<Minjavascript){
                            if(innarray[i].equals(str1)==false){
                                Minjavascript=inarray;
                            }               
                        }
                        if(inarray>Maxjavascript){
                            Maxjavascript=inarray;               
                        }
                    }
                    if(i==windowindex){
                        windowlist.add(inarray); //Add in medianlist 
                        if(inarray<Minwindow){
                            if(innarray[i].equals(str1)==false){
                                Minwindow=inarray;
                            }               
                        }
                        if(inarray>Maxwindow){
                            Maxwindow=inarray;               
                        }
                    }
                    if(i==fromcharcodeindex){
                        fromcharcodelist.add(inarray); //Add in medianlist 
                        if(inarray<Minfromcharcode){
                            if(innarray[i].equals(str1)==false){
                                Minfromcharcode=inarray;
                            }               
                        }
                        if(inarray>Maxfromcharcode){
                            Maxfromcharcode=inarray;               
                        }
                    }
    
                    if(i==documentindex){
                        documentlist.add(inarray); //Add in medianlist 
                        if(inarray<Mindocument){
                            if(innarray[i].equals(str1)==false){
                                Mindocument=inarray;
                            }               
                        }
                        if(inarray>Maxdocument){
                            Maxdocument=inarray;               
                        }
                    }
                    if(i==onmouseoverindex){
                        onmouseoverlist.add(inarray); //Add in medianlist 
                        if(inarray<Minonmouseover){
                            if(innarray[i].equals(str1)==false){
                                Minonmouseover=inarray;
                            }               
                        }
                        if(inarray>Maxonmouseover){
                            Maxonmouseover=inarray;               
                        }
                    }
     
                    if(i==cookieindex){
                        cookielist.add(inarray); //Add in medianlist 
                        if(inarray<Mincookie){
                            if(innarray[i].equals(str1)==false){
                                Mincookie=inarray;
                            }               
                        }
                        if(inarray>Maxcookie){
                            Maxcookie=inarray;               
                        }
                    }
                    if(i==domainindex){
                        domainlist.add(inarray); //Add in medianlist 
                        if(inarray<Minonfocus){
                            if(innarray[i].equals(str1)==false){
                                Minonfocus=inarray;
                            }               
                        }
                        if(inarray>Maxonfocus){
                            Maxonfocus=inarray;               
                        }
                    }
                    if(i==onfocusindex){
                        onfocuslist.add(inarray); //Add in medianlist 
                        if(inarray<Minalert){
                            if(innarray[i].equals(str1)==false){
                                Minalert=inarray;
                            }               
                        }
                        if(inarray>Maxalert){
                            Maxalert=inarray;               
                        }
                    }
                    if(i==expressionindex){
                        expressionlist.add(inarray); //Add in medianlist 
                       if(inarray<Minexpression){
                            if(innarray[i].equals(str1)==false){
                                Minexpression=inarray;
                            }               
                        }
                        if(inarray>Maxexpression){
                            Maxexpression=inarray;               
                        }
                    }       
                    if(i==iframeindex){
                        iframelist.add(inarray); //Add in medianlist 
                       if(inarray<Miniframe){
                            if(innarray[i].equals(str1)==false){
                                Miniframe=inarray;
                            }               
                        }
                        if(inarray>Maxiframe){
                            Maxiframe=inarray;               
                        }
                    }
    
    
                    if(i==onclickindex){
                        onclicklist.add(inarray); //Add in medianlist 
                        if(inarray<Minonclick){
                            if(innarray[i].equals(str1)==false){
                                Minonclick=inarray;
                            }               
                        }
                        if(inarray>Maxonclick){
                            Maxonclick=inarray;               
                        }
                    }
                    if(i==singleQuoteMarkindex){
                        singleQuoteMarklist.add(inarray); //Add in medianlist 
                        if(inarray<MinsingleQuoteMark){
                            if(innarray[i].equals(str1)==false){
                                MinsingleQuoteMark=inarray;
                            }               
                        }
                        if(inarray>MaxsingleQuoteMark){
                            MaxsingleQuoteMark=inarray;               
                        }
                    }
                    if(i==doubleQuoteMarkindex){
                        doubleQuoteMarklist.add(inarray); //Add in medianlist 
                        if(inarray<MindoubleQuoteMark){
                            if(innarray[i].equals(str1)==false){
                                MindoubleQuoteMark=inarray;
                            }               
                        }
                        if(inarray>MaxdoubleQuoteMark){
                            MaxdoubleQuoteMark=inarray;               
                        }
                    }
                    if(i==leftAngleBracketindex){
                       leftAngleBracketlist.add(inarray); //Add in medianlist 
                       if(inarray<MinleftAngleBracket){
                            if(innarray[i].equals(str1)==false){
                                MinleftAngleBracket=inarray;
                            }               
                        }
                        if(inarray>MaxleftAngleBracket){
                            MaxleftAngleBracket=inarray;               
                        }
                    }

                    if(i==rightAngleBracketindex){
                        rightAngleBracketlist.add(inarray); //Add in medianlist 
                        if(inarray<MinrightAngleBracket){
                            if(innarray[i].equals(str1)==false){
                                MinrightAngleBracket=inarray;
                            }               
                        }
                        if(inarray>MaxrightAngleBracket){
                            MaxrightAngleBracket=inarray;               
                        }
                    }
                    if(i==backslantindex){
                        backslantlist.add(inarray); //Add in medianlist 
                        if(inarray<Minbackslant){
                            if(innarray[i].equals(str1)==false){
                                Minbackslant=inarray;
                            }               
                        }
                        if(inarray>Maxbackslant){
                            Maxbackslant=inarray;               
                        }
                    }
                    if(i==comaindex){
                        comalist.add(inarray); //Add in medianlist 
                        if(inarray<Mincoma){
                            if(innarray[i].equals(str1)==false){
                                Mincoma=inarray;
                            }               
                        }
                        if(inarray>Maxcoma){
                            Maxcoma=inarray;               
                        }
                    }
                    
                    if(i==plusindex){
                        pluslist.add(inarray); //Add in medianlist 
                        if(inarray<Minplus){
                            if(innarray[i].equals(str1)==false){
                                Minplus=inarray;
                            }               
                        }
                        if(inarray>Maxplus){
                            Maxplus=inarray;               
                        }
                    }
                    if(i==httpAndFileindex){
                        httpAndFilelist.add(inarray); //Add in medianlist 
                        if(inarray<MinhttpAndFile){
                            if(innarray[i].equals(str1)==false){
                                MinhttpAndFile=inarray;
                            }               
                        }
                        if(inarray>MaxhttpAndFile){
                            MaxhttpAndFile=inarray;               
                        }
                    }
                }
                }
            } 
            
            int[] inputarray = inputlist.stream().mapToInt(i -> i).toArray();
            Arrays.sort(inputarray);//this sorts array in ascending order
            for(int g=0;g<inputarray.length;g++){
            System.out.println(inputarray[g]);
            }
            int medianindex=getmedianindex(inputarray);
            int inputmedian=getmedianinput(inputarray,medianindex);
            System.out.println("index of median "+medianindex+" median is: "+inputmedian);
            
            String [] listsname={"inputlist","alertlist", "scriptlist", "onerrorlist", "confirmlist", "imglist",
    "onloadlist", "evallist", "promptlist", "srclist", "hreflist",
    "javascriptlist", "windowlist", "fromcharcodelist", "documentlist",   
    "onmouseoverlist","cookielist","domainlist", "onfocuslist",
    "expressionlist", "iframelist", "onclicklist","singleQuoteMarklist",                    
    "doubleQuoteMarklist", "leftAngleBracketlist", "rightAngleBracketlist",
  "backslantlist","comalist","pluslist","httpAndFilelist"};
            //for(int i=0;i<listsname.length;i++){
                //int medanindex=getmedianindex(listsname[i].stream().mapToInt(i -> i).toArray());
                //int inpumedian=getmedianinput(inputarray,medanindex);
            //}
//            String[] arr=new String[list2.size()];
//            for(int j=0;j<list2.size();j++){
//            arr=list2.toArray(new String[0]);
//                }
            int[] min_array={Mininput,Minalert,Minscript,Minonerror,Minconfirm,Minimg,Minonload,Mineval,Minprompt,Minsrc,Minhref,Minjavascript,Minwindow,Minfromcharcode,Mindocument,Minonmouseover,Mincookie,Mindomain,Minonfocus,Minexpression,Miniframe,Minonclick,MinsingleQuoteMark,MindoubleQuoteMark,MinleftAngleBracket,MinrightAngleBracket,Minbackslant,Mincoma,Minplus,MinhttpAndFile};
            int[] max_array={Maxinput,Maxalert,Maxscript,Maxonerror,Maxconfirm,Maximg,Maxonload,Maxeval,Maxprompt,Maxsrc,Maxhref,Maxjavascript,Maxwindow,Maxfromcharcode,Maxdocument,Maxonmouseover,Maxcookie,Maxdomain,Maxonfocus,Maxexpression,Maxiframe,Maxonclick,MaxsingleQuoteMark,MaxdoubleQuoteMark,MaxleftAngleBracket,MaxrightAngleBracket,Maxbackslant,Maxcoma,Maxplus,MaxhttpAndFile};
            for(int i=0;i<feat.length;i++){
                if(min_array[i]==1000){
                     min_array[i]=0;
                }
            System.out.println("feature: "+feat[i]+" and maximum is: "+ max_array[i]+" minimum is: "+min_array[i]);
            }
            
            
        //insertion(arr,feature);  
        }
        catch (FileNotFoundException e) {
                    System.err.println("directory not found");
        }
        
    }
    
    public int getmedianindex(int a[]){
        int median=0;
        int lim=a.length-1;
        //System.out.println("limit "+lim);
        if((lim%2)== 0){
            int lim_modi=lim-1;
            median=((lim_modi)/2);
        }
        else{
            median=((lim)/2);
        }
       // System.out.println("median index "+median);
        return median;
    }
    public int getmedianinput(int []b, int index){
        int meedian=0;
       // System.out.println("index "+index);
        for(int h=0;h<b.length;h++){
            if(h==index){
                meedian=b[h];
            }
        }       
            return meedian;
    }
    
    
    public static  void main(String[] args){
        Scanner input=new Scanner(System.in);
        MaximumMinimumMean mmm=new MaximumMinimumMean();
        System.out.println("give path of directory to extract mean median and mode");
        String unprocessedpath= input.next();
        String path=mmm.modified_path(unprocessedpath);
        mmm.read(path);

        
        
    }
}
