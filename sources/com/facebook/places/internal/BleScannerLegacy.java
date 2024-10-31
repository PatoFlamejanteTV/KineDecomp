package com.facebook.places.internal;

import com.facebook.places.internal.ScannerException;
import java.util.List;

/* loaded from: classes.dex */
public class BleScannerLegacy implements BleScanner {
    @Override // com.facebook.places.internal.BleScanner
    public int getErrorCode() {
        return -1;
    }

    @Override // com.facebook.places.internal.BleScanner
    public List<BluetoothScanResult> getScanResults() {
        return null;
    }

    @Override // com.facebook.places.internal.BleScanner
    public void initAndCheckEligibility() throws ScannerException {
        throw new ScannerException(ScannerException.Type.NOT_SUPPORTED);
    }

    @Override // com.facebook.places.internal.BleScanner
    public void startScanning() throws ScannerException {
        throw new ScannerException(ScannerException.Type.NOT_SUPPORTED);
    }

    @Override // com.facebook.places.internal.BleScanner
    public void stopScanning() throws ScannerException {
        throw new ScannerException(ScannerException.Type.NOT_SUPPORTED);
    }
}
