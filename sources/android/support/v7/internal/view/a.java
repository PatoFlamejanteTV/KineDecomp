package android.support.v7.internal.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v4.g.w;
import android.support.v7.b.a;
import android.view.ViewConfiguration;

/* compiled from: ActionBarPolicy.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f120a;

    public static a a(Context context) {
        return new a(context);
    }

    private a(Context context) {
        this.f120a = context;
    }

    public int a() {
        return this.f120a.getResources().getInteger(a.f.abc_max_action_buttons);
    }

    public boolean b() {
        return Build.VERSION.SDK_INT >= 19 || !w.a(ViewConfiguration.get(this.f120a));
    }

    public int c() {
        return this.f120a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean d() {
        return this.f120a.getApplicationInfo().targetSdkVersion >= 16 ? this.f120a.getResources().getBoolean(a.b.abc_action_bar_embed_tabs) : this.f120a.getResources().getBoolean(a.b.abc_action_bar_embed_tabs_pre_jb);
    }

    public int e() {
        TypedArray obtainStyledAttributes = this.f120a.obtainStyledAttributes(null, a.i.ActionBar, a.C0016a.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(a.i.ActionBar_height, 0);
        Resources resources = this.f120a.getResources();
        if (!d()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(a.c.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public int f() {
        return this.f120a.getResources().getDimensionPixelSize(a.c.abc_action_bar_stacked_tab_max_width);
    }
}
