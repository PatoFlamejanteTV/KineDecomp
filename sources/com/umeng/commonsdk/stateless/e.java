package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* compiled from: UMSLNetWorkSenderHelper.java */
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private String f26344a = "10.0.0.172";

    /* renamed from: b, reason: collision with root package name */
    private int f26345b = 80;

    /* renamed from: c, reason: collision with root package name */
    private Context f26346c;

    public e(Context context) {
        this.f26346c = context;
    }

    private void a() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f26346c, "sl_domain_p", "");
        if (TextUtils.isEmpty(imprintProperty)) {
            return;
        }
        a.f26309g = DataHelper.assembleStatelessURL(imprintProperty);
    }

    private void b() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f26346c, "sl_domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f26346c, "oversea_sl_domain_p", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            a.f26308f = DataHelper.assembleStatelessURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            a.f26310h = DataHelper.assembleStatelessURL(imprintProperty2);
        }
        a.f26309g = a.f26310h;
        if (TextUtils.isEmpty(com.umeng.commonsdk.statistics.b.f26355b)) {
            return;
        }
        if (com.umeng.commonsdk.statistics.b.f26355b.startsWith("460") || com.umeng.commonsdk.statistics.b.f26355b.startsWith("461")) {
            a.f26309g = a.f26308f;
        }
    }

    private boolean c() {
        NetworkInfo activeNetworkInfo;
        String extraInfo;
        Context context = this.f26346c;
        if (context == null || context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.f26346c.getPackageName()) != 0) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f26346c.getSystemService("connectivity");
            if (DeviceConfig.checkPermission(this.f26346c, "android.permission.ACCESS_NETWORK_STATE") && connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.getType() != 1 && (extraInfo = activeNetworkInfo.getExtraInfo()) != null) {
                if (!extraInfo.equals("cmwap") && !extraInfo.equals("3gwap")) {
                    if (extraInfo.equals("uniwap")) {
                    }
                }
                return true;
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.f26346c, th);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.OutputStream, javax.net.ssl.HttpsURLConnection] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public boolean a(byte[] bArr, String str) {
        HttpsURLConnection httpsURLConnection;
        InputStream inputStream;
        boolean z = false;
        if (bArr != null && str != null) {
            if (SdkVersion.SDK_TYPE == 0) {
                a();
            } else {
                a.f26308f = a.f26310h;
                b();
            }
            ?? r2 = 0;
            r2 = 0;
            r2 = 0;
            r2 = 0;
            try {
                try {
                    try {
                        if (c()) {
                            httpsURLConnection = (HttpsURLConnection) new URL(a.f26309g + "/" + str).openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.f26344a, this.f26345b)));
                        } else {
                            httpsURLConnection = (HttpsURLConnection) new URL(a.f26309g + "/" + str).openConnection();
                        }
                    } catch (SSLHandshakeException e2) {
                        e = e2;
                        httpsURLConnection = null;
                    } catch (Throwable th) {
                        th = th;
                        if (0 != 0) {
                            try {
                                r2.close();
                            } catch (Exception unused) {
                            }
                        }
                        if (0 == 0) {
                            throw th;
                        }
                        try {
                            r2.getInputStream().close();
                        } catch (IOException unused2) {
                        }
                        r2.disconnect();
                        throw th;
                    }
                    try {
                        httpsURLConnection.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                        SSLContext sSLContext = SSLContext.getInstance("TLS");
                        sSLContext.init(null, null, new SecureRandom());
                        httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                        httpsURLConnection.setRequestProperty("X-Umeng-UTC", String.valueOf(System.currentTimeMillis()));
                        httpsURLConnection.setRequestProperty("Msg-Type", "envelope/json");
                        httpsURLConnection.setConnectTimeout(30000);
                        httpsURLConnection.setReadTimeout(30000);
                        httpsURLConnection.setRequestMethod("POST");
                        httpsURLConnection.setDoOutput(true);
                        httpsURLConnection.setDoInput(true);
                        httpsURLConnection.setUseCaches(false);
                        r2 = httpsURLConnection.getOutputStream();
                        r2.write(bArr);
                        r2.flush();
                        httpsURLConnection.connect();
                        if (httpsURLConnection.getResponseCode() == 200) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send stateless message success : " + a.f26309g + "/" + str);
                            z = true;
                        }
                        if (r2 != 0) {
                            try {
                                r2.close();
                            } catch (Exception unused3) {
                            }
                        }
                    } catch (SSLHandshakeException e3) {
                        e = e3;
                        MLog.e("SSLHandshakeException, Failed to send message.", e);
                        if (r2 != 0) {
                            try {
                                r2.close();
                            } catch (Exception unused4) {
                            }
                        }
                        if (httpsURLConnection != null) {
                            inputStream = httpsURLConnection.getInputStream();
                            inputStream.close();
                            httpsURLConnection.disconnect();
                        }
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        MLog.e("Exception,Failed to send message.", th);
                        if (r2 != 0) {
                            try {
                                r2.close();
                            } catch (Exception unused5) {
                            }
                        }
                        if (httpsURLConnection != null) {
                            inputStream = httpsURLConnection.getInputStream();
                            inputStream.close();
                            httpsURLConnection.disconnect();
                        }
                        return z;
                    }
                } catch (IOException unused6) {
                }
                if (httpsURLConnection != null) {
                    inputStream = httpsURLConnection.getInputStream();
                    inputStream.close();
                    httpsURLConnection.disconnect();
                }
                return z;
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            ULog.i("walle", "[stateless] sendMessage, envelopeByte == null || path == null ");
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x00a7, code lost:            if (r10 == null) goto L35;     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00a9, code lost:            r10.disconnect();     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00c3, code lost:            return r0;     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c0, code lost:            if (r10 == null) goto L35;     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b(byte[] r9, java.lang.String r10) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto Ld2
            if (r10 != 0) goto L7
            goto Ld2
        L7:
            r1 = 0
            boolean r2 = r8.c()     // Catch: java.lang.Throwable -> Laf java.lang.Throwable -> Lb2
            java.lang.String r3 = "/"
            if (r2 == 0) goto L40
            java.net.Proxy r2 = new java.net.Proxy     // Catch: java.lang.Throwable -> Laf java.lang.Throwable -> Lb2
            java.net.Proxy$Type r4 = java.net.Proxy.Type.HTTP     // Catch: java.lang.Throwable -> Laf java.lang.Throwable -> Lb2
            java.net.InetSocketAddress r5 = new java.net.InetSocketAddress     // Catch: java.lang.Throwable -> Laf java.lang.Throwable -> Lb2
            java.lang.String r6 = r8.f26344a     // Catch: java.lang.Throwable -> Laf java.lang.Throwable -> Lb2
            int r7 = r8.f26345b     // Catch: java.lang.Throwable -> Laf java.lang.Throwable -> Lb2
            r5.<init>(r6, r7)     // Catch: java.lang.Throwable -> Laf java.lang.Throwable -> Lb2
            r2.<init>(r4, r5)     // Catch: java.lang.Throwable -> Laf java.lang.Throwable -> Lb2
            java.net.URL r4 = new java.net.URL     // Catch: java.lang.Throwable -> Laf java.lang.Throwable -> Lb2
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Laf java.lang.Throwable -> Lb2
            r5.<init>()     // Catch: java.lang.Throwable -> Laf java.lang.Throwable -> Lb2
            java.lang.String r6 = com.umeng.commonsdk.stateless.a.f26309g     // Catch: java.lang.Throwable -> Laf java.lang.Throwable -> Lb2
            r5.append(r6)     // Catch: java.lang.Throwable -> Laf java.lang.Throwable -> Lb2
            r5.append(r3)     // Catch: java.lang.Throwable -> Laf java.lang.Throwable -> Lb2
            r5.append(r10)     // Catch: java.lang.Throwable -> Laf java.lang.Throwable -> Lb2
            java.lang.String r10 = r5.toString()     // Catch: java.lang.Throwable -> Laf java.lang.Throwable -> Lb2
            r4.<init>(r10)     // Catch: java.lang.Throwable -> Laf java.lang.Throwable -> Lb2
            java.net.URLConnection r10 = r4.openConnection(r2)     // Catch: java.lang.Throwable -> Laf java.lang.Throwable -> Lb2
            java.net.HttpURLConnection r10 = (java.net.HttpURLConnection) r10     // Catch: java.lang.Throwable -> Laf java.lang.Throwable -> Lb2
            goto L5f
        L40:
            java.net.URL r2 = new java.net.URL     // Catch: java.lang.Throwable -> Laf java.lang.Throwable -> Lb2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Laf java.lang.Throwable -> Lb2
            r4.<init>()     // Catch: java.lang.Throwable -> Laf java.lang.Throwable -> Lb2
            java.lang.String r5 = com.umeng.commonsdk.stateless.a.f26309g     // Catch: java.lang.Throwable -> Laf java.lang.Throwable -> Lb2
            r4.append(r5)     // Catch: java.lang.Throwable -> Laf java.lang.Throwable -> Lb2
            r4.append(r3)     // Catch: java.lang.Throwable -> Laf java.lang.Throwable -> Lb2
            r4.append(r10)     // Catch: java.lang.Throwable -> Laf java.lang.Throwable -> Lb2
            java.lang.String r10 = r4.toString()     // Catch: java.lang.Throwable -> Laf java.lang.Throwable -> Lb2
            r2.<init>(r10)     // Catch: java.lang.Throwable -> Laf java.lang.Throwable -> Lb2
            java.net.URLConnection r10 = r2.openConnection()     // Catch: java.lang.Throwable -> Laf java.lang.Throwable -> Lb2
            java.net.HttpURLConnection r10 = (java.net.HttpURLConnection) r10     // Catch: java.lang.Throwable -> Laf java.lang.Throwable -> Lb2
        L5f:
            java.lang.String r2 = "X-Umeng-UTC"
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lad java.lang.Throwable -> Lc4
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> Lad java.lang.Throwable -> Lc4
            r10.setRequestProperty(r2, r3)     // Catch: java.lang.Throwable -> Lad java.lang.Throwable -> Lc4
            java.lang.String r2 = "Msg-Type"
            java.lang.String r3 = "envelope/json"
            r10.setRequestProperty(r2, r3)     // Catch: java.lang.Throwable -> Lad java.lang.Throwable -> Lc4
            r2 = 30000(0x7530, float:4.2039E-41)
            r10.setConnectTimeout(r2)     // Catch: java.lang.Throwable -> Lad java.lang.Throwable -> Lc4
            r10.setReadTimeout(r2)     // Catch: java.lang.Throwable -> Lad java.lang.Throwable -> Lc4
            java.lang.String r2 = "POST"
            r10.setRequestMethod(r2)     // Catch: java.lang.Throwable -> Lad java.lang.Throwable -> Lc4
            r2 = 1
            r10.setDoOutput(r2)     // Catch: java.lang.Throwable -> Lad java.lang.Throwable -> Lc4
            r10.setDoInput(r2)     // Catch: java.lang.Throwable -> Lad java.lang.Throwable -> Lc4
            r10.setUseCaches(r0)     // Catch: java.lang.Throwable -> Lad java.lang.Throwable -> Lc4
            java.io.OutputStream r1 = r10.getOutputStream()     // Catch: java.lang.Throwable -> Lad java.lang.Throwable -> Lc4
            r1.write(r9)     // Catch: java.lang.Throwable -> Lad java.lang.Throwable -> Lc4
            r1.flush()     // Catch: java.lang.Throwable -> Lad java.lang.Throwable -> Lc4
            r10.connect()     // Catch: java.lang.Throwable -> Lad java.lang.Throwable -> Lc4
            int r9 = r10.getResponseCode()     // Catch: java.lang.Throwable -> Lad java.lang.Throwable -> Lc4
            r3 = 200(0xc8, float:2.8E-43)
            if (r9 != r3) goto La0
            r0 = 1
        La0:
            if (r1 == 0) goto La7
            r1.close()     // Catch: java.lang.Exception -> La6
            goto La7
        La6:
        La7:
            if (r10 == 0) goto Lc3
        La9:
            r10.disconnect()
            goto Lc3
        Lad:
            r9 = move-exception
            goto Lb4
        Laf:
            r9 = move-exception
            r10 = r1
            goto Lc5
        Lb2:
            r9 = move-exception
            r10 = r1
        Lb4:
            android.content.Context r2 = r8.f26346c     // Catch: java.lang.Throwable -> Lc4
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r2, r9)     // Catch: java.lang.Throwable -> Lc4
            if (r1 == 0) goto Lc0
            r1.close()     // Catch: java.lang.Exception -> Lbf
            goto Lc0
        Lbf:
        Lc0:
            if (r10 == 0) goto Lc3
            goto La9
        Lc3:
            return r0
        Lc4:
            r9 = move-exception
        Lc5:
            if (r1 == 0) goto Lcc
            r1.close()     // Catch: java.lang.Exception -> Lcb
            goto Lcc
        Lcb:
        Lcc:
            if (r10 == 0) goto Ld1
            r10.disconnect()
        Ld1:
            throw r9
        Ld2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.e.b(byte[], java.lang.String):boolean");
    }
}
