package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.util.ArrayMap;
import com.facebook.GraphResponse;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class zzo extends zzaz {
    public static final Parcelable.Creator<zzo> CREATOR = new zzp();

    /* renamed from: a */
    private static final ArrayMap<String, FastJsonResponse.Field<?, ?>> f10451a;

    /* renamed from: b */
    private final int f10452b;

    /* renamed from: c */
    private List<String> f10453c;

    /* renamed from: d */
    private List<String> f10454d;

    /* renamed from: e */
    private List<String> f10455e;

    /* renamed from: f */
    private List<String> f10456f;

    /* renamed from: g */
    private List<String> f10457g;

    static {
        ArrayMap<String, FastJsonResponse.Field<?, ?>> arrayMap = new ArrayMap<>();
        f10451a = arrayMap;
        arrayMap.put("registered", FastJsonResponse.Field.d("registered", 2));
        f10451a.put("in_progress", FastJsonResponse.Field.d("in_progress", 3));
        f10451a.put(GraphResponse.SUCCESS_KEY, FastJsonResponse.Field.d(GraphResponse.SUCCESS_KEY, 4));
        f10451a.put("failed", FastJsonResponse.Field.d("failed", 5));
        f10451a.put("escrowed", FastJsonResponse.Field.d("escrowed", 6));
    }

    public zzo() {
        this.f10452b = 1;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings() {
        return f10451a;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Object getFieldValue(FastJsonResponse.Field field) {
        switch (field.a()) {
            case 1:
                return Integer.valueOf(this.f10452b);
            case 2:
                return this.f10453c;
            case 3:
                return this.f10454d;
            case 4:
                return this.f10455e;
            case 5:
                return this.f10456f;
            case 6:
                return this.f10457g;
            default:
                int a2 = field.a();
                StringBuilder sb = new StringBuilder(37);
                sb.append("Unknown SafeParcelable id=");
                sb.append(a2);
                throw new IllegalStateException(sb.toString());
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public boolean isFieldSet(FastJsonResponse.Field field) {
        return true;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected void setStringsInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<String> arrayList) {
        int a2 = field.a();
        if (a2 == 2) {
            this.f10453c = arrayList;
            return;
        }
        if (a2 == 3) {
            this.f10454d = arrayList;
            return;
        }
        if (a2 == 4) {
            this.f10455e = arrayList;
        } else if (a2 == 5) {
            this.f10456f = arrayList;
        } else {
            if (a2 == 6) {
                this.f10457g = arrayList;
                return;
            }
            throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string list.", Integer.valueOf(a2)));
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.f10452b);
        SafeParcelWriter.c(parcel, 2, this.f10453c, false);
        SafeParcelWriter.c(parcel, 3, this.f10454d, false);
        SafeParcelWriter.c(parcel, 4, this.f10455e, false);
        SafeParcelWriter.c(parcel, 5, this.f10456f, false);
        SafeParcelWriter.c(parcel, 6, this.f10457g, false);
        SafeParcelWriter.a(parcel, a2);
    }

    @SafeParcelable.Constructor
    public zzo(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) List<String> list, @SafeParcelable.Param(id = 3) List<String> list2, @SafeParcelable.Param(id = 4) List<String> list3, @SafeParcelable.Param(id = 5) List<String> list4, @SafeParcelable.Param(id = 6) List<String> list5) {
        this.f10452b = i;
        this.f10453c = list;
        this.f10454d = list2;
        this.f10455e = list3;
        this.f10456f = list4;
        this.f10457g = list5;
    }
}
