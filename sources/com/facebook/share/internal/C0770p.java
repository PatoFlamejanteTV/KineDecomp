package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.AppCall;
import com.facebook.internal.Logger;
import com.facebook.internal.NativeProtocol;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LikeActionController.java */
/* renamed from: com.facebook.share.internal.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0770p extends ResultProcessor {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bundle f9585a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ LikeActionController f9586b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0770p(LikeActionController likeActionController, FacebookCallback facebookCallback, Bundle bundle) {
        super(facebookCallback);
        this.f9586b = likeActionController;
        this.f9585a = bundle;
    }

    @Override // com.facebook.share.internal.ResultProcessor
    public void onCancel(AppCall appCall) {
        onError(appCall, new FacebookOperationCanceledException());
    }

    @Override // com.facebook.share.internal.ResultProcessor
    public void onError(AppCall appCall, FacebookException facebookException) {
        Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Like Dialog failed with error : %s", facebookException);
        Bundle bundle = this.f9585a;
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString(AnalyticsEvents.PARAMETER_CALL_ID, appCall.getCallId().toString());
        this.f9586b.logAppEventForError("present_dialog", bundle);
        LikeActionController.broadcastAction(this.f9586b, LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR, NativeProtocol.createBundleForException(facebookException));
    }

    @Override // com.facebook.share.internal.ResultProcessor
    public void onSuccess(AppCall appCall, Bundle bundle) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        AppEventsLogger appEventsLogger;
        if (bundle == null || !bundle.containsKey("object_is_liked")) {
            return;
        }
        boolean z = bundle.getBoolean("object_is_liked");
        String str6 = this.f9586b.likeCountStringWithLike;
        String str7 = this.f9586b.likeCountStringWithoutLike;
        if (bundle.containsKey("like_count_string")) {
            str = bundle.getString("like_count_string");
            str2 = str;
        } else {
            str = str6;
            str2 = str7;
        }
        String str8 = this.f9586b.socialSentenceWithLike;
        String str9 = this.f9586b.socialSentenceWithoutLike;
        if (bundle.containsKey("social_sentence")) {
            str3 = bundle.getString("social_sentence");
            str4 = str3;
        } else {
            str3 = str8;
            str4 = str9;
        }
        if (!bundle.containsKey("object_is_liked")) {
            str5 = this.f9586b.unlikeToken;
        } else {
            str5 = bundle.getString("unlike_token");
        }
        String str10 = str5;
        Bundle bundle2 = this.f9585a;
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        bundle2.putString(AnalyticsEvents.PARAMETER_CALL_ID, appCall.getCallId().toString());
        appEventsLogger = this.f9586b.getAppEventsLogger();
        appEventsLogger.logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_DIALOG_DID_SUCCEED, null, bundle2);
        this.f9586b.updateState(z, str, str2, str3, str4, str10);
    }
}
