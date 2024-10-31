package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareMedia;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class SharePhoto extends ShareMedia {
    public static final Parcelable.Creator<SharePhoto> CREATOR = new h();
    private final Bitmap bitmap;
    private final String caption;
    private final Uri imageUrl;
    private final boolean userGenerated;

    /* synthetic */ SharePhoto(Builder builder, h hVar) {
        this(builder);
    }

    private SharePhoto(Builder builder) {
        super(builder);
        this.bitmap = builder.bitmap;
        this.imageUrl = builder.imageUrl;
        this.userGenerated = builder.userGenerated;
        this.caption = builder.caption;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SharePhoto(Parcel parcel) {
        super(parcel);
        this.bitmap = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.imageUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.userGenerated = parcel.readByte() != 0;
        this.caption = parcel.readString();
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public Uri getImageUrl() {
        return this.imageUrl;
    }

    public boolean getUserGenerated() {
        return this.userGenerated;
    }

    public String getCaption() {
        return this.caption;
    }

    @Override // com.facebook.share.model.ShareMedia, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.share.model.ShareMedia, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.bitmap, 0);
        parcel.writeParcelable(this.imageUrl, 0);
        parcel.writeByte((byte) (this.userGenerated ? 1 : 0));
        parcel.writeString(this.caption);
    }

    /* loaded from: classes.dex */
    public static final class Builder extends ShareMedia.Builder<SharePhoto, Builder> {
        private Bitmap bitmap;
        private String caption;
        private Uri imageUrl;
        private boolean userGenerated;

        public Builder setBitmap(Bitmap bitmap) {
            this.bitmap = bitmap;
            return this;
        }

        public Builder setImageUrl(Uri uri) {
            this.imageUrl = uri;
            return this;
        }

        public Builder setUserGenerated(boolean z) {
            this.userGenerated = z;
            return this;
        }

        public Builder setCaption(String str) {
            this.caption = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Uri getImageUrl() {
            return this.imageUrl;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Bitmap getBitmap() {
            return this.bitmap;
        }

        @Override // com.facebook.share.ShareBuilder
        public SharePhoto build() {
            return new SharePhoto(this, null);
        }

        @Override // com.facebook.share.model.ShareMedia.Builder, com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(SharePhoto sharePhoto) {
            return sharePhoto == null ? this : ((Builder) super.readFrom((Builder) sharePhoto)).setBitmap(sharePhoto.getBitmap()).setImageUrl(sharePhoto.getImageUrl()).setUserGenerated(sharePhoto.getUserGenerated()).setCaption(sharePhoto.getCaption());
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(Parcel parcel) {
            return readFrom((SharePhoto) parcel.readParcelable(SharePhoto.class.getClassLoader()));
        }

        public static void writeListTo(Parcel parcel, List<SharePhoto> list) {
            ArrayList arrayList = new ArrayList();
            Iterator<SharePhoto> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            parcel.writeTypedList(arrayList);
        }

        public static List<SharePhoto> readListFrom(Parcel parcel) {
            ArrayList arrayList = new ArrayList();
            parcel.readTypedList(arrayList, SharePhoto.CREATOR);
            return arrayList;
        }
    }
}
