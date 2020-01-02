package LoginData;

/**
 * Created by xiaofenShentu on 2019/12/23 13:19
 */

import org.testng.annotations.Test;

import java.util.Map;

public class TestLoginParams {
    @Test(dataProvider = "dataMethod",dataProviderClass = LoginParams.class )
    public void test(Map<?,?> param){
        System.out.println(param.get("name"));
    }
}
