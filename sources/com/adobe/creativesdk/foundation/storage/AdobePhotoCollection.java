package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.adobeinternal.analytics.AdobeAnalyticsEventParams;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloudServiceType;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.facebook.places.model.PlaceFields;
import com.facebook.share.internal.ShareConstants;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AdobePhotoCollection extends AdobePhoto implements Externalizable, com.adobe.creativesdk.foundation.internal.storage.controllers.upload.A<AdobePhotoCollection> {
    private AdobePhotoCatalog _catalog;
    private AdobePhotoAsset _coverAsset;
    private String _name;

    /* loaded from: classes.dex */
    public enum AdobePhotoCollectionFlag {
        ADOBE_PHOTO_COLLECTION_FLAG_REJECTED,
        ADOBE_PHOTO_COLLECTION_FLAG_UNFLAGGED,
        ADOBE_PHOTO_COLLECTION_FLAG_PICKED,
        ADOBE_PHOTO_COLLECTION_FLAG_ALL
    }

    /* loaded from: classes.dex */
    public enum AdobePhotoCollectionSort {
        ADOBE_PHOTO_COLLECTION_SORT_BY_DATE,
        ADOBE_PHOTO_COLLECTION_SORT_BY_CUSTOM_ORDER
    }

    @Deprecated
    public AdobePhotoCollection() {
    }

    public static AdobePhotoCollection create(String str, AdobePhotoCatalog adobePhotoCatalog, c.a.a.a.b<AdobePhotoCollection> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        if (c.a.a.a.a.a.a.b().b(new ed(cVar), "Create requires an authenticated user.")) {
            return null;
        }
        if (adobePhotoCatalog == null) {
            cVar.a(new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_UNEXPECTED_RESPONSE));
            return null;
        }
        AdobePhotoCollection adobePhotoCollection = new AdobePhotoCollection(str, null, adobePhotoCatalog);
        com.adobe.creativesdk.foundation.internal.storage.photo.F f2 = (com.adobe.creativesdk.foundation.internal.storage.photo.F) adobePhotoCatalog.getCloud().getSessionForService(AdobeCloudServiceType.AdobeCloudServiceTypePhoto);
        if (f2 == null) {
            return null;
        }
        com.adobe.creativesdk.foundation.internal.analytics.l lVar = new com.adobe.creativesdk.foundation.internal.analytics.l(AdobeAnalyticsEventParams.Type.AdobeEventTypeAppCreate.getValue());
        lVar.a(adobePhotoCollection.getCloud());
        f2.a(adobePhotoCollection, adobePhotoCatalog, new id(bVar, lVar), new jd(cVar, str, lVar, adobePhotoCollection));
        return adobePhotoCollection;
    }

    public void addAsset(AdobePhotoAsset adobePhotoAsset, c.a.a.a.b<AdobePhotoAsset> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        ArrayList<AdobePhotoAsset> arrayList = new ArrayList<>();
        arrayList.add(adobePhotoAsset);
        addAssets(arrayList, new Vc(this, bVar), cVar);
    }

    public void addAssets(ArrayList<AdobePhotoAsset> arrayList, c.a.a.a.b<ArrayList<AdobePhotoAsset>> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        if (getSession() == null) {
            return;
        }
        getSession().a(arrayList, this, new Wc(this, bVar), new Xc(this, cVar, this));
    }

    public void assetCount(c.a.a.a.b<Integer> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        if (getSession() == null) {
            return;
        }
        getSession().b(this, new gd(this, bVar), new hd(this, cVar));
    }

    public void delete(vd vdVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        if (getSession() == null) {
            return;
        }
        getSession().a(this, new od(this, vdVar), new pd(this, cVar, this));
    }

    public AdobePhotoCatalog getCatalog() {
        return this._catalog;
    }

    public AdobePhotoAsset getCoverAsset() {
        return this._coverAsset;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.upload.A
    @Deprecated
    public String getId() {
        AdobePhotoCatalog adobePhotoCatalog;
        if (this._GUID == null && ((adobePhotoCatalog = this._catalog) == null || adobePhotoCatalog.getGUID() == null)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String str = this._GUID;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        sb.append(str);
        AdobePhotoCatalog adobePhotoCatalog2 = this._catalog;
        if (adobePhotoCatalog2 != null && adobePhotoCatalog2.getGUID() != null) {
            str2 = this._catalog.getGUID();
        }
        sb.append(str2);
        return sb.toString();
    }

    public String getName() {
        return this._name;
    }

    public boolean isEqualToCollection(AdobePhotoCollection adobePhotoCollection) {
        return adobePhotoCollection != null && getGUID().equals(adobePhotoCollection.getGUID()) && getCatalog().isEqualToCatalog(adobePhotoCollection.getCatalog());
    }

    public void listAssetsOnPage(AdobePhotoPage adobePhotoPage, AdobePhotoCollectionSort adobePhotoCollectionSort, int i, AdobePhotoCollectionFlag adobePhotoCollectionFlag, td tdVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        if (getSession() == null) {
            return;
        }
        getSession().a(this, adobePhotoPage, adobePhotoCollectionSort, adobePhotoCollectionFlag, i, getCloud(), new dd(this, tdVar), new fd(this, cVar, this));
    }

    @Override // com.adobe.creativesdk.foundation.storage.AdobePhoto, java.io.Externalizable
    @Deprecated
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        super.readExternal(objectInput);
        this._name = (String) objectInput.readObject();
        this._catalog = (AdobePhotoCatalog) objectInput.readObject();
        this._coverAsset = (AdobePhotoAsset) objectInput.readObject();
    }

    public void refresh(c.a.a.a.b<AdobePhotoCollection> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        if (getSession() == null) {
            return;
        }
        getSession().c(this, new md(this, bVar), new nd(this, cVar, this));
    }

    public void removeAsset(AdobePhotoAsset adobePhotoAsset, c.a.a.a.b<AdobePhotoAsset> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        ArrayList<AdobePhotoAsset> arrayList = new ArrayList<>();
        arrayList.add(adobePhotoAsset);
        removeAssets(arrayList, new ad(this, bVar), cVar);
    }

    public void removeAssets(ArrayList<AdobePhotoAsset> arrayList, c.a.a.a.b<ArrayList<AdobePhotoAsset>> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        if (getSession() == null) {
            return;
        }
        getSession().b(arrayList, this, new bd(this, bVar), new cd(this, cVar, this));
    }

    public void setCoverAsset(AdobePhotoAsset adobePhotoAsset) {
        this._coverAsset = adobePhotoAsset;
    }

    public void setName(String str) {
        String str2 = this._name;
        if (str2 == null) {
            this._name = str;
        } else {
            if (str2.equals(str) || str.length() <= 0) {
                return;
            }
            this._name = str;
        }
    }

    public void update(c.a.a.a.b<AdobePhotoCollection> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        if (getSession() == null) {
            return;
        }
        getSession().d(this, new kd(this, bVar), new ld(this, cVar, this));
    }

    public void updateAsset(AdobePhotoAsset adobePhotoAsset, c.a.a.a.b<AdobePhotoAsset> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        ArrayList<AdobePhotoAsset> arrayList = new ArrayList<>();
        arrayList.add(adobePhotoAsset);
        updateAssets(arrayList, new Yc(this, bVar), cVar);
    }

    public void updateAssets(ArrayList<AdobePhotoAsset> arrayList, c.a.a.a.b<ArrayList<AdobePhotoAsset>> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        if (getSession() == null) {
            return;
        }
        getSession().c(arrayList, this, new Zc(this, bVar), new _c(this, cVar, this));
    }

    @Deprecated
    public boolean updateFromData(String str, AdobePhotoCatalog adobePhotoCatalog) throws AdobePhotoException {
        if (str == null || str.equals("")) {
            return true;
        }
        return updateFromDictionary(c.a.a.a.c.e.b.a(str), adobePhotoCatalog);
    }

    @Deprecated
    public boolean updateFromDictionary(JSONObject jSONObject, AdobePhotoCatalog adobePhotoCatalog) throws AdobePhotoException {
        String optString;
        Date date;
        if (jSONObject.optString("id", null) != null) {
            this._internalID = jSONObject.optString("id", null);
        }
        if (jSONObject.optString("_id", null) != null) {
            this._GUID = jSONObject.optString("_id", null);
        }
        if (jSONObject.optString("name", null) != null) {
            this._name = jSONObject.optString("name", null);
        }
        if (jSONObject.opt("created") != null) {
            this._creationDate = com.adobe.creativesdk.foundation.internal.storage.model.util.i.b(jSONObject.optString("created"));
        }
        if (jSONObject.opt("update") != null) {
            this._modificationDate = com.adobe.creativesdk.foundation.internal.storage.model.util.i.b(jSONObject.optString("updated"));
        }
        if (this._modificationDate == null && (date = this._creationDate) != null) {
            this._modificationDate = date;
        }
        this._catalog = adobePhotoCatalog;
        this._cloud = adobePhotoCatalog.getCloud();
        if (this._name != null) {
            if (this._creationDate == null) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, AdobePhotoCollection.class.getSimpleName(), "Collection " + this._name + " doesn't have a creation time.");
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(PlaceFields.COVER);
            if (optJSONObject != null && (optString = optJSONObject.optString("_id", null)) != null) {
                AdobePhotoAsset adobePhotoAsset = new AdobePhotoAsset(null, optString, adobePhotoCatalog);
                try {
                    adobePhotoAsset.updateFromDictionary(optJSONObject, adobePhotoCatalog);
                } catch (AdobePhotoException unused) {
                }
                this._coverAsset = adobePhotoAsset;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("links");
            if (optJSONObject2 != null) {
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("self");
                if (optJSONObject3 == null) {
                    return true;
                }
                this._href = optJSONObject3.optString(ShareConstants.WEB_DIALOG_PARAM_HREF, null);
                return true;
            }
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, AdobePhotoCollection.class.getSimpleName(), "Collection doesn't have an href.");
            this._href = null;
            return true;
        }
        throw new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_UNEXPECTED_RESPONSE, null, "Collection doesn't have a name");
    }

    @Override // com.adobe.creativesdk.foundation.storage.AdobePhoto, java.io.Externalizable
    @Deprecated
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        super.writeExternal(objectOutput);
        objectOutput.writeObject(this._name);
        objectOutput.writeObject(this._catalog);
        objectOutput.writeObject(this._coverAsset);
    }

    @Deprecated
    public AdobePhotoCollection(String str, String str2, AdobePhotoCatalog adobePhotoCatalog) {
        str2 = str2 == null ? c.a.a.a.c.e.b.a() : str2;
        this._GUID = str2;
        this._name = str;
        this._href = "/v1.0/catalogs/" + adobePhotoCatalog.getGUID() + "/albums/" + str2;
        this._catalog = adobePhotoCatalog;
        this._cloud = adobePhotoCatalog.getCloud();
    }

    @Override // com.adobe.creativesdk.foundation.storage.AdobePhoto
    public AdobePhotoCollection getCopy() {
        AdobePhotoCollection adobePhotoCollection = new AdobePhotoCollection(this._name, this._GUID, this._catalog);
        AdobePhotoAsset adobePhotoAsset = this._coverAsset;
        if (adobePhotoAsset != null) {
            adobePhotoCollection.setCoverAsset(adobePhotoAsset);
        }
        return adobePhotoCollection;
    }

    @Deprecated
    public boolean isSameLocation(AdobePhotoCollection adobePhotoCollection) {
        return isEqualToCollection(adobePhotoCollection);
    }
}
