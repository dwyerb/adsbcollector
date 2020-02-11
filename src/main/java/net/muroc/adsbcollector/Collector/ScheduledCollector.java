package net.muroc.adsbcollector.Collector;

import java.io.InputStreamReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.*;

import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import java.io.IOException;
import java.util.List;

import net.muroc.adsbcollector.domain.AircraftMessages;
import net.muroc.adsbcollector.domain.FlightPoint;

@Component
public class ScheduledCollector {

    @Value("${adsb.source}")
    private String adsbSourceURL;

    @Value("${adsb.rest}")
    private String adsbTargetURL;

    @Scheduled(fixedRate = 1000)
    public void fixedRateCollector()
    {
        InputStream source = retrieveStream(adsbSourceURL);
        Gson gson = new Gson();
        Reader reader = new InputStreamReader(source);
        AircraftMessages messages = gson.fromJson(reader, AircraftMessages.class);
        List<FlightPoint> inputFlightPoints = messages.aircraft;
        System.out.println(inputFlightPoints.size());
        /*
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Fixed Rate: " + adsbSourceURL + strDate);
        */
    }

    private static InputStream retrieveStream(String url)
    {
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet getRequest = new HttpGet(url);
        try {
            HttpResponse getResponse = client.execute(getRequest);
            final int statusCode = getResponse.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                //Log.w(getClass().getSimpleName(),
                //       "Error " + statusCode + " for URL " + url);
                return null;
            }
            HttpEntity getResponseEntity = getResponse.getEntity();
            return getResponseEntity.getContent();
        }
        catch (IOException e) {
            getRequest.abort();
            //Log.w(getClass().getSimpleName(), "Error for URL " + url, e);
        }
        return null;
    }
}
