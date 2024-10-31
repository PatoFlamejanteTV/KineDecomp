package com.google.android.gms.location.places.personalized;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.PlacesStatusCodes;

/* loaded from: classes.dex */
public final class zzd extends com.google.android.gms.common.data.zzd<PlaceUserData> implements Result {
    private final Status b;

    public zzd(DataHolder dataHolder) {
        this(dataHolder, PlacesStatusCodes.c(dataHolder.e()));
    }

    private zzd(DataHolder dataHolder, Status status) {
        super(dataHolder, PlaceUserData.CREATOR);
        zzx.b(dataHolder == null || dataHolder.e() == status.e());
        this.b = status;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.b;
    }
}
