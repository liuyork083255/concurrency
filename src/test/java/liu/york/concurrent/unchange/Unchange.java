package liu.york.concurrent.unchange;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;

import java.util.Collections;
import java.util.Map;

/**
 * 定义常见不可更改的对象
 */
public class Unchange {

    /**
     * 获取不能被修改的 list
     */
    private final static ImmutableList IMMUTABLE_LIST = ImmutableList.of("yang","liu");

    private final static Map<String, String> MAP = Maps.newHashMap();

    /**
     *  获取被不可被需改的 map
     * @return
     */
    public Map<String, String> getUnchageMap(){
        return Collections.unmodifiableMap(MAP);
    }

}
