package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzz;
import com.google.android.gms.drive.metadata.MetadataField;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public final class MetadataBundle implements SafeParcelable {
    public static final Parcelable.Creator<MetadataBundle> CREATOR = new zzh();

    /* renamed from: a, reason: collision with root package name */
    final int f1147a;
    final Bundle b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MetadataBundle(int i, Bundle bundle) {
        this.f1147a = i;
        this.b = (Bundle) zzx.a(bundle);
        this.b.setClassLoader(getClass().getClassLoader());
        ArrayList arrayList = new ArrayList();
        for (String str : this.b.keySet()) {
            if (zze.a(str) == null) {
                arrayList.add(str);
                zzz.a("MetadataBundle", "Ignored unknown metadata field in bundle: " + str);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.b.remove((String) it.next());
        }
    }

    private MetadataBundle(Bundle bundle) {
        this(1, bundle);
    }

    public static MetadataBundle a() {
        return new MetadataBundle(new Bundle());
    }

    public static MetadataBundle a(MetadataBundle metadataBundle) {
        return new MetadataBundle(new Bundle(metadataBundle.b));
    }

    public <T> T a(MetadataField<T> metadataField) {
        return metadataField.zzj(this.b);
    }

    public <T> void a(MetadataField<T> metadataField, T t) {
        if (zze.a(metadataField.getName()) == null) {
            throw new IllegalArgumentException("Unregistered field: " + metadataField.getName());
        }
        metadataField.zza(t, this.b);
    }

    public Set<MetadataField<?>> b() {
        HashSet hashSet = new HashSet();
        Iterator<String> it = this.b.keySet().iterator();
        while (it.hasNext()) {
            hashSet.add(zze.a(it.next()));
        }
        return hashSet;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetadataBundle)) {
            return false;
        }
        MetadataBundle metadataBundle = (MetadataBundle) obj;
        Set<String> keySet = this.b.keySet();
        if (!keySet.equals(metadataBundle.b.keySet())) {
            return false;
        }
        for (String str : keySet) {
            if (!zzw.a(this.b.get(str), metadataBundle.b.get(str))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 1;
        Iterator<String> it = this.b.keySet().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = this.b.get(it.next()).hashCode() + (i2 * 31);
        }
    }

    public String toString() {
        return "MetadataBundle [values=" + this.b + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.a(this, parcel, i);
    }
}
