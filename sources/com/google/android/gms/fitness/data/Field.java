package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
public final class Field implements SafeParcelable {
    private final int V;
    private final String W;
    private final int X;

    /* renamed from: a, reason: collision with root package name */
    public static final Field f1225a = a("activity");
    public static final Field b = b("confidence");
    public static final Field c = d("activity_confidence");
    public static final Field d = a("steps");
    public static final Field e = a("duration");
    public static final Field f = d("activity_duration");
    public static final Field g = d("activity_duration.ascending");
    public static final Field h = d("activity_duration.descending");
    public static final Field i = b("bpm");
    public static final Field j = b("latitude");
    public static final Field k = b("longitude");
    public static final Field l = b("accuracy");
    public static final Field m = b("altitude");
    public static final Field n = b("distance");
    public static final Field o = b("height");
    public static final Field p = b("weight");
    public static final Field q = b("circumference");
    public static final Field r = b("percentage");
    public static final Field s = b("speed");
    public static final Field t = b("rpm");
    public static final Field u = a("revolutions");
    public static final Field v = b("calories");
    public static final Field w = b("watts");
    public static final Field x = a("meal_type");
    public static final Field y = c("food_item");
    public static final Field z = d("nutrients");
    public static final Field A = b("elevation.change");
    public static final Field B = d("elevation.gain");
    public static final Field C = d("elevation.loss");
    public static final Field D = b("floors");
    public static final Field E = d("floor.gain");
    public static final Field F = d("floor.loss");
    public static final Field G = c("exercise");
    public static final Field H = a("repetitions");
    public static final Field I = b("resistance");
    public static final Field J = a("resistance_type");
    public static final Field K = a("num_segments");
    public static final Field L = b("average");
    public static final Field M = b("max");
    public static final Field N = b("min");
    public static final Field O = b("low_latitude");
    public static final Field P = b("low_longitude");
    public static final Field Q = b("high_latitude");
    public static final Field R = b("high_longitude");
    public static final Field S = b("x");
    public static final Field T = b("y");
    public static final Field U = b("z");
    public static final Parcelable.Creator<Field> CREATOR = new zzi();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Field(int i2, String str, int i3) {
        this.V = i2;
        this.W = (String) zzx.a(str);
        this.X = i3;
    }

    private Field(String str, int i2) {
        this(1, str, i2);
    }

    private static Field a(String str) {
        return new Field(str, 1);
    }

    private boolean a(Field field) {
        return this.W.equals(field.W) && this.X == field.X;
    }

    private static Field b(String str) {
        return new Field(str, 2);
    }

    private static Field c(String str) {
        return new Field(str, 3);
    }

    private static Field d(String str) {
        return new Field(str, 4);
    }

    public String a() {
        return this.W;
    }

    public int b() {
        return this.X;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.V;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof Field) && a((Field) obj));
    }

    public int hashCode() {
        return this.W.hashCode();
    }

    public String toString() {
        Object[] objArr = new Object[2];
        objArr[0] = this.W;
        objArr[1] = this.X == 1 ? "i" : "f";
        return String.format("%s(%s)", objArr);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        zzi.a(this, parcel, i2);
    }
}
