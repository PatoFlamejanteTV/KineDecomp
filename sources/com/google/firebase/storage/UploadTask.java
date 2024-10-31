package com.google.firebase.storage;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.annotations.PublicApi;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.internal.AdaptiveStreamBuffer;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.internal.Util;
import com.google.firebase.storage.network.NetworkRequest;
import com.google.firebase.storage.network.ResumableUploadByteRequest;
import com.google.firebase.storage.network.ResumableUploadCancelRequest;
import com.google.firebase.storage.network.ResumableUploadQueryRequest;
import com.google.firebase.storage.network.ResumableUploadStartRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;

/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
@PublicApi
/* loaded from: classes2.dex */
public class UploadTask extends StorageTask<TaskSnapshot> {
    private final StorageReference l;
    private final Uri m;
    private final long n;
    private final AdaptiveStreamBuffer o;
    private ExponentialBackoffSender r;
    private boolean s;
    private volatile StorageMetadata t;
    private volatile String y;
    private final AtomicLong p = new AtomicLong(0);
    private int q = 262144;
    private volatile Uri u = null;
    private volatile Exception v = null;
    private volatile Exception w = null;
    private volatile int x = 0;

    /* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
    @PublicApi
    /* loaded from: classes2.dex */
    public class TaskSnapshot extends StorageTask<TaskSnapshot>.SnapshotBase {

        /* renamed from: c, reason: collision with root package name */
        private final long f18131c;

        /* renamed from: d, reason: collision with root package name */
        private final Uri f18132d;

        /* renamed from: e, reason: collision with root package name */
        private final StorageMetadata f18133e;

