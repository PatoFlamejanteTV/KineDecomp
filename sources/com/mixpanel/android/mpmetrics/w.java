package com.mixpanel.android.mpmetrics;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PersistentIdentity.java */
@SuppressLint({"CommitPrefEdits"})
/* loaded from: classes.dex */
public class w {
    private static boolean j = true;
    private static final Object k = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final Future<SharedPreferences> f3049a;
    private final Future<SharedPreferences> b;
    private String g;
    private String h;
    private JSONArray i;
    private JSONObject d = null;
    private Map<String, String> e = null;
    private boolean f = false;
    private final SharedPreferences.OnSharedPreferenceChangeListener c = new x(this);

    public static JSONArray a(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString("people_distinct_id", null);
        String string2 = sharedPreferences.getString("waiting_array", null);
        if (string2 == null || string == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(string2);
            JSONArray jSONArray2 = new JSONArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    jSONObject.put("$distinct_id", string);
                    jSONArray2.put(jSONObject);
                } catch (JSONException e) {
                    Log.e("MixpanelAPI.PIdentity", "Unparsable object found in waiting people records", e);
                }
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.remove("waiting_array");
            a(edit);
            return jSONArray2;
        } catch (JSONException e2) {
            Log.e("MixpanelAPI.PIdentity", "Waiting people records were unreadable.");
            return null;
        }
    }

    public static void a(Context context, String str, Map<String, String> map) {
        synchronized (k) {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.clear();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                edit.putString(entry.getKey(), entry.getValue());
            }
            a(edit);
            j = true;
        }
    }

    public w(Future<SharedPreferences> future, Future<SharedPreferences> future2) {
        this.b = future;
        this.f3049a = future2;
    }

    public synchronized void a(JSONObject jSONObject) {
        JSONObject g = g();
        Iterator<String> keys = g.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                jSONObject.put(next, g.get(next));
            } catch (JSONException e) {
                Log.wtf("MixpanelAPI.PIdentity", "Object read from one JSON Object cannot be written to another", e);
            }
        }
    }

    public synchronized void a(ab abVar) {
        JSONObject g = g();
        JSONObject jSONObject = new JSONObject();
        try {
            Iterator<String> keys = g.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, g.get(next));
            }
            JSONObject a2 = abVar.a(jSONObject);
            if (a2 == null) {
                Log.w("MixpanelAPI.PIdentity", "An update to Mixpanel's super properties returned null, and will have no effect.");
            } else {
                this.d = a2;
                j();
            }
        } catch (JSONException e) {
            Log.wtf("MixpanelAPI.PIdentity", "Can't copy from one JSONObject to another", e);
        }
    }

    public Map<String, String> a() {
        synchronized (k) {
            if (j || this.e == null) {
                i();
                j = false;
            }
        }
        return this.e;
    }

    public synchronized String b() {
        if (!this.f) {
            k();
        }
        return this.g;
    }

    public synchronized String c() {
        if (!this.f) {
            k();
        }
        return this.h;
    }

    public synchronized void a(String str) {
        if (!this.f) {
            k();
        }
        this.h = str;
        l();
    }

    public synchronized void b(JSONObject jSONObject) {
        if (!this.f) {
            k();
        }
        if (this.i == null) {
            this.i = new JSONArray();
        }
        this.i.put(jSONObject);
        l();
    }

    public synchronized JSONArray d() {
        JSONArray jSONArray;
        ExecutionException e;
        InterruptedException e2;
        try {
            jSONArray = a(this.f3049a.get());
            try {
                k();
            } catch (InterruptedException e3) {
                e2 = e3;
                Log.e("MixpanelAPI.PIdentity", "Couldn't read waiting people records from shared preferences.", e2);
                return jSONArray;
            } catch (ExecutionException e4) {
                e = e4;
                Log.e("MixpanelAPI.PIdentity", "Couldn't read waiting people records from shared preferences.", e.getCause());
                return jSONArray;
            }
        } catch (InterruptedException e5) {
            jSONArray = null;
            e2 = e5;
        } catch (ExecutionException e6) {
            jSONArray = null;
            e = e6;
        }
        return jSONArray;
    }

    public synchronized void c(JSONObject jSONObject) {
        JSONObject g = g();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                g.put(next, jSONObject.get(next));
            } catch (JSONException e) {
                Log.e("MixpanelAPI.PIdentity", "Exception registering super property.", e);
            }
        }
        j();
    }

    public synchronized void b(String str) {
        try {
            SharedPreferences.Editor edit = this.f3049a.get().edit();
            edit.putString("push_id", str);
            a(edit);
        } catch (InterruptedException e) {
            Log.e("MixpanelAPI.PIdentity", "Can't write push id to shared preferences", e);
        } catch (ExecutionException e2) {
            Log.e("MixpanelAPI.PIdentity", "Can't write push id to shared preferences", e2.getCause());
        }
    }

    public synchronized String e() {
        String str;
        try {
            str = this.f3049a.get().getString("push_id", null);
        } catch (InterruptedException e) {
            Log.e("MixpanelAPI.PIdentity", "Can't write push id to shared preferences", e);
            str = null;
        } catch (ExecutionException e2) {
            Log.e("MixpanelAPI.PIdentity", "Can't write push id to shared preferences", e2.getCause());
            str = null;
        }
        return str;
    }

    private JSONObject g() {
        if (this.d == null) {
            h();
        }
        return this.d;
    }

    private void h() {
        try {
            try {
                try {
                    try {
                        String string = this.f3049a.get().getString("super_properties", "{}");
                        if (m.f3036a) {
                            Log.v("MixpanelAPI.PIdentity", "Loading Super Properties " + string);
                        }
                        this.d = new JSONObject(string);
                        if (this.d == null) {
                            this.d = new JSONObject();
                        }
                    } catch (InterruptedException e) {
                        Log.e("MixpanelAPI.PIdentity", "Cannot load superProperties from SharedPreferences.", e);
                        if (this.d == null) {
                            this.d = new JSONObject();
                        }
                    }
                } catch (ExecutionException e2) {
                    Log.e("MixpanelAPI.PIdentity", "Cannot load superProperties from SharedPreferences.", e2.getCause());
                    if (this.d == null) {
                        this.d = new JSONObject();
                    }
                }
            } catch (JSONException e3) {
                Log.e("MixpanelAPI.PIdentity", "Cannot parse stored superProperties");
                j();
                if (this.d == null) {
                    this.d = new JSONObject();
                }
            }
        } catch (Throwable th) {
            if (this.d == null) {
                this.d = new JSONObject();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.e = new HashMap();
        try {
            SharedPreferences sharedPreferences = this.b.get();
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(this.c);
            sharedPreferences.registerOnSharedPreferenceChangeListener(this.c);
            for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                this.e.put(entry.getKey(), entry.getValue().toString());
            }
        } catch (InterruptedException e) {
            Log.e("MixpanelAPI.PIdentity", "Cannot load referrer properties from shared preferences.", e);
        } catch (ExecutionException e2) {
            Log.e("MixpanelAPI.PIdentity", "Cannot load referrer properties from shared preferences.", e2.getCause());
        }
    }

    private void j() {
        if (this.d == null) {
            Log.e("MixpanelAPI.PIdentity", "storeSuperProperties should not be called with uninitialized superPropertiesCache.");
            return;
        }
        String jSONObject = this.d.toString();
        if (m.f3036a) {
            Log.v("MixpanelAPI.PIdentity", "Storing Super Properties " + jSONObject);
        }
        try {
            SharedPreferences.Editor edit = this.f3049a.get().edit();
            edit.putString("super_properties", jSONObject);
            a(edit);
        } catch (InterruptedException e) {
            Log.e("MixpanelAPI.PIdentity", "Cannot store superProperties in shared preferences.", e);
        } catch (ExecutionException e2) {
            Log.e("MixpanelAPI.PIdentity", "Cannot store superProperties in shared preferences.", e2.getCause());
        }
    }

    private void k() {
        SharedPreferences sharedPreferences;
        try {
            sharedPreferences = this.f3049a.get();
        } catch (InterruptedException e) {
            Log.e("MixpanelAPI.PIdentity", "Cannot read distinct ids from sharedPreferences.", e);
            sharedPreferences = null;
        } catch (ExecutionException e2) {
            Log.e("MixpanelAPI.PIdentity", "Cannot read distinct ids from sharedPreferences.", e2.getCause());
            sharedPreferences = null;
        }
        if (sharedPreferences != null) {
            this.g = sharedPreferences.getString("events_distinct_id", null);
            this.h = sharedPreferences.getString("people_distinct_id", null);
            this.i = null;
            String string = sharedPreferences.getString("waiting_array", null);
            if (string != null) {
                try {
                    this.i = new JSONArray(string);
                } catch (JSONException e3) {
                    Log.e("MixpanelAPI.PIdentity", "Could not interpret waiting people JSON record " + string);
                }
            }
            if (this.g == null) {
                this.g = UUID.randomUUID().toString();
                l();
            }
            this.f = true;
        }
    }

    private void l() {
        try {
            SharedPreferences.Editor edit = this.f3049a.get().edit();
            edit.putString("events_distinct_id", this.g);
            edit.putString("people_distinct_id", this.h);
            if (this.i == null) {
                edit.remove("waiting_array");
            } else {
                edit.putString("waiting_array", this.i.toString());
            }
            a(edit);
        } catch (InterruptedException e) {
            Log.e("MixpanelAPI.PIdentity", "Can't write distinct ids to shared preferences.", e);
        } catch (ExecutionException e2) {
            Log.e("MixpanelAPI.PIdentity", "Can't write distinct ids to shared preferences.", e2.getCause());
        }
    }

    @TargetApi(9)
    private static void a(SharedPreferences.Editor editor) {
        if (Build.VERSION.SDK_INT >= 9) {
            editor.apply();
        } else {
            editor.commit();
        }
    }
}
