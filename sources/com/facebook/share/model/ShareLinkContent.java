package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;

/* loaded from: classes.dex */
public final class ShareLinkContent extends ShareContent<ShareLinkContent, Builder> {
    public static final Parcelable.Creator<ShareLinkContent> CREATOR = new d();
    private final String contentDescription;
    private final String contentTitle;
    private final Uri imageUrl;

    /* synthetic */ ShareLinkContent(Builder builder, d dVar) {
        this(builder);
    }

    private ShareLinkContent(Builder builder) {
        super(builder);
        this.contentDescription = builder.contentDescription;
        this.contentTitle = builder.contentTitle;
        this.imageUrl = builder.imageUrl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShareLinkContent(Parcel parcel) {
        super(parcel);
        this.contentDescription = parcel.readString();
        this.contentTitle = parcel.readString();
        this.imageUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
    }

    public String getContentDescription() {
        return this.contentDescription;
    }

    public String getContentTitle() {
        return this.contentTitle;
    }

    public Uri getImageUrl() {
        return this.imageUrl;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.contentDescription);
        parcel.writeString(this.contentTitle);
        parcel.writeParcelable(this.imageUrl, 0);
    }

    /* loaded from: classes.dex */
    public static final class Builder extends ShareContent.Builder<ShareLinkContent, Builder> {
        private String contentDescription;
        private String contentTitle;
        private Uri imageUrl;

        public Builder setContentDescription(String str) {
            this.contentDescription = str;
            return this;
        }

        public Builder setContentTitle(String str) {
            this.contentTitle = str;
            return this;
        }

        public Builder setImageUrl(Uri uri) {
            this.imageUrl = uri;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ShareLinkContent build() {
            return new ShareLinkContent(this, null);
        }

        @Override // com.facebook.share.model.ShareContent.Builder, com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(ShareLinkContent shareLinkContent) {
            return shareLinkContent == null ? this : ((Builder) super.readFrom((Builder) shareLinkContent)).setContentDescription(shareLinkContent.getContentDescription()).setImageUrl(shareLinkContent.getImageUrl()).setContentTitle(shareLinkContent.getContentTitle());
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(Parcel parcel) {
            return readFrom((ShareLinkContent) parcel.readParcelable(ShareLinkContent.class.getClassLoader()));
        }
    }
}
