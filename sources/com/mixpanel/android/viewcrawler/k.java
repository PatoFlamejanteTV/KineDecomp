package com.mixpanel.android.viewcrawler;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.JsonWriter;
import android.util.Log;
import android.util.Pair;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.mixpanel.android.mpmetrics.af;
import com.mixpanel.android.mpmetrics.z;
import com.mixpanel.android.util.ImageStore;
import com.mixpanel.android.viewcrawler.EditProtocol;
import com.mixpanel.android.viewcrawler.EditorConnection;
import com.mixpanel.android.viewcrawler.e;
import com.mixpanel.android.viewcrawler.o;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ViewCrawler.java */
@TargetApi(16)
/* loaded from: classes.dex */
public class k implements h, j, o.i {

    /* renamed from: a, reason: collision with root package name */
    private final com.mixpanel.android.mpmetrics.m f3095a;
    private final Context b;
    private final com.mixpanel.android.mpmetrics.n c;
    private final com.mixpanel.android.viewcrawler.b d;
    private final af f;
    private final Map<String, String> g;
    private final f h;
    private final com.mixpanel.android.viewcrawler.c e = new com.mixpanel.android.viewcrawler.c();
    private final float i = Resources.getSystem().getDisplayMetrics().scaledDensity;

    public k(Context context, String str, com.mixpanel.android.mpmetrics.n nVar, af afVar) {
        this.f3095a = com.mixpanel.android.mpmetrics.m.a(context);
        this.b = context;
        this.f = afVar;
        this.g = nVar.d();
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new c());
        HandlerThread handlerThread = new HandlerThread(k.class.getCanonicalName());
        handlerThread.setPriority(10);
        handlerThread.start();
        this.h = new f(context, str, handlerThread.getLooper(), this);
        this.d = new com.mixpanel.android.viewcrawler.b(nVar, this.h);
        this.c = nVar;
        this.f.a(new l(this));
    }

    @Override // com.mixpanel.android.viewcrawler.j
    public void a() {
        this.h.a();
        this.h.sendMessage(this.h.obtainMessage(0));
    }

    @Override // com.mixpanel.android.viewcrawler.j
    public void a(JSONArray jSONArray) {
        Message obtainMessage = this.h.obtainMessage(5);
        obtainMessage.obj = jSONArray;
        this.h.sendMessage(obtainMessage);
    }

    @Override // com.mixpanel.android.viewcrawler.j
    public void b(JSONArray jSONArray) {
        Message obtainMessage = this.h.obtainMessage(9);
        obtainMessage.obj = jSONArray;
        this.h.sendMessage(obtainMessage);
    }

    @Override // com.mixpanel.android.viewcrawler.h
    public void a(String str) {
        Message obtainMessage = this.h.obtainMessage();
        obtainMessage.what = 7;
        obtainMessage.obj = str;
        this.h.sendMessage(obtainMessage);
    }

    @Override // com.mixpanel.android.viewcrawler.o.i
    public void a(o.e eVar) {
        Message obtainMessage = this.h.obtainMessage();
        obtainMessage.what = 12;
        obtainMessage.obj = eVar;
        this.h.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewCrawler.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        private volatile boolean b = true;

        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.b) {
                k.this.h.sendMessage(k.this.h.obtainMessage(1));
            }
            k.this.h.postDelayed(this, 30000L);
        }

        public void a() {
            this.b = false;
            k.this.h.post(this);
        }

        public void b() {
            this.b = true;
            k.this.h.removeCallbacks(this);
        }
    }

    /* compiled from: ViewCrawler.java */
    /* loaded from: classes.dex */
    private class c implements Application.ActivityLifecycleCallbacks, e.a {
        private final com.mixpanel.android.viewcrawler.e b = new com.mixpanel.android.viewcrawler.e(this);
        private final b c;

        public c() {
            this.c = new b();
        }

        @Override // com.mixpanel.android.viewcrawler.e.a
        public void a() {
            k.this.h.sendMessage(k.this.h.obtainMessage(1));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            b();
            k.this.e.b(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            k.this.e.a(activity);
            if (k.this.e.b()) {
                a(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        private void b() {
            if (!c() || k.this.f3095a.g()) {
                if (!k.this.f3095a.f()) {
                    SensorManager sensorManager = (SensorManager) k.this.b.getSystemService("sensor");
                    sensorManager.registerListener(this.b, sensorManager.getDefaultSensor(1), 3);
                    return;
                }
                return;
            }
            this.c.a();
        }

        private void a(Activity activity) {
            if (!c() || k.this.f3095a.g()) {
                if (!k.this.f3095a.f()) {
                    ((SensorManager) activity.getSystemService("sensor")).unregisterListener(this.b);
                    return;
                }
                return;
            }
            this.c.b();
        }

        private boolean c() {
            return Build.HARDWARE.equals("goldfish") && Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic") && Build.PRODUCT.contains(ServerProtocol.DIALOG_PARAM_SDK_VERSION) && Build.MODEL.toLowerCase(Locale.US).contains(ServerProtocol.DIALOG_PARAM_SDK_VERSION);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewCrawler.java */
    /* loaded from: classes.dex */
    public class f extends Handler {
        private EditorConnection b;
        private n c;
        private final Context d;
        private final String e;
        private final Lock f;
        private final EditProtocol g;
        private final ImageStore h;
        private final Map<String, Pair<String, JSONObject>> i;
        private final List<JSONObject> j;
        private final List<String> k;
        private final List<Pair<String, JSONObject>> l;
        private final List<d> m;
        private final List<e> n;
        private final List<Pair<String, JSONObject>> o;
        private final Set<Pair<Integer, Integer>> p;

        public f(Context context, String str, Looper looper, o.i iVar) {
            super(looper);
            this.d = context;
            this.e = str;
            this.c = null;
            String t = k.this.f3095a.t();
            z.a aVar = new z.a(t == null ? context.getPackageName() : t, context);
            this.h = new ImageStore(context, "ViewCrawler");
            this.g = new EditProtocol(aVar, this.h, iVar);
            this.i = new HashMap();
            this.j = new ArrayList();
            this.k = new ArrayList();
            this.l = new ArrayList();
            this.m = new ArrayList();
            this.n = new ArrayList();
            this.o = new ArrayList();
            this.p = new HashSet();
            this.f = new ReentrantLock();
            this.f.lock();
        }

        public void a() {
            this.f.unlock();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.f.lock();
            try {
                switch (message.what) {
                    case 0:
                        b();
                        c();
                        break;
                    case 1:
                        d();
                        break;
                    case 2:
                        a((JSONObject) message.obj);
                        break;
                    case 3:
                        b((JSONObject) message.obj);
                        break;
                    case 4:
                        e();
                        break;
                    case 5:
                        b((JSONArray) message.obj);
                        break;
                    case 6:
                        e((JSONObject) message.obj);
                        break;
                    case 7:
                        b((String) message.obj);
                        break;
                    case 8:
                        f();
                        break;
                    case 9:
                        a((JSONArray) message.obj);
                        break;
                    case 10:
                        c((JSONObject) message.obj);
                        break;
                    case 11:
                        d((JSONObject) message.obj);
                        break;
                    case 12:
                        a((o.e) message.obj);
                        break;
                }
            } finally {
                this.f.unlock();
            }
        }

        private void b() {
            SharedPreferences g = g();
            String string = g.getString("mixpanel.viewcrawler.changes", null);
            if (string != null) {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        this.p.add(new Pair<>(Integer.valueOf(jSONObject.getInt("experiment_id")), Integer.valueOf(jSONObject.getInt(ShareConstants.WEB_DIALOG_PARAM_ID))));
                    }
                } catch (JSONException e) {
                    Log.e("MixpanelAPI.ViewCrawler", "Malformed variants found in persistent storage, clearing all variants", e);
                    SharedPreferences.Editor edit = g.edit();
                    edit.remove("mixpanel.viewcrawler.changes");
                    edit.remove("mixpanel.viewcrawler.bindings");
                    edit.apply();
                }
            }
        }

        private void c() {
            SharedPreferences g = g();
            String string = g.getString("mixpanel.viewcrawler.changes", null);
            String string2 = g.getString("mixpanel.viewcrawler.bindings", null);
            ArrayList arrayList = new ArrayList();
            if (string != null) {
                try {
                    this.m.clear();
                    this.n.clear();
                    JSONArray jSONArray = new JSONArray(string);
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        int i2 = jSONObject.getInt(ShareConstants.WEB_DIALOG_PARAM_ID);
                        int i3 = jSONObject.getInt("experiment_id");
                        Pair pair = new Pair(Integer.valueOf(i3), Integer.valueOf(i2));
                        JSONArray jSONArray2 = jSONObject.getJSONArray("actions");
                        int length2 = jSONArray2.length();
                        for (int i4 = 0; i4 < length2; i4++) {
                            JSONObject jSONObject2 = jSONArray2.getJSONObject(i4);
                            this.m.add(new d(com.mixpanel.android.util.e.a(jSONObject2, "target_activity"), jSONObject2, pair));
                        }
                        JSONArray jSONArray3 = jSONObject.getJSONArray("tweaks");
                        int length3 = jSONArray3.length();
                        for (int i5 = 0; i5 < length3; i5++) {
                            this.n.add(new e(jSONArray3.getJSONObject(i5), pair));
                        }
                        if (length2 == 0 && length3 == 0) {
                            arrayList.add(new Pair<>(Integer.valueOf(i3), Integer.valueOf(i2)));
                        }
                    }
                } catch (JSONException e) {
                    Log.i("MixpanelAPI.ViewCrawler", "JSON error when initializing saved changes, clearing persistent memory", e);
                    SharedPreferences.Editor edit = g.edit();
                    edit.remove("mixpanel.viewcrawler.changes");
                    edit.remove("mixpanel.viewcrawler.bindings");
                    edit.apply();
                }
            }
            if (string2 != null) {
                JSONArray jSONArray4 = new JSONArray(string2);
                this.o.clear();
                for (int i6 = 0; i6 < jSONArray4.length(); i6++) {
                    JSONObject jSONObject3 = jSONArray4.getJSONObject(i6);
                    this.o.add(new Pair<>(com.mixpanel.android.util.e.a(jSONObject3, "target_activity"), jSONObject3));
                }
            }
            a(arrayList);
        }

        private void d() {
            if (com.mixpanel.android.mpmetrics.m.f3036a) {
                Log.v("MixpanelAPI.ViewCrawler", "connecting to editor");
            }
            if (this.b == null || !this.b.a()) {
                SSLSocketFactory u = k.this.f3095a.u();
                if (u == null) {
                    if (com.mixpanel.android.mpmetrics.m.f3036a) {
                        Log.v("MixpanelAPI.ViewCrawler", "SSL is not available on this device, no connection will be attempted to the events editor.");
                        return;
                    }
                    return;
                }
                String str = com.mixpanel.android.mpmetrics.m.a(this.d).r() + this.e;
                try {
                    this.b = new EditorConnection(new URI(str), new a(k.this, null), u.createSocket());
                    return;
                } catch (EditorConnection.EditorConnectionException e) {
                    Log.e("MixpanelAPI.ViewCrawler", "Error connecting to URI " + str, e);
                    return;
                } catch (IOException e2) {
                    Log.i("MixpanelAPI.ViewCrawler", "Can't create SSL Socket to connect to editor service", e2);
                    return;
                } catch (URISyntaxException e3) {
                    Log.e("MixpanelAPI.ViewCrawler", "Error parsing URI " + str + " for editor websocket", e3);
                    return;
                }
            }
            if (com.mixpanel.android.mpmetrics.m.f3036a) {
                Log.v("MixpanelAPI.ViewCrawler", "There is already a valid connection to an events editor.");
            }
        }

        private void a(String str) {
            if (this.b != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, str);
                } catch (JSONException e) {
                    Log.e("MixpanelAPI.ViewCrawler", "Apparently impossible JSONException", e);
                }
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.b.b());
                try {
                    try {
                        outputStreamWriter.write("{\"type\": \"error\", ");
                        outputStreamWriter.write("\"payload\": ");
                        outputStreamWriter.write(jSONObject.toString());
                        outputStreamWriter.write("}");
                        try {
                            outputStreamWriter.close();
                        } catch (IOException e2) {
                            Log.e("MixpanelAPI.ViewCrawler", "Could not close output writer to editor", e2);
                        }
                    } catch (Throwable th) {
                        try {
                            outputStreamWriter.close();
                        } catch (IOException e3) {
                            Log.e("MixpanelAPI.ViewCrawler", "Could not close output writer to editor", e3);
                        }
                        throw th;
                    }
                } catch (IOException e4) {
                    Log.e("MixpanelAPI.ViewCrawler", "Can't write error message to editor", e4);
                    try {
                        outputStreamWriter.close();
                    } catch (IOException e5) {
                        Log.e("MixpanelAPI.ViewCrawler", "Could not close output writer to editor", e5);
                    }
                }
            }
        }

        private void e() {
            if (this.b != null) {
                JsonWriter jsonWriter = new JsonWriter(new OutputStreamWriter(this.b.b()));
                try {
                    try {
                        jsonWriter.beginObject();
                        jsonWriter.name("type").value("device_info_response");
                        jsonWriter.name("payload").beginObject();
                        jsonWriter.name("device_type").value("Android");
                        jsonWriter.name("device_name").value(Build.BRAND + "/" + Build.MODEL);
                        jsonWriter.name("scaled_density").value(k.this.i);
                        for (Map.Entry entry : k.this.g.entrySet()) {
                            jsonWriter.name((String) entry.getKey()).value((String) entry.getValue());
                        }
                        Map<String, af.b> a2 = k.this.f.a();
                        jsonWriter.name("tweaks").beginArray();
                        for (Map.Entry<String, af.b> entry2 : a2.entrySet()) {
                            af.b value = entry2.getValue();
                            String key = entry2.getKey();
                            jsonWriter.beginObject();
                            jsonWriter.name("name").value(key);
                            jsonWriter.name("minimum").value((Number) null);
                            jsonWriter.name("maximum").value((Number) null);
                            switch (value.f3020a) {
                                case 1:
                                    jsonWriter.name("type").value("boolean");
                                    jsonWriter.name("value").value(value.c().booleanValue());
                                    break;
                                case 2:
                                    jsonWriter.name("type").value("number");
                                    jsonWriter.name("encoding").value("d");
                                    jsonWriter.name("value").value(value.b().doubleValue());
                                    break;
                                case 3:
                                    jsonWriter.name("type").value("number");
                                    jsonWriter.name("encoding").value("l");
                                    jsonWriter.name("value").value(value.b().longValue());
                                    break;
                                case 4:
                                    jsonWriter.name("type").value("string");
                                    jsonWriter.name("value").value(value.a());
                                    break;
                                default:
                                    Log.wtf("MixpanelAPI.ViewCrawler", "Unrecognized Tweak Type " + value.f3020a + " encountered.");
                                    break;
                            }
                            jsonWriter.endObject();
                        }
                        jsonWriter.endArray();
                        jsonWriter.endObject();
                        jsonWriter.endObject();
                        try {
                            jsonWriter.close();
                        } catch (IOException e) {
                            Log.e("MixpanelAPI.ViewCrawler", "Can't close websocket writer", e);
                        }
                    } catch (IOException e2) {
                        Log.e("MixpanelAPI.ViewCrawler", "Can't write device_info to server", e2);
                        try {
                            jsonWriter.close();
                        } catch (IOException e3) {
                            Log.e("MixpanelAPI.ViewCrawler", "Can't close websocket writer", e3);
                        }
                    }
                } catch (Throwable th) {
                    try {
                        jsonWriter.close();
                    } catch (IOException e4) {
                        Log.e("MixpanelAPI.ViewCrawler", "Can't close websocket writer", e4);
                    }
                    throw th;
                }
            }
        }

        private void a(JSONObject jSONObject) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("payload");
                if (jSONObject2.has("config")) {
                    this.c = this.g.b(jSONObject2);
                    if (com.mixpanel.android.mpmetrics.m.f3036a) {
                        Log.v("MixpanelAPI.ViewCrawler", "Initializing snapshot with configuration");
                    }
                }
                if (this.c == null) {
                    a("No snapshot configuration (or a malformed snapshot configuration) was sent.");
                    Log.w("MixpanelAPI.ViewCrawler", "Mixpanel editor is misconfigured, sent a snapshot request without a valid configuration.");
                    return;
                }
                BufferedOutputStream b = this.b.b();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(b);
                try {
                    try {
                        outputStreamWriter.write("{");
                        outputStreamWriter.write("\"type\": \"snapshot_response\",");
                        outputStreamWriter.write("\"payload\": {");
                        outputStreamWriter.write("\"activities\":");
                        outputStreamWriter.flush();
                        this.c.a(k.this.e, b);
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        outputStreamWriter.write(",\"snapshot_time_millis\": ");
                        outputStreamWriter.write(Long.toString(currentTimeMillis2));
                        outputStreamWriter.write("}");
                        outputStreamWriter.write("}");
                    } catch (IOException e) {
                        Log.e("MixpanelAPI.ViewCrawler", "Can't write snapshot request to server", e);
                        try {
                            outputStreamWriter.close();
                        } catch (IOException e2) {
                            Log.e("MixpanelAPI.ViewCrawler", "Can't close writer.", e2);
                        }
                    }
                } finally {
                    try {
                        outputStreamWriter.close();
                    } catch (IOException e3) {
                        Log.e("MixpanelAPI.ViewCrawler", "Can't close writer.", e3);
                    }
                }
            } catch (EditProtocol.BadInstructionsException e4) {
                Log.e("MixpanelAPI.ViewCrawler", "Editor sent malformed message with snapshot request", e4);
                a(e4.getMessage());
            } catch (JSONException e5) {
                Log.e("MixpanelAPI.ViewCrawler", "Payload with snapshot config required with snapshot request", e5);
                a("Payload with snapshot config required with snapshot request");
            }
        }

        private void b(String str) {
            if (this.b != null) {
                JsonWriter jsonWriter = new JsonWriter(new OutputStreamWriter(this.b.b()));
                try {
                    try {
                        jsonWriter.beginObject();
                        jsonWriter.name("type").value("track_message");
                        jsonWriter.name("payload");
                        jsonWriter.beginObject();
                        jsonWriter.name("event_name").value(str);
                        jsonWriter.endObject();
                        jsonWriter.endObject();
                        jsonWriter.flush();
                        try {
                            jsonWriter.close();
                        } catch (IOException e) {
                            Log.e("MixpanelAPI.ViewCrawler", "Can't close writer.", e);
                        }
                    } catch (Throwable th) {
                        try {
                            jsonWriter.close();
                        } catch (IOException e2) {
                            Log.e("MixpanelAPI.ViewCrawler", "Can't close writer.", e2);
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    Log.e("MixpanelAPI.ViewCrawler", "Can't write track_message to server", e3);
                    try {
                        jsonWriter.close();
                    } catch (IOException e4) {
                        Log.e("MixpanelAPI.ViewCrawler", "Can't close writer.", e4);
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.String] */
        private void a(o.e eVar) {
            if (this.b != null) {
                JsonWriter jsonWriter = new JsonWriter(new OutputStreamWriter(this.b.b()));
                try {
                    try {
                        jsonWriter.beginObject();
                        jsonWriter.name("type").value("layout_error");
                        jsonWriter.name("exception_type").value(eVar.a());
                        jsonWriter.name("cid").value(eVar.b());
                        jsonWriter.endObject();
                    } catch (IOException e) {
                        Log.e("MixpanelAPI.ViewCrawler", "Can't write track_message to server", e);
                        try {
                            jsonWriter.close();
                            jsonWriter = jsonWriter;
                        } catch (IOException e2) {
                            Log.e("MixpanelAPI.ViewCrawler", "Can't close writer.", e2);
                            jsonWriter = "Can't close writer.";
                        }
                    }
                } finally {
                    try {
                        jsonWriter.close();
                    } catch (IOException e3) {
                        Log.e("MixpanelAPI.ViewCrawler", "Can't close writer.", e3);
                    }
                }
            }
        }

        private void b(JSONObject jSONObject) {
            try {
                JSONArray jSONArray = jSONObject.getJSONObject("payload").getJSONArray("actions");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    String a2 = com.mixpanel.android.util.e.a(jSONObject2, "target_activity");
                    this.i.put(jSONObject2.getString("name"), new Pair<>(a2, jSONObject2));
                }
                a(Collections.emptyList());
            } catch (JSONException e) {
                Log.e("MixpanelAPI.ViewCrawler", "Bad change request received", e);
            }
        }

        private void c(JSONObject jSONObject) {
            try {
                JSONArray jSONArray = jSONObject.getJSONObject("payload").getJSONArray("actions");
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.i.remove(jSONArray.getString(i));
                }
            } catch (JSONException e) {
                Log.e("MixpanelAPI.ViewCrawler", "Bad clear request received", e);
            }
            a(Collections.emptyList());
        }

        private void d(JSONObject jSONObject) {
            try {
                this.j.clear();
                JSONArray jSONArray = jSONObject.getJSONObject("payload").getJSONArray("tweaks");
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    this.j.add(jSONArray.getJSONObject(i));
                }
            } catch (JSONException e) {
                Log.e("MixpanelAPI.ViewCrawler", "Bad tweaks received", e);
            }
            a(Collections.emptyList());
        }

        private void a(JSONArray jSONArray) {
            SharedPreferences.Editor edit = g().edit();
            edit.putString("mixpanel.viewcrawler.changes", jSONArray.toString());
            edit.apply();
            c();
        }

        private void b(JSONArray jSONArray) {
            SharedPreferences.Editor edit = g().edit();
            edit.putString("mixpanel.viewcrawler.bindings", jSONArray.toString());
            edit.apply();
            c();
        }

        private void e(JSONObject jSONObject) {
            try {
                JSONArray jSONArray = jSONObject.getJSONObject("payload").getJSONArray("events");
                int length = jSONArray.length();
                this.l.clear();
                for (int i = 0; i < length; i++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        this.l.add(new Pair<>(com.mixpanel.android.util.e.a(jSONObject2, "target_activity"), jSONObject2));
                    } catch (JSONException e) {
                        Log.e("MixpanelAPI.ViewCrawler", "Bad event binding received from editor in " + jSONArray.toString(), e);
                    }
                }
                a(Collections.emptyList());
            } catch (JSONException e2) {
                Log.e("MixpanelAPI.ViewCrawler", "Bad event bindings received", e2);
            }
        }

        private void f() {
            this.i.clear();
            this.l.clear();
            this.c = null;
            if (com.mixpanel.android.mpmetrics.m.f3036a) {
                Log.v("MixpanelAPI.ViewCrawler", "Editor closed- freeing snapshot");
            }
            a(Collections.emptyList());
            Iterator<String> it = this.k.iterator();
            while (it.hasNext()) {
                this.h.b(it.next());
            }
        }

        private void a(List<Pair<Integer, Integer>> list) {
            List arrayList;
            ArrayList arrayList2 = new ArrayList();
            HashSet<Pair> hashSet = new HashSet();
            int size = this.m.size();
            for (int i = 0; i < size; i++) {
                d dVar = this.m.get(i);
                try {
                    arrayList2.add(new Pair(dVar.f3099a, this.g.a(dVar.b).f3078a));
                    if (!this.p.contains(dVar.c)) {
                        hashSet.add(dVar.c);
                    }
                } catch (EditProtocol.CantGetEditAssetsException e) {
                    Log.v("MixpanelAPI.ViewCrawler", "Can't load assets for an edit, won't apply the change now", e);
                } catch (EditProtocol.InapplicableInstructionsException e2) {
                    Log.i("MixpanelAPI.ViewCrawler", e2.getMessage());
                } catch (EditProtocol.BadInstructionsException e3) {
                    Log.e("MixpanelAPI.ViewCrawler", "Bad persistent change request cannot be applied.", e3);
                }
            }
            int size2 = this.n.size();
            for (int i2 = 0; i2 < size2; i2++) {
                e eVar = this.n.get(i2);
                try {
                    Pair<String, Object> c = this.g.c(eVar.f3100a);
                    k.this.f.a((String) c.first, c.second);
                    if (!this.p.contains(eVar.b)) {
                        hashSet.add(eVar.b);
                    }
                } catch (EditProtocol.BadInstructionsException e4) {
                    Log.e("MixpanelAPI.ViewCrawler", "Bad editor tweak cannot be applied.", e4);
                }
            }
            for (Pair<String, JSONObject> pair : this.i.values()) {
                try {
                    EditProtocol.a a2 = this.g.a((JSONObject) pair.second);
                    arrayList2.add(new Pair(pair.first, a2.f3078a));
                    this.k.addAll(a2.b);
                } catch (EditProtocol.BadInstructionsException e5) {
                    Log.e("MixpanelAPI.ViewCrawler", "Bad editor change request cannot be applied.", e5);
                } catch (EditProtocol.CantGetEditAssetsException e6) {
                    Log.v("MixpanelAPI.ViewCrawler", "Can't load assets for an edit, won't apply the change now", e6);
                } catch (EditProtocol.InapplicableInstructionsException e7) {
                    Log.i("MixpanelAPI.ViewCrawler", e7.getMessage());
                }
            }
            int size3 = this.j.size();
            for (int i3 = 0; i3 < size3; i3++) {
                try {
                    Pair<String, Object> c2 = this.g.c(this.j.get(i3));
                    k.this.f.a((String) c2.first, c2.second);
                } catch (EditProtocol.BadInstructionsException e8) {
                    Log.e("MixpanelAPI.ViewCrawler", "Strange tweaks received", e8);
                }
            }
            int size4 = this.o.size();
            for (int i4 = 0; i4 < size4; i4++) {
                Pair<String, JSONObject> pair2 = this.o.get(i4);
                try {
                    arrayList2.add(new Pair(pair2.first, this.g.a((JSONObject) pair2.second, k.this.d)));
                } catch (EditProtocol.InapplicableInstructionsException e9) {
                    Log.i("MixpanelAPI.ViewCrawler", e9.getMessage());
                } catch (EditProtocol.BadInstructionsException e10) {
                    Log.e("MixpanelAPI.ViewCrawler", "Bad persistent event binding cannot be applied.", e10);
                }
            }
            int size5 = this.l.size();
            for (int i5 = 0; i5 < size5; i5++) {
                Pair<String, JSONObject> pair3 = this.l.get(i5);
                try {
                    arrayList2.add(new Pair(pair3.first, this.g.a((JSONObject) pair3.second, k.this.d)));
                } catch (EditProtocol.InapplicableInstructionsException e11) {
                    Log.i("MixpanelAPI.ViewCrawler", e11.getMessage());
                } catch (EditProtocol.BadInstructionsException e12) {
                    Log.e("MixpanelAPI.ViewCrawler", "Bad editor event binding cannot be applied.", e12);
                }
            }
            HashMap hashMap = new HashMap();
            int size6 = arrayList2.size();
            for (int i6 = 0; i6 < size6; i6++) {
                Pair pair4 = (Pair) arrayList2.get(i6);
                if (hashMap.containsKey(pair4.first)) {
                    arrayList = (List) hashMap.get(pair4.first);
                } else {
                    arrayList = new ArrayList();
                    hashMap.put(pair4.first, arrayList);
                }
                arrayList.add(pair4.second);
            }
            k.this.e.a((Map<String, List<o>>) hashMap);
            for (Pair<Integer, Integer> pair5 : list) {
                if (!this.p.contains(pair5)) {
                    hashSet.add(pair5);
                }
            }
            this.p.addAll(hashSet);
            if (hashSet.size() > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    for (Pair pair6 : hashSet) {
                        int intValue = ((Integer) pair6.first).intValue();
                        int intValue2 = ((Integer) pair6.second).intValue();
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("$experiment_id", intValue);
                        jSONObject2.put("$variant_id", intValue2);
                        jSONObject.put(Integer.toString(intValue), intValue2);
                        k.this.c.c().a("$experiments", jSONObject);
                        k.this.c.a(new m(this, jSONObject));
                        k.this.c.a("$experiment_started", jSONObject2);
                    }
                } catch (JSONException e13) {
                    Log.wtf("MixpanelAPI.ViewCrawler", "Could not build JSON for reporting experiment start", e13);
                }
            }
        }

        private SharedPreferences g() {
            return this.d.getSharedPreferences("mixpanel.viewcrawler.changes" + this.e, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewCrawler.java */
    /* loaded from: classes.dex */
    public class a implements EditorConnection.a {
        private a() {
        }

        /* synthetic */ a(k kVar, l lVar) {
            this();
        }

        @Override // com.mixpanel.android.viewcrawler.EditorConnection.a
        public void a(JSONObject jSONObject) {
            Message obtainMessage = k.this.h.obtainMessage(2);
            obtainMessage.obj = jSONObject;
            k.this.h.sendMessage(obtainMessage);
        }

        @Override // com.mixpanel.android.viewcrawler.EditorConnection.a
        public void b(JSONObject jSONObject) {
            Message obtainMessage = k.this.h.obtainMessage(3);
            obtainMessage.obj = jSONObject;
            k.this.h.sendMessage(obtainMessage);
        }

        @Override // com.mixpanel.android.viewcrawler.EditorConnection.a
        public void c(JSONObject jSONObject) {
            Message obtainMessage = k.this.h.obtainMessage(10);
            obtainMessage.obj = jSONObject;
            k.this.h.sendMessage(obtainMessage);
        }

        @Override // com.mixpanel.android.viewcrawler.EditorConnection.a
        public void e(JSONObject jSONObject) {
            Message obtainMessage = k.this.h.obtainMessage(11);
            obtainMessage.obj = jSONObject;
            k.this.h.sendMessage(obtainMessage);
        }

        @Override // com.mixpanel.android.viewcrawler.EditorConnection.a
        public void d(JSONObject jSONObject) {
            Message obtainMessage = k.this.h.obtainMessage(6);
            obtainMessage.obj = jSONObject;
            k.this.h.sendMessage(obtainMessage);
        }

        @Override // com.mixpanel.android.viewcrawler.EditorConnection.a
        public void a() {
            k.this.h.sendMessage(k.this.h.obtainMessage(4));
        }

        @Override // com.mixpanel.android.viewcrawler.EditorConnection.a
        public void b() {
            k.this.h.sendMessage(k.this.h.obtainMessage(8));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewCrawler.java */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final String f3099a;
        public final JSONObject b;
        public final Pair<Integer, Integer> c;

        public d(String str, JSONObject jSONObject, Pair<Integer, Integer> pair) {
            this.f3099a = str;
            this.b = jSONObject;
            this.c = pair;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewCrawler.java */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final JSONObject f3100a;
        public final Pair<Integer, Integer> b;

        public e(JSONObject jSONObject, Pair<Integer, Integer> pair) {
            this.f3100a = jSONObject;
            this.b = pair;
        }
    }
}
