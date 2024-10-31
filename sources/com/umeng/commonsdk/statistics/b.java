package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.proguard.e;
import com.umeng.commonsdk.proguard.s;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: EnvelopeManager.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f26354a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f26355b = "";

    /* renamed from: c, reason: collision with root package name */
    private static final String f26356c = "EnvelopeManager";

    /* renamed from: d, reason: collision with root package name */
    private static String f26357d;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f26358f;

    /* renamed from: e, reason: collision with root package name */
    private int f26359e = 0;

    public static long a(Context context) {
        long j = DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX - DataHelper.ENVELOPE_EXTRA_LENGTH;
        JSONObject b2 = b(context);
        if (b2 != null && b2.toString() != null && b2.toString().getBytes() != null) {
            long length = b2.toString().getBytes().length;
            if (ULog.DEBUG) {
                Log.i(f26356c, "headerLen size is " + length);
            }
            j -= length;
        }
        if (ULog.DEBUG) {
            Log.i(f26356c, "free size is " + j);
        }
        return j;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0226 A[Catch: Exception -> 0x022c, Throwable -> 0x0292, TRY_LEAVE, TryCatch #2 {Exception -> 0x022c, blocks: (B:46:0x01fc, B:53:0x0220, B:55:0x0226), top: B:45:0x01fc, outer: #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static org.json.JSONObject b(android.content.Context r14) {
        /*
            Method dump skipped, instructions count: 663
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.b.b(android.content.Context):org.json.JSONObject");
    }

    private JSONObject a(int i, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("exception", i);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("exception", i);
        } catch (Exception unused2) {
        }
        return jSONObject2;
    }

    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        String str;
        String str2;
        Envelope envelope;
        String str3;
        String str4;
        if (ULog.DEBUG && jSONObject != null && jSONObject2 != null) {
            Log.i(f26356c, "headerJSONObject size is " + jSONObject.toString().getBytes().length);
            Log.i(f26356c, "bodyJSONObject size is " + jSONObject2.toString().getBytes().length);
        }
        if (context != null && jSONObject2 != null) {
            try {
                JSONObject b2 = b(context);
                if (b2 != null && jSONObject != null) {
                    a(b2, jSONObject);
                }
                if (b2 != null && jSONObject2 != null) {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (next != null && (next instanceof String) && (str4 = next) != null && jSONObject2.opt(str4) != null) {
                            try {
                                b2.put(str4, jSONObject2.opt(str4));
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
                if (b2 != null) {
                    StringBuilder sb = new StringBuilder();
                    if (b2.length() > 0) {
                        if (b2.has("push")) {
                            String optString = b2.optJSONObject("header").optString(e.au);
                            if (!TextUtils.isEmpty("p") && !TextUtils.isEmpty(optString)) {
                                sb.append("p");
                                sb.append("==");
                                sb.append(optString);
                                sb.append("&=");
                            }
                        }
                        if (b2.has("share")) {
                            String optString2 = b2.optJSONObject("header").optString(e.av);
                            if (!TextUtils.isEmpty(e.ap) && !TextUtils.isEmpty(optString2)) {
                                sb.append(e.ap);
                                sb.append("==");
                                sb.append(optString2);
                                sb.append("&=");
                            }
                        }
                        if (b2.has("analytics")) {
                            if (b2.has("dplus")) {
                                str3 = e.an;
                            } else {
                                str3 = b2.optJSONObject("header").has("st") ? e.ar : e.al;
                            }
                            String optString3 = b2.optJSONObject("header").optString("sdk_version");
                            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(optString3)) {
                                sb.append(str3);
                                sb.append("==");
                                sb.append(optString3);
                                sb.append("&=");
                            }
                        }
                        if (b2.has("dplus")) {
                            String optString4 = b2.optJSONObject("header").optString("sdk_version");
                            if (b2.has("analytics")) {
                                if (!sb.toString().contains(e.an) && !TextUtils.isEmpty(e.an) && !TextUtils.isEmpty(optString4)) {
                                    sb.append(e.an);
                                    sb.append("==");
                                    sb.append(optString4);
                                    sb.append("&=");
                                }
                            } else if (!TextUtils.isEmpty(e.am) && !TextUtils.isEmpty(optString4)) {
                                sb.append(e.am);
                                sb.append("==");
                                sb.append(optString4);
                                sb.append("&=");
                            }
                        }
                        if (b2.has(e.ak)) {
                            String optString5 = b2.optJSONObject("header").optString(e.aw);
                            if (!TextUtils.isEmpty(e.aq) && !TextUtils.isEmpty(optString5)) {
                                sb.append(e.aq);
                                sb.append("==");
                                sb.append(optString5);
                                sb.append("&=");
                            }
                        }
                    }
                    str2 = sb.toString();
                    if (TextUtils.isEmpty(str2)) {
                        return a(101, b2);
                    }
                    if (str2.endsWith("&=")) {
                        str2 = str2.substring(0, str2.length() - 2);
                    }
                } else {
                    str2 = null;
                }
                if (b2 != null) {
                    try {
                        com.umeng.commonsdk.statistics.idtracking.e a2 = com.umeng.commonsdk.statistics.idtracking.e.a(context);
                        if (a2 != null) {
                            a2.a();
                            String encodeToString = Base64.encodeToString(new s().a(a2.b()), 0);
                            if (!TextUtils.isEmpty(encodeToString)) {
                                JSONObject jSONObject5 = b2.getJSONObject("header");
                                jSONObject5.put(e.V, encodeToString);
                                b2.put("header", jSONObject5);
                            }
                        }
                    } catch (Exception unused2) {
                    }
                }
                if (b2 != null && DataHelper.largeThanMaxSize(b2.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                    SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                    if (sharedPreferences != null) {
                        sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                    }
                    return a(113, b2);
                }
                if (b2 != null) {
                    envelope = a(context, b2.toString().getBytes());
                    if (envelope == null) {
                        return a(111, b2);
                    }
                } else {
                    envelope = null;
                }
                if (envelope != null && DataHelper.largeThanMaxSize(envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                    return a(114, b2);
                }
                int a3 = a(context, envelope, str2, b2 != null ? b2.optJSONObject("header").optString("app_version") : null);
                if (a3 != 0) {
                    return a(a3, b2);
                }
                if (ULog.DEBUG) {
                    Log.i(f26356c, "constructHeader size is " + b2.toString().getBytes().length);
                }
                return b2;
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
                if (jSONObject != null) {
                    try {
                        jSONObject3 = new JSONObject();
                    } catch (Exception e2) {
                        e = e2;
                        jSONObject3 = null;
                        UMCrashManager.reportCrash(context, e);
                        return a(110, jSONObject3);
                    }
                    try {
                        try {
                            jSONObject3.put("header", jSONObject);
                        } catch (JSONException unused3) {
                        }
                        jSONObject4 = jSONObject2;
                    } catch (Exception e3) {
                        e = e3;
                        UMCrashManager.reportCrash(context, e);
                        return a(110, jSONObject3);
                    }
                } else {
                    jSONObject4 = jSONObject2;
                    jSONObject3 = null;
                }
                if (jSONObject4 != null) {
                    if (jSONObject3 == null) {
                        jSONObject3 = new JSONObject();
                    }
                    if (jSONObject4 != null) {
                        Iterator<String> keys2 = jSONObject2.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            if (next2 != null && (next2 instanceof String) && (str = next2) != null && jSONObject4.opt(str) != null) {
                                try {
                                    jSONObject3.put(str, jSONObject4.opt(str));
                                } catch (Exception unused4) {
                                }
                            }
                        }
                    }
                }
                return a(110, jSONObject3);
            }
        }
        return a(110, (JSONObject) null);
    }

    private JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        String str;
        if (jSONObject != null && jSONObject2 != null && jSONObject.opt("header") != null && (jSONObject.opt("header") instanceof JSONObject)) {
            JSONObject jSONObject3 = (JSONObject) jSONObject.opt("header");
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next != null && (next instanceof String) && (str = next) != null && jSONObject2.opt(str) != null) {
                    try {
                        jSONObject3.put(str, jSONObject2.opt(str));
                        if (str.equals(com.umeng.analytics.pro.b.i) && (jSONObject2.opt(str) instanceof Integer)) {
                            this.f26359e = ((Integer) jSONObject2.opt(str)).intValue();
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return jSONObject;
    }

    private Envelope a(Context context, byte[] bArr) {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "codex", null);
        int i = -1;
        try {
            if (!TextUtils.isEmpty(imprintProperty)) {
                i = Integer.valueOf(imprintProperty).intValue();
            }
        } catch (NumberFormatException e2) {
            UMCrashManager.reportCrash(context, e2);
        }
        if (i == 0) {
            return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (i == 1) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (f26358f) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
    }

    private int a(Context context, Envelope envelope, String str, String str2) {
        if (context == null || envelope == null || TextUtils.isEmpty(str)) {
            return 101;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = DeviceConfig.getAppVersionName(context);
        }
        return UMFrUtils.saveEnvelopeFile(context, str + "&&" + str2 + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + System.currentTimeMillis() + "_envelope.log", envelope.toBinary());
    }

    public static void a(boolean z) {
        f26358f = z;
    }
}
