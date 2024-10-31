package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzuq;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzur<M extends zzuq<M>, T> {
    public final int tag;
    private final int type;
    private final zzrc<?, ?> zzban;
    protected final Class<T> zzbhc;
    protected final boolean zzbhd;

    private zzur(int i, Class<T> cls, int i2, boolean z) {
        this(11, cls, null, 810, false);
    }

    public static <M extends zzuq<M>, T extends zzuw> zzur<M, T> zza(int i, Class<T> cls, long j) {
        return new zzur<>(11, cls, 810, false);
    }

    private final Object zzc(zzun zzunVar) {
        Class componentType = this.zzbhd ? this.zzbhc.getComponentType() : this.zzbhc;
        try {
            int i = this.type;
            if (i == 10) {
                zzuw zzuwVar = (zzuw) componentType.newInstance();
                zzunVar.zza(zzuwVar, this.tag >>> 3);
                return zzuwVar;
            }
            if (i == 11) {
                zzuw zzuwVar2 = (zzuw) componentType.newInstance();
                zzunVar.zza(zzuwVar2);
                return zzuwVar2;
            }
            int i2 = this.type;
            StringBuilder sb = new StringBuilder(24);
            sb.append("Unknown type ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        } catch (IOException e2) {
            throw new IllegalArgumentException("Error reading extension field", e2);
        } catch (IllegalAccessException e3) {
            String valueOf = String.valueOf(componentType);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 33);
            sb2.append("Error creating instance of class ");
            sb2.append(valueOf);
            throw new IllegalArgumentException(sb2.toString(), e3);
        } catch (InstantiationException e4) {
            String valueOf2 = String.valueOf(componentType);
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 33);
            sb3.append("Error creating instance of class ");
            sb3.append(valueOf2);
            throw new IllegalArgumentException(sb3.toString(), e4);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzur)) {
            return false;
        }
        zzur zzurVar = (zzur) obj;
        return this.type == zzurVar.type && this.zzbhc == zzurVar.zzbhc && this.tag == zzurVar.tag && this.zzbhd == zzurVar.zzbhd;
    }

    public final int hashCode() {
        return ((((((this.type + 1147) * 31) + this.zzbhc.hashCode()) * 31) + this.tag) * 31) + (this.zzbhd ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final T zzag(List<Eb> list) {
        if (list == null) {
            return null;
        }
        if (this.zzbhd) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                byte[] bArr = list.get(i).f13144b;
                if (bArr.length != 0) {
                    arrayList.add(zzc(zzun.zzk(bArr)));
                }
            }
            int size = arrayList.size();
            if (size == 0) {
                return null;
            }
            Class<T> cls = this.zzbhc;
            T cast = cls.cast(Array.newInstance(cls.getComponentType(), size));
            for (int i2 = 0; i2 < size; i2++) {
                Array.set(cast, i2, arrayList.get(i2));
            }
            return cast;
        }
        if (list.isEmpty()) {
            return null;
        }
        return this.zzbhc.cast(zzc(zzun.zzk(list.get(list.size() - 1).f13144b)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int zzaj(Object obj) {
        int i = this.tag >>> 3;
        int i2 = this.type;
        if (i2 == 10) {
            return (zzuo.zzbb(i) << 1) + ((zzuw) obj).zzpe();
        }
        if (i2 == 11) {
            return zzuo.zzb(i, (zzuw) obj);
        }
        StringBuilder sb = new StringBuilder(24);
        sb.append("Unknown type ");
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }

    private zzur(int i, Class<T> cls, zzrc<?, ?> zzrcVar, int i2, boolean z) {
        this.type = i;
        this.zzbhc = cls;
        this.tag = i2;
        this.zzbhd = false;
        this.zzban = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(Object obj, zzuo zzuoVar) {
        try {
            zzuoVar.zzcb(this.tag);
            int i = this.type;
            if (i == 10) {
                int i2 = this.tag >>> 3;
                ((zzuw) obj).zza(zzuoVar);
                zzuoVar.zzd(i2, 4);
            } else {
                if (i == 11) {
                    zzuoVar.zzb((zzuw) obj);
                    return;
                }
                int i3 = this.type;
                StringBuilder sb = new StringBuilder(24);
                sb.append("Unknown type ");
                sb.append(i3);
                throw new IllegalArgumentException(sb.toString());
            }
        } catch (IOException e2) {
            throw new IllegalStateException(e2);
        }
    }
}
