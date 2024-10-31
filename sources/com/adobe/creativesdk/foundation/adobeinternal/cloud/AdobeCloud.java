package com.adobe.creativesdk.foundation.adobeinternal.cloud;

import android.support.v4.app.NotificationCompat;
import com.adobe.creativesdk.foundation.adobeinternal.imageservice.t;
import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIdentityManagementService;
import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.internal.storage.photo.F;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AdobeCloud implements Externalizable {
    public static final String ICON_URL = "iconUrl";
    public static final String PARSING_OF_INPUT_FAILED = "Parsing of input failed";
    public static final String STORAGE = "storage";
    private boolean available;
    private String cloudDescription;
    private String eTag;
    private Map<AdobeCloudServiceType, AdobeCloudEndpoint> endpoints;
    private String guid;
    private URL logoURL;
    private String name;
    private JSONObject parameters;
    private boolean privateCloud;
    private boolean quotaEnabled;
    private String region;
    private Map<AdobeCloudServiceType, g> sessions;
    private long version;

    public AdobeCloud() {
        this.quotaEnabled = true;
        this.endpoints = new HashMap();
        this.sessions = new HashMap();
        this.parameters = new JSONObject();
    }

    private String a(ArrayList<String> arrayList, JSONObject jSONObject) {
        boolean z;
        Iterator<String> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            String next = it.next();
            if (jSONObject.optJSONObject(next) == null) {
                z = false;
                break;
            }
            jSONObject = jSONObject.optJSONObject(next);
        }
        if (z) {
            return jSONObject.optString(ShareConstants.MEDIA_URI, null);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof AdobeCloud)) {
            return false;
        }
        AdobeCloud adobeCloud = (AdobeCloud) obj;
        String str = this.guid;
        return str != null ? str.equals(adobeCloud.guid) : adobeCloud.guid == null;
    }

    protected String getCloudDescription() {
        return this.cloudDescription;
    }

    public AdobeCloud getCopy() {
        AdobeCloud adobeCloud = new AdobeCloud();
        adobeCloud.guid = this.guid;
        adobeCloud.eTag = this.eTag;
        adobeCloud.name = this.name;
        adobeCloud.cloudDescription = this.cloudDescription;
        adobeCloud.region = this.region;
        try {
            adobeCloud.logoURL = new URL(this.logoURL.toString());
        } catch (MalformedURLException unused) {
        }
        adobeCloud.endpoints = new HashMap(this.endpoints);
        adobeCloud.sessions = new HashMap(this.sessions);
        adobeCloud.parameters = com.adobe.creativesdk.foundation.internal.storage.model.util.d.a(this.parameters);
        adobeCloud.version = this.version;
        adobeCloud.available = this.available;
        adobeCloud.privateCloud = this.privateCloud;
        adobeCloud.quotaEnabled = this.quotaEnabled;
        return adobeCloud;
    }

    public Map<AdobeCloudServiceType, AdobeCloudEndpoint> getEndpoints() {
        return this.endpoints;
    }

    public String getEtag() {
        return this.eTag;
    }

    public String getGUID() {
        return this.guid;
    }

    public String getHref() {
        String str;
        int i = a.f3940b[AdobeAuthIdentityManagementService.K().w().ordinal()];
        if (i == 1) {
            str = "https://cc-api-ers.adobe.io";
        } else if (i == 2 || i == 3) {
            str = "https://cc-api-ers-stage.adobe.io";
        } else if (i != 4) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "Cloud:GetHref", "An undefined authentication endpoint has been specified.");
            str = null;
        } else {
            str = "https://cc-api-ers-qe.adobe.io";
        }
        return String.format("%s/api/v1/clouds/%s", str, getGUID());
    }

    public URL getLogoURL() {
        return this.logoURL;
    }

    public String getName() {
        return this.name;
    }

    public JSONObject getParameters() {
        return this.parameters;
    }

    public String getRegion() {
        return this.region;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public g getSessionForService(AdobeCloudServiceType adobeCloudServiceType) {
        g b2;
        if (this.sessions.containsKey(adobeCloudServiceType)) {
            return this.sessions.get(adobeCloudServiceType);
        }
        AdobeCloudEndpoint adobeCloudEndpoint = this.endpoints.get(adobeCloudServiceType);
        if (adobeCloudEndpoint != null && adobeCloudEndpoint.getServiceType() != adobeCloudServiceType) {
            adobeCloudEndpoint = null;
        }
        switch (a.f3939a[adobeCloudServiceType.ordinal()]) {
            case 1:
                b2 = t.b(adobeCloudEndpoint);
                break;
            case 2:
                b2 = null;
                break;
            case 3:
                b2 = F.b(adobeCloudEndpoint);
                break;
            case 4:
                b2 = ra.b(adobeCloudEndpoint);
                break;
            case 5:
                b2 = com.adobe.creativesdk.foundation.adobeinternal.entitlement.h.b(adobeCloudEndpoint);
                break;
            case 6:
                b2 = c.a.a.a.c.d.b.b(adobeCloudEndpoint);
                break;
            default:
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, AdobeCloud.class.getSimpleName(), "Invalid cloud type specified.");
                b2 = null;
                break;
        }
        if (b2 == null) {
            return null;
        }
        b2.a(isPrivateCloud());
        this.sessions.put(adobeCloudServiceType, b2);
        return b2;
    }

    public Map<AdobeCloudServiceType, g> getSessions() {
        return this.sessions;
    }

    protected long getVersion() {
        return this.version;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean isAvailable() {
        return this.available;
    }

    public boolean isPrivateCloud() {
        return this.privateCloud;
    }

    public boolean isQuotaEnabled() {
        return this.quotaEnabled;
    }

    public boolean isStrictlyEqual(AdobeCloud adobeCloud) {
        boolean equals = equals(adobeCloud);
        return (getEtag() == null || adobeCloud.getEtag() == null) ? equals : equals & getEtag().equals(adobeCloud.getEtag());
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this.guid = (String) objectInput.readObject();
        this.eTag = (String) objectInput.readObject();
        this.name = (String) objectInput.readObject();
        this.cloudDescription = (String) objectInput.readObject();
        this.region = (String) objectInput.readObject();
        this.logoURL = (URL) objectInput.readObject();
        this.endpoints = (HashMap) objectInput.readObject();
        try {
            this.parameters = new JSONObject((String) objectInput.readObject());
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, AdobeCloud.class.getSimpleName(), null, e2);
        }
        this.version = objectInput.readLong();
        this.available = objectInput.readBoolean();
        this.privateCloud = objectInput.readBoolean();
        this.quotaEnabled = objectInput.readBoolean();
    }

    public void removeAllServices() {
        Map<AdobeCloudServiceType, g> map = this.sessions;
        if (map != null) {
            for (Map.Entry<AdobeCloudServiceType, g> entry : map.entrySet()) {
                entry.getValue().i();
                entry.getValue().d().clear();
            }
            this.sessions.clear();
        }
    }

    public void setAvailable(boolean z) {
        this.available = z;
    }

    public void setCloudDescription(String str) {
        this.cloudDescription = str;
    }

    public void setEndpoints(Map<AdobeCloudServiceType, AdobeCloudEndpoint> map) {
        this.endpoints = map;
    }

    public void setEtag(String str) {
        this.eTag = str;
    }

    public void setGUID(String str) {
        this.guid = str;
    }

    public void setLogoURL(URL url) {
        this.logoURL = url;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setParameters(JSONObject jSONObject) {
        this.parameters = jSONObject;
    }

    public void setPrivateCloud(boolean z) {
        this.privateCloud = z;
    }

    public void setQuotaEnabled(boolean z) {
        this.quotaEnabled = z;
    }

    protected void setRegion(String str) {
        this.region = str;
    }

    public void setUpService(AdobeCloudServiceType adobeCloudServiceType) {
        getSessionForService(adobeCloudServiceType).g();
    }

    public void setVersion(long j) {
        this.version = j;
    }

    public void tearDownService(AdobeCloudServiceType adobeCloudServiceType) {
        if (this.sessions.containsKey(adobeCloudServiceType)) {
            this.sessions.get(adobeCloudServiceType).i();
            this.sessions.remove(adobeCloudServiceType);
        }
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        String str = this.guid;
        if (str != null) {
            hashMap.put("guid", str);
        }
        String str2 = this.eTag;
        if (str2 != null) {
            hashMap.put("etag", str2);
        }
        String str3 = this.name;
        if (str3 != null) {
            hashMap.put("name", str3);
        }
        String str4 = this.cloudDescription;
        if (str4 != null) {
            hashMap.put("cloudDescription", str4);
        }
        String str5 = this.region;
        if (str5 != null) {
            hashMap.put("region", str5);
        }
        Map<AdobeCloudServiceType, AdobeCloudEndpoint> map = this.endpoints;
        if (map != null) {
            hashMap.put("endpoints", map);
        }
        JSONObject jSONObject = this.parameters;
        if (jSONObject != null) {
            hashMap.put("parameters", jSONObject);
        }
        Map<AdobeCloudServiceType, g> map2 = this.sessions;
        if (map2 != null) {
            hashMap.put(com.umeng.analytics.pro.b.n, map2);
        }
        hashMap.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, Long.valueOf(this.version));
        hashMap.put("availability", Boolean.valueOf(isAvailable()));
        hashMap.put("private", Boolean.valueOf(isPrivateCloud()));
        hashMap.put("quotaEnabled", Boolean.valueOf(isQuotaEnabled()));
        return hashMap.toString();
    }

    public boolean updateFromData(String str) throws AdobeCloudException {
        if (str != null) {
            try {
                updateFromDictionary(new JSONObject(str));
                return true;
            } catch (JSONException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, AdobeCloud.class.getSimpleName(), null, e2);
                throw new AdobeCloudException(AdobeCloudErrorCode.ADOBE_CLOUD_ERROR_UNEXPECTED_RESPONSE, PARSING_OF_INPUT_FAILED, e2);
            }
        }
        throw new AdobeCloudException(AdobeCloudErrorCode.ADOBE_CLOUD_ERROR_MISSING_JSON_DATA);
    }

    public boolean updateFromDictionary(JSONObject jSONObject) throws AdobeCloudException {
        boolean d2;
        if (jSONObject == null) {
            return false;
        }
        this.guid = jSONObject.optString("id", null);
        this.eTag = jSONObject.optString("etag", null);
        this.name = jSONObject.optString("name", null);
        this.cloudDescription = jSONObject.optString("cloudDescription", null);
        this.region = jSONObject.optString("region", null);
        if (jSONObject.opt(ICON_URL) != null && (jSONObject.opt(ICON_URL) instanceof URL)) {
            this.logoURL = (URL) jSONObject.opt(ICON_URL);
        } else {
            String optString = jSONObject.optString(ICON_URL, null);
            if (optString != null) {
                try {
                    this.logoURL = new URL(jSONObject.optString(ICON_URL, null));
                    this.logoURL = new URL(optString);
                } catch (MalformedURLException unused) {
                    this.logoURL = null;
                }
            }
        }
        String optString2 = jSONObject.optString("status", null);
        this.available = optString2 != null && ("Provisioned".equals(optString2) || "online".equals(optString2));
        this.privateCloud = jSONObject.optBoolean("private", false);
        this.quotaEnabled = true;
        JSONObject optJSONObject = jSONObject.optJSONObject("parameters");
        if (optJSONObject != null) {
            this.parameters = com.adobe.creativesdk.foundation.internal.storage.model.util.d.a(optJSONObject);
            if (optJSONObject.optBoolean("quota")) {
                this.quotaEnabled = optJSONObject.optBoolean("quota");
            }
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("features");
        if (isPrivateCloud()) {
            d2 = AdobeEntitlementServices.b().c();
        } else {
            d2 = AdobeEntitlementServices.b().d();
        }
        if (d2) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("files");
            arrayList.add(STORAGE);
            a(AdobeCloudServiceType.AdobeCloudServiceTypeStorage, "files", a(arrayList, optJSONObject2));
            ArrayList<String> arrayList2 = new ArrayList<>();
            arrayList2.add("assets");
            arrayList2.add(STORAGE);
            a(AdobeCloudServiceType.AdobeCloudServiceTypeStorage, "assets", a(arrayList2, optJSONObject2));
            ArrayList<String> arrayList3 = new ArrayList<>();
            arrayList3.add("files");
            arrayList3.add("archive");
            a(AdobeCloudServiceType.AdobeCloudServiceTypeStorage, "archive", a(arrayList3, optJSONObject2));
            ArrayList<String> arrayList4 = new ArrayList<>();
            arrayList4.add("libraries");
            arrayList4.add(STORAGE);
            a(AdobeCloudServiceType.AdobeCloudServiceTypeStorage, "libraries", a(arrayList4, optJSONObject2));
            ArrayList<String> arrayList5 = new ArrayList<>();
            arrayList5.add("imageservices");
            arrayList5.add(NotificationCompat.CATEGORY_SERVICE);
            a(AdobeCloudServiceType.AdobeCloudServiceTypeImage, "imageservices", a(arrayList5, optJSONObject2));
            ArrayList<String> arrayList6 = new ArrayList<>();
            arrayList6.add("clipboard");
            arrayList6.add(STORAGE);
            a(AdobeCloudServiceType.AdobeCloudServiceTypeClipBoard, "clipboard", a(arrayList6, optJSONObject2));
        } else {
            this.quotaEnabled = false;
        }
        return true;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(this.guid);
        objectOutput.writeObject(this.eTag);
        objectOutput.writeObject(this.name);
        objectOutput.writeObject(this.cloudDescription);
        objectOutput.writeObject(this.region);
        objectOutput.writeObject(this.logoURL);
        objectOutput.writeObject(this.endpoints);
        JSONObject jSONObject = this.parameters;
        objectOutput.writeObject(jSONObject != null ? jSONObject.toString() : null);
        objectOutput.writeLong(this.version);
        objectOutput.writeBoolean(this.available);
        objectOutput.writeBoolean(this.privateCloud);
        objectOutput.writeBoolean(this.quotaEnabled);
    }

    private void a(AdobeCloudServiceType adobeCloudServiceType, String str, String str2) throws AdobeCloudException {
        if (str2 == null || adobeCloudServiceType == AdobeCloudServiceType.AdobeCloudServiceTypeUnknown) {
            return;
        }
        AdobeCloudEndpoint adobeCloudEndpoint = this.endpoints.get(adobeCloudServiceType);
        if (adobeCloudEndpoint != null) {
            try {
                adobeCloudEndpoint.addServiceSchemaId(str, new URL(str2));
            } catch (MalformedURLException e2) {
                throw new AdobeCloudException(AdobeCloudErrorCode.ADOBE_CLOUD_ERROR_UNEXPECTED_RESPONSE, PARSING_OF_INPUT_FAILED, e2);
            }
        } else {
            try {
                adobeCloudEndpoint = new AdobeCloudEndpoint(str, new URL(str2), adobeCloudServiceType);
            } catch (MalformedURLException e3) {
                throw new AdobeCloudException(AdobeCloudErrorCode.ADOBE_CLOUD_ERROR_UNEXPECTED_RESPONSE, PARSING_OF_INPUT_FAILED, e3);
            }
        }
        this.endpoints.put(adobeCloudServiceType, adobeCloudEndpoint);
    }

    protected AdobeCloud(String str, String str2, String str3, String str4, String str5, long j, URL url, HashMap<AdobeCloudServiceType, AdobeCloudEndpoint> hashMap, JSONObject jSONObject) {
        this.quotaEnabled = true;
        this.guid = str;
        this.eTag = str2;
        this.name = str3;
        this.cloudDescription = str4;
        this.region = str5;
        this.version = j;
        this.logoURL = url;
        this.endpoints = new HashMap(hashMap);
        this.parameters = com.adobe.creativesdk.foundation.internal.storage.model.util.d.a(jSONObject);
        this.available = false;
        this.privateCloud = false;
    }
}
