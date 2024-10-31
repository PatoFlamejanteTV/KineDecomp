package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.DataApi;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class zzx implements DataApi {

    /* loaded from: classes.dex */
    public static class zza implements DataApi.DataItemResult {

        /* renamed from: a, reason: collision with root package name */
        private final Status f2401a;

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.f2401a;
        }
    }

    /* loaded from: classes.dex */
    public static class zzb implements DataApi.DeleteDataItemsResult {

        /* renamed from: a, reason: collision with root package name */
        private final Status f2402a;

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.f2402a;
        }
    }

    /* loaded from: classes.dex */
    public static class zzc implements DataApi.GetFdForAssetResult {

        /* renamed from: a, reason: collision with root package name */
        private final Status f2403a;
        private volatile ParcelFileDescriptor b;
        private volatile InputStream c;
        private volatile boolean d;

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.f2403a;
        }

        @Override // com.google.android.gms.common.api.Releasable
        public void release() {
            if (this.b == null) {
                return;
            }
            if (this.d) {
                throw new IllegalStateException("releasing an already released result.");
            }
            try {
                if (this.c != null) {
                    this.c.close();
                } else {
                    this.b.close();
                }
                this.d = true;
                this.b = null;
                this.c = null;
            } catch (IOException e) {
            }
        }
    }
}
