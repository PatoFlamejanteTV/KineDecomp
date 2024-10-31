package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzyc;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzyd<M extends zzyc<M>, T> {
    public final int tag;
    private final int type;
    private final zzuo<?, ?> zzbyg;
    protected final Class<T> zzceu;
    protected final boolean zzcev;

    private zzyd(int i, Class<T> cls, int i2, boolean z) {
        this(11, cls, null, 810, false);
    }

    public static <M extends zzyc<M>, T extends zzyi> zzyd<M, T> zza(int i, Class<T> cls, long j) {
        return new zzyd<>(11, cls, 810, false);
    }

    private final Object zze(zzxz zzxzVar) {
        Class componentType = this.zzcev ? this.zzceu.getComponentType() : this.zzceu;
        try {
            int i = this.type;
            if (i == 10) {
                zzyi zzyiVar = (zzyi) componentType.newInstance();
                zzxzVar.zza(zzyiVar, this.tag >>> 3);
                return zzyiVar;
            }
            if (i == 11) {
                zzyi zzyiVar2 = (zzyi) componentType.newInstance();
                zzxzVar.zza(zzyiVar2);
                return zzyiVar2;
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
        if (!(obj instanceof zzyd)) {
            return false;
        }
        zzyd zzydVar = (zzyd) obj;
        return this.type == zzydVar.type && this.zzceu == zzydVar.zzceu && this.tag == zzydVar.tag && this.zzcev == zzydVar.zzcev;
    }

    public final int hashCode() {
        return ((((((this.type + 1147) * 31) + this.zzceu.hashCode()) * 31) + this.tag) * 31) + (this.zzcev ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final T zzai(List<Hb> list) {
        if (list == null) {
            return null;
        }
        if (this.zzcev) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                byte[] bArr = list.get(i).f13371b;
                if (bArr.length != 0) {
                    arrayList.add(zze(zzxz.zzn(bArr)));
                }
            }
            int size = arrayList.size();
            if (size == 0) {
                return null;
            }
            Class<T> cls = this.zzceu;
            T cast = cls.cast(Array.newInstance(cls.getComponentType(), size));
            for (int i2 = 0; i2 < size; i2++) {
                Array.set(cast, i2, arrayList.get(i2));
            }
            return cast;
        }
        if (list.isEmpty()) {
            return null;
        }
        return this.zzceu.cast(zze(zzxz.zzn(list.get(list.size() - 1).f13371b)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int zzao(Object obj) {
        int i = this.tag >>> 3;
        int i2 = this.type;
        if (i2 == 10) {
            return (zzya.zzbd(i) << 1) + ((zzyi) obj).zzvx();
        }
        if (i2 == 11) {
            return zzya.zzb(i, (zzyi) obj);
        }
        StringBuilder sb = new StringBuilder(24);
        sb.append("Unknown type ");
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }

    private zzyd(int i, Class<T> cls, zzuo<?, ?> zzuoVar, int i2, boolean z) {
        this.type = i;
        this.zzceu = cls;
        this.tag = i2;
        this.zzcev = false;
        this.zzbyg = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(Object obj, zzya zzyaVar) {
        try {
            zzyaVar.zzcd(this.tag);
            int i = this.type;
            if (i == 10) {
                int i2 = this.tag >>> 3;
                ((zzyi) obj).zza(zzyaVar);
                zzyaVar.zzc(i2, 4);
            } else {
                if (i == 11) {
                    zzyaVar.zzb((zzyi) obj);
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
