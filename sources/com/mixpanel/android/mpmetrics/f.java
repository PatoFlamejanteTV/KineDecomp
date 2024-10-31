package com.mixpanel.android.mpmetrics;

import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DecideMessages.java */
/* loaded from: classes.dex */
public class f {
    private static final Set<Integer> j = new HashSet();
    private final String b;
    private final a g;
    private final com.mixpanel.android.viewcrawler.j h;
    private JSONArray i;

    /* renamed from: a, reason: collision with root package name */
    private String f3029a = null;
    private final List<Survey> e = new LinkedList();
    private final List<InAppNotification> f = new LinkedList();
    private final Set<Integer> c = new HashSet();
    private final Set<Integer> d = new HashSet();

    /* compiled from: DecideMessages.java */
    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    public f(String str, a aVar, com.mixpanel.android.viewcrawler.j jVar) {
        this.b = str;
        this.g = aVar;
        this.h = jVar;
    }

    public String a() {
        return this.b;
    }

    public synchronized void a(String str) {
        if (this.f3029a == null || !this.f3029a.equals(str)) {
            this.e.clear();
            this.f.clear();
        }
        this.f3029a = str;
    }

    public synchronized String b() {
        return this.f3029a;
    }

    public synchronized void a(List<Survey> list, List<InAppNotification> list2, JSONArray jSONArray, JSONArray jSONArray2) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        synchronized (this) {
            this.h.a(jSONArray);
            boolean z4 = false;
            for (Survey survey : list) {
                int b = survey.b();
                if (this.c.contains(Integer.valueOf(b))) {
                    z2 = z4;
                } else {
                    this.c.add(Integer.valueOf(b));
                    this.e.add(survey);
                    z2 = true;
                }
                z4 = z2;
            }
            for (InAppNotification inAppNotification : list2) {
                int b2 = inAppNotification.b();
                if (this.d.contains(Integer.valueOf(b2))) {
                    z = z4;
                } else {
                    this.d.add(Integer.valueOf(b2));
                    this.f.add(inAppNotification);
                    z = true;
                }
                z4 = z;
            }
            int length = jSONArray2.length();
            int i = 0;
            while (true) {
                if (i >= length) {
                    z3 = false;
                    break;
                }
                try {
                } catch (JSONException e) {
                    Log.e("MixpanelAPI.DecideUpdts", "Could not convert variants[" + i + "] into a JSONObject while comparing the new variants", e);
                }
                if (j.contains(Integer.valueOf(jSONArray2.getJSONObject(i).getInt(ShareConstants.WEB_DIALOG_PARAM_ID)))) {
                    continue;
                    i++;
                } else {
                    this.i = jSONArray2;
                    z4 = true;
                    break;
                }
            }
            if (z3) {
                j.clear();
                for (int i2 = 0; i2 < length; i2++) {
                    try {
                        j.add(Integer.valueOf(this.i.getJSONObject(i2).getInt(ShareConstants.WEB_DIALOG_PARAM_ID)));
                    } catch (JSONException e2) {
                        Log.e("MixpanelAPI.DecideUpdts", "Could not convert variants[" + i2 + "] into a JSONObject while updating the map", e2);
                    }
                }
            }
            if (m.f3036a) {
                Log.v("MixpanelAPI.DecideUpdts", "New Decide content has become available. " + list.size() + " surveys, " + list2.size() + " notifications and " + jSONArray2.length() + " experiments have been added.");
            }
            if (z4 && d() && this.g != null) {
                this.g.a();
            }
        }
    }

    public synchronized Survey a(boolean z) {
        Survey remove;
        if (this.e.isEmpty()) {
            remove = null;
        } else {
            remove = this.e.remove(0);
            if (z) {
                this.e.add(remove);
            }
        }
        return remove;
    }

    public synchronized JSONArray c() {
        return this.i;
    }

    public synchronized InAppNotification b(boolean z) {
        InAppNotification remove;
        if (this.f.isEmpty()) {
            if (m.f3036a) {
                Log.v("MixpanelAPI.DecideUpdts", "No unseen notifications exist, none will be returned.");
            }
            remove = null;
        } else {
            remove = this.f.remove(0);
            if (z) {
                this.f.add(remove);
            } else if (m.f3036a) {
                Log.v("MixpanelAPI.DecideUpdts", "Recording notification " + remove + " as seen.");
            }
        }
        return remove;
    }

    public synchronized void a(InAppNotification inAppNotification) {
        if (!m.f3036a) {
            this.f.add(inAppNotification);
        }
    }

    public synchronized boolean d() {
        boolean z;
        if (this.f.isEmpty() && this.e.isEmpty()) {
            z = this.i != null;
        }
        return z;
    }
}
