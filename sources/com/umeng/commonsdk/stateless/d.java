package com.umeng.commonsdk.stateless;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.File;

/* compiled from: UMSLNetWorkSender.java */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final int f26335a = 273;

    /* renamed from: b, reason: collision with root package name */
    private static Context f26336b = null;

    /* renamed from: c, reason: collision with root package name */
    private static HandlerThread f26337c = null;

    /* renamed from: d, reason: collision with root package name */
    private static Handler f26338d = null;

    /* renamed from: f, reason: collision with root package name */
    private static final int f26340f = 512;

    /* renamed from: g, reason: collision with root package name */
    private static IntentFilter f26341g;

    /* renamed from: e, reason: collision with root package name */
    private static Object f26339e = new Object();

    /* renamed from: h, reason: collision with root package name */
    private static boolean f26342h = false;
    private static BroadcastReceiver i = new BroadcastReceiver() { // from class: com.umeng.commonsdk.stateless.d.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager;
            if (context == null || intent == null) {
                return;
            }
            try {
                if (intent.getAction() != null && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    Context unused = d.f26336b = context.getApplicationContext();
                    if (d.f26336b != null && (connectivityManager = (ConnectivityManager) d.f26336b.getSystemService("connectivity")) != null) {
                        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                            boolean unused2 = d.f26342h = true;
                            ULog.i("walle", "[stateless] net reveiver ok --->>>");
                            d.b(d.f26335a);
                        } else {
                            ULog.i("walle", "[stateless] net reveiver disconnected --->>>");
                            boolean unused3 = d.f26342h = false;
                        }
                    }
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
            }
        }
    };

    public d(Context context) {
        synchronized (f26339e) {
            if (context != null) {
                try {
                    f26336b = context.getApplicationContext();
                    if (f26336b != null && f26337c == null) {
                        f26337c = new HandlerThread("SL-NetWorkSender");
                        f26337c.start();
                        if (f26338d == null) {
                            f26338d = new Handler(f26337c.getLooper()) { // from class: com.umeng.commonsdk.stateless.d.2
                                @Override // android.os.Handler
                                public void handleMessage(Message message) {
                                    int i2 = message.what;
                                    if (i2 == 273) {
                                        d.e();
                                    } else {
                                        if (i2 != 512) {
                                            return;
                                        }
                                        d.f();
                                    }
                                }
                            };
                        }
                        if (DeviceConfig.checkPermission(f26336b, "android.permission.ACCESS_NETWORK_STATE")) {
                            ULog.i("walle", "[stateless] begin register receiver");
                            if (f26341g == null) {
                                f26341g = new IntentFilter();
                                f26341g.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                                if (i != null) {
                                    ULog.i("walle", "[stateless] register receiver ok");
                                    f26336b.registerReceiver(i, f26341g);
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(context, th);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e() {
        Context context;
        if (!f26342h || (context = f26336b) == null) {
            return;
        }
        try {
            File a2 = f.a(context);
            if (a2 == null || a2.getParentFile() == null || TextUtils.isEmpty(a2.getParentFile().getName())) {
                return;
            }
            e eVar = new e(f26336b);
            String str = new String(Base64.decode(a2.getParentFile().getName(), 0));
            ULog.i("walle", "[stateless] handleProcessNext, pathUrl is " + str);
            byte[] bArr = null;
            try {
                bArr = f.a(a2.getAbsolutePath());
            } catch (Exception unused) {
            }
            if (eVar.a(bArr, str)) {
                ULog.i("walle", "[stateless] Send envelope file success, delete it.");
                File file = new File(a2.getAbsolutePath());
                if (!file.delete()) {
                    ULog.i("walle", "[stateless] Failed to delete already processed file. We try again after delete failed.");
                    file.delete();
                }
                b(f26335a);
                return;
            }
            ULog.i("walle", "[stateless] Send envelope file failed, abandon and wait next trigger!");
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f26336b, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f() {
        if (f26341g != null) {
            BroadcastReceiver broadcastReceiver = i;
            if (broadcastReceiver != null) {
                Context context = f26336b;
                if (context != null) {
                    context.unregisterReceiver(broadcastReceiver);
                }
                i = null;
            }
            f26341g = null;
        }
        HandlerThread handlerThread = f26337c;
        if (handlerThread != null) {
            handlerThread.quit();
            if (f26337c != null) {
                f26337c = null;
            }
            if (f26338d != null) {
                f26338d = null;
            }
        }
    }

    public static void b(int i2) {
        try {
            if (!f26342h || f26338d == null || f26338d.hasMessages(i2)) {
                return;
            }
            ULog.i("walle", "[stateless] sendMsgOnce !!!!");
            Message obtainMessage = f26338d.obtainMessage();
            obtainMessage.what = i2;
            f26338d.sendMessage(obtainMessage);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f26336b, th);
        }
    }

    public static void a(int i2) {
        Handler handler;
        if (!f26342h || (handler = f26338d) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i2;
        f26338d.sendMessage(obtainMessage);
    }

    public static void a() {
        b(512);
    }
}
