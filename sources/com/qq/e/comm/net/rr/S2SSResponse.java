package com.qq.e.comm.net.rr;

import com.qq.e.comm.net.rr.a;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;

/* loaded from: classes3.dex */
public class S2SSResponse extends AbstractResponse {
    public S2SSResponse(HttpResponse httpResponse, HttpUriRequest httpUriRequest) {
        super(httpResponse, httpUriRequest);
    }

    @Override // com.qq.e.comm.net.rr.AbstractResponse, com.qq.e.comm.net.rr.Response
    public byte[] getBytesContent() throws IllegalStateException, IOException {
        try {
            return a.b(super.getBytesContent());
        } catch (a.b e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
