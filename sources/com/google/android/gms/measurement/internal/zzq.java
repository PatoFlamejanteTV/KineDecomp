package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* loaded from: classes.dex */
public class zzq extends ac {

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, Throwable th, byte[] bArr);
    }

    /* loaded from: classes.dex */
    private static class b implements Runnable {

        /* renamed from: a */
        private final a f2064a;
        private final int b;
        private final Throwable c;
        private final byte[] d;

        private b(a aVar, int i, Throwable th, byte[] bArr) {
            this.f2064a = aVar;
            this.b = i;
            this.c = th;
            this.d = bArr;
        }

        /* synthetic */ b(a aVar, int i, Throwable th, byte[] bArr, AnonymousClass1 anonymousClass1) {
            this(aVar, i, th, bArr);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2064a.a(this.b, this.c, this.d);
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        private final URL b;
        private final byte[] c;
        private final a d;

        public c(URL url, byte[] bArr, a aVar) {
            this.b = url;
            this.c = bArr;
            this.d = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th;
            HttpURLConnection httpURLConnection;
            OutputStream outputStream;
            int i;
            zzq.this.d();
            int i2 = 0;
            try {
                byte[] a2 = zzq.this.j().a(this.c);
                httpURLConnection = zzq.this.a(this.b);
                try {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.addRequestProperty("Content-Encoding", "gzip");
                    httpURLConnection.setFixedLengthStreamingMode(a2.length);
                    httpURLConnection.connect();
                    outputStream = httpURLConnection.getOutputStream();
                    try {
                        outputStream.write(a2);
                        outputStream.close();
                        OutputStream outputStream2 = null;
                        i2 = httpURLConnection.getResponseCode();
                        byte[] a3 = zzq.this.a(httpURLConnection);
                        if (0 != 0) {
                            try {
                                outputStream2.close();
                            } catch (IOException e) {
                                zzq.this.l().b().a("Error closing HTTP compressed POST connection output stream", e);
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        zzq.this.k().a(new b(this.d, i2, null, a3));
                    } catch (IOException e2) {
                        e = e2;
                        i = 0;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e3) {
                                zzq.this.l().b().a("Error closing HTTP compressed POST connection output stream", e3);
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        zzq.this.k().a(new b(this.d, i, e, null));
                    } catch (Throwable th2) {
                        th = th2;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e4) {
                                zzq.this.l().b().a("Error closing HTTP compressed POST connection output stream", e4);
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        zzq.this.k().a(new b(this.d, i2, null, null));
                        throw th;
                    }
                } catch (IOException e5) {
                    e = e5;
                    i = i2;
                    outputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = null;
                }
            } catch (IOException e6) {
                e = e6;
                i = 0;
                outputStream = null;
                httpURLConnection = null;
            } catch (Throwable th4) {
                th = th4;
                httpURLConnection = null;
                outputStream = null;
            }
        }
    }

    public zzq(zzv zzvVar) {
        super(zzvVar);
    }

    public byte[] a(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            inputStream = httpURLConnection.getInputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            return byteArrayOutputStream.toByteArray();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    protected HttpURLConnection a(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        if (!(openConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain HTTP connection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setConnectTimeout((int) n().s());
        httpURLConnection.setReadTimeout((int) n().t());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    @Override // com.google.android.gms.measurement.internal.ac
    protected void a() {
    }

    public void a(URL url, byte[] bArr, a aVar) {
        e();
        x();
        zzx.a(url);
        zzx.a(bArr);
        zzx.a(aVar);
        k().b(new c(url, bArr, aVar));
    }

    public boolean b() {
        NetworkInfo networkInfo;
        x();
        try {
            networkInfo = ((ConnectivityManager) i().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            networkInfo = null;
        }
        return networkInfo != null && networkInfo.isConnected();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ void e() {
        super.e();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzn f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzab g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzmn h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ Context i() {
        return super.i();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzag j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzu k() {
        return super.k();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzp l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzs m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzc n() {
        return super.n();
    }
}
