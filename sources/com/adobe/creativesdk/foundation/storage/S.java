package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCacheHitLocation;
import com.adobe.creativesdk.foundation.internal.storage.AdobeAssetFileInternal;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetFile.java */
/* loaded from: classes.dex */
public class S implements com.adobe.creativesdk.foundation.internal.cache.e<byte[]> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeAssetFile f7107a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeAssetFileInternal f7108b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdobeAssetFile f7109c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public S(AdobeAssetFile adobeAssetFile, AdobeAssetFile adobeAssetFile2, AdobeAssetFileInternal adobeAssetFileInternal) {
        this.f7109c = adobeAssetFile;
        this.f7107a = adobeAssetFile2;
        this.f7108b = adobeAssetFileInternal;
    }

    @Override // com.adobe.creativesdk.foundation.internal.cache.e
    public void a(byte[] bArr, AdobeCommonCacheHitLocation adobeCommonCacheHitLocation) {
        JSONObject jSONObject;
        String str;
        String a2;
        try {
            jSONObject = com.adobe.creativesdk.foundation.internal.storage.model.util.i.a(new String(bArr, "UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            jSONObject = null;
        }
        String optString = jSONObject != null ? jSONObject.optString("hls_playlist", null) : null;
        boolean z = true;
        if (optString != null) {
            try {
                str = URLDecoder.decode(optString, "UTF-8");
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
                str = optString;
            }
            long time = new Date().getTime() / 1000;
            Matcher matcher = Pattern.compile("~exp=(\\d+)~", 2).matcher(str);
            if (matcher.find()) {
                if (time >= Long.parseLong(str.substring(matcher.start() + 5, matcher.end() - 1))) {
                    str = null;
                } else {
                    z = false;
                }
            }
        } else {
            str = optString;
        }
        if (z) {
            com.adobe.creativesdk.foundation.internal.cache.d b2 = com.adobe.creativesdk.foundation.internal.cache.d.b();
            a2 = this.f7107a.a();
            b2.c(a2, "video-data", "com.adobe.cc.storage");
            this.f7108b.hlsHref = null;
            this.f7107a.a(new N(this), new O(this));
            return;
        }
        String str2 = this.f7108b.hlsHref;
        if (str2 == null || !str2.equals(str)) {
            this.f7108b.hlsHref = jSONObject.optString("hls_playlist", null);
            this.f7108b._videDuration = jSONObject.optInt("duration", 0);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.cache.e
    public void a() {
        this.f7107a.a(new P(this), new Q(this));
    }
}
