package com.facebook.share.widget;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;

/* compiled from: JoinAppGroupDialog.java */
/* loaded from: classes.dex */
class j implements CallbackManagerImpl.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultProcessor f9636a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ JoinAppGroupDialog f9637b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(JoinAppGroupDialog joinAppGroupDialog, ResultProcessor resultProcessor) {
        this.f9637b = joinAppGroupDialog;
        this.f9636a = resultProcessor;
    }

    @Override // com.facebook.internal.CallbackManagerImpl.Callback
    public boolean onActivityResult(int i, Intent intent) {
        return ShareInternalUtility.handleActivityResult(this.f9637b.getRequestCode(), i, intent, this.f9636a);
    }
}
