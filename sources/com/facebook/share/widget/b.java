package com.facebook.share.widget;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;

/* compiled from: AppInviteDialog.java */
/* loaded from: classes.dex */
class b implements CallbackManagerImpl.Callback {

    /* renamed from: a */
    final /* synthetic */ ResultProcessor f397a;
    final /* synthetic */ AppInviteDialog b;

    public b(AppInviteDialog appInviteDialog, ResultProcessor resultProcessor) {
        this.b = appInviteDialog;
        this.f397a = resultProcessor;
    }

    @Override // com.facebook.internal.CallbackManagerImpl.Callback
    public boolean onActivityResult(int i, Intent intent) {
        return ShareInternalUtility.handleActivityResult(this.b.getRequestCode(), i, intent, this.f397a);
    }
}
