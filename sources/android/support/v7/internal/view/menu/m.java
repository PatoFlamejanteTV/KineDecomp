package android.support.v7.internal.view.menu;

import android.content.Context;
import android.os.Build;
import android.view.MenuItem;
import android.view.SubMenu;

/* compiled from: MenuWrapperFactory.java */
/* loaded from: classes.dex */
public final class m {
    public static MenuItem a(Context context, android.support.v4.c.a.b bVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            return new i(context, bVar);
        }
        if (Build.VERSION.SDK_INT >= 14) {
            return new h(context, bVar);
        }
        throw new UnsupportedOperationException();
    }

    public static SubMenu a(Context context, android.support.v4.c.a.c cVar) {
        if (Build.VERSION.SDK_INT >= 14) {
            return new p(context, cVar);
        }
        throw new UnsupportedOperationException();
    }
}
