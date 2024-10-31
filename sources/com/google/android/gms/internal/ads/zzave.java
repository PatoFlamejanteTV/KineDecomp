package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;

@zzark
/* loaded from: classes2.dex */
public final class zzave implements RewardItem {
    private final zzaur zzeel;

    public zzave(zzaur zzaurVar) {
        this.zzeel = zzaurVar;
    }

    @Override // com.google.android.gms.ads.reward.RewardItem
    public final int getAmount() {
        zzaur zzaurVar = this.zzeel;
        if (zzaurVar == null) {
            return 0;
        }
        try {
            return zzaurVar.getAmount();
        } catch (RemoteException e2) {
            zzbbd.zzc("Could not forward getAmount to RewardItem", e2);
            return 0;
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardItem
    public final String getType() {
        zzaur zzaurVar = this.zzeel;
        if (zzaurVar == null) {
            return null;
        }
        try {
            return zzaurVar.getType();
        } catch (RemoteException e2) {
            zzbbd.zzc("Could not forward getType to RewardItem", e2);
            return null;
        }
    }
}
