package test;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class InvalidTransactions {
    public  static List<String> invalidTransactions(String[] transactions) {
        HashSet<String> res = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();

        for (String s: transactions) {
            System.out.println(s + " , ");
        }

        quickSort(transactions,0,transactions.length - 1 );

        System.out.println("=========================");

        for (String s: transactions) {
            System.out.println(s + " , ");
        }

        for (int i = 0; i < transactions.length; i++) {
            String[] temp = transactions[i].split(",");
            int amount = Integer.parseInt(temp[2]);
            if (amount > 1000) {
                res.add(transactions[i]);
            }
            String name = temp[0];
            int time = Integer.parseInt(temp[1]);
            String city = temp[3];
            if (!map.containsKey(name)) {
                map.put(name,i);
            } else {
                int index = map.get(name);

                int indextime = Integer.parseInt(transactions[index].split(",")[1]);
                if (Math.abs(time - indextime) <= 60 && !city.equals(transactions[index].split(",")[3])){
                    res.add(transactions[index]);
                    res.add(transactions[i]);
                }
                map.put(name,i);
            }
        }

        List<String> ans = new ArrayList<>(res);
        return new ArrayList<>(res);

    }

    public static void quickSort(String[] arr, int left, int right) {
        int l = left;
        int r = right;
        //中间值
        int pivot = Integer.parseInt(arr[(left + right) / 2].split(",")[1]);
        String temp;
        while (l < r) {
            //在pivot的左边查找大于等于pivot值，
            while (Integer.parseInt(arr[l].split(",")[1]) < pivot) {
                l += 1;
            }
            while (Integer.parseInt(arr[r].split(",")[1]) > pivot) {
                r -= 1;
            }
            //如果l >= r说明pivot 的左右两的值，已经全部符合左边小于pivot，右边大于pivot
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个arr[l] == pivot值 相等--
            if (Integer.parseInt(arr[l].split(",")[1]) == pivot) {
                r -= 1;
            }
            //如果交换完后，发现这个arr[r] == pivot值 相等++
            if (Integer.parseInt(arr[r].split(",")[1]) == pivot) {
                l += 1;
            }
        }

        if (l == r) {
            l += 1;
            r -= 1;
        }

        if (left < r) {
            quickSort(arr,left,r);
        }

        if (right > l) {
            quickSort(arr,l,right);
        }

    }
}
