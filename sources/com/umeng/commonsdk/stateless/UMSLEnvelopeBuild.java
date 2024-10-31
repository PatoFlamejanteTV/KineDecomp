package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.proguard.s;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class UMSLEnvelopeBuild {
    private static final String TAG = "UMSLEnvelopeBuild";
    private static String cacheSystemheader;
    private static boolean isEncryptEnabled;
    public static Context mContext;
    public static String module;

    private synchronized c constructEnvelope(Context context, byte[] bArr) {
        c a2;
        int i = -1;
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "slcodex", null);
        ULog.i("walle", "[stateless] build envelope, codexStr is " + imprintProperty);
        try {
            if (!TextUtils.isEmpty(imprintProperty)) {
                i = Integer.valueOf(imprintProperty).intValue();
            }
        } catch (NumberFormatException e2) {
            UMCrashManager.reportCrash(context, e2);
        }
        if (i == 0) {
            ULog.i("walle", "[stateless] build envelope, codexValue is 0");
            a2 = c.a(context, UMUtils.getAppkey(context), bArr);
        } else if (i == 1) {
            ULog.i("walle", "[stateless] build envelope, codexValue is 1");
            a2 = c.b(context, UMUtils.getAppkey(context), bArr);
        } else if (isEncryptEnabled) {
            ULog.i("walle", "[stateless] build envelope, isEncryptEnabled is true");
            a2 = c.b(context, UMUtils.getAppkey(context), bArr);
        } else {
            ULog.i("walle", "[stateless] build envelope, isEncryptEnabled is false");
            a2 = c.a(context, UMUtils.getAppkey(context), bArr);
        }
        return a2;
    }

    private synchronized JSONObject makeErrorResult(int i, JSONObject jSONObject) {
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

    public static void setEncryptEnabled(boolean z) {
        isEncryptEnabled = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x021e A[Catch: Exception -> 0x0223, Throwable -> 0x0294, all -> 0x02b8, TRY_LEAVE, TryCatch #5 {Throwable -> 0x0294, blocks: (B:11:0x002a, B:92:0x0032, B:41:0x01e2, B:43:0x01f4, B:50:0x0218, B:52:0x021e, B:58:0x0223, B:60:0x022f, B:63:0x0234, B:65:0x0238, B:67:0x023e, B:70:0x0247, B:72:0x0257, B:74:0x025d, B:13:0x003e, B:15:0x0090, B:16:0x009d, B:18:0x00a7, B:19:0x00ac, B:21:0x00b6, B:22:0x00bb, B:24:0x00c5, B:25:0x00ca, B:27:0x0128, B:28:0x0145, B:30:0x0189, B:31:0x01aa, B:33:0x01b4, B:34:0x01bb, B:36:0x01d1, B:37:0x01d8, B:86:0x0191, B:88:0x019b, B:89:0x01a3, B:90:0x0096), top: B:10:0x002a, outer: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized org.json.JSONObject buildSLBaseHeader(android.content.Context r10) {
        /*
            Method dump skipped, instructions count: 699
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.UMSLEnvelopeBuild.buildSLBaseHeader(android.content.Context):org.json.JSONObject");
    }

    public synchronized JSONObject buildSLEnvelope(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        c cVar;
        String str2;
        ULog.i("walle", "[stateless] build envelope, heade is " + jSONObject.toString());
        ULog.i("walle", "[stateless] build envelope, body is " + jSONObject2.toString());
        ULog.i("walle", "[stateless] build envelope, thread is " + Thread.currentThread());
        if (context != null && jSONObject != null && jSONObject2 != null && str != null) {
            try {
                Context applicationContext = context.getApplicationContext();
                if (jSONObject != null && jSONObject2 != null) {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (next != null && (next instanceof String) && (str2 = next) != null && jSONObject2.opt(str2) != null) {
                            try {
                                jSONObject.put(str2, jSONObject2.opt(str2));
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
                if (jSONObject != null) {
                    try {
                        com.umeng.commonsdk.statistics.idtracking.e a2 = com.umeng.commonsdk.statistics.idtracking.e.a(applicationContext);
                        if (a2 != null) {
                            a2.a();
                            String encodeToString = Base64.encodeToString(new s().a(a2.b()), 0);
                            if (!TextUtils.isEmpty(encodeToString)) {
                                JSONObject jSONObject3 = jSONObject.getJSONObject("header");
                                jSONObject3.put(com.umeng.commonsdk.proguard.e.V, encodeToString);
                                jSONObject.put("header", jSONObject3);
                            }
                        }
                    } catch (Exception unused2) {
                    }
                }
                if (jSONObject != null && f.a(jSONObject.toString().getBytes().length, a.f26305c)) {
                    ULog.i("walle", "[stateless] build envelope, json overstep!!!! size is " + jSONObject.toString().getBytes().length);
                    return makeErrorResult(113, jSONObject);
                }
                ULog.i("walle", "[stateless] build envelope, json size is " + jSONObject.toString().getBytes().length);
                if (jSONObject != null) {
                    cVar = constructEnvelope(applicationContext, jSONObject.toString().getBytes());
                    if (cVar == null) {
                        ULog.i("walle", "[stateless] build envelope, envelope is null !!!!");
                        return makeErrorResult(111, jSONObject);
                    }
                } else {
                    cVar = null;
                }
                if (cVar != null && f.a(cVar.b().length, a.f26306d)) {
                    ULog.i("walle", "[stateless] build envelope, envelope overstep!!!! size is " + cVar.b().length);
                    return makeErrorResult(114, jSONObject);
                }
                if (!f.a(applicationContext, Base64.encodeToString(str.getBytes(), 0), Base64.encodeToString((str + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + System.currentTimeMillis()).getBytes(), 0), cVar.b())) {
                    ULog.i("walle", "[stateless] build envelope, save fail ----->>>>>");
                    return makeErrorResult(101, jSONObject);
                }
                ULog.i("walle", "[stateless] build envelope, save ok ----->>>>>");
                ULog.i("walle", "[stateless] envelope file size is " + jSONObject.toString().getBytes().length);
                new d(applicationContext);
                d.b(d.f26335a);
                ULog.i("walle", "[stateless] build envelope end, thread is " + Thread.currentThread());
                return jSONObject;
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
                ULog.i("walle", "build envelope end, thread is " + Thread.currentThread());
                return makeErrorResult(110, null);
            }
        }
        ULog.i("walle", "[stateless] build envelope, context is null or header is null or body is null");
        return makeErrorResult(110, null);
    }
}
