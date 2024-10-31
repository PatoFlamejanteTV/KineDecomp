package com.google.firebase.storage;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.firebase.annotations.PublicApi;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.network.GetNetworkRequest;
import com.google.firebase.storage.network.NetworkRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
@PublicApi
/* loaded from: classes2.dex */
public class FileDownloadTask extends StorageTask<TaskSnapshot> {
    private final Uri l;
    private long m;
    private StorageReference n;
    private ExponentialBackoffSender o;
    private long p;
    private String q;
    private volatile Exception r;
    private long s;
    private int t;

    /* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
    @PublicApi
    /* loaded from: classes2.dex */
    public class TaskSnapshot extends StorageTask<TaskSnapshot>.SnapshotBase {

        /* renamed from: c, reason: collision with root package name */
        private final long f18080c;

        TaskSnapshot(Exception exc, long j) {
            super(exc);
            this.f18080c = j;
        }
    }

    private int a(InputStream inputStream, byte[] bArr) {
        int read;
        int i = 0;
        boolean z = false;
        while (i != bArr.length && (read = inputStream.read(bArr, i, bArr.length - i)) != -1) {
            try {
                z = true;
                i += read;
            } catch (IOException e2) {
                this.r = e2;
            }
        }
        if (z) {
            return i;
        }
        return -1;
    }

    private boolean b(int i) {
        return i == 308 || (i >= 200 && i < 300);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.storage.StorageTask
    public StorageReference h() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.storage.StorageTask
    @PublicApi
    public void k() {
        this.o.a();
        this.r = StorageException.fromErrorStatus(Status.f10708e);
    }

    @Override // com.google.firebase.storage.StorageTask
    void r() {
        String str;
        if (this.r != null) {
            a(64, false);
            return;
        }
        if (!a(4, false)) {
            return;
        }
        do {
            this.m = 0L;
            this.r = null;
            this.o.b();
            GetNetworkRequest getNetworkRequest = new GetNetworkRequest(this.n.d(), this.n.a(), this.s);
            this.o.a(getNetworkRequest, false);
            this.t = getNetworkRequest.k();
            this.r = getNetworkRequest.c() != null ? getNetworkRequest.c() : this.r;
            boolean z = b(this.t) && this.r == null && f() == 4;
            if (z) {
                this.p = getNetworkRequest.m();
                String a2 = getNetworkRequest.a("ETag");
                if (!TextUtils.isEmpty(a2) && (str = this.q) != null && !str.equals(a2)) {
                    Log.w("FileDownloadTask", "The file at the server has changed.  Restarting from the beginning.");
                    this.s = 0L;
                    this.q = null;
                    getNetworkRequest.q();
                    s();
                    return;
                }
                this.q = a2;
                try {
                    z = a(getNetworkRequest);
                } catch (IOException e2) {
                    Log.e("FileDownloadTask", "Exception occurred during file write.  Aborting.", e2);
                    this.r = e2;
                }
            }
            getNetworkRequest.q();
            if (z && this.r == null && f() == 4) {
                a(128, false);
                return;
            }
            File file = new File(this.l.getPath());
            if (file.exists()) {
                this.s = file.length();
            } else {
                this.s = 0L;
            }
            if (f() == 8) {
                a(16, false);
                return;
            }
            if (f() == 32) {
                if (a(256, false)) {
                    return;
                }
                Log.w("FileDownloadTask", "Unable to change download task to final state from " + f());
                return;
            }
        } while (this.m > 0);
        a(64, false);
    }

    @Override // com.google.firebase.storage.StorageTask
    protected void s() {
        StorageTaskScheduler.a().c(g());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.firebase.storage.StorageTask
    public TaskSnapshot u() {
        return new TaskSnapshot(StorageException.fromExceptionAndHttpCode(this.r, this.t), this.m + this.s);
    }

    private boolean a(NetworkRequest networkRequest) throws IOException {
        FileOutputStream fileOutputStream;
        InputStream n = networkRequest.n();
        if (n != null) {
            File file = new File(this.l.getPath());
            if (!file.exists()) {
                if (this.s <= 0) {
                    if (!file.createNewFile()) {
                        Log.w("FileDownloadTask", "unable to create file:" + file.getAbsolutePath());
                    }
                } else {
                    Log.e("FileDownloadTask", "The file downloading to has been deleted:" + file.getAbsolutePath());
                    throw new IllegalStateException("expected a file to resume from.");
                }
            }
            boolean z = true;
            if (this.s > 0) {
                Log.d("FileDownloadTask", "Resuming download file " + file.getAbsolutePath() + " at " + this.s);
                fileOutputStream = new FileOutputStream(file, true);
            } else {
                fileOutputStream = new FileOutputStream(file);
            }
            try {
                byte[] bArr = new byte[262144];
                while (z) {
                    int a2 = a(n, bArr);
                    if (a2 == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, a2);
                    this.m += a2;
                    if (this.r != null) {
                        Log.d("FileDownloadTask", "Exception occurred during file download. Retrying.", this.r);
                        this.r = null;
                        z = false;
                    }
                    if (!a(4, false)) {
                        z = false;
                    }
                }
                fileOutputStream.flush();
                fileOutputStream.close();
                n.close();
                return z;
            } catch (Throwable th) {
                fileOutputStream.flush();
                fileOutputStream.close();
                n.close();
                throw th;
            }
        }
        this.r = new IllegalStateException("Unable to open Firebase Storage stream.");
        return false;
    }
}
