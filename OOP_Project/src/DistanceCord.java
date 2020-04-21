
public class DistanceCord {

	double getDist(String lat1,String lon1,String lat2,String lon2) {
		double d=0;
		double lt1 = Double.parseDouble(lat1); double lt2 = Double.parseDouble(lat2);
        double ln1 = Double.parseDouble(lon1); double ln2 = Double.parseDouble(lon2);
        double dlat=Math.toRadians(lt2-lt1); double dlon=Math.toRadians(ln2-ln1);
        lt1=Math.toRadians(lt1);  lt2=Math.toRadians(lt2);
        double y= (Math.sin(dlon/2)); double x= (Math.sin(dlat/2));
        double a = Math.pow(x,2.0) + Math.cos(lt1) * Math.cos(lt2) * Math.pow(y,2.0);
        double c = 2.0 * Math.atan2(Math.sqrt(a), Math.sqrt(1.0-a));
        d = 6373 * c;
		return d;
	}
}
