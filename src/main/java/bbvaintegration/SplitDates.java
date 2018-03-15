package bbvaintegration;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;

public class SplitDates extends AbstractMessageTransformer{

	@Override
	public Object transformMessage(MuleMessage m, String outputEncoding) throws TransformerException {
		// TODO Auto-generated method stub

		System.out.println(m.getPayload());
		//Map<String,String> myDetails =  (Map<String,String>) m.getPayload();
		//System.out.println(myDetails);
		String data = m.getProperty("http.query.string",PropertyScope.INBOUND);
		String first = data.split("&")[0];
		String second = data.split("&")[1];
		
		String a = first.split("=")[1];
		String b = second.split("=")[1];
		
		m.setProperty("date_from", a,PropertyScope.SESSION);
		m.setProperty("date_to", b,PropertyScope.SESSION);
		
		System.out.println(a);
		System.out.println(b);
		
		
		return m;
	}

}
