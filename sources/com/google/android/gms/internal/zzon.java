package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zzow;

/* loaded from: classes.dex */
public class zzon implements BleApi {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends zzow.zza {

        /* renamed from: a, reason: collision with root package name */
        private final zzlb.zzb<BleDevicesResult> f1788a;

        private a(zzlb.zzb<BleDevicesResult> zzbVar) {
            this.f1788a = zzbVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(zzlb.zzb zzbVar, gn gnVar) {
            this(zzbVar);
        }

        @Override // com.google.android.gms.internal.zzow
        public void zza(BleDevicesResult bleDevicesResult) {
            this.f1788a.zzp(bleDevicesResult);
        }
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient googleApiClient, BleDevice bleDevice) {
        return googleApiClient.zzb(new gq(this, googleApiClient, bleDevice));
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zzb(new gp(this, googleApiClient, str));
    }

    public PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient googleApiClient) {
        return googleApiClient.zza((GoogleApiClient) new gs(this, googleApiClient));
    }

    public PendingResult<Status> startBleScan(GoogleApiClient googleApiClient, StartBleScanRequest startBleScanRequest) {
        return googleApiClient.zza((GoogleApiClient) new gn(this, googleApiClient, startBleScanRequest));
    }

    public PendingResult<Status> stopBleScan(GoogleApiClient googleApiClient, BleScanCallback bleScanCallback) {
        return googleApiClient.zza((GoogleApiClient) new go(this, googleApiClient, bleScanCallback));
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient googleApiClient, BleDevice bleDevice) {
        return unclaimBleDevice(googleApiClient, bleDevice.a());
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zzb(new gr(this, googleApiClient, str));
    }
}
