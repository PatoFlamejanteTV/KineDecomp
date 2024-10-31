package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzea;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.measurement.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1348b extends zzea.b {

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ Context f13418e;

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f13419f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f13420g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ Bundle f13421h;
    private final /* synthetic */ zzea i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1348b(zzea zzeaVar, Context context, String str, String str2, Bundle bundle) {
        super(zzeaVar);
        this.i = zzeaVar;
        this.f13418e = context;
        this.f13419f = str;
        this.f13420g = str2;
        this.f13421h = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    public final void b() {
        zzdn zzdnVar;
        boolean zze;
        String str;
        String str2;
        String str3;
        int zzi;
        int zzh;
        zzdn zzdnVar2;
        try {
            this.i.zzadn = new HashMap();
            this.i.zzadr = this.i.zzg(this.f13418e);
            zzdnVar = this.i.zzadr;
            if (zzdnVar == null) {
                Log.w(this.i.zzadh, "Failed to connect to measurement client.");
                return;
            }
            zzea zzeaVar = this.i;
            zze = zzea.zze(this.f13419f, this.f13420g);
            if (zze) {
                String str4 = this.f13420g;
                str2 = this.f13419f;
                str3 = str4;
                str = this.i.zzadh;
            } else {
                str = null;
                str2 = null;
                str3 = null;
            }
            zzi = zzea.zzi(this.f13418e);
            zzh = zzea.zzh(this.f13418e);
            zzdy zzdyVar = new zzdy(13001L, Math.max(zzi, zzh), zzh < zzi, str, str2, str3, this.f13421h);
            zzdnVar2 = this.i.zzadr;
            zzdnVar2.initialize(ObjectWrapper.a(this.f13418e), zzdyVar, this.f13574a);
        } catch (RemoteException e2) {
            this.i.zza((Exception) e2, true, false);
        }
    }
}
