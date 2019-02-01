
package readsearchfile;


import javax.swing.*;
import java.io.File;
import java.util.Scanner;

public class DataSearch {

    private static Scanner x;

    public static void main(String[] args) {
        String filepath  ="NCHS_-_Leading_Causes_of_Death__United_States.csv";
        String searchTerm = "2016";
        readRecord(searchTerm,filepath);
    }
    public static void readRecord (String searchTerm, String filepath)
    {
        boolean found = false;
        String year = ""; String cause = ""; String CauseName = ""; String state = ""; String age = ""; String death = "";
        try{
            x = new Scanner(new File(filepath));
            x.useDelimiter ("[,\n]");
            x.next();
            while (x.hasNext() && !found)
            {
                year = x.next();
                cause = x.next();
                CauseName = x.next();
                state = x.next();
                age = x.next();
                death = x.next();
                if (year.equals(searchTerm))
                {
                    found = true;
                }
                if (found) {
                    System.out.println("Year : " + year + "Cause :" + cause + "Cause Name :" + CauseName + "State:" + state + "Death: " + death);
                }else
                {
                    System.out.println("Record Not Found");
                }

            }

        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
}
