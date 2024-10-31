package com.adobe.creativesdk.foundation.internal.grid;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ClassLoaderSavedState.java */
/* loaded from: classes.dex */
public abstract class c implements Parcelable {

    /* renamed from: b */
    private Parcelable f5016b;

    /* renamed from: c */
    private ClassLoader f5017c;

    /* renamed from: a */
    public static final c f5015a = new a();
    public static final Parcelable.Creator<c> CREATOR = new b();

    public /* synthetic */ c(a aVar) {
        this();
    }

    public final Parcelable a() {
        return this.f5016b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f5016b, i);
    }

    private c() {
        this.f5016b = f5015a;
        this.f5016b = null;
        this.f5017c = null;
    }

    public c(Parcelable parcelable, ClassLoader classLoader) {
        c cVar = f5015a;
        this.f5016b = cVar;
        this.f5017c = classLoader;
        if (parcelable != null) {
            this.f5016b = parcelable == cVar ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public c(Parcel parcel) {
        this.f5016b = f5015a;
        Parcelable readParcelable = parcel.readParcelable(this.f5017c);
        this.f5016b = readParcelable == null ? f5015a : readParcelable;
    }
}
