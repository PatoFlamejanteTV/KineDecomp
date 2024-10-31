package com.facebook.share.internal;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class LikeDialog extends FacebookDialogBase<LikeContent, Result> {
    private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.Like.toRequestCode();
    private static final String TAG = "LikeDialog";

    static /* synthetic */ DialogFeature access$300() {
        return getFeature();
    }

    /* loaded from: classes.dex */
    public static final class Result {
        private final Bundle bundle;

        public Result(Bundle bundle) {
            this.bundle = bundle;
        }

        public Bundle getData() {
            return this.bundle;
        }
    }

    public static boolean canShowNativeDialog() {
        return DialogPresenter.canPresentNativeDialogWithFeature(getFeature());
    }

    public static boolean canShowWebFallback() {
        return DialogPresenter.canPresentWebFallbackDialogWithFeature(getFeature());
    }

    public LikeDialog(Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
    }

    public LikeDialog(Fragment fragment) {
        super(fragment, DEFAULT_REQUEST_CODE);
    }

    @Override // com.facebook.internal.FacebookDialogBase
    protected AppCall createBaseAppCall() {
        return new AppCall(getRequestCode());
    }

    @Override // com.facebook.internal.FacebookDialogBase
    protected List<FacebookDialogBase<LikeContent, Result>.ModeHandler> getOrderedModeHandlers() {
        r rVar = null;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a(this, rVar));
        arrayList.add(new b(this, rVar));
        return arrayList;
    }

    @Override // com.facebook.internal.FacebookDialogBase
    protected void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, FacebookCallback<Result> facebookCallback) {
        callbackManagerImpl.registerCallback(getRequestCode(), new s(this, facebookCallback == null ? null : new r(this, facebookCallback, facebookCallback)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends FacebookDialogBase<LikeContent, Result>.ModeHandler {
        private a() {
            super();
        }

        /* synthetic */ a(LikeDialog likeDialog, r rVar) {
            this();
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean canShow(LikeContent likeContent) {
            return likeContent != null && LikeDialog.canShowNativeDialog();
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AppCall createAppCall(LikeContent likeContent) {
            AppCall createBaseAppCall = LikeDialog.this.createBaseAppCall();
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new t(this, likeContent), LikeDialog.access$300());
            return createBaseAppCall;
        }
    }

    /* loaded from: classes.dex */
    private class b extends FacebookDialogBase<LikeContent, Result>.ModeHandler {
        private b() {
            super();
        }

        /* synthetic */ b(LikeDialog likeDialog, r rVar) {
            this();
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean canShow(LikeContent likeContent) {
            return likeContent != null && LikeDialog.canShowWebFallback();
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AppCall createAppCall(LikeContent likeContent) {
            AppCall createBaseAppCall = LikeDialog.this.createBaseAppCall();
            DialogPresenter.setupAppCallForWebFallbackDialog(createBaseAppCall, LikeDialog.createParameters(likeContent), LikeDialog.access$300());
            return createBaseAppCall;
        }
    }

    private static DialogFeature getFeature() {
        return LikeDialogFeature.LIKE_DIALOG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bundle createParameters(LikeContent likeContent) {
        Bundle bundle = new Bundle();
        bundle.putString("object_id", likeContent.getObjectId());
        bundle.putString("object_type", likeContent.getObjectType());
        return bundle;
    }
}
