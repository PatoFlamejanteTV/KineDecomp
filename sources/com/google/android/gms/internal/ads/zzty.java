package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@zzark
/* loaded from: classes2.dex */
public final class zzty extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzty> CREATOR = new zztz();
    public final String url;
    private final long zzbzv;
    private final String zzbzw;
    private final String zzbzx;
    private final String zzbzy;
    private final Bundle zzbzz;
    public final boolean zzcaa;
    public long zzcab;

    @SafeParcelable.Constructor
    public zzty(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) long j, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) String str3, @SafeParcelable.Param(id = 6) String str4, @SafeParcelable.Param(id = 7) Bundle bundle, @SafeParcelable.Param(id = 8) boolean z, @SafeParcelable.Param(id = 9) long j2) {
        this.url = str;
        this.zzbzv = j;
        this.zzbzw = str2 == null ? "" : str2;
        this.zzbzx = str3 == null ? "" : str3;
        this.zzbzy = str4 != null ? str4 : "";
        this.zzbzz = bundle == null ? new Bundle() : bundle;
        this.zzcaa = z;
        this.zzcab = j2;
    }

    public static zzty zzbb(String str) {
        return zzd(Uri.parse(str));
    }

    public static zzty zzd(Uri uri) {
        try {
            if (!"gcache".equals(uri.getScheme())) {
                return null;
            }
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.size() != 2) {
                int size = pathSegments.size();
                StringBuilder sb = new StringBuilder(62);
                sb.append("Expected 2 path parts for namespace and id, found :");
                sb.append(size);
                zzbbd.zzeo(sb.toString());
                return null;
            }
            String str = pathSegments.get(0);
            String str2 = pathSegments.get(1);
            String host = uri.getHost();
            String queryParameter = uri.getQueryParameter("url");
            boolean equals = "1".equals(uri.getQueryParameter("read_only"));
            String queryParameter2 = uri.getQueryParameter("expiration");
            long parseLong = queryParameter2 == null ? 0L : Long.parseLong(queryParameter2);
            Bundle bundle = new Bundle();
            for (String str3 : com.google.android.gms.ads.internal.zzbv.g().zzh(uri)) {
                if (str3.startsWith("tag.")) {
                    bundle.putString(str3.substring(4), uri.getQueryParameter(str3));
                }
            }
            return new zzty(queryParameter, parseLong, host, str, str2, bundle, equals, 0L);
        } catch (NullPointerException | NumberFormatException e2) {
            zzbbd.zzc("Unable to parse Uri into cache offering.", e2);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.url, false);
        SafeParcelWriter.a(parcel, 3, this.zzbzv);
        SafeParcelWriter.a(parcel, 4, this.zzbzw, false);
        SafeParcelWriter.a(parcel, 5, this.zzbzx, false);
        SafeParcelWriter.a(parcel, 6, this.zzbzy, false);
        SafeParcelWriter.a(parcel, 7, this.zzbzz, false);
        SafeParcelWriter.a(parcel, 8, this.zzcaa);
        SafeParcelWriter.a(parcel, 9, this.zzcab);
        SafeParcelWriter.a(parcel, a2);
    }
}
