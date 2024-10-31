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
/* loaded from: classes.dex */
public class i extends ResultProcessor {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bundle f366a;
    final /* synthetic */ LikeActionController b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(LikeActionController likeActionController, FacebookCallback facebookCallback, Bundle bundle) {
        super(facebookCallback);
        this.b = likeActionController;
        this.f366a = bundle;
    }

    @Override // com.facebook.share.internal.ResultProcessor
    public void onSuccess(AppCall appCall, Bundle bundle) {
        String str;
        AppEventsLogger appEventsLogger;
        if (bundle != null && bundle.containsKey("object_is_liked")) {
            boolean z = bundle.getBoolean("object_is_liked");
            String str2 = this.b.likeCountStringWithLike;
            String str3 = this.b.likeCountStringWithoutLike;
            if (bundle.containsKey("like_count_string")) {
                str3 = bundle.getString("like_count_string");
                str2 = str3;
            }
            String str4 = this.b.socialSentenceWithLike;
            String str5 = this.b.socialSentenceWithoutLike;
            if (bundle.containsKey("social_sentence")) {
                str5 = bundle.getString("social_sentence");
                str4 = str5;
            }
            if (!bundle.containsKey("object_is_liked")) {
                str = this.b.unlikeToken;
            } else {
                str = bundle.getString("unlike_token");
            }
            Bundle bundle2 = this.f366a == null ? new Bundle() : this.f366a;
            bundle2.putString(AnalyticsEvents.PARAMETER_CALL_ID, appCall.getCallId().toString());
            appEventsLogger = this.b.getAppEventsLogger();
            appEventsLogger.logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_DIALOG_DID_SUCCEED, null, bundle2);
            this.b.updateState(z, str2, str3, str4, str5, str);
        }
    }

    @Override // com.facebook.share.internal.ResultProcessor
    public void onError(AppCall appCall, FacebookException facebookException) {
        Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Like Dialog failed with error : %s", facebookException);
        Bundle bundle = this.f366a == null ? new Bundle() : this.f366a;
        bundle.putString(AnalyticsEvents.PARAMETER_CALL_ID, appCall.getCallId().toString());
        this.b.logAppEventForError("present_dialog", bundle);
        LikeActionController.broadcastAction(this.b, LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR, NativeProtocol.createBundleForException(facebookException));
    }

    @Override // com.facebook.share.internal.ResultProcessor
    public void onCancel(AppCall appCall) {
        onError(appCall, new FacebookOperationCanceledException());
    }
}
