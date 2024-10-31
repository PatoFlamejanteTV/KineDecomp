package com.google.android.gms.nearby.messages.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzmi;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.internal.zzd;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends zzj<zzd> {

    /* renamed from: a, reason: collision with root package name */
    private final String f2119a;
    private final String b;
    private final boolean c;
    private final AbstractC0042a<StatusCallback> d;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.android.gms.nearby.messages.internal.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0042a<C> {

        /* renamed from: a, reason: collision with root package name */
        private final zzmi<C, IBinder> f2120a;

        private AbstractC0042a() {
            this.f2120a = new zzmi<>(1);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ AbstractC0042a(b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, com.google.android.gms.common.internal.zzf zzfVar, MessagesOptions messagesOptions) {
        super(context, looper, 62, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.d = new b(this);
        this.b = zzfVar.h();
        if (messagesOptions != null) {
            this.f2119a = messagesOptions.f2098a;
            this.c = messagesOptions.b;
        } else {
            this.f2119a = null;
            this.c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public zzd zzW(IBinder iBinder) {
        return zzd.zza.a(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfK() {
        return "com.google.android.gms.nearby.messages.service.NearbyMessagesService.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfL() {
        return "com.google.android.gms.nearby.messages.internal.INearbyMessagesService";
    }
}
