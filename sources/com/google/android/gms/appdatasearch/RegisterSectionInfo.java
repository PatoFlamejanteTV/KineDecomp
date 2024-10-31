package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/* loaded from: classes.dex */
public class RegisterSectionInfo implements SafeParcelable {
    public static final zzi CREATOR = new zzi();

    /* renamed from: a, reason: collision with root package name */
    final int f764a;
    public final String b;
    public final String c;
    public final boolean d;
    public final int e;
    public final boolean f;
    public final String g;
    public final Feature[] h;
    final int[] i;
    public final String j;

    /* loaded from: classes.dex */
    public static final class zza {

        /* renamed from: a, reason: collision with root package name */
        private final String f765a;
        private String b;
        private boolean c;
        private boolean e;
        private String f;
        private BitSet h;
        private String i;
        private int d = 1;
        private final List<Feature> g = new ArrayList();

        public zza(String str) {
            this.f765a = str;
        }

        public zza a(int i) {
            if (this.h == null) {
                this.h = new BitSet();
            }
            this.h.set(i);
            return this;
        }

        public zza a(String str) {
            this.b = str;
            return this;
        }

        public zza a(boolean z) {
            this.c = z;
            return this;
        }

        public RegisterSectionInfo a() {
            int i = 0;
            int[] iArr = null;
            if (this.h != null) {
                iArr = new int[this.h.cardinality()];
                int nextSetBit = this.h.nextSetBit(0);
                while (nextSetBit >= 0) {
                    iArr[i] = nextSetBit;
                    nextSetBit = this.h.nextSetBit(nextSetBit + 1);
                    i++;
                }
            }
            return new RegisterSectionInfo(this.f765a, this.b, this.c, this.d, this.e, this.f, (Feature[]) this.g.toArray(new Feature[this.g.size()]), iArr, this.i);
        }

        public zza b(String str) {
            this.i = str;
            return this;
        }

        public zza b(boolean z) {
            this.e = z;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RegisterSectionInfo(int i, String str, String str2, boolean z, int i2, boolean z2, String str3, Feature[] featureArr, int[] iArr, String str4) {
        this.f764a = i;
        this.b = str;
        this.c = str2;
        this.d = z;
        this.e = i2;
        this.f = z2;
        this.g = str3;
        this.h = featureArr;
        this.i = iArr;
        this.j = str4;
    }

    RegisterSectionInfo(String str, String str2, boolean z, int i, boolean z2, String str3, Feature[] featureArr, int[] iArr, String str4) {
        this(2, str, str2, z, i, z2, str3, featureArr, iArr, str4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzi zziVar = CREATOR;
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzi zziVar = CREATOR;
        zzi.a(this, parcel, i);
    }
}
