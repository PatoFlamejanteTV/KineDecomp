package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.PhoneAuthProvider;

/* loaded from: classes2.dex */
final class W implements Y {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Status f16444a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public W(S s, Status status) {
        this.f16444a = status;
    }

    @Override // com.google.firebase.auth.api.internal.Y
    public final void a(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.a(zzds.a(this.f16444a));
    }
}
