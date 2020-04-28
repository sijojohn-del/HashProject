package com.share2people.utils;

import static com.share2people.utils.DataReadWrite.getProperty;

/**
 * This class reads the PageObjectRepository text files. Uses buffer reader.
 *
 * @author nimit.jain
 *
 */
public class ConfigFileReader {

    static String tier;
    static String timeout;   
    static Boolean logtoconsole;
    
    
    public enum Tiers {
    	cert,CERT,qa,QA,staging, stage,STAGE,STAGING,
    	production,prod,PROD,PRODUCTION,
    }
    
    
    private static void setTier() {
    	tier = getProperty("Config.properties", "tier");
	    switch (Tiers.valueOf(tier)) {
	        case STAGE:
            case stage:
            case staging:
            case STAGING:
                tier = "STAGE";
                break;
            case prod:
            case PROD:
            case production:
            case PRODUCTION:
                tier = "PROD";
                break;
            case qa:
            case QA:
            	tier = "QA";
            	break;
            case cert:
            case CERT:
            	 tier = "CERT";
            	 break;
          default:
			tier = "STAGE";
			break;
	     }
    }
    
    public static String getTier(){
    	setTier();
    	return tier;
    }

    public static String getTimeOut() {
		timeout = getProperty("timeout");
		return timeout;
	}
    
    public static Boolean getLogToConsole() {
		logtoconsole = Boolean.valueOf(getProperty("Config.properties","logtoconsole"));
		return logtoconsole;
	}
}
