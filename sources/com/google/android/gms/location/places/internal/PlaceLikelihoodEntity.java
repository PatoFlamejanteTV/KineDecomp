package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.PlaceLikelihood;

/* loaded from: classes.dex */
public class PlaceLikelihoodEntity implements SafeParcelable, PlaceLikelihood {
    public static final Parcelable.Creator<PlaceLikelihoodEntity> CREATOR = new zzm();

    /* renamed from: a, reason: collision with root package name */
    final int f1884a;
    final PlaceImpl b;
    final float c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlaceLikelihoodEntity(int i, PlaceImpl placeImpl, float f) {
        this.f1884a = i;
        this.b = placeImpl;
        this.c = f;
    }

    public static PlaceLikelihoodEntity a(PlaceImpl placeImpl, float f) {
        return new PlaceLikelihoodEntity(0, (PlaceImpl) zzx.a(placeImpl), f);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public PlaceLikelihood a() {
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceLikelihoodEntity)) {
            return false;
        }
        PlaceLikelihoodEntity placeLikelihoodEntity = (PlaceLikelihoodEntity) obj;
        return this.b.equals(placeLikelihoodEntity.b) && this.c == placeLikelihoodEntity.c;
    }

    public int hashCode() {
        return zzw.a(this.b, Float.valueOf(this.c));
    }

    public String toString() {
        return zzw.a(this).a("place", this.b).a("likelihood", Float.valueOf(this.c)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzm.a(this, parcel, i);
    }
}
