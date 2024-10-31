package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Ud extends zzaw {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ byte[] f11872a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Map f11873b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzbax f11874c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ud(zzazs zzazsVar, int i, String str, zzz zzzVar, zzy zzyVar, byte[] bArr, Map map, zzbax zzbaxVar) {
        super(i, str, zzzVar, zzyVar);
        this.f11872a = bArr;
        this.f11873b = map;
        this.f11874c = zzbaxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzr
    public final Map<String, String> getHeaders() throws zza {
        Map<String, String> map = this.f11873b;
        return map == null ? super.getHeaders() : map;
    }

    @Override // com.google.android.gms.internal.ads.zzr
    public final byte[] zzh() throws zza {
        byte[] bArr = this.f11872a;
        return bArr == null ? super.zzh() : bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzaw, com.google.android.gms.internal.ads.zzr
    /* renamed from: zzh */
    public final void zza(String str) {
        this.f11874c.zzek(str);
        super.zza(str);
    }
}
