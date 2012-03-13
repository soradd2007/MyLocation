package cn.com.do1;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyLocationActivity extends Activity {
    /** Called when the activity is first created. */
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	        //getGPS();
	        final Button passingButton = (Button) findViewById(R.id.passingButton);
	        passingButton.setOnClickListener(new Button.OnClickListener() {
	        	public void onClick(View v){
	        		getGPS();
	        	}
	        });
	    }
	    
	    public void getGPS(){
	    	// 获取位置管理服务
	        LocationManager locationManager;
	        String serviceName = Context.LOCATION_SERVICE;
	        locationManager = (LocationManager) this.getSystemService(serviceName);
	    	
	    	// 查找到服务信息
	        Criteria criteria = new Criteria();
	        criteria.setAccuracy(Criteria.ACCURACY_FINE); // 高精度
	        criteria.setAltitudeRequired(false);
	        criteria.setBearingRequired(false);
	        criteria.setCostAllowed(true);
	        criteria.setPowerRequirement(Criteria.POWER_LOW); // 低功耗
	    	
	        String provider = locationManager.getBestProvider(criteria, true); // 获取GPS信息
	        Location location = locationManager.getLastKnownLocation(provider); // 通过GPS获取位置
	    	
	        
	        showLocation(location);
	    	
	    	
	    	/*locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,  
	      			 1000, 0, locationListener);*/
	    }
	    
	    private void showLocation(Location location){
	    	/*latitude = location.getLatitude();     //经度  
	    	longitude = location.getLongitude(); //纬度  
	    	altitude =  location.getAltitude();     //海拔 
	*/    	
	    	TextView latitudeTextView = (TextView)findViewById(R.id.latitudevalue);
	        TextView longitudeTextView = (TextView)findViewById(R.id.longitudevalue);
	        TextView altitudeTextView = (TextView)findViewById(R.id.altitudevalue);
	        
	        latitudeTextView.setText(String.valueOf(location.getLatitude()));	//经度  
	        longitudeTextView.setText(String.valueOf(location.getLongitude()));	//纬度  
	        altitudeTextView.setText(String.valueOf(location.getAltitude()));	//海拔
	    }
	    
	/*    private final LocationListener locationListener = new LocationListener() {  
	        public void onLocationChanged(Location location) { 
	        	//当坐标改变时触发此函数，如果Provider传进相同的坐标，它就不会被触发  
	            // log it when the location changes  
	            if (location != null) {  
	            	latitude = location.getLatitude();     //经度  
	            	longitude = location.getLongitude(); //纬度  
	            	altitude =  location.getAltitude();     //海拔 
	            	
	            	
	            	TextView latitudeTextView = (TextView)findViewById(R.id.latitudevalue);
	                TextView longitudeTextView = (TextView)findViewById(R.id.longitudevalue);
	                TextView altitudeTextView = (TextView)findViewById(R.id.altitudevalue);
	                
	                latitudeTextView.setText(String.valueOf(latitude));
	                longitudeTextView.setText(String.valueOf(longitude));
	                altitudeTextView.setText(String.valueOf(altitude)); 
	            }  
	        }  
	      
	        public void onProviderDisabled(String provider) {  
	        // Provider被disable时触发此函数，比如GPS被关闭  
	        }  
	      
	        public void onProviderEnabled(String provider) {  
	        //  Provider被enable时触发此函数，比如GPS被打开  
	        }  
	      
	        public void onStatusChanged(String provider, int status, Bundle extras) {  
	        // Provider的转态在可用、暂时不可用和无服务三个状态直接切换时触发此函数  
	        }  
	    }; */
}