package tigo.com.bo.proxyondemand.beans;

import java.util.List;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import tigo.com.bo.proxyondemand.Ondemand;
import tigo.com.bo.proxyondemand.OndemandResponse;

public class CamelProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
        OndemandResponse out = new OndemandResponse();
        List soaList = exchange.getIn().getBody(List.class);
        Ondemand ondemand= (Ondemand) soaList.get(0);
        
        out.setOut("msisdn " + ondemand.getMsisdn().toString()+" codigo " + ondemand.getCodigo().toString());
        exchange.getOut().setBody(out);
    }

}