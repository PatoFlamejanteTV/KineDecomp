package com.google.android.gms.tagmanager;

import android.support.v4.app.NotificationCompat;
import com.google.android.gms.tagmanager.DataLayer;
import java.util.Map;

/* loaded from: classes2.dex */
public final class A implements DataLayer.b {

    /* renamed from: a */
    private final /* synthetic */ TagManager f14158a;

    public A(TagManager tagManager) {
        this.f14158a = tagManager;
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.b
    public final void a(Map<String, Object> map) {
        Object obj = map.get(NotificationCompat.CATEGORY_EVENT);
        if (obj != null) {
            this.f14158a.a(obj.toString());
        }
    }
}
