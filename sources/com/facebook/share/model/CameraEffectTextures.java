package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.Utility;
import java.util.Set;

/* loaded from: classes.dex */
public class CameraEffectTextures implements ShareModel {
    public static final Parcelable.Creator<CameraEffectTextures> CREATOR = new d();
    private final Bundle textures;

    /* loaded from: classes.dex */
    public static class Builder implements ShareModelBuilder<CameraEffectTextures, Builder> {
        private Bundle textures = new Bundle();

        private Builder putParcelableTexture(String str, Parcelable parcelable) {
            if (!Utility.isNullOrEmpty(str) && parcelable != null) {
                this.textures.putParcelable(str, parcelable);
            }
            return this;
        }

        public Builder putTexture(String str, Bitmap bitmap) {
            putParcelableTexture(str, bitmap);
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public CameraEffectTextures build() {
            return new CameraEffectTextures(this, null);
        }

        public Builder putTexture(String str, Uri uri) {
            putParcelableTexture(str, uri);
            return this;
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(CameraEffectTextures cameraEffectTextures) {
            if (cameraEffectTextures != null) {
                this.textures.putAll(cameraEffectTextures.textures);
            }
            return this;
        }

        public Builder readFrom(Parcel parcel) {
            return readFrom((CameraEffectTextures) parcel.readParcelable(CameraEffectTextures.class.getClassLoader()));
        }
    }

    /* synthetic */ CameraEffectTextures(Builder builder, d dVar) {
        this(builder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Object get(String str) {
        return this.textures.get(str);
    }

    public Bitmap getTextureBitmap(String str) {
        Object obj = this.textures.get(str);
        if (obj instanceof Bitmap) {
            return (Bitmap) obj;
        }
        return null;
    }

    public Uri getTextureUri(String str) {
        Object obj = this.textures.get(str);
        if (obj instanceof Uri) {
            return (Uri) obj;
        }
        return null;
    }

    public Set<String> keySet() {
        return this.textures.keySet();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.textures);
    }

    private CameraEffectTextures(Builder builder) {
        this.textures = builder.textures;
    }

    public CameraEffectTextures(Parcel parcel) {
        this.textures = parcel.readBundle(CameraEffectTextures.class.getClassLoader());
    }
}
