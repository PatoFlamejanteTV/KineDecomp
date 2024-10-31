package com.facebook.share.internal;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;

/* compiled from: LikeDialog.java */
/* loaded from: classes.dex */
class s implements CallbackManagerImpl.Callback {

    /* renamed from: a */
    final /* synthetic */ ResultProcessor f375a;
    final /* synthetic */ LikeDialog b;

    public s(LikeDialog likeDialog, ResultProcessor resultProcessor) {
        this.b = likeDialog;
        this.f375a = resultProcessor;
    }

    @Override // com.facebook.internal.CallbackManagerImpl.Callback
    public boolean onActivityResult(int i, Intent intent) {
        return ShareInternalUtility.handleActivityResult(this.b.getRequestCode(), i, intent, this.f375a);
    }
}
