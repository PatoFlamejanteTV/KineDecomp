package com.adobe.creativesdk.foundation.internal.net;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: AdobeNetworkHttpFileDownloadTask.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.net.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0326e extends C {
    private static String k = "e";
    String l = null;

    public void a(j jVar, String str, String str2, m mVar, E e2) {
        this.l = str2;
        super.a(jVar, str, mVar, e2);
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.C
    protected void b() {
        InputStream inputStream;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        r1 = null;
        InputStream inputStream2 = null;
        bufferedOutputStream2 = null;
        BufferedOutputStream bufferedOutputStream3 = null;
        try {
            try {
                if (this.j.g() == 200) {
                    inputStream = this.f5078f.getInputStream();
                    try {
                        int contentLength = this.f5078f.getContentLength();
                        if (!new File(this.l).exists()) {
                            com.adobe.creativesdk.foundation.internal.utils.m.a(this.l);
                        }
                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.l), 32768);
                        try {
                            byte[] bArr = new byte[32768];
                            int i = 0;
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read != -1) {
                                    if (this.f5076d.c()) {
                                        org.apache.commons.io.d.a(inputStream);
                                        org.apache.commons.io.d.a((OutputStream) bufferedOutputStream);
                                        org.apache.commons.io.d.a(inputStream);
                                        org.apache.commons.io.d.a((OutputStream) bufferedOutputStream);
                                        return;
                                    }
                                    bufferedOutputStream.write(bArr, 0, read);
                                    i += read;
                                    a(Integer.valueOf((int) ((i / contentLength) * 100.0f)));
                                } else {
                                    this.j.a(i);
                                    inputStream2 = inputStream;
                                    break;
                                }
                            }
                        } catch (IOException e2) {
                            e = e2;
                            bufferedOutputStream3 = bufferedOutputStream;
                            if (e.getMessage().contains("No space left on device")) {
                                File file = new File(this.l);
                                if (file.exists()) {
                                    file.delete();
                                }
                                this.j.b(true);
                                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, k, "No space left on device", e);
                            } else {
                                this.j.a(true);
                                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, k, "Error during io operation", e);
                            }
                            org.apache.commons.io.d.a(inputStream);
                            org.apache.commons.io.d.a((OutputStream) bufferedOutputStream3);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            bufferedOutputStream2 = bufferedOutputStream;
                            org.apache.commons.io.d.a(inputStream);
                            org.apache.commons.io.d.a((OutputStream) bufferedOutputStream2);
                            throw th;
                        }
                    } catch (IOException e3) {
                        e = e3;
                    }
                } else {
                    bufferedOutputStream = null;
                }
                org.apache.commons.io.d.a(inputStream2);
                org.apache.commons.io.d.a((OutputStream) bufferedOutputStream);
            } catch (IOException e4) {
                e = e4;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
