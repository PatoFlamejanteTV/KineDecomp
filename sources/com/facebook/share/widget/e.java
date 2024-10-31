package com.facebook.share.widget;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;

/* compiled from: CreateAppGroupDialog.java */
/* loaded from: classes.dex */
class e implements CallbackManagerImpl.Callback {

    /* renamed from: a */
    final /* synthetic */ ResultProcessor f400a;
    final /* synthetic */ CreateAppGroupDialog b;

    public e(CreateAppGroupDialog createAppGroupDialog, ResultProcessor resultProcessor) {
        this.b = createAppGroupDialog;
        this.f400a = resultProcessor;
    }

    @Override // com.facebook.internal.CallbackManagerImpl.Callback
    public boolean onActivityResult(int i, Intent intent) {
        return ShareInternalUtility.handleActivityResult(this.b.getRequestCode(), i, intent, this.f400a);
    }
}
