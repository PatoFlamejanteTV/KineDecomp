package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class AppContentAnnotationRef extends MultiDataBufferRef implements AppContentAnnotation {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AppContentAnnotationRef(ArrayList<DataHolder> arrayList, int i) {
        super(arrayList, 2, i);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public String b() {
        return e("annotation_description");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public String c() {
        return e("annotation_id");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public String d() {
        return e("annotation_image_default_id");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public int e() {
        return c("annotation_image_height");
    }

    @Override // com.google.android.gms.common.data.zzc
    public boolean equals(Object obj) {
        return AppContentAnnotationEntity.a(this, obj);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public Uri f() {
        return h("annotation_image_uri");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public Bundle g() {
        return AppContentUtils.d(this.a_, this.c, "annotation_modifiers", this.b_);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public int h() {
        return c("annotation_image_width");
    }

    @Override // com.google.android.gms.common.data.zzc
    public int hashCode() {
        return AppContentAnnotationEntity.a(this);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public String i() {
        return e("annotation_layout_slot");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public String j() {
        return e("annotation_title");
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public AppContentAnnotation a() {
        return new AppContentAnnotationEntity(this);
    }

    public String toString() {
        return AppContentAnnotationEntity.b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ((AppContentAnnotationEntity) a()).writeToParcel(parcel, i);
    }
}
