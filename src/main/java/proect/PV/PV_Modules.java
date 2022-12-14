package proect.PV;

import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

/**
 *this class represents the content of PV_Modules
 * @author Minglang.Tuo
 * @version V1.0
 */
public class PV_Modules {
    /**
     * design a PV_Modules(devices) by using ArrayList 
     */
    
    private ArrayList<Devices> pv_modules;
    public Map<String,Devices> map = new HashMap<String,Devices>();

    /**
	 * construct method without parameters.
	 */
    public PV_Modules(){
   
        pv_modules = new ArrayList<Devices>();
    }

    /**
	 * construct method with parameters
	 * @param devices a ArrayList that stores PV_Modules(devices).
	 */
    public PV_Modules(ArrayList<Devices> devices){
        this.pv_modules = devices;

    }


    /**
	 * get the list of devices.
	 * @return the linked list.
	 */
    public ArrayList<Devices> getAllDevices(){
        return this.pv_modules;
    }

    /**
	 * the method is merge the same devices in the PV_Modules based on Scheme_No.
	 * @param PV_Modules(devices) all of the users in the tweet.
     * @return return the new ArrayList of devices(without the same)
	 */
    public ArrayList<Devices>mergeDevices(ArrayList<Devices> devices){
        for(Devices d:devices){
            d.index_self();
            d.get_lower_upper_value();
            String key = d.getScheme_No();
            if(map.containsKey(key)){
                Devices device = map.get(key);
                String new_Device_No = device.getDevice_No();
                int new_Power = device.getPower();
                d.addDevice_No(new_Device_No);
                d.addPower(new_Power);
            }
            map.put(key,d);
        }
        devices.clear();
        devices.addAll(map.values());
        Collections.sort(devices);
        return devices;
    }



    
}











    





