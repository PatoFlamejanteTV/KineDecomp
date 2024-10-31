package com.google.android.gms.internal.gtm;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class C extends zzan {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f13131a = "\n".getBytes();

    /* renamed from: b, reason: collision with root package name */
    private final String f13132b;

    /* renamed from: c, reason: collision with root package name */
    private final I f13133c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C(zzap zzapVar) {
        super(zzapVar);
        this.f13132b = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", "GoogleAnalytics", zzao.VERSION, Build.VERSION.RELEASE, zzcz.zza(Locale.getDefault()), Build.MODEL, Build.ID);
        this.f13133c = new I(zzapVar.zzcn());
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int b(java.net.URL r11, byte[] r12) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.C.b(java.net.URL, byte[]):int");
    }

    private final URL r() {
        String valueOf = String.valueOf(zzbq.zzet());
        String valueOf2 = String.valueOf(zzby.zzzs.get());
        try {
            return new URL(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        } catch (MalformedURLException e2) {
            zze("Error trying to parse the hardcoded host url", e2);
            return null;
        }
    }

    public final boolean a() {
        NetworkInfo networkInfo;
        com.google.android.gms.analytics.zzk.d();
        zzdb();
        try {
            networkInfo = ((ConnectivityManager) getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException unused) {
            networkInfo = null;
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        zzq("No network connectivity");
        return false;
    }

    @Override // com.google.android.gms.internal.gtm.zzan
    protected final void zzaw() {
        zza("Network initialized. User agent", this.f13132b);
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x0159, code lost:            if (a(r5) == 200) goto L47;     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x019b, code lost:            if (a(r6, r5) == 200) goto L47;     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01b5 A[EDGE_INSN: B:52:0x01b5->B:50:0x01b5 BREAK  A[LOOP:1: B:40:0x0112->B:51:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<java.lang.Long> a(java.util.List<com.google.android.gms.internal.gtm.zzcd> r9) {
        /*
            Method dump skipped, instructions count: 438
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.C.a(java.util.List):java.util.List");
    }

    @VisibleForTesting
    private final HttpURLConnection b(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout(zzby.zzaad.get().intValue());
            httpURLConnection.setReadTimeout(zzby.zzaae.get().intValue());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestProperty(io.fabric.sdk.android.services.common.a.HEADER_USER_AGENT, this.f13132b);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain http connection");
    }

    private final int a(URL url) {
        Preconditions.a(url);
        zzb("GET request", url);
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                httpURLConnection = b(url);
                httpURLConnection.connect();
                a(httpURLConnection);
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    zzcs().zzcl();
                }
                zzb("GET status", Integer.valueOf(responseCode));
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return responseCode;
            } catch (IOException e2) {
                zzd("Network GET connection error", e2);
                if (httpURLConnection == null) {
                    return 0;
                }
                httpURLConnection.disconnect();
                return 0;
            }
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.net.URL, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int a(java.net.URL r5, byte[] r6) {
        /*
            r4 = this;
            java.lang.String r0 = "Error closing http post connection output stream"
            com.google.android.gms.common.internal.Preconditions.a(r5)
            com.google.android.gms.common.internal.Preconditions.a(r6)
            int r1 = r6.length
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r2 = "POST bytes, url"
            r4.zzb(r2, r1, r5)
            boolean r1 = com.google.android.gms.internal.gtm.zzam.zzda()
            if (r1 == 0) goto L22
            java.lang.String r1 = new java.lang.String
            r1.<init>(r6)
            java.lang.String r2 = "Post payload\n"
            r4.zza(r2, r1)
        L22:
            r1 = 0
            android.content.Context r2 = r4.getContext()     // Catch: java.lang.Throwable -> L6d java.io.IOException -> L70
            r2.getPackageName()     // Catch: java.lang.Throwable -> L6d java.io.IOException -> L70
            java.net.HttpURLConnection r5 = r4.b(r5)     // Catch: java.lang.Throwable -> L6d java.io.IOException -> L70
            r2 = 1
            r5.setDoOutput(r2)     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L88
            int r2 = r6.length     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L88
            r5.setFixedLengthStreamingMode(r2)     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L88
            r5.connect()     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L88
            java.io.OutputStream r1 = r5.getOutputStream()     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L88
            r1.write(r6)     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L88
            r4.a(r5)     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L88
            int r6 = r5.getResponseCode()     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L88
            r2 = 200(0xc8, float:2.8E-43)
            if (r6 != r2) goto L52
            com.google.android.gms.internal.gtm.zzae r2 = r4.zzcs()     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L88
            r2.zzcl()     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L88
        L52:
            java.lang.String r2 = "POST status"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L88
            r4.zzb(r2, r3)     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L88
            if (r1 == 0) goto L65
            r1.close()     // Catch: java.io.IOException -> L61
            goto L65
        L61:
            r1 = move-exception
            r4.zze(r0, r1)
        L65:
            if (r5 == 0) goto L6a
            r5.disconnect()
        L6a:
            return r6
        L6b:
            r6 = move-exception
            goto L72
        L6d:
            r6 = move-exception
            r5 = r1
            goto L89
        L70:
            r6 = move-exception
            r5 = r1
        L72:
            java.lang.String r2 = "Network POST connection error"
            r4.zzd(r2, r6)     // Catch: java.lang.Throwable -> L88
            if (r1 == 0) goto L81
            r1.close()     // Catch: java.io.IOException -> L7d
            goto L81
        L7d:
            r6 = move-exception
            r4.zze(r0, r6)
        L81:
            if (r5 == 0) goto L86
            r5.disconnect()
        L86:
            r5 = 0
            return r5
        L88:
            r6 = move-exception
        L89:
            if (r1 == 0) goto L93
            r1.close()     // Catch: java.io.IOException -> L8f
            goto L93
        L8f:
            r1 = move-exception
            r4.zze(r0, r1)
        L93:
            if (r5 == 0) goto L98
            r5.disconnect()
        L98:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.C.a(java.net.URL, byte[]):int");
    }

    private final void a(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream;
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            do {
            } while (inputStream.read(new byte[1024]) > 0);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    zze("Error closing http connection input stream", e2);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    zze("Error closing http connection input stream", e3);
                }
            }
            throw th;
        }
    }

    private final URL a(zzcd zzcdVar) {
        String str;
        String concat;
        if (zzcdVar.zzfj()) {
            String valueOf = String.valueOf(zzbq.zzet());
            String valueOf2 = String.valueOf(zzbq.zzev());
            if (valueOf2.length() != 0) {
                concat = valueOf.concat(valueOf2);
            } else {
                str = new String(valueOf);
                concat = str;
            }
        } else {
            String valueOf3 = String.valueOf(zzbq.zzeu());
            String valueOf4 = String.valueOf(zzbq.zzev());
            if (valueOf4.length() != 0) {
                concat = valueOf3.concat(valueOf4);
            } else {
                str = new String(valueOf3);
                concat = str;
            }
        }
        try {
            return new URL(concat);
        } catch (MalformedURLException e2) {
            zze("Error trying to parse the hardcoded host url", e2);
            return null;
        }
    }

    private final URL a(zzcd zzcdVar, String str) {
        String sb;
        if (zzcdVar.zzfj()) {
            String zzet = zzbq.zzet();
            String zzev = zzbq.zzev();
            StringBuilder sb2 = new StringBuilder(String.valueOf(zzet).length() + 1 + String.valueOf(zzev).length() + String.valueOf(str).length());
            sb2.append(zzet);
            sb2.append(zzev);
            sb2.append("?");
            sb2.append(str);
            sb = sb2.toString();
        } else {
            String zzeu = zzbq.zzeu();
            String zzev2 = zzbq.zzev();
            StringBuilder sb3 = new StringBuilder(String.valueOf(zzeu).length() + 1 + String.valueOf(zzev2).length() + String.valueOf(str).length());
            sb3.append(zzeu);
            sb3.append(zzev2);
            sb3.append("?");
            sb3.append(str);
            sb = sb3.toString();
        }
        try {
            return new URL(sb);
        } catch (MalformedURLException e2) {
            zze("Error trying to parse the hardcoded host url", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final String a(zzcd zzcdVar, boolean z) {
        String valueOf;
        Preconditions.a(zzcdVar);
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : zzcdVar.zzdm().entrySet()) {
                String key = entry.getKey();
                if (!"ht".equals(key) && !"qt".equals(key) && !"AppUID".equals(key) && !"z".equals(key) && !"_gmsv".equals(key)) {
                    a(sb, key, entry.getValue());
                }
            }
            a(sb, "ht", String.valueOf(zzcdVar.zzfh()));
            a(sb, "qt", String.valueOf(zzcn().a() - zzcdVar.zzfh()));
            if (z) {
                long zzfk = zzcdVar.zzfk();
                if (zzfk != 0) {
                    valueOf = String.valueOf(zzfk);
                } else {
                    valueOf = String.valueOf(zzcdVar.zzfg());
                }
                a(sb, "z", valueOf);
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e2) {
            zze("Failed to encode name or value", e2);
            return null;
        }
    }

    private static void a(StringBuilder sb, String str, String str2) throws UnsupportedEncodingException {
        if (sb.length() != 0) {
            sb.append('&');
        }
        sb.append(URLEncoder.encode(str, "UTF-8"));
        sb.append('=');
        sb.append(URLEncoder.encode(str2, "UTF-8"));
    }
}
