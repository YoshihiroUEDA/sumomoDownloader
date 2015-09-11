import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TBinaryFileDownloader {
	URL url ;
	HttpURLConnection urlcon;
	
	public TBinaryFileDownloader(String paramUrl){
		try {
			url = new URL( paramUrl	);
			urlcon = (HttpURLConnection) url.openConnection();
			urlcon.setInstanceFollowRedirects(false);
			urlcon.setRequestMethod("GET");
			urlcon.setRequestProperty("Accept-Language", "ja;q=0.7,en;q=0.3");
			urlcon.connect();
			Map<String, List<String>> headers = urlcon.getHeaderFields();
			Iterator<String> it = headers.keySet().iterator();
			System.out.println("response header:");
			while (it.hasNext()) {
				String key = (String) it.next();
				System.out.println(" " + key + headers.get(key));
			}

			System.out.println("response code[" + urlcon.getResponseCode() + "]");
			System.out.println("response message[" + urlcon.getResponseMessage() + "]");
			System.out.println("\n---body----");
			
			//	here in download code
			
			
			
			//	
			
			urlcon.disconnect();
			urlcon = null;
			url = null;

			System.out.println( "Program terminated.");
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void done(){
		
	}
	
}
