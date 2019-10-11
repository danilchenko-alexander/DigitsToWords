import java.math.BigInteger;
import java.util.List;


public class Converter {
    public Converter() {
    }

    public String digitToString(BigInteger number){

        String digits = number.toString();
        FileParser fp = new FileParser();
        List<String[]> list =  fp.readFile();

        int length = digits.length();
        int temp = (int)Math.ceil(Double.valueOf(length)/3);
        String result = new String();
        if(number.equals(0)) {
            result = result.concat("Ноль");
            return result;
        }
        if(length%3!=0) {
            result = result.concat(out(temp,digits.substring(0, length % 3),list));
            temp--;
        }
        for (int i = length%3 ; i < length; i+=3){
            result = result.concat(out(temp,digits.substring(i, i+3),list));
            temp--;
        }

        return result;
    }

    public String out(int temp,String digits, List<String[]> list){
        digits = Integer.toString(Integer.parseInt(digits));
        String str = new String();
        int length = digits.length();

        for (int i = length ; i > 0; i--){
            switch (i){
                case 1:{
                    int a = Character.getNumericValue(digits.charAt(length - 1));

                    if(a != 0){
                        if(temp != 2)
                            str = str.concat(list.get(0)[Character.getNumericValue(digits.charAt(length - 1)) - 1] + " ");
                        else
                            str = str.concat(list.get(1)[Character.getNumericValue(digits.charAt(length - 1))-1] + " ");
                    }
                }break;
                case 2:{
                    int a = Character.getNumericValue(digits.charAt(length - 2));
                    if(a != 0){
                        if(a == 1){
                            str = str.concat(list.get(2)[Character.getNumericValue(digits.charAt(length - 1))] + " ");
                            if(temp > 1)
                                str = str.concat(list.get(temp+3)[2]+" ");
                            if(temp == 1)
                                str = str.substring(0,str.length()-1);
                            return str;
                        }
                        else
                            str = str.concat(list.get(3)[Character.getNumericValue(digits.charAt(length - 2))-2] + " ");
                    }
                }break;
                case 3:{
                    str = str.concat(list.get(4)[Character.getNumericValue(digits.charAt(0))-1] + " ");
                }break;
            }
        }

        if(temp > 1)
            str = str.concat(setTitle(temp,digits,list) + " ");
        if(temp == 1)
            str = str.substring(0,str.length()-1);
        return str;
    }

    public String setTitle(int temp, String digits, List<String[]> list){
        int number = Integer.parseInt(digits);
        if(number >= 10 && number <= 20) return list.get(temp+3)[2];
        if(number%10 > 1 && number%10 < 5) return list.get(temp+3)[1];
        if(number%10 == 1) return list.get(temp+3)[0];
        return list.get(temp+3)[2];
    }
}
