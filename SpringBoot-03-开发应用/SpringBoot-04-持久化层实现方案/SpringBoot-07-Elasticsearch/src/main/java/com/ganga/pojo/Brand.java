package com.ganga.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "brands")
public class Brand {

    private String id;
    private String brandName;
    private String companyName;
    private Integer ordered;
    private String description;
    private Integer status;

}
