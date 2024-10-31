package com.google.firebase.database.core;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public interface AuthTokenProvider {

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public interface GetTokenCompletionListener {
        void a(String str);

        void onError(String str);
    }

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public interface TokenChangeListener {
        void a(String str);
    }

    void a(TokenChangeListener tokenChangeListener);

    void a(boolean z, GetTokenCompletionListener getTokenCompletionListener);
}
