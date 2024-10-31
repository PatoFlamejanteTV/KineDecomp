package com.google.firebase.database.connection;

import com.google.firebase.database.connection.PersistentConnectionImpl;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class f implements PersistentConnectionImpl.a {

    /* renamed from: a */
    final /* synthetic */ PersistentConnectionImpl.d f16789a;

    /* renamed from: b */
    final /* synthetic */ PersistentConnectionImpl f16790b;

    public f(PersistentConnectionImpl persistentConnectionImpl, PersistentConnectionImpl.d dVar) {
        this.f16790b = persistentConnectionImpl;
        this.f16789a = dVar;
    }

    @Override // com.google.firebase.database.connection.PersistentConnectionImpl.a
    public void a(Map<String, Object> map) {
        Map map2;
        String str = (String) map.get(com.umeng.commonsdk.proguard.e.ap);
        if (str.equals("ok")) {
            if (((Map) map.get(com.umeng.commonsdk.proguard.e.am)).containsKey("w")) {
                this.f16790b.a((List<String>) r2.get("w"), this.f16789a.f16756b);
            }
        }
        map2 = this.f16790b.o;
        if (((PersistentConnectionImpl.d) map2.get(this.f16789a.b())) == this.f16789a) {
            if (str.equals("ok")) {
                this.f16789a.f16755a.a(null, null);
                return;
            }
            this.f16790b.a(this.f16789a.b());
            this.f16789a.f16755a.a(str, (String) map.get(com.umeng.commonsdk.proguard.e.am));
        }
    }
}
