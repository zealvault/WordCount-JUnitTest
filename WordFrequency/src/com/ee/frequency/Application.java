package com.ee.frequency;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Vishal on 22-08-2016.
 */
public class Application
{
    public static void main(String[] args) throws FileNotFoundException
    {

        int cutOff = 0;
        //WordCount wordCount = new WordCount("out", 1);

//        wordCount.findFrequency();
//        wordCount.displayFrequency();

        do
        {
            String fileName = getFileName();
            File file = getFileObject(fileName);
            if (doesFileExist(file))
            {
                if (!isItDirectory(file))
                {
                    if (!isFileEmpty(file))
                    {
                        do {
                            cutOff = getCutOff();
                            if (isCutOffPositive(cutOff))
                            {
                                WordCount wordCount = new WordCount(fileName, cutOff);
                                wordCount.findFrequency();
                                wordCount.displayFrequency();
                                break;
                            }else{
                                System.out.println("CutOff cant be negative");
                            }
                        }while(true);
                        break;
                    }

                }

            }
            else{
                    System.out.println("Please Enter a valid file:");
                }
            }while(true);


       /* while(validateFile(fileName)!=true){
            fileName = getFileName();
        }
        */
            //validateFile(fileName);
            //cutOff = getCutOff();




   /* private static boolean validateFile(String fileName) {


        if (fileName.isEmpty()) {
                return false;
            }else if(file.isDirectory()){
                //System.out.println("it is a Directory,Provide another file");
                return false;
            }
            else{
                return true;
            }
        //assert(fileName!=null):"File Name is null";
        //assert(fileName.trim().isEmpty()!=true):"File name is empty
    }
*/}
    public static boolean isItDirectory(File file) {
        if(file.isDirectory() == true){
            return true;
        }
        else return false;
    }
    private static File getFileObject(String fileName){

        return(new File(fileName));
    }
    public static boolean isFileEmpty(File file) {
        if(file.length() <= 0 ){
            return true;
        }else
        return false;
    }

    public static boolean doesFileExist(File file){
        if(file.exists() == true){
            return true;
        }else{
            return false;
        }
    }
    public static String getFileName(){
        String fileName;
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter the name of your file .... ");
        fileName = reader.nextLine();
        return fileName;
    }
     public static int getCutOff() throws InputMismatchException{
         int cutOff = 0;
         Scanner scan = new Scanner(System.in);
         System.out.println("Enter Cutoff frequency");
        /* while(true) {
              cutOff = scan.nextInt();
             if (cutOff < 0 ) {
                 System.out.println("Cutoff cant be negative,Enter again:");
             }
             else break;
         }*/
        try{
            cutOff = scan.nextInt();
        }catch (InputMismatchException e){
            e.getMessage();
        }


        return cutOff;
    }
    public static boolean isCutOffPositive(int cutOff){
        if(cutOff >= 0){
            return true;
        }else return false;
    }
}
