package iptv.programme.rest;

import java.util.HashMap;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import iptv.programme.pojo.Programme;

/**
 * 
 * @author bhawani.singh
 *
 */
@Path("programme")
public class ProgrammeREST {
	
	@SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getLogger(ProgrammeREST.class.getName());
	
	private static HashMap<String,Programme> programmes = new HashMap<String,Programme>();	
	
	static {
		int progDuration=0;
		for(int i=0; i<=100; i++){
			int val = i%4;			
			switch(val){
			case 0:
				progDuration = 5;
				break;
			case 1:
				progDuration = 10;
				break;
			case 2:
				progDuration = 20;
				break;
			case 3:
				progDuration = 30;
			}
			programmes.put(""+i, new Programme(""+i, "PROGRAMME"+i, progDuration));
		}
		
	}	
	

	@GET
	@Path("{id}")
    @Produces({"application/json"})
    public Programme find(@PathParam("id") String id) {
		LOGGER.info("ProgramREST.record() id = " + id);
		return programmes.get(id);
	}
	
	@GET
	@Path("hi")
    @Produces({"application/xml", "application/json"})
    public String hi() {
		LOGGER.info("ProgramREST.hi()");
		return "Hello Bhawani !!!";
	}


}
