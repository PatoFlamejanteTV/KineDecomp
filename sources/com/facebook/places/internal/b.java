package com.facebook.places.internal;

import java.util.Comparator;

/* compiled from: BleScannerImpl.java */
/* loaded from: classes.dex */
class b implements Comparator<BluetoothScanResult> {

    /* renamed from: a */
    final /* synthetic */ BleScannerImpl f9460a;

    public b(BleScannerImpl bleScannerImpl) {
        this.f9460a = bleScannerImpl;
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(BluetoothScanResult bluetoothScanResult, BluetoothScanResult bluetoothScanResult2) {
        return bluetoothScanResult2.rssi - bluetoothScanResult.rssi;
    }
}
