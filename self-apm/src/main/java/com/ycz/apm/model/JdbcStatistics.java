package com.ycz.apm.model;
/**
 * @author ycz
 * @date 2020/9/26 5:23 PM
 */
public class JdbcStatistics extends Statistics {
    public String error;
    public String sql;
    public String jdbcUrl;

    public JdbcStatistics(String sql, String jdbcUrl) {
        this.sql = sql;
        this.jdbcUrl = jdbcUrl;
    }

    public JdbcStatistics() {
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

        @Override
        public String toString() {
                return "JdbcStatistics{" +
                        "error='" + error + '\'' +
                        ", sql='" + sql + '\'' +
                        ", jdbcUrl='" + jdbcUrl + '\'' +
                        '}'+super.toString();
        }
}