package net.muroc.adsbcollector.Collector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.*;

import org.springframework.web.client.RestTemplate;

import net.muroc.adsbcollector.domain.AircraftMessages;
import net.muroc.adsbcollector.domain.FlightPoint;

@Component
public class ScheduledCollector {

    private static final Logger log = LoggerFactory.getLogger(ScheduledCollector.class);

   //set the url of the rasberri py where PiAware is running
   //this should be the /aircraft.json dump1090 output
    //see https://github.com/SDRplay/dump1090/blob/master/README-json.md
    @Value("${adsb.source}")
    private String adsbSourceURL;

    //set the endpoint for the spring boot rest api that will process the aircraft json into persistent storage.
    @Value("${adsb.rest}")
    private String adsbTargetURL;

    RestTemplate restTemplate = new RestTemplate();

    @Scheduled(fixedRate = 1000)
    public void fixedRateCollector()
    {
        AircraftMessages aircraftMessages = restTemplate.getForObject(adsbSourceURL, AircraftMessages.class);
        for(FlightPoint flightPoint: aircraftMessages.aircraft)
        {
            if( flightPoint.getHex()!=null && flightPoint.getFlight()!=null && flightPoint.getSquawk()!=null && flightPoint.getLat()!=0)
            {

                RestTemplate restPostTemplate = new RestTemplate();
                restPostTemplate.postForObject(adsbTargetURL, flightPoint,FlightPoint.class);
                log.info(flightPoint.getFlight());
            }

        }

    }
}
