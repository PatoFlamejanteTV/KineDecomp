package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.util.ArraySet;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class zzt extends zzaz {
    public static final Parcelable.Creator<zzt> CREATOR = new zzu();

    /* renamed from: a */
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> f10465a;

    /* renamed from: b */
    @SafeParcelable.Indicator
    private final Set<Integer> f10466b;

    /* renamed from: c */
    private final int f10467c;

    /* renamed from: d */
    private String f10468d;

    /* renamed from: e */
    private int f10469e;

    /* renamed from: f */
    private byte[] f10470f;

    /* renamed from: g */
    private PendingIntent f10471g;

    /* renamed from: h */
    private DeviceMetaData f10472h;

    static {
        HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
        f10465a = hashMap;
        hashMap.put("accountType", FastJsonResponse.Field.c("accountType", 2));
        f10465a.put("status", FastJsonResponse.Field.b("status", 3));
        f10465a.put("transferBytes", FastJsonResponse.Field.a("transferBytes", 4));
    }

    @SafeParcelable.Constructor
    public zzt(@SafeParcelable.Indicator Set<Integer> set, @SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i2, @SafeParcelable.Param(id = 4) byte[] bArr, @SafeParcelable.Param(id = 5) PendingIntent pendingIntent, @SafeParcelable.Param(id = 6) DeviceMetaData deviceMetaData) {
        this.f10466b = set;
        this.f10467c = i;
        this.f10468d = str;
        this.f10469e = i2;
        this.f10470f = bArr;
        this.f10471g = pendingIntent;
        this.f10472h = deviceMetaData;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public /* synthetic */ Map getFieldMappings() {
        return f10465a;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Object getFieldValue(FastJsonResponse.Field field) {
        int a2 = field.a();
        if (a2 == 1) {
            return Integer.valueOf(this.f10467c);
        }
        if (a2 == 2) {
            return this.f10468d;
        }
        if (a2 == 3) {
            return Integer.valueOf(this.f10469e);
        }
        if (a2 == 4) {
            return this.f10470f;
        }
        int a3 = field.a();
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unknown SafeParcelable id=");
        sb.append(a3);
        throw new IllegalStateException(sb.toString());
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public boolean isFieldSet(FastJsonResponse.Field field) {
        return this.f10466b.contains(Integer.valueOf(field.a()));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected void setDecodedBytesInternal(FastJsonResponse.Field<?, ?> field, String str, byte[] bArr) {
        int a2 = field.a();
        if (a2 == 4) {
            this.f10470f = bArr;
            this.f10466b.add(Integer.valueOf(a2));
        } else {
            StringBuilder sb = new StringBuilder(59);
            sb.append("Field with id=");
            sb.append(a2);
            sb.append(" is not known to be an byte array.");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected void setIntegerInternal(FastJsonResponse.Field<?, ?> field, String str, int i) {
        int a2 = field.a();
        if (a2 == 3) {
            this.f10469e = i;
            this.f10466b.add(Integer.valueOf(a2));
        } else {
            StringBuilder sb = new StringBuilder(52);
            sb.append("Field with id=");
            sb.append(a2);
            sb.append(" is not known to be an int.");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected void setStringInternal(FastJsonResponse.Field<?, ?> field, String str, String str2) {
        int a2 = field.a();
        if (a2 == 2) {
            this.f10468d = str2;
            this.f10466b.add(Integer.valueOf(a2));
            return;
        }
        throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", Integer.valueOf(a2)));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        Set<Integer> set = this.f10466b;
        if (set.contains(1)) {
            SafeParcelWriter.a(parcel, 1, this.f10467c);
        }
        if (set.contains(2)) {
            SafeParcelWriter.a(parcel, 2, this.f10468d, true);
        }
        if (set.contains(3)) {
            SafeParcelWriter.a(parcel, 3, this.f10469e);
        }
        if (set.contains(4)) {
            SafeParcelWriter.a(parcel, 4, this.f10470f, true);
        }
        if (set.contains(5)) {
            SafeParcelWriter.a(parcel, 5, (Parcelable) this.f10471g, i, true);
        }
        if (set.contains(6)) {
            SafeParcelWriter.a(parcel, 6, (Parcelable) this.f10472h, i, true);
        }
        SafeParcelWriter.a(parcel, a2);
    }

    public zzt() {
        this.f10466b = new ArraySet(3);
        this.f10467c = 1;
    }
}
