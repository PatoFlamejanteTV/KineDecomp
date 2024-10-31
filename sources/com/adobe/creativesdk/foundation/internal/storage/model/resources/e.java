package com.adobe.creativesdk.foundation.internal.storage.model.resources;

import android.os.Parcel;
import android.os.Parcelable;
import com.adobe.creativesdk.foundation.internal.storage.model.util.ParsingDataException;
import com.adobe.creativesdk.foundation.internal.storage.model.util.g;
import com.adobe.creativesdk.foundation.internal.storage.model.util.i;
import com.adobe.creativesdk.foundation.storage.AdobeAssetErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobeCollaborationRoleType;
import com.adobe.creativesdk.foundation.storage.AdobeCollaborationType;
import com.facebook.share.internal.ShareConstants;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AdobeStorageResourceCollection.java */
/* loaded from: classes.dex */
public class e extends b implements Parcelable {
    public static final Parcelable.Creator<e> CREATOR = new c();
    private String n;
    private String o;
    private String p;
    private ArrayList<b> q;
    private int r;
    private int s;
    private AdobeStorageOrderRelation t;
    private AdobeStorageOrderByProperty u;
    String v;

    public e() {
        this.f6612d = "application/vnd.adobe.directory+json";
        this.f6616h = true;
    }

    public void b(String str) {
        this.p = str;
    }

    public void c(String str) {
        if (str == null || str.equals(this.o)) {
            return;
        }
        this.o = str;
        this.n = null;
    }

    public ArrayList<b> d() {
        return this.q;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.v;
    }

    public int f() {
        return this.r;
    }

    public String g() {
        return this.p;
    }

    public int h() {
        return this.s;
    }

    public AdobeStorageOrderRelation i() {
        return this.t;
    }

    public AdobeStorageOrderByProperty j() {
        return this.u;
    }

    public String k() {
        if (this.n == null) {
            HashMap hashMap = new HashMap();
            String str = this.o;
            if (str != null) {
                hashMap.put("start", str);
            }
            int i = this.r;
            if (i > 0) {
                hashMap.put("limit", Integer.toString(i));
            }
            if (this.t == AdobeStorageOrderRelation.ADOBE_STORAGE_ORDER_DESCENDING) {
                hashMap.put("order", "desc");
            } else {
                hashMap.put("order", "asc");
            }
            String str2 = null;
            AdobeStorageOrderByProperty adobeStorageOrderByProperty = this.u;
            if (adobeStorageOrderByProperty != null) {
                int i2 = d.f6617a[adobeStorageOrderByProperty.ordinal()];
                if (i2 == 1) {
                    str2 = "name";
                } else if (i2 == 2) {
                    str2 = "modified";
                } else if (i2 == 3) {
                    str2 = "ordinal";
                }
            }
            if (str2 != null) {
                hashMap.put("orderby", str2);
            } else {
                hashMap.put("orderby", "name");
            }
            String str3 = this.v;
            if (str3 != null) {
                hashMap.put("type", str3);
            }
            this.n = a((HashMap<String, String>) hashMap);
        }
        return this.n;
    }

    public String l() {
        return this.o;
    }

    public boolean m() {
        return this.p == null;
    }

    public void n() {
        this.o = null;
        this.p = null;
        this.n = null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        String str = this.f6609a;
        if (str != null) {
            parcel.writeString(str);
        } else {
            parcel.writeString("-");
        }
        parcel.writeSerializable(this.f6610b);
        String str2 = this.f6613e;
        if (str2 != null) {
            parcel.writeString(str2);
        } else {
            parcel.writeString("-");
        }
        parcel.writeString(this.f6611c);
        String str3 = this.f6614f;
        if (str3 != null) {
            parcel.writeString(str3);
        } else {
            parcel.writeString("-");
        }
        String str4 = this.f6615g;
        if (str4 != null) {
            parcel.writeString(str4);
        } else {
            parcel.writeString("-");
        }
        String str5 = this.f6612d;
        if (str5 != null) {
            parcel.writeString(str5);
        } else {
            parcel.writeString("-");
        }
        parcel.writeSerializable(this.k);
        parcel.writeSerializable(this.l);
        parcel.writeInt(this.s);
    }

    public static e a(URI uri) {
        if (uri == null) {
            return null;
        }
        e eVar = new e();
        String a2 = g.a(uri.getPath());
        eVar.f6610b = uri;
        eVar.f6611c = a2;
        return eVar;
    }

    public e(e eVar) {
        super(eVar);
        this.f6612d = "application/vnd.adobe.directory+json";
        this.f6616h = true;
        this.n = eVar.k();
        this.o = eVar.l();
        this.p = eVar.g();
        this.q = null;
        if (eVar.d() != null) {
            this.q = new ArrayList<>(eVar.d());
        }
        this.r = eVar.f();
        this.s = eVar.h();
        this.t = eVar.i();
        this.u = eVar.j();
        this.v = eVar.e();
    }

    public static e a(URI uri, String str) {
        if (uri == null) {
            return null;
        }
        e eVar = new e();
        String a2 = g.a(uri.getPath());
        eVar.f6610b = uri;
        eVar.f6611c = a2;
        eVar.f6615g = str;
        return eVar;
    }

