package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzn;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzbb;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zziz;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
/* loaded from: classes.dex */
public class zzh {

    /* renamed from: a, reason: collision with root package name */
    private final Object f578a = new Object();
    private final zzn b;
    private final Context c;
    private final JSONObject d;
    private final zzbb e;
    private final zza f;
    private final zzan g;
    private final VersionInfoParcel h;
    private boolean i;
    private zziz j;
    private String k;

    /* loaded from: classes.dex */
    public interface zza {
        String a();

        void a(zzh zzhVar);

        com.google.android.gms.ads.internal.formats.zza b();

        String getCustomTemplateId();
    }

    public zzh(Context context, zzn zznVar, zzbb zzbbVar, zzan zzanVar, JSONObject jSONObject, zza zzaVar, VersionInfoParcel versionInfoParcel) {
        this.c = context;
        this.b = zznVar;
        this.e = zzbbVar;
        this.g = zzanVar;
        this.d = jSONObject;
        this.f = zzaVar;
        this.h = versionInfoParcel;
    }

    public a a(View.OnClickListener onClickListener) {
        com.google.android.gms.ads.internal.formats.zza b = this.f.b();
        if (b == null) {
            return null;
        }
        a aVar = new a(this.c, b);
        aVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        aVar.a().setOnClickListener(onClickListener);
        aVar.a().setContentDescription("Ad attribution icon");
        return aVar;
    }

    public void a() {
        zzx.b("recordImpression must be called on the main UI thread.");
        a(true);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", this.d);
            this.e.zza("google.afma.nativeAds.handleImpressionPing", jSONObject);
        } catch (JSONException e) {
            zzb.b("Unable to create impression JSON.", e);
        }
    }

    public void a(MotionEvent motionEvent) {
        this.g.zza(motionEvent);
    }

    public void a(View view) {
    }

    public void a(View view, Map<String, WeakReference<View>> map, JSONObject jSONObject, JSONObject jSONObject2) {
        zzx.b("performClick must be called on the main UI thread.");
        for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
            if (view.equals(entry.getValue().get())) {
                a(entry.getKey(), jSONObject, jSONObject2);
                return;
            }
        }
    }

    public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        zzx.b("performClick must be called on the main UI thread.");
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("asset", str);
            jSONObject3.put("template", this.f.a());
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("ad", this.d);
            jSONObject4.put("click", jSONObject3);
            jSONObject4.put("has_custom_click_handler", this.b.a(this.f.getCustomTemplateId()) != null);
            if (jSONObject != null) {
                jSONObject4.put("view_rectangles", jSONObject);
            }
            if (jSONObject2 != null) {
                jSONObject4.put("click_point", jSONObject2);
            }
            this.e.zza("google.afma.nativeAds.handleClickGmsg", jSONObject4);
        } catch (JSONException e) {
            zzb.b("Unable to create click JSON.", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z) {
        this.i = z;
    }

    public void b(View view) {
        synchronized (this.f578a) {
            if (this.i) {
                return;
            }
            if (view.isShown()) {
                if (view.getGlobalVisibleRect(new Rect(), null)) {
                    a();
                }
            }
        }
    }

    public zziz c() {
        this.j = d();
        this.j.getView().setVisibility(8);
        this.e.zza("/loadHtml", new b(this));
        this.e.zza("/showOverlay", new d(this));
        this.e.zza("/hideOverlay", new e(this));
        this.j.zzhe().zza("/hideOverlay", new f(this));
        this.j.zzhe().zza("/sendMessageToSdk", new g(this));
        return this.j;
    }

    zziz d() {
        return zzp.f().zza(this.c, AdSizeParcel.a(this.c), false, false, this.g, this.h);
    }

    public Context e() {
        return this.c;
    }
}
