package com.v.train.business.mapper.cust;

import java.util.Date;

public interface SkTokenMapperCust {

    int decrease(Date date, String trainCode, int decreaseCount);
}
