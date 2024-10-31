package com.google.android.gms.internal;

import com.google.android.gms.internal.zzko;
import org.json.JSONObject;

/* loaded from: classes.dex */
class fb extends zzko.zza {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f1547a;
    final /* synthetic */ String b;
    final /* synthetic */ JSONObject c;
    final /* synthetic */ zzko d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fb(zzko zzkoVar, int i, String str, JSONObject jSONObject) {
        super();
        this.d = zzkoVar;
        this.f1547a = i;
        this.b = str;
        this.c = jSONObject;
    }

    @Override // com.google.android.gms.internal.zzko.zzb
    public void execute() {
        com.google.android.gms.cast.internal.zzl zzlVar;
        int a2 = fg.a(this.f1547a);
        if (a2 != 0) {
            this.d.zza(this.b, a2, this.c, zzmG());
            return;
        }
        zzmG().a(-1L, 2001, null);
        zzlVar = zzko.zzVo;
        zzlVar.d("sendPlayerRequest for unsupported playerState: %d", Integer.valueOf(this.f1547a));
    }
}
