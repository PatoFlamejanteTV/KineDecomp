package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;
import java.util.Collection;

/* loaded from: classes.dex */
public final class zzqi implements People {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class a extends Plus.zza<People.LoadPeopleResult> {
        private a(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(GoogleApiClient googleApiClient, io ioVar) {
            this(googleApiClient);
        }

        @Override // com.google.android.gms.internal.zzlc
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public People.LoadPeopleResult zzb(Status status) {
            return new it(this, status);
        }
    }

    public Person getCurrentPerson(GoogleApiClient googleApiClient) {
        return Plus.a(googleApiClient, true).b();
    }

    public PendingResult<People.LoadPeopleResult> load(GoogleApiClient googleApiClient, Collection<String> collection) {
        return googleApiClient.zza((GoogleApiClient) new ir(this, googleApiClient, collection));
    }

    public PendingResult<People.LoadPeopleResult> load(GoogleApiClient googleApiClient, String... strArr) {
        return googleApiClient.zza((GoogleApiClient) new is(this, googleApiClient, strArr));
    }

    public PendingResult<People.LoadPeopleResult> loadConnected(GoogleApiClient googleApiClient) {
        return googleApiClient.zza((GoogleApiClient) new iq(this, googleApiClient));
    }

    public PendingResult<People.LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, int i, String str) {
        return googleApiClient.zza((GoogleApiClient) new io(this, googleApiClient, i, str));
    }

    public PendingResult<People.LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zza((GoogleApiClient) new ip(this, googleApiClient, str));
    }
}
