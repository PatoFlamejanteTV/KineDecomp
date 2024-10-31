package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuo;
import com.google.android.gms.internal.measurement.zzuo.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public abstract class zzuo<MessageType extends zzuo<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzsx<MessageType, BuilderType> {
    private static Map<Object, zzuo<?, ?>> zzbyf = new ConcurrentHashMap();
    protected zzxe zzbyd = zzxe.zzyl();
    private int zzbye = -1;

    /* loaded from: classes2.dex */
    public static class zzb<T extends zzuo<T, ?>> extends zzsz<T> {
        private final T zzbyg;

        public zzb(T t) {
            this.zzbyg = t;
        }

        @Override // com.google.android.gms.internal.measurement.zzwf
        public final /* synthetic */ Object zza(zztq zztqVar, zzub zzubVar) throws zzuv {
            return zzuo.zza(this.zzbyg, zztqVar, zzubVar);
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class zzc<MessageType extends zzc<MessageType, BuilderType>, BuilderType> extends zzuo<MessageType, BuilderType> implements zzvx {
        protected C1393ua<Object> zzbyj = C1393ua.g();
    }

    /* loaded from: classes2.dex */
    public static class zzd<ContainingType extends zzvv, Type> extends zztz<ContainingType, Type> {
    }

    /* loaded from: classes2.dex */
    public enum zze {
        public static final int zzbyk = 1;
        public static final int zzbyl = 2;
        public static final int zzbym = 3;
        public static final int zzbyn = 4;
        public static final int zzbyo = 5;
        public static final int zzbyp = 6;
        public static final int zzbyq = 7;
        private static final /* synthetic */ int[] zzbyr = {zzbyk, zzbyl, zzbym, zzbyn, zzbyo, zzbyp, zzbyq};
        public static final int zzbys = 1;
        public static final int zzbyt = 2;
        private static final /* synthetic */ int[] zzbyu = {zzbys, zzbyt};
        public static final int zzbyv = 1;
        public static final int zzbyw = 2;
        private static final /* synthetic */ int[] zzbyx = {zzbyv, zzbyw};

        public static int[] zzwp() {
            return (int[]) zzbyr.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzuo<?, ?>> void zza(Class<T> cls, T t) {
        zzbyf.put(cls, t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends zzuo<?, ?>> T zzg(Class<T> cls) {
        zzuo<?, ?> zzuoVar = zzbyf.get(cls);
        if (zzuoVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzuoVar = zzbyf.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (zzuoVar == null) {
            zzuoVar = (T) ((zzuo) xb.a(cls)).zza(zze.zzbyp, (Object) null, (Object) null);
            if (zzuoVar != null) {
                zzbyf.put(cls, zzuoVar);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) zzuoVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> zzuu<E> zzwg() {
        return _a.a();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (((zzuo) zza(zze.zzbyp, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return Za.a().a((Za) this).a(this, (zzuo<MessageType, BuilderType>) obj);
        }
        return false;
    }

    public int hashCode() {
        int i = this.zzbti;
        if (i != 0) {
            return i;
        }
        this.zzbti = Za.a().a((Za) this).a(this);
        return this.zzbti;
    }

    @Override // com.google.android.gms.internal.measurement.zzvx
    public final boolean isInitialized() {
        boolean booleanValue = Boolean.TRUE.booleanValue();
        byte byteValue = ((Byte) zza(zze.zzbyk, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean d2 = Za.a().a((Za) this).d(this);
        if (booleanValue) {
            zza(zze.zzbyl, d2 ? this : null, (Object) null);
        }
        return d2;
    }

    public String toString() {
        return Sa.a(this, super.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.measurement.zzsx
    final void zzai(int i) {
        this.zzbye = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzvv
    public final void zzb(zztv zztvVar) throws IOException {
        Za.a().a((Class) getClass()).a((InterfaceC1353cb) this, (Fb) C1382oa.a(zztvVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzsx
    final int zztx() {
        return this.zzbye;
    }

    @Override // com.google.android.gms.internal.measurement.zzvv
    public final int zzvx() {
        if (this.zzbye == -1) {
            this.zzbye = Za.a().a((Za) this).c(this);
        }
        return this.zzbye;
    }

    public final BuilderType zzwf() {
        BuilderType buildertype = (BuilderType) zza(zze.zzbyo, (Object) null, (Object) null);
        buildertype.zza(this);
        return buildertype;
    }

    @Override // com.google.android.gms.internal.measurement.zzvv
    public final /* synthetic */ zzvw zzwh() {
        zza zzaVar = (zza) zza(zze.zzbyo, (Object) null, (Object) null);
        zzaVar.zza((zza) this);
        return zzaVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzvv
    public final /* synthetic */ zzvw zzwi() {
        return (zza) zza(zze.zzbyo, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzvx
    public final /* synthetic */ zzvv zzwj() {
        return (zzuo) zza(zze.zzbyp, (Object) null, (Object) null);
    }

    /* loaded from: classes2.dex */
    public static abstract class zza<MessageType extends zzuo<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzsy<MessageType, BuilderType> {
        private final MessageType zzbyg;
        protected MessageType zzbyh;
        private boolean zzbyi = false;

        /* JADX INFO: Access modifiers changed from: protected */
        public zza(MessageType messagetype) {
            this.zzbyg = messagetype;
            this.zzbyh = (MessageType) messagetype.zza(zze.zzbyn, null, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.measurement.zzsy
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zzaVar = (zza) this.zzbyg.zza(zze.zzbyo, null, null);
            zzaVar.zza((zza) zzwn());
            return zzaVar;
        }

        @Override // com.google.android.gms.internal.measurement.zzvx
        public final boolean isInitialized() {
            return zzuo.zza(this.zzbyh, false);
        }

        @Override // com.google.android.gms.internal.measurement.zzsy
        public final BuilderType zza(MessageType messagetype) {
            zzwk();
            zza(this.zzbyh, messagetype);
            return this;
        }

        @Override // com.google.android.gms.internal.measurement.zzsy
        /* renamed from: zzty */
        public final /* synthetic */ zzsy clone() {
            return (zza) clone();
        }

        @Override // com.google.android.gms.internal.measurement.zzvx
        public final /* synthetic */ zzvv zzwj() {
            return this.zzbyg;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void zzwk() {
            if (this.zzbyi) {
                MessageType messagetype = (MessageType) this.zzbyh.zza(zze.zzbyn, null, null);
                zza(messagetype, this.zzbyh);
                this.zzbyh = messagetype;
                this.zzbyi = false;
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzvw
        /* renamed from: zzwl, reason: merged with bridge method [inline-methods] */
        public MessageType zzwn() {
            if (this.zzbyi) {
                return this.zzbyh;
            }
            MessageType messagetype = this.zzbyh;
            Za.a().a((Za) messagetype).b(messagetype);
            this.zzbyi = true;
            return this.zzbyh;
        }

        @Override // com.google.android.gms.internal.measurement.zzvw
        /* renamed from: zzwm, reason: merged with bridge method [inline-methods] */
        public final MessageType zzwo() {
            MessageType messagetype = (MessageType) zzwn();
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) messagetype.zza(zze.zzbyk, null, null)).byteValue();
            boolean z = true;
            if (byteValue != 1) {
                if (byteValue == 0) {
                    z = false;
                } else {
                    z = Za.a().a((Za) messagetype).d(messagetype);
                    if (booleanValue) {
                        messagetype.zza(zze.zzbyl, z ? messagetype : null, null);
                    }
                }
            }
            if (z) {
                return messagetype;
            }
            throw new zzxc(messagetype);
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            Za.a().a((Za) messagetype).b(messagetype, messagetype2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object zza(zzvv zzvvVar, String str, Object[] objArr) {
        return new C1347ab(zzvvVar, str, objArr);
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

    protected static final <T extends zzuo<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zze.zzbyk, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        return Za.a().a((Za) t).d(t);
    }

    static <T extends zzuo<T, ?>> T zza(T t, zztq zztqVar, zzub zzubVar) throws zzuv {
        T t2 = (T) t.zza(zze.zzbyn, null, null);
        try {
            Za.a().a((Za) t2).a(t2, C1378ma.a(zztqVar), zzubVar);
            Za.a().a((Za) t2).b(t2);
            return t2;
        } catch (IOException e2) {
            if (e2.getCause() instanceof zzuv) {
                throw ((zzuv) e2.getCause());
            }
            throw new zzuv(e2.getMessage()).zzg(t2);
        } catch (RuntimeException e3) {
            if (e3.getCause() instanceof zzuv) {
                throw ((zzuv) e3.getCause());
            }
            throw e3;
        }
    }
}
