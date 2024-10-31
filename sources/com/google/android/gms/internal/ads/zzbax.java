package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.util.JsonWriter;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@zzark
/* loaded from: classes2.dex */
public final class zzbax {
    private final List<String> zzeop;
    private static Object sLock = new Object();
    private static boolean zzeom = false;
    private static boolean zzeon = false;
    private static Clock zzbrs = DefaultClock.d();
    private static final Set<String> zzeoo = new HashSet(Arrays.asList(new String[0]));

    public zzbax() {
        this(null);
    }

    public static boolean isEnabled() {
        boolean z;
        synchronized (sLock) {
            z = zzeom && zzeon;
        }
        return z;
    }

    public static void zzaat() {
        synchronized (sLock) {
            zzeom = false;
            zzeon = false;
            zzbbd.zzeo("Ad debug logging enablement is out of date.");
        }
    }

    public static boolean zzaau() {
        boolean z;
        synchronized (sLock) {
            z = zzeom;
        }
        return z;
    }

    public static void zzaq(boolean z) {
        synchronized (sLock) {
            zzeom = true;
            zzeon = z;
        }
    }

    private final void zzb(final String str, final String str2, final Map<String, ?> map, final byte[] bArr) {
        zza("onNetworkRequest", new InterfaceC0914ge(str, str2, map, bArr) { // from class: com.google.android.gms.internal.ads.ce

            /* renamed from: a, reason: collision with root package name */
            private final String f12098a;

            /* renamed from: b, reason: collision with root package name */
            private final String f12099b;

            /* renamed from: c, reason: collision with root package name */
            private final Map f12100c;

            /* renamed from: d, reason: collision with root package name */
            private final byte[] f12101d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12098a = str;
                this.f12099b = str2;
                this.f12100c = map;
                this.f12101d = bArr;
            }

            @Override // com.google.android.gms.internal.ads.InterfaceC0914ge
            public final void a(JsonWriter jsonWriter) {
                zzbax.zza(this.f12098a, this.f12099b, this.f12100c, this.f12101d, jsonWriter);
            }
        });
    }

    public static boolean zzbl(Context context) {
        if (Build.VERSION.SDK_INT < 17) {
            return false;
        }
        if (!((Boolean) zzwu.zzpz().zzd(zzaan.zzcsn)).booleanValue()) {
            return false;
        }
        try {
            return Settings.Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0;
        } catch (Exception e2) {
            zzbbd.zzc("Fail to determine debug setting.", e2);
            return false;
        }
    }

    private final void zzel(final String str) {
        zza("onNetworkRequestError", new InterfaceC0914ge(str) { // from class: com.google.android.gms.internal.ads.fe

            /* renamed from: a, reason: collision with root package name */
            private final String f12160a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12160a = str;
            }

            @Override // com.google.android.gms.internal.ads.InterfaceC0914ge
            public final void a(JsonWriter jsonWriter) {
                zzbax.zza(this.f12160a, jsonWriter);
            }
        });
    }

    private static synchronized void zzem(String str) {
        synchronized (zzbax.class) {
            zzbbd.zzen("GMA Debug BEGIN");
            int i = 0;
            while (i < str.length()) {
                int i2 = i + LicenseErrCode.ERROR_NO_XIAOMI_ACCOUNT;
                String valueOf = String.valueOf(str.substring(i, Math.min(i2, str.length())));
                zzbbd.zzen(valueOf.length() != 0 ? "GMA Debug CONTENT ".concat(valueOf) : new String("GMA Debug CONTENT "));
                i = i2;
            }
            zzbbd.zzen("GMA Debug FINISH");
        }
    }

    public final void zza(HttpURLConnection httpURLConnection, byte[] bArr) {
        if (isEnabled()) {
            zzb(new String(httpURLConnection.getURL().toString()), new String(httpURLConnection.getRequestMethod()), httpURLConnection.getRequestProperties() == null ? null : new HashMap(httpURLConnection.getRequestProperties()), bArr);
        }
    }

    public final void zzek(String str) {
        if (isEnabled() && str != null) {
            zzi(str.getBytes());
        }
    }

    public final void zzi(final byte[] bArr) {
        zza("onNetworkResponseBody", new InterfaceC0914ge(bArr) { // from class: com.google.android.gms.internal.ads.ee

            /* renamed from: a, reason: collision with root package name */
            private final byte[] f12141a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12141a = bArr;
            }

            @Override // com.google.android.gms.internal.ads.InterfaceC0914ge
            public final void a(JsonWriter jsonWriter) {
                zzbax.zza(this.f12141a, jsonWriter);
            }
        });
    }

    public zzbax(String str) {
        List<String> asList;
        if (!isEnabled()) {
            asList = new ArrayList<>();
        } else {
            String uuid = UUID.randomUUID().toString();
            if (str == null) {
                String[] strArr = new String[1];
                String valueOf = String.valueOf(uuid);
                strArr[0] = valueOf.length() != 0 ? "network_request_".concat(valueOf) : new String("network_request_");
                asList = Arrays.asList(strArr);
            } else {
                String[] strArr2 = new String[2];
                String valueOf2 = String.valueOf(str);
                strArr2[0] = valueOf2.length() != 0 ? "ad_request_".concat(valueOf2) : new String("ad_request_");
                String valueOf3 = String.valueOf(uuid);
                strArr2[1] = valueOf3.length() != 0 ? "network_request_".concat(valueOf3) : new String("network_request_");
                asList = Arrays.asList(strArr2);
            }
        }
        this.zzeop = asList;
    }

    private final void zzb(final Map<String, ?> map, final int i) {
        zza("onNetworkResponse", new InterfaceC0914ge(i, map) { // from class: com.google.android.gms.internal.ads.de

            /* renamed from: a, reason: collision with root package name */
            private final int f12122a;

            /* renamed from: b, reason: collision with root package name */
            private final Map f12123b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12122a = i;
                this.f12123b = map;
            }

            @Override // com.google.android.gms.internal.ads.InterfaceC0914ge
            public final void a(JsonWriter jsonWriter) {
                zzbax.zza(this.f12122a, this.f12123b, jsonWriter);
            }
        });
    }

    public final void zza(String str, String str2, Map<String, ?> map, byte[] bArr) {
        if (isEnabled()) {
            zzb(str, str2, map, bArr);
        }
    }

    public final void zza(HttpURLConnection httpURLConnection, int i) {
        if (isEnabled()) {
            String str = null;
            zzb(httpURLConnection.getHeaderFields() == null ? null : new HashMap(httpURLConnection.getHeaderFields()), i);
            if (i < 200 || i >= 300) {
                try {
                    str = httpURLConnection.getResponseMessage();
                } catch (IOException e2) {
                    String valueOf = String.valueOf(e2.getMessage());
                    zzbbd.zzeo(valueOf.length() != 0 ? "Can not get error message from error HttpURLConnection\n".concat(valueOf) : new String("Can not get error message from error HttpURLConnection\n"));
                }
                zzel(str);
            }
        }
    }

    public final void zza(Map<String, ?> map, int i) {
        if (isEnabled()) {
            zzb(map, i);
            if (i < 200 || i >= 300) {
                zzel(null);
            }
        }
    }

    private static void zza(JsonWriter jsonWriter, Map<String, ?> map) throws IOException {
        if (map == null) {
            return;
        }
        jsonWriter.name("headers").beginArray();
        Iterator<Map.Entry<String, ?>> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, ?> next = it.next();
            String key = next.getKey();
            if (!zzeoo.contains(key)) {
                if (next.getValue() instanceof List) {
                    for (String str : (List) next.getValue()) {
                        jsonWriter.beginObject();
                        jsonWriter.name("name").value(key);
                        jsonWriter.name("value").value(str);
                        jsonWriter.endObject();
                    }
                } else if (next.getValue() instanceof String) {
                    jsonWriter.beginObject();
                    jsonWriter.name("name").value(key);
                    jsonWriter.name("value").value((String) next.getValue());
                    jsonWriter.endObject();
                } else {
                    zzbbd.e("Connection headers should be either Map<String, String> or Map<String, List<String>>");
                    break;
                }
            }
        }
        jsonWriter.endArray();
    }

    private final void zza(String str, InterfaceC0914ge interfaceC0914ge) {
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            jsonWriter.name("timestamp").value(zzbrs.a());
            jsonWriter.name(NotificationCompat.CATEGORY_EVENT).value(str);
            jsonWriter.name("components").beginArray();
            Iterator<String> it = this.zzeop.iterator();
            while (it.hasNext()) {
                jsonWriter.value(it.next());
            }
            jsonWriter.endArray();
            interfaceC0914ge.a(jsonWriter);
            jsonWriter.endObject();
            jsonWriter.flush();
            jsonWriter.close();
        } catch (IOException e2) {
            zzbbd.zzb("unable to log", e2);
        }
        zzem(stringWriter.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void zza(String str, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginObject();
        if (str != null) {
            jsonWriter.name("error_description").value(str);
        }
        jsonWriter.endObject();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void zza(byte[] bArr, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginObject();
        int length = bArr.length;
        String a2 = Base64Utils.a(bArr);
        if (length < 10000) {
            jsonWriter.name("body").value(a2);
        } else {
            String zzei = zzbat.zzei(a2);
            if (zzei != null) {
                jsonWriter.name("bodydigest").value(zzei);
            }
        }
        jsonWriter.name("bodylength").value(length);
        jsonWriter.endObject();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void zza(int i, Map map, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("code").value(i);
        jsonWriter.endObject();
        zza(jsonWriter, (Map<String, ?>) map);
        jsonWriter.endObject();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void zza(String str, String str2, Map map, byte[] bArr, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name(ShareConstants.MEDIA_URI).value(str);
        jsonWriter.name("verb").value(str2);
        jsonWriter.endObject();
        zza(jsonWriter, (Map<String, ?>) map);
        if (bArr != null) {
            jsonWriter.name("body").value(Base64Utils.a(bArr));
        }
        jsonWriter.endObject();
    }
}
