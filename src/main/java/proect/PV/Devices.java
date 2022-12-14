package proect.PV;

import java.util.Comparator;
/**
 *<h1>print the information about devices</h1>
 *<p>this class represnts the relevent information about device.</p>
 *@author: Minglang.Tuo 
 *@version V1.0
 */


public class Devices implements Comparable<Devices>{
    /**
    *represent the PV scheme for building.
    */
    private String Scheme_No;

    /**
     *represent the PV sorting.
     */
    private int Index;

    private float upper_value;

    private float lower_value;

    /**
    *represent the capacity of PV.
    */
    private String Pv_Capacity;

    /**
    *represent the Number of Devices.
    */
    private String Device_No;

    /**
    *represent the power of Devices.
    */
    private int Power;

    /**
     *represent the Pv_Capacity/Total_Power.
     */
    private String inverterratio;

    private String Transformer_No;


    /**
     *represent the Input_Pv_Capacity.
     */
    private String Input_Pv_Capacity = "None";




     /**
	 * construct method without parameters.
	 */
    public Devices(){}


    /**
	 * construct method with parameters.
	 * @param Scheme_No the PV scheme for the customers.
	 * @param Pv_Capacity Capacity of PV for the customers.
	 * @param Device_No the Number of Devices in PV scheme.
	 * @param Power the power of devices in the scheme.
	 */

     public Devices(String Scheme_No,String Pv_Capacity,String Device_No,int Power,String Transformer_No){
        this.Scheme_No = Scheme_No;
        this.Pv_Capacity = Pv_Capacity;
        this.Device_No = Device_No;
        this.Power = Power;
        this.Transformer_No = Transformer_No;
     }

     /**
	 * get the design scheme of the PVs.
	 * @return the number of the PV scheme.
	 */
    public String getScheme_No(){
        return Scheme_No;
    }


    /**
	 * get the capacity of the PVs.
	 * @return the range of the PV capacity.
	 */
    public String getPv_Capacity(){
        return Pv_Capacity;
    }

    public String getTransformer_No(){return Transformer_No;}


      /**
	 * get the ID of the device.
	 * @return the ID of the device.
	 */
    public String getDevice_No(){
        return Device_No;
    }

      /**
	 * add the ID of the device.
     * @param new_device_no the new device for the customers.
	 * @return the IDs of the devices.
	 */
    public String addDevice_No(String new_device_no){
        this.Device_No = Device_No+","+new_device_no;
        return this.Device_No;
    }



    /**
     * get the Inverterratio of the devices.
     * @return the value of the Inverterratio.
     */
    public String getInverterratio(){
        if(this.Input_Pv_Capacity!="None"){
        float value = Float.valueOf(this.Input_Pv_Capacity)/getPower();
        this.inverterratio = String.valueOf(value);
        return this.inverterratio;}
        return "None";
    }

    public void setZero(){
        this.inverterratio = "None";
    }


      /**
	 * get the power of devices in the scheme.
	 * @return the power of the device.
	 */
    public int getPower(){
        return Power;
    }

    /**
     * set the Pv_Capacity in the scheme.
     */
    public void setInput_Pv_Capacity(String key){
        this.Input_Pv_Capacity= key;
    }


    /**
	 * get the power of devices in the scheme.
     * @param new_pwoer the new power for the device.
	 * @return the total power of the device.
	 */
    public int addPower(int new_pwoer){
        this.Power = new_pwoer+Power;
        return this.Power;
    }


    public void index_self(){
        String strings[] = Scheme_No.split("-");
        int rank1 = Integer.valueOf(strings[1]);
        int rank2 = Integer.valueOf(strings[2]);
         this.Index = rank1*100+rank2;
    }

    public int get_index(){
        return this.Index;
    }


    public void get_lower_upper_value(){
        String values[] = this.Pv_Capacity.split("-");
         this.lower_value = Float.parseFloat(values[0]);
         this.upper_value = Float.parseFloat(values[1]);
    }


    public float get_lower_value(){
        return this.lower_value;
    }

    public float get_upper_value(){
        return this.upper_value;
    }

     /**the method printing the String of all relevent information about Devices.
    */
    @Override
    public String toString(){
        return "方案序号: "+Scheme_No+"\n安装容量范围: "+Pv_Capacity+"\n逆变器型号: "+Device_No+"\n逆变器总功率: "+Power+"\n容配比: "+getInverterratio()+"\n变压器型号："+Transformer_No;
    }

    /**the method printing itself.
     * @return information about itself.
     */
    public String self(){
        return Scheme_No+" "+Pv_Capacity+" "+Device_No+" "+Power+" "+getInverterratio()+" "+Transformer_No;
    }

    public String self_2(){
        return "方案序号: "+Scheme_No+"\n     安装容量范围: "+Pv_Capacity+"\n     逆变器型号: "+Device_No+"\n     逆变器总功率: "+Power+"\n     变压器型号："+Transformer_No;
    }


    @Override
    public int compareTo(Devices o) {
        return this.Index-o.Index;
    }
}
