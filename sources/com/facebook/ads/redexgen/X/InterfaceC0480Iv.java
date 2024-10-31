package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

/* renamed from: com.facebook.ads.redexgen.X.Iv, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public interface InterfaceC0480Iv {
    boolean A6a(J9 j9);

    HttpURLConnection A7g(String str) throws IOException;

    InputStream A7h(HttpURLConnection httpURLConnection) throws IOException;

    OutputStream A7i(HttpURLConnection httpURLConnection) throws IOException;

    void A7p(HttpURLConnection httpURLConnection, J7 j7, String str) throws IOException;

    byte[] A7x(InputStream inputStream) throws IOException;

    void A8o(OutputStream outputStream, byte[] bArr) throws IOException;
}
