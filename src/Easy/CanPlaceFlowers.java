package Easy;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (satify(flowerbed, i)) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n <= 0 ? true : false;
    }

    public boolean satify(int[] flowerbed, int i) {
        if (flowerbed[i] == 1) {
            return false;
        }
        int length = flowerbed.length;
        //种花条件 前后都为0 或在边界
        if (flowerbed[i] == 0 && (i - 1 < 0 || flowerbed[i - 1] == 0) && (i + 1 > length || flowerbed[i + 1] == 0)) {
            return true;
        } else {
            return false;
        }
    }
}
