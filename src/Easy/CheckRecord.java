package Easy;

public class CheckRecord {
    public boolean checkRecord(String s) {
        int A = 0, L = 0;
        boolean A1 = true, L1 = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                A++;
            }
            if (A > 1) {
                A1 = false;
            }
            if (i + 3 <= s.length() && s.substring(i, i + 3)=="LLL") {
                L1 = false;
            }
        }
        return A1 && L1;
    }

    public static void main(String[] args){
        String s = "PPALLL";
        System.out.println(s.substring(3,6).equals("LLL"));
    }
}
