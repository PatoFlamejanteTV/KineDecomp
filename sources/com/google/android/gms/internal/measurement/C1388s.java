package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.internal.measurement.zzea;
import com.google.android.gms.measurement.internal.zzcy;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.s, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1388s extends zzea.b {

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzcy f13519e;

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzea f13520f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1388s(zzea zzeaVar, zzcy zzcyVar) {
        super(zzeaVar);
        this.f13520f = zzeaVar;
        this.f13519e = zzcyVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    final void b() throws RemoteException {
        Map map;
        Map map2;
        zzdn zzdnVar;
        map = this.f13520f.zzadn;
        if (map.containsKey(this.f13519e)) {
            Log.w(this.f13520f.zzadh, "OnEventListener already registered.");
            return;
        }
        zzea.d dVar = new zzea.d(this.f13519e);
        map2 = this.f13520f.zzadn;
        map2.put(this.f13519e, dVar);
        zzdnVar = this.f13520f.zzadr;
        zzdnVar.registerOnMeasurementEventListener(dVar);
    }
}
