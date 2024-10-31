package com.mixpanel.android.viewcrawler;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mixpanel.android.viewcrawler.o;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DynamicEventTracker.java */
/* loaded from: classes.dex */
public class b implements o.h {
    private static String e = "MixpanelAPI.DynamicEventTracker";

    /* renamed from: a, reason: collision with root package name */
    private final com.mixpanel.android.mpmetrics.n f3082a;
    private final Handler b;
    private final Map<C0059b, c> d = new HashMap();
    private final Runnable c = new a();

    public b(com.mixpanel.android.mpmetrics.n nVar, Handler handler) {
        this.f3082a = nVar;
        this.b = handler;
    }

    @Override // com.mixpanel.android.viewcrawler.o.h
    public void a(View view, String str, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("$text", a(view));
            jSONObject.put("$from_binding", true);
            jSONObject.put("time", currentTimeMillis / 1000);
        } catch (JSONException e2) {
            Log.e(e, "Can't format properties from view due to JSON issue", e2);
        }
        if (z) {
            C0059b c0059b = new C0059b(view, str);
            c cVar = new c(str, jSONObject, currentTimeMillis);
            synchronized (this.d) {
                boolean isEmpty = this.d.isEmpty();
                this.d.put(c0059b, cVar);
                if (isEmpty) {
                    this.b.postDelayed(this.c, 1000L);
                }
            }
            return;
        }
        this.f3082a.a(str, jSONObject);
    }

    /* compiled from: DynamicEventTracker.java */
    /* loaded from: classes.dex */
    private final class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (b.this.d) {
                Iterator it = b.this.d.entrySet().iterator();
                while (it.hasNext()) {
                    c cVar = (c) ((Map.Entry) it.next()).getValue();
                    if (currentTimeMillis - cVar.f3085a > 1000) {
                        b.this.f3082a.a(cVar.b, cVar.c);
                        it.remove();
                    }
                }
                if (!b.this.d.isEmpty()) {
                    b.this.b.postDelayed(this, 500L);
                }
            }
        }
    }

    private static String a(View view) {
        if (view instanceof TextView) {
            CharSequence text = ((TextView) view).getText();
            if (text == null) {
                return null;
            }
            return text.toString();
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount && sb.length() < 128; i++) {
            String a2 = a(viewGroup.getChildAt(i));
            if (a2 != null && a2.length() > 0) {
                if (z) {
                    sb.append(", ");
                }
                sb.append(a2);
                z = true;
            }
        }
        if (sb.length() > 128) {
            return sb.substring(0, 128);
        }
        if (!z) {
            return null;
        }
        return sb.toString();
    }

    /* compiled from: DynamicEventTracker.java */
    /* renamed from: com.mixpanel.android.viewcrawler.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0059b {

        /* renamed from: a, reason: collision with root package name */
        private final int f3084a;

        public C0059b(View view, String str) {
            this.f3084a = view.hashCode() ^ str.hashCode();
        }

        public boolean equals(Object obj) {
            return (obj instanceof C0059b) && this.f3084a == obj.hashCode();
        }

        public int hashCode() {
            return this.f3084a;
        }
    }

    /* compiled from: DynamicEventTracker.java */
    /* loaded from: classes.dex */
    private static class c {

        /* renamed from: a, reason: collision with root package name */
        public final long f3085a;
        public final String b;
        public final JSONObject c;

        public c(String str, JSONObject jSONObject, long j) {
            this.b = str;
            this.c = jSONObject;
            this.f3085a = j;
        }
    }
}
