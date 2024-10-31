package com.nexstreaming.sdk2.nexsns;

import android.accounts.Account;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.media.MediaHttpDownloader;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.sdk2.nexsns.SNS;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

/* loaded from: classes.dex */
public class GoogleDriveMediaDownload extends SNS implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, com.nexstreaming.sdk2.nexsns.a {
    private static final Executor m = Executors.newCachedThreadPool();
    private static Task.TaskError o = Task.makeTaskError("Authentication Pending");

    /* renamed from: a */
    List<File> f4407a;
    InputStream b;
    private Drive c;
    private final HttpTransport d;
    private final JsonFactory e;
    private aa f;
    private GoogleApiClient g;
    private Task h;
    private boolean i;
    private String j;
    private String k;
    private SynchronousQueue<a> l;
    private Activity n;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public static final a f4409a = new a(true, null);
        public final boolean b;
        public final Task.TaskError c;

        public static a a(Task.TaskError taskError) {
            return new a(false, taskError);
        }

        private a(boolean z, Task.TaskError taskError) {
            this.b = z;
            this.c = taskError;
        }
    }

    public GoogleDriveMediaDownload(Activity activity) {
        super(activity);
        this.c = null;
        this.d = AndroidHttp.a();
        this.e = AndroidJsonFactory.a();
        this.f = null;
        this.h = null;
        this.i = false;
        this.k = null;
        this.l = new SynchronousQueue<>();
        this.f4407a = new ArrayList();
        this.b = null;
        this.n = activity;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public boolean a() {
        return false;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public boolean b() {
        return false;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public boolean c() {
        return false;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public boolean d() {
        return false;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public int e() {
        throw new UnsupportedOperationException();
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public String a(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void b_(String str) {
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public ad a(java.io.File file) {
        throw new UnsupportedOperationException();
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public Task f() {
        if (this.h != null && (this.h.isRunning() || !this.h.didSignalEvent(Task.Event.FAIL))) {
            return this.h;
        }
        this.h = new Task();
        ab.a("GoogleDriveMediaDL", "authenticate : start : " + this.h);
        if (this.n == null) {
            ab.a("GoogleDriveMediaDL", "authenticate : activity is null : " + this.h);
            this.h.signalEvent(Task.Event.FAIL);
            return this.h;
        }
        if (this.g == null) {
            this.g = new GoogleApiClient.Builder(this.n, this, this).a(com.google.android.gms.drive.Drive.f).a(com.google.android.gms.drive.Drive.b).a(this.j).b();
            ab.a("GoogleDriveMediaDL", "new mGoogleApiClient :  " + this.g + " mAccountName : " + this.j);
        }
        if (this.g.isConnected()) {
            this.h.signalEvent(Task.Event.SUCCESS);
        } else if (!this.g.isConnecting()) {
            this.g.connect();
        }
        return this.h;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public SNS.PrivacyManagementProfile h() {
        return null;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public List<Privacy> i() {
        return null;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public ResultTask<List<ac>> j() {
        ResultTask<List<ac>> resultTask = new ResultTask<>();
        resultTask.sendResult(Collections.emptyList());
        return resultTask;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void a_(Bundle bundle) {
        boolean z = false;
        if (bundle != null && bundle.getBoolean("RESOLVING_ERROR", false)) {
            z = true;
        }
        this.i = z;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void k() {
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void l() {
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void m() {
        if (this.g != null) {
            this.g.disconnect();
        }
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void n() {
        this.n = null;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void o() {
        if (this.g != null) {
            this.g.connect();
        }
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void b(Bundle bundle) {
        bundle.putBoolean("RESOLVING_ERROR", this.i);
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void a(Activity activity, int i, int i2, Intent intent) {
        ab.a("GoogleDriveMediaDL", "onActivityResult");
        if (i == R.id.rqcode_gdrive_resolve_auth_err) {
            if (this.h == null) {
                this.h = new Task();
            }
            this.h.signalEvent(Task.Event.SUCCESS);
            ab.a("GoogleDriveMediaDL", "onActivityResult : R.id.rqcode_gdrive_resolve_auth_err : " + i2);
            if (i2 == -1) {
                this.l.offer(a.f4409a);
                return;
            } else {
                this.l.offer(a.a(Task.makeTaskError("Authentication failure " + i2)));
                return;
            }
        }
        if (i == R.id.rqcode_gdrive_resolve_connect_err) {
            ab.a("GoogleDriveMediaDL", "onActivityResult : R.id.rqcode_gdrive_resolve_connect_err : " + i2);
            if (i2 == -1) {
                if (this.g == null) {
                    if (this.h != null) {
                        this.h.sendFailure(SNS.SNSErrorCode.NullClient);
                        return;
                    }
                    return;
                } else {
                    if (!this.g.isConnecting() && !this.g.isConnected()) {
                        this.g.connect();
                        return;
                    }
                    return;
                }
            }
            SNS.SNSErrorCode sNSErrorCode = SNS.SNSErrorCode.WrongActivityResult;
            if (this.h != null) {
                this.h.sendFailure(sNSErrorCode);
            }
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public void a(ConnectionResult connectionResult) {
        Task.TaskError taskError;
        ab.a("GoogleDriveMediaDL", "onConnectionFailed mResolvingError=" + this.i);
        if (connectionResult.a() && !this.i) {
            ab.b("GoogleDriveMediaDL", String.format("Connection to Play Services Failed, error: %d, reason: %s", Integer.valueOf(connectionResult.c()), connectionResult.toString()));
            try {
                ab.a("GoogleDriveMediaDL", "onConnectionFailed try === startResolutionForResult");
                connectionResult.a(this.n, R.id.rqcode_gdrive_resolve_connect_err);
                this.i = true;
                return;
            } catch (IntentSender.SendIntentException e) {
                ab.a("GoogleDriveMediaDL", "onConnectionFailed catch === IntentSender.SendIntentException");
                ab.b("GoogleDriveMediaDL", "IntentSender.SendIntentException : " + e.toString(), e);
                Task.TaskError makeTaskError = Task.makeTaskError(e);
                if (this.h != null) {
                    this.h.sendFailure(makeTaskError);
                    return;
                }
                return;
            }
        }
        this.i = false;
        int c = connectionResult.c();
        switch (c) {
            case 4:
                taskError = SNS.SNSErrorCode.SignInRequired;
                break;
            case 7:
                taskError = SNS.SNSErrorCode.NetworkError;
                break;
            case 19:
                taskError = SNS.SNSErrorCode.NeedPermission;
                break;
            default:
                if (this.n != null) {
                    GooglePlayServicesUtil.a(c, this.n, 0).show();
                    taskError = SNS.SNSErrorCode.ServiceErrorPopupShown;
                    break;
                } else {
                    taskError = new SNS.a(c);
                    break;
                }
        }
        if (this.h != null) {
            this.h.sendFailure(taskError);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void a(Bundle bundle) {
        ab.a("GoogleDriveMediaDL", "Google Drive - onConnected");
        this.f = aa.a(this.n, Collections.singleton(DriveScopes.DRIVE));
        this.f.a(new ExponentialBackOff());
        if (this.g.isConnected()) {
            this.f.a(new Account(this.j, "com.google"));
            new g(this).executeOnExecutor(m, new Void[0]);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void a_(int i) {
        ab.a("GoogleDriveMediaDL", "onConnectionSuspended");
        this.h = null;
    }

    @Override // com.nexstreaming.sdk2.nexsns.a
    public ResultTask<List<File>> a(String str) {
        ResultTask<List<File>> resultTask = new ResultTask<>();
        f().onSuccess(new i(this, str, resultTask)).onFailure(new h(this, resultTask));
        return resultTask;
    }

    @Override // com.nexstreaming.sdk2.nexsns.a
    public ResultTask<File> b(String str) {
        ResultTask<File> resultTask = new ResultTask<>();
        f().onSuccess(new l(this, str, resultTask)).onFailure(new k(this, resultTask));
        return resultTask;
    }

    /* loaded from: classes.dex */
    public class DownloadCancelException extends RuntimeException {
        private static final long serialVersionUID = 1;

        public DownloadCancelException() {
        }

        public DownloadCancelException(String str, Throwable th) {
            super(str, th);
        }

        public DownloadCancelException(String str) {
            super(str);
        }

        public DownloadCancelException(Throwable th) {
            super(th);
        }
    }

    public void s() {
        if (this.c == null) {
            Drive.Builder builder = new Drive.Builder(this.d, this.e, this.f);
            builder.setApplicationName("KineMaster");
            this.c = builder.build();
        }
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void c(String str) {
    }

    @Override // com.nexstreaming.sdk2.nexsns.a
    public ResultTask<java.io.File> a(String str, String str2, String str3) {
        ab.a("GoogleDriveMediaDL", "getImageorVideo is called in NEXSNS_SDK!");
        String str4 = str3 + ".tmp";
        ResultTask<java.io.File> resultTask = new ResultTask<>();
        java.io.File file = new java.io.File(str3);
        java.io.File file2 = new java.io.File(str4);
        resultTask.setCancellable(true);
        if (file.exists()) {
            resultTask.sendResult(file);
        } else {
            f().onSuccess(new o(this, str4, str, resultTask, str2, file2, file)).onFailure(new n(this, file2, resultTask));
        }
        return resultTask;
    }

    /* renamed from: com.nexstreaming.sdk2.nexsns.GoogleDriveMediaDownload$1 */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f4408a = new int[MediaHttpDownloader.DownloadState.values().length];

        static {
            try {
                f4408a[MediaHttpDownloader.DownloadState.MEDIA_IN_PROGRESS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4408a[MediaHttpDownloader.DownloadState.MEDIA_COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4408a[MediaHttpDownloader.DownloadState.NOT_STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @Override // com.nexstreaming.sdk2.nexsns.a
    public ResultTask<Bitmap> a(String str, String str2) {
        ab.a("GoogleDriveMediaDL", "getThumbnail in NEXSNS_SDK is called! ");
        ResultTask<Bitmap> resultTask = new ResultTask<>();
        f().onSuccess(new t(this, str2, resultTask)).onFailure(new s(this, resultTask));
        ab.a("GoogleDriveMediaDL", "fileThumbTask : " + resultTask);
        return resultTask;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void c_(String str) {
        this.j = str;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public String g() {
        ab.a("GoogleDriveMediaDL", "getAuthenticationToken : " + (this.k == null ? "null" : "not-null"));
        return this.k;
    }
}
