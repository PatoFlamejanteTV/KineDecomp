package com.google.firebase.database.android;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.connection.PersistentConnection;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
class g implements FirebaseApp.BackgroundStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ PersistentConnection f16677a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AndroidPlatform f16678b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AndroidPlatform androidPlatform, PersistentConnection persistentConnection) {
        this.f16678b = androidPlatform;
        this.f16677a = persistentConnection;
    }

    @Override // com.google.firebase.FirebaseApp.BackgroundStateChangeListener
    public void a(boolean z) {
        if (z) {
            this.f16677a.b("app_in_background");
        } else {
            this.f16677a.d("app_in_background");
        }
    }
}
