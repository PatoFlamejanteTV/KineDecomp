package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
public class DataSource implements SafeParcelable {
    public static final Parcelable.Creator<DataSource> CREATOR = new zzf();

    /* renamed from: a, reason: collision with root package name */
    private final int f1221a;
    private final DataType b;
    private final String c;
    private final int d;
    private final Device e;
    private final Application f;
    private final String g;
    private final String h;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private DataType f1222a;
        private String c;
        private Device d;
        private Application e;
        private int b = -1;
        private String f = "";

        public Builder a(int i) {
            this.b = i;
            return this;
        }

        public Builder a(DataType dataType) {
            this.f1222a = dataType;
            return this;
        }

        public Builder a(String str) {
            this.c = str;
            return this;
        }

        public DataSource a() {
            zzx.a(this.f1222a != null, "Must set data type");
            zzx.a(this.b >= 0, "Must set data source type");
            return new DataSource(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataSource(int i, DataType dataType, String str, int i2, Device device, Application application, String str2) {
        this.f1221a = i;
        this.b = dataType;
        this.d = i2;
        this.c = str;
        this.e = device;
        this.f = application;
        this.g = str2;
        this.h = i();
    }

    private DataSource(Builder builder) {
        this.f1221a = 3;
        this.b = builder.f1222a;
        this.d = builder.b;
        this.c = builder.c;
        this.e = builder.d;
        this.f = builder.e;
        this.g = builder.f;
        this.h = i();
    }

    private boolean a(DataSource dataSource) {
        return this.h.equals(dataSource.h);
    }

    private String i() {
        StringBuilder sb = new StringBuilder();
        sb.append(j());
        sb.append(":").append(this.b.a());
        if (this.f != null) {
            sb.append(":").append(this.f.a());
        }
        if (this.e != null) {
            sb.append(":").append(this.e.g());
        }
        if (this.g != null) {
            sb.append(":").append(this.g);
        }
        return sb.toString();
    }

    private String j() {
        switch (this.d) {
            case 0:
                return "raw";
            case 1:
                return "derived";
            default:
                throw new IllegalArgumentException("invalid type value");
        }
    }

    public DataType a() {
        return this.b;
    }

    public int b() {
        return this.d;
    }

    public String c() {
        return this.c;
    }

    public Application d() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Device e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataSource) && a((DataSource) obj));
    }

    public String f() {
        return this.g;
    }

    public String g() {
        return (this.d == 0 ? "r" : "d") + ":" + this.b.c() + (this.f == null ? "" : this.f.equals(Application.f1216a) ? ":gms" : ":" + this.f.a()) + (this.e != null ? ":" + this.e.b() + ":" + this.e.d() : "") + (this.g != null ? ":" + this.g : "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.f1221a;
    }

    public int hashCode() {
        return this.h.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataSource{");
        sb.append(j());
        if (this.c != null) {
            sb.append(":").append(this.c);
        }
        if (this.f != null) {
            sb.append(":").append(this.f);
        }
        if (this.e != null) {
            sb.append(":").append(this.e);
        }
        if (this.g != null) {
            sb.append(":").append(this.g);
        }
        sb.append(":").append(this.b);
        return sb.append("}").toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.a(this, parcel, i);
    }
}
