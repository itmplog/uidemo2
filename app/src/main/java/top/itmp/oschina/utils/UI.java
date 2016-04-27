package top.itmp.oschina.utils;

import android.content.Context;
import java.lang.reflect.Field;

/**
 * Created by hz on 2016/4/27.
 */
public class UI {

    public static int getStatusBarHeight(Context context) {

        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x = 0, statusBarHeight = 38;//通常这个值会是38

        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            statusBarHeight = context.getResources().getDimensionPixelSize(x);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return statusBarHeight;

    }
}