        TaskSnapshot(Exception exc, long j, Uri uri, StorageMetadata storageMetadata) {
            super(exc);
            this.f18131c = j;
            this.f18132d = uri;
            this.f18133e = storageMetadata;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UploadTask(StorageReference storageReference, StorageMetadata storageMetadata, byte[] bArr) {
        Preconditions.a(storageReference);
        Preconditions.a(bArr);
        this.n = bArr.length;
        this.l = storageReference;
        this.t = storageMetadata;
        this.m = null;
        this.o = new AdaptiveStreamBuffer(new ByteArrayInputStream(bArr), 262144);
        this.s = true;
        this.r = new ExponentialBackoffSender(this.l.a(), this.l.c().d());
    }

    private void A() {
        try {
            this.o.b(this.q);
            int min = Math.min(this.q, this.o.a());
            ResumableUploadByteRequest resumableUploadByteRequest = new ResumableUploadByteRequest(this.l.d(), this.l.a(), this.u.toString(), this.o.c(), this.p.get(), min, this.o.d());
            if (!b(resumableUploadByteRequest)) {
                this.q = 262144;
                Log.d("UploadTask", "Resetting chunk size to " + this.q);
                return;
            }
            this.p.getAndAdd(min);
            if (!this.o.d()) {
                this.o.a(min);
                if (this.q < 33554432) {
                    this.q *= 2;
                    Log.d("UploadTask", "Increasing chunk size to " + this.q);
                    return;
                }
                return;
            }
            try {
                this.t = new StorageMetadata.Builder(resumableUploadByteRequest.j(), this.l).a();
                a(4, false);
                a(128, false);
            } catch (JSONException e2) {
                Log.e("UploadTask", "Unable to parse resulting metadata from upload:" + resumableUploadByteRequest.i(), e2);
                this.v = e2;
            }
        } catch (IOException e3) {
            Log.e("UploadTask", "Unable to read bytes for uploading", e3);
            this.v = e3;
        }
    }

    private boolean b(int i) {
        return i == 308 || (i >= 200 && i < 300);
    }

    private boolean b(NetworkRequest networkRequest) {
        networkRequest.a(Util.a(this.l.a()), this.l.a().b());
        return a(networkRequest);
    }

    private boolean c(NetworkRequest networkRequest) {
        this.r.a(networkRequest);
        return a(networkRequest);
    }

    private void x() {
        String f2 = this.t != null ? this.t.f() : null;
        if (this.m != null && TextUtils.isEmpty(f2)) {
            f2 = this.l.c().a().b().getContentResolver().getType(this.m);
        }
        if (TextUtils.isEmpty(f2)) {
            f2 = "application/octet-stream";
        }
        try {
            ResumableUploadStartRequest resumableUploadStartRequest = new ResumableUploadStartRequest(this.l.d(), this.l.a(), this.t != null ? this.t.a() : null, f2);
            if (c(resumableUploadStartRequest)) {
                String a2 = resumableUploadStartRequest.a("X-Goog-Upload-URL");
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                this.u = Uri.parse(a2);
            }
        } catch (JSONException e2) {
            Log.e("UploadTask", "Unable to create a network request from metadata", e2);
            this.v = e2;
        }
    }

    private boolean y() {
        if (!"final".equals(this.y)) {
            return true;
        }
        if (this.v == null) {
            this.v = new IOException("The server has terminated the upload session", this.w);
        }
        a(64, false);
        return false;
    }

    private boolean z() {
        if (f() == 128) {
            return false;
        }
        if (Thread.interrupted()) {
            this.v = new InterruptedException();
            a(64, false);
            return false;
        }
        if (f() == 32) {
            a(256, false);
            return false;
        }
        if (f() == 8) {
            a(16, false);
            return false;
        }
        if (!y()) {
            return false;
        }
        if (this.u == null) {
            if (this.v == null) {
                this.v = new IllegalStateException("Unable to obtain an upload URL.");
            }
            a(64, false);
            return false;
        }
        if (this.v != null) {
            a(64, false);
            return false;
        }
        if (!(this.w != null || this.x < 200 || this.x >= 300) || a(true)) {
            return true;
        }
        if (y()) {
            a(64, false);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.storage.StorageTask
    public StorageReference h() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.storage.StorageTask
    public void k() {
        this.r.a();
        ResumableUploadCancelRequest resumableUploadCancelRequest = this.u != null ? new ResumableUploadCancelRequest(this.l.d(), this.l.a(), this.u.toString()) : null;
        if (resumableUploadCancelRequest != null) {
            StorageTaskScheduler.a().b(new w(this, resumableUploadCancelRequest));
        }
        this.v = StorageException.fromErrorStatus(Status.f10708e);
        super.k();
    }

    @Override // com.google.firebase.storage.StorageTask
    void r() {
        this.r.b();
        if (!a(4, false)) {
            Log.d("UploadTask", "The upload cannot continue as it is not in a valid state.");
            return;
        }
        if (this.l.b() == null) {
            this.v = new IllegalArgumentException("Cannot upload to getRoot. You should upload to a storage location such as .getReference('image.png').putFile...");
        }
        if (this.v != null) {
            return;
        }
        if (this.u == null) {
            x();
        } else {
            a(false);
        }
        boolean z = z();
        while (z) {
            A();
            z = z();
            if (z) {
                a(4, false);
            }
        }
        if (!this.s || f() == 16) {
            return;
        }
        try {
            this.o.b();
        } catch (IOException e2) {
            Log.e("UploadTask", "Unable to close stream.", e2);
        }
    }

    @Override // com.google.firebase.storage.StorageTask
    protected void s() {
        StorageTaskScheduler.a().d(g());
    }

    private boolean a(boolean z) {
        ResumableUploadQueryRequest resumableUploadQueryRequest = new ResumableUploadQueryRequest(this.l.d(), this.l.a(), this.u.toString());
        if ("final".equals(this.y)) {
            return false;
        }
        if (z) {
            if (!c(resumableUploadQueryRequest)) {
                return false;
            }
        } else if (!b(resumableUploadQueryRequest)) {
            return false;
        }
        if ("final".equals(resumableUploadQueryRequest.a("X-Goog-Upload-Status"))) {
            this.v = new IOException("The server has terminated the upload session");
            return false;
        }
        String a2 = resumableUploadQueryRequest.a("X-Goog-Upload-Size-Received");
        long parseLong = !TextUtils.isEmpty(a2) ? Long.parseLong(a2) : 0L;
        long j = this.p.get();
        if (j > parseLong) {
            this.v = new IOException("Unexpected error. The server lost a chunk update.");
            return false;
        }
        if (j >= parseLong) {
            return true;
        }
        try {
            if (this.o.a((int) r7) != parseLong - j) {
                this.v = new IOException("Unexpected end of stream encountered.");
                return false;
            }
            if (this.p.compareAndSet(j, parseLong)) {
                return true;
            }
            Log.e("UploadTask", "Somehow, the uploaded bytes changed during an uploaded.  This should nothappen");
            this.v = new IllegalStateException("uploaded bytes changed unexpectedly.");
            return false;
        } catch (IOException e2) {
            Log.e("UploadTask", "Unable to recover position in Stream during resumable upload", e2);
            this.v = e2;
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.storage.StorageTask
    public TaskSnapshot u() {
        return new TaskSnapshot(StorageException.fromExceptionAndHttpCode(this.v != null ? this.v : this.w, this.x), this.p.get(), this.u, this.t);
    }

    private boolean a(NetworkRequest networkRequest) {
        int k = networkRequest.k();
        if (this.r.a(k)) {
            k = -2;
        }
        this.x = k;
        this.w = networkRequest.c();
        this.y = networkRequest.a("X-Goog-Upload-Status");
        return b(this.x) && this.w == null;
    }
}
