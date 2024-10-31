package com.adobe.creativesdk.foundation.storage;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class AdobePhotoAssetRevision implements Externalizable {
    private String _GUID;

    public AdobePhotoAssetRevision() {
        this._GUID = null;
        this._GUID = c.a.a.a.c.e.b.a();
    }

    public static AdobePhotoAssetRevision create() {
        return new AdobePhotoAssetRevision();
    }

    public AdobePhotoAssetRevision getCopy() {
        return new AdobePhotoAssetRevision(this._GUID, true);
    }

    public String getGUID() {
        return this._GUID;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this._GUID = (String) objectInput.readObject();
    }

    public void setGUID(String str) {
        this._GUID = str;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(this._GUID);
    }

    public AdobePhotoAssetRevision(String str, boolean z) {
        this._GUID = null;
        if (z) {
            this._GUID = str;
            return;
        }
        Matcher matcher = Pattern.compile("/revisions/([a-zA-Z0-9]+)", 2).matcher(str);
        if (matcher.find()) {
            this._GUID = matcher.group(1);
        }
    }
}
