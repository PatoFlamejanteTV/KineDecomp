package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class AppContentSectionRef extends MultiDataBufferRef implements AppContentSection {
    private final int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppContentSectionRef(ArrayList<DataHolder> arrayList, int i, int i2) {
        super(arrayList, 0, i);
        this.d = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public String e() {
        return e("section_card_type");
    }

    @Override // com.google.android.gms.common.data.zzc
    public boolean equals(Object obj) {
        return AppContentSectionEntity.a(this, obj);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public String f() {
        return e("section_content_description");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public Bundle g() {
        return AppContentUtils.d(this.a_, this.c, "section_data", this.b_);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public String h() {
        return e("section_id");
    }

    @Override // com.google.android.gms.common.data.zzc
    public int hashCode() {
        return AppContentSectionEntity.a(this);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public String i() {
        return e("section_subtitle");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public String j() {
        return e("section_title");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public String k() {
        return e("section_type");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public ArrayList<AppContentAction> b() {
        return AppContentUtils.a(this.a_, this.c, "section_actions", this.b_);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public ArrayList<AppContentAnnotation> c() {
        return AppContentUtils.b(this.a_, this.c, "section_annotations", this.b_);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public ArrayList<AppContentCard> d() {
        ArrayList<AppContentCard> arrayList = new ArrayList<>(this.d);
        for (int i = 0; i < this.d; i++) {
            arrayList.add(new AppContentCardRef(this.c, this.b_ + i));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public AppContentSection a() {
        return new AppContentSectionEntity(this);
    }

    public String toString() {
        return AppContentSectionEntity.b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ((AppContentSectionEntity) a()).writeToParcel(parcel, i);
    }
}
