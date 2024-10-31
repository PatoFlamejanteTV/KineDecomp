package com.squareup.picasso;

import android.content.Context;
import android.net.Uri;
import com.squareup.okhttp.C2379e;
import com.squareup.okhttp.C2382h;
import com.squareup.okhttp.E;
import com.squareup.picasso.Downloader;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* compiled from: OkHttpDownloader.java */
/* loaded from: classes3.dex */
public class v implements Downloader {

    /* renamed from: a, reason: collision with root package name */
    private final com.squareup.okhttp.C f25677a;

    public v(Context context) {
        this(N.b(context));
    }

    private static com.squareup.okhttp.C a() {
        com.squareup.okhttp.C c2 = new com.squareup.okhttp.C();
        c2.a(15000L, TimeUnit.MILLISECONDS);
        c2.b(20000L, TimeUnit.MILLISECONDS);
        c2.c(20000L, TimeUnit.MILLISECONDS);
        return c2;
    }

    public v(File file) {
        this(file, N.a(file));
    }

    public v(File file, long j) {
        this(a());
        try {
            this.f25677a.a(new C2379e(file, j));
        } catch (IOException unused) {
        }
    }

    public v(com.squareup.okhttp.C c2) {
        this.f25677a = c2;
    }

    @Override // com.squareup.picasso.Downloader
    public Downloader.a a(Uri uri, int i) throws IOException {
        C2382h c2382h;
        if (i == 0) {
            c2382h = null;
        } else if (NetworkPolicy.isOfflineOnly(i)) {
            c2382h = C2382h.f25251b;
        } else {
            C2382h.a aVar = new C2382h.a();
            if (!NetworkPolicy.shouldReadFromDiskCache(i)) {
                aVar.b();
            }
            if (!NetworkPolicy.shouldWriteToDiskCache(i)) {
                aVar.c();
            }
            c2382h = aVar.a();
        }
        E.a aVar2 = new E.a();
        aVar2.b(uri.toString());
        if (c2382h != null) {
            aVar2.a(c2382h);
        }
        com.squareup.okhttp.H a2 = this.f25677a.a(aVar2.a()).a();
        int e2 = a2.e();
        if (e2 < 300) {
            boolean z = a2.c() != null;
            com.squareup.okhttp.I a3 = a2.a();
            return new Downloader.a(a3.a(), z, a3.b());
        }
        a2.a().close();
        throw new Downloader.ResponseException(e2 + " " + a2.h(), i, e2);
    }
}
