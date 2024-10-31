package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class FieldMappingDictionary implements SafeParcelable {
    public static final zzc CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    private final int f1034a;
    private final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> b;
    private final ArrayList<Entry> c;
    private final String d;

    /* loaded from: classes.dex */
    public static class Entry implements SafeParcelable {
        public static final zzd CREATOR = new zzd();

        /* renamed from: a, reason: collision with root package name */
        final int f1035a;
        final String b;
        final ArrayList<FieldMapPair> c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Entry(int i, String str, ArrayList<FieldMapPair> arrayList) {
            this.f1035a = i;
            this.b = str;
            this.c = arrayList;
        }

        Entry(String str, Map<String, FastJsonResponse.Field<?, ?>> map) {
            this.f1035a = 1;
            this.b = str;
            this.c = a(map);
        }

        private static ArrayList<FieldMapPair> a(Map<String, FastJsonResponse.Field<?, ?>> map) {
            if (map == null) {
                return null;
            }
            ArrayList<FieldMapPair> arrayList = new ArrayList<>();
            for (String str : map.keySet()) {
                arrayList.add(new FieldMapPair(str, map.get(str)));
            }
            return arrayList;
        }

        HashMap<String, FastJsonResponse.Field<?, ?>> a() {
            HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                FieldMapPair fieldMapPair = this.c.get(i);
                hashMap.put(fieldMapPair.b, fieldMapPair.c);
            }
            return hashMap;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzd zzdVar = CREATOR;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zzd zzdVar = CREATOR;
            zzd.a(this, parcel, i);
        }
    }

    /* loaded from: classes.dex */
    public static class FieldMapPair implements SafeParcelable {
        public static final zzb CREATOR = new zzb();

        /* renamed from: a, reason: collision with root package name */
        final int f1036a;
        final String b;
        final FastJsonResponse.Field<?, ?> c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public FieldMapPair(int i, String str, FastJsonResponse.Field<?, ?> field) {
            this.f1036a = i;
            this.b = str;
            this.c = field;
        }

        FieldMapPair(String str, FastJsonResponse.Field<?, ?> field) {
            this.f1036a = 1;
            this.b = str;
            this.c = field;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzb zzbVar = CREATOR;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zzb zzbVar = CREATOR;
            zzb.a(this, parcel, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FieldMappingDictionary(int i, ArrayList<Entry> arrayList, String str) {
        this.f1034a = i;
        this.c = null;
        this.b = a(arrayList);
        this.d = (String) zzx.a(str);
        a();
    }

    public FieldMappingDictionary(Class<? extends FastJsonResponse> cls) {
        this.f1034a = 1;
        this.c = null;
        this.b = new HashMap<>();
        this.d = cls.getCanonicalName();
    }

    private static HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> a(ArrayList<Entry> arrayList) {
        HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> hashMap = new HashMap<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Entry entry = arrayList.get(i);
            hashMap.put(entry.b, entry.a());
        }
        return hashMap;
    }

    public Map<String, FastJsonResponse.Field<?, ?>> a(String str) {
        return this.b.get(str);
    }

    public void a() {
        Iterator<String> it = this.b.keySet().iterator();
        while (it.hasNext()) {
            Map<String, FastJsonResponse.Field<?, ?>> map = this.b.get(it.next());
            Iterator<String> it2 = map.keySet().iterator();
            while (it2.hasNext()) {
                map.get(it2.next()).a(this);
            }
        }
    }

    public void a(Class<? extends FastJsonResponse> cls, Map<String, FastJsonResponse.Field<?, ?>> map) {
        this.b.put(cls.getCanonicalName(), map);
    }

    public boolean a(Class<? extends FastJsonResponse> cls) {
        return this.b.containsKey(cls.getCanonicalName());
    }

    public void b() {
        for (String str : this.b.keySet()) {
            Map<String, FastJsonResponse.Field<?, ?>> map = this.b.get(str);
            HashMap hashMap = new HashMap();
            for (String str2 : map.keySet()) {
                hashMap.put(str2, map.get(str2).a());
            }
            this.b.put(str, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f1034a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<Entry> d() {
        ArrayList<Entry> arrayList = new ArrayList<>();
        for (String str : this.b.keySet()) {
            arrayList.add(new Entry(str, this.b.get(str)));
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzc zzcVar = CREATOR;
        return 0;
    }

    public String e() {
        return this.d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.b.keySet()) {
            sb.append(str).append(":\n");
            Map<String, FastJsonResponse.Field<?, ?>> map = this.b.get(str);
            for (String str2 : map.keySet()) {
                sb.append("  ").append(str2).append(": ");
                sb.append(map.get(str2));
            }
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc zzcVar = CREATOR;
        zzc.a(this, parcel, i);
    }
}
