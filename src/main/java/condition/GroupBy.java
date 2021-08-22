package condition;

import java.util.ArrayList;
import java.util.List;

public class GroupBy {
    //group条件数组
    private List<String> gruopCon;

    public void setGruopCon(List<String> gruopCon) {
        this.gruopCon = gruopCon;
    }

    public List<String> getGruopCon() {
        return gruopCon;
    }
    //将分组字段加入条件数组可加入的值为CommonValue中的字段名常量
    public void addCondi(String condi){
        this.gruopCon.add(condi);

    }

    public GroupBy() {
        this.gruopCon = new ArrayList<>();
    }


}
