package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.rb;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.storage.C0614ub;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibrarySyncManager.java */
/* loaded from: classes.dex */
public class X implements rb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4561a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0614ub f4562b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ha f4563c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public X(ha haVar, int i, C0614ub c0614ub) {
        this.f4563c = haVar;
        this.f4561a = i;
        this.f4562b = c0614ub;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.rb
    public void a(AdobeCSDKException adobeCSDKException) {
        this.f4563c.a(this.f4562b, false, adobeCSDKException);
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.rb
    public void onSuccess() {
        int i;
        int i2 = this.f4561a;
        i = this.f4563c.G;
        if (i2 != i) {
            return;
        }
        this.f4563c.a(this.f4562b, true, (AdobeCSDKException) null);
    }
}
