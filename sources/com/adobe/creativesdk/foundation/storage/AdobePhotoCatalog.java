package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloudServiceType;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.facebook.share.internal.ShareConstants;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AdobePhotoCatalog extends AdobePhoto implements Externalizable {
    private boolean _inSync;
    private String _name;
    private boolean _shared;
    private AdobePhotoCatalogType _type;

    /* loaded from: classes.dex */
    public enum AdobePhotoCatalogType {
        AdobePhotoCatalogTypeLightroom
    }

    public AdobePhotoCatalog() {
    }

    protected static AdobePhotoCatalog create(String str, AdobePhotoCatalogType adobePhotoCatalogType, AdobeCloud adobeCloud, c.a.a.a.b<AdobePhotoCatalog> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        AdobePhotoCatalog adobePhotoCatalog = new AdobePhotoCatalog(str, null, adobeCloud);
        com.adobe.creativesdk.foundation.internal.storage.photo.F f2 = (com.adobe.creativesdk.foundation.internal.storage.photo.F) adobeCloud.getSessionForService(AdobeCloudServiceType.AdobeCloudServiceTypePhoto);
        if (f2 == null) {
            return null;
        }
        f2.a(adobePhotoCatalog, adobePhotoCatalogType, new Ic(bVar), new Jc(cVar, str));
        return adobePhotoCatalog;
    }

    public static void listCatalogOfType(AdobePhotoCatalogType adobePhotoCatalogType, c.a.a.a.b<ArrayList<AdobePhotoCatalog>> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        listCatalogOfType(adobePhotoCatalogType, com.adobe.creativesdk.foundation.adobeinternal.cloud.d.e().c(), bVar, cVar);
    }

    public void assetCount(c.a.a.a.b<Integer> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        if (getSession() == null) {
            return;
        }
        getSession().b(this, new Gc(this, bVar), new Hc(this, cVar));
    }

    public void collectionCount(c.a.a.a.b<Integer> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        if (getSession() == null) {
            return;
        }
        getSession().d(this, new Uc(this, bVar), new Fc(this, cVar));
    }

    public void delete(vd vdVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        if (getSession() == null) {
            return;
        }
        getSession().a(this, new Qc(this, vdVar), new Rc(this, cVar, this));
    }

    public String getName() {
        return this._name;
    }

    public AdobePhotoCatalogType getType() {
        return this._type;
    }

    public boolean isEqualToCatalog(AdobePhotoCatalog adobePhotoCatalog) {
        if (this._GUID == null && adobePhotoCatalog.getGUID() == null) {
            return true;
        }
        if (this._GUID == null || adobePhotoCatalog.getGUID() == null) {
            return false;
        }
        return this._GUID.equals(adobePhotoCatalog.getGUID());
    }

    public boolean isInSync() {
        return this._inSync;
    }

    public boolean isShared() {
        return this._shared;
    }

    public void listCollectionsAfterName(String str, int i, boolean z, c.a.a.a.b<ArrayList<AdobePhotoCollection>> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        if (getSession() == null) {
            return;
        }
        getSession().a(this, getCloud(), new Sc(this, bVar), new Tc(this, cVar, this));
    }

    @Override // com.adobe.creativesdk.foundation.storage.AdobePhoto, java.io.Externalizable
    @Deprecated
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        super.readExternal(objectInput);
        this._name = (String) objectInput.readObject();
        this._inSync = objectInput.readBoolean();
    }

    public void refresh(c.a.a.a.b<AdobePhotoCatalog> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        if (getSession() == null) {
            return;
        }
        getSession().c(this, new Oc(this, bVar), new Pc(this, cVar, this));
    }

    void setInSync(boolean z) {
        this._inSync = z;
    }

    public void setName(String str) {
        if (str == null || this._name.equals(str) || str.length() <= 0) {
            return;
        }
        this._name = str;
    }

    void setShared(boolean z) {
        this._shared = z;
    }

    void setType(AdobePhotoCatalogType adobePhotoCatalogType) {
        this._type = adobePhotoCatalogType;
    }

    public void update(c.a.a.a.b<AdobePhotoCatalog> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        if (getSession() == null) {
            return;
        }
        getSession().e(this, new Mc(this, bVar), new Nc(this, cVar, this));
    }

    @Deprecated
    public boolean updateFromData(String str) throws AdobePhotoException {
        this._inSync = true;
        if (str == null || str.equals("")) {
            return true;
        }
        JSONObject a2 = c.a.a.a.c.e.b.a(str);
        if (a2 != null) {
            return updateFromDictionary(a2);
        }
        throw new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_UNEXPECTED_RESPONSE, null, "Parsed catalog data is not of type dictionary.");
    }

    @Deprecated
    public boolean updateFromDictionary(JSONObject jSONObject) throws AdobePhotoException {
        Date date;
        this._inSync = true;
        if (jSONObject.optString("id", null) != null) {
            this._internalID = jSONObject.optString("id", null);
        }
        if (jSONObject.optString("_id", null) != null) {
            this._GUID = jSONObject.optString("_id", null);
        }
        if (jSONObject.optString("name", null) != null) {
            try {
                this._name = URLDecoder.decode(jSONObject.optString("name", null), "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        if (jSONObject.opt("created") != null) {
            this._creationDate = com.adobe.creativesdk.foundation.internal.storage.model.util.i.b(jSONObject.optString("created"));
        }
        if (jSONObject.opt("updated") != null) {
            this._modificationDate = com.adobe.creativesdk.foundation.internal.storage.model.util.i.b(jSONObject.optString("updated"));
        }
        if (this._modificationDate == null && (date = this._creationDate) != null) {
            this._modificationDate = date;
        }
        if (jSONObject.optString("subtype", null) != null && jSONObject.optString("subtype", null).equals("lightroom")) {
            this._type = AdobePhotoCatalogType.AdobePhotoCatalogTypeLightroom;
        }
        if (this._name != null) {
            if (this._creationDate == null) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, AdobePhotoCatalog.class.getSimpleName(), "Catalog " + this._name + " doesn't have a creation time.");
            }
            if (jSONObject.optString("sharing", null) == null) {
                this._shared = false;
            } else {
                this._shared = true;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("links");
            if (optJSONObject != null) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("self");
                if (optJSONObject2 != null) {
                    this._href = optJSONObject2.optString(ShareConstants.WEB_DIALOG_PARAM_HREF, null);
                }
            } else {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, AdobePhotoCatalog.class.getSimpleName(), "Catalog doesn't have an href.");
                this._href = null;
            }
            return true;
        }
        throw new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_UNEXPECTED_RESPONSE, null, "Catalog doesn't have a name");
    }

    @Override // com.adobe.creativesdk.foundation.storage.AdobePhoto, java.io.Externalizable
    @Deprecated
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        super.writeExternal(objectOutput);
        objectOutput.writeObject(this._name);
        objectOutput.writeBoolean(this._inSync);
    }

    @Deprecated
    public AdobePhotoCatalog(String str, String str2, AdobeCloud adobeCloud) {
        str2 = str2 == null ? c.a.a.a.c.e.b.a() : str2;
        this._GUID = str2;
        this._name = str;
        this._href = String.format("/v1.0/catalogs/%s", str2);
        this._inSync = false;
        this._cloud = adobeCloud;
    }

    @Deprecated
    public static void listCatalogOfType(AdobePhotoCatalogType adobePhotoCatalogType, AdobeCloud adobeCloud, c.a.a.a.b<ArrayList<AdobePhotoCatalog>> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        com.adobe.creativesdk.foundation.internal.storage.photo.F f2 = (com.adobe.creativesdk.foundation.internal.storage.photo.F) adobeCloud.getSessionForService(AdobeCloudServiceType.AdobeCloudServiceTypePhoto);
        if (f2 == null) {
            return;
        }
        f2.a(adobePhotoCatalogType, adobeCloud, new Kc(bVar), new Lc(cVar));
    }

    @Override // com.adobe.creativesdk.foundation.storage.AdobePhoto
    public AdobePhotoCatalog getCopy() {
        return new AdobePhotoCatalog(this._name, this._GUID, this._cloud);
    }

    @Deprecated
    public AdobePhotoCatalog(String str, String str2, AdobeCloud adobeCloud, AdobePhotoCatalogType adobePhotoCatalogType) {
        this(str, str2, adobeCloud);
        this._type = adobePhotoCatalogType;
    }
}
