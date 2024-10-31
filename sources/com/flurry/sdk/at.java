package com.flurry.sdk;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class at implements ax {

    /* renamed from: a, reason: collision with root package name */
    private static at f468a;
    private final List<ax> b = b();

    public static synchronized at a() {
        at atVar;
        synchronized (at.class) {
            if (f468a == null) {
                f468a = new at();
            }
            atVar = f468a;
        }
        return atVar;
    }

    private at() {
    }

    @Override // com.flurry.sdk.ax
    public void a(Context context) {
        Iterator<ax> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a(context);
        }
    }

    @Override // com.flurry.sdk.ax
    public void b(Context context) {
        Iterator<ax> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().b(context);
        }
    }

    private static List<ax> b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new au("com.flurry.android.impl.appcloud.AppCloudModule", 10));
        arrayList.add(new au("com.flurry.android.impl.ads.FlurryAdModule", 10));
        return Collections.unmodifiableList(arrayList);
    }
}
