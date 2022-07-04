/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package finalproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class SeperateAPI {

        ArrayList<Integer> startindex= new ArrayList<Integer>();
        ArrayList<Integer> endindex= new ArrayList<Integer>();
        ArrayList<Integer> IOindex= new ArrayList<Integer>();
        ArrayList<String> ApiName= new ArrayList<String>();

        int APInumber=0;
            String FullAPI[][];
                        int maxrows=0;
            int[] numberofrows;
            int[] rowsStart;
                        String [][][] arraysofAPI=new String[APInumber][maxrows][5];
    public SeperateAPI() throws IOException {

        ReadExcel excelfile=new ReadExcel();
       FullAPI=excelfile.getOutputString();
                    intialize();}
                                   /*     for (int i=0;i<FullAPI.length;i++)
                                {
                                                for(int j=0;j<FullAPI[0].length;j++)
                                                {
                                                   System.out.print(FullAPI[i][j]);
                                                    System.out.print(" ");
                                                }
                                    System.out.println("");
                                }*/
    public void intialize(){
        for(int i=0;i<FullAPI.length;i++)
        {   
            for(int j=0; j<5;j++)
            {
                try{
                if(FullAPI[i][j].equals("HTTP Operation"))
                {
                    
                    if(APInumber!=0)
                    {
                        endindex.set(APInumber-1, i-2);
                    }
                    String e = FullAPI[i-1][j].substring(24,FullAPI[i-1][j].length()-1 );
                    startindex.add((i-1));
                    ApiName.add(e);
                    endindex.add((FullAPI.length-1));
                    IOindex.add(0);
                    APInumber++;
   
                }
                
            
            if(FullAPI[i][j].equals("I/o"))
            {
                                    IOindex.set(APInumber-1,i+1);

            }
            
        }
                        catch(NullPointerException x){
                    
                    }
            }

        }
       // System.out.println(" "+APInumber+" "+ startindex.toString()+" "+endindex.toString()+" "+IOindex.toString());

            this.numberofrows = new int[APInumber];
            this.rowsStart = new int[APInumber];
            for(int i=0;i<APInumber;i++)
            {
                            numberofrows[i]=(endindex.get(i)-startindex.get(i)+1);
                            rowsStart[i]=(IOindex.get(i)-startindex.get(i));
                            if(maxrows<numberofrows[i])
                            {
                                maxrows=numberofrows[i];
                            }
            }
           // System.out.println(Arrays.toString(rowsStart));
         //   System.out.println(""+maxrows);


                        this.arraysofAPI=new String[APInumber][maxrows][5];

            for(int i=0;i<APInumber;i++)
            {      
                int row=0;
                            for(int j=startindex.get(i);j<=endindex.get(i);j++)
                        {  
                                        for(int z=0;z<5;z++)
                                        {
                                            this.arraysofAPI[i][row][z]=this.FullAPI[j][z];
                                        }
                            row++;
                        }
                
            }}
            
            

    
    public String[] getColoumns(String[][] x, int index,int conumber)
    {            String[] y=new String[numberofrows[index]-rowsStart[index]];
                int jj=0;
        for(int i=rowsStart[index];i<numberofrows[index];i++)
        {  
            y[jj]=x[i][conumber];
            jj++;
        }
        return y;
    }

    public String[][][] getArraysofAPI() {
        return arraysofAPI;
    }

    public String getApiName(int index) {
        return ApiName.get(index);
    }
    
}
