package com.google.android.gms.internal;

import com.google.android.gms.internal.zzry;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class zzrz<M extends zzry<M>, T> {
    public final int tag;
    protected final int type;
    protected final Class<T> zzbil;
    protected final boolean zzbim;

    private zzrz(int i, Class<T> cls, int i2, boolean z) {
        this.type = i;
        this.zzbil = cls;
        this.tag = i2;
        this.zzbim = z;
    }

    private T zzF(List<jm> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            jm jmVar = list.get(i);
            if (jmVar.b.length != 0) {
                zza(jmVar, arrayList);
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        T cast = this.zzbil.cast(Array.newInstance(this.zzbil.getComponentType(), size));
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(cast, i2, arrayList.get(i2));
        }
        return cast;
    }

    private T zzG(List<jm> list) {
        if (list.isEmpty()) {
            return null;
        }
        return this.zzbil.cast(zzF(zzrw.zzB(list.get(list.size() - 1).b)));
    }

    public static <M extends zzry<M>, T extends zzse> zzrz<M, T> zza(int i, Class<T> cls, long j) {
        return new zzrz<>(i, cls, (int) j, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final T zzE(List<jm> list) {
        if (list == null) {
            return null;
        }
        return this.zzbim ? zzF(list) : zzG(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected Object zzF(zzrw zzrwVar) {
        Class componentType = this.zzbim ? this.zzbil.getComponentType() : this.zzbil;
        try {
            switch (this.type) {
                case 10:
                    zzse zzseVar = (zzse) componentType.newInstance();
                    zzrwVar.zza(zzseVar, zzsh.zzlV(this.tag));
                    return zzseVar;
                case 11:
                    zzse zzseVar2 = (zzse) componentType.newInstance();
                    zzrwVar.zza(zzseVar2);
                    return zzseVar2;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Error reading extension field", e);
        } catch (IllegalAccessException e2) {
            throw new IllegalArgumentException("Error creating instance of class " + componentType, e2);
        } catch (InstantiationException e3) {
            throw new IllegalArgumentException("Error creating instance of class " + componentType, e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int zzX(Object obj) {
        return this.zzbim ? zzY(obj) : zzZ(obj);
    }

    protected int zzY(Object obj) {
        int i = 0;
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += zzZ(Array.get(obj, i2));
            }
        }
        return i;
    }

    protected int zzZ(Object obj) {
        int zzlV = zzsh.zzlV(this.tag);
        switch (this.type) {
            case 10:
                return zzrx.zzb(zzlV, (zzse) obj);
            case 11:
                return zzrx.zzc(zzlV, (zzse) obj);
            default:
                throw new IllegalArgumentException("Unknown type " + this.type);
        }
    }

    protected void zza(jm jmVar, List<Object> list) {
        list.add(zzF(zzrw.zzB(jmVar.b)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zza(Object obj, zzrx zzrxVar) throws IOException {
        if (this.zzbim) {
            zzc(obj, zzrxVar);
        } else {
            zzb(obj, zzrxVar);
        }
    }

    protected void zzb(Object obj, zzrx zzrxVar) {
        try {
            zzrxVar.zzlN(this.tag);
            switch (this.type) {
                case 10:
                    int zzlV = zzsh.zzlV(this.tag);
                    zzrxVar.zzb((zzse) obj);
                    zzrxVar.zzC(zzlV, 4);
                    return;
                case 11:
                    zzrxVar.zzc((zzse) obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    protected void zzc(Object obj, zzrx zzrxVar) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                zzb(obj2, zzrxVar);
            }
        }
    }
}
