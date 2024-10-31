package com.nexstreaming.app.general.tracelog;

import com.nexstreaming.app.general.tracelog.TLP;

/* loaded from: classes2.dex */
public class RegisterAppResponse implements TLP.BaseResponse {
    public String message;
    public int result;
    public String url;
    public String url_type;

    public ResponseCode getResponseCode() {
        return ResponseCode.fromValue(this.result);
    }

    @Override // com.nexstreaming.app.general.tracelog.TLP.BaseResponse
    public int getResult() {
        return this.result;
    }
}
