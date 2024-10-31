package com.facebook.share.widget;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;

/* compiled from: GameRequestDialog.java */
/* loaded from: classes.dex */
class g implements CallbackManagerImpl.Callback {

    /* renamed from: a */
    final /* synthetic */ ResultProcessor f402a;
    final /* synthetic */ GameRequestDialog b;

    public g(GameRequestDialog gameRequestDialog, ResultProcessor resultProcessor) {
        this.b = gameRequestDialog;
        this.f402a = resultProcessor;
    }

    @Override // com.facebook.internal.CallbackManagerImpl.Callback
    public boolean onActivityResult(int i, Intent intent) {
        return ShareInternalUtility.handleActivityResult(this.b.getRequestCode(), i, intent, this.f402a);
    }
}
