package com.gythtglxt.dao;

import com.gythtglxt.dataobject.MedRecordsDO;
import com.gythtglxt.dataobject.MedRecordsDOKey;

public interface MedRecordsDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_natmeha_med_records
     *
     * @mbg.generated Thu Nov 26 00:22:00 CST 2020
     */
    int deleteByPrimaryKey(MedRecordsDOKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_natmeha_med_records
     *
     * @mbg.generated Thu Nov 26 00:22:00 CST 2020
     */
    int insert(MedRecordsDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_natmeha_med_records
     *
     * @mbg.generated Thu Nov 26 00:22:00 CST 2020
     */
    int insertSelective(MedRecordsDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_natmeha_med_records
     *
     * @mbg.generated Thu Nov 26 00:22:00 CST 2020
     */
    MedRecordsDO selectByPrimaryKey(MedRecordsDOKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_natmeha_med_records
     *
     * @mbg.generated Thu Nov 26 00:22:00 CST 2020
     */
    int updateByPrimaryKeySelective(MedRecordsDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_natmeha_med_records
     *
     * @mbg.generated Thu Nov 26 00:22:00 CST 2020
     */
    int updateByPrimaryKey(MedRecordsDO record);
}