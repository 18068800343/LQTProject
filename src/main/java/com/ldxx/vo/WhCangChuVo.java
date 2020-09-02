package com.ldxx.vo;

import com.ldxx.bean.WhCangchu;
import com.ldxx.bean.WhWarehouseCount;

public class WhCangChuVo extends WhCangchu {
    WhWarehouseCount whWarehouseCount;

    public WhWarehouseCount getWhWarehouseCount() {
        return whWarehouseCount;
    }

    public void setWhWarehouseCount(WhWarehouseCount whWarehouseCount) {
        this.whWarehouseCount = whWarehouseCount;
    }
}
