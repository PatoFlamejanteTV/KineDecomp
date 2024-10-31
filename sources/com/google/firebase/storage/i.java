package com.google.firebase.storage;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnCanceledListener;

/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class i implements OnCanceledListener {

    /* renamed from: a */
    private final CancellationTokenSource f18149a;

    private i(CancellationTokenSource cancellationTokenSource) {
        this.f18149a = cancellationTokenSource;
    }

    public static OnCanceledListener a(CancellationTokenSource cancellationTokenSource) {
        return new i(cancellationTokenSource);
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public void a() {
        this.f18149a.a();
    }
}
