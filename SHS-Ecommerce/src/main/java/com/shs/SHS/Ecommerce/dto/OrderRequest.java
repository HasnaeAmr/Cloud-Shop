package com.shs.SHS.Ecommerce.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shs.SHS.Ecommerce.entity.Payment;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderRequest {

    private Double totalPrice;
    //private List<OredrItemRequest> Items;
    private Payment paymentInfos;
}
