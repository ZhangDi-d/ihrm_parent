package testjson;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestJson {

    @Test
    public void test1() {
        Map<String, Object> map = new HashMap<>();
        map.put("filedA", "A");
        map.put("filedB", "B");

        Map<String, Object> mapinner = new HashMap<>();
        mapinner.put("innerfiledA", "1");
        mapinner.put("innerfiledB", "2");
        List list = new ArrayList();
        list.add(mapinner);
        map.put("filedC", list);
        String jsonString = JSON.toJSONString(map);
        System.out.println(jsonString);
    }


    /**
     * 如果接口接受的时并不是以对象json化传参，那么要以String类型来接受，并自己解析，
     * 注意：：：不能自己定义对象，将类似 {"filedA":"A","filedB":"B","filedC":[{"innerfiledA":"1","innerfiledB":"2"}]}
     *          转成自己定义的对象
     */
    @Test
    public void test2() {
        String str = "{\"filedA\":\"A\",\"filedB\":\"B\",\"filedC\":[{\"innerfiledA\":\"1\",\"innerfiledB\":\"2\"}]}";
        Map<String, Object> objectMap = (Map<String, Object>) JSON.parse(str);
        String filedA = (String) objectMap.get("filedA");
        String filedB = (String) objectMap.get("filedB");
        List<Map<String, Object>> filedC = (List<Map<String, Object>>) objectMap.get("filedC");
        for (Map<String, Object> map : filedC) {
            String innerfiledA = (String) map.get("innerfiledA");
            String innerfiledB = (String) map.get("innerfiledB");
            System.out.println("filedA= "+filedA);
            System.out.println("filedB= "+filedB);
            System.out.println("innerfiledA= "+innerfiledA);
            System.out.println("innerfiledB= "+innerfiledB);
        }
    }
}
