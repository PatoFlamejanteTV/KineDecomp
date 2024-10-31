package com.facebook.share.widget;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;

/* compiled from: JoinAppGroupDialog.java */
/* loaded from: classes.dex */
class i implements CallbackManagerImpl.Callback {

    /* renamed from: a */
    final /* synthetic */ ResultProcessor f404a;
    final /* synthetic */ JoinAppGroupDialog b;

    public i(JoinAppGroupDialog joinAppGroupDialog, ResultProcessor resultProcessor) {
        this.b = joinAppGroupDialog;
        this.f404a = resultProcessor;
    }

    @Override // com.facebook.internal.CallbackManagerImpl.Callback
    public boolean onActivityResult(int i, Intent intent) {
        return ShareInternalUtility.handleActivityResult(this.b.getRequestCode(), i, intent, this.f404a);
    }
}
