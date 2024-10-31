package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.td, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1093td extends zzaxv {

    /* renamed from: a, reason: collision with root package name */
    private Context f12548a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1093td(Context context) {
        this.f12548a = context;
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void onStop() {
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void zzki() {
        boolean z;
        try {
            z = AdvertisingIdClient.getIsAdIdFakeForDebugLogging(this.f12548a);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e2) {
            zzbbd.zzb("Fail to get isAdIdFakeForDebugLogging", e2);
            z = false;
        }
        zzbax.zzaq(z);
        StringBuilder sb = new StringBuilder(43);
        sb.append("Update ad debug logging enablement as ");
        sb.append(z);
        zzbbd.zzeo(sb.toString());
    }
}
