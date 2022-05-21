package com.ganga.dao;

import com.ganga.pojo.Brand;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BrandRepository extends ElasticsearchRepository<Brand,String> {
}
