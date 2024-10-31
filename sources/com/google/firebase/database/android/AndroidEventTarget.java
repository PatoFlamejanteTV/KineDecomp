package com.google.firebase.database.android;

import android.os.Handler;
import android.os.Looper;
import com.google.firebase.database.core.EventTarget;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class AndroidEventTarget implements EventTarget {

    /* renamed from: a */
    private final Handler f16655a = new Handler(Looper.getMainLooper());

    @Override // com.google.firebase.database.core.EventTarget
    public void a() {
    }

    @Override // com.google.firebase.database.core.EventTarget
    public void a(Runnable runnable) {
        this.f16655a.post(runnable);
    }
}
