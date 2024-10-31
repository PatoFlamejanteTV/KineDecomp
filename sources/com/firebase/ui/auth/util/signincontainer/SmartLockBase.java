package com.firebase.ui.auth.util.signincontainer;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.widget.Toast;
import com.facebook.places.model.PlaceFields;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ui.FragmentBase;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class SmartLockBase<T extends Result> extends FragmentBase implements GoogleApiClient.ConnectionCallbacks, ResultCallback<T>, GoogleApiClient.OnConnectionFailedListener {
    private static final String TAG = "SmartLockBase";
    private Pair<Integer, Intent> mActivityResultPair;
    protected GoogleApiClient mGoogleApiClient;
    private boolean mWasProgressDialogShowing;

    public static String accountTypeToProviderId(String str) {
        char c2;
        int hashCode = str.hashCode();
        if (hashCode == -376862683) {
            if (str.equals("https://accounts.google.com")) {
                c2 = 0;
            }
            c2 = 65535;
        } else if (hashCode != 746549591) {
            if (hashCode == 1721158175 && str.equals("https://www.facebook.com")) {
                c2 = 1;
            }
            c2 = 65535;
        } else {
            if (str.equals("https://twitter.com")) {
                c2 = 2;
            }
            c2 = 65535;
        }
        if (c2 == 0) {
            return "google.com";
        }
        if (c2 == 1) {
            return "facebook.com";
        }
        if (c2 != 2) {
            return null;
        }
        return "twitter.com";
    }

    public static List<Credential> credentialsFromFirebaseUser(FirebaseUser firebaseUser) {
        if (TextUtils.isEmpty(firebaseUser.getEmail())) {
            Log.w(TAG, "Can't get credentials from user with no email: " + firebaseUser);
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<? extends UserInfo> it = firebaseUser.P().iterator();
        while (it.hasNext()) {
            String providerIdToAccountType = providerIdToAccountType(it.next().getProviderId());
            Credential.Builder a2 = new Credential.Builder(firebaseUser.getEmail()).a(providerIdToAccountType);
            if (providerIdToAccountType == null) {
                a2.c("some_password");
            }
            arrayList.add(a2.a());
        }
        return arrayList;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String providerIdToAccountType(String str) {
        char c2;
        switch (str.hashCode()) {
            case -1830313082:
                if (str.equals("twitter.com")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -1536293812:
                if (str.equals("google.com")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -364826023:
                if (str.equals("facebook.com")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 106642798:
                if (str.equals(PlaceFields.PHONE)) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1216985755:
                if (str.equals(AuthUI.EMAIL_PROVIDER)) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 == 0) {
            return "https://accounts.google.com";
        }
        if (c2 == 1) {
            return "https://www.facebook.com";
        }
        if (c2 == 2) {
            return "https://twitter.com";
        }
        if (c2 == 3 || c2 != 4) {
        }
        return null;
    }

    @Override // com.firebase.ui.auth.ui.FragmentBase
    public void finish(int i, Intent intent) {
        if (getActivity() == null) {
            this.mActivityResultPair = new Pair<>(Integer.valueOf(i), intent);
        } else {
            super.finish(i, intent);
        }
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        Toast.makeText(getContext(), R.string.general_error, 0).show();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnectionSuspended(int i) {
    }

    @Override // com.firebase.ui.auth.ui.FragmentBase, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    @Override // com.firebase.ui.auth.ui.FragmentBase, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        GoogleApiClient googleApiClient = this.mGoogleApiClient;
        if (googleApiClient != null) {
            googleApiClient.d();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        Pair<Integer, Intent> pair = this.mActivityResultPair;
        if (pair != null) {
            finish(((Integer) pair.first).intValue(), (Intent) this.mActivityResultPair.second);
        } else if (this.mWasProgressDialogShowing) {
            getDialogHolder().showLoadingDialog(R.string.progress_dialog_loading);
            this.mWasProgressDialogShowing = false;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.mWasProgressDialogShowing = getDialogHolder().isProgressDialogShowing();
        getDialogHolder().dismissDialog();
    }
}
