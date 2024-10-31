package com.google.firebase.dynamiclinks;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.dynamiclinks.internal.zza;

/* loaded from: classes2.dex */
public class PendingDynamicLinkData {

    /* renamed from: a */
    private final zza f17273a;

    @VisibleForTesting
    public PendingDynamicLinkData(zza zzaVar) {
        if (zzaVar == null) {
            this.f17273a = null;
            return;
        }
        if (zzaVar.a() == 0) {
            zzaVar.h(DefaultClock.d().a());
        }
        this.f17273a = zzaVar;
    }

    public Uri a() {
        String O;
        zza zzaVar = this.f17273a;
        if (zzaVar == null || (O = zzaVar.O()) == null) {
            return null;
        }
        return Uri.parse(O);
    }

    @ShowFirstParty
    public final Bundle b() {
        zza zzaVar = this.f17273a;
        if (zzaVar == null) {
            return new Bundle();
        }
        return zzaVar.P();
    }
}
