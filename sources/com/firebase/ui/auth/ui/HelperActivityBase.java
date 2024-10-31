package com.firebase.ui.auth.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.util.AuthHelper;
import com.firebase.ui.auth.util.Preconditions;
import com.firebase.ui.auth.util.signincontainer.SaveSmartLock;
import com.google.firebase.auth.FirebaseUser;

/* loaded from: classes.dex */
public class HelperActivityBase extends AppCompatActivity {
    private static final String TAG = "HelperActivityBase";
    private AuthHelper mAuthHelper;
    private FlowParameters mFlowParameters;
    private ProgressDialogHolder mProgressDialogHolder;

    public static Intent createBaseIntent(Context context, Class<? extends Activity> cls, FlowParameters flowParameters) {
        Preconditions.checkNotNull(context, "context cannot be null", new Object[0]);
        Preconditions.checkNotNull(cls, "target activity cannot be null", new Object[0]);
        Intent intent = new Intent(context, cls);
        Preconditions.checkNotNull(flowParameters, "flowParams cannot be null", new Object[0]);
        return intent.putExtra(ExtraConstants.EXTRA_FLOW_PARAMS, flowParameters);
    }

    public void finish(int i, Intent intent) {
        setResult(i, intent);
        finish();
    }

    public AuthHelper getAuthHelper() {
        return this.mAuthHelper;
    }

    public ProgressDialogHolder getDialogHolder() {
        return this.mProgressDialogHolder;
    }

    public FlowParameters getFlowParams() {
        if (this.mFlowParameters == null) {
            this.mFlowParameters = FlowParameters.fromIntent(getIntent());
        }
        return this.mFlowParameters;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAuthHelper = new AuthHelper(getFlowParams());
        this.mProgressDialogHolder = new ProgressDialogHolder(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mProgressDialogHolder.dismissDialog();
    }

    public void saveCredentialsOrFinish(SaveSmartLock saveSmartLock, FirebaseUser firebaseUser, IdpResponse idpResponse) {
        saveCredentialsOrFinish(saveSmartLock, firebaseUser, null, idpResponse);
    }

    public void saveCredentialsOrFinish(SaveSmartLock saveSmartLock, FirebaseUser firebaseUser, String str, IdpResponse idpResponse) {
        if (saveSmartLock == null) {
            finish(-1, idpResponse.toIntent());
        } else {
            saveSmartLock.saveCredentialsOrFinish(firebaseUser, str, idpResponse);
        }
    }
}
