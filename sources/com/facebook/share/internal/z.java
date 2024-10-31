package com.facebook.share.internal;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;

/* compiled from: LikeDialog.java */
/* loaded from: classes.dex */
class z implements CallbackManagerImpl.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultProcessor f9602a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ LikeDialog f9603b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(LikeDialog likeDialog, ResultProcessor resultProcessor) {
        this.f9603b = likeDialog;
        this.f9602a = resultProcessor;
    }

    @Override // com.facebook.internal.CallbackManagerImpl.Callback
    public boolean onActivityResult(int i, Intent intent) {
        return ShareInternalUtility.handleActivityResult(this.f9603b.getRequestCode(), i, intent, this.f9602a);
    }
}
