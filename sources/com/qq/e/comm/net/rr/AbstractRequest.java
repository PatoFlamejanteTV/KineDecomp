package com.qq.e.comm.net.rr;

import android.net.Uri;
import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.util.StringUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.NameValuePair;

/* loaded from: classes3.dex */
public abstract class AbstractRequest implements Request {

    /* renamed from: b */
    private int f25028b;

    /* renamed from: c */
    private int f25029c;

    /* renamed from: d */
    private int f25030d;

    /* renamed from: e */
    private String f25031e;
    private Request.Method j;
    private byte[] k;
    private ArrayList<NameValuePair> l;

    /* renamed from: a */
    private boolean f25027a = true;

    /* renamed from: f */
    private Map<String, String> f25032f = new HashMap();

    /* renamed from: g */
    private Map<String, String> f25033g = new HashMap();

    /* renamed from: h */
    private Map<String, String> f25034h = Collections.unmodifiableMap(this.f25032f);
    private Map<String, String> i = Collections.unmodifiableMap(this.f25033g);

    public AbstractRequest(String str, Request.Method method, byte[] bArr) {
        this.f25031e = str;
        this.j = method;
        this.k = bArr == null ? null : (byte[]) bArr.clone();
    }

    public AbstractRequest(String str, ArrayList<NameValuePair> arrayList, Request.Method method) {
        this.f25031e = str;
        this.j = method;
        this.l = arrayList;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public void addHeader(String str, String str2) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2)) {
            return;
        }
        this.f25032f.put(str, str2);
    }

    @Override // com.qq.e.comm.net.rr.Request
    public void addQuery(String str, String str2) {
        this.f25033g.put(str, str2);
    }

    @Override // com.qq.e.comm.net.rr.Request
    public int getConnectionTimeOut() {
        return this.f25029c;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public Map<String, String> getHeaders() {
        return this.f25034h;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public Request.Method getMethod() {
        return this.j;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public byte[] getPostData() throws Exception {
        return this.k;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public ArrayList<NameValuePair> getPostDataList() {
        return this.l;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public int getPriority() {
        return this.f25028b;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public Map<String, String> getQuerys() {
        return this.i;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public int getSocketTimeOut() {
        return this.f25030d;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public String getUrl() {
        return this.f25031e;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public String getUrlWithParas() {
        if (getQuerys().isEmpty()) {
            return getUrl();
        }
        Uri.Builder buildUpon = Uri.parse(getUrl()).buildUpon();
        for (Map.Entry<String, String> entry : getQuerys().entrySet()) {
            buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        return buildUpon.build().toString();
    }

    @Override // com.qq.e.comm.net.rr.Request
    public boolean isAutoClose() {
        return this.f25027a;
    }

    public void setAutoClose(boolean z) {
        this.f25027a = z;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public void setConnectionTimeOut(int i) {
        this.f25029c = i;
    }

    public void setPriority(int i) {
        this.f25028b = i;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public void setSocketTimeOut(int i) {
        this.f25030d = i;
    }
}
