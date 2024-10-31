package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.internal.measurement.zzea;
import com.google.android.gms.measurement.internal.zzcy;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.t, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1390t extends zzea.b {

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzcy f13521e;

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzea f13522f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1390t(zzea zzeaVar, zzcy zzcyVar) {
        super(zzeaVar);
        this.f13522f = zzeaVar;
        this.f13521e = zzcyVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    final void b() throws RemoteException {
        Map map;
        zzdn zzdnVar;
        Map map2;
        map = this.f13522f.zzadn;
        zzea.d dVar = (zzea.d) map.get(this.f13521e);
        if (dVar == null) {
            Log.w(this.f13522f.zzadh, "OnEventListener had not been registered.");
            return;
        }
        zzdnVar = this.f13522f.zzadr;
        zzdnVar.unregisterOnMeasurementEventListener(dVar);
        map2 = this.f13522f.zzadn;
        map2.remove(this.f13521e);
    }
}
