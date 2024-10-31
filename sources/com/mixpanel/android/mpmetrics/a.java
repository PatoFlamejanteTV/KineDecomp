package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.mixpanel.android.mpmetrics.MPDbAdapter;
import com.mixpanel.android.util.RemoteService;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.keyczar.Keyczar;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnalyticsMessages.java */
/* loaded from: classes.dex */
public class a {
    private static final Map<Context, a> d = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    protected final Context f3012a;
    protected final m b;
    private final b c = a();

    a(Context context) {
        this.f3012a = context;
        this.b = c(context);
        c().a();
    }

    protected b a() {
        return new b();
    }

    public static a a(Context context) {
        a aVar;
        synchronized (d) {
            Context applicationContext = context.getApplicationContext();
            if (!d.containsKey(applicationContext)) {
                aVar = new a(applicationContext);
                d.put(applicationContext, aVar);
            } else {
                aVar = d.get(applicationContext);
            }
        }
        return aVar;
    }

    public void a(C0057a c0057a) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = c0057a;
        this.c.a(obtain);
    }

    public void a(JSONObject jSONObject) {
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = jSONObject;
        this.c.a(obtain);
    }

    public void b() {
        Message obtain = Message.obtain();
        obtain.what = 2;
        this.c.a(obtain);
    }

    public void a(f fVar) {
        Message obtain = Message.obtain();
        obtain.what = 12;
        obtain.obj = fVar;
        this.c.a(obtain);
    }

    public void a(String str) {
        Message obtain = Message.obtain();
        obtain.what = 13;
        obtain.obj = str;
        this.c.a(obtain);
    }

    protected MPDbAdapter b(Context context) {
        return new MPDbAdapter(context);
    }

    protected m c(Context context) {
        return m.a(context);
    }

    protected RemoteService c() {
        return new com.mixpanel.android.util.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnalyticsMessages.java */
    /* renamed from: com.mixpanel.android.mpmetrics.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0057a {

        /* renamed from: a, reason: collision with root package name */
        private final String f3013a;
        private final JSONObject b;
        private final String c;

        public C0057a(String str, JSONObject jSONObject, String str2) {
            this.f3013a = str;
            this.b = jSONObject;
            this.c = str2;
        }

        public String a() {
            return this.f3013a;
        }

        public JSONObject b() {
            return this.b;
        }

        public String c() {
            return this.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (m.f3036a) {
            Log.v("MixpanelAPI.Messages", str + " (Thread " + Thread.currentThread().getId() + ")");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Throwable th) {
        if (m.f3036a) {
            Log.v("MixpanelAPI.Messages", str + " (Thread " + Thread.currentThread().getId() + ")", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnalyticsMessages.java */
    /* loaded from: classes.dex */
    public class b {
        private ad g;
        private final Object b = new Object();
        private long d = 0;
        private long e = 0;
        private long f = -1;
        private Handler c = a();

        public b() {
        }

        public void a(Message message) {
            synchronized (this.b) {
                if (this.c == null) {
                    a.this.b("Dead mixpanel worker dropping a message: " + message.what);
                } else {
                    this.c.sendMessage(message);
                }
            }
        }

        protected Handler a() {
            HandlerThread handlerThread = new HandlerThread("com.mixpanel.android.AnalyticsWorker", 1);
            handlerThread.start();
            return new HandlerC0058a(handlerThread.getLooper());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AnalyticsMessages.java */
        /* renamed from: com.mixpanel.android.mpmetrics.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class HandlerC0058a extends Handler {
            private MPDbAdapter b;
            private final DecideChecker c;
            private final long d;
            private final boolean e;
            private long f;
            private long g;
            private int h;

            public HandlerC0058a(Looper looper) {
                super(looper);
                this.b = null;
                this.c = a();
                this.e = a.this.b.e();
                this.d = a.this.b.b();
                b.this.g = new ad(a.this.f3012a);
            }

            protected DecideChecker a() {
                return new DecideChecker(a.this.f3012a, a.this.b);
            }

            /* JADX WARN: Removed duplicated region for block: B:85:0x0166 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // android.os.Handler
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void handleMessage(android.os.Message r8) {
                /*
                    Method dump skipped, instructions count: 649
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.a.b.HandlerC0058a.handleMessage(android.os.Message):void");
            }

            private void a(String str) {
                try {
                    try {
                        if (GooglePlayServicesUtil.a(a.this.f3012a) != 0) {
                            Log.i("MixpanelAPI.Messages", "Can't register for push notifications, Google Play Services are not installed.");
                        } else {
                            n.a(new com.mixpanel.android.mpmetrics.b(this, GoogleCloudMessaging.a(a.this.f3012a).a(str)));
                        }
                    } catch (IOException e) {
                        Log.i("MixpanelAPI.Messages", "Exception when trying to register for GCM", e);
                    } catch (NoClassDefFoundError e2) {
                        Log.w("MixpanelAPI.Messages", "Google play services were not part of this build, push notifications cannot be registered or delivered");
                    }
                } catch (RuntimeException e3) {
                    Log.i("MixpanelAPI.Messages", "Can't register for push notifications, Google Play services are not configured.");
                }
            }

            private void a(MPDbAdapter mPDbAdapter) {
                if (!a.this.c().a(a.this.f3012a)) {
                    a.this.b("Not flushing data to Mixpanel because the device is not connected to the internet.");
                } else if (this.e) {
                    a(mPDbAdapter, MPDbAdapter.Table.EVENTS, new String[]{a.this.b.k()});
                    a(mPDbAdapter, MPDbAdapter.Table.PEOPLE, new String[]{a.this.b.l()});
                } else {
                    a(mPDbAdapter, MPDbAdapter.Table.EVENTS, new String[]{a.this.b.k(), a.this.b.n()});
                    a(mPDbAdapter, MPDbAdapter.Table.PEOPLE, new String[]{a.this.b.l(), a.this.b.o()});
                }
            }

            private void a(MPDbAdapter mPDbAdapter, MPDbAdapter.Table table, String[] strArr) {
                String str;
                boolean z;
                boolean z2;
                RemoteService c = a.this.c();
                String[] a2 = mPDbAdapter.a(table);
                if (a2 != null) {
                    str = a2[0];
                    String str2 = a2[1];
                    String a3 = com.mixpanel.android.util.b.a(str2);
                    HashMap hashMap = new HashMap();
                    hashMap.put(ShareConstants.WEB_DIALOG_PARAM_DATA, a3);
                    if (m.f3036a) {
                        hashMap.put("verbose", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                    }
                    z = true;
                    int length = strArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        String str3 = strArr[i];
                        try {
                            byte[] a4 = c.a(str3, hashMap, a.this.b.u());
                            z = true;
                            if (a4 == null) {
                                a.this.b("Response was null, unexpected failure posting to " + str3 + ".");
                            } else {
                                try {
                                    String str4 = new String(a4, Keyczar.DEFAULT_ENCODING);
                                    if (this.h > 0) {
                                        this.h = 0;
                                        removeMessages(2);
                                    }
                                    a.this.b("Successfully posted to " + str3 + ": \n" + str2);
                                    a.this.b("Response was " + str4);
                                } catch (UnsupportedEncodingException e) {
                                    throw new RuntimeException("UTF not supported on this platform?", e);
                                }
                            }
                        } catch (RemoteService.ServiceUnavailableException e2) {
                            a.this.a("Cannot post message to " + str3 + ".", e2);
                            z2 = false;
                            this.g = e2.getRetryAfter() * LicenseErrCode.LICENSE_STATUS_NOT_LICENSED;
                        } catch (OutOfMemoryError e3) {
                            Log.e("MixpanelAPI.Messages", "Out of memory when posting to " + str3 + ".", e3);
                        } catch (MalformedURLException e4) {
                            Log.e("MixpanelAPI.Messages", "Cannot interpret " + str3 + " as a URL.", e4);
                        } catch (SocketTimeoutException e5) {
                            a.this.a("Cannot post message to " + str3 + ".", e5);
                            z2 = false;
                        } catch (IOException e6) {
                            a.this.a("Cannot post message to " + str3 + ".", e6);
                            z2 = false;
                        }
                        i++;
                        z = z2;
                    }
                } else {
                    return;
                }
                if (z) {
                    a.this.b("Not retrying this batch of events, deleting them from DB.");
                    mPDbAdapter.a(str, table);
                    return;
                }
                removeMessages(2);
                this.g = Math.max(((long) Math.pow(2.0d, this.h)) * 60000, this.g);
                this.g = Math.min(this.g, 600000L);
                sendEmptyMessageDelayed(2, this.g);
                this.h++;
                a.this.b("Retrying this batch of events in " + this.g + " ms");
            }

            private JSONObject b() throws JSONException {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("mp_lib", "android");
                jSONObject.put("$lib_version", "4.8.0");
                jSONObject.put("$os", "Android");
                jSONObject.put("$os_version", Build.VERSION.RELEASE == null ? "UNKNOWN" : Build.VERSION.RELEASE);
                jSONObject.put("$manufacturer", Build.MANUFACTURER == null ? "UNKNOWN" : Build.MANUFACTURER);
                jSONObject.put("$brand", Build.BRAND == null ? "UNKNOWN" : Build.BRAND);
                jSONObject.put("$model", Build.MODEL == null ? "UNKNOWN" : Build.MODEL);
                try {
                    try {
                        switch (GooglePlayServicesUtil.a(a.this.f3012a)) {
                            case 0:
                                jSONObject.put("$google_play_services", "available");
                                break;
                            case 1:
                                jSONObject.put("$google_play_services", "missing");
                                break;
                            case 2:
                                jSONObject.put("$google_play_services", "out of date");
                                break;
                            case 3:
                                jSONObject.put("$google_play_services", "disabled");
                                break;
                            case 9:
                                jSONObject.put("$google_play_services", "invalid");
                                break;
                        }
                    } catch (RuntimeException e) {
                        jSONObject.put("$google_play_services", "not configured");
                    }
                } catch (NoClassDefFoundError e2) {
                    jSONObject.put("$google_play_services", "not included");
                }
                DisplayMetrics e3 = b.this.g.e();
                jSONObject.put("$screen_dpi", e3.densityDpi);
                jSONObject.put("$screen_height", e3.heightPixels);
                jSONObject.put("$screen_width", e3.widthPixels);
                String a2 = b.this.g.a();
                if (a2 != null) {
                    jSONObject.put("$app_version", a2);
                    jSONObject.put("$app_version_string", a2);
                }
                Integer b = b.this.g.b();
                if (b != null) {
                    jSONObject.put("$app_release", b);
                    jSONObject.put("$app_build_number", b);
                }
                Boolean valueOf = Boolean.valueOf(b.this.g.c());
                if (valueOf != null) {
                    jSONObject.put("$has_nfc", valueOf.booleanValue());
                }
                Boolean valueOf2 = Boolean.valueOf(b.this.g.d());
                if (valueOf2 != null) {
                    jSONObject.put("$has_telephone", valueOf2.booleanValue());
                }
                String f = b.this.g.f();
                if (f != null) {
                    jSONObject.put("$carrier", f);
                }
                Boolean g = b.this.g.g();
                if (g != null) {
                    jSONObject.put("$wifi", g.booleanValue());
                }
                Boolean h = b.this.g.h();
                if (h != null) {
                    jSONObject.put("$bluetooth_enabled", h);
                }
                String i = b.this.g.i();
                if (i != null) {
                    jSONObject.put("$bluetooth_version", i);
                }
                return jSONObject;
            }

            private JSONObject a(C0057a c0057a) throws JSONException {
                JSONObject jSONObject = new JSONObject();
                JSONObject b = c0057a.b();
                JSONObject b2 = b();
                b2.put("token", c0057a.c());
                if (b != null) {
                    Iterator<String> keys = b.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        b2.put(next, b.get(next));
                    }
                }
                jSONObject.put("event", c0057a.a());
                jSONObject.put("properties", b2);
                return jSONObject;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.d + 1;
            if (this.f > 0) {
                this.e = ((currentTimeMillis - this.f) + (this.e * this.d)) / j;
                a.this.b("Average send frequency approximately " + (this.e / 1000) + " seconds.");
            }
            this.f = currentTimeMillis;
            this.d = j;
        }
    }
}
