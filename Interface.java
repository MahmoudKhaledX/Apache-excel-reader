/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package finalproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author dido_
 */
public class Interface extends Application {


    public static void main(String[] args) {
        Application.launch(args);
    }

    

    @Override
    public void start(Stage stage) throws Exception {
        
        Items test =new Items();
        ArrayList<String> x=test.getChilds();
        ArrayList<String> y=test.getParents();
        String[] z=test.getApiNames();
        String[] split;
        String[] split2;
        String full;
                System.out.println(x);
                System.out.println(y);
                TabPane panel=new TabPane();
                Tab[] tab = new Tab[test.ApiNames.length];
                for (int i =0;i<tab.length;i++)
                {
                    tab[i]=new Tab(z[i]);
                    panel.getTabs().add(tab[i]);
                }
                  HBox hBox = new HBox(panel);

                 Scene scene = new Scene(hBox);

        HBox[] hBoxs=new HBox[tab.length];
        for (int i=0;i<tab.length;i++){
            hBoxs[i]=new HBox();
            hBoxs[i].setPadding(new Insets(10,10,10,10));
        }       
            int hboxInd=0;
            ListView<String>[] list=new ListView[y.size()];
            for(int ii=0;ii<y.size();ii++)
            {       if(y.get(ii).equals("break"))
            {
                hboxInd++;
                continue;
            }   try{
                list[ii] = new ListView<>();
                split=y.get(ii).split("/");
                full="\t\t\t"+split[0]+"\nType : " + split[1]+"\nAllowedValues : "+((split[2].equals("null"))?"All":split[2])+"\nMandatory : "+split[3]+"\nI/O : "+split[4];
                list[ii].getItems().add(full);
                list[ii].getItems().add("");
                split2=x.get(ii).split(" ");
                if(split2.length==1)
                {               hBoxs[hboxInd].getChildren().add(list[ii]);

                    continue;
                }
                for(int jj=0;jj<split2.length;jj++)
                {   split=split2[jj].split("/");
                full="\t\t\t"+split[0]+"\nType : " + split[1]+"\nAllowedValues : "+((split[2].equals("null"))?"All":split[2])+"\nMandatory : "+split[3]+"\nI/O : "+split[4];
                list[ii].getItems().add(full);
                }
            }
            catch(NullPointerException l){}
            hBoxs[hboxInd].getChildren().add(list[ii]);

            }
        
        for (int i=0;i<tab.length;i++){
            tab[i].setContent(hBoxs[i]);
        }

                final Label label = new Label("Address Book");
                label.setFont(new Font("Arial", 20));

                    stage.setScene(scene);
                    stage.setTitle(label.getText());
                    stage.setResizable(true);
                    stage.setMaximized(true);

                    stage.show();
                
                
    }
    
}
