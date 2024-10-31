package android.support.v4.g;

import android.view.MenuItem;
import android.view.View;

/* compiled from: MenuItemCompatHoneycomb.java */
/* loaded from: classes.dex */
class l {
    public static void a(MenuItem menuItem, int i) {
        menuItem.setShowAsAction(i);
    }

    public static MenuItem a(MenuItem menuItem, View view) {
        return menuItem.setActionView(view);
    }

    public static MenuItem b(MenuItem menuItem, int i) {
        return menuItem.setActionView(i);
    }
}
