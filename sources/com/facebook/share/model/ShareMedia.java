package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class ShareMedia implements ShareModel {
    private final Bundle params;

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareMedia(Builder builder) {
        this.params = new Bundle(builder.params);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShareMedia(Parcel parcel) {
        this.params = parcel.readBundle();
    }

    @Deprecated
    public Bundle getParameters() {
        return new Bundle(this.params);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.params);
    }

    /* loaded from: classes.dex */
    public static abstract class Builder<M extends ShareMedia, B extends Builder> implements ShareModelBuilder<M, B> {
        private Bundle params = new Bundle();

        @Deprecated
        public B setParameter(String str, String str2) {
            this.params.putString(str, str2);
            return this;
        }

        @Deprecated
        public B setParameters(Bundle bundle) {
            this.params.putAll(bundle);
            return this;
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public B readFrom(M m) {
            return m == null ? this : setParameters(m.getParameters());
        }
    }
}
