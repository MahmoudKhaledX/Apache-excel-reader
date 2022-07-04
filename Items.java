/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package finalproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author dido_
 */
public class Items {

ArrayList<String> Parents;
ArrayList<String> childs;
SeperateAPI x;
String[] ApiNames;
    public Items() throws IOException {
        Parents=new ArrayList<String>();
        childs=new ArrayList<String>();
         x=new SeperateAPI();
        String[][][] z = x.getArraysofAPI();
        ApiNames=new String[x.APInumber];
        for(int i=0;i<x.APInumber;i++){
           // System.out.println(x.getApiName(i));
            ApiNames[i]=x.getApiName(i);
            
        for(int j=0;j<5;j++){
        String[] f = x.getColoumns(z[i], i, j);
        if(j==1)
        {          String[] type = x.getColoumns(z[i], i, 2);
                    String[] values = x.getColoumns(z[i], i, 3);
                    String[] mandatory = x.getColoumns(z[i], i, 4);
                    String[] io = x.getColoumns(z[i], i, 0);
            for(int jj=0;jj<f.length;jj++)
        {
            if(f[jj].split("/").length==2)
            {   String[] l=f[jj].split("/");
            childs.add("");
                Parents.add(l[1]+"/"+type[jj]+"/"+values[jj]+"/"+mandatory[jj]+"/"+io[jj]);
            }
            else if (!type[jj].equals("string"))
            {   childs.add("");
                Parents.add(type[jj]+"/"+type[jj]+"/"+values[jj]+"/"+mandatory[jj]+"/"+io[jj]);
                                       String index[]=f[jj].split("/");
                        String index2= index[index.length-2];
                        int index3=0;
                        for(int ii=0;ii<Parents.size();ii++)
                        {   if(Parents.get(ii).split("/")[0].equals(index2))
                        {
                            index3=ii;
                            break;
                        }
                        }
                        childs.set(index3,childs.get(index3)+index[index.length-1]+"/"+type[jj]+"/"+values[jj]+"/"+mandatory[jj]+"/"+io[jj]+" ");            }
            else
                    { 
                        String index[]=f[jj].split("/");
                        String index2= index[index.length-2];
                        int index3=0;
                        for(int ii=0;ii<Parents.size();ii++)
                        {   if(Parents.get(ii).split("/")[0].equals(index2))
                        {
                            index3=ii;
                            break;
                        }
                        }
                        
                        childs.set(index3,childs.get(index3)+index[index.length-1]+"/"+type[jj]+"/"+values[jj]+"/"+mandatory[jj]+"/"+io[jj]+" ");
                    }
        }
            
        }
       // System.out.println(Arrays.toString(f));
        }
         //   System.out.println("");
           Parents.add("break");
           childs.add("break");
        }
       // System.out.println(Parents.toString());
        
         //       System.out.println(childs.toString());

    }

    public ArrayList<String> getParents() {
        return Parents;
    }

    public ArrayList<String> getChilds() {
        return childs;
    }

    public String[] getApiNames() {
        return ApiNames;
    }
    
    
}
