package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
@TargetApi(21)
/* renamed from: com.google.android.gms.internal.ads.jd, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0954jd {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, String> f12219a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f12220b;

    /* renamed from: c, reason: collision with root package name */
    private final List<String> f12221c;

    /* renamed from: d, reason: collision with root package name */
    private final zzawg f12222d;

    static {
        HashMap hashMap = new HashMap();
        if (PlatformVersion.h()) {
            hashMap.put("android.webkit.resource.AUDIO_CAPTURE", "android.permission.RECORD_AUDIO");
            hashMap.put("android.webkit.resource.VIDEO_CAPTURE", "android.permission.CAMERA");
        }
        f12219a = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0954jd(Context context, List<String> list, zzawg zzawgVar) {
        this.f12220b = context;
        this.f12221c = list;
        this.f12222d = zzawgVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<String> a(String[] strArr) {
        boolean z;
        boolean z2;
        String valueOf;
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Iterator<String> it = this.f12221c.iterator();
            do {
                z = true;
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                String next = it.next();
                if (next.equals(str)) {
                    break;
                }
                valueOf = String.valueOf(next);
            } while (!(valueOf.length() != 0 ? "android.webkit.resource.".concat(valueOf) : new String("android.webkit.resource.")).equals(str));
            z2 = true;
            if (z2) {
                if (f12219a.containsKey(str)) {
                    com.google.android.gms.ads.internal.zzbv.e();
                    if (!zzayh.zzn(this.f12220b, f12219a.get(str))) {
                        z = false;
                    }
                }
                if (z) {
                    arrayList.add(str);
                } else {
                    this.f12222d.zzdk(str);
                }
            } else {
                this.f12222d.zzdj(str);
            }
        }
        return arrayList;
    }
}
