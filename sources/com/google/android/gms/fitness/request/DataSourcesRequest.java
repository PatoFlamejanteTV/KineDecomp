package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zznv;
import java.util.List;

/* loaded from: classes.dex */
public class DataSourcesRequest implements SafeParcelable {
    public static final Parcelable.Creator<DataSourcesRequest> CREATOR = new zzh();

    /* renamed from: a, reason: collision with root package name */
    private final int f1249a;
    private final List<DataType> b;
    private final List<Integer> c;
    private final boolean d;
    private final zznv e;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private DataType[] f1250a = new DataType[0];
        private int[] b = {0, 1};
        private boolean c = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataSourcesRequest(int i, List<DataType> list, List<Integer> list2, boolean z, IBinder iBinder) {
        this.f1249a = i;
        this.b = list;
        this.c = list2;
        this.d = z;
        this.e = zznv.zza.zzbv(iBinder);
    }

    public DataSourcesRequest(DataSourcesRequest dataSourcesRequest, zznv zznvVar) {
        this(dataSourcesRequest.b, dataSourcesRequest.c, dataSourcesRequest.d, zznvVar);
    }

    public DataSourcesRequest(List<DataType> list, List<Integer> list2, boolean z, zznv zznvVar) {
        this.f1249a = 4;
        this.b = list;
        this.c = list2;
        this.d = z;
        this.e = zznvVar;
    }

    public List<DataType> a() {
        return this.b;
    }

    public List<Integer> b() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }

    public IBinder d() {
        if (this.e == null) {
            return null;
        }
        return this.e.asBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f1249a;
    }

    public String toString() {
        zzw.zza a2 = com.google.android.gms.common.internal.zzw.a(this).a("dataTypes", this.b).a("sourceTypes", this.c);
        if (this.d) {
            a2.a("includeDbOnlySources", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        }
        return a2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.a(this, parcel, i);
    }
}
