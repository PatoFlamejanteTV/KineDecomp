package com.google.android.gms.flags;

import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
@Deprecated
/* loaded from: classes.dex */
public abstract class Flag<T> {

    /* renamed from: a */
    private final int f11333a;

    /* renamed from: b */
    private final String f11334b;

    /* renamed from: c */
    private final T f11335c;

    @Deprecated
    /* loaded from: classes.dex */
    public static class BooleanFlag extends Flag<Boolean> {
        public BooleanFlag(int i, String str, Boolean bool) {
            super(i, str, bool);
        }

        @Override // com.google.android.gms.flags.Flag
        /* renamed from: b */
        public final Boolean a(zzc zzcVar) {
            try {
                return Boolean.valueOf(zzcVar.getBooleanFlagValue(b(), d().booleanValue(), c()));
            } catch (RemoteException unused) {
                return d();
            }
        }
    }

    @Deprecated
    @KeepForSdk
    /* loaded from: classes.dex */
    public static class IntegerFlag extends Flag<Integer> {
        public IntegerFlag(int i, String str, Integer num) {
            super(i, str, num);
        }

        @Override // com.google.android.gms.flags.Flag
        /* renamed from: b */
        public final Integer a(zzc zzcVar) {
            try {
                return Integer.valueOf(zzcVar.getIntFlagValue(b(), d().intValue(), c()));
            } catch (RemoteException unused) {
                return d();
            }
        }
    }

    @Deprecated
    @KeepForSdk
    /* loaded from: classes.dex */
    public static class LongFlag extends Flag<Long> {
        public LongFlag(int i, String str, Long l) {
            super(i, str, l);
        }

        @Override // com.google.android.gms.flags.Flag
        /* renamed from: b */
        public final Long a(zzc zzcVar) {
            try {
                return Long.valueOf(zzcVar.getLongFlagValue(b(), d().longValue(), c()));
            } catch (RemoteException unused) {
                return d();
            }
        }
    }

    @Deprecated
    @KeepForSdk
    /* loaded from: classes.dex */
    public static class StringFlag extends Flag<String> {
        public StringFlag(int i, String str, String str2) {
            super(i, str, str2);
        }

        @Override // com.google.android.gms.flags.Flag
        /* renamed from: b */
        public final String a(zzc zzcVar) {
            try {
                return zzcVar.getStringFlagValue(b(), d(), c());
            } catch (RemoteException unused) {
                return d();
            }
        }
    }

    private Flag(int i, String str, T t) {
        this.f11333a = i;
        this.f11334b = str;
        this.f11335c = t;
        Singletons.a().a(this);
    }

    @KeepForSdk
    public T a() {
        return (T) Singletons.b().a(this);
    }

    public abstract T a(zzc zzcVar);

    public final String b() {
        return this.f11334b;
    }

    @Deprecated
    public final int c() {
        return this.f11333a;
    }

    public final T d() {
        return this.f11335c;
    }

    @KeepForSdk
    @Deprecated
    public static BooleanFlag a(int i, String str, Boolean bool) {
        return new BooleanFlag(i, str, bool);
    }

    @KeepForSdk
    @Deprecated
    public static IntegerFlag a(int i, String str, int i2) {
        return new IntegerFlag(i, str, Integer.valueOf(i2));
    }

    @KeepForSdk
    @Deprecated
    public static LongFlag a(int i, String str, long j) {
        return new LongFlag(i, str, Long.valueOf(j));
    }

    @KeepForSdk
    @Deprecated
    public static StringFlag a(int i, String str, String str2) {
        return new StringFlag(i, str, str2);
    }

    /* synthetic */ Flag(int i, String str, Object obj, a aVar) {
        this(i, str, obj);
    }
}
