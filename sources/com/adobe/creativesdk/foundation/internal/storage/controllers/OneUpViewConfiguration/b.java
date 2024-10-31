package com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration;

import android.view.Menu;
import android.view.View;
import java.util.HashMap;

/* compiled from: AdobeOneUpViewerBaseConfiguration.java */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: b */
    private boolean f5759b;

    /* renamed from: e */
    private Menu f5762e;

    /* renamed from: f */
    private j f5763f;

    /* renamed from: c */
    private HashMap<Integer, Integer> f5760c = new HashMap<>();

    /* renamed from: d */
    private HashMap<Integer, View> f5761d = new HashMap<>();

    /* renamed from: a */
    private int f5758a = -1;

    public void a(int i, View view) {
        this.f5761d.put(Integer.valueOf(i), view);
    }

    public int b() {
        return this.f5758a;
    }

    public boolean c() {
        return this.f5759b;
    }

    public Integer a(int i) {
        return this.f5760c.get(Integer.valueOf(i));
    }

    public void a(boolean z) {
        this.f5759b = z;
    }

    public j a() {
        return this.f5763f;
    }

    public void a(Menu menu) {
        this.f5762e = menu;
    }
}
