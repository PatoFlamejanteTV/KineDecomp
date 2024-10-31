package com.adobe.creativesdk.foundation.internal.net;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.facebook.stetho.server.http.HttpHeaders;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;

/* compiled from: AdobeNetworkHttpFileUploadTask.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.net.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0328g extends C {
    private String k = null;

    public void a(j jVar, String str, String str2, m mVar, E e2) {
        this.k = str2;
        super.a(jVar, str, mVar, e2);
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.C
    protected void b() {
        a(this.j);
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.C
    protected boolean e() {
        OutputStream outputStream;
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                this.f5078f.setDoOutput(true);
                this.f5078f.setDoInput(true);
                long length = new File(this.k).length();
                this.f5078f.setFixedLengthStreamingMode((int) length);
                this.f5078f.setRequestProperty("file", org.apache.commons.io.c.e(URLDecoder.decode(this.f5079g.g().getPath(), "UTF-8")));
                this.f5078f.setRequestProperty("Content-Transfer-Encoding", "binary");
                if (length > 0) {
                    this.f5078f.setRequestProperty(HttpHeaders.CONTENT_LENGTH, "" + length);
                }
                outputStream = this.f5078f.getOutputStream();
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(this.k), 32768);
                    try {
                        byte[] bArr = new byte[32768];
                        int read = bufferedInputStream2.read(bArr, 0, 32768);
                        int i = 0;
                        while (read > 0) {
                            if (this.f5076d.c()) {
                                org.apache.commons.io.d.a((InputStream) bufferedInputStream2);
                                org.apache.commons.io.d.a(outputStream);
                                org.apache.commons.io.d.a((InputStream) bufferedInputStream2);
                                org.apache.commons.io.d.a(outputStream);
                                return false;
                            }
                            outputStream.write(bArr, 0, read);
                            outputStream.flush();
                            i += read;
                            read = bufferedInputStream2.read(bArr, 0, 32768);
                            a(Integer.valueOf((int) ((i / ((float) length)) * 100.0f)));
                        }
                        this.j.b(i);
                        org.apache.commons.io.d.a((InputStream) bufferedInputStream2);
                        org.apache.commons.io.d.a(outputStream);
                        return true;
                    } catch (IOException e2) {
                        e = e2;
                        bufferedInputStream = bufferedInputStream2;
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, C0325d.class.getName(), "Error during io operation", e);
                        this.j.a(true);
                        org.apache.commons.io.d.a((InputStream) bufferedInputStream);
                        org.apache.commons.io.d.a(outputStream);
                        return false;
                    } catch (IllegalArgumentException e3) {
                        e = e3;
                        bufferedInputStream = bufferedInputStream2;
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, C0325d.class.getName(), "Error during io operation", e);
                        this.j.a(true);
                        org.apache.commons.io.d.a((InputStream) bufferedInputStream);
                        org.apache.commons.io.d.a(outputStream);
                        return false;
                    } catch (IllegalStateException e4) {
                        e = e4;
                        bufferedInputStream = bufferedInputStream2;
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, C0325d.class.getName(), "Error during io operation", e);
                        this.j.a(true);
                        org.apache.commons.io.d.a((InputStream) bufferedInputStream);
                        org.apache.commons.io.d.a(outputStream);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        org.apache.commons.io.d.a((InputStream) bufferedInputStream);
                        org.apache.commons.io.d.a(outputStream);
                        throw th;
                    }
                } catch (IOException e5) {
                    e = e5;
                } catch (IllegalArgumentException e6) {
                    e = e6;
                } catch (IllegalStateException e7) {
                    e = e7;
                }
            } catch (IOException e8) {
                e = e8;
                outputStream = null;
            } catch (IllegalArgumentException e9) {
                e = e9;
                outputStream = null;
            } catch (IllegalStateException e10) {
                e = e10;
                outputStream = null;
            } catch (Throwable th2) {
                th = th2;
                outputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
