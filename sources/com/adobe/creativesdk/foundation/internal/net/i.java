package com.adobe.creativesdk.foundation.internal.net;

import android.os.Handler;
import android.text.TextUtils;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: AdobeNetworkHttpMultiPartTask.java */
/* loaded from: classes.dex */
public class i extends C {
    String k;
    ArrayList<C0322a> l;

    private void b(String str) {
    }

    public void a(j jVar, String str, m mVar, E e2, String str2, ArrayList<C0322a> arrayList) {
        this.k = str2;
        this.l = arrayList;
        super.a(jVar, str, mVar, e2);
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.C
    protected void b() {
        a(this.j);
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.C, java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ l call() {
        return super.call();
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.C
    protected boolean e() {
        OutputStream outputStream;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                this.f5078f.setDoOutput(true);
                this.f5078f.setDoInput(true);
                outputStream = this.f5078f.getOutputStream();
                try {
                    Iterator<C0322a> it = this.l.iterator();
                    while (it.hasNext()) {
                        C0322a next = it.next();
                        if (Thread.currentThread().isInterrupted()) {
                            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, "MultiPartTask", "thread interrupted or cancelled.");
                            org.apache.commons.io.d.a((InputStream) null);
                        } else {
                            try {
                                if (next.h() == null && next.f() == null) {
                                    if (next.d() != null) {
                                        String a2 = a(next, this.k);
                                        b(a2);
                                        outputStream.write(a2.getBytes(Charset.defaultCharset()));
                                        outputStream.write(next.d());
                                    }
                                    outputStream.write("\r\n".getBytes());
                                }
                                String a3 = a(next, this.k);
                                b(a3);
                                outputStream.write(a3.getBytes(Charset.defaultCharset()));
                                byte[] bArr = new byte[32768];
                                int available = bufferedInputStream.available();
                                int read = bufferedInputStream.read(bArr, 0, 32768);
                                int i = 0;
                                while (read > 0) {
                                    if (!this.f5076d.c() && !Thread.currentThread().isInterrupted()) {
                                        outputStream.write(bArr, 0, read);
                                        i += read;
                                        read = bufferedInputStream.read(bArr, 0, 32768);
                                        a(next, i, available);
                                    }
                                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, "MultiPartTask", "thread interrupted or cancelled.");
                                    org.apache.commons.io.d.a((InputStream) bufferedInputStream);
                                }
                                this.j.b(i);
                                org.apache.commons.io.d.a((InputStream) bufferedInputStream);
                                outputStream.write("\r\n".getBytes());
                            } catch (IOException e2) {
                                e = e2;
                                bufferedInputStream2 = bufferedInputStream;
                                e.printStackTrace();
                                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, C0325d.class.getName(), "Error during io operation", e);
                                this.j.a(true);
                                org.apache.commons.io.d.a((InputStream) bufferedInputStream2);
                                org.apache.commons.io.d.a(outputStream);
                                this.i = false;
                                return false;
                            } catch (IllegalArgumentException e3) {
                                e = e3;
                                bufferedInputStream2 = bufferedInputStream;
                                e.printStackTrace();
                                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, C0325d.class.getName(), "Error during io operation", e);
                                this.j.a(true);
                                org.apache.commons.io.d.a((InputStream) bufferedInputStream2);
                                org.apache.commons.io.d.a(outputStream);
                                this.i = false;
                                return false;
                            } catch (IllegalStateException e4) {
                                e = e4;
                                bufferedInputStream2 = bufferedInputStream;
                                e.printStackTrace();
                                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, C0325d.class.getName(), "Error during io operation", e);
                                this.j.a(true);
                                org.apache.commons.io.d.a((InputStream) bufferedInputStream2);
                                org.apache.commons.io.d.a(outputStream);
                                this.i = false;
                                return false;
                            } catch (Throwable th) {
                                th = th;
                                bufferedInputStream2 = bufferedInputStream;
                                org.apache.commons.io.d.a((InputStream) bufferedInputStream2);
                                org.apache.commons.io.d.a(outputStream);
                                this.i = false;
                                throw th;
                            }
                            if (next.f() != null) {
                                bufferedInputStream = new BufferedInputStream(next.f());
                            } else {
                                bufferedInputStream = new BufferedInputStream(new FileInputStream(next.h()), 32768);
                            }
                        }
                        org.apache.commons.io.d.a(outputStream);
                        this.i = false;
                        return false;
                    }
                    String format = String.format("--%s--\r\n", this.k);
                    outputStream.write(format.getBytes(Charset.defaultCharset()));
                    b(format);
                    org.apache.commons.io.d.a((InputStream) null);
                    org.apache.commons.io.d.a(outputStream);
                    this.i = false;
                    return true;
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
                e.printStackTrace();
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, C0325d.class.getName(), "Error during io operation", e);
                this.j.a(true);
                org.apache.commons.io.d.a((InputStream) bufferedInputStream2);
                org.apache.commons.io.d.a(outputStream);
                this.i = false;
                return false;
            } catch (IllegalArgumentException e9) {
                e = e9;
                outputStream = null;
                e.printStackTrace();
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, C0325d.class.getName(), "Error during io operation", e);
                this.j.a(true);
                org.apache.commons.io.d.a((InputStream) bufferedInputStream2);
                org.apache.commons.io.d.a(outputStream);
                this.i = false;
                return false;
            } catch (IllegalStateException e10) {
                e = e10;
                outputStream = null;
                e.printStackTrace();
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, C0325d.class.getName(), "Error during io operation", e);
                this.j.a(true);
                org.apache.commons.io.d.a((InputStream) bufferedInputStream2);
                org.apache.commons.io.d.a(outputStream);
                this.i = false;
                return false;
            } catch (Throwable th2) {
                th = th2;
                outputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private void a(C0322a c0322a, int i, int i2) {
        Handler handler = c0322a.f5091a;
        if (handler == null || c0322a.f5092b == null) {
            return;
        }
        handler.post(new RunnableC0329h(this, c0322a, i, i2));
    }

    private String a(C0322a c0322a, String str) {
        StringBuilder sb = new StringBuilder("");
        sb.append(String.format("--%s\r\n", str));
        sb.append(String.format("Content-Disposition: %s; ", c0322a.a()));
        String e2 = c0322a.e();
        if (!TextUtils.isEmpty(e2)) {
            sb.append(String.format("name=\"%s\"", e2));
        }
        String g2 = c0322a.g();
        if (!TextUtils.isEmpty(g2)) {
            sb.append(String.format("; filename=\"%s\"", g2));
        }
        sb.append("\r\n");
        String b2 = c0322a.b();
        if (b2 != null) {
            if (b2.startsWith("cid:")) {
                b2 = b2.substring(4);
            }
            sb.append(String.format("Content-ID: <%s>\r\n", b2));
        }
        String c2 = c0322a.c();
        if (!TextUtils.isEmpty(c2)) {
            sb.append(String.format("Content-Type: %s\r\n", c2));
        }
        sb.append("\r\n");
        return sb.toString();
    }
}
