package com.facebook.share.widget;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;

/* compiled from: CreateAppGroupDialog.java */
/* loaded from: classes.dex */
class e implements CallbackManagerImpl.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultProcessor f9627a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ CreateAppGroupDialog f9628b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(CreateAppGroupDialog createAppGroupDialog, ResultProcessor resultProcessor) {
        this.f9628b = createAppGroupDialog;
        this.f9627a = resultProcessor;
    }

    @Override // com.facebook.internal.CallbackManagerImpl.Callback
    public boolean onActivityResult(int i, Intent intent) {
        return ShareInternalUtility.handleActivityResult(this.f9628b.getRequestCode(), i, intent, this.f9627a);
    }
}
