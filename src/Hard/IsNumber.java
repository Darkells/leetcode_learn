package Hard;

public class IsNumber {
    public boolean isNumber(String s) {
        if (s.length() == 0) return false;
        boolean decimal = false, sign = false, hasE = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                if (i == s.length() - 1) {
                    return false;
                }
                if (hasE) {
                    return false;
                }
                hasE = true;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (!sign && i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i-1) != 'E') {
                    return false;
                }
                if (sign && s.charAt(i-1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
                sign = true;
            } else if (s.charAt(i) == '.') {
                if (hasE || decimal) {
                    return false;
                }
                decimal = true;
            } else if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }
        }

        return true;
    }
}
