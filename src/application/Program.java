package application;

import entities.Account;
import exeptions.BusinesExceptions;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

//        Account acc = new Account();

        System.out.println("Informe os dados da conta: ");
        System.out.print("Numero: ");
        Integer number = sc.nextInt();
        sc.nextLine();
        System.out.print("Titular: ");
        String holder = sc.nextLine();
        System.out.print("Saldo inicial: ");
        double balance = sc.nextDouble();
        System.out.print("Limite de saque: ");
        double withdrawLimit = sc.nextDouble();

        Account acc = new Account(number , holder , balance , withdrawLimit);

        System.out.println();
        System.out.println("Informe uma quantia para sacar: ");
        double amount = sc.nextDouble();

        try {
            acc.withdraw(amount);
            System.out.println("Novo Saldo: "+String.format("%.2f", acc.getBalance()) );
        }
        catch (BusinesExceptions e){
            System.out.println(e.getMessage());
        }



        sc.close();
    }
}
