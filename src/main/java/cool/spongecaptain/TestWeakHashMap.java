package cool.spongecaptain;

import java.util.WeakHashMap;

/**
 * @author: Spongecaptain
 */
public class TestWeakHashMap {
    //测试方法
    public static void main(String[] args) {
        WeakHashMap<Key, Value> map = new WeakHashMap<Key, Value>();

        Key key = new Key("hello", "world");

        Value value = new Value("world", "spongecaptain");

        map.put(key, value);
        //检查 WeakHashMap 是否有该 key
        System.out.println(map.size());//输出 1 代表 WeakHashMap 中有该键值对

        key = null;//去除对 key 的引用

        //这里仅仅是建议 JVM GC，但是不一定马上会执行，因此需要进行等待几秒时间
        //为了促使 JVM 进行 GC 我们选择创建非常多的 value 对象，不过这里就不进行了，因为在我的电脑上运行 JVM 会进行 GC

//        for (int i = 0; i < 10000; i++) {
//            new Value(String.valueOf(i),String.valueOf(i+1));
//        }
        System.gc();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(map.size());//输出 0 代表 WeakHashMap 中不再有该键值对
    }
}


class Key {
    String foo;
    String bar;

    public Key(String foo, String bar) {
        this.foo = foo;
        this.bar = bar;
    }

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    public String getBar() {
        return bar;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }
}


class Value {
    String foo;
    String bar;

    public Value(String foo, String bar) {
        this.foo = foo;
        this.bar = bar;
    }

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    public String getBar() {
        return bar;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }
}
