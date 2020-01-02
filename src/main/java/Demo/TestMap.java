package Demo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaofenShentu on 2019/12/23 20:00
 */
public class TestMap {
    public static void main(String[] args) {
        Map map1=new HashMap();
        map1.put("name","stxf");
        map1.put("pwd","123456");
        map1.put("exp","success");

        Map map2=new HashMap();
        map2.put("name","admin");
        map2.put("pwd","admin");
        map2.put("exp","success");

        Object[][] objects=new Object[2][];
        objects[0]=new Object[]{map1};
        objects[1]=new Object[]{map2};
        System.out.println(objects[0][0].toString());
        System.out.println(objects[1][0].toString());

    }
}
