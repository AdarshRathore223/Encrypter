package mypacks;
import java.io.FileWriter;
import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class mypacks {
    
   static public int[] rkey(int number){
       int[] temp = new int [number];
        for (int i=0;i<number;i++){
            temp [i] =(int) (Math.random()*10);
        }
        return temp;
    }

    static public String encrypter(int[] akey,String word){
    	int[] bkey = getkey(akey[50]);
    	int[] rkey = new int [50];
    	for (int i=0;i<50;i++){
    		rkey[i] = akey[i] + bkey[i];
    		if (rkey[i] >= 10) {
    			rkey[i]-=10;
    		}
    	}
        int[] Message_ascii = new int[word.length()];
        char[] encryptedtext = new char[word.length()];
        
        for(int i=0; i<word.length();i++){  
            char c = word.charAt(i);  
            Message_ascii[i]=(int) c + rkey[i];
            encryptedtext[i] = (char) Message_ascii [i];
        }   
        String encyptedtext = new String(encryptedtext);  
        return encyptedtext;
    }
    static public String decrypter(int[] akey,String word){
        int[] Message_ascii = new int[word.length()];
        char[] encryptedtext = new char[word.length()];
        int[] bkey = getkey(akey[0]);
    	int[] rkey = new int [50];
    	for (int i=0;i<50;i++){
    		rkey[i] = akey[i] + bkey[i];
    		if (rkey[i] >= 10) {
    			rkey[i]-=10;
    		}
    	}
        for(int i=0; i<word.length();i++){  
            char c = word.charAt(i);  
            Message_ascii[i]=(int) c - rkey[i];
            encryptedtext[i] = (char) Message_ascii [i];
        }   
        String encyptedtext = new String(encryptedtext);  
        return encyptedtext;
    }
    static public void fileentry(){
        String text;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your secret message here :");
        text =sc.nextLine();
        try{         
            FileWriter wr = new FileWriter("input.txt");
            wr.write(text);
            wr.close();
        }
        catch (Exception e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }
    static public int[] getkey(int firstnum) {
    	String temp = null;
    	
    	int[] keyarray = new int [50];
    	try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con =DriverManager.getConnection("jdbc:oracle:thin:@LAPTOP-PCVGGS4F:1521:xe", "encrypter", "encrypter"); 
            String q = "SELECT key from keys where initials ="+ firstnum ;
            Statement stmt =con.createStatement();
            ResultSet set = stmt.executeQuery(q);
            
            while (set.next()) {
                temp =set.getString(1); 
                }    
        }
        catch (Exception e) {
            e.printStackTrace();
        }
			for ( int i = 0; i< temp.length(); i++ ){
                keyarray[i]= temp.charAt(i)-48;  
            }
			return keyarray;
    }
    static public void entry(int[] arr) {
    	try {
    		String string_arr = Arrays.toString(arr).replaceAll(",","").replaceAll(" ", "");
        	string_arr =  string_arr.substring(1,string_arr.length()-1);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con =DriverManager.getConnection("jdbc:oracle:thin:@LAPTOP-PCVGGS4F:1521:xe", "encrypter", "encrypter"); 
            String q = "insert into key_table values('"+string_arr+"')";
            PreparedStatement stmt = con.prepareStatement(q);
            stmt.executeUpdate();
    	}
        catch (Exception e) {
            e.printStackTrace();
        } 
    }
    static public int[] key_by_udi(String UID) {
    	int[] keyarray = new int [50];
    	String temp= null;
    	try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con =DriverManager.getConnection("jdbc:oracle:thin:@LAPTOP-PCVGGS4F:1521:xe", "encrypter", "encrypter"); 
            String q = "select key from key_table where ROWID ='"+UID+"'";
           
            Statement stmt =con.createStatement();
            ResultSet set = stmt.executeQuery(q);
            
            while (set.next()) {
                temp =set.getString(1); 
                }    
        }
        catch (Exception e) {
            e.printStackTrace();
        }
			for ( int i = 0; i< temp.length(); i++ ){
                keyarray[i]= temp.charAt(i)-48;  
            }
			return keyarray;
    }
    static public String Uid(int[] temp) {
    	String uid =null;
    	String string_arr = Arrays.toString(temp).replaceAll(",","").replaceAll(" ", "");
    	string_arr =  string_arr.substring(1,string_arr.length()-1);
    	
    	
    	try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con =DriverManager.getConnection("jdbc:oracle:thin:@LAPTOP-PCVGGS4F:1521:xe", "encrypter", "encrypter"); 
            String q = "select ROWID from key_table where Key ="+string_arr;
            Statement stmt =con.createStatement();
            ResultSet set = stmt.executeQuery(q);
            while (set.next()) {
                uid =set.getString(1);
                }
    	}
    	catch (Exception e) {
            e.printStackTrace();
        }	
    	return uid;
    	
    }

}


