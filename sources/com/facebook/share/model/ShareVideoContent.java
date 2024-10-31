package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.ShareVideo;

/* loaded from: classes.dex */
public final class ShareVideoContent extends ShareContent<ShareVideoContent, Builder> implements ShareModel {
    public static final Parcelable.Creator<ShareVideoContent> CREATOR = new k();
    private final String contentDescription;
    private final String contentTitle;
    private final SharePhoto previewPhoto;
    private final ShareVideo video;

    /* synthetic */ ShareVideoContent(Builder builder, k kVar) {
        this(builder);
    }

    private ShareVideoContent(Builder builder) {
        super(builder);
        this.contentDescription = builder.contentDescription;
        this.contentTitle = builder.contentTitle;
        this.previewPhoto = builder.previewPhoto;
        this.video = builder.video;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShareVideoContent(Parcel parcel) {
        super(parcel);
        this.contentDescription = parcel.readString();
        this.contentTitle = parcel.readString();
        SharePhoto.Builder readFrom = new SharePhoto.Builder().readFrom(parcel);
        if (readFrom.getImageUrl() != null || readFrom.getBitmap() != null) {
            this.previewPhoto = readFrom.build();
        } else {
            this.previewPhoto = null;
        }
        this.video = new ShareVideo.Builder().readFrom(parcel).build();
    }

    public String getContentDescription() {
        return this.contentDescription;
    }

    public String getContentTitle() {
        return this.contentTitle;
    }

    public SharePhoto getPreviewPhoto() {
        return this.previewPhoto;
    }

    public ShareVideo getVideo() {
        return this.video;
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
        parcel.writeParcelable(this.previewPhoto, 0);
        parcel.writeParcelable(this.video, 0);
    }

    /* loaded from: classes.dex */
    public static final class Builder extends ShareContent.Builder<ShareVideoContent, Builder> {
        private String contentDescription;
        private String contentTitle;
        private SharePhoto previewPhoto;
        private ShareVideo video;

        public Builder setContentDescription(String str) {
            this.contentDescription = str;
            return this;
        }

        public Builder setContentTitle(String str) {
            this.contentTitle = str;
            return this;
        }

        public Builder setPreviewPhoto(SharePhoto sharePhoto) {
            this.previewPhoto = sharePhoto == null ? null : new SharePhoto.Builder().readFrom(sharePhoto).build();
            return this;
        }

        public Builder setVideo(ShareVideo shareVideo) {
            if (shareVideo != null) {
                this.video = new ShareVideo.Builder().readFrom(shareVideo).build();
            }
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ShareVideoContent build() {
            return new ShareVideoContent(this, null);
        }

        @Override // com.facebook.share.model.ShareContent.Builder, com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(ShareVideoContent shareVideoContent) {
            return shareVideoContent == null ? this : ((Builder) super.readFrom((Builder) shareVideoContent)).setContentDescription(shareVideoContent.getContentDescription()).setContentTitle(shareVideoContent.getContentTitle()).setPreviewPhoto(shareVideoContent.getPreviewPhoto()).setVideo(shareVideoContent.getVideo());
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(Parcel parcel) {
            return readFrom((ShareVideoContent) parcel.readParcelable(ShareVideoContent.class.getClassLoader()));
        }
    }
}
