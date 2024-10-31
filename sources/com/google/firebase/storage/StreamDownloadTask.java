package com.google.firebase.storage;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.annotations.PublicApi;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.network.GetNetworkRequest;
import com.google.firebase.storage.network.NetworkRequest;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;

/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
@PublicApi
/* loaded from: classes2.dex */
public class StreamDownloadTask extends StorageTask<TaskSnapshot> {
    private StorageReference l;
    private ExponentialBackoffSender m;
    private StreamProcessor p;
    private long r;
    private long s;
    private InputStream t;
    private NetworkRequest u;
    private String v;
    private volatile Exception n = null;
    private volatile int o = 0;
    private long q = -1;

    /* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
    @PublicApi
    /* loaded from: classes2.dex */
    public interface StreamProcessor {
        void a(TaskSnapshot taskSnapshot, InputStream inputStream) throws IOException;
    }

    /* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
    @PublicApi
    /* loaded from: classes2.dex */
    public class TaskSnapshot extends StorageTask<TaskSnapshot>.SnapshotBase {

        /* renamed from: c */
        private final long f18122c;

        TaskSnapshot(Exception exc, long j) {
            super(exc);
            this.f18122c = j;
        }
    }

    /* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
    /* loaded from: classes2.dex */
    static class a extends InputStream {

        /* renamed from: a */
        private StreamDownloadTask f18124a;

        /* renamed from: b */
        private InputStream f18125b;

        /* renamed from: c */
        private Callable<InputStream> f18126c;

        /* renamed from: d */
        private IOException f18127d;

        /* renamed from: e */
        private long f18128e;

        /* renamed from: f */
        private long f18129f;

        /* renamed from: g */
        private boolean f18130g;

        a(Callable<InputStream> callable, StreamDownloadTask streamDownloadTask) {
            this.f18124a = streamDownloadTask;
            this.f18126c = callable;
        }

        public boolean b() throws IOException {
            a();
            if (this.f18127d != null) {
                try {
                    if (this.f18125b != null) {
                        this.f18125b.close();
                    }
                } catch (IOException unused) {
                }
                this.f18125b = null;
                if (this.f18129f == this.f18128e) {
                    Log.i("StreamDownloadTask", "Encountered exception during stream operation. Aborting.", this.f18127d);
                    return false;
                }
                Log.i("StreamDownloadTask", "Encountered exception during stream operation. Retrying at " + this.f18128e, this.f18127d);
                this.f18129f = this.f18128e;
                this.f18127d = null;
            }
            if (!this.f18130g) {
                if (this.f18125b != null) {
                    return true;
                }
                try {
                    this.f18125b = this.f18126c.call();
                    return true;
                } catch (Exception e2) {
                    if (e2 instanceof IOException) {
                        throw ((IOException) e2);
                    }
                    throw new IOException("Unable to open stream", e2);
                }
            }
            throw new IOException("Can't perform operation on closed stream");
        }

        private void g(long j) {
            StreamDownloadTask streamDownloadTask = this.f18124a;
            if (streamDownloadTask != null) {
                streamDownloadTask.a(j);
            }
            this.f18128e += j;
        }

        @Override // java.io.InputStream
        @PublicApi
        public int available() throws IOException {
            while (b()) {
                try {
                    return this.f18125b.available();
                } catch (IOException e2) {
                    this.f18127d = e2;
                }
            }
            throw this.f18127d;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        @PublicApi
        public void close() throws IOException {
            InputStream inputStream = this.f18125b;
            if (inputStream != null) {
                inputStream.close();
            }
            this.f18130g = true;
            StreamDownloadTask streamDownloadTask = this.f18124a;
            if (streamDownloadTask != null && streamDownloadTask.u != null) {
                this.f18124a.u.q();
                this.f18124a.u = null;
            }
            a();
        }

        @Override // java.io.InputStream
        @PublicApi
        public void mark(int i) {
        }

        @Override // java.io.InputStream
        @PublicApi
        public boolean markSupported() {
            return false;
        }

        @Override // java.io.InputStream
        @PublicApi
        public int read() throws IOException {
            while (b()) {
                try {
                    int read = this.f18125b.read();
                    if (read != -1) {
                        g(1L);
                    }
                    return read;
                } catch (IOException e2) {
                    this.f18127d = e2;
                }
            }
            throw this.f18127d;
        }

        @Override // java.io.InputStream
        @PublicApi
        public long skip(long j) throws IOException {
            long j2 = j;
            long j3 = 0;
            while (b()) {
                while (j2 > PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                    try {
                        long skip = this.f18125b.skip(PlaybackStateCompat.ACTION_SET_REPEAT_MODE);
                        if (skip < 0) {
                            if (j3 == 0) {
                                return -1L;
                            }
                            return j3;
                        }
                        j3 += skip;
                        j2 -= skip;
                        g(skip);
                        a();
                    } catch (IOException e2) {
                        this.f18127d = e2;
                    }
                }
                if (j2 > 0) {
                    long skip2 = this.f18125b.skip(j2);
                    if (skip2 < 0) {
                        if (j3 == 0) {
                            return -1L;
                        }
                        return j3;
                    }
                    j3 += skip2;
                    j2 -= skip2;
                    g(skip2);
                }
                if (j2 == 0) {
                    return j3;
                }
            }
            throw this.f18127d;
        }

        private void a() throws IOException {
            StreamDownloadTask streamDownloadTask = this.f18124a;
            if (streamDownloadTask != null && streamDownloadTask.f() == 32) {
                throw new CancelException();
            }
        }

        @Override // java.io.InputStream
        @PublicApi
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = 0;
            while (b()) {
                while (i2 > PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                    try {
                        int read = this.f18125b.read(bArr, i, 262144);
                        if (read == -1) {
                            if (i3 == 0) {
                                return -1;
                            }
                            return i3;
                        }
                        i3 += read;
                        i += read;
                        i2 -= read;
                        g(read);
                        a();
                    } catch (IOException e2) {
                        this.f18127d = e2;
                    }
                }
                if (i2 > 0) {
                    int read2 = this.f18125b.read(bArr, i, i2);
                    if (read2 == -1) {
                        if (i3 == 0) {
                            return -1;
                        }
                        return i3;
                    }
                    i += read2;
                    i3 += read2;
                    i2 -= read2;
                    g(read2);
                }
                if (i2 == 0) {
                    return i3;
                }
            }
            throw this.f18127d;
        }
    }

