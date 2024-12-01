package String;

public class TimeConversion {
    public static String convertToMilTime(String s){
        //12:00:00AM -> 00:00:00
        //check AM or PM
        StringBuilder res = new StringBuilder();
        if(s.charAt(8) == 'A' && s.charAt(0) == '1' && s.charAt(1) == '2'){
            res.append("00");
            res.append(s.substring(2,8));
        }else if(s.charAt(8) == 'A'){
            res = new StringBuilder();
            res.append(s.substring(0,8));
        }
        else if(s.charAt(8) == 'P' && s.charAt(0) == '1' && s.charAt(1) == '2'){
            res = new StringBuilder();
            res.append(s.substring(0,8));
        }else if(s.charAt(8) == 'P'){
            res = new StringBuilder();
            int h = Integer.parseInt(s.substring(0,2));
            h = h + 12;
            String hour = String.valueOf(h);
            res.append(hour);
            res.append(s.substring(2,8));
        }
        return res.toString();
    }
    public static void main(String[] args) {
        String s = "02:00:00PM";


        String ans = convertToMilTime(s);
        System.out.println(ans);
    }
}
