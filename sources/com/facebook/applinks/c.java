package com.facebook.applinks;

import a.b;
import a.g;
import android.net.Uri;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
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
    final /* synthetic */ g.a f259a;
    final /* synthetic */ Map b;
    final /* synthetic */ HashSet c;
    final /* synthetic */ FacebookAppLinkResolver d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FacebookAppLinkResolver facebookAppLinkResolver, g.a aVar, Map map, HashSet hashSet) {
        this.d = facebookAppLinkResolver;
        this.f259a = aVar;
        this.b = map;
        this.c = hashSet;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        Uri webFallbackUriFromJson;
        HashMap hashMap;
        HashMap hashMap2;
        b.a androidTargetFromJson;
        FacebookRequestError error = graphResponse.getError();
        if (error != null) {
            this.f259a.b((Exception) error.getException());
            return;
        }
        JSONObject jSONObject = graphResponse.getJSONObject();
        if (jSONObject == null) {
            this.f259a.b((g.a) this.b);
            return;
        }
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (jSONObject.has(uri.toString())) {
                try {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(uri.toString()).getJSONObject("app_links");
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
                    a.b bVar = new a.b(uri, arrayList, webFallbackUriFromJson);
                    this.b.put(uri, bVar);
                    hashMap = this.d.cachedAppLinks;
                    synchronized (hashMap) {
                        hashMap2 = this.d.cachedAppLinks;
                        hashMap2.put(uri, bVar);
                    }
                } catch (JSONException e) {
                }
            }
        }
        this.f259a.b((g.a) this.b);
    }
}
