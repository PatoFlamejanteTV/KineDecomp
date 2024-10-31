package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class AppContentConditionRef extends MultiDataBufferRef implements AppContentCondition {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AppContentConditionRef(ArrayList<DataHolder> arrayList, int i) {
        super(arrayList, 4, i);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCondition
    public String b() {
        return e("condition_default_value");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCondition
    public String c() {
        return e("condition_expected_value");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCondition
    public String d() {
        return e("condition_predicate");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCondition
    public Bundle e() {
        return AppContentUtils.d(this.a_, this.c, "condition_predicate_parameters", this.b_);
    }

    @Override // com.google.android.gms.common.data.zzc
    public boolean equals(Object obj) {
        return AppContentConditionEntity.a(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public AppContentCondition a() {
        return new AppContentConditionEntity(this);
    }

    @Override // com.google.android.gms.common.data.zzc
    public int hashCode() {
        return AppContentConditionEntity.a(this);
    }

    public String toString() {
        return AppContentConditionEntity.b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ((AppContentConditionEntity) a()).writeToParcel(parcel, i);
    }
}
