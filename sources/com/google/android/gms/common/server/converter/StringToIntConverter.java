package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;

@KeepForSdk
/* loaded from: classes.dex */
public final class StringToIntConverter extends AbstractSafeParcelable implements FastJsonResponse.FieldConverter<String, Integer> {
    public static final Parcelable.Creator<StringToIntConverter> CREATOR = new zac();

    /* renamed from: a */
    private final int f11193a;

    /* renamed from: b */
    private final HashMap<String, Integer> f11194b;

    /* renamed from: c */
    private final SparseArray<String> f11195c;

    /* renamed from: d */
    private final ArrayList<zaa> f11196d;

    @SafeParcelable.Constructor
    public StringToIntConverter(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) ArrayList<zaa> arrayList) {
        this.f11193a = i;
        this.f11194b = new HashMap<>();
        this.f11195c = new SparseArray<>();
        this.f11196d = null;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            zaa zaaVar = arrayList.get(i2);
            i2++;
            zaa zaaVar2 = zaaVar;
            a(zaaVar2.f11198b, zaaVar2.f11199c);
        }
    }

    @KeepForSdk
    public final StringToIntConverter a(String str, int i) {
        this.f11194b.put(str, Integer.valueOf(i));
        this.f11195c.put(i, str);
        return this;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter
    public final /* synthetic */ String b(Integer num) {
        String str = this.f11195c.get(num.intValue());
        return (str == null && this.f11194b.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.f11193a);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f11194b.keySet()) {
            arrayList.add(new zaa(str, this.f11194b.get(str).intValue()));
        }
        SafeParcelWriter.d(parcel, 2, arrayList, false);
        SafeParcelWriter.a(parcel, a2);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter
    public final /* synthetic */ Integer a(String str) {
        Integer num = this.f11194b.get(str);
        return num == null ? this.f11194b.get("gms_unknown") : num;
    }

    /* loaded from: classes.dex */
    public static final class zaa extends AbstractSafeParcelable {
        public static final Parcelable.Creator<zaa> CREATOR = new zad();

        /* renamed from: a */
        private final int f11197a;

        /* renamed from: b */
        final String f11198b;

        /* renamed from: c */
        final int f11199c;

        @SafeParcelable.Constructor
        public zaa(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i2) {
            this.f11197a = i;
            this.f11198b = str;
            this.f11199c = i2;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int a2 = SafeParcelWriter.a(parcel);
            SafeParcelWriter.a(parcel, 1, this.f11197a);
            SafeParcelWriter.a(parcel, 2, this.f11198b, false);
            SafeParcelWriter.a(parcel, 3, this.f11199c);
            SafeParcelWriter.a(parcel, a2);
        }

        zaa(String str, int i) {
            this.f11197a = 1;
            this.f11198b = str;
            this.f11199c = i;
        }
    }

    @KeepForSdk
    public StringToIntConverter() {
        this.f11193a = 1;
        this.f11194b = new HashMap<>();
        this.f11195c = new SparseArray<>();
        this.f11196d = null;
    }
}
