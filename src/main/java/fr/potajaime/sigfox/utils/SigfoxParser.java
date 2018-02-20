package fr.potajaime.sigfox.utils;

import java.io.UnsupportedEncodingException;

import javax.xml.bind.DatatypeConverter;

import org.json.JSONException;
import org.json.JSONObject;

import fr.potajaime.core.entities.Indicateur;

public class SigfoxParser implements Parser {

	@Override
	public Indicateur parse(String data) throws JSONException, UnsupportedEncodingException {
		
		if( data.isEmpty() ) return null;
		
		JSONObject jsonObject = new JSONObject(data);
		Indicateur indicateur = new Indicateur();
		
		String[] stringData = this.hexToString(jsonObject.getString("data")).split(";");
		float temprature = Float.parseFloat(stringData[0]);
		float humidity = Float.parseFloat(stringData[1]);
		
		indicateur.setTemprature(temprature);
		indicateur.setHumidity(humidity);
		
		return indicateur;
	}
	
	
	
	public String hexToString(String hexString) throws UnsupportedEncodingException {
		byte[] bytes = DatatypeConverter.parseHexBinary(hexString);		
		return new String(bytes, "UTF-8");
	}

}
