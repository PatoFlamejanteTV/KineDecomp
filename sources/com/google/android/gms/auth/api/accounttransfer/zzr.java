package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class zzr extends zzaz {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();

    /* renamed from: a */
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> f10458a;

    /* renamed from: b */
    @SafeParcelable.Indicator
    private final Set<Integer> f10459b;

    /* renamed from: c */
    private final int f10460c;

    /* renamed from: d */
    private zzt f10461d;

    /* renamed from: e */
    private String f10462e;

    /* renamed from: f */
    private String f10463f;

    /* renamed from: g */
    private String f10464g;

    static {
        HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
        f10458a = hashMap;
        hashMap.put("authenticatorInfo", FastJsonResponse.Field.a("authenticatorInfo", 2, zzt.class));
        f10458a.put("signature", FastJsonResponse.Field.c("signature", 3));
        f10458a.put("package", FastJsonResponse.Field.c("package", 4));
    }

    public zzr() {
        this.f10459b = new HashSet(3);
        this.f10460c = 1;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public <T extends FastJsonResponse> void addConcreteTypeInternal(FastJsonResponse.Field<?, ?> field, String str, T t) {
        int a2 = field.a();
        if (a2 == 2) {
            this.f10461d = (zzt) t;
            this.f10459b.add(Integer.valueOf(a2));
            return;
        }
        throw new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", Integer.valueOf(a2), t.getClass().getCanonicalName()));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public /* synthetic */ Map getFieldMappings() {
        return f10458a;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Object getFieldValue(FastJsonResponse.Field field) {
        int a2 = field.a();
        if (a2 == 1) {
            return Integer.valueOf(this.f10460c);
        }
        if (a2 == 2) {
            return this.f10461d;
        }
        if (a2 == 3) {
            return this.f10462e;
        }
        if (a2 == 4) {
            return this.f10463f;
        }
        int a3 = field.a();
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unknown SafeParcelable id=");
        sb.append(a3);
        throw new IllegalStateException(sb.toString());
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public boolean isFieldSet(FastJsonResponse.Field field) {
        return this.f10459b.contains(Integer.valueOf(field.a()));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected void setStringInternal(FastJsonResponse.Field<?, ?> field, String str, String str2) {
        int a2 = field.a();
        if (a2 == 3) {
            this.f10462e = str2;
        } else if (a2 == 4) {
            this.f10463f = str2;
        } else {
            throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", Integer.valueOf(a2)));
        }
        this.f10459b.add(Integer.valueOf(a2));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        Set<Integer> set = this.f10459b;
        if (set.contains(1)) {
            SafeParcelWriter.a(parcel, 1, this.f10460c);
        }
        if (set.contains(2)) {
            SafeParcelWriter.a(parcel, 2, (Parcelable) this.f10461d, i, true);
        }
        if (set.contains(3)) {
            SafeParcelWriter.a(parcel, 3, this.f10462e, true);
        }
        if (set.contains(4)) {
            SafeParcelWriter.a(parcel, 4, this.f10463f, true);
        }
        if (set.contains(5)) {
            SafeParcelWriter.a(parcel, 5, this.f10464g, true);
        }
        SafeParcelWriter.a(parcel, a2);
    }

    @SafeParcelable.Constructor
    public zzr(@SafeParcelable.Indicator Set<Integer> set, @SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) zzt zztVar, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) String str3) {
        this.f10459b = set;
        this.f10460c = i;
        this.f10461d = zztVar;
        this.f10462e = str;
        this.f10463f = str2;
        this.f10464g = str3;
    }
}
