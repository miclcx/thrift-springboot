package com.intellif.jianyi.dao;

import com.intellif.jianyi.vo.SolrConfigInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SolrConfigDaoImpl implements SolrConfigDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<SolrConfigInfo> findAll() {
        String sql = "select * from t_solr_config_info";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(SolrConfigInfo.class));
    }

    @Override
    public int totalSolrConfigCount() {
        String sql = "select count(*) from t_solr_config_info";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public List<String> getSolrServerWithCameras() {
        String sql = "select distinct server_url from t_solr_config_info";
        return jdbcTemplate.queryForList(sql, String.class);
    }
}
