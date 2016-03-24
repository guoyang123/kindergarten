package com.squareup.customviews;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import com.squareup.interfaces.OnClickOtherDateListener;
import com.squareup.timessquare.CalendarCellDecorator;
import com.squareup.timessquare.CalendarCellView;
import com.squareup.timessquare.CalendarRowView;
import com.squareup.timessquare.MonthCellDescriptor;
import com.squareup.timessquare.MonthDescriptor;
import com.squareup.timessquare.utils.TimeUtils;
import com.squareup.viewsxml.MonthXml;

public class MonthXmlView extends MonthXml {

	public MonthXmlView(Context context, float pro, float screenW, float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}

	  public static MonthXmlView view=null;
	  public Listener listener;
	  public List<CalendarCellDecorator> decorators;
	  public boolean isRtl;

	  public static MonthXmlView create(Context context,float pro,float screenW,float screenH,
		      DateFormat weekdayNameFormat, Listener listener, Calendar today, int dividerColor,
		      int dayBackgroundResId, int dayTextColorResId, int titleTextColor, boolean displayHeader,
		      int headerTextColor, List<CalendarCellDecorator> decorators, Locale locale) 
	  {
		  return create(context,pro,screenW,screenH,
					weekdayNameFormat, listener, today, dividerColor,
	                dayBackgroundResId, dayTextColorResId, titleTextColor, displayHeader,
	                headerTextColor, decorators, locale,null);
	  }
	  public static MonthXmlView create(Context context,float pro,float screenW,float screenH,
		      DateFormat weekdayNameFormat, Listener listener, Calendar today, int dividerColor,
		      int dayBackgroundResId, int dayTextColorResId, int titleTextColor, boolean displayHeader,
		      int headerTextColor, List<CalendarCellDecorator> decorators, Locale locale,OnClickOtherDateListener onClickOtherDateListener) {
		    view =  new MonthXmlView(context,pro,screenW,screenH);
		 //   view.calTitleView.setListener(onClickOtherDateListener);
		    view.setDividerColor(dividerColor);
		    view.setDayTextColor(dayTextColorResId);//
		    view.setTitleTextColor(titleTextColor);
		    view.setDisplayHeader(displayHeader);
		    view.setHeaderTextColor(headerTextColor);
		    if (dayBackgroundResId != 0) {
		      view.setDayBackground(dayBackgroundResId);
		    }
		  
		    final int originalDayOfWeek = today.get(Calendar.DAY_OF_WEEK);
		    
		    view.isRtl = isRtl(locale);
		    int firstDayOfWeek = today.getFirstDayOfWeek();
		    final CalendarRowView headerRow = (CalendarRowView) view.rowView;
		    headerRow.setVisibility(view.GONE);
		    for (int offset = 0; offset < 7; offset++) {
		      today.set(Calendar.DAY_OF_WEEK, getDayOfWeek(firstDayOfWeek, offset, view.isRtl));
		      final TextView textView = (TextView) headerRow.getChildAt(offset);
		      textView.setText(weekdayNameFormat.format(today.getTime()));
		      if(offset==0||offset==6)
		      {
		    	   textView.setTextColor(Color.parseColor("#f28288"));   
		      }
		      
		    }
		    today.set(Calendar.DAY_OF_WEEK, originalDayOfWeek);
		    view.listener = listener;
		    view.decorators = decorators;
		    return view;
		  }

	  private static int getDayOfWeek(int firstDayOfWeek, int offset, boolean isRtl) {
	    int dayOfWeek = firstDayOfWeek + offset;
	    if (isRtl) {
	      return 8 - dayOfWeek;
	    }
	    return dayOfWeek;
	  }

	  private static boolean isRtl(Locale locale) {
	    // TODO convert the build to gradle and use getLayoutDirection instead of this (on 17+)?
	    final int directionality = Character.getDirectionality(locale.getDisplayName(locale).charAt(0));
	    return directionality == Character.DIRECTIONALITY_RIGHT_TO_LEFT
	        || directionality == Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC;
	  }

	 

