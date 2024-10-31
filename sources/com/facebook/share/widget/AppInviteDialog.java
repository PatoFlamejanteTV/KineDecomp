package com.facebook.share.widget;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.share.internal.AppInviteDialogFeature;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.model.AppInviteContent;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class AppInviteDialog extends FacebookDialogBase<AppInviteContent, Result> {
    private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.AppInvite.toRequestCode();
    private static final String TAG = "AppInviteDialog";

    static /* synthetic */ boolean access$200() {
        return canShowNativeDialog();
    }

    static /* synthetic */ DialogFeature access$400() {
        return getFeature();
    }

    static /* synthetic */ boolean access$500() {
        return canShowWebFallback();
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

    public static boolean canShow() {
        return canShowNativeDialog() || canShowWebFallback();
    }

    public static void show(Activity activity, AppInviteContent appInviteContent) {
        new AppInviteDialog(activity).show(appInviteContent);
    }

    public static void show(Fragment fragment, AppInviteContent appInviteContent) {
        new AppInviteDialog(fragment).show(appInviteContent);
    }

    private static boolean canShowNativeDialog() {
        return DialogPresenter.canPresentNativeDialogWithFeature(getFeature());
    }

    private static boolean canShowWebFallback() {
        return DialogPresenter.canPresentWebFallbackDialogWithFeature(getFeature());
    }

    public AppInviteDialog(Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
    }

    public AppInviteDialog(Fragment fragment) {
        super(fragment, DEFAULT_REQUEST_CODE);
    }

    @Override // com.facebook.internal.FacebookDialogBase
    protected void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, FacebookCallback<Result> facebookCallback) {
        callbackManagerImpl.registerCallback(getRequestCode(), new com.facebook.share.widget.b(this, facebookCallback == null ? null : new com.facebook.share.widget.a(this, facebookCallback, facebookCallback)));
    }

    @Override // com.facebook.internal.FacebookDialogBase
    protected AppCall createBaseAppCall() {
        return new AppCall(getRequestCode());
    }

    @Override // com.facebook.internal.FacebookDialogBase
    protected List<FacebookDialogBase<AppInviteContent, Result>.ModeHandler> getOrderedModeHandlers() {
        com.facebook.share.widget.a aVar = null;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a(this, aVar));
        arrayList.add(new b(this, aVar));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends FacebookDialogBase<AppInviteContent, Result>.ModeHandler {
        private a() {
            super();
        }

        /* synthetic */ a(AppInviteDialog appInviteDialog, com.facebook.share.widget.a aVar) {
            this();
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean canShow(AppInviteContent appInviteContent) {
            return AppInviteDialog.access$200();
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AppCall createAppCall(AppInviteContent appInviteContent) {
            AppCall createBaseAppCall = AppInviteDialog.this.createBaseAppCall();
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new c(this, appInviteContent), AppInviteDialog.access$400());
            return createBaseAppCall;
        }
    }

    /* loaded from: classes.dex */
    private class b extends FacebookDialogBase<AppInviteContent, Result>.ModeHandler {
        private b() {
            super();
        }

        /* synthetic */ b(AppInviteDialog appInviteDialog, com.facebook.share.widget.a aVar) {
            this();
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean canShow(AppInviteContent appInviteContent) {
            return AppInviteDialog.access$500();
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AppCall createAppCall(AppInviteContent appInviteContent) {
            AppCall createBaseAppCall = AppInviteDialog.this.createBaseAppCall();
            DialogPresenter.setupAppCallForWebFallbackDialog(createBaseAppCall, AppInviteDialog.createParameters(appInviteContent), AppInviteDialog.access$400());
            return createBaseAppCall;
        }
    }

    private static DialogFeature getFeature() {
        return AppInviteDialogFeature.APP_INVITES_DIALOG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bundle createParameters(AppInviteContent appInviteContent) {
        Bundle bundle = new Bundle();
        bundle.putString(ShareConstants.APPLINK_URL, appInviteContent.getApplinkUrl());
        bundle.putString(ShareConstants.PREVIEW_IMAGE_URL, appInviteContent.getPreviewImageUrl());
        return bundle;
    }
}
