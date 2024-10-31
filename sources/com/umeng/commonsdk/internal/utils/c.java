package com.umeng.commonsdk.internal.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.appevents.UserDataStore;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import org.json.JSONObject;

/* compiled from: BatteryUtils.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a */
    private static final String f26086a = "BatteryUtils";

    /* renamed from: b */
    private static boolean f26087b = false;

    /* renamed from: c */
    private static Context f26088c;

    /* renamed from: d */
    private BroadcastReceiver f26089d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BatteryUtils.java */
    /* renamed from: com.umeng.commonsdk.internal.utils.c$1 */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 extends BroadcastReceiver {
        AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("le", intent.getIntExtra("level", 0));
                    } catch (Exception unused) {
                    }
                    try {
                        jSONObject.put("vol", intent.getIntExtra("voltage", 0));
                    } catch (Exception unused2) {
                    }
                    try {
                        jSONObject.put("temp", intent.getIntExtra("temperature", 0));
                        jSONObject.put("ts", System.currentTimeMillis());
                    } catch (Exception unused3) {
                    }
                    int intExtra = intent.getIntExtra("status", 0);
                    int i = -1;
                    int i2 = 2;
                    if (intExtra != 1) {
                        if (intExtra == 2) {
                            i = 1;
                        } else if (intExtra != 3) {
                            if (intExtra == 4) {
                                i = 0;
                            } else if (intExtra == 5) {
                                i = 2;
                            }
                        }
                    }
                    try {
                        jSONObject.put("st", i);
                    } catch (Exception unused4) {
                    }
                    int intExtra2 = intent.getIntExtra("plugged", 0);
                    if (intExtra2 == 1) {
                        i2 = 1;
                    } else if (intExtra2 != 2) {
                        i2 = 0;
                    }
                    try {
                        jSONObject.put(UserDataStore.CITY, i2);
                        jSONObject.put("ts", System.currentTimeMillis());
                    } catch (Exception unused5) {
                    }
                    ULog.i(c.f26086a, jSONObject.toString());
                    UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.f26056g, com.umeng.commonsdk.internal.b.a(c.f26088c).a(), jSONObject.toString());
                    c.this.c();
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(c.f26088c, th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BatteryUtils.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a */
        private static final c f26091a = new c();

        private a() {
        }
    }

    /* synthetic */ c(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static c a(Context context) {
        if (f26088c == null && context != null) {
            f26088c = context.getApplicationContext();
        }
        return a.f26091a;
    }

    public synchronized void b() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            f26088c.registerReceiver(this.f26089d, intentFilter);
            f26087b = true;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f26088c, th);
        }
    }

    public synchronized void c() {
        try {
            f26088c.unregisterReceiver(this.f26089d);
            f26087b = false;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f26088c, th);
        }
    }

    private c() {
        this.f26089d = new BroadcastReceiver() { // from class: com.umeng.commonsdk.internal.utils.c.1
            AnonymousClass1() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                try {
                    if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("le", intent.getIntExtra("level", 0));
                        } catch (Exception unused) {
                        }
                        try {
                            jSONObject.put("vol", intent.getIntExtra("voltage", 0));
                        } catch (Exception unused2) {
                        }
                        try {
                            jSONObject.put("temp", intent.getIntExtra("temperature", 0));
                            jSONObject.put("ts", System.currentTimeMillis());
                        } catch (Exception unused3) {
                        }
                        int intExtra = intent.getIntExtra("status", 0);
                        int i = -1;
                        int i2 = 2;
                        if (intExtra != 1) {
                            if (intExtra == 2) {
                                i = 1;
                            } else if (intExtra != 3) {
                                if (intExtra == 4) {
                                    i = 0;
                                } else if (intExtra == 5) {
                                    i = 2;
                                }
                            }
                        }
                        try {
                            jSONObject.put("st", i);
                        } catch (Exception unused4) {
                        }
                        int intExtra2 = intent.getIntExtra("plugged", 0);
                        if (intExtra2 == 1) {
                            i2 = 1;
                        } else if (intExtra2 != 2) {
                            i2 = 0;
                        }
                        try {
                            jSONObject.put(UserDataStore.CITY, i2);
                            jSONObject.put("ts", System.currentTimeMillis());
                        } catch (Exception unused5) {
                        }
                        ULog.i(c.f26086a, jSONObject.toString());
                        UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.f26056g, com.umeng.commonsdk.internal.b.a(c.f26088c).a(), jSONObject.toString());
                        c.this.c();
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(c.f26088c, th);
                }
            }
        };
    }

    public synchronized boolean a() {
        return f26087b;
    }
}
