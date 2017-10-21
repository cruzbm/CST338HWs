/*
 * Title: Calculator.java
 * Abstract: This program is the sole file that SubnetCalculator Project is built on.
 *           Will read in a subnet in form of ###.###.###.###/## and output subnet information.
 * Author: Brandon Cruz
 * ID: 8309
 * Date: 10/20/2017
 */



import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.lang.Math.*;

import static java.lang.Math.pow;

public class Calculator {
    private String ipv4;
    private int O1;
    private int O2;
    private int O3;
    private int O4;
    private int mask;
    private String classful;
    private String classfulBroadcast; //initialized at processClassfulBroadcast
    private String subnetNetworkAddress;
    private String subnetBroadcast;
    private String subnetMask;
    private int hostPerSub;
    private int numSubnets;
    private int subnetBits;
    private int hostBits;
    private String hostRangeStart;
    private String hostRangeEnd;
    private char classType; //A,B,C,D

    public static String ip_format = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\/\\d{1,3}";
    //public static Pattern ip_format = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\/\\d{1,3}");

    public String toBinary(int n) {
        if (n == 0) {
            return "0";
        }
        String binary = "";
        while (n > 0) {
            int rem = n % 2;
            binary = rem + binary;
            n = n / 2;
        }

        if (binary.length() != 8){
            return String.format("%08d",Integer.parseInt(binary));
        }
        else{
            return binary;
        }
    }

    public String binPad(int dec){
        return "";
    }

    public char identifyClass(int o1){
        if (o1 >= 0 && o1 <= 127){
            return 'A';
        }
        else if (o1 >= 128 && o1 <= 191){
            return 'B';
        }
        else if (o1 >= 192 && o1 <= 223){
            return 'C';
        }
        else{
            System.out.println("IP Address Octet 1 is invalid.");
            return 'F';
        }
    }

    public void processClassful(){
        if (classType == 'A'){
            classful = String.valueOf(O1) + ".0.0.0";
        }
        else if (classType == 'B'){
            classful = String.valueOf(O1) + "." + String.valueOf(O2) + ".0.0";
        }
        else if (classType == 'C') {
            classful = String.valueOf(O1) + "." + String.valueOf(O2) + "." + String.valueOf(O3) + ".0";
        }
    }

    public void processClassfulBroadcast(){
        if (classType == 'A'){
            classfulBroadcast = String.valueOf(O1) + ".255.255.255";
        }
        else if (classType == 'B'){
            classfulBroadcast = String.valueOf(O1) + "." + String.valueOf(O2) + ".255.255";
        }
        else if (classType == 'C') {
            classfulBroadcast = String.valueOf(O1) + "." + String.valueOf(O2) + "." + String.valueOf(O3) + ".255";
        }
    }

    public void processSubnetMask(){
        if (classType == 'A'){
            subnetMask = "255" +
                    "";
            if (mask >= 8 && mask <= 32){
                if (mask == 8){
                    subnetMask += ".0.0.0";
                }
                else if (mask <=16){
                    int temp = mask - 8;
                    if (temp == 1){
                        subnetMask += ".128.0.0";
                    }
                    if (temp == 2){
                        subnetMask += ".192.0.0";
                    }
                    if (temp == 3){
                        subnetMask += ".224.0.0";
                    }
                    if (temp == 4){
                        subnetMask += ".240.0.0";
                    }
                    if (temp == 5){
                        subnetMask += ".248.0.0";
                    }
                    if (temp == 6){
                        subnetMask += ".252.0.0";
                    }
                    if (temp == 7){
                        subnetMask += ".254.0.0";
                    }
                    if (temp == 8){
                        subnetMask += ".255.0.0";
                    }
                }
                else if (mask <= 24){
                    int temp = mask - 16;
                    if (temp == 1){
                        subnetMask += ".255.128.0";
                    }
                    if (temp == 2){
                        subnetMask += ".255.192.0";
                    }
                    if (temp == 3){
                        subnetMask += ".255.224.0";
                    }
                    if (temp == 4){
                        subnetMask += ".255.240.0";
                    }
                    if (temp == 5){
                        subnetMask += ".255.248.0";
                    }
                    if (temp == 6){
                        subnetMask += ".255.252.0";
                    }
                    if (temp == 7){
                        subnetMask += ".255.254.0";
                    }
                    if (temp == 8){
                        subnetMask += ".255.255.0";
                    }
                }
                else if (mask <= 32){
                    int temp = mask - 24;
                    if (temp == 1){
                        subnetMask += ".255.255.128";
                    }
                    if (temp == 2){
                        subnetMask += ".255.255.192";
                    }
                    if (temp == 3){
                        subnetMask += ".255.255.224";
                    }
                    if (temp == 4){
                        subnetMask += ".255.255.240";
                    }
                    if (temp == 5){
                        subnetMask += ".255.255.248";
                    }
                    if (temp == 6){
                        subnetMask += ".255.255.252";
                    }
                    if (temp == 7){
                        subnetMask += ".255.255.254";
                    }
                    if (temp == 8){
                        subnetMask += ".255.255.255";
                    }
                }
                processSubnet();
            }
            else {
                System.out.println("Invalid Mask Provided. Complete Subnet Calculator.");
                return;
            }
        }
        else if (classType == 'B'){
            subnetMask = "255.255";
            if (mask >= 16 && mask <= 32){
                if (mask == 16){
                    subnetMask += ".0.0";
                }
                else if (mask <= 24){
                    int temp = mask - 16;
                    if (temp == 1){
                        subnetMask += ".128.0";
                    }
                    if (temp == 2){
                        subnetMask += ".192.0";
                    }
                    if (temp == 3){
                        subnetMask += ".224.0";
                    }
                    if (temp == 4){
                        subnetMask += ".240.0";
                    }
                    if (temp == 5){
                        subnetMask += ".248.0";
                    }
                    if (temp == 6){
                        subnetMask += ".252.0";
                    }
                    if (temp == 7){
                        subnetMask += ".254.0";
                    }
                    if (temp == 8){
                        subnetMask += ".255.0";
                    }
                }
                else if (mask <= 32){
                    int temp = mask - 24;
                    if (temp == 1){
                        subnetMask += ".255.128";
                    }
                    if (temp == 2){
                        subnetMask += ".255.192";
                    }
                    if (temp == 3){
                        subnetMask += ".255.224";
                    }
                    if (temp == 4){
                        subnetMask += ".255.240";
                    }
                    if (temp == 5){
                        subnetMask += ".255.248";
                    }
                    if (temp == 6){
                        subnetMask += ".255.252";
                    }
                    if (temp == 7){
                        subnetMask += ".255.254";
                    }
                    if (temp == 8){
                        subnetMask += ".255.255";
                    }
                }
                processSubnet();
            }
            else{
                System.out.println("Invalid Mask Provided. Complete Subnet Calculator.");
                return;
            }
        }
        else if(classType == 'C'){
            if (mask >= 24 && mask <= 32){
                subnetMask = "255.255.255";
                if (mask <= 32){
                    int temp = mask - 24;
                    if (temp == 1){
                        subnetMask += ".128";
                    }
                    if (temp == 2){
                        subnetMask += ".192";
                    }
                    if (temp == 3){
                        subnetMask += ".224";
                    }
                    if (temp == 4){
                        subnetMask += ".240";
                    }
                    if (temp == 5){
                        subnetMask += ".248";
                    }
                    if (temp == 6){
                        subnetMask += ".252";
                    }
                    if (temp == 7){
                        subnetMask += ".254";
                    }
                    if (temp == 8){
                        subnetMask += ".255";
                    }
                }
                processSubnet();
            }
            else{
                System.out.println("Invalid Mask Provided. Complete Subnet Calculator.");
                return;
            }
        }
    }

