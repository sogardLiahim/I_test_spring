package com.ab.places;



import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ab.db.DAOImpl;
import com.ab.db.FilmeDAO;
import com.ab.db.SaliDAO;
import com.ab.helpers.ProductGenerator;
import com.ab.model.ColectieProduse;
import com.ab.model.Film;
import com.ab.model.Produs;
import com.ab.model.ProdusClient;



// SA SE MUTE METODELE DIN ACEASTA cLASA IN ALTA CLASA, CLASA CU SCOP INSPIRATIONAL

@Controller
@RequestMapping("/api")
public class RestController {

	@Autowired
	DAOImpl daoImpl;  // DAOImpl daoImpl = new DAOImpl();
	
	
    @Autowired
    FilmeDAO filmeDAO;
    
    @Autowired
    SaliDAO saliDAO;
	
	
	@RequestMapping (value = "/getFilme", method = RequestMethod.GET)
	@ResponseBody
	ResponseEntity<List<Film>> colectieFilme() 
	{
		Date a2 = new Date();
		Timestamp date = new Timestamp(a2.getTime());
		return new ResponseEntity<List<Film>>(filmeDAO.getMovies(date), HttpStatus.OK);
	}
	
	@RequestMapping (value = "/getSaliCount", method = RequestMethod.GET)
	@ResponseBody
	ResponseEntity<Integer> numarSali() 
	{
		
		return new ResponseEntity<Integer>(saliDAO.getSaliCount(), HttpStatus.OK);
	}
	
	@RequestMapping (value = "/getSalaLocuri", method = RequestMethod.POST)
	@ResponseBody
	ResponseEntity <List<String>> locuriSala(@RequestParam("v1") String salaNo) 
	{	
		System.out.println(Integer.valueOf(salaNo.replaceAll("\\D+","")));
		return new ResponseEntity <List<String>>(saliDAO.getSaliNo(Integer.valueOf(salaNo.replaceAll("\\D+",""))), HttpStatus.OK);
	}
	
	@RequestMapping (value = "/getSaliId", method = RequestMethod.GET)
	@ResponseBody
	ResponseEntity <List<Integer>> saliID() 
	{	
		return new ResponseEntity <List<Integer>>(saliDAO.getSaliId(), HttpStatus.OK);
	}
	

	@RequestMapping(value="/test",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> test() {
		try {
			daoImpl.test();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<String>("test",HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/UserData")
	public  ResponseEntity<String> userData () 
	{	
		return new ResponseEntity<String>("Mihai", HttpStatus.OK);
	}
	
	@RequestMapping(value= "/produse")
	public ResponseEntity<ColectieProduse> getProduse()
	{
		ColectieProduse objColectie = new ColectieProduse(ProductGenerator.populateList());
		return new ResponseEntity<ColectieProduse>(objColectie, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/produseClient", method=RequestMethod.GET)
	public ResponseEntity<List<ProdusClient>> dateTrimiseClient()
	{
		//if (Produs.produseClient.isEmpty()) {return null;}
		Produs.populateList();
		Produs.populateList();
		Produs.populateList();
		Produs.populateList();

		for (ProdusClient p : Produs.produseClient) {
			System.out.println(p.getNume());
		}
		return new ResponseEntity<List<ProdusClient>>(Produs.produseClient,HttpStatus.OK);
	}
	

	@RequestMapping(value = "/UploadMovie",method=RequestMethod.POST)
	public ResponseEntity<String> dateTrimie(@RequestParam("v1") String numeFilm,
											 @RequestParam("v2") String descriere,
											 @RequestParam("v3") String pret,
											 @RequestParam("v4") String date,
											 @RequestParam("v5") String gen,
											 @RequestParam("v6") String idSala
											)
	{
		//Film x = new Film(numeFilm,pret,date,descriere);
		System.out.println(numeFilm);
		System.out.println(pret);
		System.out.println(descriere);
		System.out.println(date);
		System.out.println(gen);
		System.out.println(idSala);
		
		Date a = new Date(date);
		Timestamp dateT = new Timestamp(a.getTime());
		Film film =  new Film(numeFilm, descriere, idSala, pret, gen, dateT);
		filmeDAO.insertMovie(film);
		return new ResponseEntity<String>("OK",HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/trimiteProduseJSON",method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> primesteDateJSON(@RequestBody ProdusClient p)								
	{
		System.out.println(p.getNume());
		System.out.println(p.getCantitate());
		return new ResponseEntity<String>("sUCCESS", HttpStatus.OK);
		
		
	}
	
	
	
	

	
	
	
}
