package com.firebase.ui.auth.util;

import com.firebase.ui.auth.ui.FlowParameters;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.firebase.ui.auth.util.signincontainer.SaveSmartLock;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthProvider;

/* loaded from: classes.dex */
public class AuthHelper {
    private final FlowParameters mFlowParams;

    public AuthHelper(FlowParameters flowParameters) {
        this.mFlowParams = flowParameters;
    }

    public CredentialsApi getCredentialsApi() {
        return Auth.i;
    }

    public FirebaseUser getCurrentUser() {
        return getFirebaseAuth().a();
    }

    public FirebaseAuth getFirebaseAuth() {
        return FirebaseAuth.getInstance(FirebaseApp.a(this.mFlowParams.appName));
    }

    public PhoneAuthProvider getPhoneAuthProvider() {
        return PhoneAuthProvider.a(getFirebaseAuth());
    }

    public SaveSmartLock getSaveSmartLockInstance(HelperActivityBase helperActivityBase) {
        return SaveSmartLock.getInstance(helperActivityBase);
    }
}
