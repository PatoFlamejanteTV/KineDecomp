package com.nexstreaming.app.general.tracelog;

import com.nexstreaming.app.general.tracelog.TLP;

/* loaded from: classes2.dex */
public class CpLoginInfoResponse implements TLP.BaseResponse {
    private int result = -1;
    public long log_date = 0;

    @Override // com.nexstreaming.app.general.tracelog.TLP.BaseResponse
    public int getResult() {
        return this.result;
    }
}