    public static e a(String str) {
        if (str == null) {
            return null;
        }
        e eVar = new e();
        String a2 = g.a(str);
        try {
            eVar.f6610b = new URI(URLEncoder.encode(str, "UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (URISyntaxException e3) {
            e3.printStackTrace();
        }
        eVar.f6611c = a2;
        return eVar;
    }

    void a(JSONObject jSONObject, boolean z) throws ParsingDataException {
        URI uri;
        this.f6609a = jSONObject.optString("id");
        this.f6611c = jSONObject.optString("name");
        this.f6613e = jSONObject.optString("etag");
        this.f6615g = jSONObject.optString("modified");
        this.i = jSONObject.optInt("ordinal");
        this.f6612d = jSONObject.optString("type");
        this.s = jSONObject.has("total_children") ? jSONObject.optInt("total_children") : jSONObject.optJSONArray("children") != null ? jSONObject.optJSONArray("children").length() : 0;
        this.j = (JSONObject) jSONObject.opt("_links");
        if (this.f6611c != null) {
            if (this.f6613e != null) {
                if (this.f6615g != null) {
                    String optString = jSONObject.optString("collaboration", null);
                    this.l = AdobeCollaborationRoleType.ADOBE_COLLABORATION_ROLE_TYPE_OWNER;
                    if (optString == null) {
                        this.k = AdobeCollaborationType.ADOBE_COLLABORATION_TYPE_PRIVATE;
                    } else if (optString.equalsIgnoreCase("outgoing")) {
                        this.k = AdobeCollaborationType.ADOBE_COLLABORATION_TYPE_SHAREDBYUSER;
                    } else if (optString.equalsIgnoreCase("incoming")) {
                        this.k = AdobeCollaborationType.ADOBE_COLLABORATION_TYPE_SHAREDWITHUSER;
                        String optString2 = jSONObject.optString("collaboration_role", null);
                        if (optString2 == null) {
                            this.l = AdobeCollaborationRoleType.ADOBE_COLLABORATION_ROLE_TYPE_EDITOR;
                        } else if (optString2.equalsIgnoreCase("VIEWER")) {
                            this.l = AdobeCollaborationRoleType.ADOBE_COLLABORATION_ROLE_TYPE_VIEWER;
                        }
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("children");
                    if (optJSONArray != null) {
                        ArrayList<b> arrayList = new ArrayList<>();
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            try {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                                String a2 = f.a(optJSONObject.optString("name"));
                                JSONObject jSONObject2 = (JSONObject) optJSONObject.opt("_links");
                                JSONObject jSONObject3 = jSONObject2 != null ? (JSONObject) jSONObject2.opt("http://ns.adobe.com/ccapi/path") : null;
                                String optString3 = jSONObject3 != null ? jSONObject3.optString(ShareConstants.WEB_DIALOG_PARAM_HREF) : null;
                                if (optString3 != null) {
                                    uri = new URI(optString3);
                                } else {
                                    uri = new URI(this.f6610b.getRawPath().concat(a2));
                                }
                                if (optJSONObject.optString("type").equals("application/vnd.adobe.directory+json")) {
                                    e a3 = a(new URI(uri.getRawPath().concat("/")));
                                    a3.a(a());
                                    a3.a(optJSONObject, false);
                                    arrayList.add(a3);
                                } else {
                                    f a4 = f.a(uri);
                                    a4.a(a());
                                    a4.b(optJSONObject);
                                    arrayList.add(a4);
                                }
                            } catch (URISyntaxException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (z && this.q != null) {
                            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                this.q.add(arrayList.get(i2));
                            }
                            return;
                        }
                        this.q = arrayList;
                        return;
                    }
                    this.q = null;
                    return;
                }
                throw new ParsingDataException(com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorUnexpectedResponse, "Collection doesn't have a modified time."));
            }
            throw new ParsingDataException(com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorUnexpectedResponse, "Collection doesn't have an etag."));
        }
        throw new ParsingDataException(com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorUnexpectedResponse, "Collection doesn't have a name."));
    }

    public void a(String str, boolean z) throws ParsingDataException {
        JSONObject a2 = i.a(str);
        if (a2 != null) {
            a(a2, z);
            return;
        }
        throw new ParsingDataException(com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorUnexpectedResponse, "Parsed collection data is not of type dictionary."));
    }

    public void a(int i) {
        if (i != this.r) {
            this.r = i;
            this.n = null;
        }
    }

    public void a(AdobeStorageOrderRelation adobeStorageOrderRelation) {
        if (adobeStorageOrderRelation != this.t) {
            this.t = adobeStorageOrderRelation;
            n();
        }
    }

    public void a(AdobeStorageOrderByProperty adobeStorageOrderByProperty) {
        if (adobeStorageOrderByProperty != this.u) {
            this.u = adobeStorageOrderByProperty;
            n();
        }
    }

    public void a(ArrayList<b> arrayList) {
        this.q = arrayList;
    }

    private static String a(HashMap<String, String> hashMap) {
        String encode;
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            String key = entry.getKey();
            String value = entry.getValue();
            String str = "";
            if (key != null) {
                try {
                    encode = URLEncoder.encode(key, "UTF-8");
                } catch (UnsupportedEncodingException e2) {
                    throw new RuntimeException("Problem encoding the collection params into query string", e2);
                }
            } else {
                encode = "";
            }
            sb.append(encode);
            sb.append("=");
            if (value != null) {
                str = URLEncoder.encode(value, "UTF-8");
            }
            sb.append(str);
        }
        return sb.toString();
    }
}
