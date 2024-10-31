package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;

/* loaded from: classes.dex */
public class ConverterWrapper implements SafeParcelable {
    public static final zza CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    private final int f1030a;
    private final StringToIntConverter b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConverterWrapper(int i, StringToIntConverter stringToIntConverter) {
        this.f1030a = i;
        this.b = stringToIntConverter;
    }

    private ConverterWrapper(StringToIntConverter stringToIntConverter) {
        this.f1030a = 1;
        this.b = stringToIntConverter;
    }

    public static ConverterWrapper a(FastJsonResponse.zza<?, ?> zzaVar) {
        if (zzaVar instanceof StringToIntConverter) {
            return new ConverterWrapper((StringToIntConverter) zzaVar);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f1030a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StringToIntConverter b() {
        return this.b;
    }

    public FastJsonResponse.zza<?, ?> c() {
        if (this.b != null) {
            return this.b;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zza zzaVar = CREATOR;
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza zzaVar = CREATOR;
        zza.a(this, parcel, i);
    }
}
