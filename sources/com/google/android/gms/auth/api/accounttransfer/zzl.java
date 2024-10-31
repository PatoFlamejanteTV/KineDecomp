package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.NotificationCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzl extends zzaz {
    public static final Parcelable.Creator<zzl> CREATOR = new zzm();

    /* renamed from: a */
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> f10445a;

    /* renamed from: b */
    @SafeParcelable.Indicator
    private final Set<Integer> f10446b;

    /* renamed from: c */
    private final int f10447c;

    /* renamed from: d */
    private ArrayList<zzr> f10448d;

    /* renamed from: e */
    private int f10449e;

    /* renamed from: f */
    private zzo f10450f;

    static {
        HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
        f10445a = hashMap;
        hashMap.put("authenticatorData", FastJsonResponse.Field.b("authenticatorData", 2, zzr.class));
        f10445a.put(NotificationCompat.CATEGORY_PROGRESS, FastJsonResponse.Field.a(NotificationCompat.CATEGORY_PROGRESS, 4, zzo.class));
    }

    @SafeParcelable.Constructor
    public zzl(@SafeParcelable.Indicator Set<Integer> set, @SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) ArrayList<zzr> arrayList, @SafeParcelable.Param(id = 3) int i2, @SafeParcelable.Param(id = 4) zzo zzoVar) {
        this.f10446b = set;
        this.f10447c = i;
        this.f10448d = arrayList;
        this.f10449e = i2;
        this.f10450f = zzoVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final <T extends FastJsonResponse> void addConcreteTypeArrayInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<T> arrayList) {
        int a2 = field.a();
        if (a2 == 2) {
            this.f10448d = arrayList;
            this.f10446b.add(Integer.valueOf(a2));
            return;
        }
        throw new IllegalArgumentException(String.format("Field with id=%d is not a known ConcreteTypeArray type. Found %s", Integer.valueOf(a2), arrayList.getClass().getCanonicalName()));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final <T extends FastJsonResponse> void addConcreteTypeInternal(FastJsonResponse.Field<?, ?> field, String str, T t) {
        int a2 = field.a();
        if (a2 == 4) {
            this.f10450f = (zzo) t;
            this.f10446b.add(Integer.valueOf(a2));
            return;
        }
        throw new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", Integer.valueOf(a2), t.getClass().getCanonicalName()));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final /* synthetic */ Map getFieldMappings() {
        return f10445a;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final Object getFieldValue(FastJsonResponse.Field field) {
        int a2 = field.a();
        if (a2 == 1) {
            return Integer.valueOf(this.f10447c);
        }
        if (a2 == 2) {
            return this.f10448d;
        }
        if (a2 == 4) {
            return this.f10450f;
        }
        int a3 = field.a();
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unknown SafeParcelable id=");
        sb.append(a3);
        throw new IllegalStateException(sb.toString());
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final boolean isFieldSet(FastJsonResponse.Field field) {
        return this.f10446b.contains(Integer.valueOf(field.a()));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        Set<Integer> set = this.f10446b;
        if (set.contains(1)) {
            SafeParcelWriter.a(parcel, 1, this.f10447c);
        }
        if (set.contains(2)) {
            SafeParcelWriter.d(parcel, 2, this.f10448d, true);
        }
        if (set.contains(3)) {
            SafeParcelWriter.a(parcel, 3, this.f10449e);
        }
        if (set.contains(4)) {
            SafeParcelWriter.a(parcel, 4, (Parcelable) this.f10450f, i, true);
        }
        SafeParcelWriter.a(parcel, a2);
    }

    public zzl() {
        this.f10446b = new HashSet(1);
        this.f10447c = 1;
    }
}
