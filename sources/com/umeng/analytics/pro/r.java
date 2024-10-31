package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.g;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ViewPageTracker.java */
/* loaded from: classes3.dex */
public class r {

    /* renamed from: b */
    private static final int f25962b = 5;

    /* renamed from: c */
    private static JSONArray f25963c = new JSONArray();

    /* renamed from: d */
    private static Object f25964d = new Object();

    /* renamed from: e */
    private final Map<String, Long> f25966e = new HashMap();

    /* renamed from: a */
    Stack<String> f25965a = new Stack<>();

    public static void a(Context context) {
        String jSONArray;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (f25964d) {
                    jSONArray = f25963c.toString();
                    f25963c = new JSONArray();
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("__a", new JSONArray(jSONArray));
                    if (jSONObject.length() > 0) {
                        g.a(context).a(q.a().c(), jSONObject, g.a.PAGE);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    protected int a() {
        return 2;
    }

    public void b(String str) {
        Long l;
        Context appContext;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f25966e.containsKey(str)) {
            synchronized (this.f25966e) {
                l = this.f25966e.get(str);
            }
            if (l == null) {
                return;
            }
            if (UMConfigure.isDebugLog() && this.f25965a.size() > 0 && str.equals(this.f25965a.peek())) {
                this.f25965a.pop();
            }
            long currentTimeMillis = System.currentTimeMillis() - l.longValue();
            synchronized (f25964d) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(b.u, str);
                    jSONObject.put("duration", currentTimeMillis);
                    jSONObject.put(b.w, l);
                    jSONObject.put("type", a());
                    f25963c.put(jSONObject);
                    if (f25963c.length() >= 5 && (appContext = UMGlobalContext.getAppContext(null)) != null) {
                        UMWorkDispatch.sendEvent(appContext, 4099, CoreProtocol.getInstance(appContext), null);
                    }
                } catch (Throwable unused) {
                }
            }
            if (!UMConfigure.isDebugLog() || this.f25965a.size() == 0) {
                return;
            }
            UMLog.aq(h.E, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
            return;
        }
        if (UMConfigure.isDebugLog() && this.f25965a.size() == 0) {
            UMLog.aq(h.G, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (UMConfigure.isDebugLog() && this.f25965a.size() != 0) {
            UMLog.aq(h.F, 0, "\\|", new String[]{"@"}, new String[]{this.f25965a.peek()}, null, null);
        }
        synchronized (this.f25966e) {
            this.f25966e.put(str, Long.valueOf(System.currentTimeMillis()));
            if (UMConfigure.isDebugLog()) {
                this.f25965a.push(str);
            }
        }
    }

    public void b() {
        String str;
        synchronized (this.f25966e) {
            str = null;
            long j = 0;
            for (Map.Entry<String, Long> entry : this.f25966e.entrySet()) {
                if (entry.getValue().longValue() > j) {
                    long longValue = entry.getValue().longValue();
                    str = entry.getKey();
                    j = longValue;
                }
            }
        }
        if (str != null) {
            b(str);
        }
    }
}
