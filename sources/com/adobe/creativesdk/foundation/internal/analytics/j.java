package com.adobe.creativesdk.foundation.internal.analytics;

import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIMSEnvironment;
import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIdentityManagementService;
import com.adobe.creativesdk.foundation.internal.utils.w;
import com.birbit.android.jobqueue.c.b;
import com.facebook.share.internal.ShareConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdobeAnalyticsETSJobManager.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a */
    private static j f4733a;

    /* renamed from: b */
    private com.birbit.android.jobqueue.r f4734b;

    /* renamed from: c */
    private ArrayList<JSONObject> f4735c = null;

    /* renamed from: d */
    private TimerTask f4736d = null;

    /* renamed from: e */
    private Timer f4737e = null;

    private j() {
        this.f4734b = null;
        h hVar = new h(this);
        b.a aVar = new b.a(c.a.a.a.c.a.a.b().a());
        aVar.a(hVar);
        aVar.a("AnalyticsJobManager");
        this.f4734b = new com.birbit.android.jobqueue.r(aVar.a());
    }

    private JSONObject b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("time", w.c());
        jSONObject.put("ingesttype", "dunamis");
        if (AdobeAuthIdentityManagementService.K().w() == AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentProductionUS) {
            jSONObject.put("environment", "prod");
        } else {
            jSONObject.put("environment", "stage");
        }
        return jSONObject;
    }

    private void c() {
        this.f4737e = new Timer();
        this.f4736d = new i(this);
        this.f4737e.schedule(this.f4736d, 5000L, 10000L);
    }

    public synchronized void d() {
        if (this.f4735c != null) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            Iterator<JSONObject> it = this.f4735c.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            try {
                jSONObject.put(com.umeng.analytics.pro.b.ao, jSONArray);
                this.f4734b.a(new AdobeAnalyticsETSJob(jSONObject.toString()));
                this.f4735c = null;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static j a() {
        if (f4733a == null) {
            f4733a = new j();
            f4733a.c();
        }
        return f4733a;
    }

    public synchronized void a(g gVar) {
        Map<String, Object> map = gVar.f4730c;
        if (this.f4735c == null) {
            this.f4735c = new ArrayList<>();
        }
        if (this.f4735c.size() >= 15) {
            this.f4735c.remove(0);
        }
        new JSONObject();
        try {
            JSONObject b2 = b();
            if (map.get("project") != null) {
                b2.put("project", map.get("project"));
                map.remove("project");
                b2.put(ShareConstants.WEB_DIALOG_PARAM_DATA, new JSONObject(map));
                this.f4735c.add(b2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
