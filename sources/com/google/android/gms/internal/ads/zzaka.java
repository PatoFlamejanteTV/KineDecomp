package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public final class zzaka {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final zzajz<JSONObject> zzdkb = new C0824ab();
    private static final zzajx<InputStream> zzdkc = _a.f12022a;

    public static final /* synthetic */ InputStream zzf(JSONObject jSONObject) throws JSONException {
        return new ByteArrayInputStream(jSONObject.toString().getBytes(UTF_8));
    }
}
