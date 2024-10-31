package com.firebase.ui.auth.util.signincontainer;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.Log;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.User;
import com.firebase.ui.auth.ui.ExtraConstants;
import com.firebase.ui.auth.ui.FlowParameters;
import com.firebase.ui.auth.ui.TaskFailureLogger;
import com.firebase.ui.auth.ui.email.RegisterEmailActivity;
import com.firebase.ui.auth.util.GoogleApiHelper;
import com.firebase.ui.auth.util.GoogleSignInHelper;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class SignInDelegate extends SmartLockBase<CredentialRequestResult> {
    private static final int RC_AUTH_METHOD_PICKER = 4;
    private static final int RC_CREDENTIALS_READ = 2;
    private static final int RC_EMAIL_FLOW = 5;
    private static final int RC_IDP_SIGNIN = 3;
    private static final int RC_PHONE_FLOW = 6;
    private static final String TAG = "SignInDelegate";
    private Credential mCredential;

    public static void delegate(FragmentActivity fragmentActivity, FlowParameters flowParameters) {
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        if (supportFragmentManager.findFragmentByTag(TAG) instanceof SignInDelegate) {
            return;
        }
        SignInDelegate signInDelegate = new SignInDelegate();
        signInDelegate.setArguments(flowParameters.toBundle());
        supportFragmentManager.beginTransaction().add(signInDelegate, TAG).disallowAddToBackStack().commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteCredentialAndRedirect() {
        if (this.mCredential == null) {
            Log.w(TAG, "deleteCredentialAndRedirect: null credential");
            startAuthMethodChoice();
        } else {
            GoogleSignInHelper.getInstance(getActivity()).delete(this.mCredential).a(new OnCompleteListener<Status>() { // from class: com.firebase.ui.auth.util.signincontainer.SignInDelegate.3
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public void onComplete(Task<Status> task) {
                    if (!task.e()) {
                        Log.w(SignInDelegate.TAG, "deleteCredential:failure", task.a());
                    }
                    SignInDelegate.this.startAuthMethodChoice();
                }
            });
        }
    }

    private String getAccountTypeFromCredential() {
        Credential credential = this.mCredential;
        if (credential == null) {
            return null;
        }
        return credential.a();
    }

    private String getEmailFromCredential() {
        Credential credential = this.mCredential;
        if (credential == null) {
            return null;
        }
        return credential.getId();
    }

    public static SignInDelegate getInstance(FragmentActivity fragmentActivity) {
        Fragment findFragmentByTag = fragmentActivity.getSupportFragmentManager().findFragmentByTag(TAG);
        if (findFragmentByTag instanceof SignInDelegate) {
            return (SignInDelegate) findFragmentByTag;
        }
        return null;
    }

    private String getPasswordFromCredential() {
        Credential credential = this.mCredential;
        if (credential == null) {
            return null;
        }
        return credential.getPassword();
    }

    private List<String> getSupportedAccountTypes() {
        ArrayList arrayList = new ArrayList();
        Iterator<AuthUI.IdpConfig> it = getFlowParams().providerInfo.iterator();
        while (it.hasNext()) {
            String providerId = it.next().getProviderId();
            if (providerId.equals("google.com") || providerId.equals("facebook.com") || providerId.equals("twitter.com")) {
                arrayList.add(SmartLockBase.providerIdToAccountType(providerId));
            }
        }
        return arrayList;
    }

    private void handleCredential(Credential credential) {
        this.mCredential = credential;
        String emailFromCredential = getEmailFromCredential();
        String passwordFromCredential = getPasswordFromCredential();
        if (TextUtils.isEmpty(emailFromCredential)) {
            return;
        }
        if (TextUtils.isEmpty(passwordFromCredential)) {
            redirectToIdpSignIn(emailFromCredential, getAccountTypeFromCredential());
        } else {
            signInWithEmailAndPassword(emailFromCredential, passwordFromCredential);
        }
    }

    private void redirectToIdpSignIn(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            startActivityForResult(RegisterEmailActivity.createIntent(getContext(), getFlowParams(), str), 5);
        } else {
            getDialogHolder().dismissDialog();
        }
    }

    private void signInWithEmailAndPassword(String str, String str2) {
        final IdpResponse build = new IdpResponse.Builder(new User.Builder(AuthUI.EMAIL_PROVIDER, str).build()).build();
        getAuthHelper().getFirebaseAuth().b(str, str2).a(new OnSuccessListener<AuthResult>() { // from class: com.firebase.ui.auth.util.signincontainer.SignInDelegate.2
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public void onSuccess(AuthResult authResult) {
                SignInDelegate.this.finish(-1, build.toIntent());
            }
        }).a(new TaskFailureLogger(TAG, "Error signing in with email and password")).a(new OnFailureListener() { // from class: com.firebase.ui.auth.util.signincontainer.SignInDelegate.1
            @Override // com.google.android.gms.tasks.OnFailureListener
            public void onFailure(Exception exc) {
                if ((exc instanceof FirebaseAuthInvalidUserException) || (exc instanceof FirebaseAuthInvalidCredentialsException)) {
                    SignInDelegate.this.deleteCredentialAndRedirect();
                } else {
                    SignInDelegate.this.startAuthMethodChoice();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAuthMethodChoice() {
        FlowParameters flowParams = getFlowParams();
        List<AuthUI.IdpConfig> list = flowParams.providerInfo;
        if (list.size() == 1) {
            String providerId = list.get(0).getProviderId();
            if (((providerId.hashCode() == 1216985755 && providerId.equals(AuthUI.EMAIL_PROVIDER)) ? (char) 0 : (char) 65535) != 0) {
                redirectToIdpSignIn(null, SmartLockBase.providerIdToAccountType(providerId));
            } else {
                startActivityForResult(RegisterEmailActivity.createIntent(getContext(), flowParams), 5);
            }
            getDialogHolder().dismissDialog();
            return;
        }
        throw new UnsupportedOperationException();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 2) {
            if (i2 == -1) {
                handleCredential((Credential) intent.getParcelableExtra("com.google.android.gms.credentials.Credential"));
                return;
            } else {
                startAuthMethodChoice();
                return;
            }
        }
        if (i == 3 || i == 4 || i == 5 || i == 6) {
            finish(i2, intent);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnected(Bundle bundle) {
    }

    @Override // com.firebase.ui.auth.util.signincontainer.SmartLockBase, com.firebase.ui.auth.ui.FragmentBase, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            return;
        }
        if (getFlowParams().enableCredentials) {
            getDialogHolder().showLoadingDialog(R.string.progress_dialog_loading);
            this.mGoogleApiClient = new GoogleApiClient.Builder(getContext().getApplicationContext()).a((GoogleApiClient.ConnectionCallbacks) this).a(Auth.f10422f).a(getActivity(), GoogleApiHelper.getSafeAutoManageId(), this).a();
            this.mGoogleApiClient.c();
            getAuthHelper().getCredentialsApi().request(this.mGoogleApiClient, new CredentialRequest.Builder().a(true).a((String[]) getSupportedAccountTypes().toArray(new String[0])).a()).a(this);
            return;
        }
        startAuthMethodChoice();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(ExtraConstants.HAS_EXISTING_INSTANCE, true);
        super.onSaveInstanceState(bundle);
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public void onResult(CredentialRequestResult credentialRequestResult) {
        Status status = credentialRequestResult.getStatus();
        if (status.Q()) {
            handleCredential(credentialRequestResult.getCredential());
            return;
        }
        if (status.P()) {
            try {
                if (status.getStatusCode() == 6) {
                    startIntentSenderForResult(status.a().getIntentSender(), 2);
                    return;
                }
            } catch (IntentSender.SendIntentException e2) {
                Log.e(TAG, "Failed to send Credentials intent.", e2);
            }
        } else {
            Log.e(TAG, "Status message:\n" + status.O());
        }
        startAuthMethodChoice();
    }
}
