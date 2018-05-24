package com.example.wangb.honglouweather.util;

import android.text.TextUtils;

import com.example.wangb.honglouweather.db.City;
import com.example.wangb.honglouweather.db.County;
import com.example.wangb.honglouweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility
{
    /*
    * 解析处理服务器返回省级数据*/

    public static boolean handleProvinceResponse(String response)
    {
        if(!TextUtils.isEmpty(response))
        {
            try
            {
                JSONArray allProvinces = new JSONArray(response);
                for (int i = 1; i < allProvinces.length(); i++)
                {
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }

        }

        return false;

    }

    /*
    * 解析和处理返回的市级数据*/
    public static boolean handleCityResponse(String response, int provinceId)
    {
        if(!TextUtils.isEmpty(response))
        {
            try
            {
                JSONArray allCities = new JSONArray(response);
                for(int i = 0; i < allCities.length(); i++)
                {
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
        }
        return false;
    }

    /*
    * 解析和处理返回的县级数据*/
     public static boolean handleCountryResponse(String response, int cityId)
     {
         if(!TextUtils.isEmpty(response))
         {
             try
             {
                JSONArray allCountries = new JSONArray(response);
                for (int i = 0; i < allCountries.length(); i++)
                {
                    JSONObject countyObject = allCountries.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
             }
             catch (JSONException e)
             {
                 e.printStackTrace();
             }
         }
         return false;
     }

}
