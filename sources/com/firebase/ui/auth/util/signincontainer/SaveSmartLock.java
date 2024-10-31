package com.firebase.ui.auth.util.signincontainer;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.firebase.ui.auth.util.GoogleApiHelper;
import com.firebase.ui.auth.util.PlayServicesHelper;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseUser;
import com.nexstreaming.app.kinemasterfree.R;

/* loaded from: classes.dex */
public class SaveSmartLock extends SmartLockBase<Status> {
    private static final int RC_SAVE = 100;
    private static final int RC_UPDATE_SERVICE = 28;
    private static final String TAG = "SaveSmartLock";
    private Context mAppContext;
    private String mEmail;
    private String mName;
    private String mPassword;
    private String mProfilePictureUri;
    private IdpResponse mResponse;

    private void finish() {
        finish(-1, this.mResponse.toIntent());
    }

    public static SaveSmartLock getInstance(HelperActivityBase helperActivityBase) {
        FragmentManager supportFragmentManager = helperActivityBase.getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(TAG);
        if (!(findFragmentByTag instanceof SaveSmartLock)) {
            SaveSmartLock saveSmartLock = new SaveSmartLock();
            saveSmartLock.setArguments(helperActivityBase.getFlowParams().toBundle());
            try {
                supportFragmentManager.beginTransaction().add(saveSmartLock, TAG).disallowAddToBackStack().commit();
                return saveSmartLock;
            } catch (IllegalStateException e2) {
                Log.e(TAG, "Cannot add fragment", e2);
                return null;
            }
        }
        return (SaveSmartLock) findFragmentByTag;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (i2 != -1) {
                Log.e(TAG, "SAVE: Canceled by user");
            }
            finish();
        } else if (i == 28) {
            if (i2 == -1) {
                getAuthHelper().getCredentialsApi().save(this.mGoogleApiClient, new Credential.Builder(this.mEmail).c(this.mPassword).a()).a(this);
            } else {
                Log.e(TAG, "SAVE: Canceled by user");
                finish();
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mAppContext = context.getApplicationContext();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnected(Bundle bundle) {
        IdpResponse idpResponse;
        if (TextUtils.isEmpty(this.mEmail)) {
            Log.e(TAG, "Unable to save null credential!");
            finish();
            return;
        }
        Credential.Builder builder = new Credential.Builder(this.mEmail);
        builder.c(this.mPassword);
        if (this.mPassword == null && (idpResponse = this.mResponse) != null) {
            String providerIdToAccountType = SmartLockBase.providerIdToAccountType(idpResponse.getProviderType());
            if (providerIdToAccountType != null) {
                builder.a(providerIdToAccountType);
            } else {
                Log.e(TAG, "Unable to save null credential!");
                finish();
                return;
            }
        }
        String str = this.mName;
        if (str != null) {
            builder.b(str);
        }
        String str2 = this.mProfilePictureUri;
        if (str2 != null) {
            builder.a(Uri.parse(str2));
        }
        getAuthHelper().getCredentialsApi().save(this.mGoogleApiClient, builder.a()).a(this);
    }

    @Override // com.firebase.ui.auth.util.signincontainer.SmartLockBase, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Toast.makeText(getContext(), R.string.general_error, 0).show();
        try {
            startIntentSenderForResult(PlayServicesHelper.getGoogleApiAvailability().a(getContext(), connectionResult.a(), 28).getIntentSender(), 28);
        } catch (IntentSender.SendIntentException e2) {
            Log.e(TAG, "STATUS: Failed to send resolution.", e2);
            finish();
        }
    }

    public void saveCredentialsOrFinish(FirebaseUser firebaseUser, String str, IdpResponse idpResponse) {
        this.mResponse = idpResponse;
        if (!getFlowParams().enableCredentials) {
            finish();
            return;
        }
        this.mName = firebaseUser.getDisplayName();
        this.mEmail = firebaseUser.getEmail();
        this.mPassword = str;
        this.mProfilePictureUri = firebaseUser.O() != null ? firebaseUser.O().toString() : null;
        this.mGoogleApiClient = new GoogleApiClient.Builder(this.mAppContext).a((GoogleApiClient.ConnectionCallbacks) this).a((GoogleApiClient.OnConnectionFailedListener) this).a(Auth.f10422f).a(getActivity(), GoogleApiHelper.getSafeAutoManageId(), this).a();
        this.mGoogleApiClient.c();
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public void onResult(Status status) {
        if (status.Q()) {
            finish();
            return;
        }
        if (status.P()) {
            try {
                startIntentSenderForResult(status.a().getIntentSender(), 100);
                return;
            } catch (IntentSender.SendIntentException e2) {
                Log.e(TAG, "STATUS: Failed to send resolution.", e2);
                finish();
                return;
            }
        }
        Log.w(TAG, "Status message:\n" + status.O());
        finish();
    }
}
