package proect.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import proect.PV.Devices;

/**
 *<h1>About Util</h1>
 *<p>this class represnts utilizing regular match engine to search information.</p>
 *@author: Minglang.Tuo 
 *@version V1.0
 */

public class Regular_Match_Engine {
    private String output_info = "";


    /**
	 * the method is creating regular match engine for searching text.
	 * @param devices the all devices in dataset.
     * @param key the Search keywords.
	 */ 
    public void Text_matching(ArrayList<Devices> devices,String key){
        int count = 1;
        String content = "";
        String pattern = ".*"+key+".*";
        pattern = pattern.toLowerCase();

        for(Devices d:devices){
            content = d.self();
            String pattern_content = content.toLowerCase();
            boolean isMatch = Pattern.matches(pattern, pattern_content);
            if(isMatch){

                //System.out.println(d);
                output_info = output_info+count+"."+d.self_2()+"\n \n";
                count++;
                //System.out.println();
            }
            isMatch = false;
        }

        if(output_info.equals("")){
            output_info = "没有查询到有效信息。";
        }

    }

    /**
	 * the method is creating regular match engine for searching PV Capacity.
	 * @param devices the all devices in dataset.
     * @param key the Search keywords.
	 */ 
    public void Pv_Capacity_matching(ArrayList<Devices> devices,String key) {
        float value = Float.parseFloat(key);
        //int value_1 = (int) (value_2+0.5);
        //float value = (float) value_1;
        if (value >= 8.8 && value <= 1080) {

            boolean isMatch = false;
            for (int i = 0; i < devices.size(); i++) {
                if (value >= devices.get(i).get_lower_value() && value <= devices.get(i).get_upper_value()) {
                    isMatch = true;
                    devices.get(i).setInput_Pv_Capacity(key);
                    devices.get(i).getInverterratio();
                    //System.out.println(devices.get(i));
                    output_info = devices.get(i).toString();
                    //System.out.println();
                } else if (value >= devices.get(i).get_upper_value() && value < devices.get(i + 1).get_lower_value()) {
                    isMatch = true;
                    devices.get(i + 1).setInput_Pv_Capacity(key);
                    devices.get(i + 1).getInverterratio();
                    //System.out.println(devices.get(i + 1));
                    output_info = devices.get(i+1).toString();
                    //System.out.println();
                }

            }



        }else{
            output_info = "没有查询到有效信息。";
        }
    }
    
    
    public String getString(){
        return output_info;
    }
    
    public void clear(){
        this.output_info = "";
    }



}
