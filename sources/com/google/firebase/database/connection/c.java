package com.google.firebase.database.connection;

import com.google.firebase.database.connection.PersistentConnectionImpl;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class c implements PersistentConnectionImpl.a {

    /* renamed from: a */
    final /* synthetic */ RequestResultCallback f16780a;

    /* renamed from: b */
    final /* synthetic */ PersistentConnectionImpl f16781b;

    public c(PersistentConnectionImpl persistentConnectionImpl, RequestResultCallback requestResultCallback) {
        this.f16781b = persistentConnectionImpl;
        this.f16780a = requestResultCallback;
    }

    @Override // com.google.firebase.database.connection.PersistentConnectionImpl.a
    public void a(Map<String, Object> map) {
        String str = (String) map.get(com.umeng.commonsdk.proguard.e.ap);
        String str2 = null;
        if (str.equals("ok")) {
            str = null;
        } else {
            str2 = (String) map.get(com.umeng.commonsdk.proguard.e.am);
        }
        RequestResultCallback requestResultCallback = this.f16780a;
        if (requestResultCallback != null) {
            requestResultCallback.a(str, str2);
        }
    }
}
