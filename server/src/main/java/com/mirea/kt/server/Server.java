/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mirea.kt.server;

import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author HP
 */
public class Server {

    public static void main(String[] args) {
        String server = "https://android-for-students.ru";
        String serverPath = "/coursework/login.php";
        HashMap<String,String> map = new HashMap();
        map.put("lgn","Student7604"); 
        map.put("pwd", "oZyoE8a"); 
        map.put("g", "RIBO-04-21");
        HTTPRunnable httpRunnable = new HTTPRunnable (server + serverPath, map);
        Thread th = new Thread( httpRunnable);
        th.start ();
        try {
            th.join(); }
        catch (InterruptedException еx) {
        }
        finally{
            JSONObject jsonObject = new JSONObject(httpRunnable.getResponseBody());
            int result = jsonObject.getInt("result_code");
            System.out.println("Result: "+ result);
            jsonObject.getString("title");
            System.out.println("title: " +jsonObject.getString("title"));
            jsonObject.getString("task");
            System.out.println("task: " +jsonObject.getString("task"));
            jsonObject.getInt("variant");
            System.out.println("variant: " +jsonObject.getInt("variant"));
            //System.out.println("Text: "+ jsonObject.getString("message_text"));
            //switch (result) {
              //  case 1: 
                //    JSONArray jsonArray = jsonObject.getJSONArray( "title");
                  //  System.out.println("title:");
                    //for(int i=0;i < jsonArray.length();i++){
                      //  System.out.println((i+1)+")"+jsonArray.get(i));
                    //}
                    //break;
                //case 0:
                  //  break;
                //default: 
                  //  break;
            //}
        }
    }
}
