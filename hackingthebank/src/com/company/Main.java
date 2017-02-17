package com.company;
import java.io.*;
import java.util.*;
import java.text.*;
public class Main {

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("Imports");
        PrintWriter output = new PrintWriter(fw, true);
        NumberFormat fmt = NumberFormat.getNumberInstance();
        fmt.setMinimumFractionDigits(2);
        fmt.setMaximumFractionDigits(2);
        String name;
        BA_comparator baba = new BA_comparator();
        ArrayList aryLst = new ArrayList();
        ArrayList<Double> deposits = new ArrayList<>();
        ListIterator iter = aryLst.listIterator();
        bankAccount Pennebacker = new bankAccount("Pennebacker", 0);
        do {
            Scanner kbReader = new Scanner(System.in);
            System.out
                    .print("Please enter the name to whom the account belongs. (\"Exit\" to abort) (\"Debug\" to go to menu) ");
            name = kbReader.nextLine();
            if (name.equalsIgnoreCase("Debug"))
            {
                System.out.println("Type in \"Deposits\", \"Accounts\", or \"Drain\" (Type in anything else to see a log of what has been done)");
                name = kbReader.nextLine();
                if (name.equalsIgnoreCase("Accounts"))
                {
                    ArrayList money = new ArrayList(aryLst);
                    Collections.sort(money);
                  for(int x = 0; x < money.size(); x++)
                  {
                      bankAccount swag = (bankAccount)money.get(x);
                      System.out.println(swag.name + " " + swag.balance);
                  }
                  output.println("AccountsChecked");
                }
                else if (name.equalsIgnoreCase("Deposits")) {
                    Collections.sort(deposits, baba);
                    for (int a = 0; a < deposits.size(); a++)
                    {
                        System.out.println(deposits.get(a));
                    }
                    output.println("DepositsChecked");
                }
                else if (name.equalsIgnoreCase("Drain"))
                {
                    System.out.println("Drain which account?");
                    name = kbReader.nextLine();
                    for (int a = 0; a < aryLst.size(); a++)
                    {
                        bankAccount d = (bankAccount)aryLst.get(a);
                        if (d.name.equalsIgnoreCase(name))
                        {
                            Pennebacker.balance = d.balance;
                            d.balance = 0;
                        }
                    }
                }
                else {
                    Scanner reader = new Scanner(new File("Imports"));
                    while (reader.hasNext()) {
                        System.out.println(reader.nextLine());
                    }
                }
            }
            else if (!name.equalsIgnoreCase("EXIT")) {
                System.out.print("Please enter the amount of the deposit. ");
                double amount = kbReader.nextDouble();
                System.out.println(" ");
                bankAccount theAccount = new bankAccount(name, amount);
                output.println(name + " " + amount);
                deposits.add(amount);
                iter.add(theAccount);
            }
        } while (!name.equalsIgnoreCase("EXIT"));

        bankAccount ba = (bankAccount) iter.previous();
        double maxBalance = ba.balance;
        String maxName = ba.name;
        while (iter.hasPrevious()) {
            ba = (bankAccount) iter.previous();
            if (ba.balance > maxBalance) {
                maxBalance = ba.balance;
                maxName = ba.name;
            }
        }
        System.out.println(" ");
        System.out.println("The account with the largest balance belongs to "
                + maxName + ".");
        System.out.println("The amount is $" + fmt.format(maxBalance) + ".");


    }
}




