package info.staturtweets.Mersal_geo;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MyCustomBaseAdapter extends BaseAdapter {
  private static ArrayList<enc_message> searchArrayList;
  
  private LayoutInflater mInflater;
  
  public MyCustomBaseAdapter(Context paramContext, ArrayList<enc_message> paramArrayList) {
    searchArrayList = paramArrayList;
    this.mInflater = LayoutInflater.from(paramContext);
  }
  
  public int getCount() {
    return searchArrayList.size();
  }
  
  public Object getItem(int paramInt) {
    return searchArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder;
    if (paramView == null) {
      paramView = this.mInflater.inflate(2130903041, null);
      viewHolder = new ViewHolder();
      viewHolder.txtName = (TextView)paramView.findViewById(2131099653);
      viewHolder.txtCityState = (TextView)paramView.findViewById(2131099654);
      viewHolder.txtPhone = (TextView)paramView.findViewById(2131099655);
      paramView.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder)paramView.getTag();
    } 
    viewHolder.txtName.setText(((enc_message)searchArrayList.get(paramInt)).getDate());
    if (((enc_message)searchArrayList.get(paramInt)).getRead())
      viewHolder.txtName.setTextColor(Color.rgb(140, 140, 0)); 
    viewHolder.txtCityState.setText(String.valueOf(((enc_message)searchArrayList.get(paramInt)).getLng()) + "," + ((enc_message)searchArrayList.get(paramInt)).getLat());
    viewHolder.txtPhone.setText(get_preview(((enc_message)searchArrayList.get(paramInt)).getMessage()));
    return paramView;
  }
  
  public String get_preview(String paramString) {
    String str = (new StringTokenizer(paramString, "\n")).nextToken();
    paramString = str;
    if (str.length() > 45)
      paramString = str.substring(0, 44); 
    return paramString;
  }
  
  static class ViewHolder {
    TextView txtCityState;
    
    TextView txtName;
    
    TextView txtPhone;
  }
}


/* Location:              D:\geoo\dex-tools-2.1\classes-dex2jar.jar!\info\staturtweets\Mersal_geo\MyCustomBaseAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */