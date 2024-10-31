package com.google.firebase.database.core;

import com.google.firebase.FirebaseApp;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class DatabaseConfig extends Context {
    public synchronized void a(FirebaseApp firebaseApp) {
        this.k = firebaseApp;
    }

    public synchronized void c(String str) {
        a();
        if (str != null && !str.isEmpty()) {
            this.f16844e = str;
        } else {
            throw new IllegalArgumentException("Session identifier is not allowed to be empty or null!");
        }
    }
}
