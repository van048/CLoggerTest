package cn.ben.cloggertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private static final String JSON_CONTENT = "{\n" +
            "\"employees\": [\n" +
            "{ \"firstName\":\"Bill\" , \"lastName\":\"Gates\" },\n" +
            "{ \"firstName\":\"George\" , \"lastName\":\"Bush\" },\n" +
            "{ \"firstName\":\"Thomas\" , \"lastName\":\"Carter\" }\n" +
            "]\n" +
            "}";
    private static final String XML_CONTENT = "<?xml version=\"1.0\"?>\n" +
            "<小纸条>\n" +
            " <收件人>大元</收件人>\n" +
            " <發件人>小張</發件人>\n" +
            " <主題>問候</主題>\n" +
            " <具體內容>早啊，飯吃了沒？ </具體內容>\n" +
            "</小纸条>";
    private static final String YOUR_TAG = "BenYang";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Logger.d("hello");
        // String format arguments are supported
        Logger.d("hello %s %d", "world", 5);   // String.format
        Logger.d("hello");
        Logger.e("hello");
        Logger.w("hello");
        Logger.v("hello");
        // TODO: 2016/7/5
        Logger.wtf("hello");
        Logger.json(JSON_CONTENT);
        Logger.xml(XML_CONTENT);

        Throwable throwable = new Throwable("I am clever!");
        Logger.log(Logger.DEBUG, "tag", "message", throwable);

        // Array, Map, Set and List are supported
        List<Object> list = new ArrayList<>();
        list.add(1);
        list.add("as");
        Logger.d(list);

        Map<Object, Object> map = new HashMap<>();
        map.put(1, 3);
        map.put(2, "student");
        Logger.d(map);

        Set<Object> set = new HashSet<>();
        set.add(6);
        set.add("share");
        Logger.d(set);

        String[] arr = new String[2];
        arr[0] = "9";
        arr[1] = "father";
        Logger.d(arr);

        // Change TAG
//        Logger.init(YOUR_TAG);
//        Logger.d(arr);

        Logger.t("mytag").d("hello");

        // Settings (optional)
        // Change the settings with init. This should be called only once. Best place would be in application class. All of them are optional. You can just use the default settings if you don't init Logger.
        // Note: Use LogLevel.NONE for the release versions.
        Logger.init(YOUR_TAG)
                .methodCount(3)                 // default 2
                .hideThreadInfo()               // default shown
                .logLevel(LogLevel.FULL)        // default LogLevel.FULL
//                .logLevel(LogLevel.NONE)
                // To integrate logger with other libraries, you can set the offset in order to avoid that library's methods.
                .methodOffset(2)                // default 0
        ;
        // Use another log util instead of android.util.log
//                .logAdapter(new AndroidLogAdapter()); //default AndroidLogAdapter
        Logger.d("hello");
        Logger.t(1).d("hello");
    }

//    private class AndroidLogAdapter implements LogAdapter {
//        @Override
//        public void d(String tag, String message) {
//            Log.d("搞事情", "搞事情");
//        }
//
//        @Override
//        public void e(String tag, String message) {
//
//        }
//
//        @Override
//        public void w(String tag, String message) {
//
//        }
//
//        @Override
//        public void i(String tag, String message) {
//
//        }
//
//        @Override
//        public void v(String tag, String message) {
//
//        }
//
//        @Override
//        public void wtf(String tag, String message) {
//
//        }
//    }
}
