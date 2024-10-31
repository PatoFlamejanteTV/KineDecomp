package com.google.android.gms.internal;

import com.google.android.gms.internal.zzis;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements zzis.zzc<zzbe> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ JSONObject f1656a;
    final /* synthetic */ zzaz b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(zzaz zzazVar, JSONObject jSONObject) {
        this.b = zzazVar;
        this.f1656a = jSONObject;
    }

    @Override // com.google.android.gms.internal.zzis.zzc
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zzc(zzbe zzbeVar) {
        zzbeVar.zza("AFMA_updateActiveView", this.f1656a);
    }
}
