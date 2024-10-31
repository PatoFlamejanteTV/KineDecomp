package com.firebase.ui.auth;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import com.firebase.ui.auth.ui.ExtraConstants;
import com.firebase.ui.auth.ui.FlowParameters;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.firebase.ui.auth.util.PlayServicesHelper;
import com.firebase.ui.auth.util.signincontainer.SignInDelegate;
import com.nexstreaming.kinemaster.usage.analytics.b;

/* loaded from: classes.dex */
public class KickoffActivity extends HelperActivityBase {
    private static final String IS_WAITING_FOR_PLAY_SERVICES = "is_waiting_for_play_services";
    private static final int RC_PLAY_SERVICES = 1;
    private static final String TAG = "KickoffActivity";
    private boolean mIsWaitingForPlayServices = false;

    public static Intent createIntent(Context context, FlowParameters flowParameters) {
        return HelperActivityBase.createBaseIntent(context, KickoffActivity.class, flowParameters);
    }

    private boolean isOffline() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
        return connectivityManager == null || connectivityManager.getActiveNetworkInfo() == null || !connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();
    }

    private void start() {
        SignInDelegate.delegate(this, getFlowParams());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            if (i2 == -1) {
                start();
                return;
            } else {
                finish(0, IdpResponse.getErrorCodeIntent(20));
                return;
            }
        }
        SignInDelegate signInDelegate = SignInDelegate.getInstance(this);
        if (signInDelegate != null) {
            signInDelegate.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.firebase.ui.auth.ui.HelperActivityBase, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        b.a(getLocalClassName());
        super.onCreate(bundle);
        if (bundle == null || bundle.getBoolean(IS_WAITING_FOR_PLAY_SERVICES)) {
            if (isOffline()) {
                Log.d(TAG, "No network connection");
                finish(0, IdpResponse.getErrorCodeIntent(10));
            } else if (PlayServicesHelper.makePlayServicesAvailable(this, 1, new DialogInterface.OnCancelListener() { // from class: com.firebase.ui.auth.KickoffActivity.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    KickoffActivity.this.finish(0, IdpResponse.getErrorCodeIntent(20));
                }
            })) {
                start();
            } else {
                this.mIsWaitingForPlayServices = true;
            }
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(ExtraConstants.HAS_EXISTING_INSTANCE, true);
        bundle.putBoolean(IS_WAITING_FOR_PLAY_SERVICES, this.mIsWaitingForPlayServices);
        super.onSaveInstanceState(bundle);
    }
}
