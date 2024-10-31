package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import com.facebook.GraphRequest;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Utility;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SessionEventsState.java */
/* loaded from: classes.dex */
public class y {

    /* renamed from: c */
    private int f9231c;

    /* renamed from: d */
    private AttributionIdentifiers f9232d;

    /* renamed from: e */
    private String f9233e;

    /* renamed from: a */
    private List<AppEvent> f9229a = new ArrayList();

    /* renamed from: b */
    private List<AppEvent> f9230b = new ArrayList();

    /* renamed from: f */
    private final int f9234f = 1000;

    public y(AttributionIdentifiers attributionIdentifiers, String str) {
        this.f9232d = attributionIdentifiers;
        this.f9233e = str;
    }

    public synchronized void a(AppEvent appEvent) {
        if (this.f9229a.size() + this.f9230b.size() >= 1000) {
            this.f9231c++;
        } else {
            this.f9229a.add(appEvent);
        }
    }

    public synchronized List<AppEvent> b() {
        List<AppEvent> list;
        list = this.f9229a;
        this.f9229a = new ArrayList();
        return list;
    }

    public synchronized int a() {
        return this.f9229a.size();
    }

    public synchronized void a(boolean z) {
        if (z) {
            this.f9229a.addAll(this.f9230b);
        }
        this.f9230b.clear();
        this.f9231c = 0;
    }

    public int a(GraphRequest graphRequest, Context context, boolean z, boolean z2) {
        synchronized (this) {
            int i = this.f9231c;
            this.f9230b.addAll(this.f9229a);
            this.f9229a.clear();
            JSONArray jSONArray = new JSONArray();
            for (AppEvent appEvent : this.f9230b) {
                if (appEvent.isChecksumValid()) {
                    if (z || !appEvent.getIsImplicit()) {
                        jSONArray.put(appEvent.getJSONObject());
                    }
                } else {
                    Utility.logd("Event with invalid checksum: %s", appEvent.toString());
                }
            }
            if (jSONArray.length() == 0) {
                return 0;
            }
            a(graphRequest, context, i, jSONArray, z2);
            return jSONArray.length();
        }
    }

    private void a(GraphRequest graphRequest, Context context, int i, JSONArray jSONArray, boolean z) {
        JSONObject jSONObject;
        try {
            jSONObject = AppEventsLoggerUtility.getJSONObjectForGraphAPICall(AppEventsLoggerUtility.GraphAPIActivityType.CUSTOM_APP_EVENTS, this.f9232d, this.f9233e, z, context);
            if (this.f9231c > 0) {
                jSONObject.put("num_skipped_events", i);
            }
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
        }
        graphRequest.setGraphObject(jSONObject);
        Bundle parameters = graphRequest.getParameters();
        if (parameters == null) {
            parameters = new Bundle();
        }
        String jSONArray2 = jSONArray.toString();
        if (jSONArray2 != null) {
            parameters.putByteArray("custom_events_file", a(jSONArray2));
            graphRequest.setTag(jSONArray2);
        }
        graphRequest.setParameters(parameters);
    }

    private byte[] a(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e2) {
            Utility.logd("Encoding exception: ", e2);
            return null;
        }
    }
}
