package com.qq.e.comm.managers.plugin;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.net.NetworkCallBack;
import com.qq.e.comm.net.NetworkClient;
import com.qq.e.comm.net.NetworkClientImpl;
import com.qq.e.comm.net.rr.PlainRequest;
import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
import com.qq.e.comm.util.FileUtil;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import com.qq.e.comm.util.StringUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Executor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f24977a = Pattern.compile(".*plugin\\.dex-(\\d+)\\.jar.*");

    /* renamed from: b, reason: collision with root package name */
    private final Context f24978b;

    /* renamed from: c, reason: collision with root package name */
    private PM.a.b f24979c;

    /* renamed from: d, reason: collision with root package name */
    private Executor f24980d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements NetworkCallBack {

        /* renamed from: a, reason: collision with root package name */
        private final String f24981a;

        /* renamed from: b, reason: collision with root package name */
        private final int f24982b;

        public a(String str, int i) {
            this.f24981a = str;
            this.f24982b = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [com.qq.e.comm.net.rr.Response] */
        /* JADX WARN: Type inference failed for: r5v1 */
        /* JADX WARN: Type inference failed for: r5v2 */
        /* JADX WARN: Type inference failed for: r5v3 */
        /* JADX WARN: Type inference failed for: r5v4, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r5v5 */
        /* JADX WARN: Type inference failed for: r5v7 */
        /* JADX WARN: Type inference failed for: r5v8, types: [java.io.InputStream] */
        private static String a(Response response, File file) {
            OutputStream outputStream;
            FileOutputStream fileOutputStream;
            String str;
            InputStream inputStream;
            MessageDigest messageDigest;
            try {
                try {
                    messageDigest = MessageDigest.getInstance("MD5");
                    response = response.getStreamContent();
                    try {
                        fileOutputStream = new FileOutputStream(file);
                    } catch (IOException e2) {
                        e = e2;
                        fileOutputStream = null;
                    } catch (NoSuchAlgorithmException e3) {
                        e = e3;
                        fileOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        outputStream = null;
                        FileUtil.tryClose((InputStream) response);
                        FileUtil.tryClose(outputStream);
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                    response = 0;
                    fileOutputStream = null;
                } catch (NoSuchAlgorithmException e5) {
                    e = e5;
                    response = 0;
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    response = 0;
                    outputStream = null;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = response.read(bArr);
                        if (read <= 0) {
                            FileUtil.tryClose((InputStream) response);
                            FileUtil.tryClose(fileOutputStream);
                            String byteArrayToHexString = Md5Util.byteArrayToHexString(messageDigest.digest());
                            FileUtil.tryClose((InputStream) response);
                            FileUtil.tryClose(fileOutputStream);
                            return byteArrayToHexString;
                        }
                        messageDigest.update(bArr, 0, read);
                        fileOutputStream.write(bArr, 0, read);
                    }
                } catch (IOException e6) {
                    e = e6;
                    str = "IOException While Update Plugin";
                    inputStream = response;
                    GDTLogger.e(str, e);
                    FileUtil.tryClose(inputStream);
                    FileUtil.tryClose(fileOutputStream);
                    return null;
                } catch (NoSuchAlgorithmException e7) {
                    e = e7;
                    str = "MD5SUMException While Update Plugin";
                    inputStream = response;
                    GDTLogger.e(str, e);
                    FileUtil.tryClose(inputStream);
                    FileUtil.tryClose(fileOutputStream);
                    return null;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }

        private void a() {
            if (b.this.f24979c != null) {
                b.this.f24979c.b();
            }
        }

        private boolean a(File file) {
            try {
                StringUtil.writeTo(this.f24982b + "#####" + this.f24981a, file);
                return true;
            } catch (IOException e2) {
                GDTLogger.e("IOException While Update Plugin", e2);
                return false;
            }
        }

        @Override // com.qq.e.comm.net.NetworkCallBack
        public final void onException(Exception exc) {
            GDTLogger.w("Exception While Update Plugin", exc);
            a();
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0088 A[Catch: all -> 0x00b0, Throwable -> 0x00b2, TryCatch #1 {Throwable -> 0x00b2, blocks: (B:8:0x000e, B:10:0x0042, B:12:0x0048, B:14:0x0058, B:19:0x006f, B:21:0x0088, B:27:0x0092), top: B:7:0x000e, outer: #0 }] */
        @Override // com.qq.e.comm.net.NetworkCallBack
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void onResponse(com.qq.e.comm.net.rr.Request r7, com.qq.e.comm.net.rr.Response r8) {
            /*
                Method dump skipped, instructions count: 268
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.plugin.b.a.onResponse(com.qq.e.comm.net.rr.Request, com.qq.e.comm.net.rr.Response):void");
        }
    }

    public b(Context context, Executor executor) {
        this.f24978b = context.getApplicationContext();
        this.f24980d = executor;
    }

    public final void a(PM.a.b bVar) {
        this.f24979c = bVar;
    }

    public final void a(String str, String str2) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2)) {
            return;
        }
        Matcher matcher = f24977a.matcher(str2);
        boolean z = false;
        int parseInteger = StringUtil.parseInteger(matcher.matches() ? matcher.group(1) : AppEventsConstants.EVENT_PARAM_VALUE_NO, 0);
        if (parseInteger < 910) {
            GDTLogger.i("online plugin version is smaller than asset plugin version" + parseInteger + ",910.download give up");
        } else {
            z = true;
        }
        if (z) {
            GDTLogger.d("TIMESTAP_BEFORE_OWN_PLUGIN:" + System.nanoTime());
            NetworkClientImpl.getInstance().submit(new PlainRequest(str2, Request.Method.GET, (byte[]) null), NetworkClient.Priority.High, new a(str, parseInteger), this.f24980d);
        }
    }
}
