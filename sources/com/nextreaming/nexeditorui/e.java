package com.nextreaming.nexeditorui;

import android.os.Environment;
import android.os.StrictMode;
import android.util.Log;
import com.facebook.internal.ServerProtocol;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: KMConfigFile.java */
/* loaded from: classes.dex */
public class E {

    /* renamed from: a, reason: collision with root package name */
    private static E f24012a;
    private String A;
    private Long B;
    private String C;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f24013b;

    /* renamed from: c, reason: collision with root package name */
    private String[] f24014c;

    /* renamed from: d, reason: collision with root package name */
    private String[] f24015d;

    /* renamed from: e, reason: collision with root package name */
    private String[] f24016e;

    /* renamed from: f, reason: collision with root package name */
    private String[] f24017f;

    /* renamed from: g, reason: collision with root package name */
    private String[] f24018g;

    /* renamed from: h, reason: collision with root package name */
    private String[] f24019h;
    private String[] i;
    private String[] j;
    private String[] k;
    private String[] l;
    private String[] m;
    private String[] n;
    private String[] o;
    private boolean p;
    private boolean q;
    private String r;
    private String s;
    private String t;
    private String u;
    private Boolean v;
    private Boolean w;
    private Integer x;
    private String y;
    private MessageDigest z;

    private E() {
        this.f24014c = null;
        this.f24015d = null;
        this.f24016e = null;
        this.f24017f = null;
        this.f24018g = null;
        this.f24019h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = false;
        this.q = false;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.f24013b = false;
    }

    private void a(String str) {
        MessageDigest messageDigest = this.z;
        if (messageDigest != null && this.A == null) {
            messageDigest.update(str.getBytes());
            return;
        }
        throw new IllegalStateException();
    }

    public static E c() {
        if (f24012a == null) {
            StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
            try {
                File file = new File(Environment.getExternalStorageDirectory(), "kinemaster.cfg");
                if (file.exists()) {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                        f24012a = new E(bufferedReader);
                        bufferedReader.close();
                        Log.i("KMConfigFile", "Using config file");
                    } catch (IOException unused) {
                        f24012a = new E();
                    }
                } else {
                    f24012a = new E();
                }
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        }
        return f24012a;
    }

    private void g() {
        if (this.z == null && this.A == null) {
            try {
                this.z = MessageDigest.getInstance("MD5");
                return;
            } catch (NoSuchAlgorithmException e2) {
                throw new IllegalStateException(e2);
            }
        }
        throw new IllegalStateException();
    }

    private void h() {
        MessageDigest messageDigest = this.z;
        if (messageDigest != null && this.A == null) {
            this.A = com.nexstreaming.app.general.util.J.b(messageDigest.digest());
            return;
        }
        throw new IllegalStateException();
    }

    public String[] b(String[] strArr) {
        String[] strArr2 = this.i;
        return strArr2 == null ? strArr : strArr2;
    }

    public boolean d() {
        return this.f24013b;
    }

    public String[] e(String[] strArr) {
        String[] strArr2 = this.l;
        return strArr2 == null ? strArr : strArr2;
    }

    public String[] f(String[] strArr) {
        String[] strArr2 = this.m;
        return strArr2 == null ? strArr : strArr2;
    }

    public String[] i(String[] strArr) {
        String[] strArr2 = this.f24017f;
        return strArr2 == null ? strArr : strArr2;
    }

    public boolean b(boolean z) {
        Boolean bool = this.v;
        return bool == null ? z : bool.booleanValue();
    }

    public String[] d(String[] strArr) {
        String[] strArr2 = this.o;
        return strArr2 == null ? strArr : strArr2;
    }

    public boolean e() {
        return this.p;
    }

    public boolean f() {
        return this.q;
    }

    public String b() {
        return this.r;
    }

