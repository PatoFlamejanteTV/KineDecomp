package com.facebook.share.widget;

import android.app.Activity;
import android.support.v4.app.Fragment;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.share.internal.WebDialogParameters;
import com.facebook.share.model.AppGroupCreationContent;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class CreateAppGroupDialog extends FacebookDialogBase<AppGroupCreationContent, Result> {
    private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.AppGroupCreate.toRequestCode();
    private static final String GAME_GROUP_CREATION_DIALOG = "game_group_create";

    /* loaded from: classes.dex */
    public static final class Result {
        private final String id;

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ Result(String str, d dVar) {
            this(str);
        }

        private Result(String str) {
            this.id = str;
        }

        public String getId() {
            return this.id;
        }
    }

    public static boolean canShow() {
        return true;
    }

    public static void show(Activity activity, AppGroupCreationContent appGroupCreationContent) {
        new CreateAppGroupDialog(activity).show(appGroupCreationContent);
    }

    public static void show(Fragment fragment, AppGroupCreationContent appGroupCreationContent) {
        new CreateAppGroupDialog(fragment).show(appGroupCreationContent);
    }

    public CreateAppGroupDialog(Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
    }

    public CreateAppGroupDialog(Fragment fragment) {
        super(fragment, DEFAULT_REQUEST_CODE);
    }

    @Override // com.facebook.internal.FacebookDialogBase
    protected void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, FacebookCallback<Result> facebookCallback) {
        callbackManagerImpl.registerCallback(getRequestCode(), new e(this, facebookCallback == null ? null : new d(this, facebookCallback, facebookCallback)));
    }

    @Override // com.facebook.internal.FacebookDialogBase
    protected AppCall createBaseAppCall() {
        return new AppCall(getRequestCode());
    }

    @Override // com.facebook.internal.FacebookDialogBase
    protected List<FacebookDialogBase<AppGroupCreationContent, Result>.ModeHandler> getOrderedModeHandlers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a(this, null));
        return arrayList;
    }

    /* loaded from: classes.dex */
    private class a extends FacebookDialogBase<AppGroupCreationContent, Result>.ModeHandler {
        private a() {
            super();
        }

        /* synthetic */ a(CreateAppGroupDialog createAppGroupDialog, d dVar) {
            this();
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean canShow(AppGroupCreationContent appGroupCreationContent) {
            return true;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AppCall createAppCall(AppGroupCreationContent appGroupCreationContent) {
            AppCall createBaseAppCall = CreateAppGroupDialog.this.createBaseAppCall();
            DialogPresenter.setupAppCallForWebDialog(createBaseAppCall, CreateAppGroupDialog.GAME_GROUP_CREATION_DIALOG, WebDialogParameters.create(appGroupCreationContent));
            return createBaseAppCall;
        }
    }
}
