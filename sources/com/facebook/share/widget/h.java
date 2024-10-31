package com.facebook.share.widget;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;

/* compiled from: GameRequestDialog.java */
/* loaded from: classes.dex */
class h implements CallbackManagerImpl.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultProcessor f9632a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ GameRequestDialog f9633b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(GameRequestDialog gameRequestDialog, ResultProcessor resultProcessor) {
        this.f9633b = gameRequestDialog;
        this.f9632a = resultProcessor;
    }

    @Override // com.facebook.internal.CallbackManagerImpl.Callback
    public boolean onActivityResult(int i, Intent intent) {
        return ShareInternalUtility.handleActivityResult(this.f9633b.getRequestCode(), i, intent, this.f9632a);
    }
}
