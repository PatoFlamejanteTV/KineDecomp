package com.google.firebase.database.connection;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public interface ConnectionAuthTokenProvider {

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public interface GetTokenCallback {
        void a(String str);

        void onError(String str);
    }

    void a(boolean z, GetTokenCallback getTokenCallback);
}
