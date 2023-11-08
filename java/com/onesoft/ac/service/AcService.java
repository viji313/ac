package com.onesoft.ac.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.onesoft.ac.dao.AcDao;
import com.onesoft.ac.entity.AcEntity;
import com.onesoft.ac.exception.NameNotFound;
import com.onesoft.ac.exception.PriceNotFound;


@Service
public class AcService {
	@Autowired
		AcDao ad;

	public String setValue(List <AcEntity> e) {
	
		return ad.setValue(e);
	}
	
	public String putData( AcEntity e) {
		return ad.putData(e);
	}
	public AcEntity getData(int a)
	{
		return ad.getData(a);
	}

	public String delData(int b)
	{
		return ad.delData(b);
	}
	
	public List<AcEntity> fetchall() {
		return ad.fetchall();
	}
	public AcEntity getMax() {
		List<AcEntity> i = ad.fetchall();
		AcEntity a= i.stream().max(Comparator.comparing(AcEntity::getPrice)).get();
		return a;
	}
	
	public AcEntity getMin() {
		List<AcEntity> l = ad.fetchall();
		AcEntity b = l.stream().min(Comparator.comparing(AcEntity::getPrice)).get();
		return b;
	}
	public String adding(AcEntity e)
	{
		return ad.adding(e);
	}
	public List<AcEntity> filt(int pr)
	{
		List<AcEntity> i = ad.fetchall();
	List <AcEntity> m = i.stream().filter(x->x.getPrice()>pr).collect(Collectors.toList());
		return m;
	}
	public List<AcEntity>filters( String pr)
	{
		return ad.filters(pr);
	}
	public List<AcEntity>getColor(String cl)
	{
		return ad.getColor(cl);
	}
	public List<AcEntity>rating( float f)
	{
		return ad.rating(f);
	}
	public List<AcEntity>multi(@PathVariable int pr,@PathVariable float ft)
	{
		return ad.multi(pr,ft);
	}
	public int maximum() {
		return ad.maximum();
	}
	public AcEntity maxval() {
		return ad.maxval();
	}
	
	public List<AcEntity>acsending() {
		return ad.acsending();
	}
	public List<AcEntity>getdetail(String cl) throws NameNotFound { 
	
		List<AcEntity> lv= ad.getdetail(cl);
		if(lv.isEmpty())
		{
			throw new NameNotFound("invalid");
		}
		else
		{
			return lv;
		}
	}
		public List<AcEntity> exception(int price) throws PriceNotFound {
			List<AcEntity> lae = ad.exception(price);
			if(lae.isEmpty())
			{
				throw new PriceNotFound("Invalid data");
			}
			else 
			{
				return lae;
			}
	}
		public String setInput(AcEntity e) throws PriceNotFound
		{
			if(e.getPrice()>20000)
			{
				return ad.setInput(e);
			}
			else
			{
				throw new PriceNotFound("Invalid price");
			}
		}

	
			
				}
		
	
	



	


	

