package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloudServiceType;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

/* loaded from: classes.dex */
public class AdobePhoto implements Externalizable {
    protected String _internalID = null;
    protected String _GUID = null;
    protected String _href = null;
    protected String _baseHref = null;
    protected Date _creationDate = null;
    protected Date _modificationDate = null;
    protected AdobeCloud _cloud = null;

    public String getBaseHref() {
        return this._baseHref;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AdobeCloud getCloud() {
        return this._cloud;
    }

    public AdobePhoto getCopy() {
        AdobePhoto adobePhoto = new AdobePhoto();
        adobePhoto._internalID = this._internalID;
        adobePhoto._GUID = this._GUID;
        adobePhoto._href = this._href;
        adobePhoto._baseHref = this._baseHref;
        adobePhoto._creationDate = this._creationDate;
        adobePhoto._modificationDate = this._modificationDate;
        adobePhoto._cloud = this._cloud;
        return adobePhoto;
    }

    public Date getCreationDate() {
        return new Date(this._creationDate.getTime());
    }

    public String getGUID() {
        return this._GUID;
    }

    public String getHref() {
        return this._href;
    }

    public String getInternalID() {
        return this._internalID;
    }

    public Date getModificationDate() {
        return new Date(this._modificationDate.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.adobe.creativesdk.foundation.internal.storage.photo.F getSession() {
        return (com.adobe.creativesdk.foundation.internal.storage.photo.F) this._cloud.getSessionForService(AdobeCloudServiceType.AdobeCloudServiceTypePhoto);
    }

    public boolean isEqualToPhoto(AdobePhoto adobePhoto) {
        return this._GUID.equals(adobePhoto._GUID);
    }

    @Override // java.io.Externalizable
    @Deprecated
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this._internalID = (String) objectInput.readObject();
        this._GUID = (String) objectInput.readObject();
        this._href = (String) objectInput.readObject();
        this._baseHref = (String) objectInput.readObject();
        this._creationDate = (Date) objectInput.readObject();
        this._modificationDate = (Date) objectInput.readObject();
        this._cloud = (AdobeCloud) objectInput.readObject();
    }

    public void setBaseHref(String str) {
        this._baseHref = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setCloud(AdobeCloud adobeCloud) {
        this._cloud = adobeCloud;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setCreationDate(Date date) {
        this._creationDate = date;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setGUID(String str) {
        this._GUID = str;
    }

    public void setHref(String str) {
        this._href = str;
    }

    protected void setInternalID(String str) {
        this._internalID = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setModificationDate(Date date) {
        this._modificationDate = date;
    }

    @Override // java.io.Externalizable
    @Deprecated
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(this._internalID);
        objectOutput.writeObject(this._GUID);
        objectOutput.writeObject(this._href);
        objectOutput.writeObject(this._baseHref);
        objectOutput.writeObject(this._creationDate);
        objectOutput.writeObject(this._modificationDate);
        objectOutput.writeObject(this._cloud);
    }
}
