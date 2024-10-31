package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class StringToIntConverter implements SafeParcelable, FastJsonResponse.zza<String, Integer> {
    public static final zzb CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    private final int f1031a;
    private final HashMap<String, Integer> b;
    private final HashMap<Integer, String> c;
    private final ArrayList<Entry> d;

    /* loaded from: classes.dex */
    public static final class Entry implements SafeParcelable {
        public static final zzc CREATOR = new zzc();

        /* renamed from: a, reason: collision with root package name */
        final int f1032a;
        final String b;
        final int c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Entry(int i, String str, int i2) {
            this.f1032a = i;
            this.b = str;
            this.c = i2;
        }

        Entry(String str, int i) {
            this.f1032a = 1;
            this.b = str;
            this.c = i;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzc zzcVar = CREATOR;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zzc zzcVar = CREATOR;
            zzc.a(this, parcel, i);
        }
    }

    public StringToIntConverter() {
        this.f1031a = 1;
        this.b = new HashMap<>();
        this.c = new HashMap<>();
        this.d = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StringToIntConverter(int i, ArrayList<Entry> arrayList) {
        this.f1031a = i;
        this.b = new HashMap<>();
        this.c = new HashMap<>();
        this.d = null;
        a(arrayList);
    }

    private void a(ArrayList<Entry> arrayList) {
        Iterator<Entry> it = arrayList.iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            a(next.b, next.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f1031a;
    }

    public StringToIntConverter a(String str, int i) {
        this.b.put(str, Integer.valueOf(i));
        this.c.put(Integer.valueOf(i), str);
        return this;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.zza
    public String a(Integer num) {
        String str = this.c.get(num);
        return (str == null && this.b.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<Entry> b() {
        ArrayList<Entry> arrayList = new ArrayList<>();
        for (String str : this.b.keySet()) {
            arrayList.add(new Entry(str, this.b.get(str).intValue()));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.zza
    public int c() {
        return 7;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.zza
    public int d() {
        return 0;
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
