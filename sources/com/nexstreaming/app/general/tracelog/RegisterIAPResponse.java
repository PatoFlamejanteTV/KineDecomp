package com.nexstreaming.app.general.tracelog;

import com.nexstreaming.app.general.tracelog.TLP;

/* loaded from: classes.dex */
public class RegisterIAPResponse implements TLP.BaseResponse {
    public int result;

    @Override // com.nexstreaming.app.general.tracelog.TLP.BaseResponse
    public int getResult() {
        return this.result;
    }

    public ResponseCode getResponseCode() {
        return ResponseCode.fromValue(this.result);
    }
}
