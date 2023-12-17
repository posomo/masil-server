package com.posomo.masil.query.map;

import com.posomo.masil.query.map.dto.MapFilterRequest;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

public class FilterQueryBuilder {
  public String buildFilter(MapFilterRequest filterRequest){
    SQL query = new SQL() {
      {
      SELECT("id, name");
      FROM("bar b");
      JOIN("bar_keyword bk ON b.vendor_id = bk.bar_vendor_id");
      }
    };
    List<String> keywords = filterRequest.getKeywords();
    List<String> drinkCategories = filterRequest.getDrinkCategories();
    List<String> barCategories = filterRequest.getBarCategories();
    for(String s : barCategories)
      query.WHERE("b.category='"+s+"'").OR();
    for(int i=0;i<keywords.size();i++)
      if(i!=keywords.size()-1)
        query.WHERE("bk.name='"+keywords.get(i)+"'").OR();
      else
        query.WHERE("bk.name='"+keywords.get(i)+"'");
    query.GROUP_BY("b.vendor_id");

    query.OFFSET(filterRequest.getOffset()).FETCH_FIRST_ROWS_ONLY(filterRequest.getLimit());
    return query.toString();
  }
}
