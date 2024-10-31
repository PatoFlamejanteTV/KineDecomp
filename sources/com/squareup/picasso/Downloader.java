package com.squareup.picasso;

import android.graphics.Bitmap;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public interface Downloader {

    /* loaded from: classes3.dex */
    public static class ResponseException extends IOException {
        final boolean localCacheOnly;
        final int responseCode;

        public ResponseException(String str, int i, int i2) {
            super(str);
            this.localCacheOnly = NetworkPolicy.isOfflineOnly(i);
            this.responseCode = i2;
        }
    }

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a */
        final InputStream f25567a;

        /* renamed from: b */
        final Bitmap f25568b;

        /* renamed from: c */
        final boolean f25569c;

        /* renamed from: d */
        final long f25570d;

        public a(InputStream inputStream, boolean z, long j) {
            if (inputStream != null) {
                this.f25567a = inputStream;
                this.f25568b = null;
                this.f25569c = z;
                this.f25570d = j;
                return;
            }
            throw new IllegalArgumentException("Stream may not be null.");
        }

        @Deprecated
        public Bitmap a() {
            return this.f25568b;
        }

        public long b() {
            return this.f25570d;
        }

        public InputStream c() {
            return this.f25567a;
        }
    }

    a a(Uri uri, int i) throws IOException;
}
