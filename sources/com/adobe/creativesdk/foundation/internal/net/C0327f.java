package com.adobe.creativesdk.foundation.internal.net;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.facebook.stetho.server.http.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;

/* compiled from: AdobeNetworkHttpFileUploadStreamTask.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.net.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0327f extends C0328g {
    private InputStream l;

    @Override // com.adobe.creativesdk.foundation.internal.net.C0328g
    public /* bridge */ /* synthetic */ void a(j jVar, String str, String str2, m mVar, E e2) {
        super.a(jVar, str, str2, mVar, e2);
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.C, java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ l call() {
        return super.call();
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.C0328g, com.adobe.creativesdk.foundation.internal.net.C
    protected boolean e() {
        OutputStream outputStream = null;
        try {
            try {
                try {
                    try {
                        if (this.l == null) {
                            this.j.a(true);
                        } else {
                            this.f5078f.setDoOutput(true);
                            this.f5078f.setDoInput(true);
                            this.f5078f.setFixedLengthStreamingMode(this.l.available());
                            this.f5078f.setRequestProperty("file", org.apache.commons.io.c.e(URLDecoder.decode(this.f5079g.g().getPath(), "UTF-8")));
                            int available = this.l.available();
                            this.f5078f.setRequestProperty("Content-Transfer-Encoding", "binary");
                            if (available > 0) {
                                this.f5078f.setRequestProperty(HttpHeaders.CONTENT_LENGTH, "" + available);
                            }
                            outputStream = this.f5078f.getOutputStream();
                            byte[] bArr = new byte[32768];
                            int read = this.l.read(bArr, 0, 32768);
                            int i = 0;
                            while (read > 0) {
                                if (this.f5076d.c()) {
                                    org.apache.commons.io.d.a(this.l);
                                    org.apache.commons.io.d.a(outputStream);
                                } else {
                                    outputStream.write(bArr, 0, read);
                                    outputStream.flush();
                                    i += read;
                                    read = this.l.read(bArr, 0, 32768);
                                    a(Integer.valueOf((int) ((i / available) * 100.0f)));
                                }
                            }
                            this.j.b(i);
                            return true;
                        }
                        return false;
                    } catch (IllegalStateException e2) {
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, C0325d.class.getName(), "Error during io operation", e2);
                        this.j.a(true);
                        return false;
                    }
                } catch (IOException e3) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, C0325d.class.getName(), "Error during io operation", e3);
                    this.j.a(true);
                    return false;
                }
            } catch (IllegalArgumentException e4) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, C0325d.class.getName(), "Error during io operation", e4);
                this.j.a(true);
                return false;
            }
        } finally {
            org.apache.commons.io.d.a(this.l);
            org.apache.commons.io.d.a((OutputStream) null);
        }
    }

    public void a(j jVar, String str, InputStream inputStream, m mVar, E e2) {
        super.a(jVar, str, (String) null, mVar, e2);
        this.l = inputStream;
    }
}
