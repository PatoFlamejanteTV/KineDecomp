package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.internal.ForegroundNotifier;
import io.reactivex.f;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class c implements ForegroundNotifier.Listener {

    /* renamed from: a */
    private final f f17967a;

    private c(f fVar) {
        this.f17967a = fVar;
    }

    public static ForegroundNotifier.Listener a(f fVar) {
        return new c(fVar);
    }

    @Override // com.google.firebase.inappmessaging.internal.ForegroundNotifier.Listener
    public void a() {
        this.f17967a.onNext("ON_FOREGROUND");
    }
}
