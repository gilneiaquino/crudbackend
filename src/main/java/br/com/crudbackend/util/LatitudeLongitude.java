package br.com.crudbackend.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LatitudeLongitude {

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	public static void main(String[] args) throws IOException, JSONException {
		LatitudeLongitude l = new LatitudeLongitude();
		var latitude = l.recuperarLatitude();
		var longitude = l.recuperarLongitude();
		
		System.out.println("Latitude: " + latitude);
		System.out.println("Longitude: " + longitude);
	}

	private JSONObject recuperarLocalizacao() throws JSONException, IOException {
		JSONObject jsonServico = recuperarServicoGoogle();
		JSONArray arrayResultado = (JSONArray) jsonServico.get("results");
		JSONObject resultado = (JSONObject) arrayResultado.get(0);
		JSONObject coordendas = (JSONObject) resultado.get("geometry");
		JSONObject localizacao = (JSONObject) coordendas.get("location");
		return localizacao;

	}

	private JSONObject recuperarServicoGoogle() throws JSONException, IOException {
		JSONObject json = readJsonFromUrl(
				"https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=AIzaSyCj0cY2yEvVfYhAaTz3-P2MW-YRKmhz5Uw");
		return json;
	}

	public BigDecimal recuperarLatitude() throws JSONException, IOException {
		JSONObject localizacao = recuperarLocalizacao();
		return (BigDecimal) localizacao.get("lat");
	}

	public BigDecimal recuperarLongitude() throws JSONException, IOException {
		JSONObject localizacao = recuperarLocalizacao();
		return (BigDecimal) localizacao.get("lng");
	}

}
