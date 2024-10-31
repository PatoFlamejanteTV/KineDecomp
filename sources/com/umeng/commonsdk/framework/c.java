package com.umeng.commonsdk.framework;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.ULog;
import org.json.JSONObject;

/* compiled from: UMWorkDispatchImpl.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final String f26042a = "content";

    /* renamed from: b, reason: collision with root package name */
    public static final String f26043b = "header";

    /* renamed from: c, reason: collision with root package name */
    public static final String f26044c = "exception";

    /* renamed from: d, reason: collision with root package name */
    private static HandlerThread f26045d = null;

    /* renamed from: e, reason: collision with root package name */
    private static Handler f26046e = null;

    /* renamed from: f, reason: collision with root package name */
    private static b f26047f = null;

    /* renamed from: g, reason: collision with root package name */
    private static Object f26048g = new Object();

    /* renamed from: h, reason: collision with root package name */
    private static final int f26049h = 768;
    private static final int i = 769;
    private static final int j = 770;
    private static final int k = 784;

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d() {
        JSONObject buildEnvelopeWithExtHeader;
        ULog.d("--->>> delayProcess Enter...");
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> delayProcess Enter...");
        Context appContext = UMModuleRegister.getAppContext();
        if (appContext == null || !UMFrUtils.isOnline(appContext)) {
            return;
        }
        long maxDataSpace = UMEnvelopeBuild.maxDataSpace(appContext);
        UMLogDataProtocol callbackFromModuleName = UMModuleRegister.getCallbackFromModuleName("analytics");
        JSONObject jSONObject = null;
        if (callbackFromModuleName != null) {
            try {
                jSONObject = callbackFromModuleName.setupReportData(maxDataSpace);
                if (jSONObject == null) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> analyticsCB.setupReportData() return null");
                    return;
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(appContext, th);
                return;
            }
        }
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        JSONObject jSONObject2 = (JSONObject) jSONObject.opt("header");
        JSONObject jSONObject3 = (JSONObject) jSONObject.opt("content");
        if (appContext == null || jSONObject2 == null || jSONObject3 == null || (buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(appContext, jSONObject2, jSONObject3)) == null) {
            return;
        }
        try {
            if (buildEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> autoProcess: Build envelope error code: " + buildEnvelopeWithExtHeader.getInt("exception"));
            }
        } catch (Throwable unused) {
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> autoProcess: removeCacheData ... ");
        callbackFromModuleName.removeCacheData(buildEnvelopeWithExtHeader);
    }

    private static synchronized void e() {
        synchronized (c.class) {
            ULog.d("--->>> Dispatch: init Enter...");
            try {
                if (f26045d == null) {
                    f26045d = new HandlerThread("work_thread");
                    f26045d.start();
                    if (f26046e == null) {
                        f26046e = new Handler(f26045d.getLooper()) { // from class: com.umeng.commonsdk.framework.c.1
                            @Override // android.os.Handler
                            public void handleMessage(Message message) {
                                int i2 = message.what;
                                if (i2 != c.k) {
                                    switch (i2) {
                                        case c.f26049h /* 768 */:
                                            c.b(message);
                                            return;
                                        case c.i /* 769 */:
                                        default:
                                            return;
                                        case c.j /* 770 */:
                                            c.d();
                                            return;
                                    }
                                }
                                c.g();
                            }
                        };
                    }
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(UMModuleRegister.getAppContext(), th);
            }
            ULog.d("--->>> Dispatch: init Exit...");
        }
    }

    private static void f() {
        if (f26045d != null) {
            f26045d = null;
        }
        if (f26046e != null) {
            f26046e = null;
        }
        if (f26047f != null) {
            f26047f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g() {
        if (f26047f == null || f26045d == null) {
            return;
        }
        b.c();
        ULog.d("--->>> handleQuit: Quit dispatch thread.");
        f26045d.quit();
        f();
    }

    public static void a(UMSenderStateNotify uMSenderStateNotify) {
        if (f26047f != null) {
            b.a(uMSenderStateNotify);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Message message) {
        int i2 = message.arg1;
        Object obj = message.obj;
        UMLogDataProtocol callbackFromModuleName = UMModuleRegister.getCallbackFromModuleName(UMModuleRegister.eventType2ModuleName(i2));
        if (callbackFromModuleName != null) {
            ULog.d("--->>> dispatch:handleEvent: call back workEvent with msg type [ 0x" + Integer.toHexString(i2) + "]");
            callbackFromModuleName.workEvent(obj, i2);
        }
    }

    public static void a(Context context, int i2, UMLogDataProtocol uMLogDataProtocol, Object obj) {
        if (context != null && uMLogDataProtocol != null) {
            UMModuleRegister.registerAppContext(context.getApplicationContext());
            if (UMModuleRegister.registerCallback(i2, uMLogDataProtocol)) {
                if (f26045d == null || f26046e == null) {
                    e();
                }
                try {
                    if (f26046e != null) {
                        if (UMGlobalContext.getInstance().isMainProcess(context) && f26047f == null) {
                            synchronized (f26048g) {
                                UMFrUtils.syncLegacyEnvelopeIfNeeded(context);
                                f26047f = new b(context, f26046e);
                            }
                        }
                        Message obtainMessage = f26046e.obtainMessage();
                        obtainMessage.what = f26049h;
                        obtainMessage.arg1 = i2;
                        obtainMessage.obj = obj;
                        f26046e.sendMessage(obtainMessage);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(UMModuleRegister.getAppContext(), th);
                    return;
                }
            }
            return;
        }
        ULog.d("--->>> Context or UMLogDataProtocol parameter cannot be null!");
    }

    public static void a(long j2) {
        Handler handler = f26046e;
        if (handler != null) {
            if (handler.hasMessages(j)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> MSG_DELAY_PROCESS has exist. do nothing.");
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> MSG_DELAY_PROCESS not exist. send it.");
            Message obtainMessage = f26046e.obtainMessage();
            obtainMessage.what = j;
            f26046e.sendMessageDelayed(obtainMessage, j2);
        }
    }

    public static synchronized boolean a(int i2) {
        synchronized (c.class) {
            if (f26046e == null) {
                return false;
            }
            return f26046e.hasMessages(i2);
        }
    }

    public static void a() {
        Handler handler = f26046e;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = k;
            f26046e.sendMessage(obtainMessage);
        }
    }
}
