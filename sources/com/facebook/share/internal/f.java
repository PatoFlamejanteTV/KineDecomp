package com.facebook.share.internal;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LikeActionController.java */
/* loaded from: classes.dex */
public final class f implements CallbackManagerImpl.Callback {
    @Override // com.facebook.internal.CallbackManagerImpl.Callback
    public boolean onActivityResult(int i, Intent intent) {
        return LikeActionController.handleOnActivityResult(CallbackManagerImpl.RequestCodeOffset.Like.toRequestCode(), i, intent);
    }
}
