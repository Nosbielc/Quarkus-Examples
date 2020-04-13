package com.nosbielc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Cleibson Gomes (https://github.com/Nosbielc) ON 09/04/2020
 * @project Quarkus-Examples
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private String name;

    private BigDecimal vlr;
}
