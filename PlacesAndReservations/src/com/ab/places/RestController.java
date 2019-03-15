package com.ab.places;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ab.helpers.ProductGenerator;
import com.ab.model.ColectieProduse;
import com.ab.model.Produs;
import com.ab.model.ProdusClient;



@Controller
@RequestMapping("/api")
public class RestController {

	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> test(){
		System.out.println("intra!!");
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
	
	@RequestMapping(value = "/produseClient")
	public ResponseEntity<List<ProdusClient>> dateTrimiseClient()
	{
		return new ResponseEntiy<List<ProdusClient>> (Produs.produseClient,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/trimiteProduse",method=RequestMethod.POST)
	public ResponseEntity<String> dateTrimie(@RequestParam("v1") String nume,
											 @RequestParam("v2") String Cantitate,
											 @RequestParam("v3") String Pret,
											 @RequestParam("v4") String ID,
											 @RequestParam("v5") String Serie,
											 @RequestParam("v6") String Tara
											)
	{
		Produs.produseClient.add(new ProdusClient(nume,Cantitate,Pret,ID,Serie,Tara));
		System.out.println(nume);
		System.out.println(Pret);
		System.out.println(Cantitate);
		return null;
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
