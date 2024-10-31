package com.google.firebase.database.connection;

import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.database.connection.PersistentConnectionImpl;
import com.google.firebase.database.connection.util.RetryHelper;
import com.google.firebase.database.logging.LogWrapper;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class d implements PersistentConnectionImpl.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f16782a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ PersistentConnectionImpl f16783b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersistentConnectionImpl persistentConnectionImpl, boolean z) {
        this.f16783b = persistentConnectionImpl;
        this.f16782a = z;
    }

    @Override // com.google.firebase.database.connection.PersistentConnectionImpl.a
    public void a(Map<String, Object> map) {
        PersistentConnection.Delegate delegate;
        LogWrapper logWrapper;
        Connection connection;
        int i;
        RetryHelper retryHelper;
        LogWrapper logWrapper2;
        PersistentConnection.Delegate delegate2;
        this.f16783b.i = PersistentConnectionImpl.ConnectionState.Connected;
        String str = (String) map.get(com.umeng.commonsdk.proguard.e.ap);
        if (str.equals("ok")) {
            this.f16783b.y = 0;
            delegate2 = this.f16783b.f16742b;
            delegate2.a(true);
            if (this.f16782a) {
                this.f16783b.k();
                return;
            }
            return;
        }
        this.f16783b.p = null;
        this.f16783b.q = true;
        delegate = this.f16783b.f16742b;
        delegate.a(false);
        String str2 = (String) map.get(com.umeng.commonsdk.proguard.e.am);
        logWrapper = this.f16783b.u;
        logWrapper.a("Authentication failed: " + str + " (" + str2 + ")", new Object[0]);
        connection = this.f16783b.f16748h;
        connection.a();
        if (str.equals("invalid_token")) {
            PersistentConnectionImpl.b(this.f16783b);
            i = this.f16783b.y;
            if (i >= 3) {
                retryHelper = this.f16783b.v;
                retryHelper.b();
                logWrapper2 = this.f16783b.u;
                logWrapper2.b("Provided authentication credentials are invalid. This usually indicates your FirebaseApp instance was not initialized correctly. Make sure your google-services.json file has the correct firebase_url and api_key. You can re-download google-services.json from https://console.firebase.google.com/.");
            }
        }
    }
}