    public void processSubnet(){
        StringTokenizer maskToken = new StringTokenizer(subnetMask, ".");
        ArrayList<String> maskList = new ArrayList<>();
        while (maskToken.hasMoreTokens()){
            maskList.add(maskToken.nextToken());
        }

        //String oct1 = toBinary(O1);
        String oct2 = toBinary(O2);
        String oct3 = toBinary(O3);
        String oct4 = toBinary(O4);

        if (classType == 'A'){
            subnetBits = mask - 8;
        }
        else if (classType == 'B'){
            subnetBits = mask - 16;
        }
        else if (classType == 'C'){
            subnetBits = mask - 24;
        }

        hostBits = 32 - mask;
        numSubnets = (int)pow(2, subnetBits);
        hostPerSub = (int)pow(2, hostBits) - 2;

    }


    public void process(String oIP, Calculator subnet){
        StringTokenizer st = new StringTokenizer(oIP, ".///");
        int i = 0;
        while (st.hasMoreTokens()) {
            if (i == 0) {
                subnet.O1 = Integer.parseInt(st.nextToken());
            } else if (i == 1) {
                subnet.O2 = Integer.parseInt(st.nextToken());
            } else if (i == 2) {
                subnet.O3 = Integer.parseInt(st.nextToken());
            } else if (i == 3) {
                subnet.O4 = Integer.parseInt(st.nextToken());
            } else {
                subnet.mask = Integer.parseInt(st.nextToken());
            }

            i++;
        }

        subnet.classType = subnet.identifyClass(subnet.O1);
        subnet.processClassful();
        subnet.processClassfulBroadcast();
        subnet.processSubnetMask();
    }



    //---------------MAIN---------------//
    public static void main(String[] args){
        Calculator subnet = new Calculator();

        subnet.toBinary(8);

        System.out.println("===== Subnet Calculator =====");
        System.out.println("Enter an IP address (ex: 192.168.1.1/24)");
        Scanner input = new Scanner(System.in);
        String readIP = input.nextLine();

        boolean flag = false;
        while (!flag) {
            //CHECKING FORMAT
            if (!readIP.matches(ip_format)) {
                System.out.println("Invalid IP Address format. Please try again.");
                readIP = input.nextLine();
            } else {
                flag = true;
            }
        }


        subnet.ipv4 = readIP;
        subnet.process(readIP, subnet);
        subnet.print();
    }

    public void print(){
        System.out.println("=========="+ipv4+"==========");
        System.out.println("Network Class Type:\t" + classType);
        System.out.println("Classful Address:\t" + classful);
        System.out.println("Classful Broadcast:\t" + classfulBroadcast);
        System.out.println("Subnet Address:\t\t" + subnetNetworkAddress);
        System.out.println("Subnet Mask:\t\t" + subnetMask);
        System.out.println("Subnet Broadcast:\t" + subnetBroadcast);
        System.out.println("Subnets per Host:\t" + hostPerSub);
        System.out.println("Number of Subnets:\t" + numSubnets);
        System.out.println("Host Range:\t\t" + hostRangeStart + " - " + hostRangeEnd);
    }
}


