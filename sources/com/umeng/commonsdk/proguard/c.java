package com.umeng.commonsdk.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.text.TextUtils;
import com.umeng.commonsdk.statistics.common.ULog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UMSysLocationCache.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a */
    public static final String f26224a = "lng";

    /* renamed from: b */
    public static final String f26225b = "lat";

    /* renamed from: c */
    public static final String f26226c = "ts";

    /* renamed from: d */
    public static final long f26227d = 30000;

    /* renamed from: e */
    public static final int f26228e = 200;

    /* renamed from: f */
    private static final String f26229f = "UMSysLocationCache";

    /* renamed from: g */
    private static boolean f26230g = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UMSysLocationCache.java */
    /* renamed from: com.umeng.commonsdk.proguard.c$1 */
    /* loaded from: classes3.dex */
    public static class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f26231a;

        /* compiled from: UMSysLocationCache.java */
        /* renamed from: com.umeng.commonsdk.proguard.c$1$1 */
        /* loaded from: classes3.dex */
        class C01421 extends d {

            /* renamed from: a */
            final /* synthetic */ b f26232a;

            C01421(b bVar) {
                bVar = bVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r2v11 */
            /* JADX WARN: Type inference failed for: r2v12 */
            /* JADX WARN: Type inference failed for: r2v4 */
            /* JADX WARN: Type inference failed for: r2v8 */
            @Override // com.umeng.commonsdk.proguard.d
            public void a(Location location) {
                int i;
                ?? r2 = com.umeng.commonsdk.internal.a.s;
                if (location != null) {
                    try {
                        double longitude = location.getLongitude();
                        double latitude = location.getLatitude();
                        float accuracy = location.getAccuracy();
                        double altitude = location.getAltitude();
                        ULog.i(c.f26229f, "lon is " + longitude + ", lat is " + latitude + ", acc is " + accuracy + ", alt is " + altitude);
                        if (longitude != 0.0d && latitude != 0.0d) {
                            long time = location.getTime();
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("lng", longitude);
                                jSONObject.put("lat", latitude);
                                jSONObject.put("ts", time);
                                jSONObject.put("acc", accuracy);
                                jSONObject.put("alt", altitude);
                            } catch (JSONException e2) {
                                ULog.i(c.f26229f, "e is " + e2);
                            }
                            ULog.i(c.f26229f, "locationJSONObject is " + jSONObject.toString());
                            SharedPreferences sharedPreferences = context.getSharedPreferences(com.umeng.commonsdk.internal.a.p, 0);
                            if (sharedPreferences != null) {
                                String string = sharedPreferences.getString(com.umeng.commonsdk.internal.a.r, "");
                                String string2 = sharedPreferences.getString(com.umeng.commonsdk.internal.a.s, "");
                                ULog.i(c.f26229f, "--->>> get lon is " + string + ", lat is " + string2);
                                try {
                                    if (!TextUtils.isEmpty(string) && Double.parseDouble(string) == longitude && !TextUtils.isEmpty(string2) && Double.parseDouble(string2) == latitude) {
                                        Object[] objArr = new Object[1];
                                        objArr[0] = "location same";
                                        ULog.i(c.f26229f, objArr);
                                        r2 = "location same";
                                    } else {
                                        JSONArray b2 = c.b(context);
                                        if (b2 == null) {
                                            b2 = new JSONArray();
                                        }
                                        b2.put(jSONObject);
                                        SharedPreferences.Editor edit = sharedPreferences.edit();
                                        edit.putString(com.umeng.commonsdk.internal.a.r, String.valueOf(longitude));
                                        edit.putString(com.umeng.commonsdk.internal.a.s, String.valueOf(latitude));
                                        edit.putString(com.umeng.commonsdk.internal.a.q, b2.toString());
                                        edit.commit();
                                        Object[] objArr2 = new Object[1];
                                        objArr2[0] = "location put is ok~~";
                                        ULog.i(c.f26229f, objArr2);
                                        r2 = "location put is ok~~";
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    i = r2;
                                    Object[] objArr3 = new Object[i];
                                    objArr3[0] = "" + th.getMessage();
                                    ULog.i(c.f26229f, objArr3);
                                    bVar.a();
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i = 1;
                    }
                }
                bVar.a();
            }
        }

        AnonymousClass1(Context context) {
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            while (c.f26230g) {
                try {
                    try {
                        JSONArray b2 = c.b(context);
                        if (b2 != null && b2.length() >= 200) {
                            boolean unused = c.f26230g = false;
                            return;
                        }
                        ULog.i(c.f26229f, "location status is ok, time is " + System.currentTimeMillis());
                        b bVar = new b(context);
                        bVar.a(new d() { // from class: com.umeng.commonsdk.proguard.c.1.1

                            /* renamed from: a */
                            final /* synthetic */ b f26232a;

                            C01421(b bVar2) {
                                bVar = bVar2;
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
                            /* JADX WARN: Type inference failed for: r2v11 */
                            /* JADX WARN: Type inference failed for: r2v12 */
                            /* JADX WARN: Type inference failed for: r2v4 */
                            /* JADX WARN: Type inference failed for: r2v8 */
                            @Override // com.umeng.commonsdk.proguard.d
                            public void a(Location location) {
                                int i;
                                ?? r2 = com.umeng.commonsdk.internal.a.s;
                                if (location != null) {
                                    try {
                                        double longitude = location.getLongitude();
                                        double latitude = location.getLatitude();
                                        float accuracy = location.getAccuracy();
                                        double altitude = location.getAltitude();
                                        ULog.i(c.f26229f, "lon is " + longitude + ", lat is " + latitude + ", acc is " + accuracy + ", alt is " + altitude);
                                        if (longitude != 0.0d && latitude != 0.0d) {
                                            long time = location.getTime();
                                            JSONObject jSONObject = new JSONObject();
                                            try {
                                                jSONObject.put("lng", longitude);
                                                jSONObject.put("lat", latitude);
                                                jSONObject.put("ts", time);
                                                jSONObject.put("acc", accuracy);
                                                jSONObject.put("alt", altitude);
                                            } catch (JSONException e2) {
                                                ULog.i(c.f26229f, "e is " + e2);
                                            }
                                            ULog.i(c.f26229f, "locationJSONObject is " + jSONObject.toString());
                                            SharedPreferences sharedPreferences = context.getSharedPreferences(com.umeng.commonsdk.internal.a.p, 0);
                                            if (sharedPreferences != null) {
                                                String string = sharedPreferences.getString(com.umeng.commonsdk.internal.a.r, "");
                                                String string2 = sharedPreferences.getString(com.umeng.commonsdk.internal.a.s, "");
                                                ULog.i(c.f26229f, "--->>> get lon is " + string + ", lat is " + string2);
                                                try {
                                                    if (!TextUtils.isEmpty(string) && Double.parseDouble(string) == longitude && !TextUtils.isEmpty(string2) && Double.parseDouble(string2) == latitude) {
                                                        Object[] objArr = new Object[1];
                                                        objArr[0] = "location same";
                                                        ULog.i(c.f26229f, objArr);
                                                        r2 = "location same";
                                                    } else {
                                                        JSONArray b22 = c.b(context);
                                                        if (b22 == null) {
                                                            b22 = new JSONArray();
                                                        }
                                                        b22.put(jSONObject);
                                                        SharedPreferences.Editor edit = sharedPreferences.edit();
                                                        edit.putString(com.umeng.commonsdk.internal.a.r, String.valueOf(longitude));
                                                        edit.putString(com.umeng.commonsdk.internal.a.s, String.valueOf(latitude));
                                                        edit.putString(com.umeng.commonsdk.internal.a.q, b22.toString());
                                                        edit.commit();
                                                        Object[] objArr2 = new Object[1];
                                                        objArr2[0] = "location put is ok~~";
                                                        ULog.i(c.f26229f, objArr2);
                                                        r2 = "location put is ok~~";
                                                    }
                                                } catch (Throwable th) {
                                                    th = th;
                                                    i = r2;
                                                    Object[] objArr3 = new Object[i];
                                                    objArr3[0] = "" + th.getMessage();
                                                    ULog.i(c.f26229f, objArr3);
                                                    bVar.a();
                                                }
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        i = 1;
                                    }
                                }
                                bVar.a();
                            }
                        });
                        try {
                            Thread.sleep(c.f26227d);
                        } catch (Exception unused2) {
                        }
                    } catch (Throwable unused3) {
                        boolean unused4 = c.f26230g = false;
                        return;
                    }
                } catch (Throwable unused5) {
                    return;
                }
            }
        }
    }

    public static JSONArray b(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(com.umeng.commonsdk.internal.a.p, 0);
        JSONArray jSONArray = null;
        if (sharedPreferences == null) {
            return null;
        }
        try {
            String string = sharedPreferences.getString(com.umeng.commonsdk.internal.a.q, "");
            if (!TextUtils.isEmpty(string)) {
                jSONArray = new JSONArray(string);
            }
        } catch (JSONException e2) {
            ULog.i(f26229f, "e is " + e2);
        } catch (Throwable th) {
            ULog.i(f26229f, "e is " + th);
        }
        if (jSONArray != null) {
            ULog.i(f26229f, "get json str is " + jSONArray.toString());
        }
        return jSONArray;
    }

    public static void c(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(com.umeng.commonsdk.internal.a.p, 0);
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(com.umeng.commonsdk.internal.a.q, "");
                edit.commit();
                ULog.i(f26229f, "delete is ok~~");
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context) {
        ULog.i(f26229f, "begin location");
        if (context == null) {
            return;
        }
        try {
            new Thread(new Runnable() { // from class: com.umeng.commonsdk.proguard.c.1

                /* renamed from: a */
                final /* synthetic */ Context f26231a;

                /* compiled from: UMSysLocationCache.java */
                /* renamed from: com.umeng.commonsdk.proguard.c$1$1 */
                /* loaded from: classes3.dex */
                class C01421 extends d {

                    /* renamed from: a */
                    final /* synthetic */ b f26232a;

                    C01421(b bVar2) {
                        bVar = bVar2;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
                    /* JADX WARN: Type inference failed for: r2v11 */
                    /* JADX WARN: Type inference failed for: r2v12 */
                    /* JADX WARN: Type inference failed for: r2v4 */
                    /* JADX WARN: Type inference failed for: r2v8 */
                    @Override // com.umeng.commonsdk.proguard.d
                    public void a(Location location) {
                        int i;
                        ?? r2 = com.umeng.commonsdk.internal.a.s;
                        if (location != null) {
                            try {
                                double longitude = location.getLongitude();
                                double latitude = location.getLatitude();
                                float accuracy = location.getAccuracy();
                                double altitude = location.getAltitude();
                                ULog.i(c.f26229f, "lon is " + longitude + ", lat is " + latitude + ", acc is " + accuracy + ", alt is " + altitude);
                                if (longitude != 0.0d && latitude != 0.0d) {
                                    long time = location.getTime();
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("lng", longitude);
                                        jSONObject.put("lat", latitude);
                                        jSONObject.put("ts", time);
                                        jSONObject.put("acc", accuracy);
                                        jSONObject.put("alt", altitude);
                                    } catch (JSONException e2) {
                                        ULog.i(c.f26229f, "e is " + e2);
                                    }
                                    ULog.i(c.f26229f, "locationJSONObject is " + jSONObject.toString());
                                    SharedPreferences sharedPreferences = context.getSharedPreferences(com.umeng.commonsdk.internal.a.p, 0);
                                    if (sharedPreferences != null) {
                                        String string = sharedPreferences.getString(com.umeng.commonsdk.internal.a.r, "");
                                        String string2 = sharedPreferences.getString(com.umeng.commonsdk.internal.a.s, "");
                                        ULog.i(c.f26229f, "--->>> get lon is " + string + ", lat is " + string2);
                                        try {
                                            if (!TextUtils.isEmpty(string) && Double.parseDouble(string) == longitude && !TextUtils.isEmpty(string2) && Double.parseDouble(string2) == latitude) {
                                                Object[] objArr = new Object[1];
                                                objArr[0] = "location same";
                                                ULog.i(c.f26229f, objArr);
                                                r2 = "location same";
                                            } else {
                                                JSONArray b22 = c.b(context);
                                                if (b22 == null) {
                                                    b22 = new JSONArray();
                                                }
                                                b22.put(jSONObject);
                                                SharedPreferences.Editor edit = sharedPreferences.edit();
                                                edit.putString(com.umeng.commonsdk.internal.a.r, String.valueOf(longitude));
                                                edit.putString(com.umeng.commonsdk.internal.a.s, String.valueOf(latitude));
                                                edit.putString(com.umeng.commonsdk.internal.a.q, b22.toString());
                                                edit.commit();
                                                Object[] objArr2 = new Object[1];
                                                objArr2[0] = "location put is ok~~";
                                                ULog.i(c.f26229f, objArr2);
                                                r2 = "location put is ok~~";
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            i = r2;
                                            Object[] objArr3 = new Object[i];
                                            objArr3[0] = "" + th.getMessage();
                                            ULog.i(c.f26229f, objArr3);
                                            bVar.a();
                                        }
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                i = 1;
                            }
                        }
                        bVar.a();
                    }
                }

                AnonymousClass1(Context context2) {
                    context = context2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    while (c.f26230g) {
                        try {
                            try {
                                JSONArray b2 = c.b(context);
                                if (b2 != null && b2.length() >= 200) {
                                    boolean unused = c.f26230g = false;
                                    return;
                                }
                                ULog.i(c.f26229f, "location status is ok, time is " + System.currentTimeMillis());
                                b bVar2 = new b(context);
                                bVar2.a(new d() { // from class: com.umeng.commonsdk.proguard.c.1.1

                                    /* renamed from: a */
                                    final /* synthetic */ b f26232a;

                                    C01421(b bVar22) {
                                        bVar = bVar22;
                                    }

                                    /* JADX WARN: Multi-variable type inference failed */
                                    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
                                    /* JADX WARN: Type inference failed for: r2v11 */
                                    /* JADX WARN: Type inference failed for: r2v12 */
                                    /* JADX WARN: Type inference failed for: r2v4 */
                                    /* JADX WARN: Type inference failed for: r2v8 */
                                    @Override // com.umeng.commonsdk.proguard.d
                                    public void a(Location location) {
                                        int i;
                                        ?? r2 = com.umeng.commonsdk.internal.a.s;
                                        if (location != null) {
                                            try {
                                                double longitude = location.getLongitude();
                                                double latitude = location.getLatitude();
                                                float accuracy = location.getAccuracy();
                                                double altitude = location.getAltitude();
                                                ULog.i(c.f26229f, "lon is " + longitude + ", lat is " + latitude + ", acc is " + accuracy + ", alt is " + altitude);
                                                if (longitude != 0.0d && latitude != 0.0d) {
                                                    long time = location.getTime();
                                                    JSONObject jSONObject = new JSONObject();
                                                    try {
                                                        jSONObject.put("lng", longitude);
                                                        jSONObject.put("lat", latitude);
                                                        jSONObject.put("ts", time);
                                                        jSONObject.put("acc", accuracy);
                                                        jSONObject.put("alt", altitude);
                                                    } catch (JSONException e2) {
                                                        ULog.i(c.f26229f, "e is " + e2);
                                                    }
                                                    ULog.i(c.f26229f, "locationJSONObject is " + jSONObject.toString());
                                                    SharedPreferences sharedPreferences = context.getSharedPreferences(com.umeng.commonsdk.internal.a.p, 0);
                                                    if (sharedPreferences != null) {
                                                        String string = sharedPreferences.getString(com.umeng.commonsdk.internal.a.r, "");
                                                        String string2 = sharedPreferences.getString(com.umeng.commonsdk.internal.a.s, "");
                                                        ULog.i(c.f26229f, "--->>> get lon is " + string + ", lat is " + string2);
                                                        try {
                                                            if (!TextUtils.isEmpty(string) && Double.parseDouble(string) == longitude && !TextUtils.isEmpty(string2) && Double.parseDouble(string2) == latitude) {
                                                                Object[] objArr = new Object[1];
                                                                objArr[0] = "location same";
                                                                ULog.i(c.f26229f, objArr);
                                                                r2 = "location same";
                                                            } else {
                                                                JSONArray b22 = c.b(context);
                                                                if (b22 == null) {
                                                                    b22 = new JSONArray();
                                                                }
                                                                b22.put(jSONObject);
                                                                SharedPreferences.Editor edit = sharedPreferences.edit();
                                                                edit.putString(com.umeng.commonsdk.internal.a.r, String.valueOf(longitude));
                                                                edit.putString(com.umeng.commonsdk.internal.a.s, String.valueOf(latitude));
                                                                edit.putString(com.umeng.commonsdk.internal.a.q, b22.toString());
                                                                edit.commit();
                                                                Object[] objArr2 = new Object[1];
                                                                objArr2[0] = "location put is ok~~";
                                                                ULog.i(c.f26229f, objArr2);
                                                                r2 = "location put is ok~~";
                                                            }
                                                        } catch (Throwable th) {
                                                            th = th;
                                                            i = r2;
                                                            Object[] objArr3 = new Object[i];
                                                            objArr3[0] = "" + th.getMessage();
                                                            ULog.i(c.f26229f, objArr3);
                                                            bVar.a();
                                                        }
                                                    }
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                i = 1;
                                            }
                                        }
                                        bVar.a();
                                    }
                                });
                                try {
                                    Thread.sleep(c.f26227d);
                                } catch (Exception unused2) {
                                }
                            } catch (Throwable unused3) {
                                boolean unused4 = c.f26230g = false;
                                return;
                            }
                        } catch (Throwable unused5) {
                            return;
                        }
                    }
                }
            }).start();
        } catch (Exception unused) {
        }
    }
}
