package com.example.wangb.honglouweather.db;

import org.litepal.crud.DataSupport;

public class Province extends DataSupport
{
    private int id;
    private String provinceName;
    private int provinceCode;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getProvinceName(int id)
    {
        return provinceName;
    }

    public void setProvinceName(String provinceName)
    {
        this.provinceName = provinceName;
    }

    public int getProvinceCode()
    {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode)
    {
        this.provinceCode = provinceCode;
    }

}