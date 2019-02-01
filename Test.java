import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {
        // open file input stream
        BufferedReader reader = new BufferedReader(new FileReader(
                "NCHS_-_Leading_Causes_of_Death__United_States.csv"));

        // read file line by line
        String line = null;
        Scanner scanner = null;
        Scanner input = new Scanner(System.in);
        int index = 0;
        List<Report> empList = new ArrayList<Report>();
        List<Report> yearList = new ArrayList<Report>();
        Hashtable<String, Integer> totalDeathInYear = new Hashtable<String, Integer>();
        while ((line = reader.readLine()) != null) {
            Report emp = new Report();
            scanner = new Scanner(line);
            scanner.useDelimiter(",(?![^()]*\\))");
            while (scanner.hasNext()) {
                String data = scanner.next();
                if (index == 0)
                    emp.setYear(data);
                else if (index == 1)
                    emp.set_113cause(data);
                else if (index == 2)
                    emp.setCauseName(data);
                else if (index == 3)
                    emp.setState(data);
                else if (index == 4)
                    emp.setDeath(data);
                else if (index == 5)
                    emp.setDeathRate(data);
                /*else
                    System.out.println("invalid data::" + data);*/
                index++;
            }
            index = 0;
            empList.add(emp);
        }

        //close reader
        reader.close();


        System.out.println("Enter 1 to search by Year \nEnter 2 to search by State \nEnter 3 to search by Specific Cause of Death\nEnter 4 to get Generalised cause of death");
        int x = input.nextInt();

        if (x == 1) {
            System.out.println("Please enter your desired year!: ");
            input.nextLine();
            String year = input.nextLine();
            Report rep = new Report();
            for (Report r : empList) {

                if (r.getYear().equals(year)) {

                    rep.setYear(r.getYear());
                    rep.set_113cause(r.get_113cause());
                    rep.setCauseName(r.getCauseName());
                    rep.setState(r.getState());
                    rep.setDeath(r.getDeath());
                    rep.setDeathRate(r.getDeathRate());
                    yearList.add(rep);

                }
                rep = new Report();

            }

        } else if (x == 2) {
            System.out.println("Please enter a state to know the information : ");
            input.nextLine();
            String state = input.nextLine();
            Report rep = new Report();
            for (Report r : empList) {

                if (r.getState().equals(state)) {
                    rep.setYear(r.getState());
                    rep.set_113cause(r.get_113cause());
                    rep.setCauseName(r.getCauseName());
                    rep.setState(r.getState());
                    rep.setDeath(r.getDeath());
                    rep.setDeathRate(r.getDeathRate());
                    yearList.add(rep);
                }
                rep = new Report();
            }
        } else if (x == 3) {
            System.out.println("Please enter the reason of death to know the details : ");
            input.nextLine();
            String CauseName = input.nextLine();
            Report rep = new Report();
            for (Report r : empList) {
                if (r.getCauseName().equals(CauseName)) {
                    rep.setYear(r.getState());
                    rep.set_113cause(r.get_113cause());
                    rep.setCauseName(r.getCauseName());
                    rep.setState(r.getState());
                    rep.setDeath(r.getDeath());
                    rep.setDeathRate(r.getDeathRate());
                    yearList.add(rep);
                }
                rep = new Report();
            }
        } else if (x == 4) {
            System.out.println("Please enter the Generalised reason of death to know the details : ");
            input.nextLine();
            String _113cause = input.nextLine();
            Report rep = new Report();
            for (Report r : empList) {
                if (r.get_113cause().equals(_113cause)) {
                    rep.setYear(r.getState());
                    rep.set_113cause(r.get_113cause());
                    rep.setCauseName(r.getCauseName());
                    rep.setState(r.getState());
                    rep.setDeath(r.getDeath());
                    rep.setDeathRate(r.getDeathRate());
                    yearList.add(rep);
                }
                rep = new Report();

            }
        }
        else
            {
                System.out.println("Please enter between 1 and 4");
            }
            // System.out.println(empList);

            for (Report r : yearList) {

                System.out.println("Year: " + r.getYear() + ", 113 Cause Name: " + r.get_113cause() + ", Cause: " + r.getCauseName() + ", State: " + r.getState() + " Death: " + r.getDeath() + ", DeathRate: " + r.getDeathRate());
            }


        }

    }
