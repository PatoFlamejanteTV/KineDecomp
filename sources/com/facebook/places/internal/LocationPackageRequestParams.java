package com.facebook.places.internal;

/* loaded from: classes.dex */
public class LocationPackageRequestParams {
    private static final boolean DEFAULT_BLUETOOTH_ENABLED = true;
    private static final long DEFAULT_BLUETOOTH_FLUSH_RESULTS_TIMEOUT_MS = 300;
    private static final int DEFAULT_BLUETOOTH_MAX_SCAN_RESULTS = 25;
    private static final long DEFAULT_BLUETOOTH_SCAN_DURATION_MS = 500;
    private static final long DEFAULT_LAST_LOCATION_MAX_AGE_MS = 60000;
    private static final boolean DEFAULT_LOCATION_ENABLED = true;
    private static final float DEFAULT_LOCATION_MAX_ACCURACY_METERS = 100.0f;
    private static final String[] DEFAULT_LOCATION_PROVIDERS = {"network", "gps"};
    private static final long DEFAULT_LOCATION_REQUEST_TIMEOUT_MS = 30000;
    private static final boolean DEFAULT_WIFI_ACTIVE_SCAN_ALLOWED = true;
    private static final boolean DEFAULT_WIFI_ACTIVE_SCAN_FORCED = false;
    private static final boolean DEFAULT_WIFI_ENABLED = true;
    private static final int DEFAULT_WIFI_MAX_SCAN_RESULTS = 25;
    private static final long DEFAULT_WIFI_SCAN_MAX_AGE_MS = 30000;
    private static final long DEFAULT_WIFI_SCAN_TIMEOUT_MS = 6000;
    private long bluetoothFlushResultsTimeoutMs;
    private int bluetoothMaxScanResults;
    private long bluetoothScanDurationMs;
    private boolean isBluetoothScanEnabled;
    private boolean isLocationScanEnabled;
    private boolean isWifiActiveScanAllowed;
    private boolean isWifiActiveScanForced;
    private boolean isWifiScanEnabled;
    private long lastLocationMaxAgeMs;
    private float locationMaxAccuracyMeters;
    private final String[] locationProviders;
    private long locationRequestTimeoutMs;
    private int wifiMaxScanResults;
    private long wifiScanMaxAgeMs;
    private long wifiScanTimeoutMs;

    /* loaded from: classes.dex */
    public static class Builder {
        private boolean isLocationScanEnabled = true;
        private String[] locationProviders = LocationPackageRequestParams.DEFAULT_LOCATION_PROVIDERS;
        private float locationMaxAccuracyMeters = LocationPackageRequestParams.DEFAULT_LOCATION_MAX_ACCURACY_METERS;
        private long locationRequestTimeoutMs = com.umeng.commonsdk.proguard.c.f26227d;
        private long lastLocationMaxAgeMs = LocationPackageRequestParams.DEFAULT_LAST_LOCATION_MAX_AGE_MS;
        private boolean isWifiScanEnabled = true;
        private long wifiScanMaxAgeMs = com.umeng.commonsdk.proguard.c.f26227d;
        private int wifiMaxScanResults = 25;
        private long wifiScanTimeoutMs = 6000;
        private boolean isWifiActiveScanAllowed = true;
        private boolean isWifiActiveScanForced = false;
        private boolean isBluetoothScanEnabled = true;
        private long bluetoothScanDurationMs = LocationPackageRequestParams.DEFAULT_BLUETOOTH_SCAN_DURATION_MS;
        private int bluetoothMaxScanResults = 25;
        private long bluetoothFlushResultsTimeoutMs = LocationPackageRequestParams.DEFAULT_BLUETOOTH_FLUSH_RESULTS_TIMEOUT_MS;

        public LocationPackageRequestParams build() {
            return new LocationPackageRequestParams(this);
        }

        public Builder setBluetoothFlushResultsTimeoutMs(long j) {
            this.bluetoothFlushResultsTimeoutMs = j;
            return this;
        }

        public Builder setBluetoothMaxScanResults(int i) {
            this.bluetoothMaxScanResults = i;
            return this;
        }

        public Builder setBluetoothScanDurationMs(long j) {
            this.bluetoothScanDurationMs = j;
            return this;
        }

        public Builder setBluetoothScanEnabled(boolean z) {
            this.isBluetoothScanEnabled = z;
            return this;
        }

