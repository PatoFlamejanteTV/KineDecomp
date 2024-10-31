package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@zzark
/* renamed from: com.google.android.gms.internal.ads.uf */
/* loaded from: classes2.dex */
final class C1109uf {

    /* renamed from: a */
    private final ArrayList<zzpb> f12578a = new ArrayList<>();

    /* renamed from: b */
    private long f12579b;

    public final long a() {
        Iterator<zzpb> it = this.f12578a.iterator();
        while (it.hasNext()) {
            Map<String, List<String>> responseHeaders = it.next().getResponseHeaders();
            if (responseHeaders != null) {
                for (Map.Entry<String, List<String>> entry : responseHeaders.entrySet()) {
                    try {
                        if ("content-length".equalsIgnoreCase(entry.getKey())) {
                            this.f12579b = Math.max(this.f12579b, Long.parseLong(entry.getValue().get(0)));
                        }
                    } catch (RuntimeException unused) {
                    }
                }
                it.remove();
            }
        }
        return this.f12579b;
    }

    public final void a(zzpb zzpbVar) {
        this.f12578a.add(zzpbVar);
    }
}
