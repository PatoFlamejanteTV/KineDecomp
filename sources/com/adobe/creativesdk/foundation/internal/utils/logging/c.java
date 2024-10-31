package com.adobe.creativesdk.foundation.internal.utils.logging;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdobeLogger.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    public static File f6870a = null;

    /* renamed from: b */
    private static boolean f6871b = false;

    /* renamed from: c */
    private static boolean f6872c = false;

    /* renamed from: d */
    private static int f6873d = 0;

    /* renamed from: e */
    private static volatile int f6874e = 0;

    /* renamed from: f */
    private static volatile PrintWriter f6875f = null;

    /* renamed from: g */
    private static int f6876g = 1048576;

    /* renamed from: h */
    private static int f6877h = 3;
    private static int i = 2;
    private static final Object j = new Object();

    private static void c(String str, String str2, Throwable th) {
        if (f6872c) {
            Log.i(str, str2, th);
        }
        if (f6871b && f6873d == Level.INFO.getValue()) {
            e(str, str2, th);
        }
    }

    private static void d(String str, String str2, Throwable th) {
        if (f6872c) {
            Log.w(str, str2, th);
        }
        if (!f6871b || f6873d > Level.WARN.getValue()) {
            return;
        }
        e(str, str2, th);
    }

    private static void e(String str, String str2, Throwable th) {
        if (f6875f != null) {
            try {
                f6874e += str2 != null ? str2.getBytes().length : 0;
                if (f6874e > f6877h * f6876g) {
                    f6875f.close();
                    a(false);
                    f6874e = i * f6876g;
                }
                synchronized (j) {
                    PrintWriter printWriter = f6875f;
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(":");
                    if (str2 == null) {
                        str2 = "";
                    }
                    sb.append(str2);
                    sb.append("\n");
                    printWriter.append((CharSequence) sb.toString());
                    f6875f.flush();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static String b(String str, int i2) {
        String str2;
        try {
            byte[] g2 = org.apache.commons.io.b.g(new File(str));
            if (i2 > f6877h * f6876g) {
                byte[] bArr = new byte[i * f6876g];
                System.arraycopy(g2, i2 - (i * f6876g), bArr, 0, i * f6876g);
                str2 = new String(bArr, "UTF-8");
            } else {
                str2 = new String(g2, "UTF-8");
            }
            return str2;
        } catch (IOException e2) {
            Log.d("AdobeDCXUtils.fRead", e2.getMessage());
            return null;
        }
    }

    private static void a(boolean z) {
        new Thread(new a(z)).start();
    }

    public static void a(Level level, String str, String str2) {
        a(level, str, str2, null);
    }

    public static void a(Level level, String str, String str2, Throwable th) {
        if (f6872c || f6871b) {
            try {
                String substring = str.substring(str.lastIndexOf(".") + 1);
                if (substring.length() > 23) {
                    substring = substring.substring(0, 23);
                }
                int i2 = b.f6869a[level.ordinal()];
                if (i2 == 1) {
                    a(substring, str2, th);
                    return;
                }
                if (i2 == 2) {
                    c(substring, str2, th);
                } else if (i2 == 3) {
                    b(substring, str2, th);
                } else {
                    if (i2 != 4) {
                        return;
                    }
                    d(substring, str2, th);
                }
            } catch (Exception e2) {
                Log.e(c.class.getSimpleName(), e2.getMessage(), e2);
            }
        }
    }

    private static void b(String str, String str2, Throwable th) {
        if (f6872c) {
            Log.e(str, str2, th);
        }
        if (f6871b) {
            e(str, str2, th);
        }
    }

    private static void a(String str, String str2, Throwable th) {
        if (f6872c) {
            Log.d(str, str2, th);
        }
        if (!f6871b || f6873d > Level.DEBUG.getValue()) {
            return;
        }
        e(str, str2, th);
    }

    public static String a(JSONObject jSONObject) {
        String str;
        if (jSONObject == null || jSONObject.length() == 0) {
            return "Empty JSONObject";
        }
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                Object obj = jSONObject.get(next);
                if (obj.getClass().equals(JSONObject.class)) {
                    jSONObject2.put(next, a((JSONObject) obj));
                } else if (obj.getClass().equals(JSONArray.class)) {
                    jSONObject2.put(next, a((JSONArray) obj));
                } else if (obj.getClass().equals(String.class)) {
                    String str2 = (String) obj;
                    if (str2.length() == 0) {
                        str = "Empty String";
                    } else {
                        str = "Non-Empty String of length " + str2.length();
                    }
                    jSONObject2.put(next, str);
                } else if (obj.getClass().equals(Number.class)) {
                    jSONObject2.put(next, "Number");
                } else {
                    jSONObject2.put(next, "Object");
                }
            } catch (JSONException e2) {
                return e2.toString();
            }
        }
        return jSONObject2.toString();
    }

    public static String a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return "Empty JSONArray";
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                Object obj = jSONArray.get(i2);
                if (obj.getClass().equals(JSONObject.class)) {
                    jSONArray2.put(i2, a((JSONObject) obj));
                } else if (obj.getClass().equals(JSONArray.class)) {
                    jSONArray2.put(i2, a((JSONArray) obj));
                } else if (obj.getClass().equals(String.class)) {
                    String str = (String) obj;
                    jSONArray2.put(i2, str.length() == 0 ? "Empty String" : "Non-Empty String of length " + str.length());
                } else if (obj.getClass().equals(Number.class)) {
                    jSONArray2.put(i2, "Number");
                } else {
                    jSONArray2.put(i2, "Object");
                }
            } catch (JSONException e2) {
                return e2.toString();
            }
        }
        return jSONArray2.toString();
    }
}
