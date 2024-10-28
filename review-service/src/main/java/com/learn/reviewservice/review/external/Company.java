package com.learn.reviewservice.review.external;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author anthonylee
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    private Long id;
    private String name;
    private String description;
}
