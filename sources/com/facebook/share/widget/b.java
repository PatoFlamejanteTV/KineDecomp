package com.facebook.share.widget;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;

/* compiled from: AppInviteDialog.java */
/* loaded from: classes.dex */
class b implements CallbackManagerImpl.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultProcessor f9621a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AppInviteDialog f9622b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AppInviteDialog appInviteDialog, ResultProcessor resultProcessor) {
        this.f9622b = appInviteDialog;
        this.f9621a = resultProcessor;
    }

    @Override // com.facebook.internal.CallbackManagerImpl.Callback
    public boolean onActivityResult(int i, Intent intent) {
        return ShareInternalUtility.handleActivityResult(this.f9622b.getRequestCode(), i, intent, this.f9621a);
    }
}
