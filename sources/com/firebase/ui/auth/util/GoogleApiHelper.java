package com.firebase.ui.auth.util;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.net.ConnectException;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class GoogleApiHelper implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private static final AtomicInteger SAFE_ID = new AtomicInteger(10);
    protected GoogleApiClient mClient;
    private TaskCompletionSource<Bundle> mGoogleApiConnectionTask = new TaskCompletionSource<>();

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class ExceptionForwarder<TResult> implements OnCompleteListener<TResult> {
        private OnSuccessListener<TResult> mListener;
        private TaskCompletionSource mSource;

        public ExceptionForwarder(TaskCompletionSource taskCompletionSource, OnSuccessListener<TResult> onSuccessListener) {
            this.mSource = taskCompletionSource;
            this.mListener = onSuccessListener;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public void onComplete(Task<TResult> task) {
            if (task.e()) {
                this.mListener.onSuccess(task.b());
            } else {
                this.mSource.a(task.a());
            }
        }
    }

    /* loaded from: classes.dex */
    protected static final class TaskResultCaptor<R extends Result> implements ResultCallback<R> {
        private TaskCompletionSource<R> mSource;

        public TaskResultCaptor(TaskCompletionSource<R> taskCompletionSource) {
            this.mSource = taskCompletionSource;
        }

        @Override // com.google.android.gms.common.api.ResultCallback
        public void onResult(R r) {
            this.mSource.a((TaskCompletionSource<R>) r);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GoogleApiHelper(FragmentActivity fragmentActivity, GoogleApiClient.Builder builder) {
        builder.a(fragmentActivity, getSafeAutoManageId(), this);
        builder.a((GoogleApiClient.ConnectionCallbacks) this);
        this.mClient = builder.a();
    }

    public static int getSafeAutoManageId() {
        return SAFE_ID.getAndIncrement();
    }

    public Task<Bundle> getConnectedApiTask() {
        return this.mGoogleApiConnectionTask.a();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnected(Bundle bundle) {
        this.mGoogleApiConnectionTask.b((TaskCompletionSource<Bundle>) bundle);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.mGoogleApiConnectionTask.b(new ConnectException(connectionResult.toString()));
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnectionSuspended(int i) {
    }
}
