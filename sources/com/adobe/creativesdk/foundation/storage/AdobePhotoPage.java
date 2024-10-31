package com.adobe.creativesdk.foundation.storage;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/* loaded from: classes.dex */
public class AdobePhotoPage implements Externalizable {
    private String _key;

    @Deprecated
    public AdobePhotoPage(String str) {
        this._key = str;
    }

    public AdobePhotoPage getCopy() {
        return new AdobePhotoPage(this._key);
    }

    @Deprecated
    public String getKey() {
        return this._key;
    }

    public boolean isEqualToPage(AdobePhotoPage adobePhotoPage) {
        return adobePhotoPage.getKey().equals(this._key);
    }

    @Override // java.io.Externalizable
    @Deprecated
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this._key = (String) objectInput.readObject();
    }

    void setKey(String str) {
        this._key = str;
    }

    @Override // java.io.Externalizable
    @Deprecated
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(this._key);
    }

    protected AdobePhotoPage() {
    }
}
