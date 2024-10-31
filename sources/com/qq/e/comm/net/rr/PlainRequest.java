package com.qq.e.comm.net.rr;

import com.qq.e.comm.net.rr.Request;
import java.util.ArrayList;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpUriRequest;

/* loaded from: classes3.dex */
public class PlainRequest extends AbstractRequest {
    public PlainRequest(String str, Request.Method method, byte[] bArr) {
        super(str, method, bArr);
    }

    public PlainRequest(String str, ArrayList<NameValuePair> arrayList, Request.Method method) {
        super(str, arrayList, method);
    }

    @Override // com.qq.e.comm.net.rr.Request
    public Response initResponse(HttpUriRequest httpUriRequest, HttpResponse httpResponse) {
        return new PlainResponse(httpResponse, httpUriRequest);
    }
}
