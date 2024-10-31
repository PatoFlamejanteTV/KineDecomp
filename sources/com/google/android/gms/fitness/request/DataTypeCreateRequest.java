package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.GraphRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.internal.zznw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class DataTypeCreateRequest implements SafeParcelable {
    public static final Parcelable.Creator<DataTypeCreateRequest> CREATOR = new zzi();

    /* renamed from: a, reason: collision with root package name */
    private final int f1251a;
    private final String b;
    private final List<Field> c;
    private final zznw d;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private List<Field> f1252a = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataTypeCreateRequest(int i, String str, List<Field> list, IBinder iBinder) {
        this.f1251a = i;
        this.b = str;
        this.c = Collections.unmodifiableList(list);
        this.d = zznw.zza.zzbw(iBinder);
    }

    public DataTypeCreateRequest(DataTypeCreateRequest dataTypeCreateRequest, zznw zznwVar) {
        this(dataTypeCreateRequest.b, dataTypeCreateRequest.c, zznwVar);
    }

    public DataTypeCreateRequest(String str, List<Field> list, zznw zznwVar) {
        this.f1251a = 3;
        this.b = str;
        this.c = Collections.unmodifiableList(list);
        this.d = zznwVar;
    }

    private boolean a(DataTypeCreateRequest dataTypeCreateRequest) {
        return com.google.android.gms.common.internal.zzw.a(this.b, dataTypeCreateRequest.b) && com.google.android.gms.common.internal.zzw.a(this.c, dataTypeCreateRequest.c);
    }

    public String a() {
        return this.b;
    }

    public List<Field> b() {
        return this.c;
    }

    public IBinder c() {
        if (this.d == null) {
            return null;
        }
        return this.d.asBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f1251a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof DataTypeCreateRequest) && a((DataTypeCreateRequest) obj));
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.a(this.b, this.c);
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzw.a(this).a("name", this.b).a(GraphRequest.FIELDS_PARAM, this.c).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzi.a(this, parcel, i);
    }
}
