package com.nexstreaming.kinemaster.ui.store.view;

import android.view.View;
import java.util.HashMap;

/* compiled from: AssetStoreFocusManager.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a */
    private static a f23679a;

    /* renamed from: f */
    public final String f23684f = "main_category_view";

    /* renamed from: g */
    public final String f23685g = "sub_category_view";

    /* renamed from: h */
    public final String f23686h = "feature_banner_view";
    public final String i = "feature_asset_view";
    public final String j = "asset_view";

    /* renamed from: b */
    private HashMap<String, View> f23680b = new HashMap<>();

    /* renamed from: c */
    private boolean f23681c = false;

    /* renamed from: d */
    private boolean f23682d = false;

    /* renamed from: e */
    private int f23683e = 0;

    private a() {
    }

    public static a a() {
        if (f23679a == null) {
            f23679a = new a();
        }
        return f23679a;
    }

    public boolean b() {
        return this.f23681c;
    }

    public boolean c() {
        return this.f23682d;
    }

    public boolean d() {
        return this.f23683e == 0;
    }

    public void a(String str, View view) {
        this.f23680b.put(str, view);
    }

    public void a(String str, boolean z) {
        this.f23682d = z;
        if (this.f23680b.get(str) != null) {
            this.f23680b.get(str).requestFocus();
        }
    }

    public void a(boolean z) {
        this.f23681c = z;
    }

    public void a(int i) {
        this.f23683e = i;
    }
}
