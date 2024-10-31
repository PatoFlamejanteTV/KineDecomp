package android.support.v4.g;

import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

/* compiled from: MenuItemCompat.java */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    static final d f95a;

    /* compiled from: MenuItemCompat.java */
    /* loaded from: classes.dex */
    interface d {
        MenuItem a(MenuItem menuItem, View view);

        void a(MenuItem menuItem, int i);

        boolean a(MenuItem menuItem);

        MenuItem b(MenuItem menuItem, int i);
    }

    /* compiled from: MenuItemCompat.java */
    /* loaded from: classes.dex */
    public interface e {
        boolean a(MenuItem menuItem);

        boolean b(MenuItem menuItem);
    }

    /* compiled from: MenuItemCompat.java */
    /* loaded from: classes.dex */
    static class a implements d {
        a() {
        }

        @Override // android.support.v4.g.k.d
        public void a(MenuItem menuItem, int i) {
        }

        @Override // android.support.v4.g.k.d
        public MenuItem a(MenuItem menuItem, View view) {
            return menuItem;
        }

        @Override // android.support.v4.g.k.d
        public MenuItem b(MenuItem menuItem, int i) {
            return menuItem;
        }

        @Override // android.support.v4.g.k.d
        public boolean a(MenuItem menuItem) {
            return false;
        }
    }

    /* compiled from: MenuItemCompat.java */
    /* loaded from: classes.dex */
    static class b implements d {
        b() {
        }

        @Override // android.support.v4.g.k.d
        public void a(MenuItem menuItem, int i) {
            l.a(menuItem, i);
        }

        @Override // android.support.v4.g.k.d
        public MenuItem a(MenuItem menuItem, View view) {
            return l.a(menuItem, view);
        }

        @Override // android.support.v4.g.k.d
        public MenuItem b(MenuItem menuItem, int i) {
            return l.b(menuItem, i);
        }

        @Override // android.support.v4.g.k.d
        public boolean a(MenuItem menuItem) {
            return false;
        }
    }

    /* compiled from: MenuItemCompat.java */
    /* loaded from: classes.dex */
    static class c extends b {
        c() {
        }

        @Override // android.support.v4.g.k.b, android.support.v4.g.k.d
        public boolean a(MenuItem menuItem) {
            return m.a(menuItem);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 14) {
            f95a = new c();
        } else if (i >= 11) {
            f95a = new b();
        } else {
            f95a = new a();
        }
    }

    public static void a(MenuItem menuItem, int i) {
        if (menuItem instanceof android.support.v4.c.a.b) {
            ((android.support.v4.c.a.b) menuItem).setShowAsAction(i);
        } else {
            f95a.a(menuItem, i);
        }
    }

    public static MenuItem a(MenuItem menuItem, View view) {
        return menuItem instanceof android.support.v4.c.a.b ? ((android.support.v4.c.a.b) menuItem).setActionView(view) : f95a.a(menuItem, view);
    }

    public static MenuItem b(MenuItem menuItem, int i) {
        return menuItem instanceof android.support.v4.c.a.b ? ((android.support.v4.c.a.b) menuItem).setActionView(i) : f95a.b(menuItem, i);
    }

    public static MenuItem a(MenuItem menuItem, android.support.v4.g.a aVar) {
        if (menuItem instanceof android.support.v4.c.a.b) {
            return ((android.support.v4.c.a.b) menuItem).a(aVar);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static boolean a(MenuItem menuItem) {
        return menuItem instanceof android.support.v4.c.a.b ? ((android.support.v4.c.a.b) menuItem).expandActionView() : f95a.a(menuItem);
    }
}
