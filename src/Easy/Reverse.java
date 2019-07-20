package Easy;

public class Reverse {
    public static void main(String[] args) {
        String str = "i am tom, i very 'love' that.";
        System.out.println(reverse(str));

    }

    public static String reverse(String s) {
        int pos = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
//            if(c==' '){
//                pos=0;
//            }
            if (c == ' ' || c == '.' || c == ',' || c == '?' || c == '!') {
                pos = 0;
            }
            sb.insert(pos, c);
            if (c != ' ') {
                pos++;
            }
        }
        return sb.toString();
    }
}
