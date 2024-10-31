package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

/* loaded from: assets/audience_network.dex */
public interface F5 {
    boolean A6b(EQ eq);

    HttpURLConnection A7g(String str) throws IOException;

    InputStream A7h(HttpURLConnection httpURLConnection) throws IOException;

    OutputStream A7i(HttpURLConnection httpURLConnection) throws IOException;

    void A7q(HttpURLConnection httpURLConnection, EnumC0371El enumC0371El, String str) throws IOException;

    byte[] A7x(InputStream inputStream) throws IOException;

    void A8o(OutputStream outputStream, byte[] bArr) throws IOException;
}
