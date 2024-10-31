package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.internal.AppCall;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.Sharer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareInternalUtility.java */
/* loaded from: classes.dex */
public class H extends ResultProcessor {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FacebookCallback f9508a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H(FacebookCallback facebookCallback, FacebookCallback facebookCallback2) {
        super(facebookCallback);
        this.f9508a = facebookCallback2;
    }

    @Override // com.facebook.share.internal.ResultProcessor
    public void onCancel(AppCall appCall) {
        ShareInternalUtility.invokeOnCancelCallback(this.f9508a);
    }

    @Override // com.facebook.share.internal.ResultProcessor
    public void onError(AppCall appCall, FacebookException facebookException) {
        ShareInternalUtility.invokeOnErrorCallback((FacebookCallback<Sharer.Result>) this.f9508a, facebookException);
    }

    @Override // com.facebook.share.internal.ResultProcessor
    public void onSuccess(AppCall appCall, Bundle bundle) {
        if (bundle != null) {
            String nativeDialogCompletionGesture = ShareInternalUtility.getNativeDialogCompletionGesture(bundle);
            if (nativeDialogCompletionGesture != null && !"post".equalsIgnoreCase(nativeDialogCompletionGesture)) {
                if ("cancel".equalsIgnoreCase(nativeDialogCompletionGesture)) {
                    ShareInternalUtility.invokeOnCancelCallback(this.f9508a);
                    return;
                } else {
                    ShareInternalUtility.invokeOnErrorCallback((FacebookCallback<Sharer.Result>) this.f9508a, new FacebookException(NativeProtocol.ERROR_UNKNOWN_ERROR));
                    return;
                }
            }
            ShareInternalUtility.invokeOnSuccessCallback(this.f9508a, ShareInternalUtility.getShareDialogPostId(bundle));
        }
    }
}
