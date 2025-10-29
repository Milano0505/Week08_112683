package week08.milano.id.ac.umn.Tugas2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Item> listItems = new ArrayList<>();
    static ArrayList<Payment> listPayments = new ArrayList<>();
    static Scanner s = new Scanner(System.in);

    public static void seedData() {
        listItems.add(new Item("Kulkas", "Electronic", 4800000));
        listItems.add(new Item("TV", "Electronic", 1280000));
        listItems.add(new Item("Laptop", "Computer", 6000000));
        listItems.add(new Item("PC", "Computer", 12000000));
    }

    public static void main(String[] args) {
        seedData();
        int opt;

        do {
            System.out.println("\n---Program Toko Elektronik----");
            System.out.println("1. Pesan Barang");
            System.out.println("2. Lihat Pesanan");
            System.out.println("0. Keluar");
            System.out.print("Pilihan : ");
            opt = s.nextInt();

            switch (opt) {
                case 1:
                    System.out.println("\n----Daftar Barang----");
                    for (int i = 0; i < listItems.size(); i++) {
                        System.out.println("No : " + (i + 1));
                        System.out.println("Nama : " + listItems.get(i).getName());
                        System.out.println("Tipe : " + listItems.get(i).getType());
                        System.out.println("Harga : " + listItems.get(i).getPrice());
                        System.out.println("-------------------------------");
                    }

                    System.out.print("Pilih : ");
                    int pilih = s.nextInt();
                    Item selected = listItems.get(pilih - 1);

                    System.out.println("\n----Tipe pembayaran----");
                    System.out.println("1. Cash");
                    System.out.println("2. Credit");
                    System.out.print("Pilih : ");
                    int metode = s.nextInt();

                    if (metode == 1) {
                        System.out.println("Bayar (Y/N): ");
                        char y = s.next().charAt(0);
                        if (y == 'Y' || y == 'y') {
                            Payment p = new Cash(selected);
                            int bayar = p.pay();
                            listPayments.add(p);
                            System.out.println("Harga Pembayaran : " + bayar);
                            System.out.println("Transaksi telah dibayar lunas");
                        } else {
                            Payment p = new Cash(selected);
                            listPayments.add(p);
                            System.out.println("Transaksi telah disimpan");
                        }
                    } else if (metode == 2) {
                        System.out.print("Lama Cicilan (3/6/9/12): ");
                        int lama = s.nextInt();
                        Payment p = new Credit(selected, lama);
                        int bayar = p.pay();
                        listPayments.add(p);
                        System.out.println("Lama Cicilan : " + lama);
                        System.out.println("Harga Pembayaran : " + bayar);
                        System.out.println("Transaksi telah dibayar");
                    }
                    break;

                case 2:
                    System.out.println("\n----Daftar Pesanan----");
                    if (listPayments.isEmpty()) {
                        System.out.println("Belum ada transaksi.");
                        break;
                    }

                    for (int i = 0; i < listPayments.size(); i++) {
                        Payment p = listPayments.get(i);
                        System.out.println("No : " + (i + 1));
                        System.out.println("Nama : " + p.getItem().getName());
                        System.out.println("Tipe : " + p.getItem().getType());
                        System.out.println("Status : " + p.getStatus());
                        System.out.println("Sisa Pembayaran : " + p.getRemainingAmount());
                        System.out.println("---------------------------------");
                    }

                    System.out.print("Pilih No Transaksi : ");
                    int no = s.nextInt();
                    if (no < 1 || no > listPayments.size()) {
                        System.out.println("Nomor tidak valid.");
                        break;
                    }

                    Payment pilihPay = listPayments.get(no - 1);
                    System.out.println("Nama : " + pilihPay.getItem().getName());
                    System.out.println("Tipe : " + pilihPay.getItem().getType());
                    System.out.println("Status : " + pilihPay.getStatus());
                    System.out.println("Sisa Pembayaran : " + pilihPay.getRemainingAmount());

                    if (!pilihPay.isPaidOff()) {
                        int bayar = pilihPay.pay();
                        System.out.println("Bayar : " + bayar);
                        System.out.println("Transaksi telah dibayar");
                    } else {
                        System.out.println("Transaksi telah lunas");
                    }
                    break;

                case 0:
                    System.out.println("Terima kasih telah berbelanja!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (opt != 0);
    }
}
