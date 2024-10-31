package com.squareup.picasso;

import android.graphics.Bitmap;
import android.net.NetworkInfo;
import com.squareup.picasso.Downloader;
import com.squareup.picasso.E;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class NetworkRequestHandler extends E {

    /* renamed from: a, reason: collision with root package name */
    private final Downloader f25601a;

    /* renamed from: b, reason: collision with root package name */
    private final H f25602b;

    /* loaded from: classes3.dex */
    static class ContentLengthException extends IOException {
        public ContentLengthException(String str) {
            super(str);
        }
    }

    public NetworkRequestHandler(Downloader downloader, H h2) {
        this.f25601a = downloader;
        this.f25602b = h2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.squareup.picasso.E
    public int a() {
        return 2;
    }

    @Override // com.squareup.picasso.E
    public boolean a(C c2) {
        String scheme = c2.f25547e.getScheme();
        return "http".equals(scheme) || "https".equals(scheme);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.squareup.picasso.E
    public boolean b() {
        return true;
    }

    @Override // com.squareup.picasso.E
    public E.a a(C c2, int i) throws IOException {
        Downloader.a a2 = this.f25601a.a(c2.f25547e, c2.f25546d);
        if (a2 == null) {
            return null;
        }
        Picasso.LoadedFrom loadedFrom = a2.f25569c ? Picasso.LoadedFrom.DISK : Picasso.LoadedFrom.NETWORK;
        Bitmap a3 = a2.a();
        if (a3 != null) {
            return new E.a(a3, loadedFrom);
        }
        InputStream c3 = a2.c();
        if (c3 == null) {
            return null;
        }
        if (loadedFrom == Picasso.LoadedFrom.DISK && a2.b() == 0) {
            N.a(c3);
            throw new ContentLengthException("Received response with 0 content-length header.");
        }
        if (loadedFrom == Picasso.LoadedFrom.NETWORK && a2.b() > 0) {
            this.f25602b.a(a2.b());
        }
        return new E.a(c3, loadedFrom);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.squareup.picasso.E
    public boolean a(boolean z, NetworkInfo networkInfo) {
        return networkInfo == null || networkInfo.isConnected();
    }
}
