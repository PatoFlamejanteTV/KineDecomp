package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzft;
import com.google.android.gms.internal.firebase_auth.zzft.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public abstract class zzft<MessageType extends zzft<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzdz<MessageType, BuilderType> {
    private static Map<Object, zzft<?, ?>> zzxa = new ConcurrentHashMap();
    protected zzir zzwy = zzir.zzjp();
    private int zzwz = -1;

    /* loaded from: classes2.dex */
    public static class zzb<T extends zzft<T, ?>> extends zzec<T> {
        private final T zzxb;

        public zzb(T t) {
            this.zzxb = t;
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzhm
        public final /* synthetic */ Object zza(zzet zzetVar, zzfg zzfgVar) throws zzgc {
            return zzft.zza(this.zzxb, zzetVar, zzfgVar);
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class zzc<MessageType extends zzc<MessageType, BuilderType>, BuilderType> extends zzft<MessageType, BuilderType> implements zzhe {
        protected C1287z<Object> zzxe = C1287z.g();
    }

    /* loaded from: classes2.dex */
    public static class zzd<ContainingType extends zzhc, Type> extends zzfe<ContainingType, Type> {
    }

    /* loaded from: classes2.dex */
    public enum zze {
        public static final int zzxf = 1;
        public static final int zzxg = 2;
        public static final int zzxh = 3;
        public static final int zzxi = 4;
        public static final int zzxj = 5;
        public static final int zzxk = 6;
        public static final int zzxl = 7;
        private static final /* synthetic */ int[] zzxm = {zzxf, zzxg, zzxh, zzxi, zzxj, zzxk, zzxl};
        public static final int zzxn = 1;
        public static final int zzxo = 2;
        private static final /* synthetic */ int[] zzxp = {zzxn, zzxo};
        public static final int zzxq = 1;
        public static final int zzxr = 2;
        private static final /* synthetic */ int[] zzxs = {zzxq, zzxr};

        public static int[] zzho() {
            return (int[]) zzxm.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzft<?, ?>> void zza(Class<T> cls, T t) {
        zzxa.put(cls, t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends zzft<?, ?>> T zzd(Class<T> cls) {
        zzft<?, ?> zzftVar = zzxa.get(cls);
        if (zzftVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzftVar = zzxa.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (zzftVar == null) {
            zzftVar = (T) ((zzft) Ja.a(cls)).zza(zze.zzxk, (Object) null, (Object) null);
            if (zzftVar != null) {
                zzxa.put(cls, zzftVar);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) zzftVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzfz zzhe() {
        return F.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> zzgb<E> zzhf() {
        return C1251ga.a();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (((zzft) zza(zze.zzxk, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return C1249fa.a().a((C1249fa) this).a(this, (zzft<MessageType, BuilderType>) obj);
        }
        return false;
    }

    public int hashCode() {
        int i = this.zzsf;
        if (i != 0) {
            return i;
        }
        this.zzsf = C1249fa.a().a((C1249fa) this).a(this);
        return this.zzsf;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhe
    public final boolean isInitialized() {
        boolean booleanValue = Boolean.TRUE.booleanValue();
        byte byteValue = ((Byte) zza(zze.zzxf, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean b2 = C1249fa.a().a((C1249fa) this).b(this);
        if (booleanValue) {
            zza(zze.zzxg, b2 ? this : null, (Object) null);
        }
        return b2;
    }

    public String toString() {
        return Y.a(this, super.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.firebase_auth.zzhc
    public final void zzb(zzfa zzfaVar) throws IOException {
        C1249fa.a().a((Class) getClass()).a((InterfaceC1263ma) this, (Ra) C1275t.a(zzfaVar));
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzdz
    final int zzes() {
        return this.zzwz;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzdz
    final void zzg(int i) {
        this.zzwz = i;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhc
    public final int zzgw() {
        if (this.zzwz == -1) {
            this.zzwz = C1249fa.a().a((C1249fa) this).c(this);
        }
        return this.zzwz;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhc
    public final /* synthetic */ zzhd zzhg() {
        zza zzaVar = (zza) zza(zze.zzxj, (Object) null, (Object) null);
        zzaVar.zza((zza) this);
        return zzaVar;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhc
    public final /* synthetic */ zzhd zzhh() {
        return (zza) zza(zze.zzxj, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhe
    public final /* synthetic */ zzhc zzhi() {
        return (zzft) zza(zze.zzxk, (Object) null, (Object) null);
    }

    /* loaded from: classes2.dex */
    public static abstract class zza<MessageType extends zzft<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzea<MessageType, BuilderType> {
        private final MessageType zzxb;
        protected MessageType zzxc;
        private boolean zzxd = false;

        /* JADX INFO: Access modifiers changed from: protected */
        public zza(MessageType messagetype) {
            this.zzxb = messagetype;
            this.zzxc = (MessageType) messagetype.zza(zze.zzxi, null, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.firebase_auth.zzea
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zzaVar = (zza) this.zzxb.zza(zze.zzxj, null, null);
            zzaVar.zza((zza) zzhm());
            return zzaVar;
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzhe
        public final boolean isInitialized() {
            return zzft.zza(this.zzxc, false);
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzea
        public final BuilderType zza(MessageType messagetype) {
            zzhj();
            zza(this.zzxc, messagetype);
            return this;
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzea
        /* renamed from: zzet */
        public final /* synthetic */ zzea clone() {
            return (zza) clone();
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzhe
        public final /* synthetic */ zzhc zzhi() {
            return this.zzxb;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void zzhj() {
            if (this.zzxd) {
                MessageType messagetype = (MessageType) this.zzxc.zza(zze.zzxi, null, null);
                zza(messagetype, this.zzxc);
                this.zzxc = messagetype;
                this.zzxd = false;
            }
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzhd
        /* renamed from: zzhk, reason: merged with bridge method [inline-methods] */
        public MessageType zzhm() {
            if (this.zzxd) {
                return this.zzxc;
            }
            MessageType messagetype = this.zzxc;
            C1249fa.a().a((C1249fa) messagetype).zzf(messagetype);
            this.zzxd = true;
            return this.zzxc;
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzhd
        /* renamed from: zzhl, reason: merged with bridge method [inline-methods] */
        public final MessageType zzhn() {
            MessageType messagetype = (MessageType) zzhm();
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) messagetype.zza(zze.zzxf, null, null)).byteValue();
            boolean z = true;
            if (byteValue != 1) {
                if (byteValue == 0) {
                    z = false;
                } else {
                    z = C1249fa.a().a((C1249fa) messagetype).b(messagetype);
                    if (booleanValue) {
                        messagetype.zza(zze.zzxg, z ? messagetype : null, null);
                    }
                }
            }
            if (z) {
                return messagetype;
            }
            throw new zzip(messagetype);
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            C1249fa.a().a((C1249fa) messagetype).b(messagetype, messagetype2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object zza(zzhc zzhcVar, String str, Object[] objArr) {
        return new C1253ha(zzhcVar, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    protected static final <T extends zzft<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zze.zzxf, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        return C1249fa.a().a((C1249fa) t).b(t);
    }

    static <T extends zzft<T, ?>> T zza(T t, zzet zzetVar, zzfg zzfgVar) throws zzgc {
        T t2 = (T) t.zza(zze.zzxi, null, null);
        try {
            C1249fa.a().a((C1249fa) t2).a(t2, r.a(zzetVar), zzfgVar);
            C1249fa.a().a((C1249fa) t2).zzf(t2);
            return t2;
        } catch (IOException e2) {
            if (e2.getCause() instanceof zzgc) {
                throw ((zzgc) e2.getCause());
            }
            throw new zzgc(e2.getMessage()).zzh(t2);
        } catch (RuntimeException e3) {
            if (e3.getCause() instanceof zzgc) {
                throw ((zzgc) e3.getCause());
            }
            throw e3;
        }
    }
}
