package com.v.train.domain.passenger.model.aggregates;

import com.v.train.domain.passenger.model.entity.PassengerEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PassengerAggregate {

    /**
     * 会员id
     */
    private long memberId;

    /**
     * 乘车人
     */
    private PassengerEntity passenger;


}
