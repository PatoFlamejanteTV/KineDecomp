package com.facebook.places.internal;

import android.net.wifi.ScanResult;
import java.util.Comparator;

/* compiled from: WifiScannerImpl.java */
/* loaded from: classes.dex */
class h implements Comparator<ScanResult> {
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(ScanResult scanResult, ScanResult scanResult2) {
        return scanResult2.level - scanResult.level;
    }
}
