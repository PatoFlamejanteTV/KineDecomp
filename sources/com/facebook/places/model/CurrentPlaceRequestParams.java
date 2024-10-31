package com.facebook.places.model;

import android.location.Location;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class CurrentPlaceRequestParams {
    private final Set<String> fields;
    private final int limit;
    private final Location location;
    private final ConfidenceLevel minConfidenceLevel;
    private final ScanMode scanMode;

    /* loaded from: classes.dex */
    public static class Builder {
        private int limit;
        private Location location;
        private ConfidenceLevel minConfidenceLevel;
        private ScanMode scanMode = ScanMode.HIGH_ACCURACY;
        private final Set<String> fields = new HashSet();

        public Builder addField(String str) {
            this.fields.add(str);
            return this;
        }

        public CurrentPlaceRequestParams build() {
            return new CurrentPlaceRequestParams(this);
        }

        public Builder setLimit(int i) {
            this.limit = i;
            return this;
        }

        public Builder setLocation(Location location) {
            this.location = location;
            return this;
        }

        public Builder setMinConfidenceLevel(ConfidenceLevel confidenceLevel) {
            this.minConfidenceLevel = confidenceLevel;
            return this;
        }

        public Builder setScanMode(ScanMode scanMode) {
            this.scanMode = scanMode;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public enum ConfidenceLevel {
        LOW,
        MEDIUM,
        HIGH
    }

    /* loaded from: classes.dex */
    public enum ScanMode {
        HIGH_ACCURACY,
        LOW_LATENCY
    }

    /* synthetic */ CurrentPlaceRequestParams(Builder builder, b bVar) {
        this(builder);
    }

    public Set<String> getFields() {
        return this.fields;
    }

    public int getLimit() {
        return this.limit;
    }

    public Location getLocation() {
        return this.location;
    }

    public ConfidenceLevel getMinConfidenceLevel() {
        return this.minConfidenceLevel;
    }

    public ScanMode getScanMode() {
        return this.scanMode;
    }

    private CurrentPlaceRequestParams(Builder builder) {
        this.fields = new HashSet();
        this.location = builder.location;
        this.scanMode = builder.scanMode;
        this.minConfidenceLevel = builder.minConfidenceLevel;
        this.limit = builder.limit;
        this.fields.addAll(builder.fields);
    }
}
