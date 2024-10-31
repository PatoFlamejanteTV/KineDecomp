package com.facebook.places.internal;

/* loaded from: classes.dex */
public class BluetoothScanResult {
    public String payload;
    public int rssi;
    public long timestampNanos;

    public BluetoothScanResult(String str, int i, long j) {
        this.payload = str;
        this.rssi = i;
        this.timestampNanos = j;
    }
}
