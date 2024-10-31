package com.google.firebase.database.connection;

import com.google.firebase.database.connection.PersistentConnectionImpl;
import com.google.firebase.database.logging.LogWrapper;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class e implements PersistentConnectionImpl.a {

    /* renamed from: a */
    final /* synthetic */ String f16784a;

    /* renamed from: b */
    final /* synthetic */ long f16785b;

    /* renamed from: c */
    final /* synthetic */ PersistentConnectionImpl.e f16786c;

    /* renamed from: d */
    final /* synthetic */ RequestResultCallback f16787d;

    /* renamed from: e */
    final /* synthetic */ PersistentConnectionImpl f16788e;

    public e(PersistentConnectionImpl persistentConnectionImpl, String str, long j, PersistentConnectionImpl.e eVar, RequestResultCallback requestResultCallback) {
        this.f16788e = persistentConnectionImpl;
        this.f16784a = str;
        this.f16785b = j;
        this.f16786c = eVar;
        this.f16787d = requestResultCallback;
    }

    @Override // com.google.firebase.database.connection.PersistentConnectionImpl.a
    public void a(Map<String, Object> map) {
        LogWrapper logWrapper;
        Map map2;
        LogWrapper logWrapper2;
        LogWrapper logWrapper3;
        Map map3;
        LogWrapper logWrapper4;
        logWrapper = this.f16788e.u;
        if (logWrapper.a()) {
            logWrapper4 = this.f16788e.u;
            logWrapper4.a(this.f16784a + " response: " + map, new Object[0]);
        }
        map2 = this.f16788e.n;
        if (((PersistentConnectionImpl.e) map2.get(Long.valueOf(this.f16785b))) == this.f16786c) {
            map3 = this.f16788e.n;
            map3.remove(Long.valueOf(this.f16785b));
            if (this.f16787d != null) {
                String str = (String) map.get(com.umeng.commonsdk.proguard.e.ap);
                if (str.equals("ok")) {
                    this.f16787d.a(null, null);
                } else {
                    this.f16787d.a(str, (String) map.get(com.umeng.commonsdk.proguard.e.am));
                }
            }
        } else {
            logWrapper2 = this.f16788e.u;
            if (logWrapper2.a()) {
                logWrapper3 = this.f16788e.u;
                logWrapper3.a("Ignoring on complete for put " + this.f16785b + " because it was removed already.", new Object[0]);
            }
        }
        this.f16788e.f();
    }
}
