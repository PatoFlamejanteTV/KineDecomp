package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.DataLayer;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements DataLayer.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TagManager f2225a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TagManager tagManager) {
        this.f2225a = tagManager;
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.b
    public void a(Map<String, Object> map) {
        Object obj = map.get("event");
        if (obj != null) {
            this.f2225a.a(obj.toString());
        }
    }
}
