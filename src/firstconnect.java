import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;

public class firstconnect {
    public static void main(String[] args) throws IOException {
        ConnectFarm koneksisaya = new ConnectFarm();
        URL myAddress = koneksisaya.buildURL("https://farmasi.mimoapps.xyz/mimoqss2auyqD1EAlkgZCOhiffSsFl6QqAEIGtM" );
        String respone = koneksisaya.getResponseFromHttpURL(myAddress);
        System.out.println(respone);

        assert respone != null;
        JSONArray responseJSON = new JSONArray(respone);
        ArrayList<modelObat> responseModel =
                new ArrayList<>();
        for (int i=0;i< responseJSON.length();i++) {
            modelObat resModel = new modelObat();
            JSONObject myJSONObject =
                    responseJSON.getJSONObject(i);
            resModel.setI_barcode(myJSONObject.getString("i_barcode"));
            resModel.setI_sell(myJSONObject.getString("i_sell"));
            resModel.setI_qty(myJSONObject.getString("i_qty"));
            responseModel.add(resModel);
        }

        System.out.println("Response are");
        for (int index=0; index<responseModel.size();index++){
            System.out.println("NAMA BARANG : " +
                    responseModel.get(index).getI_barcode());
        }
    }

}
