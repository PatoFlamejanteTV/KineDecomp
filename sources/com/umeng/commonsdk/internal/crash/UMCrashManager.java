package com.umeng.commonsdk.internal.crash;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.commonsdk.stateless.UMSLEnvelopeBuild;
import com.umeng.commonsdk.stateless.f;
import com.umeng.commonsdk.statistics.common.ULog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class UMCrashManager {
    private static boolean isReportCrash = false;
    private static Object mObject = new Object();

    /* renamed from: com.umeng.commonsdk.internal.crash.UMCrashManager$1 */
    /* loaded from: classes3.dex */
    public static class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f26064a;

        /* renamed from: b */
        final /* synthetic */ Throwable f26065b;

        AnonymousClass1(Context context, Throwable th) {
            context = context;
            th = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                synchronized (UMCrashManager.mObject) {
                    if (context != null && th != null && !UMCrashManager.isReportCrash) {
                        boolean unused = UMCrashManager.isReportCrash = true;
                        ULog.i("walle-crash", "report thread is " + UMCrashManager.isReportCrash);
                        String a2 = a.a(th);
                        if (!TextUtils.isEmpty(a2)) {
                            f.a(context, context.getFilesDir() + "/" + com.umeng.commonsdk.stateless.a.f26307e + "/" + Base64.encodeToString(com.umeng.commonsdk.internal.a.f26050a.getBytes(), 0), 10);
                            UMSLEnvelopeBuild uMSLEnvelopeBuild = new UMSLEnvelopeBuild();
                            JSONObject buildSLBaseHeader = uMSLEnvelopeBuild.buildSLBaseHeader(context);
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("content", a2);
                                jSONObject.put("ts", System.currentTimeMillis());
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("crash", jSONObject);
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("tp", jSONObject2);
                                JSONObject buildSLEnvelope = uMSLEnvelopeBuild.buildSLEnvelope(context, buildSLBaseHeader, jSONObject3, com.umeng.commonsdk.internal.a.f26050a);
                                if (buildSLEnvelope != null) {
                                    buildSLEnvelope.has("exception");
                                }
                            } catch (JSONException unused2) {
                            }
                        }
                    }
                }
            } catch (Throwable unused3) {
            }
        }
    }

    public static void reportCrash(Context context, Throwable th) {
        if (isReportCrash) {
            return;
        }
        ULog.i("walle-crash", "report is " + isReportCrash);
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.internal.crash.UMCrashManager.1

            /* renamed from: a */
            final /* synthetic */ Context f26064a;

            /* renamed from: b */
            final /* synthetic */ Throwable f26065b;

            AnonymousClass1(Context context2, Throwable th2) {
                context = context2;
                th = th2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    synchronized (UMCrashManager.mObject) {
                        if (context != null && th != null && !UMCrashManager.isReportCrash) {
                            boolean unused = UMCrashManager.isReportCrash = true;
                            ULog.i("walle-crash", "report thread is " + UMCrashManager.isReportCrash);
                            String a2 = a.a(th);
                            if (!TextUtils.isEmpty(a2)) {
                                f.a(context, context.getFilesDir() + "/" + com.umeng.commonsdk.stateless.a.f26307e + "/" + Base64.encodeToString(com.umeng.commonsdk.internal.a.f26050a.getBytes(), 0), 10);
                                UMSLEnvelopeBuild uMSLEnvelopeBuild = new UMSLEnvelopeBuild();
                                JSONObject buildSLBaseHeader = uMSLEnvelopeBuild.buildSLBaseHeader(context);
                                try {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("content", a2);
                                    jSONObject.put("ts", System.currentTimeMillis());
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("crash", jSONObject);
                                    JSONObject jSONObject3 = new JSONObject();
                                    jSONObject3.put("tp", jSONObject2);
                                    JSONObject buildSLEnvelope = uMSLEnvelopeBuild.buildSLEnvelope(context, buildSLBaseHeader, jSONObject3, com.umeng.commonsdk.internal.a.f26050a);
                                    if (buildSLEnvelope != null) {
                                        buildSLEnvelope.has("exception");
                                    }
                                } catch (JSONException unused2) {
                                }
                            }
                        }
                    }
                } catch (Throwable unused3) {
                }
            }
        }).start();
    }
}
