package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;

@zzark
/* loaded from: classes2.dex */
public final class zzaul extends zzaus {
    private final String zzeee;
    private final int zzeef;

    public zzaul(String str, int i) {
        this.zzeee = str;
        this.zzeef = i;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzaul)) {
            zzaul zzaulVar = (zzaul) obj;
            if (Objects.a(this.zzeee, zzaulVar.zzeee) && Objects.a(Integer.valueOf(this.zzeef), Integer.valueOf(zzaulVar.zzeef))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final int getAmount() {
        return this.zzeef;
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final String getType() {
        return this.zzeee;
    }
}
