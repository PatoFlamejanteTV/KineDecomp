package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class zzct extends zzcs {
    private zzct(Context context, String str, boolean z) {
        super(context, str, z);
    }

    public static zzct zza(String str, Context context, boolean z) {
        zzcs.zza(context, z);
        return new zzct(context, str, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzcs
    public final List<Callable<Void>> zza(zzdl zzdlVar, Context context, zzbl zzblVar, zzbi zzbiVar) {
        if (zzdlVar.zzac() != null && this.zzrp) {
            int zzy = zzdlVar.zzy();
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(super.zza(zzdlVar, context, zzblVar, zzbiVar));
            arrayList.add(new zzee(zzdlVar, "DPtJycwRqj/e0TdTHULzeUhZhWJ1IU3iwhH90sUbn4eYKEdB5HI7UC0PtJgg2RSN", "Ye7G7hL63+8nOBoyCAHdjfK62rvCOKz3+aC1KA/K9CI=", zzblVar, zzy, 24));
            return arrayList;
        }
        return super.zza(zzdlVar, context, zzblVar, zzbiVar);
    }
}
