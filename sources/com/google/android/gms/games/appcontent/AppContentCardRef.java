package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class AppContentCardRef extends MultiDataBufferRef implements AppContentCard {
    public AppContentCardRef(ArrayList<DataHolder> arrayList, int i) {
        super(arrayList, 0, i);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public List<AppContentAction> b() {
        return AppContentUtils.a(this.a_, this.c, "card_actions", this.b_);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public List<AppContentAnnotation> c() {
        return AppContentUtils.b(this.a_, this.c, "card_annotations", this.b_);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public List<AppContentCondition> d() {
        return AppContentUtils.c(this.a_, this.c, "card_conditions", this.b_);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public String e() {
        return e("card_content_description");
    }

    @Override // com.google.android.gms.common.data.zzc
    public boolean equals(Object obj) {
        return AppContentCardEntity.a(this, obj);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public int f() {
        return c("card_current_steps");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public String g() {
        return e("card_description");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public Bundle h() {
        return AppContentUtils.d(this.a_, this.c, "card_data", this.b_);
    }

    @Override // com.google.android.gms.common.data.zzc
    public int hashCode() {
        return AppContentCardEntity.a(this);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public String i() {
        return e("card_id");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public String j() {
        return e("card_subtitle");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public String k() {
        return e("card_title");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public int l() {
        return c("card_total_steps");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public String m() {
        return e("card_type");
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: n */
    public AppContentCard a() {
        return new AppContentCardEntity(this);
    }

    public String toString() {
        return AppContentCardEntity.b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ((AppContentCardEntity) a()).writeToParcel(parcel, i);
    }
}
