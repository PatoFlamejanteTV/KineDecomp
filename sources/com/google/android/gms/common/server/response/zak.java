package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@ShowFirstParty
/* loaded from: classes.dex */
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new zan();

    /* renamed from: a */
    private final int f11225a;

    /* renamed from: b */
    private final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> f11226b;

    /* renamed from: c */
    private final ArrayList<zal> f11227c = null;

    /* renamed from: d */
    private final String f11228d;

    @SafeParcelable.Constructor
    public zak(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) ArrayList<zal> arrayList, @SafeParcelable.Param(id = 3) String str) {
        this.f11225a = i;
        HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> hashMap = new HashMap<>();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            zal zalVar = arrayList.get(i2);
            String str2 = zalVar.f11230b;
            HashMap hashMap2 = new HashMap();
            int size2 = zalVar.f11231c.size();
            for (int i3 = 0; i3 < size2; i3++) {
                zam zamVar = zalVar.f11231c.get(i3);
                hashMap2.put(zamVar.f11233b, zamVar.f11234c);
            }
            hashMap.put(str2, hashMap2);
        }
        this.f11226b = hashMap;
        Preconditions.a(str);
        this.f11228d = str;
        a();
    }

    public final String O() {
        return this.f11228d;
    }

    public final void a() {
        Iterator<String> it = this.f11226b.keySet().iterator();
        while (it.hasNext()) {
            Map<String, FastJsonResponse.Field<?, ?>> map = this.f11226b.get(it.next());
            Iterator<String> it2 = map.keySet().iterator();
            while (it2.hasNext()) {
                map.get(it2.next()).a(this);
            }
        }
    }

    public final Map<String, FastJsonResponse.Field<?, ?>> e(String str) {
        return this.f11226b.get(str);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.f11226b.keySet()) {
            sb.append(str);
            sb.append(":\n");
            Map<String, FastJsonResponse.Field<?, ?>> map = this.f11226b.get(str);
            for (String str2 : map.keySet()) {
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(map.get(str2));
            }
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.f11225a);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f11226b.keySet()) {
            arrayList.add(new zal(str, this.f11226b.get(str)));
        }
        SafeParcelWriter.d(parcel, 2, arrayList, false);
        SafeParcelWriter.a(parcel, 3, this.f11228d, false);
        SafeParcelWriter.a(parcel, a2);
    }
}
