package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.commonsdk.internal.utils.a;
import com.umeng.commonsdk.statistics.common.ULog;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: InfoPreference.java */
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a */
    private static final String f26103a = "info";

    /* renamed from: b */
    private static final String f26104b = "a_na";

    /* renamed from: c */
    private static final String f26105c = "a_st";

    /* renamed from: d */
    private static final String f26106d = "a_ad";

    /* renamed from: e */
    private static final String f26107e = "blueinfo";

    /* renamed from: f */
    private static final String f26108f = "a_dc";

    /* renamed from: g */
    private static final String f26109g = "bssid";

    /* renamed from: h */
    private static final String f26110h = "ssid";
    private static final String i = "a_fcy";
    private static final String j = "a_hssid";
    private static final String k = "a_ip";
    private static final String l = "a_ls";
    private static final String m = "a_mac";
    private static final String n = "a_nid";
    private static final String o = "rssi";
    private static final String p = "sta";
    private static final String q = "ts";
    private static final String r = "wifiinfo";
    private static final String s = "ua";

    public static JSONObject a(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f26103a, 0);
        if (sharedPreferences == null) {
            return null;
        }
        try {
            String string = sharedPreferences.getString(f26107e, null);
            if (string != null) {
                return new JSONObject(string);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONArray b(Context context) {
        String string;
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f26103a, 0);
            if (sharedPreferences == null || (string = sharedPreferences.getString(r, null)) == null) {
                return null;
            }
            return new JSONArray(string);
        } catch (Exception e2) {
            ULog.e(e2.getMessage());
            return null;
        }
    }

    public static void c(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f26103a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove(r).commit();
        }
    }

    public static String d(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f26103a, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getString(s, null);
        }
        return null;
    }

    public static void a(Context context, Object obj) {
        if (obj != null) {
            try {
                a.b bVar = (a.b) obj;
                SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f26103a, 0);
                String str = null;
                if (sharedPreferences != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(f26104b, bVar.f26070c);
                    jSONObject.put(f26105c, bVar.f26069b);
                    jSONObject.put(f26106d, bVar.f26068a);
                    jSONObject.put("ts", System.currentTimeMillis());
                    str = jSONObject.toString();
                }
                if (str != null) {
                    sharedPreferences.edit().putString(f26107e, str).commit();
                }
            } catch (Exception e2) {
                ULog.e("saveBluetoothInfo:" + e2.getMessage());
            }
        }
    }

    public static void a(Context context, a.c cVar) {
        JSONArray jSONArray;
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f26103a, 0);
            String str = null;
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString(r, null);
                if (string == null) {
                    jSONArray = new JSONArray();
                } else {
                    jSONArray = new JSONArray(string);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(f26108f, cVar.f26071a);
                jSONObject.put(f26109g, cVar.f26072b);
                jSONObject.put(f26110h, cVar.f26073c);
                jSONObject.put(i, cVar.f26074d);
                jSONObject.put(j, cVar.f26075e);
                jSONObject.put(k, cVar.f26076f);
                jSONObject.put(l, cVar.f26077g);
                jSONObject.put(m, cVar.f26078h);
                jSONObject.put(n, cVar.i);
                jSONObject.put(o, cVar.j);
                jSONObject.put(p, cVar.k);
                jSONObject.put("ts", cVar.l);
                jSONArray.put(jSONObject);
                str = jSONArray.toString();
            }
            if (str != null) {
                sharedPreferences.edit().putString(r, str).commit();
            }
        } catch (Exception e2) {
            ULog.e(e2.getMessage());
        }
    }

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f26103a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(s, str).commit();
        }
    }
}
