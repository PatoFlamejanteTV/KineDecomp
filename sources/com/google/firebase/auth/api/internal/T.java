package com.google.firebase.auth.api.internal;

import com.google.firebase.auth.PhoneAuthProvider;

/* loaded from: classes2.dex */
final class T implements Y {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f16441a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public T(S s, String str) {
        this.f16441a = str;
    }

    @Override // com.google.firebase.auth.api.internal.Y
    public final void a(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.a(this.f16441a, PhoneAuthProvider.ForceResendingToken.a());
    }
}
