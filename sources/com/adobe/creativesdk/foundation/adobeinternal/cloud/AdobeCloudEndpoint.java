package com.adobe.creativesdk.foundation.adobeinternal.cloud;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class AdobeCloudEndpoint implements Externalizable {
    private HashMap<String, URL> _serviceURLs;

    /* renamed from: a */
    private transient AdobeCloudServiceType f3932a;

    public AdobeCloudEndpoint() {
        this.f3932a = AdobeCloudServiceType.AdobeCloudServiceTypeUnknown;
        this._serviceURLs = new HashMap<>();
    }

    public void addServiceSchemaId(String str, URL url) {
        if (str == null) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, AdobeCloudEndpoint.class.getSimpleName(), "Service name cannot be null.");
        }
        if (url == null) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, AdobeCloudEndpoint.class.getSimpleName(), "Service URL cannot be null.");
        }
        if (str == null || url == null) {
            return;
        }
        this._serviceURLs.put(str, url);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdobeCloudEndpoint)) {
            AdobeCloudEndpoint adobeCloudEndpoint = (AdobeCloudEndpoint) obj;
            if (this.f3932a == adobeCloudEndpoint.f3932a) {
                if (this._serviceURLs == null && adobeCloudEndpoint._serviceURLs == null) {
                    return true;
                }
                HashMap<String, URL> hashMap = this._serviceURLs;
                if (hashMap != null && adobeCloudEndpoint._serviceURLs != null && hashMap.size() == adobeCloudEndpoint._serviceURLs.size()) {
                    for (Map.Entry<String, URL> entry : this._serviceURLs.entrySet()) {
                        URL url = adobeCloudEndpoint._serviceURLs.get(entry.getKey());
                        if (url != null && url.getPath().equals(entry.getValue().getPath())) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public AdobeCloudEndpoint getCopy() {
        AdobeCloudEndpoint adobeCloudEndpoint = new AdobeCloudEndpoint();
        adobeCloudEndpoint.f3932a = this.f3932a;
        adobeCloudEndpoint._serviceURLs = (HashMap) this._serviceURLs.clone();
        return adobeCloudEndpoint;
    }

    public AdobeCloudServiceType getServiceType() {
        return this.f3932a;
    }

    public HashMap<String, URL> getServiceURLs() {
        return this._serviceURLs;
    }

    public int hashCode() {
        return super.hashCode();
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this.f3932a = AdobeCloudServiceType.values()[objectInput.readInt()];
        this._serviceURLs = (HashMap) objectInput.readObject();
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("service_type", this.f3932a);
        hashMap.put("service_urls", this._serviceURLs);
        return hashMap.toString();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeInt(this.f3932a.getValue());
        objectOutput.writeObject(this._serviceURLs);
    }

    public AdobeCloudEndpoint(String str, URL url, AdobeCloudServiceType adobeCloudServiceType) {
        this();
        this.f3932a = adobeCloudServiceType;
        str = str == null ? "default" : str;
        if (url != null) {
            this._serviceURLs.put(str, url);
        } else {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, AdobeCloudEndpoint.class.getSimpleName(), "Service URL cannot be null.");
        }
    }
}
