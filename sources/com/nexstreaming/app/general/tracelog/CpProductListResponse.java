package com.nexstreaming.app.general.tracelog;

import com.nexstreaming.app.general.iab.Product;
import com.nexstreaming.app.general.tracelog.TLP;
import java.util.List;

/* loaded from: classes.dex */
public class CpProductListResponse implements TLP.BaseResponse {
    private int result = -1;
    public long log_date = 0;
    private List<Product> list = null;

    @Override // com.nexstreaming.app.general.tracelog.TLP.BaseResponse
    public int getResult() {
        return this.result;
    }

    public List<Product> getList() {
        return this.list;
    }
}
