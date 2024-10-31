package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.MessageApi;

/* loaded from: classes.dex */
public final class zzaz implements MessageApi {

    /* loaded from: classes.dex */
    public static class zzb implements MessageApi.SendMessageResult {

        /* renamed from: a, reason: collision with root package name */
        private final Status f2387a;

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.f2387a;
        }
    }
}
