package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class AppVisibleCustomProperties implements SafeParcelable, Iterable<CustomProperty> {
    public static final Parcelable.Creator<AppVisibleCustomProperties> CREATOR = new com.google.android.gms.drive.metadata.internal.zza();

    /* renamed from: a, reason: collision with root package name */
    public static final AppVisibleCustomProperties f1144a = new zza().a();
    final int b;
    final List<CustomProperty> c;

    /* loaded from: classes2.dex */
    public static class zza {

        /* renamed from: a, reason: collision with root package name */
        private final Map<CustomPropertyKey, CustomProperty> f1145a = new HashMap();

        public zza a(CustomProperty customProperty) {
            zzx.a(customProperty, "property");
            this.f1145a.put(customProperty.a(), customProperty);
            return this;
        }

        public AppVisibleCustomProperties a() {
            return new AppVisibleCustomProperties(this.f1145a.values());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppVisibleCustomProperties(int i, Collection<CustomProperty> collection) {
        this.b = i;
        zzx.a(collection);
        this.c = new ArrayList(collection);
    }

    private AppVisibleCustomProperties(Collection<CustomProperty> collection) {
        this(1, collection);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Iterable
    public Iterator<CustomProperty> iterator() {
        return this.c.iterator();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        com.google.android.gms.drive.metadata.internal.zza.a(this, parcel, i);
    }
}