    private void a(String str, String str2) {
        if (str.equalsIgnoreCase("@@S")) {
            this.C = str2;
            return;
        }
        a("\u001bK");
        a(str.toLowerCase());
        a("\u001bV");
        a(str2);
        a("\u001bX");
        if (str.equalsIgnoreCase("@@T")) {
            this.B = Long.valueOf(Long.parseLong(str2));
            return;
        }
        if (str.equalsIgnoreCase("DEVICE_SUPPORT_SERVER_TIMEOUT")) {
            try {
                this.x = Integer.valueOf(Integer.parseInt(str2));
                return;
            } catch (NumberFormatException unused) {
                return;
            }
        }
        if (str.equalsIgnoreCase("DEVICE_SUPPORT_SERVER_CACHE")) {
            if (str2.equalsIgnoreCase(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                this.v = true;
                return;
            } else {
                if (str2.equalsIgnoreCase("false")) {
                    this.v = false;
                    return;
                }
                return;
            }
        }
        if (str.equalsIgnoreCase("DEVICE_SUPPORT_LOCAL_ONLY")) {
            if (str2.equalsIgnoreCase(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                this.w = true;
                return;
            } else {
                if (str2.equalsIgnoreCase("false")) {
                    this.w = false;
                    return;
                }
                return;
            }
        }
        if (str.equalsIgnoreCase("USING_TEST_SKU")) {
            this.q = Boolean.parseBoolean(str2);
            return;
        }
        if (str.equalsIgnoreCase("INAPP_TEST")) {
            this.p = Boolean.parseBoolean(str2);
            return;
        }
        if (str.equalsIgnoreCase("INAPP_INSTALLER")) {
            this.r = str2;
            return;
        }
        String[] split = str2.split(";");
        int i = 0;
        for (int i2 = 0; i2 < split.length; i2++) {
            split[i2] = split[i2].trim();
            if (split[i2].length() > 0) {
                i++;
            }
        }
        String[] strArr = new String[i];
        int i3 = 0;
        for (String str3 : split) {
            if (str3.length() > 0) {
                strArr[i3] = split[i3];
                i3++;
            }
        }
        if (str.equalsIgnoreCase("REGISTER_SERVER_URL")) {
            this.f24014c = strArr;
            return;
        }
        if (str.equalsIgnoreCase("UPDATE_SERVER_URL")) {
            this.f24016e = strArr;
            return;
        }
        if (str.equalsIgnoreCase("UPDATE_SERVER_PARAM")) {
            this.u = str2;
            return;
        }
        if (str.equalsIgnoreCase("USAGE_SERVER_URL")) {
            this.f24017f = strArr;
            return;
        }
        if (str.equalsIgnoreCase("NOTIFY_SERVER_URL")) {
            this.f24018g = strArr;
            return;
        }
        if (str.equalsIgnoreCase("DEVICE_SUPPORT_SERVER_URL")) {
            this.f24015d = strArr;
            return;
        }
        if (str.equalsIgnoreCase("THEME_SERVER_URL")) {
            this.f24019h = strArr;
            return;
        }
        if (str.equalsIgnoreCase("AUTHPROMOCODE_SERVER_URL")) {
            this.i = strArr;
            return;
        }
        if (str.equalsIgnoreCase("GOOGLE_PRODUCT_LIST_SERVER_URL")) {
            this.j = strArr;
            return;
        }
        if (str.equalsIgnoreCase("STORE_TEST_URL") && strArr.length > 0 && strArr[0].trim().length() > 0) {
            this.s = strArr[0];
            return;
        }
        if (str.equalsIgnoreCase("CP_PRODUCT_LIST_SERVER_URL")) {
            this.k = strArr;
            return;
        }
        if (str.equalsIgnoreCase("CP_LOGIN_SERVER_URL")) {
            this.l = strArr;
            return;
        }
        if (str.equalsIgnoreCase("CP_ORDER_ID_SERVER_URL")) {
            this.n = strArr;
        } else if (str.equalsIgnoreCase("CP_ORDER_LIST_SERVER_URL")) {
            this.o = strArr;
        } else if (str.equalsIgnoreCase("STORE_SERVER_URL")) {
            this.t = strArr[0];
        }
    }

    public String[] h(String[] strArr) {
        String[] strArr2 = this.f24018g;
        return strArr2 == null ? strArr : strArr2;
    }

    public String[] g(String[] strArr) {
        String[] strArr2 = this.f24015d;
        return strArr2 == null ? strArr : strArr2;
    }

    public String[] c(String[] strArr) {
        String[] strArr2 = this.n;
        return strArr2 == null ? strArr : strArr2;
    }

    private E(BufferedReader bufferedReader) throws IOException {
        this.f24014c = null;
        this.f24015d = null;
        this.f24016e = null;
        this.f24017f = null;
        this.f24018g = null;
        this.f24019h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = false;
        this.q = false;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.f24013b = true;
        StringBuilder sb = new StringBuilder();
        g();
        a("ZZKMCONFIG");
        a(com.nexstreaming.app.general.util.N.b(KineMasterApplication.f24056d.getApplicationContext()));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                if (sb.length() < 4096) {
                    sb.append("  ");
                    sb.append(readLine);
                    sb.append('\n');
                }
                if (!readLine.startsWith("#") && !readLine.startsWith(";") && readLine.contains("=")) {
                    String[] split = readLine.split("=", 2);
                    if (split.length < 2) {
                        continue;
                    } else {
                        String trim = split[0].trim();
                        String trim2 = split[1].trim();
                        if (trim.length() < 1) {
                            return;
                        } else {
                            a(trim, trim2);
                        }
                    }
                }
            } else {
                this.y = sb.toString();
                h();
                if (this.A.equals(this.C)) {
                    if (this.B != null && System.currentTimeMillis() > this.B.longValue()) {
                        throw new IllegalStateException();
                    }
                    return;
                }
                throw new IllegalStateException();
            }
        }
    }

    public String a() {
        return this.y;
    }

    public String[] a(String[] strArr) {
        String[] strArr2 = this.k;
        return strArr2 == null ? strArr : strArr2;
    }

    public int a(int i) {
        Integer num = this.x;
        return num == null ? i : num.intValue();
    }

    public boolean a(boolean z) {
        Boolean bool = this.w;
        return bool == null ? z : bool.booleanValue();
    }
}
