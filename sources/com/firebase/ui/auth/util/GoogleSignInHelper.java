package com.firebase.ui.auth.util;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.firebase.ui.auth.util.GoogleApiHelper;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public class GoogleSignInHelper extends GoogleApiHelper {
    private GoogleSignInHelper(FragmentActivity fragmentActivity, GoogleApiClient.Builder builder) {
        super(fragmentActivity, builder);
    }

    public static GoogleSignInHelper getInstance(FragmentActivity fragmentActivity) {
        return new GoogleSignInHelper(fragmentActivity, new GoogleApiClient.Builder(fragmentActivity).a(Auth.f10422f).a(Auth.f10423g, GoogleSignInOptions.f10565f));
    }

    public Task<Status> delete(final Credential credential) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        getConnectedApiTask().a(new GoogleApiHelper.ExceptionForwarder(taskCompletionSource, new OnSuccessListener<Bundle>() { // from class: com.firebase.ui.auth.util.GoogleSignInHelper.3
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public void onSuccess(Bundle bundle) {
                Auth.i.delete(GoogleSignInHelper.this.mClient, credential).a(new GoogleApiHelper.TaskResultCaptor(taskCompletionSource));
            }
        }));
        return taskCompletionSource.a();
    }

    public Task<Status> disableAutoSignIn() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        getConnectedApiTask().a(new GoogleApiHelper.ExceptionForwarder(taskCompletionSource, new OnSuccessListener<Bundle>() { // from class: com.firebase.ui.auth.util.GoogleSignInHelper.2
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public void onSuccess(Bundle bundle) {
                Auth.i.disableAutoSignIn(GoogleSignInHelper.this.mClient).a(new GoogleApiHelper.TaskResultCaptor(taskCompletionSource));
            }
        }));
        return taskCompletionSource.a();
    }

    public Task<Status> signOut() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        getConnectedApiTask().a(new GoogleApiHelper.ExceptionForwarder(taskCompletionSource, new OnSuccessListener<Bundle>() { // from class: com.firebase.ui.auth.util.GoogleSignInHelper.1
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public void onSuccess(Bundle bundle) {
                Auth.j.b(GoogleSignInHelper.this.mClient).a(new GoogleApiHelper.TaskResultCaptor(taskCompletionSource));
            }
        }));
        return taskCompletionSource.a();
    }
}
