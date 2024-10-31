package c.a.a.a.c.b;

import com.adobe.creativesdk.foundation.adobeinternal.entitlement.AdobeEntitlementErrorCode;
import com.adobe.creativesdk.foundation.adobeinternal.entitlement.AdobeEntitlementException;
import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIMSEnvironment;
import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIdentityManagementService;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.internal.utils.logging.c;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdobeEntitlementUtils.java */
/* loaded from: classes.dex */
public class b {
    private b() {
    }

    public static JSONObject a(String str) throws AdobeEntitlementException {
        if (str != null) {
            try {
                Matcher matcher = Pattern.compile("while \\(1\\) \\{\\}").matcher(str);
                if (matcher.find()) {
                    str = matcher.replaceAll("").trim();
                }
                return new JSONObject(str);
            } catch (JSONException e2) {
                throw new AdobeEntitlementException(AdobeEntitlementErrorCode.AdobeEntitlementErrorUnexpectedResponse, "Parsed collection data is not of type dictionary.", e2);
            }
        }
        throw new AdobeEntitlementException(AdobeEntitlementErrorCode.AdobeEntitlementErrorMissingJSONData);
    }

    public static JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("endpoints", a().optJSONArray("endpoints"));
            jSONObject.put("services", new JSONObject("\t\t\t{\nBehance: {\n                \"allow_private_endpoint\": true,\nentitled: true\n            },\nccv: {\n                \"allow_private_endpoint\": true,\nentitled: true\n            },\ncollaboration: {\n                \"allow_private_endpoint\": true,\nentitled: true\n            },\ncolor: {\n                \"allow_private_endpoint\": true,\nentitled: true\n            },\ndesign_assets: {\n                \"allow_private_endpoint\": true,\nentitled: true\n            },\nedge_inspect: {\n                \"allow_private_endpoint\": true,\nentitled: true\n            },\nextract: {\n                \"allow_private_endpoint\": true,\nentitled: true\n            },\nfile_sync: {\n                \"allow_private_endpoint\": true,\nentitled: true\n            },\nimage: {\n                \"allow_private_endpoint\": true,\nentitled: true\n            },\nlibraries: {\n                \"allow_private_endpoint\": true,\nentitled: true\n            },\nlightroom: {\n                \"allow_private_endpoint\": true,\nentitled: true\n            },\nphonegap_build: {\n                \"allow_private_endpoint\": true,\nentitled: true\n            },\npreview: {\n                \"allow_private_endpoint\": true,\nentitled: true\n            },\nstorage: {\n                \"allow_private_endpoint\": true,\nentitled: true\n            },\nstory: {\n                \"allow_private_endpoint\": true,\nentitled: true\n            },\nsync_metadata: {\n                \"allow_private_endpoint\": true,\nentitled: true\n            },\nsync_settings: {\n                \"allow_private_endpoint\": true,\nentitled: true\n            },\ntypekit: {\n                \"allow_private_endpoint\": true,\nentitled: true\n            }\nstock: {\n                \"allow_private_endpoint\": true,\nentitled: true,\nservice_level: free_basic\n            }\n        }"));
        } catch (JSONException e2) {
            c.a(Level.ERROR, b.class.getSimpleName(), e2.getMessage(), e2);
        }
        return jSONObject;
    }

    public static JSONObject a() {
        AdobeAuthIMSEnvironment w = AdobeAuthIdentityManagementService.K().w();
        if (w == AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentTestUS) {
            try {
                return new JSONObject("{\nendpoints:\n\t[\n\t{\"features\" : {\"photos\" : {\"service\" : {\"uri\" : \"https://api.oznext.com\"}}},\n\t\t\"id\" : \"00000000-0000-0000-0000-000000000000\",\n\t\t\"name\" : \"Adobe Creative Cloud [QA1]\",\n\t\t\"private\" : false,\n\t\t\"status\" : \"ONLINE\"}\n\t]\n};");
            } catch (JSONException e2) {
                c.a(Level.ERROR, b.class.getSimpleName(), e2.getMessage(), e2);
            }
        } else if (w == AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentStageUS) {
            try {
                return new JSONObject("{\nendpoints:\n\t[\n\t{\"features\" : {\n\t\t\"files\" : {\"storage\" : {\"uri\" : \"https://cc-api-storage-stage.adobe.io\"},\"archive\" :{ \"uri\" : \"https://cc-api-storage-stage.adobe.io\"}},\n\t\t\"assets\" : {\"storage\" : {\"uri\" : \"https://cc-api-storage-stage.adobe.io\"}},\n\t\t\"libraries\" : {\"storage\" : {\"uri\" : \"https://cc-api-storage-stage.adobe.io\"}},\n\t\t\"imageservices\" : {\"service\" : {\"uri\" : \"https://cc-api-image-stage.adobe.io\"}},\n\t\t\"clipboard\" : {\"service\" : {\"uri\" : \"https://cc-api-storage-stage.adobe.io\"}}\n\t},\n\t\t\"id\" : \"00000000-0000-0000-0000-000000000000\",\n\t\t\"name\" : \"Adobe Creative Cloud [Stage] (static)\",\n\t\t\"private\" : false,\n\t\t\"status\" : \"ONLINE\"},\n\t]\n};");
            } catch (JSONException e3) {
                c.a(Level.ERROR, b.class.getSimpleName(), e3.getMessage(), e3);
            }
        } else if (w == AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentProductionUS) {
            try {
                return new JSONObject("{\nendpoints:\n\t[\n\t{\"features\" : {\n\t\t\"files\" : {\"storage\" : {\"uri\" : \"https://cc-api-storage.adobe.io\"}, \"archive\" :{ \"uri\" : \"https://cc-api-storage.adobe.io\"} },\n\t\t\"assets\" : {\"storage\" : {\"uri\" : \"https://cc-api-storage.adobe.io\"}},\n\t\t\"libraries\" : {\"storage\" : {\"uri\" : \"https://cc-api-storage.adobe.io\"}},\n\t\t\"imageservices\" : {\"service\" : {\"uri\" : \"https://cc-api-image.adobe.io\"}},\n\t\t\"clipboard\" : {\"service\" : {\"uri\" : \"https://cc-api-storage.adobe.io\"}}\n\t},\n\t\t\"id\" : \"00000000-0000-0000-0000-000000000000\",\n\t\t\"name\" : \"Adobe Creative Cloud\",\n\t\t\"private\" : false,\n\t\t\"status\" : \"ONLINE\"},\n\t]\n};");
            } catch (JSONException e4) {
                c.a(Level.ERROR, b.class.getSimpleName(), e4.getMessage(), e4);
            }
        }
        return null;
    }

    public static JSONObject a(JSONObject jSONObject) throws AdobeEntitlementException {
        if (jSONObject != null && jSONObject.opt("services") != null) {
            return jSONObject.optJSONObject("services");
        }
        if (jSONObject != null && jSONObject.opt("services") == null) {
            throw new AdobeEntitlementException(AdobeEntitlementErrorCode.AdobeEntitlementErrorNoServicesAvailable, "No Public Services are available for this user.");
        }
        throw new AdobeEntitlementException(AdobeEntitlementErrorCode.AdobeEntitlementErrorUnexpectedResponse, "Query for Public Services returned an unexpected response.");
    }

    public static boolean a(JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator<String> keys = jSONObject.keys();
        int i = 0;
        while (keys.hasNext()) {
            keys.next();
            i++;
        }
        Iterator<String> keys2 = jSONObject2.keys();
        int i2 = 0;
        while (keys2.hasNext()) {
            keys2.next();
            i2++;
        }
        boolean z = i == i2;
        if (z) {
            Iterator<String> keys3 = jSONObject.keys();
            while (keys3.hasNext()) {
                String next = keys3.next();
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                JSONObject optJSONObject2 = jSONObject2.optJSONObject(next);
                if (optJSONObject != null && optJSONObject2 != null) {
                    Iterator<String> keys4 = optJSONObject.keys();
                    while (keys4.hasNext()) {
                        String next2 = keys4.next();
                        if (optJSONObject.opt(next2).getClass().equals(String.class)) {
                            if (!optJSONObject.optString(next2).equals(optJSONObject2.optString(next2))) {
                                z = false;
                                break;
                            }
                        } else if (optJSONObject.opt(next2).getClass().equals(JSONObject.class)) {
                            if (!a(optJSONObject.optJSONObject(next2), optJSONObject2.optJSONObject(next2))) {
                                z = false;
                                break;
                                break;
                            }
                        } else if (optJSONObject.optBoolean(next2) != optJSONObject2.optBoolean(next2)) {
                            z = false;
                            break;
                            break;
                        }
                    }
                }
                if (!z) {
                    break;
                }
            }
        }
        return z;
    }
}
