package com.facebook;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.NativeProtocol;
import com.facebook.login.LoginFragment;

/* loaded from: classes.dex */
public class FacebookActivity extends android.support.v4.app.l {
    private Fragment singleFragment;
    public static String PASS_THROUGH_CANCEL_ACTION = "PassThrough";
    private static String FRAGMENT_TAG = "SingleFragment";

    @Override // android.support.v4.app.l, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.com_facebook_activity_layout);
        Intent intent = getIntent();
        if (PASS_THROUGH_CANCEL_ACTION.equals(intent.getAction())) {
            handlePassThroughError();
            return;
        }
        android.support.v4.app.p supportFragmentManager = getSupportFragmentManager();
        Fragment a2 = supportFragmentManager.a(FRAGMENT_TAG);
        Fragment fragment = a2;
        if (a2 == null) {
            if (FacebookDialogFragment.TAG.equals(intent.getAction())) {
                FacebookDialogFragment facebookDialogFragment = new FacebookDialogFragment();
                facebookDialogFragment.setRetainInstance(true);
                facebookDialogFragment.show(supportFragmentManager, FRAGMENT_TAG);
                fragment = facebookDialogFragment;
            } else {
                LoginFragment loginFragment = new LoginFragment();
                loginFragment.setRetainInstance(true);
                supportFragmentManager.a().a(R.id.com_facebook_fragment_container, loginFragment, FRAGMENT_TAG).a();
                fragment = loginFragment;
            }
        }
        this.singleFragment = fragment;
    }

    @Override // android.support.v4.app.l, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.singleFragment != null) {
            this.singleFragment.onConfigurationChanged(configuration);
        }
    }

    private void handlePassThroughError() {
        Intent intent = getIntent();
        setResult(0, NativeProtocol.createProtocolResultIntent(intent, null, NativeProtocol.getExceptionFromErrorData(NativeProtocol.getMethodArgumentsFromIntent(intent))));
        finish();
    }
}
