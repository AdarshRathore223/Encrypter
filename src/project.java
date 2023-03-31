import mypacks.*;
import java.io.File;
import java.io.FileWriter;
import java.io.WriteAbortedException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
class project{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Welcome to my Cypher encrypter program ---");
        System.out.println("Made by Adarsh Rathore");
        System.out.println("Select any one of the feature below :");
        System.out.println("Press 1 to encrypt a message");
        System.out.println("Press 2 to decrypt a message");
        int a =sc.nextInt();
//        System.out.print("\033[H\033[2J");
        switch (a){
            case 1 :
            	
            	mypacks.fileentry();
                File file = new File("input.txt");
                FileWriter wr2 = new FileWriter("output.txt");  
                Scanner input = new Scanner(file); 
                int[] arr= mypacks.rkey(50); 
                mypacks.entry(arr);
                String UID = mypacks.Uid(arr);
                System.out.println("Your encrypted  message is :");
                while (input.hasNext()) {
                    String message  = input.next();
                    String encrptedmessage = mypacks.encrypter(arr,message);
                    wr2.write(encrptedmessage + " ");
                    System.out.print(encrptedmessage+" ");
                }
                System.out.println();
                System.out.print("Your Unique id is : "+UID);
                wr2.close();
                
                break;
                case 2:
                System.out.println("Enter your unique id : ");
                String Uid = sc.next();
                System.out.println("Enter your Encrypted message: ");
                Scanner scc = new Scanner(System.in);
                String text = scc.nextLine();
                System.out.println();
                FileWriter wr = new FileWriter("input.txt");
                wr.write(text);
                wr.close();
                File filee = new File("input.txt");
                FileWriter dwr2 = new FileWriter("output.txt");
                Scanner einput = new Scanner(filee);
                int[] decrypterkey=mypacks.key_by_udi(Uid);
                System.out.println("Your decrypted message is :");
			while (einput.hasNext()) {
                    String message  = einput.next();
                        String decrptedmessage = mypacks.decrypter(decrypterkey,message);
                        dwr2.write(decrptedmessage + " "); 
                        System.out.print(decrptedmessage+ " ");
                }
			System.out.println();
			dwr2.close();  	
        }
        sc.close();
}
} 