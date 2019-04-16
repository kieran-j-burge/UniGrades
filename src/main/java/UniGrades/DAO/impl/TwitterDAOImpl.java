package UniGrades.DAO.impl;

import UniGrades.DAO.TwitterDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class TwitterDAOImpl implements TwitterDAO{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TwitterDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String getTweetBgn(int i) {

         return jdbcTemplate.queryForObject("SELECT msg FROM tweet_msg_bgn WHERE id = ?",
                new Object[]{i},
                (rs, rowNum) -> rs.getString("msg"));
    }

    @Override
    public String getTweetMid(int i) {
        return jdbcTemplate.queryForObject("SELECT msg FROM tweet_msg_mid WHERE id = ?",
                new Object[]{i},
                (rs, rowNum) -> rs.getString("msg"));
    }

    @Override
    public String getTweetEnd(int i) {
        return jdbcTemplate.queryForObject("SELECT msg FROM tweet_msg_end WHERE id = ?",
                new Object[]{i},
                (rs, rowNum) -> rs.getString("msg"));
    }
}
