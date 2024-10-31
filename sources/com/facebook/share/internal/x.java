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
public final class x extends ResultProcessor {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FacebookCallback f378a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(FacebookCallback facebookCallback, FacebookCallback facebookCallback2) {
        super(facebookCallback);
        this.f378a = facebookCallback2;
    }

    @Override // com.facebook.share.internal.ResultProcessor
    public void onSuccess(AppCall appCall, Bundle bundle) {
        if (bundle != null) {
            String nativeDialogCompletionGesture = ShareInternalUtility.getNativeDialogCompletionGesture(bundle);
            if (nativeDialogCompletionGesture == null || "post".equalsIgnoreCase(nativeDialogCompletionGesture)) {
                ShareInternalUtility.invokeOnSuccessCallback(this.f378a, ShareInternalUtility.getShareDialogPostId(bundle));
            } else if ("cancel".equalsIgnoreCase(nativeDialogCompletionGesture)) {
                ShareInternalUtility.invokeOnCancelCallback(this.f378a);
            } else {
                ShareInternalUtility.invokeOnErrorCallback((FacebookCallback<Sharer.Result>) this.f378a, new FacebookException(NativeProtocol.ERROR_UNKNOWN_ERROR));
            }
        }
    }

    @Override // com.facebook.share.internal.ResultProcessor
    public void onCancel(AppCall appCall) {
        ShareInternalUtility.invokeOnCancelCallback(this.f378a);
    }

    @Override // com.facebook.share.internal.ResultProcessor
    public void onError(AppCall appCall, FacebookException facebookException) {
        ShareInternalUtility.invokeOnErrorCallback((FacebookCallback<Sharer.Result>) this.f378a, facebookException);
    }
}