    public StreamDownloadTask(StorageReference storageReference) {
        this.l = storageReference;
        this.m = new ExponentialBackoffSender(this.l.a(), this.l.c().c());
    }

    private boolean b(int i) {
        return i == 308 || (i >= 200 && i < 300);
    }

    public InputStream x() throws Exception {
        String str;
        this.m.b();
        NetworkRequest networkRequest = this.u;
        if (networkRequest != null) {
            networkRequest.q();
        }
        this.u = new GetNetworkRequest(this.l.d(), this.l.a(), this.r);
        boolean z = false;
        this.m.a(this.u, false);
        this.o = this.u.k();
        this.n = this.u.c() != null ? this.u.c() : this.n;
        if (b(this.o) && this.n == null && f() == 4) {
            z = true;
        }
        if (z) {
            String a2 = this.u.a("ETag");
            if (!TextUtils.isEmpty(a2) && (str = this.v) != null && !str.equals(a2)) {
                this.o = 409;
                throw new IOException("The ETag on the server changed.");
            }
            this.v = a2;
            if (this.q == -1) {
                this.q = this.u.m();
            }
            return this.u.n();
        }
        throw new IOException("Could not open resulting stream.");
    }

    @Override // com.google.firebase.storage.StorageTask
    public StorageReference h() {
        return this.l;
    }

    @Override // com.google.firebase.storage.StorageTask
    public void k() {
        this.m.a();
        this.n = StorageException.fromErrorStatus(Status.f10708e);
    }

    @Override // com.google.firebase.storage.StorageTask
    protected void n() {
        this.s = this.r;
    }

    @Override // com.google.firebase.storage.StorageTask
    void r() {
        if (this.n != null) {
            a(64, false);
            return;
        }
        if (a(4, false)) {
            a aVar = new a(new CallableC1646r(this), this);
            this.t = new BufferedInputStream(aVar);
            try {
                aVar.b();
                if (this.p != null) {
                    try {
                        this.p.a(t(), this.t);
                    } catch (Exception e2) {
                        Log.w("StreamDownloadTask", "Exception occurred calling doInBackground.", e2);
                        this.n = e2;
                    }
                }
            } catch (IOException e3) {
                Log.d("StreamDownloadTask", "Initial opening of Stream failed", e3);
                this.n = e3;
            }
            if (this.t == null) {
                this.u.q();
                this.u = null;
            }
            if (this.n == null && f() == 4) {
                a(4, false);
                a(128, false);
                return;
            }
            if (a(f() == 32 ? 256 : 64, false)) {
                return;
            }
            Log.w("StreamDownloadTask", "Unable to change download task to final state from " + f());
        }
    }

    @Override // com.google.firebase.storage.StorageTask
    protected void s() {
        StorageTaskScheduler.a().c(g());
    }

    @Override // com.google.firebase.storage.StorageTask
    public TaskSnapshot u() {
        return new TaskSnapshot(StorageException.fromExceptionAndHttpCode(this.n, this.o), this.s);
    }

    public StreamDownloadTask a(StreamProcessor streamProcessor) {
        Preconditions.a(streamProcessor);
        Preconditions.b(this.p == null);
        this.p = streamProcessor;
        return this;
    }

    void a(long j) {
        this.r += j;
        if (this.s + PlaybackStateCompat.ACTION_SET_REPEAT_MODE <= this.r) {
            if (f() == 4) {
                a(4, false);
            } else {
                this.s = this.r;
            }
        }
    }
}
