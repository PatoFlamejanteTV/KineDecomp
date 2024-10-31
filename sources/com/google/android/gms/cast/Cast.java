package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.cast.internal.zze;
import com.google.android.gms.cast.internal.zzk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.io.IOException;

/* loaded from: classes.dex */
public final class Cast {
    private static final Api.zza<zze, CastOptions> c = new a();

    /* renamed from: a, reason: collision with root package name */
    public static final Api<CastOptions> f818a = new Api<>("Cast.API", c, zzk.f856a);
    public static final CastApi b = new CastApi.zza();

    /* loaded from: classes.dex */
    public interface ApplicationConnectionResult extends Result {
    }

    /* loaded from: classes.dex */
    public interface CastApi {

        /* loaded from: classes.dex */
        public static final class zza implements CastApi {
            @Override // com.google.android.gms.cast.Cast.CastApi
            public PendingResult<Status> a(GoogleApiClient googleApiClient, String str, String str2) {
                return googleApiClient.zzb(new b(this, googleApiClient, str, str2));
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public void a(GoogleApiClient googleApiClient, String str) throws IOException, IllegalArgumentException {
                try {
                    ((zze) googleApiClient.zza(zzk.f856a)).a(str);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public void a(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback) throws IOException, IllegalStateException {
                try {
                    ((zze) googleApiClient.zza(zzk.f856a)).a(str, messageReceivedCallback);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }
        }

        PendingResult<Status> a(GoogleApiClient googleApiClient, String str, String str2);

        void a(GoogleApiClient googleApiClient, String str) throws IOException, IllegalArgumentException;

        void a(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback) throws IOException, IllegalStateException;
    }

    /* loaded from: classes.dex */
    public static final class CastOptions implements Api.ApiOptions.HasOptions {

        /* renamed from: a, reason: collision with root package name */
        final CastDevice f819a;
        final Listener b;
        private final int c;

        /* loaded from: classes.dex */
        public static final class Builder {
        }
    }

    /* loaded from: classes.dex */
    public static class Listener {
        public void a() {
        }

        public void a(int i) {
        }

        public void a(ApplicationMetadata applicationMetadata) {
        }

        public void b() {
        }

        public void b(int i) {
        }

        public void c(int i) {
        }
    }

    /* loaded from: classes.dex */
    public interface MessageReceivedCallback {
        void a(CastDevice castDevice, String str, String str2);
    }

    private Cast() {
    }
}
