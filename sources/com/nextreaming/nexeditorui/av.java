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

/* compiled from: KMConfigFile.java */
/* loaded from: classes.dex */
public class av {
    private String[] c;
    private String[] d;
    private String[] e;
    private String[] f;
    private String[] g;
    private String[] h;
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
    private Boolean u;
    private Boolean v;
    private Integer w;
    private String x;
    private static av b = null;

    /* renamed from: a, reason: collision with root package name */
    public static File f4530a = new File(Environment.getExternalStorageDirectory(), "kinemaster.cfg");

    public static av a() {
        if (b == null) {
            StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
            try {
                File file = f4530a;
                if (file.exists()) {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                        b = new av(bufferedReader);
                        bufferedReader.close();
                        Log.i("KMConfigFile", "Using config file");
                    } catch (IOException e) {
                        b = new av();
                    }
                } else {
                    b = new av();
                }
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        }
        return b;
    }

    private av() {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
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
    }

    private av(BufferedReader bufferedReader) throws IOException {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
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
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                if (sb.length() < 4096) {
                    sb.append("  ").append(readLine).append('\n');
                }
                if (!readLine.startsWith("#") && !readLine.startsWith(";") && readLine.contains("=")) {
                    String[] split = readLine.split("=", 2);
                    if (split.length >= 2) {
                        String trim = split[0].trim();
                        String trim2 = split[1].trim();
                        if (trim.length() >= 1) {
                            a(trim, trim2);
                        } else {
                            return;
                        }
                    } else {
                        continue;
                    }
                }
            } else {
                this.x = sb.toString();
                return;
            }
        }
    }

    private void a(String str, String str2) {
        if (str.equalsIgnoreCase("DEVICE_SUPPORT_SERVER_TIMEOUT")) {
            try {
                this.w = Integer.valueOf(Integer.parseInt(str2));
                return;
            } catch (NumberFormatException e) {
                return;
            }
        }
        if (str.equalsIgnoreCase("DEVICE_SUPPORT_SERVER_CACHE")) {
            if (str2.equalsIgnoreCase(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                this.u = true;
                return;
            } else {
                if (str2.equalsIgnoreCase("false")) {
                    this.u = false;
                    return;
                }
                return;
            }
        }
        if (str.equalsIgnoreCase("DEVICE_SUPPORT_LOCAL_ONLY")) {
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
            this.c = strArr;
            return;
        }
        if (str.equalsIgnoreCase("UPDATE_SERVER_URL")) {
            this.e = strArr;
            return;
        }
        if (str.equalsIgnoreCase("UPDATE_SERVER_PARAM")) {
            this.t = str2;
            return;
        }
        if (str.equalsIgnoreCase("USAGE_SERVER_URL")) {
            this.f = strArr;
            return;
        }
        if (str.equalsIgnoreCase("NOTIFY_SERVER_URL")) {
            this.g = strArr;
            return;
        }
        if (str.equalsIgnoreCase("DEVICE_SUPPORT_SERVER_URL")) {
            this.d = strArr;
            return;
        }
        if (str.equalsIgnoreCase("THEME_SERVER_URL")) {
            this.h = strArr;
            return;
        }
        if (str.equalsIgnoreCase("REGISTERIAP_SERVER_URL")) {
            this.i = strArr;
            return;
        }
        if (str.equalsIgnoreCase("AUTHPROMOCODE_SERVER_URL")) {
            this.j = strArr;
            return;
        }
        if (str.equalsIgnoreCase("GOOGLE_PRODUCT_LIST_SERVER_URL")) {
            this.k = strArr;
            return;
        }
        if (str.equalsIgnoreCase("STORE_TEST_URL") && strArr.length > 0 && strArr[0].trim().length() > 0) {
            this.s = strArr[0];
            return;
        }
        if (str.equalsIgnoreCase("CP_PRODUCT_LIST_SERVER_URL")) {
            this.l = strArr;
            return;
        }
        if (str.equalsIgnoreCase("CP_LOGIN_SERVER_URL")) {
            this.m = strArr;
        } else if (str.equalsIgnoreCase("CP_ORDER_ID_SERVER_URL")) {
            this.n = strArr;
        } else if (str.equalsIgnoreCase("CP_ORDER_LIST_SERVER_URL")) {
            this.o = strArr;
        }
    }

    public String b() {
        return this.x;
    }

    public String[] a(String[] strArr) {
        return this.c == null ? strArr : this.c;
    }

    public String[] b(String[] strArr) {
        return this.f == null ? strArr : this.f;
    }

    public String[] c(String[] strArr) {
        return this.g == null ? strArr : this.g;
    }

    public String[] d(String[] strArr) {
        return this.d == null ? strArr : this.d;
    }

    public String[] e(String[] strArr) {
        return this.h == null ? strArr : this.h;
    }

    public String[] f(String[] strArr) {
        return this.i == null ? strArr : this.i;
    }

    public String[] g(String[] strArr) {
        return this.j == null ? strArr : this.j;
    }

    public String[] h(String[] strArr) {
        return this.k == null ? strArr : this.k;
    }

    public String[] i(String[] strArr) {
        return this.l == null ? strArr : this.l;
    }

    public String[] j(String[] strArr) {
        return this.m == null ? strArr : this.m;
    }

    public String[] k(String[] strArr) {
        return this.n == null ? strArr : this.n;
    }

    public String[] l(String[] strArr) {
        return this.o == null ? strArr : this.o;
    }

    public int a(int i) {
        return this.w == null ? i : this.w.intValue();
    }

    public boolean a(boolean z) {
        return this.u == null ? z : this.u.booleanValue();
    }

    public boolean b(boolean z) {
        return this.v == null ? z : this.v.booleanValue();
    }

    public String c() {
        return this.s;
    }

    public boolean d() {
        return this.p;
    }

    public String e() {
        return this.r;
    }

    public boolean f() {
        return this.q;
    }
}
