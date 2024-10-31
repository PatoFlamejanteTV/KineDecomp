package com.facebook.share.internal;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareInternalUtility.java */
/* loaded from: classes.dex */
public final class y implements CallbackManagerImpl.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f379a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(int i) {
        this.f379a = i;
    }

    @Override // com.facebook.internal.CallbackManagerImpl.Callback
    public boolean onActivityResult(int i, Intent intent) {
        return ShareInternalUtility.handleActivityResult(this.f379a, i, intent, ShareInternalUtility.getShareResultProcessor(null));
    }
}
