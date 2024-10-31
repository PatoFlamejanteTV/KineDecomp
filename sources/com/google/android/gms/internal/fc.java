package com.google.android.gms.internal;

import com.google.android.gms.internal.zzko;
import org.json.JSONObject;

/* loaded from: classes.dex */
class fc extends zzko.zza {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1548a;
    final /* synthetic */ JSONObject b;
    final /* synthetic */ zzko c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fc(zzko zzkoVar, String str, JSONObject jSONObject) {
        super();
        this.c = zzkoVar;
        this.f1548a = str;
        this.b = jSONObject;
    }

    @Override // com.google.android.gms.internal.zzko.zzb
    public void execute() {
        this.c.zza(this.f1548a, 6, this.b, zzmG());
    }
}
