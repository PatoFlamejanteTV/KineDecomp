package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;
import com.google.protos.datapol.SemanticAnnotations;
import com.xiaomi.gamecenter.sdk.MiErrorCode;

/* loaded from: classes2.dex */
public final class zzuo {

    /* loaded from: classes2.dex */
    public static final class zza extends zzbrd<zza, C0074zza> implements zzbsn {
        private static final zza zzcar = new zza();
        private static volatile zzbsw<zza> zzcas;

        /* renamed from: com.google.android.gms.internal.ads.zzuo$zza$zza */
        /* loaded from: classes2.dex */
        public static final class C0074zza extends zzbrd.zza<zza, C0074zza> implements zzbsn {
            private C0074zza() {
                super(zza.zzcar);
            }

            /* synthetic */ C0074zza(Um um) {
                this();
            }
        }

        /* loaded from: classes2.dex */
        public enum zzb implements zzbrg {
            UNKNOWN_EVENT_TYPE(0),
            AD_REQUEST(1),
            AD_LOADED(2),
            AD_FAILED_TO_LOAD(3),
            AD_FAILED_TO_LOAD_NO_FILL(4),
            AD_IMPRESSION(5),
            AD_FIRST_CLICK(6),
            AD_SUBSEQUENT_CLICK(7),
            REQUEST_WILL_START(8),
            REQUEST_DID_END(9),
            REQUEST_WILL_UPDATE_SIGNALS(10),
            REQUEST_DID_UPDATE_SIGNALS(11),
            REQUEST_WILL_BUILD_URL(12),
            REQUEST_DID_BUILD_URL(13),
            REQUEST_WILL_MAKE_NETWORK_REQUEST(14),
            REQUEST_DID_RECEIVE_NETWORK_RESPONSE(15),
            REQUEST_WILL_PROCESS_RESPONSE(16),
            REQUEST_DID_PROCESS_RESPONSE(17),
            REQUEST_WILL_RENDER(18),
            REQUEST_DID_RENDER(19),
            REQUEST_WILL_UPDATE_GMS_SIGNALS(1000),
            REQUEST_DID_UPDATE_GMS_SIGNALS(1001),
            REQUEST_FAILED_TO_UPDATE_GMS_SIGNALS(1002),
            REQUEST_FAILED_TO_BUILD_URL(1003),
            REQUEST_FAILED_TO_MAKE_NETWORK_REQUEST(1004),
            REQUEST_FAILED_TO_PROCESS_RESPONSE(SemanticAnnotations.SemanticType.ST_MANDELBREAD_ID_VALUE),
            REQUEST_FAILED_TO_UPDATE_SIGNALS(1006),
            BANNER_SIZE_INVALID(io.fabric.sdk.android.services.common.a.DEFAULT_TIMEOUT),
            BANNER_SIZE_VALID(MiErrorCode.MI_XIAOMI_EXIT),
            ANDROID_WEBVIEW_CRASH(10002);

            private static final zzbrh<zzb> zzcbx = new Vm();
            private final int value;

            zzb(int i) {
                this.value = i;
            }

            @Override // com.google.android.gms.internal.ads.zzbrg
            public final int zzom() {
                return this.value;
            }
        }

        static {
            zzbrd.zza((Class<zza>) zza.class, zzcar);
        }

        private zza() {
        }

        @Override // com.google.android.gms.internal.ads.zzbrd
        public final Object zza(int i, Object obj, Object obj2) {
            switch (Um.f11896a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0074zza(null);
                case 3:
                    return zzbrd.zza(zzcar, "\u0001\u0000", (Object[]) null);
                case 4:
                    return zzcar;
                case 5:
                    zzbsw<zza> zzbswVar = zzcas;
                    if (zzbswVar == null) {
                        synchronized (zza.class) {
                            zzbswVar = zzcas;
                            if (zzbswVar == null) {
                                zzbswVar = new zzbrd.zzb<>(zzcar);
                                zzcas = zzbswVar;
                            }
                        }
                    }
                    return zzbswVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }
}
