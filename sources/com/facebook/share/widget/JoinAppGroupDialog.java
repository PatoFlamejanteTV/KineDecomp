package com.facebook.share.widget;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.share.internal.ShareConstants;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class JoinAppGroupDialog extends FacebookDialogBase<String, Result> {
    private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.AppGroupJoin.toRequestCode();
    private static final String JOIN_GAME_GROUP_DIALOG = "game_group_join";

    /* loaded from: classes.dex */
    public static final class Result {
        private final Bundle data;

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ Result(Bundle bundle, h hVar) {
            this(bundle);
        }

        private Result(Bundle bundle) {
            this.data = bundle;
        }

        public Bundle getData() {
            return this.data;
        }
    }

    public static boolean canShow() {
        return true;
    }

    public static void show(Activity activity, String str) {
        new JoinAppGroupDialog(activity).show(str);
    }

    public static void show(Fragment fragment, String str) {
        new JoinAppGroupDialog(fragment).show(str);
    }

    public JoinAppGroupDialog(Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
    }

    public JoinAppGroupDialog(Fragment fragment) {
        super(fragment, DEFAULT_REQUEST_CODE);
    }

    @Override // com.facebook.internal.FacebookDialogBase
    protected void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, FacebookCallback<Result> facebookCallback) {
        callbackManagerImpl.registerCallback(getRequestCode(), new i(this, facebookCallback == null ? null : new h(this, facebookCallback, facebookCallback)));
    }

    @Override // com.facebook.internal.FacebookDialogBase
    protected AppCall createBaseAppCall() {
        return new AppCall(getRequestCode());
    }

    @Override // com.facebook.internal.FacebookDialogBase
    protected List<FacebookDialogBase<String, Result>.ModeHandler> getOrderedModeHandlers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a(this, null));
        return arrayList;
    }

    /* loaded from: classes.dex */
    private class a extends FacebookDialogBase<String, Result>.ModeHandler {
        private a() {
            super();
        }

        /* synthetic */ a(JoinAppGroupDialog joinAppGroupDialog, h hVar) {
            this();
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean canShow(String str) {
            return true;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AppCall createAppCall(String str) {
            AppCall createBaseAppCall = JoinAppGroupDialog.this.createBaseAppCall();
            Bundle bundle = new Bundle();
            bundle.putString(ShareConstants.WEB_DIALOG_PARAM_ID, str);
            DialogPresenter.setupAppCallForWebDialog(createBaseAppCall, JoinAppGroupDialog.JOIN_GAME_GROUP_DIALOG, bundle);
            return createBaseAppCall;
        }
    }
}
