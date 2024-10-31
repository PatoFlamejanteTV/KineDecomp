package com.adobe.creativesdk.foundation.adobeinternal.imageservice;

import com.adobe.creativesdk.foundation.internal.net.AdobeNetworkHttpRequestMethod;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.places.model.PlaceFields;
import com.facebook.share.internal.ShareConstants;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdobeImageOperation.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static String f3987a = "b";

    /* renamed from: b, reason: collision with root package name */
    private JSONObject f3988b;

    /* renamed from: c, reason: collision with root package name */
    private JSONObject f3989c;

    /* renamed from: d, reason: collision with root package name */
    private JSONObject f3990d;

    /* renamed from: e, reason: collision with root package name */
    private JSONArray f3991e;

    /* renamed from: f, reason: collision with root package name */
    private JSONObject f3992f;

    /* renamed from: g, reason: collision with root package name */
    private JSONObject f3993g;

    private b b(String str, b bVar, com.adobe.creativesdk.foundation.internal.net.l lVar) throws AdobeAssetException, AdobeNetworkException, FileNotFoundException {
        b bVar2 = null;
        if (lVar == null || lVar.e() == null) {
            return null;
        }
        String str2 = null;
        for (String str3 : lVar.e().keySet()) {
            if (str3.compareToIgnoreCase("content-type") == 0) {
                str2 = lVar.e().get(str3).get(0);
            }
        }
        if (str2 != null) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f3987a, "content-type " + str2);
            if (str2.compareToIgnoreCase("application/vnd.adobe.image-operation+json") == 0) {
                try {
                    File file = new File(str);
                    FileInputStream fileInputStream = new FileInputStream(file);
                    byte[] bArr = new byte[(int) file.length()];
                    if (file.length() != fileInputStream.read(bArr)) {
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, f3987a, "inputstream read FAIL");
                    }
                    String str4 = new String(bArr, "UTF-8");
                    fileInputStream.close();
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "", "response : " + str4);
                    return e(str4);
                } catch (IOException e2) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, f3987a, "", e2);
                }
            } else if (str2.toLowerCase().contains("multipart/related")) {
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
                    try {
                        try {
                            bVar2 = a(bufferedInputStream, str2, bVar);
                        } catch (Exception e3) {
                            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, f3987a, "", e3);
                        }
                        return bVar2;
                    } finally {
                        org.apache.commons.io.d.a((InputStream) bufferedInputStream);
                    }
                } catch (FileNotFoundException e4) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, f3987a, "", e4);
                    throw e4;
                }
            }
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, f3987a, "unhandled content-type " + str2);
            return null;
        }
        throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorUnexpectedResponse, "Content type header not specified");
    }

    private String c(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(":|@");
        if (split.length == 2) {
            return split[0];
        }
        if (split.length == 3) {
            return split[1];
        }
        return split[0];
    }

    private String d(String str) throws AdobeAssetException {
        Matcher matcher = Pattern.compile(".*boundary=(.*)", 2).matcher(str);
        ArrayList arrayList = new ArrayList();
        while (matcher.find()) {
            arrayList.add(matcher.group(1));
        }
        if (arrayList.size() == 1) {
            return (String) arrayList.get(0);
        }
        throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorUnexpectedResponse, "Invalid content type string");
    }

    private b e(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f3988b = jSONObject.has("options") ? jSONObject.getJSONObject("options") : null;
            this.f3989c = jSONObject.has("response") ? jSONObject.getJSONObject("response") : null;
            if (jSONObject.has("inputs")) {
                this.f3990d = d(jSONObject.getJSONObject("inputs"));
            } else {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, f3987a, "inputs !found in JSON");
                this.f3990d = null;
            }
            if (jSONObject.has("outputs")) {
                this.f3993g = d(jSONObject.getJSONObject("outputs"));
            } else {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, f3987a, "outputs !found in JSON");
                this.f3993g = null;
            }
            return this;
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, f3987a, "", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.adobe.creativesdk.foundation.internal.net.j a(String str, URL url, String str2) {
        URL url2;
        try {
            url2 = new URL(com.adobe.creativesdk.foundation.internal.storage.model.util.g.a(str, url.toString()));
        } catch (MalformedURLException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, f3987a, "", e2);
            url2 = null;
        }
        com.adobe.creativesdk.foundation.internal.net.j jVar = new com.adobe.creativesdk.foundation.internal.net.j();
        jVar.a(url2);
        jVar.a(AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodPOST);
        HashMap<String, com.adobe.creativesdk.foundation.internal.storage.model.resources.f> hashMap = new HashMap<>();
        String a2 = a();
        String str3 = a2 + AppEventsConstants.EVENT_PARAM_VALUE_NO + "@adobe.com";
        String a3 = a(hashMap, a2);
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f3987a, a3);
        if (hashMap.size() == 0) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f3987a, "response : image-operation+json");
            jVar.b("content-type", "application/vnd.adobe.image-operation+json");
            jVar.a(a3.getBytes(org.apache.commons.io.a.f29306f));
            return jVar;
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f3987a, "response : multipart");
        String str4 = "Boundary_" + a();
        jVar.b("content-type", "multipart/related; boundary=" + str4);
        d.a(a3, str3, hashMap, str4, str2);
        try {
            long length = new File(str2).length();
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f3987a, "body stream len : " + length);
            jVar.a(str2);
            jVar.b("content-length", "" + Long.toString(length));
            return jVar;
        } catch (IOException e3) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, f3987a, "", e3);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(JSONObject jSONObject) {
        this.f3992f = jSONObject;
    }

    private JSONObject d(JSONObject jSONObject) {
        String str;
        String str2;
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f3987a, "replacing with storage items...");
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f3987a, "key : " + next);
            try {
                Object obj = jSONObject.get(next);
                if (obj instanceof JSONArray) {
                    JSONArray jSONArray = new JSONArray();
                    for (int i = 0; i < ((JSONArray) obj).length(); i++) {
                        try {
                            JSONObject jSONObject3 = (JSONObject) ((JSONArray) obj).get(i);
                            if (jSONObject3.has(ShareConstants.WEB_DIALOG_PARAM_HREF)) {
                                str = (String) jSONObject3.get(ShareConstants.WEB_DIALOG_PARAM_HREF);
                            } else if (jSONObject3.has(PlaceFields.LOCATION)) {
                                str = (String) jSONObject3.get(PlaceFields.LOCATION);
                            } else {
                                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, f3987a, "href/location not found in input.");
                                str = "";
                            }
                            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f3987a, "create storage item for " + str);
                            com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar = new com.adobe.creativesdk.foundation.internal.storage.model.resources.f();
                            fVar.f6610b = new URI(str);
                            jSONArray.put(fVar);
                        } catch (URISyntaxException | JSONException e2) {
                            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, f3987a, "", e2);
                        }
                    }
                    jSONObject2.putOpt(next, jSONArray);
                } else if (obj instanceof JSONObject) {
                    JSONObject jSONObject4 = (JSONObject) obj;
                    try {
                        if (jSONObject4.has(ShareConstants.WEB_DIALOG_PARAM_HREF)) {
                            str2 = (String) jSONObject4.get(ShareConstants.WEB_DIALOG_PARAM_HREF);
                        } else if (jSONObject4.has(PlaceFields.LOCATION)) {
                            str2 = (String) jSONObject4.get(PlaceFields.LOCATION);
                        } else {
                            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, f3987a, "href/location not found in input.");
                            str2 = "";
                        }
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f3987a, "create storage item for " + str2);
                        com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar2 = new com.adobe.creativesdk.foundation.internal.storage.model.resources.f();
                        fVar2.f6610b = new URI(str2);
                        jSONObject2.putOpt(next, fVar2);
                    } catch (URISyntaxException | JSONException e3) {
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, f3987a, "", e3);
                    }
                } else {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, f3987a, "unknown type of item.");
                }
            } catch (JSONException e4) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, f3987a, "", e4);
            }
        }
        return jSONObject2;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x017d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.lang.String a(java.util.HashMap<java.lang.String, com.adobe.creativesdk.foundation.internal.storage.model.resources.f> r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 708
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.adobeinternal.imageservice.b.a(java.util.HashMap, java.lang.String):java.lang.String");
    }

    public static String b(String str) {
        Matcher matcher = Pattern.compile("Content-Type:(.*)", 2).matcher(str);
        ArrayList arrayList = new ArrayList();
        while (matcher.find()) {
            arrayList.add(matcher.group(1));
        }
        if (arrayList.size() != 1) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, f3987a, "content type not found");
            return null;
        }
        return ((String) arrayList.get(0)).replaceAll("\\s+", "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(JSONObject jSONObject) {
        this.f3988b = jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x025c, code lost:            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(com.adobe.creativesdk.foundation.internal.utils.logging.Level.ERROR, com.adobe.creativesdk.foundation.adobeinternal.imageservice.b.f3987a, "content-type not found for part " + r10);     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0275, code lost:            return null;     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0276, code lost:            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(com.adobe.creativesdk.foundation.internal.utils.logging.Level.ERROR, com.adobe.creativesdk.foundation.adobeinternal.imageservice.b.f3987a, "content-id not found for part " + r10);     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x028f, code lost:            return null;     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00e6, code lost:            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(com.adobe.creativesdk.foundation.internal.utils.logging.Level.ERROR, com.adobe.creativesdk.foundation.adobeinternal.imageservice.b.f3987a, "assign local file FAIL");     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ef, code lost:            return r7;     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.adobe.creativesdk.foundation.adobeinternal.imageservice.b a(java.io.InputStream r19, java.lang.String r20, com.adobe.creativesdk.foundation.adobeinternal.imageservice.b r21) throws com.adobe.creativesdk.foundation.storage.AdobeAssetException, com.adobe.creativesdk.foundation.network.AdobeNetworkException {
        /*
            Method dump skipped, instructions count: 687
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.adobeinternal.imageservice.b.a(java.io.InputStream, java.lang.String, com.adobe.creativesdk.foundation.adobeinternal.imageservice.b):com.adobe.creativesdk.foundation.adobeinternal.imageservice.b");
    }

    public static b a(String str, b bVar, com.adobe.creativesdk.foundation.internal.net.l lVar) throws AdobeAssetException, AdobeNetworkException, FileNotFoundException {
        return new b().b(str, bVar, lVar);
    }

    private boolean a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, c cVar, HashMap<String, String> hashMap) throws AdobeNetworkException {
        URI uri = fVar.f6610b;
        if (uri == null || !uri.toString().startsWith("cid:")) {
            return false;
        }
        String c2 = c(uri.toString());
        if (cVar.f3998e != null) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f3987a, c2 + " : " + cVar.f3998e);
            hashMap.put(c2, cVar.f3998e);
            return true;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("ADOBE_ASSET_DETAILS_STRING_KEY", "No local file path provided to output result images to");
        throw new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorBadRequest, hashMap2);
    }

    private HashMap<String, String> a(b bVar) throws AdobeNetworkException {
        c cVar;
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f3987a, "assign local file...");
        HashMap<String, String> hashMap = new HashMap<>();
        Iterator<String> keys = this.f3993g.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = null;
            try {
                cVar = (c) bVar.f3992f.get(next);
            } catch (JSONException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, f3987a, "", e2);
                cVar = null;
            }
            if (cVar == null) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, f3987a, "output params NULL for " + next);
            } else {
                try {
                    obj = this.f3993g.get(next);
                } catch (JSONException e3) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, f3987a, "", e3);
                }
                if (obj instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) obj;
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f3987a, "outputs are JSONArray len " + jSONArray.length());
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            a((com.adobe.creativesdk.foundation.internal.storage.model.resources.f) jSONArray.get(i), cVar, hashMap);
                        } catch (JSONException e4) {
                            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, f3987a, "not a storage item.", e4);
                        }
                    }
                } else if (obj instanceof com.adobe.creativesdk.foundation.internal.storage.model.resources.f) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f3987a, "outputs is AdobeStorageResourceItem");
                    a((com.adobe.creativesdk.foundation.internal.storage.model.resources.f) obj, cVar, hashMap);
                } else {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, f3987a, "unknown resource item ");
                    throw new ClassCastException();
                }
            }
        }
        return hashMap;
    }

    private boolean a(HashMap<String, x> hashMap) {
        URI uri;
        JSONObject jSONObject = this.f3993g;
        if (jSONObject == null) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, f3987a, "mOutputs null");
            return false;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                Object obj = this.f3993g.get(next);
                if (obj instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) obj;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            URI uri2 = ((com.adobe.creativesdk.foundation.internal.storage.model.resources.f) jSONArray.get(i)).f6610b;
                            if (uri2 != null && uri2.toString().startsWith("cid:")) {
                                String c2 = c(uri2.toString());
                                x xVar = hashMap.get(c2);
                                try {
                                    jSONArray.put(i, com.adobe.creativesdk.foundation.internal.storage.model.resources.f.a(xVar.f4066a, xVar.f4067b));
                                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f3987a, "replaced item for " + c2 + ":" + xVar.f4066a);
                                } catch (JSONException e2) {
                                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, f3987a, "", e2);
                                }
                            }
                        } catch (JSONException e3) {
                            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, f3987a, "", e3);
                        }
                    }
                } else if ((obj instanceof com.adobe.creativesdk.foundation.internal.storage.model.resources.f) && (uri = ((com.adobe.creativesdk.foundation.internal.storage.model.resources.f) obj).f6610b) != null && uri.toString().startsWith("cid:")) {
                    String c3 = c(uri.toString());
                    x xVar2 = hashMap.get(c3);
                    try {
                        this.f3993g.putOpt(next, com.adobe.creativesdk.foundation.internal.storage.model.resources.f.a(xVar2.f4066a, xVar2.f4067b));
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f3987a, "replaced item for " + c3);
                    } catch (JSONException e4) {
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, f3987a, "", e4);
                    }
                }
            } catch (JSONException e5) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, f3987a, "", e5);
            }
        }
        return true;
    }

    public static String a(u uVar, String str, String str2) throws AdobeAssetException {
        String str3;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean a2 = uVar.a(byteArrayOutputStream, str);
        try {
            byteArrayOutputStream.close();
        } catch (IOException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, f3987a, "", e2);
        }
        try {
            str3 = byteArrayOutputStream.toString("UTF-8");
        } catch (UnsupportedEncodingException e3) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, f3987a, "", e3);
            str3 = null;
        }
        if (a2) {
            return str3;
        }
        if (str3 != null && str3.indexOf(str2) != -1) {
            throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorUnexpectedResponse, "Multipart parsing error");
        }
        if (uVar.a((OutputStream) null, str2)) {
            throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorUnexpectedResponse, "Multipart parsing error");
        }
        return null;
    }

    public static String a(String str) throws AdobeAssetException {
        Matcher matcher = Pattern.compile("Content-ID:.*<(.*)>", 2).matcher(str);
        ArrayList arrayList = new ArrayList();
        while (matcher.find()) {
            arrayList.add(matcher.group(1));
        }
        if (arrayList.size() == 1) {
            return (String) arrayList.get(0);
        }
        throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorUnexpectedResponse, "Cannot find content id header");
    }

    private static String a(String str, HashMap<String, String> hashMap, String str2) throws AdobeAssetException {
        String str3 = hashMap.get(str);
        if (str3 == null) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f3987a, "path not found for " + str);
            return null;
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f3987a, "path : " + str3);
        File file = new File(str3);
        if (file.exists() && file.isDirectory()) {
            if (!"image/jpg".equalsIgnoreCase(str2) && !"image/jpeg".equalsIgnoreCase(str2)) {
                if ("image/png".equalsIgnoreCase(str2)) {
                    return new File(str3, String.format("%s.png", str)).toString();
                }
                if ("image/gif".equalsIgnoreCase(str2)) {
                    return new File(str3, String.format("%s.gif", str)).toString();
                }
                if ("image/tiff".equalsIgnoreCase(str2)) {
                    return new File(str3, String.format("%s.tiff", str)).toString();
                }
                if ("application/vnd.adobe.nnf".equalsIgnoreCase(str2)) {
                    return new File(str3, String.format("%s.nnf", str)).toString();
                }
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, f3987a, "unsupported content type " + str2 + " " + str2.compareToIgnoreCase("image/jpeg"));
                throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorUnexpectedResponse, "Unsupported content type header " + str2);
            }
            return new File(str3, String.format("%s.jpg", str)).toString();
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, f3987a, str3 + " exists: " + file.exists() + " isdir: " + file.isDirectory());
        return str3;
    }

    private static String a() {
        return com.adobe.creativesdk.foundation.internal.storage.model.util.i.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(JSONObject jSONObject) {
        this.f3990d = jSONObject;
    }
}
