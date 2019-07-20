package Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReverseStrWithSpace {
    private final static char splitSymbol = ' ';
    public static void main(String[] args) {
        String target = "i am tom, i very love that.";
        reverseStrWitchSpace(target,splitSymbol);
    }

    private static String constructStrFromMap(Map<String, List> listMap)
    {
        List<Integer> intList = listMap.get("intList");
        List<String>strList = listMap.get("strList");

        String retStr="";
        for(int index=strList.size()-1;index>=0;index--)
        {
            if(index>0)
            {
                retStr+=strList.get(index);
                for(int count=0;count<intList.get(index-1);count++)
                {
                    retStr+=new String(new char[]{splitSymbol});
                }
            }
            else {
                retStr+=strList.get(0);
            }
        }
        System.out.println(retStr);
        return retStr;
    }

    public static String reverseStrWitchSpace(String target,char splitSymbol)
    {
        Map<String, List>listMap = new HashMap<String, List>();

        if(target==null||target.length()==0)
        {
            System.out.println("目标字符串为空");
            return null;
        }

        int intCount = 0;
        int start = 0;
        int end = 0;

        List<Integer> intList = new ArrayList<Integer>();
        List<String> strList = new ArrayList<String>();

        for(int index=0;index<target.length();index++)
        {
            boolean lastChar = index==target.length()-1?true:false;

            if(target.charAt(index)==splitSymbol)
            {
                intCount++;

                if (lastChar) {
                    intList.add(intCount);
                    listMap.put("intList", intList);
                    listMap.put("strList", strList);
                    return constructStrFromMap(listMap);
                }

                if (target.charAt(index+1)!=splitSymbol) {
                    intList.add(intCount);
                    listMap.put("intList", intList);
                    start=index+1;
                }
            }

            else {
                end=index;
                if (lastChar) {
                    strList.add(target.substring(start, end+1));
                    listMap.put("intList", intList);
                    listMap.put("strList", strList);
                    return constructStrFromMap(listMap);
                }

                if (target.charAt(index+1)==splitSymbol) {
                    strList.add(target.substring(start, end+1));
                    listMap.put("strList", strList);
                    intCount = 0;
                }
            }
        }

        return constructStrFromMap(listMap);
    }
}

