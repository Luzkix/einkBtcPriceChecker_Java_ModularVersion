package com.example.einkbitcoinpriceticker.services;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class JsonServiceImpl implements JsonService {

  @Override
  public JSONObject getJson(String currency) {
    try {

      URL url = new URL("https://api.pro.coinbase.com/products/BTC-"+currency+"/stats");

      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestProperty("User-Agent", "Mozilla/5.0");
      conn.setRequestProperty("Cache-Control","no-cache");
      conn.setRequestProperty("Cookie","coinbase_device_id=11406e7e-93f9-4418-b006-5ccd57d3b348");
      conn.setRequestProperty("Accept", "application/xml,text/xml,application/xhtml+xml");
      conn.setConnectTimeout(5000);
      conn.setReadTimeout(5000);
      conn.setRequestMethod("GET");

      //Getting the response code (expected 200)
      int responsecode = conn.getResponseCode();

      if (responsecode != 200) {
        System.out.println("Wrong HttpResponseCode from Coinbase: " + responsecode);
        throw new RuntimeException("Wrong HttpResponseCode from Coinbase: " + responsecode);
      } else {
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
          content.append(inputLine);
        }
        in.close();
        conn.disconnect();

        //Parse the string into a json object
        JSONObject jsonObject = new JSONObject(content.toString());
        System.out.println(jsonObject);

        return jsonObject;
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
