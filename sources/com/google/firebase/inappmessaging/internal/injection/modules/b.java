package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.internal.ForegroundNotifier;
import io.reactivex.f;
import io.reactivex.g;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class b implements g {

    /* renamed from: a */
    private final ForegroundNotifier f17966a;

    private b(ForegroundNotifier foregroundNotifier) {
        this.f17966a = foregroundNotifier;
    }

    public static g a(ForegroundNotifier foregroundNotifier) {
        return new b(foregroundNotifier);
    }

    @Override // io.reactivex.g
    public void a(f fVar) {
        this.f17966a.a(c.a(fVar));
    }
}
