package com.trungnguyen.springmail.mapper;

import com.trungnguyen.springmail.domain.RpKpiCbclDaily;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RpKpiCbclDailyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SMARTW.RP_KPI_CBCL_DAILY
     *
     * @mbg.generated Sat Apr 30 18:07:22 ICT 2022
     */
    int insert(RpKpiCbclDaily record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SMARTW.RP_KPI_CBCL_DAILY
     *
     * @mbg.generated Sat Apr 30 18:07:22 ICT 2022
     */
    List<RpKpiCbclDaily> selectAll();
}