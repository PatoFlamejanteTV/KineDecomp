package com.bumptech.glide.load.engine.b;

import android.util.Log;
import com.bumptech.glide.a.b;
import com.bumptech.glide.load.engine.b.a;
import java.io.File;
import java.io.IOException;

/* compiled from: DiskLruCacheWrapper.java */
/* loaded from: classes.dex */
public class e implements a {

    /* renamed from: b */
    private final File f8843b;

    /* renamed from: c */
    private final long f8844c;

    /* renamed from: e */
    private com.bumptech.glide.a.b f8846e;

    /* renamed from: d */
    private final c f8845d = new c();

    /* renamed from: a */
    private final l f8842a = new l();

    @Deprecated
    protected e(File file, long j) {
        this.f8843b = file;
        this.f8844c = j;
    }

    public static a a(File file, long j) {
        return new e(file, j);
    }

    private synchronized com.bumptech.glide.a.b a() throws IOException {
        if (this.f8846e == null) {
            this.f8846e = com.bumptech.glide.a.b.a(this.f8843b, 1, 1, this.f8844c);
        }
        return this.f8846e;
    }

    @Override // com.bumptech.glide.load.engine.b.a
    public File a(com.bumptech.glide.load.c cVar) {
        String a2 = this.f8842a.a(cVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + a2 + " for for Key: " + cVar);
        }
        try {
            b.d f2 = a().f(a2);
            if (f2 != null) {
                return f2.a(0);
            }
            return null;
        } catch (IOException e2) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e2);
            return null;
        }
    }

    @Override // com.bumptech.glide.load.engine.b.a
    public void a(com.bumptech.glide.load.c cVar, a.b bVar) {
        com.bumptech.glide.a.b a2;
        String a3 = this.f8842a.a(cVar);
        this.f8845d.a(a3);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + a3 + " for for Key: " + cVar);
            }
            try {
                a2 = a();
            } catch (IOException e2) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e2);
                }
            }
            if (a2.f(a3) != null) {
                return;
            }
            b.C0044b e3 = a2.e(a3);
            if (e3 != null) {
                try {
                    if (bVar.a(e3.a(0))) {
                        e3.c();
                    }
                    e3.b();
                    return;
                } catch (Throwable th) {
                    e3.b();
                    throw th;
                }
            }
            throw new IllegalStateException("Had two simultaneous puts for: " + a3);
        } finally {
            this.f8845d.b(a3);
        }
    }
}
