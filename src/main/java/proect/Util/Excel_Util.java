package proect.Util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

import proect.PV.Devices;
import proect.PV.PV_Modules;

/**
 *<h1>About Util</h1>
 *<p>this class represnts utilizing the data from Excel.</p>
 *@author: Minglang.Tuo 
 *@version V1.0
 */


public class Excel_Util {
     /**
    *represent total columns of scheme_No in excel.
    */
    public static List<String> Scheme_No_Column = new ArrayList<>();

     /**
    *represent total columns of Pv_Capacity in excel.
    */
    public static List<String> Pv_Capacity_Column = new ArrayList<>();

     /**
    *represent total columns of Device_No in excel.
    */
    public static List<String> Device_No_Column = new ArrayList<>();

     /**
    *represent total columns of Power in excel.
    */
    public static List<String> Power_Column = new ArrayList<>();

    public static List<String> Transformer_Column = new ArrayList<>();


     /**
	 * the method is handling PV_Dataset.
	 * @param filePath the file path in computer.
     * @return return the new ArrayList of devices
	 */
    public static ArrayList<Devices> dealDataset(String filePath){
        readDataSet(filePath);
        ArrayList<Devices> devices = new ArrayList();
        int length = Scheme_No_Column.size();
        


        for(int i = 0;i<length;++i){
            String Scheme_No = Scheme_No_Column.get(i);

            String Pv_Capacity = Pv_Capacity_Column.get(i);

            String Device_No = Device_No_Column.get(i);

            String Power = Power_Column.get(i);

            String Transformer_No = Transformer_Column.get(i);

            devices.add(new Devices(Scheme_No,Pv_Capacity,Device_No,Integer.parseInt(Power),Transformer_No));
        }

        return devices;

    }

 /**
	 * the method is reading PV_Dataset.
	 * @param filePath the file path in computer.
	 */
    @SuppressWarnings("resource")
    public static void readDataSet(String filePath){
        InputStream in;
        DataFormatter formatter = new DataFormatter();
        try{
            Excel_Util eu = new Excel_Util();
            ClassLoader cl = eu.getClass().getClassLoader();
             in = cl.getResourceAsStream("D1.xlsx");

            //input = new FileInputStream(filePath);
            XSSFWorkbook book = new XSSFWorkbook(in);
            XSSFSheet sheet = book.getSheetAt(0);
            XSSFRow row;
            for(int i=sheet.getFirstRowNum()+1;i<sheet.getPhysicalNumberOfRows();++i){
                row = sheet.getRow(i);
                Scheme_No_Column.add(row.getCell(0).getStringCellValue());
                Pv_Capacity_Column.add(row.getCell(1).getStringCellValue());
                Device_No_Column.add(row.getCell(2).getStringCellValue());
                Power_Column.add(formatter.formatCellValue(sheet.getRow(i).getCell(3)));
                Transformer_Column.add(row.getCell(4).getStringCellValue());

            }

            }catch(FileNotFoundException IOE){
                System.out.println("文件不在正确的位置（the file is not found in the location）");

            }catch(IOException IOE){
                System.out.println("Excel的文件内容不正确（the content of the excel is not correct）");
            }

        }
        

    }



    

