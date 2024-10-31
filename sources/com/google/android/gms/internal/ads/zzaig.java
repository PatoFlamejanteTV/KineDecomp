package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.common.util.Predicate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public class zzaig<ReferenceT> {
    private final Map<String, CopyOnWriteArrayList<com.google.android.gms.ads.internal.gmsg.zzu<? super ReferenceT>>> zzdii = new HashMap();
    private ReferenceT zzdij;

    private final synchronized void zzb(String str, Map<String, String> map) {
        if (zzbbd.isLoggable(2)) {
            String valueOf = String.valueOf(str);
            zzaxz.v(valueOf.length() != 0 ? "Received GMSG: ".concat(valueOf) : new String("Received GMSG: "));
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 4 + String.valueOf(str3).length());
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(str3);
                zzaxz.v(sb.toString());
            }
        }
        CopyOnWriteArrayList<com.google.android.gms.ads.internal.gmsg.zzu<? super ReferenceT>> copyOnWriteArrayList = this.zzdii.get(str);
        if (copyOnWriteArrayList != null) {
            Iterator<com.google.android.gms.ads.internal.gmsg.zzu<? super ReferenceT>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                zzbcg.zzepo.execute(new Runnable(this, it.next(), map) { // from class: com.google.android.gms.internal.ads.ya

                    /* renamed from: a, reason: collision with root package name */
                    private final zzaig f12676a;

                    /* renamed from: b, reason: collision with root package name */
                    private final com.google.android.gms.ads.internal.gmsg.zzu f12677b;

                    /* renamed from: c, reason: collision with root package name */
                    private final Map f12678c;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f12676a = this;
                        this.f12677b = next;
                        this.f12678c = map;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f12676a.zza(this.f12677b, this.f12678c);
                    }
                });
            }
        }
    }

    public final synchronized void reset() {
        this.zzdii.clear();
    }

    public final synchronized void zza(String str, com.google.android.gms.ads.internal.gmsg.zzu<? super ReferenceT> zzuVar) {
        CopyOnWriteArrayList<com.google.android.gms.ads.internal.gmsg.zzu<? super ReferenceT>> copyOnWriteArrayList = this.zzdii.get(str);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.zzdii.put(str, copyOnWriteArrayList);
        }
        copyOnWriteArrayList.add(zzuVar);
    }

    public final boolean zzf(Uri uri) {
        if (!"gmsg".equalsIgnoreCase(uri.getScheme()) || !"mobileads.google.com".equalsIgnoreCase(uri.getHost())) {
            return false;
        }
        String path = uri.getPath();
        com.google.android.gms.ads.internal.zzbv.e();
        zzb(path, zzayh.zzg(uri));
        return true;
    }

    public final void zzi(ReferenceT referencet) {
        this.zzdij = referencet;
    }

    public final synchronized void zza(String str, Predicate<com.google.android.gms.ads.internal.gmsg.zzu<? super ReferenceT>> predicate) {
        CopyOnWriteArrayList<com.google.android.gms.ads.internal.gmsg.zzu<? super ReferenceT>> copyOnWriteArrayList = this.zzdii.get(str);
        if (copyOnWriteArrayList == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            com.google.android.gms.ads.internal.gmsg.zzu<? super ReferenceT> zzuVar = (com.google.android.gms.ads.internal.gmsg.zzu) it.next();
            if (predicate.apply(zzuVar)) {
                arrayList.add(zzuVar);
            }
        }
        copyOnWriteArrayList.removeAll(arrayList);
    }

    public final synchronized void zzb(String str, com.google.android.gms.ads.internal.gmsg.zzu<? super ReferenceT> zzuVar) {
        CopyOnWriteArrayList<com.google.android.gms.ads.internal.gmsg.zzu<? super ReferenceT>> copyOnWriteArrayList = this.zzdii.get(str);
        if (copyOnWriteArrayList == null) {
            return;
        }
        copyOnWriteArrayList.remove(zzuVar);
    }

    public final /* synthetic */ void zza(com.google.android.gms.ads.internal.gmsg.zzu zzuVar, Map map) {
        zzuVar.zza(this.zzdij, map);
    }
}
