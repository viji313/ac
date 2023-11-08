package com.onesoft.ac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onesoft.ac.entity.AcEntity;
import com.onesoft.ac.exception.NameNotFound;
import com.onesoft.ac.exception.PriceNotFound;
import com.onesoft.ac.service.AcService;

@RestController
@RequestMapping(value = "/hope")
public class AcController {
	@Autowired
	AcService as;

	@PostMapping(value = "/added")
	public String setValue(@RequestBody List<AcEntity> e) {
		return as.setValue(e);
	}

	@PutMapping(value = "/update")
	public String putData(@RequestBody AcEntity e) {
		return as.putData(e);
	}

	@GetMapping(value = "/fet/{a}")

	public AcEntity getData(@PathVariable int a) {
		return as.getData(a);
	}

	@DeleteMapping(value = "/del/{b}")
	public String delData(@PathVariable int b) {
		return as.delData(b);
	}

	@GetMapping(value = "/all")
	public List<AcEntity> fetchall() {
		return as.fetchall();
	}

	@GetMapping(value = "/max")
	public AcEntity getMax() {
		return as.getMax();
	}

	@GetMapping(value = "/minimum")
	public AcEntity getMin() {
		return as.getMin();
	}

	@PostMapping(value = "/store")
	public String adding(@RequestBody AcEntity e) {
		return as.adding(e);
	}

	@GetMapping(value = "/filter/{pr}")
	public List<AcEntity> filt(@PathVariable int pr) {
		return as.filt(pr);
	}

	@GetMapping(value = "/query/{pr}")
	public List<AcEntity> filters(@PathVariable String pr) {
		return as.filters(pr);
	}

	@GetMapping(value = "/some/{cl}")
	public List<AcEntity> getColor(@PathVariable String cl) {
		return as.getColor(cl);
	}

	@GetMapping(value = "/val/{f}")
	public List<AcEntity> rating(@PathVariable float f) {
		return as.rating(f);
	}

	@GetMapping(value = "/call/{pr}/{ft}")
	public List<AcEntity> multi(@PathVariable int pr, @PathVariable float ft) {
		return as.multi(pr, ft);
	}

	@GetMapping(value = "/maxi")
	public int maximum() {
		return as.maximum();
	}

	@GetMapping(value = "/whole")
	public AcEntity maxval() {
		return as.maxval();
	}

	@GetMapping(value = "/asce")
	public List<AcEntity> acsending() {
		return as.acsending();
	}

	@GetMapping(value = "/empty/{cl}")
	public List<AcEntity> getdetail(@PathVariable String cl) throws NameNotFound {
		return as.getdetail(cl);
	}

	@GetMapping(value = "excep/{price}")
	public List<AcEntity> exception(@PathVariable int price) throws PriceNotFound {
		return as.exception(price);
	}

	@PostMapping(value ="/chec")
	public String setInput(@RequestBody AcEntity e) throws PriceNotFound
	{
		return as.setInput(e);
	}
	
	

}
