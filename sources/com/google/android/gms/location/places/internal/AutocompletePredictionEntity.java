package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.AutocompletePrediction;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class AutocompletePredictionEntity implements SafeParcelable, AutocompletePrediction {
    public static final Parcelable.Creator<AutocompletePredictionEntity> CREATOR = new zza();
    private static final List<SubstringEntity> k = Collections.emptyList();

    /* renamed from: a, reason: collision with root package name */
    final int f1880a;
    final String b;
    final String c;
    final List<Integer> d;
    final List<SubstringEntity> e;
    final int f;
    final String g;
    final List<SubstringEntity> h;
    final String i;
    final List<SubstringEntity> j;

    /* loaded from: classes.dex */
    public static class SubstringEntity implements SafeParcelable, AutocompletePrediction.Substring {
        public static final Parcelable.Creator<SubstringEntity> CREATOR = new zzv();

        /* renamed from: a, reason: collision with root package name */
        final int f1881a;
        final int b;
        final int c;

        public SubstringEntity(int i, int i2, int i3) {
            this.f1881a = i;
            this.b = i2;
            this.c = i3;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SubstringEntity)) {
                return false;
            }
            SubstringEntity substringEntity = (SubstringEntity) obj;
            return zzw.a(Integer.valueOf(this.b), Integer.valueOf(substringEntity.b)) && zzw.a(Integer.valueOf(this.c), Integer.valueOf(substringEntity.c));
        }

        public int hashCode() {
            return zzw.a(Integer.valueOf(this.b), Integer.valueOf(this.c));
        }

        public String toString() {
            return zzw.a(this).a("offset", Integer.valueOf(this.b)).a("length", Integer.valueOf(this.c)).toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zzv.a(this, parcel, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutocompletePredictionEntity(int i, String str, List<Integer> list, int i2, String str2, List<SubstringEntity> list2, String str3, List<SubstringEntity> list3, String str4, List<SubstringEntity> list4) {
        this.f1880a = i;
        this.c = str;
        this.d = list;
        this.f = i2;
        this.b = str2;
        this.e = list2;
        this.g = str3;
        this.h = list3;
        this.i = str4;
        this.j = list4;
    }

    public static AutocompletePredictionEntity a(String str, List<Integer> list, int i, String str2, List<SubstringEntity> list2, String str3, List<SubstringEntity> list3, String str4, List<SubstringEntity> list4) {
        return new AutocompletePredictionEntity(0, str, list, i, (String) zzx.a(str2), list2, str3, list3, str4, list4);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AutocompletePrediction a() {
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
        if (!(obj instanceof AutocompletePredictionEntity)) {
            return false;
        }
        AutocompletePredictionEntity autocompletePredictionEntity = (AutocompletePredictionEntity) obj;
        return zzw.a(this.c, autocompletePredictionEntity.c) && zzw.a(this.d, autocompletePredictionEntity.d) && zzw.a(Integer.valueOf(this.f), Integer.valueOf(autocompletePredictionEntity.f)) && zzw.a(this.b, autocompletePredictionEntity.b) && zzw.a(this.e, autocompletePredictionEntity.e) && zzw.a(this.g, autocompletePredictionEntity.g) && zzw.a(this.h, autocompletePredictionEntity.h) && zzw.a(this.i, autocompletePredictionEntity.i) && zzw.a(this.j, autocompletePredictionEntity.j);
    }

    public int hashCode() {
        return zzw.a(this.c, this.d, Integer.valueOf(this.f), this.b, this.e, this.g, this.h, this.i, this.j);
    }

    public String toString() {
        return zzw.a(this).a("placeId", this.c).a("placeTypes", this.d).a("fullText", this.b).a("fullTextMatchedSubstrings", this.e).a("primaryText", this.g).a("primaryTextMatchedSubstrings", this.h).a("secondaryText", this.i).a("secondaryTextMatchedSubstrings", this.j).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.a(this, parcel, i);
    }
}
