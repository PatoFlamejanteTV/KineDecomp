package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;

/* loaded from: classes.dex */
public class zzov implements BleApi {
    private static final Status zzarV = new Status(5007);

    public PendingResult<Status> claimBleDevice(GoogleApiClient googleApiClient, BleDevice bleDevice) {
        return PendingResults.a(zzarV, googleApiClient);
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient googleApiClient, String str) {
        return PendingResults.a(zzarV, googleApiClient);
    }

    public PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient googleApiClient) {
        return PendingResults.a(BleDevicesResult.a(zzarV), googleApiClient);
    }

    public PendingResult<Status> startBleScan(GoogleApiClient googleApiClient, StartBleScanRequest startBleScanRequest) {
        return PendingResults.a(zzarV, googleApiClient);
    }

    public PendingResult<Status> stopBleScan(GoogleApiClient googleApiClient, BleScanCallback bleScanCallback) {
        return PendingResults.a(zzarV, googleApiClient);
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient googleApiClient, BleDevice bleDevice) {
        return PendingResults.a(zzarV, googleApiClient);
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient googleApiClient, String str) {
        return PendingResults.a(zzarV, googleApiClient);
    }
}
