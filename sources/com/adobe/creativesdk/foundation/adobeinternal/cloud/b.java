package com.adobe.creativesdk.foundation.adobeinternal.cloud;

import android.util.Log;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeCloudManager.java */
/* loaded from: classes.dex */
public class b implements c.a.a.a.b<JSONObject> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f3941a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f3942b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f3943c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ d f3944d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(d dVar, d dVar2, c.a.a.a.b bVar, c.a.a.a.c cVar) {
        this.f3944d = dVar;
        this.f3941a = dVar2;
        this.f3942b = bVar;
        this.f3943c = cVar;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(JSONObject jSONObject) {
        ArrayList arrayList;
        ArrayList arrayList2;
        d dVar;
        ArrayList arrayList3;
        String str = null;
        Za.a(d.class.getSimpleName(), "refreshClouds", "onCompletion", null);
        boolean b2 = d.b(jSONObject);
        AdobeEntitlementServices.b().d();
        AdobeEntitlementServices.b().b(b2);
        boolean a2 = d.a(jSONObject);
        AdobeEntitlementServices.b().c();
        AdobeEntitlementServices.b().a(a2);
        ArrayList arrayList4 = new ArrayList();
        try {
            h.a(jSONObject, arrayList4);
            dVar = d.f3947a;
            arrayList3 = dVar.f3951e;
            boolean a3 = h.a(arrayList4, arrayList3);
            if (!arrayList4.isEmpty() && !a3) {
                this.f3941a.a(arrayList4);
            }
            e = null;
        } catch (AdobeCSDKException e2) {
            e = e2;
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, d.class.getSimpleName(), null, e);
        }
        arrayList = this.f3941a.f3951e;
        if (!arrayList.isEmpty()) {
            if (this.f3942b != null) {
                Za.a(d.class.getSimpleName(), "refreshClouds", "onSuccess", null);
                c.a.a.a.b bVar = this.f3942b;
                arrayList2 = this.f3941a.f3951e;
                bVar.b(arrayList2);
                return;
            }
            return;
        }
        String simpleName = d.class.getSimpleName();
        StringBuilder sb = new StringBuilder();
        sb.append("Empty cloud list: ");
        if (e != null) {
            str = Log.getStackTraceString(e) + e.getDescription();
        }
        sb.append(str);
        Za.a(simpleName, "refreshClouds", sb.toString(), jSONObject.toString());
        this.f3943c.a(e);
    }
}
