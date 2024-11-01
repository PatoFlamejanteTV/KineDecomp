package com.tencent.mm.sdk.modelmsg;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import java.io.ByteArrayOutputStream;

/* loaded from: classes.dex */
public final class WXMediaMessage {
    public static final String ACTION_WXAPPMESSAGE = "com.tencent.mm.sdk.openapi.Intent.ACTION_WXAPPMESSAGE";
    private static final int DESCRIPTION_LENGTH_LIMIT = 1024;
    private static final int MEDIA_TAG_NAME_LENGTH_LIMIT = 64;
    private static final String TAG = "MicroMsg.SDK.WXMediaMessage";
    private static final int THUMB_LENGTH_LIMIT = 32768;
    private static final int TITLE_LENGTH_LIMIT = 512;
    public String description;
    public IMediaObject mediaObject;
    public String mediaTagName;
    public int sdkVer;
    public byte[] thumbData;
    public String title;

    /* loaded from: classes.dex */
    public static class Builder {
        public static final String KEY_IDENTIFIER = "_wxobject_identifier_";

        public static WXMediaMessage fromBundle(Bundle bundle) {
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.sdkVer = bundle.getInt("_wxobject_sdkVer");
            wXMediaMessage.title = bundle.getString("_wxobject_title");
            wXMediaMessage.description = bundle.getString("_wxobject_description");
            wXMediaMessage.thumbData = bundle.getByteArray("_wxobject_thumbdata");
            wXMediaMessage.mediaTagName = bundle.getString("_wxobject_mediatagname");
            String pathOldToNew = pathOldToNew(bundle.getString(KEY_IDENTIFIER));
            if (pathOldToNew == null || pathOldToNew.length() <= 0) {
                return wXMediaMessage;
            }
            try {
                wXMediaMessage.mediaObject = (IMediaObject) Class.forName(pathOldToNew).newInstance();
                wXMediaMessage.mediaObject.unserialize(bundle);
                return wXMediaMessage;
            } catch (Exception e) {
                e.printStackTrace();
                a.a(WXMediaMessage.TAG, "get media object from bundle failed: unknown ident " + pathOldToNew + ", ex = " + e.getMessage());
                return wXMediaMessage;
            }
        }

        private static String pathNewToOld(String str) {
            if (str != null && str.length() != 0) {
                return str.replace("com.tencent.mm.sdk.modelmsg", "com.tencent.mm.sdk.openapi");
            }
            a.a(WXMediaMessage.TAG, "pathNewToOld fail, newPath is null");
            return str;
        }

        private static String pathOldToNew(String str) {
            if (str != null && str.length() != 0) {
                return str.replace("com.tencent.mm.sdk.openapi", "com.tencent.mm.sdk.modelmsg");
            }
            a.a(WXMediaMessage.TAG, "pathOldToNew fail, oldPath is null");
            return str;
        }

        public static Bundle toBundle(WXMediaMessage wXMediaMessage) {
            Bundle bundle = new Bundle();
            bundle.putInt("_wxobject_sdkVer", wXMediaMessage.sdkVer);
            bundle.putString("_wxobject_title", wXMediaMessage.title);
            bundle.putString("_wxobject_description", wXMediaMessage.description);
            bundle.putByteArray("_wxobject_thumbdata", wXMediaMessage.thumbData);
            if (wXMediaMessage.mediaObject != null) {
                bundle.putString(KEY_IDENTIFIER, pathNewToOld(wXMediaMessage.mediaObject.getClass().getName()));
                wXMediaMessage.mediaObject.serialize(bundle);
            }
            bundle.putString("_wxobject_mediatagname", wXMediaMessage.mediaTagName);
            return bundle;
        }
    }

    /* loaded from: classes.dex */
    public interface IMediaObject {
        public static final int TYPE_APPDATA = 7;
        public static final int TYPE_EMOJI = 8;
        public static final int TYPE_FILE = 6;
        public static final int TYPE_IMAGE = 2;
        public static final int TYPE_MUSIC = 3;
        public static final int TYPE_PRODUCT = 10;
        public static final int TYPE_TEXT = 1;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_URL = 5;
        public static final int TYPE_VIDEO = 4;

        boolean checkArgs();

        void serialize(Bundle bundle);

        int type();

        void unserialize(Bundle bundle);
    }

    public WXMediaMessage() {
        this(null);
    }

    public WXMediaMessage(IMediaObject iMediaObject) {
        this.mediaObject = iMediaObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean checkArgs() {
        if (getType() == 8 && (this.thumbData == null || this.thumbData.length == 0)) {
            a.a(TAG, "checkArgs fail, thumbData should not be null when send emoji");
            return false;
        }
        if (this.thumbData != null && this.thumbData.length > THUMB_LENGTH_LIMIT) {
            a.a(TAG, "checkArgs fail, thumbData is invalid");
            return false;
        }
        if (this.title != null && this.title.length() > TITLE_LENGTH_LIMIT) {
            a.a(TAG, "checkArgs fail, title is invalid");
            return false;
        }
        if (this.description != null && this.description.length() > DESCRIPTION_LENGTH_LIMIT) {
            a.a(TAG, "checkArgs fail, description is invalid");
            return false;
        }
        if (this.mediaObject == null) {
            a.a(TAG, "checkArgs fail, mediaObject is null");
            return false;
        }
        if (this.mediaTagName == null || this.mediaTagName.length() <= 64) {
            return this.mediaObject.checkArgs();
        }
        a.a(TAG, "checkArgs fail, mediaTagName is too long");
        return false;
    }

    public final int getType() {
        if (this.mediaObject == null) {
            return 0;
        }
        return this.mediaObject.type();
    }

    public final void setThumbImage(Bitmap bitmap) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.thumbData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            a.a(TAG, "put thumb failed");
        }
    }
}
