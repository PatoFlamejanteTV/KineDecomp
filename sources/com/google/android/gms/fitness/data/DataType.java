package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzmj;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class DataType implements SafeParcelable {
    private final int V;
    private final String W;
    private final List<Field> X;

    /* renamed from: a, reason: collision with root package name */
    public static final DataType f1223a = new DataType("com.google.step_count.delta", Field.d);
    public static final DataType b = new DataType("com.google.step_count.cumulative", Field.d);
    public static final DataType c = new DataType("com.google.step_count.cadence", Field.t);
    public static final DataType d = new DataType("com.google.activity.segment", Field.f1225a);
    public static final DataType e = new DataType("com.google.floor_change", Field.f1225a, Field.b, Field.A, Field.D);
    public static final DataType f = new DataType("com.google.calories.consumed", Field.v);
    public static final DataType g = new DataType("com.google.calories.expended", Field.v);
    public static final DataType h = new DataType("com.google.calories.bmr", Field.v);
    public static final DataType i = new DataType("com.google.power.sample", Field.w);
    public static final DataType j = new DataType("com.google.activity.sample", Field.f1225a, Field.b);
    public static final DataType k = new DataType("com.google.accelerometer", Field.S, Field.T, Field.U);
    public static final DataType l = new DataType("com.google.heart_rate.bpm", Field.i);
    public static final DataType m = new DataType("com.google.location.sample", Field.j, Field.k, Field.l, Field.m);
    public static final DataType n = new DataType("com.google.location.track", Field.j, Field.k, Field.l, Field.m);
    public static final DataType o = new DataType("com.google.distance.delta", Field.n);
    public static final DataType p = new DataType("com.google.distance.cumulative", Field.n);
    public static final DataType q = new DataType("com.google.speed", Field.s);
    public static final DataType r = new DataType("com.google.cycling.wheel_revolution.cumulative", Field.u);
    public static final DataType s = new DataType("com.google.cycling.wheel_revolution.rpm", Field.t);
    public static final DataType t = new DataType("com.google.cycling.pedaling.cumulative", Field.u);
    public static final DataType u = new DataType("com.google.cycling.pedaling.cadence", Field.t);
    public static final DataType v = new DataType("com.google.height", Field.o);
    public static final DataType w = new DataType("com.google.weight", Field.p);
    public static final DataType x = new DataType("com.google.body.fat.percentage", Field.r);
    public static final DataType y = new DataType("com.google.body.waist.circumference", Field.q);
    public static final DataType z = new DataType("com.google.body.hip.circumference", Field.q);
    public static final DataType A = new DataType("com.google.nutrition", Field.z, Field.x, Field.y);
    public static final DataType B = new DataType("com.google.activity.exercise", Field.G, Field.H, Field.e, Field.J, Field.I);
    public static final Set<DataType> C = Collections.unmodifiableSet(new HashSet(Arrays.asList(f1223a, o, d, e, q, l, w, m, f, g, x, z, y, A)));
    public static final DataType D = new DataType("com.google.activity.summary", Field.f1225a, Field.e, Field.K);
    public static final DataType E = new DataType("com.google.floor_change.summary", Field.g, Field.h, Field.B, Field.C, Field.E, Field.F);
    public static final DataType F = new DataType("com.google.calories.bmr.summary", Field.L, Field.M, Field.N);
    public static final DataType G = f1223a;
    public static final DataType H = o;

    @Deprecated
    public static final DataType I = f;
    public static final DataType J = g;
    public static final DataType K = new DataType("com.google.heart_rate.summary", Field.L, Field.M, Field.N);
    public static final DataType L = new DataType("com.google.location.bounding_box", Field.O, Field.P, Field.Q, Field.R);
    public static final DataType M = new DataType("com.google.power.summary", Field.L, Field.M, Field.N);
    public static final DataType N = new DataType("com.google.speed.summary", Field.L, Field.M, Field.N);
    public static final DataType O = new DataType("com.google.body.fat.percentage.summary", Field.L, Field.M, Field.N);
    public static final DataType P = new DataType("com.google.body.hip.circumference.summary", Field.L, Field.M, Field.N);
    public static final DataType Q = new DataType("com.google.body.waist.circumference.summary", Field.L, Field.M, Field.N);
    public static final DataType R = new DataType("com.google.weight.summary", Field.L, Field.M, Field.N);
    public static final DataType S = new DataType("com.google.nutrition.summary", Field.z, Field.x);
    private static final Map<DataType, List<DataType>> U = new HashMap<DataType, List<DataType>>() { // from class: com.google.android.gms.fitness.data.DataType.1
        {
            put(DataType.d, Collections.singletonList(DataType.D));
            put(DataType.h, Collections.singletonList(DataType.F));
            put(DataType.x, Collections.singletonList(DataType.O));
            put(DataType.z, Collections.singletonList(DataType.P));
            put(DataType.y, Collections.singletonList(DataType.Q));
            put(DataType.f, Collections.singletonList(DataType.I));
            put(DataType.g, Collections.singletonList(DataType.J));
            put(DataType.o, Collections.singletonList(DataType.H));
            put(DataType.e, Collections.singletonList(DataType.E));
            put(DataType.m, Collections.singletonList(DataType.L));
            put(DataType.A, Collections.singletonList(DataType.S));
            put(DataType.i, Collections.singletonList(DataType.M));
            put(DataType.l, Collections.singletonList(DataType.K));
            put(DataType.q, Collections.singletonList(DataType.N));
            put(DataType.f1223a, Collections.singletonList(DataType.G));
            put(DataType.w, Collections.singletonList(DataType.R));
        }
    };
    public static final DataType[] T = {k, B, j, d, D, x, O, z, P, y, Q, h, F, f, g, u, t, r, s, p, o, e, E, l, K, v, L, m, n, A, S, i, M, q, N, c, b, f1223a, w, R};
    public static final Parcelable.Creator<DataType> CREATOR = new zzg();

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataType(int i2, String str, List<Field> list) {
        this.V = i2;
        this.W = str;
        this.X = Collections.unmodifiableList(list);
    }

    public DataType(String str, Field... fieldArr) {
        this(1, str, zzmj.zzb(fieldArr));
    }

    private boolean a(DataType dataType) {
        return this.W.equals(dataType.W) && this.X.equals(dataType.X);
    }

    public String a() {
        return this.W;
    }

    public List<Field> b() {
        return this.X;
    }

    public String c() {
        return this.W.startsWith("com.google.") ? this.W.substring(11) : this.W;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.V;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataType) && a((DataType) obj));
    }

    public int hashCode() {
        return this.W.hashCode();
    }

    public String toString() {
        return String.format("DataType{%s%s}", this.W, this.X);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        zzg.a(this, parcel, i2);
    }
}
