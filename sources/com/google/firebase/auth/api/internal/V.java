package com.google.firebase.auth.api.internal;

import com.google.firebase.auth.PhoneAuthProvider;

/* loaded from: classes2.dex */
final class V implements Y {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f16443a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public V(S s, String str) {
        this.f16443a = str;
    }

    @Override // com.google.firebase.auth.api.internal.Y
    public final void a(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.a(this.f16443a);
    }
}