	  public void setDecorators(List<CalendarCellDecorator> decorators) {
	    this.decorators = decorators;
	  }

	  public List<CalendarCellDecorator> getDecorators() {
	    return decorators;
	  }



	  public void init(MonthDescriptor month, List<List<MonthCellDescriptor>> cells,
	      boolean displayOnly, Typeface titleTypeface, Typeface dateTypeface) {
	    long start = System.currentTimeMillis();
	    
	    view.calTitleView.title.setText(month.getLabel());

	    final int numRows = cells.size();
	    view.calendar_grid.setNumRows(numRows);
	    for (int i = 0; i < 6; i++) {
	      CalendarRowView weekRow = (CalendarRowView) view.calendar_grid.getChildAt(i + 1);
//	      weekRow.setListener(listener);
	      if (i < numRows) {
	        weekRow.setVisibility(VISIBLE);
	        List<MonthCellDescriptor> week = cells.get(i);
	       long currentTime= System.currentTimeMillis();
	        for (int c = 0; c < week.size(); c++) {
	          MonthCellDescriptor cell = week.get(isRtl ? 6 - c : c);
	          CalendarCellView cellView = (CalendarCellView) weekRow.getChildAt(c);

	          String cellDate = Integer.toString(cell.getValue());
	         // Log.e("buzz1", "cell.getValue():"+cell.getValue());
	          
	          if(TimeUtils.isWeekEnd(cell.getDate())&&currentTime<cell.getDate().getTime())
	          {
	        	  cellView.setTextColor(Color.parseColor("#f28288"));
	          }
	          if (!cellView.getText().equals(cellDate))
	          {
	        	  cellView.setText(cellDate);
	          }
	          cellView.setEnabled(cell.isCurrentMonth());
	          cellView.setClickable(!displayOnly);

	          cellView.setSelectable(cell.isSelectable());
	          cellView.setSelected(cell.isSelected());
	          cellView.setCurrentMonth(cell.isCurrentMonth());
	          if(!cell.isCurrentMonth())
	          {
	        	  cellView.setVisibility(View.INVISIBLE);
	          }else
	          {
	        	  cellView.setVisibility(View.VISIBLE);
	          }
	          cellView.setToday(cell.isToday());
	          if(cell.isToday())
	          {
	        	  cellView.setBackgroundColor(Color.parseColor("#1da3fc"));
	          }
	          else 
	          {
	        	  cellView.setBackgroundColor(Color.parseColor("#ffffff"));//未被选择的所有天数的背景颜色
	          }
	          cellView.setRangeState(cell.getRangeState());
	          cellView.setHighlighted(cell.isHighlighted());
	          cellView.setTag(cell);

	          if (null != decorators) {
	            for (CalendarCellDecorator decorator : decorators) {
	              decorator.decorate(cellView, cell.getDate());
	            }
	          }
	        }
	      } else {
	        weekRow.setVisibility(GONE);
	      }
	    }

	    if (titleTypeface != null) {
	      view.calTitleView.title.setTypeface(titleTypeface);
	    }
	    if (dateTypeface != null) {
	    	view.calendar_grid.setTypeface(dateTypeface);
	    }

	  }

	  public void setDividerColor(int color) {
		  view.calendar_grid.setDividerColor(color);
	  }

	  public void setDayBackground(int resId) {
		  view.calendar_grid.setDayBackground(resId);
	  }

	  public void setDayTextColor(int resId) {
		  view.calendar_grid.setDayTextColor(resId);
	  }

	  public void setTitleTextColor(int color) {
	    view.calTitleView.title.setTextColor(color);
	  }

	  public void setDisplayHeader(boolean displayHeader) {
		  view.calendar_grid.setDisplayHeader(displayHeader);
	  }

	  public void setHeaderTextColor(int color) {
		  view.calendar_grid.setHeaderTextColor(color);
	  }

	  public interface Listener {
	    void handleClick(MonthCellDescriptor cell);
	  }
}
