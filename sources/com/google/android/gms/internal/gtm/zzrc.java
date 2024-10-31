package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;
import com.google.android.gms.internal.gtm.zzrc.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public abstract class zzrc<MessageType extends zzrc<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzpl<MessageType, BuilderType> {
    private static Map<Object, zzrc<?, ?>> zzbam = new ConcurrentHashMap();
    protected zzts zzbak = zzts.zzrj();
    private int zzbal = -1;

    /* loaded from: classes2.dex */
    public static class zzb<T extends zzrc<T, ?>> extends zzpn<T> {
        private final T zzban;

        public zzb(T t) {
            this.zzban = t;
        }

        @Override // com.google.android.gms.internal.gtm.zzsu
        public final /* synthetic */ Object zza(zzqe zzqeVar, zzqp zzqpVar) throws zzrk {
            return zzrc.zza(this.zzban, zzqeVar, zzqpVar);
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class zzc<MessageType extends zzc<MessageType, BuilderType>, BuilderType> extends zzrc<MessageType, BuilderType> implements zzsm {
        protected C1330sa<Object> zzbaq = C1330sa.f();
    }

    /* loaded from: classes2.dex */
    public static class zzd<ContainingType extends zzsk, Type> extends zzqn<ContainingType, Type> {
    }

    /* loaded from: classes2.dex */
    public enum zze {
        public static final int zzbar = 1;
        public static final int zzbas = 2;
        public static final int zzbat = 3;
        public static final int zzbau = 4;
        public static final int zzbav = 5;
        public static final int zzbaw = 6;
        public static final int zzbax = 7;
        private static final /* synthetic */ int[] zzbay = {zzbar, zzbas, zzbat, zzbau, zzbav, zzbaw, zzbax};
        public static final int zzbaz = 1;
        public static final int zzbba = 2;
        private static final /* synthetic */ int[] zzbbb = {zzbaz, zzbba};
        public static final int zzbbc = 1;
        public static final int zzbbd = 2;
        private static final /* synthetic */ int[] zzbbe = {zzbbc, zzbbd};

        public static int[] zzpn() {
            return (int[]) zzbay.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzrc<?, ?>> void zza(Class<T> cls, T t) {
        zzbam.put(cls, t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends zzrc<?, ?>> T zzg(Class<T> cls) {
        zzrc<?, ?> zzrcVar = zzbam.get(cls);
        if (zzrcVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzrcVar = zzbam.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (zzrcVar == null) {
            zzrcVar = (T) ((zzrc) ub.a(cls)).zza(zze.zzbaw, (Object) null, (Object) null);
            if (zzrcVar != null) {
                zzbam.put(cls, zzrcVar);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) zzrcVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.gtm.ya, com.google.android.gms.internal.gtm.zzri] */
    public static zzri zzpf() {
        return C1342ya.a();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (((zzrc) zza(zze.zzbaw, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return Xa.a().a((Xa) this).a(this, (zzrc<MessageType, BuilderType>) obj);
        }
        return false;
    }

    public int hashCode() {
        int i = this.zzavp;
        if (i != 0) {
            return i;
        }
        this.zzavp = Xa.a().a((Xa) this).a(this);
        return this.zzavp;
    }

    @Override // com.google.android.gms.internal.gtm.zzsm
    public final boolean isInitialized() {
        return zza(this, Boolean.TRUE.booleanValue());
    }

    public String toString() {
        return Qa.a(this, super.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.gtm.zzpl
    final void zzag(int i) {
        this.zzbal = i;
    }

    @Override // com.google.android.gms.internal.gtm.zzsk
    public final void zzb(zzqj zzqjVar) throws IOException {
        Xa.a().a((Class) getClass()).a((_a) this, (Cb) C1319ma.a(zzqjVar));
    }

    protected final void zzmi() {
        Xa.a().a((Xa) this).e(this);
    }

    @Override // com.google.android.gms.internal.gtm.zzpl
    final int zzmw() {
        return this.zzbal;
    }

    public final BuilderType zzpd() {
        BuilderType buildertype = (BuilderType) zza(zze.zzbav, (Object) null, (Object) null);
        buildertype.zza(this);
        return buildertype;
    }

    @Override // com.google.android.gms.internal.gtm.zzsk
    public final int zzpe() {
        if (this.zzbal == -1) {
            this.zzbal = Xa.a().a((Xa) this).d(this);
        }
        return this.zzbal;
    }

    @Override // com.google.android.gms.internal.gtm.zzsk
    public final /* synthetic */ zzsl zzpg() {
        zza zzaVar = (zza) zza(zze.zzbav, (Object) null, (Object) null);
        zzaVar.zza((zza) this);
        return zzaVar;
    }

    @Override // com.google.android.gms.internal.gtm.zzsk
    public final /* synthetic */ zzsl zzph() {
        return (zza) zza(zze.zzbav, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.gtm.zzsm
    public final /* synthetic */ zzsk zzpi() {
        return (zzrc) zza(zze.zzbaw, (Object) null, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object zza(zzsk zzskVar, String str, Object[] objArr) {
        return new Ya(zzskVar, str, objArr);
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

    /* loaded from: classes2.dex */
    public static abstract class zza<MessageType extends zzrc<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzpm<MessageType, BuilderType> {
        private final MessageType zzban;
        private MessageType zzbao;
        private boolean zzbap = false;

        /* JADX INFO: Access modifiers changed from: protected */
        public zza(MessageType messagetype) {
            this.zzban = messagetype;
            this.zzbao = (MessageType) messagetype.zza(zze.zzbau, null, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.gtm.zzpm
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zzaVar = (zza) this.zzban.zza(zze.zzbav, null, null);
            zzaVar.zza((zza) zzpl());
            return zzaVar;
        }

        @Override // com.google.android.gms.internal.gtm.zzsm
        public final boolean isInitialized() {
            return zzrc.zza(this.zzbao, false);
        }

        @Override // com.google.android.gms.internal.gtm.zzpm
        public final BuilderType zza(MessageType messagetype) {
            if (this.zzbap) {
                MessageType messagetype2 = (MessageType) this.zzbao.zza(zze.zzbau, null, null);
                zza(messagetype2, this.zzbao);
                this.zzbao = messagetype2;
                this.zzbap = false;
            }
            zza(this.zzbao, messagetype);
            return this;
        }

        @Override // com.google.android.gms.internal.gtm.zzpm
        /* renamed from: zzmx */
        public final /* synthetic */ zzpm clone() {
            return (zza) clone();
        }

        @Override // com.google.android.gms.internal.gtm.zzsm
        public final /* synthetic */ zzsk zzpi() {
            return this.zzban;
        }

        @Override // com.google.android.gms.internal.gtm.zzsl
        /* renamed from: zzpj, reason: merged with bridge method [inline-methods] */
        public MessageType zzpl() {
            if (this.zzbap) {
                return this.zzbao;
            }
            this.zzbao.zzmi();
            this.zzbap = true;
            return this.zzbao;
        }

        @Override // com.google.android.gms.internal.gtm.zzsl
        /* renamed from: zzpk, reason: merged with bridge method [inline-methods] */
        public final MessageType zzpm() {
            MessageType messagetype = (MessageType) zzpl();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zztq(messagetype);
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            Xa.a().a((Xa) messagetype).b(messagetype, messagetype2);
        }
    }

    protected static final <T extends zzrc<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zze.zzbar, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean b2 = Xa.a().a((Xa) t).b(t);
        if (z) {
            t.zza(zze.zzbas, b2 ? t : null, null);
        }
        return b2;
    }

    static <T extends zzrc<T, ?>> T zza(T t, zzqe zzqeVar, zzqp zzqpVar) throws zzrk {
        T t2 = (T) t.zza(zze.zzbau, null, null);
        try {
            Xa.a().a((Xa) t2).a(t2, C1315ka.a(zzqeVar), zzqpVar);
            t2.zzmi();
            return t2;
        } catch (IOException e2) {
            if (e2.getCause() instanceof zzrk) {
                throw ((zzrk) e2.getCause());
            }
            throw new zzrk(e2.getMessage()).zzg(t2);
        } catch (RuntimeException e3) {
            if (e3.getCause() instanceof zzrk) {
                throw ((zzrk) e3.getCause());
            }
            throw e3;
        }
    }
}
