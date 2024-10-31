package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.server.response.SafeParcelResponse;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.model.moments.MomentEntity;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import com.google.android.gms.plus.internal.zzd;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

/* loaded from: classes.dex */
public class zze extends zzj<zzd> {

    /* renamed from: a */
    private Person f2177a;
    private final PlusSession b;

    /* loaded from: classes.dex */
    public static final class a implements Moments.LoadMomentsResult {

        /* renamed from: a */
        private final Status f2178a;
        private final String b;
        private final String c;
        private final MomentBuffer d;

        public a(Status status, DataHolder dataHolder, String str, String str2) {
            this.f2178a = status;
            this.b = str;
            this.c = str2;
            this.d = dataHolder != null ? new MomentBuffer(dataHolder) : null;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.f2178a;
        }

        @Override // com.google.android.gms.common.api.Releasable
        public void release() {
            if (this.d != null) {
                this.d.release();
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements People.LoadPeopleResult {

        /* renamed from: a */
        private final Status f2179a;
        private final String b;
        private final PersonBuffer c;

        public b(Status status, DataHolder dataHolder, String str) {
            this.f2179a = status;
            this.b = str;
            this.c = dataHolder != null ? new PersonBuffer(dataHolder) : null;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.f2179a;
        }

        @Override // com.google.android.gms.common.api.Releasable
        public void release() {
            if (this.c != null) {
                this.c.release();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c extends zza {

        /* renamed from: a */
        private final zzlb.zzb<Status> f2180a;

        public c(zzlb.zzb<Status> zzbVar) {
            this.f2180a = zzbVar;
        }

        @Override // com.google.android.gms.plus.internal.zza, com.google.android.gms.plus.internal.zzb
        public void a(Status status) {
            this.f2180a.zzp(status);
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends zza {

        /* renamed from: a */
        private final zzlb.zzb<Moments.LoadMomentsResult> f2181a;

        public d(zzlb.zzb<Moments.LoadMomentsResult> zzbVar) {
            this.f2181a = zzbVar;
        }

        @Override // com.google.android.gms.plus.internal.zza, com.google.android.gms.plus.internal.zzb
        public void a(DataHolder dataHolder, String str, String str2) {
            Status status = new Status(dataHolder.e(), null, dataHolder.f() != null ? (PendingIntent) dataHolder.f().getParcelable("pendingIntent") : null);
            if (!status.d() && dataHolder != null) {
                if (!dataHolder.h()) {
                    dataHolder.i();
                }
                dataHolder = null;
            }
            this.f2181a.zzp(new a(status, dataHolder, str, str2));
        }
    }

    /* loaded from: classes.dex */
    public static final class e extends zza {

        /* renamed from: a */
        private final zzlb.zzb<People.LoadPeopleResult> f2182a;

        public e(zzlb.zzb<People.LoadPeopleResult> zzbVar) {
            this.f2182a = zzbVar;
        }

        @Override // com.google.android.gms.plus.internal.zza, com.google.android.gms.plus.internal.zzb
        public void a(DataHolder dataHolder, String str) {
            Status status = new Status(dataHolder.e(), null, dataHolder.f() != null ? (PendingIntent) dataHolder.f().getParcelable("pendingIntent") : null);
            if (!status.d() && dataHolder != null) {
                if (!dataHolder.h()) {
                    dataHolder.i();
                }
                dataHolder = null;
            }
            this.f2182a.zzp(new b(status, dataHolder, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class f extends zza {

        /* renamed from: a */
        private final zzlb.zzb<Status> f2183a;

        public f(zzlb.zzb<Status> zzbVar) {
            this.f2183a = zzbVar;
        }

        @Override // com.google.android.gms.plus.internal.zza, com.google.android.gms.plus.internal.zzb
        public void a(int i, Bundle bundle) {
            this.f2183a.zzp(new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
        }
    }

    public zze(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, PlusSession plusSession, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 2, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.b = plusSession;
    }

    public static boolean a(Set<Scope> set) {
        if (set == null || set.isEmpty()) {
            return false;
        }
        return (set.size() == 1 && set.contains(new Scope("plus_one_placeholder_scope"))) ? false : true;
    }

    private Bundle d() {
        Bundle k = this.b.k();
        k.putStringArray("request_visible_actions", this.b.d());
        k.putString("auth_package", this.b.f());
        return k;
    }

    public zzq a(zzlb.zzb<People.LoadPeopleResult> zzbVar, int i, String str) {
        zzpb();
        e eVar = new e(zzbVar);
        try {
            return zzpc().a(eVar, 1, i, -1, str);
        } catch (RemoteException e2) {
            eVar.a(DataHolder.b(8), (String) null);
            return null;
        }
    }

    public zzq a(zzlb.zzb<People.LoadPeopleResult> zzbVar, String str) {
        return a(zzbVar, 0, str);
    }

    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: a */
    public zzd zzW(IBinder iBinder) {
        return zzd.zza.a(iBinder);
    }

    public String a() {
        zzpb();
        try {
            return zzpc().a();
        } catch (RemoteException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public void a(zzlb.zzb<Moments.LoadMomentsResult> zzbVar) {
        a(zzbVar, 20, null, null, null, "me");
    }

    public void a(zzlb.zzb<Moments.LoadMomentsResult> zzbVar, int i, String str, Uri uri, String str2, String str3) {
        zzpb();
        d dVar = zzbVar != null ? new d(zzbVar) : null;
        try {
            zzpc().a(dVar, i, str, uri, str2, str3);
        } catch (RemoteException e2) {
            dVar.a(DataHolder.b(8), (String) null, (String) null);
        }
    }

    public void a(zzlb.zzb<Status> zzbVar, Moment moment) {
        zzpb();
        c cVar = zzbVar != null ? new c(zzbVar) : null;
        try {
            zzpc().a(cVar, SafeParcelResponse.a((MomentEntity) moment));
        } catch (RemoteException e2) {
            if (cVar == null) {
                throw new IllegalStateException(e2);
            }
            cVar.a(new Status(8, null, null));
        }
    }

    public void a(zzlb.zzb<People.LoadPeopleResult> zzbVar, Collection<String> collection) {
        zzpb();
        e eVar = new e(zzbVar);
        try {
            zzpc().a(eVar, new ArrayList(collection));
        } catch (RemoteException e2) {
            eVar.a(DataHolder.b(8), (String) null);
        }
    }

    public void a(zzlb.zzb<People.LoadPeopleResult> zzbVar, String[] strArr) {
        a(zzbVar, Arrays.asList(strArr));
    }

    public void a(String str) {
        zzpb();
        try {
            zzpc().a(str);
        } catch (RemoteException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public Person b() {
        zzpb();
        return this.f2177a;
    }

    public void b(zzlb.zzb<People.LoadPeopleResult> zzbVar) {
        zzpb();
        e eVar = new e(zzbVar);
        try {
            zzpc().a(eVar, 2, 1, -1, null);
        } catch (RemoteException e2) {
            eVar.a(DataHolder.b(8), (String) null);
        }
    }

    public void c() {
        zzpb();
        try {
            this.f2177a = null;
            zzpc().b();
        } catch (RemoteException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public void c(zzlb.zzb<Status> zzbVar) {
        zzpb();
        c();
        f fVar = new f(zzbVar);
        try {
            zzpc().b(fVar);
        } catch (RemoteException e2) {
            fVar.a(8, (Bundle) null);
        }
    }

    @Override // com.google.android.gms.common.internal.zzj
    public void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (i == 0 && bundle != null && bundle.containsKey("loaded_person")) {
            this.f2177a = PersonEntity.a(bundle.getByteArray("loaded_person"));
        }
        super.zza(i, iBinder, bundle, i2);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfK() {
        return "com.google.android.gms.plus.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfL() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public boolean zzlN() {
        return a(zzpa().a(Plus.c));
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected Bundle zzly() {
        return d();
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected Bundle zzpd() {
        return d();
    }
}
