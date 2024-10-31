package com.facebook.applinks;

import android.net.Uri;
import bolts.c;
import bolts.p;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.places.model.PlaceFields;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FacebookAppLinkResolver.java */
/* loaded from: classes.dex */
public class c implements GraphRequest.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ p.a f9240a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Map f9241b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ HashSet f9242c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ FacebookAppLinkResolver f9243d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FacebookAppLinkResolver facebookAppLinkResolver, p.a aVar, Map map, HashSet hashSet) {
        this.f9243d = facebookAppLinkResolver;
        this.f9240a = aVar;
        this.f9241b = map;
        this.f9242c = hashSet;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        Uri webFallbackUriFromJson;
        HashMap hashMap;
        HashMap hashMap2;
        c.a androidTargetFromJson;
        FacebookRequestError error = graphResponse.getError();
        if (error != null) {
            this.f9240a.a((Exception) error.getException());
            return;
        }
        JSONObject jSONObject = graphResponse.getJSONObject();
        if (jSONObject == null) {
            this.f9240a.a((p.a) this.f9241b);
            return;
        }
        Iterator it = this.f9242c.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (jSONObject.has(uri.toString())) {
                try {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(uri.toString()).getJSONObject(PlaceFields.APP_LINKS);
                    JSONArray jSONArray = jSONObject2.getJSONArray("android");
                    int length = jSONArray.length();
                    ArrayList arrayList = new ArrayList(length);
                    for (int i = 0; i < length; i++) {
                        androidTargetFromJson = FacebookAppLinkResolver.getAndroidTargetFromJson(jSONArray.getJSONObject(i));
                        if (androidTargetFromJson != null) {
                            arrayList.add(androidTargetFromJson);
                        }
                    }
                    webFallbackUriFromJson = FacebookAppLinkResolver.getWebFallbackUriFromJson(uri, jSONObject2);
                    bolts.c cVar = new bolts.c(uri, arrayList, webFallbackUriFromJson);
                    this.f9241b.put(uri, cVar);
                    hashMap = this.f9243d.cachedAppLinks;
                    synchronized (hashMap) {
                        hashMap2 = this.f9243d.cachedAppLinks;
                        hashMap2.put(uri, cVar);
                    }
                } catch (JSONException unused) {
                }
            }
        }
        this.f9240a.a((p.a) this.f9241b);
    }
}
