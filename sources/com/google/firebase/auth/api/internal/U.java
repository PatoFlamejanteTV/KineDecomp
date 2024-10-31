package com.google.firebase.auth.api.internal;

import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

/* loaded from: classes2.dex */
final class U implements Y {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ PhoneAuthCredential f16442a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public U(S s, PhoneAuthCredential phoneAuthCredential) {
        this.f16442a = phoneAuthCredential;
    }

    @Override // com.google.firebase.auth.api.internal.Y
    public final void a(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.a(this.f16442a);
    }
}
