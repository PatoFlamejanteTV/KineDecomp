package com.facebook.places.model;

import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class PlaceInfoRequestParams {
    private final Set<String> fields;
    private final String placeId;

    /* loaded from: classes.dex */
    public static class Builder {
        private final Set<String> fields = new HashSet();
        private String placeId;

        public Builder addField(String str) {
            this.fields.add(str);
            return this;
        }

        public Builder addFields(String[] strArr) {
            for (String str : strArr) {
                this.fields.add(str);
            }
            return this;
        }

        public PlaceInfoRequestParams build() {
            return new PlaceInfoRequestParams(this);
        }

        public Builder setPlaceId(String str) {
            this.placeId = str;
            return this;
        }
    }

    /* synthetic */ PlaceInfoRequestParams(Builder builder, c cVar) {
        this(builder);
    }

    public Set<String> getFields() {
        return this.fields;
    }

    public String getPlaceId() {
        return this.placeId;
    }

    private PlaceInfoRequestParams(Builder builder) {
        this.fields = new HashSet();
        this.placeId = builder.placeId;
        this.fields.addAll(builder.fields);
    }
}
