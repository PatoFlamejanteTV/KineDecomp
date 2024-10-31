package com.google.firebase.database.connection;

import com.google.firebase.database.connection.PersistentConnectionImpl;
import com.google.firebase.database.logging.LogWrapper;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class g implements PersistentConnectionImpl.a {

    /* renamed from: a */
    final /* synthetic */ PersistentConnectionImpl f16791a;

    public g(PersistentConnectionImpl persistentConnectionImpl) {
        this.f16791a = persistentConnectionImpl;
    }

    @Override // com.google.firebase.database.connection.PersistentConnectionImpl.a
    public void a(Map<String, Object> map) {
        LogWrapper logWrapper;
        LogWrapper logWrapper2;
        String str = (String) map.get(com.umeng.commonsdk.proguard.e.ap);
        if (str.equals("ok")) {
            return;
        }
        String str2 = (String) map.get(com.umeng.commonsdk.proguard.e.am);
        logWrapper = this.f16791a.u;
        if (logWrapper.a()) {
            logWrapper2 = this.f16791a.u;
            logWrapper2.a("Failed to send stats: " + str + " (message: " + str2 + ")", new Object[0]);
        }
    }
}
