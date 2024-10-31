package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;
import com.google.android.gms.internal.ads.zzbrd.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public abstract class zzbrd<MessageType extends zzbrd<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzbpl<MessageType, BuilderType> {
    private static Map<Object, zzbrd<?, ?>> zzfpw = new ConcurrentHashMap();
    protected zzbtv zzfpu = zzbtv.zzaoz();
    private int zzfpv = -1;

    /* loaded from: classes2.dex */
    public static class zzb<T extends zzbrd<T, ?>> extends zzbpn<T> {
        private final T zzfpx;

        public zzb(T t) {
            this.zzfpx = t;
        }

        @Override // com.google.android.gms.internal.ads.zzbsw
        public final /* synthetic */ Object zza(zzbqf zzbqfVar, zzbqq zzbqqVar) throws zzbrl {
            return zzbrd.zza(this.zzfpx, zzbqfVar, zzbqqVar);
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class zzc<MessageType extends zzc<MessageType, BuilderType>, BuilderType> extends zzbrd<MessageType, BuilderType> implements zzbsn {
        protected Mh<Object> zzfqa = Mh.g();
    }

    /* loaded from: classes2.dex */
    public static class zzd<ContainingType extends zzbsl, Type> extends zzbqo<ContainingType, Type> {
    }

    /* loaded from: classes2.dex */
    public enum zze {
        public static final int zzfqb = 1;
        public static final int zzfqc = 2;
        public static final int zzfqd = 3;
        public static final int zzfqe = 4;
        public static final int zzfqf = 5;
        public static final int zzfqg = 6;
        public static final int zzfqh = 7;
        private static final /* synthetic */ int[] zzfqi = {zzfqb, zzfqc, zzfqd, zzfqe, zzfqf, zzfqg, zzfqh};
        public static final int zzfqj = 1;
        public static final int zzfqk = 2;
        private static final /* synthetic */ int[] zzfql = {zzfqj, zzfqk};
        public static final int zzfqm = 1;
        public static final int zzfqn = 2;
        private static final /* synthetic */ int[] zzfqo = {zzfqm, zzfqn};

        public static int[] values$50KLMJ33DTMIUPRFDTJMOP9FE1P6UT3FC9QMCBQ7CLN6ASJ1EHIM8JB5EDPM2PR59HKN8P949LIN8Q3FCHA6UIBEEPNMMP9R0() {
            return (int[]) zzfqi.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzbrd<?, ?>> void zza(Class<T> cls, T t) {
        zzfpw.put(cls, t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.ads.Sh, com.google.android.gms.internal.ads.zzbrj] */
    public static zzbrj zzamr() {
        return Sh.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> zzbrk<E> zzams() {
        return C1070ri.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends zzbrd<?, ?>> T zzd(Class<T> cls) {
        T t = (T) zzfpw.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (T) zzfpw.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (t != null) {
            return t;
        }
        String valueOf = String.valueOf(cls.getName());
        throw new IllegalStateException(valueOf.length() != 0 ? "Unable to get default instance for: ".concat(valueOf) : new String("Unable to get default instance for: "));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (((zzbrd) zza(zze.zzfqg, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return C1057qi.a().a((C1057qi) this).a(this, (zzbrd<MessageType, BuilderType>) obj);
        }
        return false;
    }

    public int hashCode() {
        int i = this.zzfkx;
        if (i != 0) {
            return i;
        }
        this.zzfkx = C1057qi.a().a((C1057qi) this).a(this);
        return this.zzfkx;
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final boolean isInitialized() {
        boolean booleanValue = Boolean.TRUE.booleanValue();
        byte byteValue = ((Byte) zza(zze.zzfqb, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean b2 = C1057qi.a().a((C1057qi) this).b(this);
        if (booleanValue) {
            zza(zze.zzfqc, b2 ? this : null, (Object) null);
        }
        return b2;
    }

    public String toString() {
        return C0959ji.a(this, super.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.ads.zzbpl
    final int zzakg() {
        return this.zzfpv;
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final int zzamj() {
        if (this.zzfpv == -1) {
            this.zzfpv = C1057qi.a().a((C1057qi) this).c(this);
        }
        return this.zzfpv;
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final /* synthetic */ zzbsm zzamt() {
        zza zzaVar = (zza) zza(zze.zzfqf, (Object) null, (Object) null);
        zzaVar.zza((zza) this);
        return zzaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final /* synthetic */ zzbsm zzamu() {
        return (zza) zza(zze.zzfqf, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final /* synthetic */ zzbsl zzamv() {
        return (zzbrd) zza(zze.zzfqg, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void zzb(zzbqk zzbqkVar) throws IOException {
        C1057qi.a().a((Class) getClass()).a((InterfaceC1112ui) this, (Xi) Gh.a(zzbqkVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbpl
    final void zzei(int i) {
        this.zzfpv = i;
    }

    /* loaded from: classes2.dex */
    public static abstract class zza<MessageType extends zzbrd<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzbpm<MessageType, BuilderType> {
        private final MessageType zzfpx;
        protected MessageType zzfpy;
        private boolean zzfpz = false;

        /* JADX INFO: Access modifiers changed from: protected */
        public zza(MessageType messagetype) {
            this.zzfpx = messagetype;
            this.zzfpy = (MessageType) messagetype.zza(zze.zzfqe, null, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.ads.zzbpm
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zzaVar = (zza) this.zzfpx.zza(zze.zzfqf, null, null);
            zzaVar.zza((zza) zzamz());
            return zzaVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbsn
        public final boolean isInitialized() {
            return zzbrd.zza(this.zzfpy, false);
        }

        @Override // com.google.android.gms.internal.ads.zzbpm
        public final BuilderType zza(MessageType messagetype) {
            zzamw();
            zza(this.zzfpy, messagetype);
            return this;
        }

        @Override // com.google.android.gms.internal.ads.zzbpm
        /* renamed from: zzakh */
        public final /* synthetic */ zzbpm clone() {
            return (zza) clone();
        }

        @Override // com.google.android.gms.internal.ads.zzbsn
        public final /* synthetic */ zzbsl zzamv() {
            return this.zzfpx;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void zzamw() {
            if (this.zzfpz) {
                MessageType messagetype = (MessageType) this.zzfpy.zza(zze.zzfqe, null, null);
                zza(messagetype, this.zzfpy);
                this.zzfpy = messagetype;
                this.zzfpz = false;
            }
        }

        @Override // com.google.android.gms.internal.ads.zzbsm
        /* renamed from: zzamx, reason: merged with bridge method [inline-methods] */
        public MessageType zzamz() {
            if (this.zzfpz) {
                return this.zzfpy;
            }
            MessageType messagetype = this.zzfpy;
            C1057qi.a().a((C1057qi) messagetype).d(messagetype);
            this.zzfpz = true;
            return this.zzfpy;
        }

        @Override // com.google.android.gms.internal.ads.zzbsm
        /* renamed from: zzamy, reason: merged with bridge method [inline-methods] */
        public final MessageType zzana() {
            MessageType messagetype = (MessageType) zzamz();
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) messagetype.zza(zze.zzfqb, null, null)).byteValue();
            boolean z = true;
            if (byteValue != 1) {
                if (byteValue == 0) {
                    z = false;
                } else {
                    z = C1057qi.a().a((C1057qi) messagetype).b(messagetype);
                    if (booleanValue) {
                        messagetype.zza(zze.zzfqc, z ? messagetype : null, null);
                    }
                }
            }
            if (z) {
                return messagetype;
            }
            throw new zzbtt(messagetype);
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            C1057qi.a().a((C1057qi) messagetype).b(messagetype, messagetype2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object zza(zzbsl zzbslVar, String str, Object[] objArr) {
        return new C1084si(zzbslVar, str, objArr);
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

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzbrd<T, ?>> T zzb(T t, byte[] bArr) throws zzbrl {
        T t2 = (T) zza(t, bArr);
        if (t2 != null) {
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) t2.zza(zze.zzfqb, null, null)).byteValue();
            boolean z = true;
            if (byteValue != 1) {
                if (byteValue == 0) {
                    z = false;
                } else {
                    z = C1057qi.a().a((C1057qi) t2).b(t2);
                    if (booleanValue) {
                        t2.zza(zze.zzfqc, z ? t2 : null, null);
                    }
                }
            }
            if (!z) {
                throw new zzbtt(t2).zzaox().zzj(t2);
            }
        }
        return t2;
    }

    protected static final <T extends zzbrd<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zze.zzfqb, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        return C1057qi.a().a((C1057qi) t).b(t);
    }

    static <T extends zzbrd<T, ?>> T zza(T t, zzbqf zzbqfVar, zzbqq zzbqqVar) throws zzbrl {
        T t2 = (T) t.zza(zze.zzfqe, null, null);
        try {
            C1057qi.a().a((C1057qi) t2).a(t2, Eh.a(zzbqfVar), zzbqqVar);
            C1057qi.a().a((C1057qi) t2).d(t2);
            return t2;
        } catch (IOException e2) {
            if (e2.getCause() instanceof zzbrl) {
                throw ((zzbrl) e2.getCause());
            }
            throw new zzbrl(e2.getMessage()).zzj(t2);
        } catch (RuntimeException e3) {
            if (e3.getCause() instanceof zzbrl) {
                throw ((zzbrl) e3.getCause());
            }
            throw e3;
        }
    }

    private static <T extends zzbrd<T, ?>> T zza(T t, byte[] bArr) throws zzbrl {
        T t2 = (T) t.zza(zze.zzfqe, null, null);
        try {
            C1057qi.a().a((C1057qi) t2).a(t2, bArr, 0, bArr.length, new C1111uh());
            C1057qi.a().a((C1057qi) t2).d(t2);
            if (t2.zzfkx == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e2) {
            if (e2.getCause() instanceof zzbrl) {
                throw ((zzbrl) e2.getCause());
            }
            throw new zzbrl(e2.getMessage()).zzj(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzbrl.zzanc().zzj(t2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzbrd<T, ?>> T zza(T t, zzbpu zzbpuVar) throws zzbrl {
        boolean b2;
        T t2 = (T) zza(t, zzbpuVar, zzbqq.zzamd());
        boolean z = false;
        if (t2 != null) {
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) t2.zza(zze.zzfqb, null, null)).byteValue();
            if (byteValue == 1) {
                b2 = true;
            } else if (byteValue == 0) {
                b2 = false;
            } else {
                b2 = C1057qi.a().a((C1057qi) t2).b(t2);
                if (booleanValue) {
                    t2.zza(zze.zzfqc, b2 ? t2 : null, null);
                }
            }
            if (!b2) {
                throw new zzbtt(t2).zzaox().zzj(t2);
            }
        }
        if (t2 != null) {
            boolean booleanValue2 = Boolean.TRUE.booleanValue();
            byte byteValue2 = ((Byte) t2.zza(zze.zzfqb, null, null)).byteValue();
            if (byteValue2 == 1) {
                z = true;
            } else if (byteValue2 != 0) {
                z = C1057qi.a().a((C1057qi) t2).b(t2);
                if (booleanValue2) {
                    t2.zza(zze.zzfqc, z ? t2 : null, null);
                }
            }
            if (!z) {
                throw new zzbtt(t2).zzaox().zzj(t2);
            }
        }
        return t2;
    }

    private static <T extends zzbrd<T, ?>> T zza(T t, zzbpu zzbpuVar, zzbqq zzbqqVar) throws zzbrl {
        try {
            zzbqf zzakp = zzbpuVar.zzakp();
            T t2 = (T) zza(t, zzakp, zzbqqVar);
            try {
                zzakp.zzeo(0);
                return t2;
            } catch (zzbrl e2) {
                throw e2.zzj(t2);
            }
        } catch (zzbrl e3) {
            throw e3;
        }
    }
}
