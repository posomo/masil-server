package com.posomo.masil.query.map;

import com.posomo.masil.query.map.dto.MapFilterRequest;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

public class FilterQueryBuilder {
  public String buildFilter(MapFilterRequest req){
    SQL query = new SQL() {
      {
      SELECT("b.id, b.name, b.common_address, b.category");
      FROM("bar b");
      JOIN("bar_keyword bk ON b.vendor_id = bk.bar_vendor_id");
      }
    };
    query.WHERE("ST_DISTANCE_SPHERE(POINT("+req.getLatitude()+","+req.getLongitude()+")" +
            ",POINT(b.latitude,b.longitude))<=3000").AND();

    List<String> keywords = req.getKeywords();
    List<String> drinkCategories = req.getDrinkCategories();
    List<String> barCategories = req.getBarCategories();
    for(String s : barCategories)
      query.WHERE("b.category='"+s+"'").OR();
    for(int i=0;i<keywords.size();i++)
      if(i!=keywords.size()-1)
        query.WHERE("bk.name='"+keywords.get(i)+"'").OR();
      else
        query.WHERE("bk.name='"+keywords.get(i)+"'");
    query.GROUP_BY("b.vendor_id");

    query.OFFSET(req.getOffset()).FETCH_FIRST_ROWS_ONLY(req.getLimit());
    return query.toString();
  }
}
