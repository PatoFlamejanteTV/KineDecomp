package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Map;

@zzark
/* loaded from: classes2.dex */
public final class zzafl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzafl> CREATOR = new zzafm();
    private final String url;
    private final String[] zzdgi;
    private final String[] zzdgj;

    @SafeParcelable.Constructor
    public zzafl(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String[] strArr, @SafeParcelable.Param(id = 3) String[] strArr2) {
        this.url = str;
        this.zzdgi = strArr;
        this.zzdgj = strArr2;
    }

    public static zzafl zzh(zzr zzrVar) throws zza {
        Map<String, String> headers = zzrVar.getHeaders();
        int size = headers.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i = 0;
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            strArr[i] = entry.getKey();
            strArr2[i] = entry.getValue();
            i++;
        }
        return new zzafl(zzrVar.getUrl(), strArr, strArr2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.url, false);
        SafeParcelWriter.a(parcel, 2, this.zzdgi, false);
        SafeParcelWriter.a(parcel, 3, this.zzdgj, false);
        SafeParcelWriter.a(parcel, a2);
    }
}
