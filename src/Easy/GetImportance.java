package Easy;

import java.util.HashMap;
import java.util.List;

/**
 * @author Dark
 * @date 2019/5/18 11:53
 */
public class GetImportance {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> map = new HashMap<>();
        for ( Employee employee:
             employees) {
            map.put(employee.id,employee);
        }
        return dfs(map,id);
    }

    public int dfs(HashMap<Integer,Employee> map,int id){
        //自身的重要度
        int tempRes = map.get(id).importance;
        //统计id直系下属的所有重要之和
        for (int subordinate : map.get(id).subordinates){
            tempRes += dfs(map,subordinate);
        }
        return tempRes;
    }
}
