package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzad;
import com.google.android.gms.internal.gtm.zzap;
import com.google.android.gms.internal.gtm.zzz;
import java.util.ListIterator;

@VisibleForTesting
/* loaded from: classes.dex */
public class zza extends zzj<zza> {

    /* renamed from: d, reason: collision with root package name */
    private final zzap f10355d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f10356e;

    @VisibleForTesting
    public zza(zzap zzapVar) {
        super(zzapVar.zzcq(), zzapVar.zzcn());
        this.f10355d = zzapVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.analytics.zzj
    public final void a(zzg zzgVar) {
        zzz zzzVar = (zzz) zzgVar.b(zzz.class);
        if (TextUtils.isEmpty(zzzVar.zzbt())) {
            zzzVar.setClientId(this.f10355d.zzdh().zzeh());
        }
        if (this.f10356e && TextUtils.isEmpty(zzzVar.zzbv())) {
            zzad zzdg = this.f10355d.zzdg();
            zzzVar.zzm(zzdg.zzcd());
            zzzVar.zza(zzdg.zzbw());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final zzap b() {
        return this.f10355d;
    }

    public final zzg c() {
        zzg a2 = this.f10372b.a();
        a2.a(this.f10355d.zzcy().zzdv());
        a2.a(this.f10355d.zzcz().zzfa());
        b(a2);
        return a2;
    }

    public final void a(boolean z) {
        this.f10356e = z;
    }

    public final void a(String str) {
        Preconditions.b(str);
        Uri e2 = zzb.e(str);
        ListIterator<zzo> listIterator = this.f10372b.c().listIterator();
        while (listIterator.hasNext()) {
            if (e2.equals(listIterator.next().c())) {
                listIterator.remove();
            }
        }
        this.f10372b.c().add(new zzb(this.f10355d, str));
    }
}