        public Builder setLastLocationMaxAgeMs(long j) {
            this.lastLocationMaxAgeMs = j;
            return this;
        }

        public Builder setLocationMaxAccuracyMeters(float f2) {
            this.locationMaxAccuracyMeters = f2;
            return this;
        }

        public Builder setLocationProviders(String[] strArr) {
            this.locationProviders = strArr;
            return this;
        }

        public Builder setLocationRequestTimeoutMs(long j) {
            this.locationRequestTimeoutMs = j;
            return this;
        }

        public Builder setLocationScanEnabled(boolean z) {
            this.isLocationScanEnabled = z;
            return this;
        }

        public Builder setWifiActiveScanAllowed(boolean z) {
            this.isWifiActiveScanAllowed = z;
            return this;
        }

        public Builder setWifiActiveScanForced(boolean z) {
            this.isWifiActiveScanForced = z;
            return this;
        }

        public Builder setWifiMaxScanResults(int i) {
            this.wifiMaxScanResults = i;
            return this;
        }

        public Builder setWifiScanEnabled(boolean z) {
            this.isWifiScanEnabled = z;
            return this;
        }

        public Builder setWifiScanMaxAgeMs(long j) {
            this.wifiScanMaxAgeMs = j;
            return this;
        }

        public Builder setWifiScanTimeoutMs(long j) {
            this.wifiScanTimeoutMs = j;
            return this;
        }
    }

    /* synthetic */ LocationPackageRequestParams(Builder builder, g gVar) {
        this(builder);
    }

    public long getBluetoothFlushResultsTimeoutMs() {
        return this.bluetoothFlushResultsTimeoutMs;
    }

    public int getBluetoothMaxScanResults() {
        return this.bluetoothMaxScanResults;
    }

    public long getBluetoothScanDurationMs() {
        return this.bluetoothScanDurationMs;
    }

    public long getLastLocationMaxAgeMs() {
        return this.lastLocationMaxAgeMs;
    }

    public float getLocationMaxAccuracyMeters() {
        return this.locationMaxAccuracyMeters;
    }

    public String[] getLocationProviders() {
        return this.locationProviders;
    }

    public long getLocationRequestTimeoutMs() {
        return this.locationRequestTimeoutMs;
    }

    public int getWifiMaxScanResults() {
        return this.wifiMaxScanResults;
    }

    public long getWifiScanMaxAgeMs() {
        return this.wifiScanMaxAgeMs;
    }

    public long getWifiScanTimeoutMs() {
        return this.wifiScanTimeoutMs;
    }

    public boolean isBluetoothScanEnabled() {
        return this.isBluetoothScanEnabled;
    }

    public boolean isLocationScanEnabled() {
        return this.isLocationScanEnabled;
    }

    public boolean isWifiActiveScanAllowed() {
        return this.isWifiActiveScanAllowed;
    }

    public boolean isWifiActiveScanForced() {
        return this.isWifiActiveScanForced;
    }

    public boolean isWifiScanEnabled() {
        return this.isWifiScanEnabled;
    }

    private LocationPackageRequestParams(Builder builder) {
        this.isLocationScanEnabled = builder.isLocationScanEnabled;
        this.locationProviders = builder.locationProviders;
        this.locationMaxAccuracyMeters = builder.locationMaxAccuracyMeters;
        this.locationRequestTimeoutMs = builder.locationRequestTimeoutMs;
        this.lastLocationMaxAgeMs = builder.lastLocationMaxAgeMs;
        this.isWifiScanEnabled = builder.isWifiScanEnabled;
        this.wifiScanMaxAgeMs = builder.wifiScanMaxAgeMs;
        this.wifiMaxScanResults = builder.wifiMaxScanResults;
        this.wifiScanTimeoutMs = builder.wifiScanTimeoutMs;
        this.isWifiActiveScanAllowed = builder.isWifiActiveScanAllowed;
        this.isWifiActiveScanForced = builder.isWifiActiveScanForced;
        this.isBluetoothScanEnabled = builder.isBluetoothScanEnabled;
        this.bluetoothScanDurationMs = builder.bluetoothScanDurationMs;
        this.bluetoothMaxScanResults = builder.bluetoothMaxScanResults;
        this.bluetoothFlushResultsTimeoutMs = builder.bluetoothFlushResultsTimeoutMs;
    }
}
