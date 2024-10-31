package com.google.firebase.dynamiclinks;

import android.content.Intent;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;

/* loaded from: classes2.dex */
public abstract class FirebaseDynamicLinks {
    public static synchronized FirebaseDynamicLinks a() {
        FirebaseDynamicLinks firebaseDynamicLinks;
        synchronized (FirebaseDynamicLinks.class) {
            firebaseDynamicLinks = (FirebaseDynamicLinks) FirebaseApp.c().a(FirebaseDynamicLinks.class);
        }
        return firebaseDynamicLinks;
    }

    public abstract Task<PendingDynamicLinkData> a(Intent intent);
}
