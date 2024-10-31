package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.internal.zzm;

/* loaded from: classes.dex */
public class zzw extends zzm.zza {

    /* renamed from: a */
    private final zzv f2074a;
    private final boolean b;

    public zzw(zzv zzvVar) {
        zzx.a(zzvVar);
        this.f2074a = zzvVar;
        this.b = false;
    }

    public zzw(zzv zzvVar, boolean z) {
        zzx.a(zzvVar);
        this.f2074a = zzvVar;
        this.b = z;
    }

    private void a(String str) throws SecurityException {
        if (TextUtils.isEmpty(str)) {
            this.f2074a.f().b().a("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        try {
            b(str);
        } catch (SecurityException e) {
            this.f2074a.f().b().a("Measurement Service called with invalid calling package", str);
            throw e;
        }
    }

    private void b(String str) throws SecurityException {
        int myUid = this.b ? Process.myUid() : Binder.getCallingUid();
        if (GooglePlayServicesUtil.a(this.f2074a.m(), myUid, str)) {
            return;
        }
        if (!GooglePlayServicesUtil.a(this.f2074a.m(), myUid) || this.f2074a.u()) {
            throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzm
    public void a(AppMetadata appMetadata) {
        zzx.a(appMetadata);
        a(appMetadata.b);
        this.f2074a.g().a(new aa(this, appMetadata));
    }

    @Override // com.google.android.gms.measurement.internal.zzm
    public void a(EventParcel eventParcel, AppMetadata appMetadata) {
        zzx.a(eventParcel);
        zzx.a(appMetadata);
        a(appMetadata.b);
        this.f2074a.g().a(new x(this, eventParcel, appMetadata));
    }

    @Override // com.google.android.gms.measurement.internal.zzm
    public void a(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        zzx.a(userAttributeParcel);
        zzx.a(appMetadata);
        a(appMetadata.b);
        if (userAttributeParcel.a() == null) {
            this.f2074a.g().a(new y(this, userAttributeParcel, appMetadata));
        } else {
            this.f2074a.g().a(new z(this, userAttributeParcel, appMetadata));
        }
    }
}
