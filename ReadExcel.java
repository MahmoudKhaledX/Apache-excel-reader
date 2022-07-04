
package finalproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import java.io.File;



public class ReadExcel {
    String outputString[][];
    
    public ReadExcel() throws IOException
    {
        
        this.outputString=readfile();
    }

    public String[][] getOutputString() {
        return outputString;
    }
                public String[][] readfile() throws FileNotFoundException, IOException {
                    String file = "C:\\Users\\dido_\\Downloads\\Example (1).xlsx" ;
                    FileInputStream inputStream= new FileInputStream(file);
                    XSSFWorkbook workbook =new XSSFWorkbook(inputStream);
                    XSSFSheet sheet=workbook.getSheetAt(0);
                    Iterator iterator = sheet.iterator();
                    ArrayList<String> excelfile=new ArrayList<String>();
                    ArrayList<Integer> noColoumns=new ArrayList<Integer>();
                    int r =0;

                            while(iterator.hasNext())
                            {   int coloumns=0;
                                noColoumns.add(0);
                                XSSFRow row =(XSSFRow) iterator.next();
                                            Iterator cells = row.cellIterator();
                                            while(cells.hasNext())
                                            {   
                                                noColoumns.set(r,coloumns);
                                                coloumns++;
                                                XSSFCell cell=(XSSFCell)cells.next();
                                                switch(cell.getCellType())
                                                {
                                                    case STRING: excelfile.add(cell.getStringCellValue());
                                                    break;
                                                    case NUMERIC :excelfile.add(Double.toString(cell.getNumericCellValue()));
                                                    break;
                                                    default: excelfile.add("null");

                                                }

                                            }
                               r++;

                            }
                              //  System.out.println(noColoumns.toString());

                    int items=0;
                    String[][] array=new String[r][5];
                            for(int j =0;j<r;j++)
                            {
                                            for(int i=0;i<=noColoumns.get(j);i++)
                                            {
                                                array[j][i]=excelfile.get(items);
                                                        items++;
                                            }
                            }
                               /* for (int i=0;i<array.length;i++)
                                {
                                                for(int j=0;j<array[0].length;j++)
                                                {
                                                   System.out.print(array[i][j]);
                                                    //System.out.print(" ");
                                                }
                                    System.out.println("");
                                }*/

               return array; }

    
}
