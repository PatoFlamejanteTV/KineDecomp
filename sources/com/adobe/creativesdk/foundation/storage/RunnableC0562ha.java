package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCacheOptions;
import com.facebook.internal.ServerProtocol;
import com.facebook.places.model.PlaceFields;
import java.util.EnumSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdobeAssetFolder.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.ha */
/* loaded from: classes.dex */
public class RunnableC0562ha implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f7272a;

    /* renamed from: b */
    final /* synthetic */ C0566ia f7273b;

    public RunnableC0562ha(C0566ia c0566ia, String str) {
        this.f7273b = c0566ia;
        this.f7272a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        JSONObject jSONObject;
        String str3;
        String str4;
        int length;
        int i;
        int i2;
        int i3;
        String str5;
        String str6;
        long j;
        String str7;
        String str8;
        String str9;
        String str10;
        int i4;
        long j2;
        long j3;
        int i5;
        String str11;
        JSONObject jSONObject2;
        JSONArray jSONArray;
        String str12;
        String str13 = "total_children";
        String str14 = "children";
        try {
            JSONObject jSONObject3 = new JSONObject(this.f7272a);
            JSONArray optJSONArray = jSONObject3.optJSONArray("children");
            String str15 = "name";
            String str16 = "type";
            if (optJSONArray != null) {
                int i6 = 0;
                boolean z = false;
                while (i6 < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                    String str17 = str14;
                    String optString = optJSONObject.optString(str16);
                    String str18 = str16;
                    if (optString.equals("application/vnd.adobe.directory+json")) {
                        C0578la.c(this.f7273b.f7288d);
                    } else {
                        C0578la.h(this.f7273b.f7288d);
                    }
                    if (z) {
                        str11 = str13;
                    } else {
                        str11 = str13;
                        if (optJSONObject.optString("renderable").equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                            this.f7273b.f7288d.f7334g = optJSONObject.optString(str15);
                            this.f7273b.f7288d.f7333f = optString;
                            str12 = str15;
                            jSONObject2 = jSONObject3;
                            this.f7273b.f7288d.l = optJSONObject.optLong("size", 0L);
                            this.f7273b.f7288d.k = optJSONObject.optString("md5");
                            this.f7273b.f7288d.f7335h = optJSONObject.optString("id");
                            this.f7273b.f7288d.i = optJSONObject.optString("created");
                            this.f7273b.f7288d.j = optJSONObject.optString("modified");
                            this.f7273b.f7288d.m = optJSONObject.optInt(com.umeng.analytics.pro.b.s, 1);
                            jSONArray = optJSONArray;
                            this.f7273b.f7288d.n = optJSONObject.optLong("height", 0L);
                            this.f7273b.f7288d.o = optJSONObject.optLong("width", 0L);
                            z = true;
                            i6++;
                            optJSONArray = jSONArray;
                            str14 = str17;
                            str16 = str18;
                            str13 = str11;
                            jSONObject3 = jSONObject2;
                            str15 = str12;
                        }
                    }
                    jSONObject2 = jSONObject3;
                    jSONArray = optJSONArray;
                    str12 = str15;
                    i6++;
                    optJSONArray = jSONArray;
                    str14 = str17;
                    str16 = str18;
                    str13 = str11;
                    jSONObject3 = jSONObject2;
                    str15 = str12;
                }
                str = str13;
                str2 = str14;
                jSONObject = jSONObject3;
                str3 = str15;
                str4 = str16;
                C0578la c0578la = this.f7273b.f7288d;
                i5 = this.f7273b.f7288d.f7330c;
                c0578la.f7330c = i5 + optJSONArray.length();
            } else {
                str = "total_children";
                str2 = "children";
                jSONObject = jSONObject3;
                str3 = "name";
                str4 = "type";
            }
            String str19 = str;
            JSONObject jSONObject4 = jSONObject;
            if (jSONObject4.has(str19)) {
                length = jSONObject4.optInt(str19);
            } else {
                String str20 = str2;
                length = jSONObject4.optJSONArray(str20) != null ? jSONObject4.optJSONArray(str20).length() : 0;
            }
            i = this.f7273b.f7288d.f7330c;
            if (i < length) {
                this.f7273b.f7288d.a((c.a.a.a.b<JSONObject>) new C0542ca(this), (c.a.a.a.c<AdobeAssetException>) new C0550ea(this), this.f7273b.f7285a);
                return;
            }
            JSONObject jSONObject5 = new JSONObject();
            i2 = this.f7273b.f7288d.f7332e;
            jSONObject5.put("num_files", i2);
            i3 = this.f7273b.f7288d.f7331d;
            jSONObject5.put("num_folders", i3);
            str5 = this.f7273b.f7288d.f7334g;
            jSONObject5.put(str3, str5);
            str6 = this.f7273b.f7288d.f7333f;
            jSONObject5.put(str4, str6);
            j = this.f7273b.f7288d.l;
            jSONObject5.put("size", j);
            str7 = this.f7273b.f7288d.k;
            jSONObject5.put("md5", str7);
            str8 = this.f7273b.f7288d.f7335h;
            jSONObject5.put("id", str8);
            str9 = this.f7273b.f7288d.i;
            jSONObject5.put("created", str9);
            str10 = this.f7273b.f7288d.j;
            jSONObject5.put("modified", str10);
            i4 = this.f7273b.f7288d.m;
            jSONObject5.put(PlaceFields.PAGE, i4);
            j2 = this.f7273b.f7288d.n;
            jSONObject5.put("height", j2);
            j3 = this.f7273b.f7288d.o;
            jSONObject5.put("width", j3);
            com.adobe.creativesdk.foundation.internal.cache.d.b().a(jSONObject5.toString().getBytes(), this.f7273b.f7288d.getGUID(), "PAGE_RESOURCE_COLLECTION_DATA", EnumSet.of(AdobeCommonCacheOptions.AdobeCommonCacheKeepInMemoryCache, AdobeCommonCacheOptions.AdobeCommonCacheKeepOnDiskCache), "com.adobe.cc.storage", new C0554fa(this));
            if (this.f7273b.f7285a != null) {
                this.f7273b.f7285a.post(new RunnableC0558ga(this, jSONObject5));
            } else {
                this.f7273b.f7287c.b(jSONObject5);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
