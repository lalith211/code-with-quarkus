package service;

import DTO.DataDto;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Converter {
    public DataDto conv(String bob) {
        String l=bob;
        String amount="";
        String address1="";
        String address2="";
        String truckNum="";
        String Name1="";
        String status="";
        String date="";
        String billNo="";
        String phone="";
        String[] words = l.split(" ");
        int a = words.length;
        for(int i=0;i<a;i++) {
            String k = words[i];
            if (k.equals("Name"))  {
                for(int j=0;j<words[i+1].length();j++) {
                    int x=(int)words[i+1].charAt(j);
                    if((int)x==10) {
                        break;
                    }
                    Name1=Name1+words[i+1].charAt(j);
                }
                System.out.println("name "+Name1);
            }
            if(k.equals("Phone:")) {
                for(int j=0;j<words[i+1].length();j++) {
                    int x=(int)words[i+1].charAt(j);
                    if((int)x==10) {
                        break;
                    }
                    phone=phone+words[i+1].charAt(j);
                }
                System.out.println("phone "+phone);
            }
            if(k.equals("Status")) {
                for(int j=0;j<words[i+1].length();j++) {
                    int x=(int)words[i+1].charAt(j);
                    if((int)x==10) {
                        break;
                    }
                    status=status+words[i+1].charAt(j);
                }
                System.out.println("Status "+status);
            }
            if(k.equals("Number:")) {
                for(int j=0;j<words[i+1].length();j++) {
                    int x=(int)words[i+1].charAt(j);
                    if((int)x==10) {
                        break; 
                    }
                    billNo=billNo+words[i+1].charAt(j);
                }
            }
            if(k.equals("Date:")) {
                for(int j=0;j<words[i+1].length();j++) {
                    int x=(int)words[i+1].charAt(j);
                    if((int)x==10) {
                        break;
                    }
                    date=date+words[i+1].charAt(j);
                }
                System.out.println("date "+date);
            }
            if(k.equals("Truck")) {
                for(int j=0;j<words[i+2].length();j++) {
                    int x=(int)words[i+2].charAt(j);
                    if((int)x==10) {
                        break;
                    }
                    truckNum=truckNum+words[i+2].charAt(j);
                }
                System.out.println("truckNum "+truckNum);
            }
            if(k.equals("Address")) {
                for(int p=i;p<a;p++) {
                    String t = words[p];
                    System.out.println(words[p]);
                    if(t.equals("Vizag")) {break;}
                    address1="";
                    for(int j=0;j<words[p].length();j++) {
                        int x=(int)words[p].charAt(j);
                        if((int)x==160) {
                            break;
                        }
                        address1=address1+words[p].charAt(j);
                    }
                    address2=address2+address1;
                }
                System.out.println("address "+address2);
            }
            if(k.equals("Amount")) {
                for(int j=0;j<words[i+1].length();j++) {
                    int x=(int)words[i+1].charAt(j);
                    if((int)x==10) {
                        break;
                    }
                    amount=amount+words[i+1].charAt(j);
                }
                System.out.println("amount "+amount);
            }
        }
        DataDto x= new DataDto();
        x.setBillNo(billNo);
        x.setName(Name1);
        x.setDate(date);
        x.setPhone(phone);
        x.setAmount(amount);
        x.setAddress(address2);
        x.setTruckNum(truckNum);
        x.setStatus(status);
        return x;
    }
}