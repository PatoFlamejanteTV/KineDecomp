package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class AppInviteContent implements ShareModel {
    public static final Parcelable.Creator<AppInviteContent> CREATOR = new b();
    private final String applinkUrl;
    private final String previewImageUrl;

    /* synthetic */ AppInviteContent(Builder builder, b bVar) {
        this(builder);
    }

    private AppInviteContent(Builder builder) {
        this.applinkUrl = builder.applinkUrl;
        this.previewImageUrl = builder.previewImageUrl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppInviteContent(Parcel parcel) {
        this.applinkUrl = parcel.readString();
        this.previewImageUrl = parcel.readString();
    }

    public String getApplinkUrl() {
        return this.applinkUrl;
    }

    public String getPreviewImageUrl() {
        return this.previewImageUrl;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.applinkUrl);
        parcel.writeString(this.previewImageUrl);
    }

    /* loaded from: classes.dex */
    public static class Builder implements ShareModelBuilder<AppInviteContent, Builder> {
        private String applinkUrl;
        private String previewImageUrl;

        public Builder setApplinkUrl(String str) {
            this.applinkUrl = str;
            return this;
        }

        public Builder setPreviewImageUrl(String str) {
            this.previewImageUrl = str;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public AppInviteContent build() {
            return new AppInviteContent(this, null);
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(AppInviteContent appInviteContent) {
            return appInviteContent == null ? this : setApplinkUrl(appInviteContent.getApplinkUrl()).setPreviewImageUrl(appInviteContent.getPreviewImageUrl());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(Parcel parcel) {
            return readFrom((AppInviteContent) parcel.readParcelable(AppInviteContent.class.getClassLoader()));
        }
    }
}
